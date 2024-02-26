package br.edu.senaisp.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.senaisp.dao.AlunoDAO;
import br.edu.senaisp.model.Aluno;
import br.edu.senaisp.util.Log;
import br.edu.senaisp.view.FormDetAluno;
import br.edu.senaisp.view.FormPrincipal;

public class AlunoController {

	public static void main(String[] args) {

		FormPrincipal frmPri = new FormPrincipal();
		frmPri.show();

		// Gera��o de Alunos
		Aluno a1 = new Aluno(123L, "Yuri", "000.000.000-00");
		Aluno a2 = new Aluno(124L, "Napole�o", "111.111.111-11");
		Aluno a3 = new Aluno(125L, "Fabricio", "111.111.111-11");
		Aluno a4 = new Aluno(126L, "Julia", "111.111.111-11");
		Aluno a5 = new Aluno(127L, "Emily", "111.111.111-11");
		Aluno a6 = new Aluno(128L, "Elysson", "111.111.111-11");
		Aluno a7 = new Aluno(129L, "Nilson", "111.111.111-11");
		Aluno a8 = new Aluno(130L, "Ant�nio", "111.111.111-11");

		// Listagem de Alunos
		List<Aluno> lista = new ArrayList<Aluno>();
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		lista.add(a4);
		lista.add(a5);
		lista.add(a6);
		lista.add(a7);
		lista.add(a8);

		AlunoDAO dao = new AlunoDAO();
		try {
			dao.gravarAlunos(lista);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Leitura
		List<Aluno> novaLista = new ArrayList<Aluno>();
		novaLista = dao.lerAlunos();

		for (Aluno aluno : novaLista) {
			System.err.println(aluno.getNome());
		}

	}

}
