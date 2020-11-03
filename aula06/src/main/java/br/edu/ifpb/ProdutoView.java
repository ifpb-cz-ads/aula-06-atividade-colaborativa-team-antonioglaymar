package br.edu.ifpb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detalhe/produto")
public class ProdutoView extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request,  HttpServletResponse response) 
        throws IOException{
            
            PrintWriter out = response.getWriter();
            Produto produto = (Produto) request.getAttribute("styles");
            out.println("<html>");
            out.println("<body>");
            if (produto != null){
                out.println("<p>Id: "+produto.getId()+"</p>");
                out.println("<p>Nome: "+produto.getNome()+"</p>");
                out.println("<p>Preco: "+produto.getPreco()+"</p>");
            } else {
                out.println("Nao existe produto com o id solicitado");
            }
            out.println("</body>");
            out.println("</html>");

    }
}