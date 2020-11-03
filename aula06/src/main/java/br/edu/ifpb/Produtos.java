package br.edu.ifpb;

import java.util.ArrayList;
import java.util.List;

public class Produtos {
    List<Produto> produtos;

    public Produtos(){
        produtos = new ArrayList<Produto>();
        produtos.add(new Produto(1, "Tijolo", 0.50));
        produtos.add(new Produto(2, "Telha", 0.75));
        produtos.add(new Produto(3, "Cimento", 50.99));
        produtos.add(new Produto(4, "Semente de Abóbora", 12));
        produtos.add(new Produto(5, "Caderno", 1.0));
    }


    public Produto getProduto(Integer id) {
        for(Produto produto : produtos){
            if (produto.getId() == id){
                return produto;
            }
        }
        return null;
    }
}