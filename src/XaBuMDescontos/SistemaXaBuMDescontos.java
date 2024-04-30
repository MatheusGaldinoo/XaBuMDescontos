package XaBuMDescontos;

import java.util.*;

public class SistemaXaBuMDescontos {
	// Atributos
	private ArrayList<Cupom> cupons;
	private HashMap<String, Usuario> usuarios;
	
	// Construtor
	public SistemaXaBuMDescontos() {
		this.cupons = new ArrayList<>();
		this.usuarios = new HashMap<>();
	}
	
	// Métodos
	
	// Parte 1 
	
	public String criaCupomFreteGratis(double maxDesconto) {
		CupomFreteGratis c = new CupomFreteGratis(maxDesconto);
		cupons.add(c);
		return "Cupom adicioando ao sistema";
	}
	
	public String criaCupomDescontoFixo(double percentualDesconto, double maxDesconto) {
		CupomDescontoFixo c = new CupomDescontoFixo(percentualDesconto, maxDesconto);
		cupons.add(c);
		return "Cupom adicionado ao sistema";
	}
	
	public String criaCupomDescontoProgressivo() {
		CupomDescontoProgressivo c = new CupomDescontoProgressivo();
		cupons.add(c);
		return "Cupom adicionado ao sistema";
	}
	
	public String adicionaUsuario(String cpf, String nome) {
		Usuario u = new Usuario(cpf, nome);
		usuarios.put(cpf, u);
		return "Usuario adicionado ao sistema";
	}
	
	public String addCupomUsuario(String cpf, int indexCupom) {
		Usuario u = usuarios.get(cpf);
		Cupom c = cupons.get(indexCupom);
		u.adicionaCupom(c);
		cupons.remove(indexCupom);
		return "Cupom adicionado ao usuário";
	}
	
	public String aplicarDescontoCompra(Compra minhaCompra, int indexCupomUsuario) {
		Usuario u = usuarios.get(minhaCompra.getCpf());
		u.usaCupom(indexCupomUsuario, minhaCompra);
		return "Desconto aplicado";
	}
	
	public String[] listarCuponsUsuario(String cpf) {
		Usuario u = usuarios.get(cpf);
		
		String[] cuponsArray = new String[u.getCupons().size()];
		
		int i = 0;
		for (Cupom c : u.getCupons()) {
			cuponsArray[i] = c.toString();
		}
		
		return cuponsArray;
	}
	
	// Parte 2
	
	public String[] listarUsuariosPorNome() {
		
		Usuario[] UsuariosArray = new Usuario[usuarios.size()];
	    
	    int j = 0;
	    for (Usuario u : usuarios.values()) {
	    	UsuariosArray[j] = u;
	        j++;
	    }

	    Arrays.sort(UsuariosArray);
	    
	    String[] ordenadoPorNome = new String[UsuariosArray.length];
	    
	    int i = 0;
	    for (Usuario u : UsuariosArray) {
	    	ordenadoPorNome[i] = u.toString();
	        i++;
	    }
	    
	    return ordenadoPorNome;
	}
	
	public String[] listarUsuariosPorCuponsTotais() {
		ArrayList<Usuario> usuariosList = new ArrayList<>(usuarios.values());

        Collections.sort(usuariosList, new ComparadorUsuarios());

        String[] ordenado = new String[usuariosList.size()];
        int i = 0;
        for (Usuario u : usuariosList) {
            ordenado[i] = u.toString();
            i++;
        }

        return ordenado;
	}
	
}
