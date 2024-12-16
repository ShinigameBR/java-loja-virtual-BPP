package br.ufrn.imd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LojaVirtualTest {

    @Test
    public void testAdicionarEListarProdutos() {
        Catalogo catalogo = new Catalogo();
        Produto produto = new Produto(1, "Produto 1", 50.0f);
        catalogo.adicionarProduto(produto);

        assertEquals(1, catalogo.listarProdutos().size());
        assertEquals(produto, catalogo.listarProdutos().get(0));
    }

    @Test
    public void testBuscarProdutoPorId() {
        Catalogo catalogo = new Catalogo();
        Produto produto = new Produto(1, "Produto 1", 50.0f);
        catalogo.adicionarProduto(produto);

        assertNotNull(catalogo.buscarProdutoPorId(1));
        assertNull(catalogo.buscarProdutoPorId(2));
    }

    @Test
    public void testCalcularTotalPedidoComDesconto() {
        Pedido pedido = new Pedido("Cliente 1");
        pedido.adicionarProduto(new Produto(1, "Produto 1", 60.0f));
        pedido.adicionarProduto(new Produto(2, "Produto 2", 50.0f));

        assertEquals(99.0f, pedido.calcularTotal(), 0.01);
    }

    @Test
    public void testCalcularTotalPedidoSemDesconto() {
        Pedido pedido = new Pedido("Cliente 2");
        pedido.adicionarProduto(new Produto(1, "Produto 1", 40.0f));
        pedido.adicionarProduto(new Produto(2, "Produto 2", 30.0f));

        assertEquals(70.0f, pedido.calcularTotal(), 0.01);
    }
}
