package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

//Essa classe pertence ao pacote Web
//URL - foi criada uma URL  "/novaEmpresa"
@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa extends HttpServlet {

	// Este metódo o próprio eclipse gera, "doget + ctrl + espaço"
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp); Não será usado o super.

		// Aqui vai o processo de criação de uma nova empresa:
		// Como o nome (Apartir da informação de parametro):
		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);

		// A informação será devolvida para o cliente:
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Empresa " + empresa.getNome() + " adicionada!</body></html>");
	}
}
