package XaBuMDescontos;

public interface Cupom {
	void aplicarDesconto(Compra compra);

    @Override
    String toString();
}
