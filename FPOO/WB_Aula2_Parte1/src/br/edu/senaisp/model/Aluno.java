package br.edu.senaisp.model;

public class Aluno {
	private Long id;
	private String nome;
	private String cpf;
	private static String turma;
	
	public Aluno() {}
	
	public Aluno(Long id, String nome, String cpf) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + "("+ this.cpf +")";
	}
	
	

}
