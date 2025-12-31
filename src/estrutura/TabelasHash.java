package estrutura;

import modelo.Encomenda;
import java.util.HashMap;

public class TabelasHash {
    // HashMap para armazenar as encomendas com chave = ID
    private HashMap<Integer, Encomenda> tabela;

    // Construtor
    public TabelasHash() {
        tabela = new HashMap<>();
    }

    // Método para cadastrar uma encomenda
    public void cadastrarEncomenda(Encomenda e) {
        tabela.put(e.getId(), e);
        System.out.println("Encomenda cadastrada com sucesso!");
    }

    // Método para remover uma encomenda pelo ID
    public void removerEncomenda(int id) {
        if(tabela.containsKey(id)) {
            tabela.remove(id);
            System.out.println("Encomenda removida com sucesso!");
        } else {
            System.out.println("Encomenda não encontrada!");
        }
    }

    // Método para listar todas as encomendas
    public void listarEncomendas() {
        if(tabela.isEmpty()) {
            System.out.println("Nenhuma encomenda cadastrada.");
        } else {
            for(Encomenda e : tabela.values()) {
                e.mostrarEncomenda();
            }
        }
    }

    // Método para buscar uma encomenda pelo ID (opcional)
    public Encomenda buscarEncomenda(int id) {
        return tabela.get(id);
    }
}

