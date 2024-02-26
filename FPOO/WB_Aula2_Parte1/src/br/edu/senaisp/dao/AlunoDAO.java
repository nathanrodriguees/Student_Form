package br.edu.senaisp.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import br.edu.senaisp.model.Aluno;
import br.edu.senaisp.util.Log;

public class AlunoDAO {
	private String pathBancoDados = "C:\\TEMP\\TesteDeArquivo\\BancoDeDados.csv";

	public boolean gravarAlunos(List<Aluno> alunos) throws Exception {

		// Escrita
		PrintWriter pw;
		try {
			pw = new PrintWriter(pathBancoDados, Charset.forName("UTF-8"));

			for (Aluno a : alunos) {
				pw.print(a.getId());
				pw.print(";" + a.getNome());
				pw.print(";" + a.getCpf());
				pw.println();
			}

			pw.close();
			return true;
		} catch (Exception e) {
			Log.escrever("Erro ao tentar gravar Alunos: " + e.getMessage());
			throw new Exception("Erro ao tentar gravar Alunos: " + e.getMessage());
		}
	}

	public List<Aluno> lerAlunos() {
		List<Aluno> resposta = new ArrayList<Aluno>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(pathBancoDados));

			String linha;

			Aluno tmp;
			while ((linha = br.readLine()) != null) {

				String[] palavras = linha.split(";");
				tmp = new Aluno();
				tmp.setId(Long.parseLong(palavras[0]));
				tmp.setNome(palavras[1]);
				tmp.setCpf(palavras[2]);

				resposta.add(tmp);
			}

		} catch (Exception e) {
			Log.escrever(e.getMessage());
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				Log.escrever("Não conseguiu liberar o recurso. " + e.getMessage());
			}
		}
		return resposta;
	}

}
