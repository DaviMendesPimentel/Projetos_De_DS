package cadastro.pkg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

import java.awt.Container;
import java.awt.Component;

public class Cadastro extends JFrame{
	
	JLabel nomeLabel = new JLabel("Nome: ");
	JLabel enderecoLabel = new JLabel("Endere�o: ");
	JLabel cidadeLabel = new JLabel("Cidade: ");
	JLabel bairroLabel = new JLabel("Bairro: ");
	JLabel telefoneLabel = new JLabel("Telefone: ");
	JLabel rgLabel = new JLabel("RG: ");
	JLabel sexoLabel = new JLabel("Sexo: ");
	JLabel cepLabel = new JLabel("CEP: ");
	JLabel estadoLabel = new JLabel("Estados: ");
	JLabel celularLabel = new JLabel("Celular: ");
	JLabel cpfLabel = new JLabel("CPF: ");
	
	JTextField nometxt = new JTextField();
	JTextField enderecotxt = new JTextField();
	JTextField cidadetxt = new JTextField();
	JTextField bairrotxt = new JTextField();
	JTextField telefonetxt = new JTextField();
	JTextField rgtxt = new JTextField();
	JTextField ceptxt = new JTextField();
	JTextField celulartxt = new JTextField();
	JTextField cpftxt = new JTextField();
	
	JRadioButton masculino = new JRadioButton("Masculino");
	JRadioButton feminino = new JRadioButton("Feminino");
	ButtonGroup radioGroup = new ButtonGroup();
	
	JComboBox estados = new JComboBox();
	
	// construtor:
	public Cadastro(){
		super("Tela de Cadastro"); // configura o t�tulo da janela atrav�s do construtor de JFrame()
		
		Container paine = this.getContentPane(); // cria um container para ter como refer�ncia da janela
		
		this.setBoundsComponentsCadastro(); // configura a posi��o de todos os componentes da janela
		this.addComponentsCadastro(); // adiciona todos os componentes na janela
		
		this.setLayout(null); // configura o layout como null
		this.setVisible(true); // configura a visibilidade da janela
		this.setSize(500, 400); // configura o tamanho da janela
		//this.setResizable(false); // torna o tamanho da janela inalter�vel pelo usu�rio
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); // configura a a��o de 'fechar' da janela
	}// fim do construtor
	
	// fun��o respons�vel por posicionar cada componente no JFrame
	public void setBoundsComponentsCadastro() {
		int 	xPosition = 5, // cria e configura a posi��o X
				yPosition = 5, // cria e configura a posi��o Y
				width = 0, // cria e configura a largura
				heigth = 30, // cria e configura a altura
				espacamento = 5; // cria e configura o espacamento
		
		int labelCount = 1;
		int fieldsCount = 1;
		width = 70; // configura a largura para os labels
		JLabel vetButtons[] = {nomeLabel, enderecoLabel, cidadeLabel,
								bairroLabel, telefoneLabel, rgLabel, sexoLabel,
								cepLabel, estadoLabel, celularLabel, cpfLabel}; // cria o vetor de componentes
		
		JTextField vetTextFields[] = {nometxt, enderecotxt, cidadetxt, bairrotxt,
									telefonetxt, rgtxt, ceptxt, celulartxt, cpftxt}; // cria o vetor de textos
		
		for(JLabel l : vetButtons) { // la�o for para configurar todos os JLabels
			if(labelCount % 7 == 0) {
				xPosition = width + 50;
				yPosition = 5;
			}
			
			l.setBounds(xPosition, yPosition, width, heigth); // configura as posi��es de cada label
			
			
			yPosition += heigth + espacamento; // configura a posi��o Y para o pr�ximo label do for
			++labelCount;
		} // fim do for
		
		xPosition += width; // configura a posi��o X novamente com base na largura dos labels passados
		yPosition = 5; // configura a posi��o Y novamente (reseta a posi��o)
		width = 190; // configura a nova largura para os componentes JTextField
		for(JTextField t : vetTextFields) { // la�o for para configurar todos os JTextFields
			if(fieldsCount % 7 == 0) {
				xPosition = width + 50;
				yPosition = 5;
			}
			
			t.setBounds(xPosition, yPosition, width, heigth); // configura as posi��es de cada campo de texto
			
			yPosition += heigth + espacamento; // configura a posi��o Y para o pr�ximo campo de texto do for
		} // fim do for
		
	} // fim de setBoundsComponentsCadastro()

	// fun��o respons�vel por adicionar todos os componentes no JFrame
	public void addComponentsCadastro() {
		Component vetComponents[] = {nomeLabel, enderecoLabel, cidadeLabel, // vetor de Componentes
									bairroLabel, telefoneLabel, rgLabel,
									sexoLabel, cepLabel, estadoLabel,
									celularLabel, cpfLabel,
									nometxt, enderecotxt, cidadetxt, bairrotxt,
									telefonetxt, rgtxt, ceptxt, celulartxt, cpftxt,
									masculino, feminino, estados};
		
		estados.addItem("AC");
		estados.addItem("AL");
		estados.addItem("AP");
		estados.addItem("AM");
		estados.addItem("BA");
		estados.addItem("CE");
		estados.addItem("DF");
		estados.addItem("ES");
		estados.addItem("GO");
		estados.addItem("MA");
		estados.addItem("MT");
		estados.addItem("MS");
		estados.addItem("MG");
		estados.addItem("PA");
		estados.addItem("PB");
		estados.addItem("PR");
		estados.addItem("PE");
		estados.addItem("PI");
		estados.addItem("RJ");
		estados.addItem("RN");
		estados.addItem("RS");
		estados.addItem("RO");
		estados.addItem("RR");
		estados.addItem("SC");
		estados.addItem("SP");
		estados.addItem("SE");
		estados.addItem("TO");
		
		for(Component c : vetComponents) // la�o for para adicionar os componentes do vetor no JFrame
			this.add(c); // adiciona o componente ao JFrame
		
		radioGroup.add(masculino);
		radioGroup.add(feminino);
		
		
		
	} // fim de addComponentsCadastro()
	
	
	// fun��o main:
	public static void main(String[] args) {
		Cadastro cad = new Cadastro(); // cria um objeto Cadastro para inicializar a janela
	}

}
