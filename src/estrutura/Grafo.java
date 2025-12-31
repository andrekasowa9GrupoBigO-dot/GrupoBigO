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

    // Criar arestas entre províncias (ligação fictícia para exemplo)
    private void criarArestas() {
        // Luanda ↔ Bengo
        adicionarAresta("Luanda", "Bengo", 50);
        adicionarAresta("Bengo", "Luanda", 50);
        adicionarAresta("Luanda", "Bengo", 50);
        adicionarAresta("Bengo", "Uíge", 50);

        // Luanda ↔ Cuanza Norte
        adicionarAresta("Luanda", "Cuanza Norte", 120);
        adicionarAresta("Cuanza Norte", "Luanda", 120);

        // Cuanza Norte ↔ Malanje
        adicionarAresta("Cuanza Norte", "Malanje", 200);
        adicionarAresta("Malanje", "Cuanza Norte", 200);

        // Cuanza Sul ↔ Benguela
        adicionarAresta("Cuanza Sul", "Benguela", 150);
        adicionarAresta("Benguela", "Cuanza Sul", 150);

        // Benguela ↔ Huíla
        adicionarAresta("Benguela", "Huíla", 130);
        adicionarAresta("Huíla", "Benguela", 130);

        // Huíla ↔ Namibe
        adicionarAresta("Huíla", "Namibe", 160);
        adicionarAresta("Namibe", "Huíla", 160);

        // Malanje ↔ Lunda Norte
        adicionarAresta("Malanje", "Lunda Norte", 400);
        adicionarAresta("Lunda Norte", "Malanje", 400);

        // Lunda Norte ↔ Lunda Sul
        adicionarAresta("Lunda Norte", "Lunda Sul", 200);
        adicionarAresta("Lunda Sul", "Lunda Norte", 200);

        // Lunda Sul ↔ Moxico
        adicionarAresta("Lunda Sul", "Moxico", 300);
        adicionarAresta("Moxico", "Lunda Sul", 300);

        // Moxico ↔ Cuando Cubango
        adicionarAresta("Moxico", "Cuando Cubango", 250);
        adicionarAresta("Cuando Cubango", "Moxico", 250);

        // Cabinda ↔ Zaire
        adicionarAresta("Cabinda", "Zaire", 300);
        adicionarAresta("Zaire", "Cabinda", 150);
        adicionarAresta("Huíla", "Huambo", 50);
        adicionarAresta("Huambo", "Bié", 50);
        adicionarAresta("Bié", "Cuanza Norte", 50);


        // Uíge ↔ Zaire
        adicionarAresta("Zaire", "Uíge", 180);
        adicionarAresta("Zaire", "Bengo", 50);
        adicionarAresta("Bengo", "Cuanza Norte", 50);
        adicionarAresta("Cuanza Norte", "Cuanza Sul", 50);
        adicionarAresta("Cuanza Sul", "Benguela", 50);

        // Huambo ↔ Bié
        adicionarAresta("Huambo", "Bié", 100);
        adicionarAresta("Bié", "Huambo", 100);
        adicionarAresta("Bié", "Malanje", 50);
        adicionarAresta("Bié", "Moxico", 50);
        // Bié ↔ Cuanza Sul
        adicionarAresta("Bié", "Cuanza Sul", 120);
        adicionarAresta("Cuanza Sul", "Bié", 120);

        // Cunene ↔ Namibe
        adicionarAresta("Cunene", "Namibe", 140);
        adicionarAresta("Namibe", "Cunene", 140);
    }

    // Método para adicionar aresta
    private void adicionarAresta(String origem, String destino, double peso) {
        Vertice vOrigem = vertices.get(origem);
        Vertice vDestino = vertices.get(destino);
        if(vOrigem != null && vDestino != null) {
            vOrigem.adicionarAresta(new Aresta(vDestino, peso));
        }
    }

    // Retornar todos os vértices
    public HashMap<String, Vertice> getVertices() {
        return vertices;
    }

    // Retornar um vértice pelo nome
    public Vertice getVertice(String nome) {
        return vertices.get(nome);
    }
}

