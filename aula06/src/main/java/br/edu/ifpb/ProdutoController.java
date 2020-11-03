package br.edu.ifpb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/produtoById")
public class ProdutoController extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Produtos produtos = new Produtos();
            Produto produto = produtos.getProduto(id);

            request.setAttribute("styles", produto);
            RequestDispatcher view = request.getRequestDispatcher("detalhe/produto");
            view.forward(request, response);
    }

}