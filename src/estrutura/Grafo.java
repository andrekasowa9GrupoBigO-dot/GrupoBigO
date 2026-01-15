package estrutura;

import modelo.Vertice;
import modelo.Aresta;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo {
    private HashMap<String, Vertice> vertices;

    public Grafo() {
        vertices = new HashMap<>();
        criarVertices();
        criarArestas();
    }

    // Criar todos os vértices (províncias)
    private void criarVertices() {
        vertices.put("Luanda", new Vertice("Luanda", "Oeste"));
        vertices.put("Bengo", new Vertice("Bengo", "Oeste"));
        vertices.put("Cuanza Norte", new Vertice("Cuanza Norte", "Oeste"));
        vertices.put("Cuanza Sul", new Vertice("Cuanza Sul", "Oeste"));
        vertices.put("Benguela", new Vertice("Benguela", "Sul"));
        vertices.put("Huíla", new Vertice("Huíla", "Sul"));
        vertices.put("Namibe", new Vertice("Namibe", "Sul"));
        vertices.put("Bié", new Vertice("Bié", "Centro"));
        vertices.put("Malanje", new Vertice("Malanje", "Norte"));
        vertices.put("Lunda Norte", new Vertice("Lunda Norte", "Norte"));
        vertices.put("Lunda Sul", new Vertice("Lunda Sul", "Norte"));
        vertices.put("Moxico", new Vertice("Moxico", "Leste"));
        vertices.put("Cuando Cubango", new Vertice("Cuando Cubango", "Sul-Leste"));
        vertices.put("Cabinda", new Vertice("Cabinda", "Norte"));
        vertices.put("Uíge", new Vertice("Uíge", "Norte"));
        vertices.put("Zaire", new Vertice("Zaire", "Norte"));
        vertices.put("Cunene", new Vertice("Cunene", "Sul"));
        vertices.put("Huambo", new Vertice("Huambo", "Centro"));
        vertices.put("Bié", new Vertice("Bié", "Centro"));
        vertices.put("Cunene", new Vertice("Cunene", "Sul"));

    }


    private void criarArestas() {

        adicionarAresta("Luanda", "Bengo", 50);
        adicionarAresta("Bengo", "Luanda", 50);


        adicionarAresta("Luanda", "Cuanza Norte", 120);
        adicionarAresta("Cuanza Norte", "Luanda", 120);


        adicionarAresta("Cuanza Norte", "Malanje", 200);
        adicionarAresta("Malanje", "Cuanza Norte", 200);

        adicionarAresta("Benguela", "Huambo", 120);
        adicionarAresta("Huambo", "Benguela", 120);


        adicionarAresta("Cuanza Sul", "Benguela", 150);
        adicionarAresta("Benguela", "Cuanza Sul", 150);


        adicionarAresta("Benguela", "Huíla", 130);
        adicionarAresta("Huíla", "Benguela", 130);


        adicionarAresta("Huíla", "Namibe", 160);
        adicionarAresta("Namibe", "Huíla", 160);

        adicionarAresta("Lunda Sul", "Malanje", 557);
        adicionarAresta("Malanje", "Lunda Sul", 557);

        adicionarAresta("Lunda Sul", "Bié", 800);
        adicionarAresta("Bié", "Lunda Sul", 800);

        adicionarAresta("Malanje", "Lunda Norte", 400);
        adicionarAresta("Lunda Norte", "Malanje", 400);


        adicionarAresta("Lunda Norte", "Lunda Sul", 200);
        adicionarAresta("Lunda Sul", "Lunda Norte", 200);

        adicionarAresta("Uíge", "Cuanza Norte", 160);
        adicionarAresta("Cuanza Norte", "Uíge", 160);

        adicionarAresta("Lunda Sul", "Moxico", 300);
        adicionarAresta("Moxico", "Lunda Sul", 300);



        adicionarAresta("Moxico", "Cuando Cubango", 250);
        adicionarAresta("Cuando Cubango", "Moxico", 250);


        adicionarAresta("Cabinda", "Zaire", 300);
        adicionarAresta("Zaire", "Cabinda", 150);

        adicionarAresta("Huíla", "Huambo", 50);
        adicionarAresta("Huambo", "Bié", 50);

        adicionarAresta("Zaire", "Uíge", 180);
        adicionarAresta("Zaire", "Bengo", 180);

        adicionarAresta("Bengo", "Cuanza Norte", 50);
        adicionarAresta("Cuanza Norte", "Cuanza Sul", 50);

        adicionarAresta("Huambo", "Bié", 100);
        adicionarAresta("Bié", "Huambo", 100);

        adicionarAresta("Bié", "Malanje", 50);
        adicionarAresta("Bié", "Moxico", 50);

        adicionarAresta("Bié", "Cuanza Sul", 120);
        adicionarAresta("Cuanza Sul", "Bié", 120);

        adicionarAresta("Cunene", "Namibe", 140);
        adicionarAresta("Namibe", "Cunene", 140);

    }


    private void adicionarAresta(String origem, String destino, double peso) {
        Vertice vOrigem = vertices.get(origem);
        Vertice vDestino = vertices.get(destino);
        if(vOrigem != null && vDestino != null) {
            vOrigem.adicionarAresta(new Aresta(vDestino, peso));
        }
    }


    public HashMap<String, Vertice> getVertices() {
        return vertices;
    }


    public Vertice getVertice(String nome) {
        return vertices.get(nome);
    }
}

