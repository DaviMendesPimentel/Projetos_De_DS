package ModelCadastro;

public class PessoaFisica extends Pessoa {
	private Endereco endereco = null;	// endereço da pessoa
	private String telefone = null;		// numero-telefone da pessoa
	private String celular = null;		// numero-celular da pessoa
	
	// construtor
	public PessoaFisica(){
		endereco = new Endereco();
	}
	
	// define o endereco da pessoa física
	public void setEndereco(String rua, String bairro, String cidade,
							String estado, String cep) 
	{
		endereco.setRua(rua);	// define a rua
		endereco.setBairro(bairro);	// define o bairro
		endereco.setCidade(cidade);	// define a cidade
		endereco.setEstado(estado);	// define o estado
		endereco.setCep(cep);	// define o cep
	}
	
	// retorna o endereco
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	// define o numero-telefone
	public void setTelefone(String telefone) {
		if(telefone != null && !telefone.equals(""))
			this.telefone = telefone;
		
		else System.out.println("Valor invalido passado para telefone.");
	}
	
	// retorna o numero-telefone
	public String getTelefone() {
		return this.telefone;
	}
	
	// define o numero-celular
	public void setCelular(String celular) {
		if(celular != null && !celular.equals(""))
			this.celular = celular;
		
		else System.out.println("Valor invalido passado para celular.");
	}
	
	// retorna o numero-celular
	public String getCelular() {
		return this.celular;
	}
	
	@Override
	public String toString() {
		return String.format("Nome: %s\n"
				+ "Endereço: %s\n"
				+ "RG: %s\n"
				+ "CPF: %s\n"
				+ "Telefone: %s\n"
				+ "Sexo: %s\n"
				+ "Celular: %s\n", this.getNome(), this.endereco.toString(), this.getRG(), this.getCPF(),
				this.telefone, this.getGenero(), this.celular);
	}
}
