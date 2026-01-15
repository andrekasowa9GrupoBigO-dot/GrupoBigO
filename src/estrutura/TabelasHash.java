package estrutura;

import modelo.Encomenda;
import java.util.HashMap;

public class TabelasHash {

    private HashMap<Integer, Encomenda> tabela;


    public TabelasHash() {
        tabela = new HashMap<>();
    }


    public void cadastrarEncomenda(Encomenda e) {
        tabela.put(e.getId(), e);
        System.out.println("Encomenda cadastrada com sucesso!");
    }


    public void removerEncomenda(int id) {
        if(tabela.containsKey(id)) {
            tabela.remove(id);
            System.out.println("Encomenda removida com sucesso!");
        } else {
            System.out.println("Encomenda não encontrada!");
        }
    }


    public void listarEncomendas() {
        if(tabela.isEmpty()) {
            System.out.println("Nenhuma encomenda cadastrada.");
        } else {
            for(Encomenda e : tabela.values()) {
                e.mostrarEncomenda();
            }
        }
    }


    public Encomenda buscarEncomenda(int id) {
        return tabela.get(id);
    }
}

