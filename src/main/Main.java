package main;

import modelo.Encomenda;
import modelo.Vertice;
import estrutura.TabelasHash;
import estrutura.Grafo;
import util.Dijkstra;
import util.VisualGrafo;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TabelasHash tabela = new TabelasHash();
        Grafo grafo = new Grafo();

        int opcao = 0;
        int contadorId = 1;

        while (opcao != 5) {
            System.out.println("===== SISTEMA DE ENCOMENDAS =====");
            System.out.println("1. Cadastrar Encomenda");
            System.out.println("2. Remover Encomenda");
            System.out.println("3. Listar Encomendas");
            System.out.println("4. Rota Nacional");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Produto: ");
                    String produto = sc.nextLine();
                    System.out.print("Peso (kg): ");
                    double peso = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Origem: ");
                    String origemNome = sc.nextLine();
                    System.out.print("Destino: ");
                    String destinoNome = sc.nextLine();

                    Vertice origem = grafo.getVertice(origemNome);
                    Vertice destino = grafo.getVertice(destinoNome);

                    if (origem == null || destino == null) {
                        System.out.println("Origem ou destino inválidos!");
                        break;
                    }

                    Encomenda encomenda = new Encomenda(contadorId, origemNome, destinoNome, produto, peso);
                    tabela.cadastrarEncomenda(encomenda);
                    contadorId++;


                    List<Vertice> rota = Dijkstra.calcularRota(origem, destino);

                    double distanciaTotal = Dijkstra.calcularDistanciaTotal(rota);
                    System.out.println("Distância total da rota: " + distanciaTotal + " km");

                    Dijkstra.mostrarRota(rota);
                    VisualGrafo.mostrarGrafo(grafo.getVertices(), rota);
                    break;

                case 2:
                    System.out.print("Digite o ID da encomenda para remover: ");
                    int idRemover = sc.nextInt();
                    tabela.removerEncomenda(idRemover);
                    break;

                case 3:
                    tabela.listarEncomendas();
                    break;

                case 4:
                    System.out.println("===== ROTAS NACIONAIS =====");

                        VisualGrafo.mostrarGrafo(grafo.getVertices(), null);

                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}

