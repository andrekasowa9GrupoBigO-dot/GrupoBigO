package util;

import modelo.Vertice;
import modelo.Aresta;

import java.util.*;

public class Dijkstra {

    // Método para calcular a rota mais curta entre origem e destino
    public static List<Vertice> calcularRota(Vertice origem, Vertice destino) {

        // Mapa que guarda a menor distância de cada vértice desde a origem
        Map<Vertice, Double> distancias = new HashMap<>();

        // Mapa que guarda o vértice anterior para reconstruir a rota
        Map<Vertice, Vertice> anterior = new HashMap<>();

        // Conjunto de vértices ainda não visitados
        Set<Vertice> naoVisitados = new HashSet<>();

        // Inicializa distâncias
        distancias.put(origem, 0.0);
        naoVisitados.add(origem);

        // Inicializa distâncias infinitas para os demais vértices
        Queue<Vertice> fila = new LinkedList<>();
        fila.add(origem);

        while (!fila.isEmpty()) {
            Vertice atual = fila.poll();

            for (Aresta aresta : atual.getArestas()) {
                Vertice vizinho = aresta.getDestino();
                double novaDistancia = distancias.getOrDefault(atual, Double.MAX_VALUE) + aresta.getPeso();

                if (novaDistancia < distancias.getOrDefault(vizinho, Double.MAX_VALUE)) {
                    distancias.put(vizinho, novaDistancia);
                    anterior.put(vizinho, atual);
                    fila.add(vizinho);
                }
            }
        }

        // Reconstruir a rota do destino até a origem
        List<Vertice> rota = new ArrayList<>();
        Vertice passo = destino;
        while (passo != null) {
            rota.add(0, passo); // adiciona no início da lista
            passo = anterior.get(passo);
        }

        // Se a primeira posição não for a origem, não existe rota
        if (rota.isEmpty() || rota.get(0) != origem) {
            System.out.println("Não há rota disponível entre " + origem.getNome() + " e " + destino.getNome());
            return new ArrayList<>();
        }

        return rota;
    }

    // Método para mostrar a rota no console
    public static void mostrarRota(List<Vertice> rota) {
        if (rota.isEmpty()) return;

        System.out.print("Rota mais curta: ");
        for (int i = 0; i < rota.size(); i++) {
            System.out.print(rota.get(i).getNome());
            if (i < rota.size() - 1) System.out.print(" → ");
        }
        System.out.println();
    }
}

