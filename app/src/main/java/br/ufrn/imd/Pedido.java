package br.ufrn.imd;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Pedido {
    private static final Logger logger = Logger.getLogger(Catalogo.class.getName());
    private List<Produto> produtos = new ArrayList<>();
    private String cliente;

    public Pedido(String cliente) {
        this.cliente = cliente;
        logger.info("Pedido criado para o cliente: " + cliente);
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public float calcularTotal() {
        float total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        if (total > 100) {
            total *= 0.9; // Aplica 10% de desconto
            logger.info("Desconto de 10% aplicado ao pedido do cliente: " + cliente);
        }
        return total;
    }
}
