package util;

import modelo.Vertice;
import modelo.Aresta;

import java.util.*;

public class Dijkstra {


    public static List<Vertice> calcularRota(Vertice origem, Vertice destino) {


        Map<Vertice, Double> distancias = new HashMap<>();


        Map<Vertice, Vertice> anterior = new HashMap<>();


        Set<Vertice> visitados = new HashSet<>();


        PriorityQueue<Vertice> fila = new PriorityQueue<>(
                Comparator.comparingDouble(v -> distancias.getOrDefault(v, Double.MAX_VALUE))
        );

        // Inicialização
        distancias.put(origem, 0.0);
        fila.add(origem);

        while (!fila.isEmpty()) {
            Vertice atual = fila.poll();


            if (visitados.contains(atual)) continue;
            visitados.add(atual);


            if (atual.equals(destino)) break;

            for (Aresta aresta : atual.getArestas()) {
                Vertice vizinho = aresta.getDestino();

                double novaDistancia =
                        distancias.get(atual) + aresta.getPeso();

                if (novaDistancia < distancias.getOrDefault(vizinho, Double.MAX_VALUE)) {
                    distancias.put(vizinho, novaDistancia);
                    anterior.put(vizinho, atual);
                    fila.add(vizinho);
                }
            }
        }


        List<Vertice> rota = new ArrayList<>();
        Vertice passo = destino;

        if (!anterior.containsKey(destino) && !origem.equals(destino)) {
            System.out.println("Não há rota disponível entre "
                    + origem.getNome() + " e " + destino.getNome());
            return rota;
        }

        while (passo != null) {
            rota.add(0, passo);
            passo = anterior.get(passo);
        }

        return rota;
    }


    public static void mostrarRota(List<Vertice> rota) {
        if (rota.isEmpty()) return;

        System.out.print("Rota mais curta: ");
        for (int i = 0; i < rota.size(); i++) {
            System.out.print(rota.get(i).getNome());
            if (i < rota.size() - 1) System.out.print(" → ");
        }
        System.out.println();
    }


    public static double calcularDistanciaTotal(List<Vertice> rota) {
        double total = 0;

        for (int i = 0; i < rota.size() - 1; i++) {
            Vertice atual = rota.get(i);
            Vertice proximo = rota.get(i + 1);

            for (Aresta a : atual.getArestas()) {
                if (a.getDestino().equals(proximo)) {
                    total += a.getPeso();
                    break;
                }
            }
        }
        return total;
    }


}

