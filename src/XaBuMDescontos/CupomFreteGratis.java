package XaBuMDescontos;

public class CupomFreteGratis implements Cupom {
	// Atributos
	private double maxDesconto;
	
	// Construtor
	public CupomFreteGratis(double maxDesconto) {
		this.maxDesconto = maxDesconto;
	}

	// Métodos
	
	@Override
	public String toString() {
		if (this.maxDesconto == 0) {
			return "FreteGratis";
		} else {
			return "Desconto de até R$ " + maxDesconto " no Frete"
		}
	}

	@Override
	public void aplicarDesconto(ResumoCompra compra) {
		if (this.maxDesconto = 0) {
			compra.setFrete(0);
		} else {
			double novoFrete = compra.getFrete() - this.maxDesconto;
			compra.setFrete(novoFrete);
		}
	}
	
}
