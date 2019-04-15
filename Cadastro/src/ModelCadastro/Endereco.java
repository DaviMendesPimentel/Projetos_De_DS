package ModelCadastro;

public class Endereco {
	private String cidade = null;	// cidade
	private String bairro = null;	// bairro
	private String rua = null;		// rua
	private String estado = null;	// estado
	private String cep = null;
	
	// define a cidade
	public void setCidade(String cidade) {
		if(cidade != null && !cidade.equals(""))
			this.cidade = cidade;
		
		else System.out.println("Valor invalido passado para cidade.");
	}
	
	// retorna a cidade
	public String getCidade() {
		return this.cidade;
	}
	
	// define o bairro
	public void setBairro(String bairro) {
		if(bairro != null && !bairro.equals(""))
			this.bairro = bairro;
		
		else System.out.println("Valor invalido passado para bairro.");
	}
	
	// retorna o bairro
	public String getBairro() {
		return this.bairro;
	}
	
	// define a rua
	public void setRua(String rua) {
		if(rua != null && !rua.equals(""))
			this.rua = rua;
	
		else System.out.println("Valor invalido passado para rua.");
	}
	
	// retorna a rua
	public String getRua() {
		return this.rua;
	}
	
	// define o estado
	public void setEstado(String estado) {
		if(estado != null && !estado.equals(""))
			this.estado = estado;
	
		else System.out.println("Valor invalido passado para estado.");
	}
	
	// retorna o estado
	public String getEstado() {
		return this.estado;
	}
	
	// define o cep
	public void setCep(String cep) {
		if(cep != null && !cep.equals(""))
			this.cep = cep;
		
		else System.out.println("Valor invalido passado para cep.");
	}
	
	// retorna o cep
	public String getCep() {
		return this.cep;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s - %s, %s - %s.", this.rua, this.bairro,
							this.cidade, this.cep, this.estado);
	}
}
