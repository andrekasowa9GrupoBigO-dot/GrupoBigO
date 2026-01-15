package modelo;

public class Encomenda {


    private int id;
    private String origem;
    private String destino;
    private String produto;
    private double peso;


    public Encomenda(int id, String origem, String destino, String produto, double peso) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.produto = produto;
        this.peso = peso;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public String getProduto() {
        return produto;
    }

    public double getPeso() {
        return peso;
    }


    public void mostrarEncomenda() {
        System.out.println("ID: " + id);
        System.out.println("Origem: " + origem);
        System.out.println("Destino: " + destino);
        System.out.println("Produto: " + produto);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("--------------------------");
    }
}

