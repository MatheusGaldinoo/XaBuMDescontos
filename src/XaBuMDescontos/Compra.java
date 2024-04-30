package XaBuMDescontos;

public class Compra {
	// Atributos
	private int id;
	private String cpf;
	private double total;
	private double frete;

	// Construtor
	public Compra(int id, String cpf, double total, double frete) {
		this.id = id;
		this.cpf = cpf;
		this.total = total;
		this.frete = frete;
	}

	// Métodos
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getFrete() {
		return frete;
	}

	public void setFrete(double frete) {
		this.frete = frete;
	}

	public int getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}
}
