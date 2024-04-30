package XaBuMDescontos;

import java.util.*;

public class Usuario implements Comparable<Usuario> {
	// Atributos
	private String nome;
	private String cpf;
	private ArrayList<Cupom> cupons;
	private int quantidadeCupons;
	
	// Construtor
	public Usuario(String nome, String cpf) {
		verificaExcecao(nome, cpf);
		this.nome = nome;
		this.cpf = cpf;
		this.cupons = new ArrayList<>();
		this.quantidadeCupons = 0;
	}
	
	// Métodos 

	public ArrayList<Cupom> getCupons() {
		return cupons;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return nome + " - "  + cpf + "\n";
	}
	
	public void verificaExcecao(String nome, String cpf) {
		if (nome == null || cpf == null) {
			throw new NullPointerException("ENTRADA NULA");
		} else if (nome == "" || cpf == "") {
			throw new IllegalArgumentException("ENTRADA VAZIA");
		}
	}
	
	public void adicionaCupom(Cupom c) {
		cupons.add(c);
		this.quantidadeCupons++;
	}
	
	public void usaCupom(int index, Compra minhaCompra) {
		Cupom c = cupons.get(index);
		c.aplicarDesconto(minhaCompra);
		cupons.remove(index);
	}

	@Override
	public int compareTo(Usuario o) {
		return this.nome.compareTo(o.getNome());
	}
	
}
