package modelo;

import java.util.ArrayList;

public class Vertice {
    private String nome;
    private String regiao; // Norte, Sul, Centro, Leste, Sul
    private ArrayList<Aresta> arestas;

    // Coordenadas para visualização gráfica
    private double x;
    private double y;

    public Vertice(String nome, String regiao) {
        this.nome = nome;
        this.regiao = regiao;
        this.arestas = new ArrayList<>();
    }

    // --- getters existentes ---
    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    // --- métodos novos (VISUAL) ---
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setPosicao(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Adiciona uma aresta a este vértice
    public void adicionarAresta(Aresta a) {
        arestas.add(a);
    }
}
