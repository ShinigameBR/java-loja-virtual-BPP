package br.ufrn.imd;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Catalogo {
    private static final Logger logger = Logger.getLogger(Catalogo.class.getName());
    private List<Produto> produtosCatalogados = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtosCatalogados.add(produto);
        logger.info("Produto adicionado ao catalogo: " + produto.getNome());
    }

    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtosCatalogados);
    }

    public Produto buscarProdutoPorId(int id) {
        return produtosCatalogados.stream()
                .filter(produto -> produto.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
