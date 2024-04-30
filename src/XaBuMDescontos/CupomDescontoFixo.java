package XaBuMDescontos;

public class CupomDescontoFixo implements Cupom {
	// Atributos
	private double percentualDesconto;
	private double maxDesconto;
	
	// Construtor
	public CupomDescontoFixo(double percentualDesconto, double maxDesconto) {
		this.percentualDesconto = percentualDesconto;
		this.maxDesconto = maxDesconto;

	}
	
	// Métodos
	
	@Override
	public String toString() {
		return "Desconto Fixo de " + percentualDesconto  + "% até no máximo R$ " + maxDesconto;
	}
	
	@Override
	public void aplicarDesconto(Compra compra) {
		if (this.percentualDesconto*compra.getTotal() > maxDesconto) {
			double novoTotal = compra.getTotal() - this.maxDesconto;
			compra.setTotal(novoTotal);
		} else {
			double novoTotal = compra.getTotal() - (this.percentualDesconto * compra.getTotal());
			compra.setTotal(novoTotal);
		}
	}
	
}
