package ModelCadastro;

/**
 * Esta classe serve basicamente como uma superclasse padr�o para todas
 * as outras classes "pessoas", tais como PessoaF�sica, PessoaJur�dica, etc.
 * As implementa��es desta classe ser�o focadas no b�sico para todas classes pessoas,
 * tais como nome, cpf, rg, etc..
 * */


// classe Pessoa(padr�o) que implementa PessoaInterface
public class Pessoa implements PessoaInterface {
	
	private String genero = null; // genero da pessoa
	private String nome = null;	// nome da pessoa
	private String rg = null;	// rg da pessoa
	private String cpf = null;	// cpf da pessoa

	@Override // m�todo setNome sobrecarregado
	public void setNome(String nome) {
		// define o nome caso esteja de acordo
		if(nome != null && !nome.equals(""))
			this.nome = nome;
		
		else this.nome = null;	// ou define como null caso n�o esteja de acordo
	}

	@Override // m�todo getNome sobrecarregado
	public String getNome() {
		// retorna o nome da pessoa
		return this.nome;
	}

	@Override // m�todo setRG sobrecarregado
	public void setRG(String rg) {
		// define o rg caso esteja de acordo
		if(rg != null && !rg.equals(""))
			this.rg = rg;
		
		else this.rg = null;	// ou define como null caso n�o esteja de acordo
	}

	@Override
	public String getRG() {
		// retorna o rg da pessoa
		return this.rg;
	}

	@Override
	public void setCPF(String cpf) {
		// define o cpf caso esteja de acordo
		if(cpf != null && !cpf.equals(""))
			this.cpf = cpf;
		
		else this.cpf = null;	// ou define como null caso n�o esteja de acordo
	}

	@Override
	public String getCPF() {
		// retorna o cpf da pessoa
		return this.cpf;
	}

	@Override
	public void setGenero(String genero) {
		// define o genero caso esteja de acordo
		if(genero != null && !genero.equals(""))
			this.genero = genero;
		
		else this.genero = null;	// ou define como null caso n�o esteja de acordo
	}

	@Override
	public String getGenero() {
		// retorna o genero da pessoa
		return genero;
	}
	
}
