package XaBuMDescontos;

public class CupomDescontoProgressivo implements Cupom {
	
	// Construtor
	public CupomDescontoProgressivo() {
		
	}

	// Métodos
	
	@Override
	public String toString() {
		return "Desconto Progressivo, 1%, 5% ou 10%";
	}
	
	@Override
	public void aplicarDesconto(Compra compra) {
		if (compra.getTotal() <= 100) {
			double novoTotal = compra.getTotal() - (0.01 * compra.getTotal());
			compra.setTotal(novoTotal);
		} else if (compra.getTotal() <= 500){
			double novoTotal = compra.getTotal() - (0.05 * compra.getTotal());
			compra.setTotal(novoTotal);
		} else {
			double novoTotal = compra.getTotal() - (0.1 * compra.getTotal());
			compra.setTotal(novoTotal);
		}
	}
	
}
