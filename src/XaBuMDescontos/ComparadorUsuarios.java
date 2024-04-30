package XaBuMDescontos;

import java.util.Comparator;

public class ComparadorUsuarios implements Comparator<Usuario> {
    @Override
    public int compare(Usuario u1, Usuario u2) {
        return Integer.compare(u2.getCupons().size(), u1.getCupons().size());
    }
}
