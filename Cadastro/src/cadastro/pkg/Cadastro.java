package cadastro.pkg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;

import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	JComboBox<String> estados = new JComboBox<String>();
	
	MaskFormatter rgfmt;
	MaskFormatter cepfmt;
	MaskFormatter celularfmt;
	MaskFormatter cpffmt;
	
	JButton confirmar = new JButton("Confirmar");
	JButton cancelar = new JButton("Cancelar");
	
	// construtor:
	public Cadastro(){
		super("Tela de Cadastro"); // configura o t�tulo da janela atrav�s do construtor de JFrame()
		
		this.setMasksFormatters();
		this.setBoundsComponentsCadastro(); // configura a posi��o de todos os componentes da janela
		this.addComponentsCadastro(); // adiciona todos os componentes na janela
		
		confirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		this.setLayout(null); // configura o layout como null
		this.setVisible(true); // configura a visibilidade da janela
		this.setSize(600, 400); // configura o tamanho da janela
		this.setResizable(false); // torna o tamanho da janela inalter�vel pelo usu�rio
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // configura a a��o de 'fechar' da janela
	}// fim do construtor
	
	// fun��o respons�vel por posicionar cada componente no JFrame
	public void setBoundsComponentsCadastro() {
		int 	xPosition = 5, // cria e configura a posi��o X
				yPosition = 5, // cria e configura a posi��o Y
				width = 0, // cria e configura a largura
				heigth = 40, // cria e configura a altura
				espacamento = 5; // cria e configura o espacamento
		
		int labelCount = 1;
		width = 70; // configura a largura para os labels
		JLabel vetLabels[] = {nomeLabel, enderecoLabel, cidadeLabel,
								bairroLabel, telefoneLabel, rgLabel, sexoLabel,
								cepLabel, estadoLabel, celularLabel, cpfLabel}; // cria o vetor de componentes
		
		JTextField vetTextFields[] = {nometxt, enderecotxt, cidadetxt, bairrotxt,
									telefonetxt, rgtxt}; // cria o vetor de textos
		
		Component vetComponents[] = {ceptxt, estados, celulartxt, cpftxt}; // vetor para componentes especiais
		
		for(JLabel l : vetLabels) { // la�o for para configurar todos os JLabels
			if(labelCount % 7 == 0) { // verifica se est� configurando o s�timo label
				xPosition = width + 250; // caso sim, configura a posi��o de X para 'width + 250'
				yPosition = 5; // configura/reseta a posi��o de Y para 5
			} // fim do for
			
			l.setBounds(xPosition, yPosition, width, heigth); // configura as posi��es de cada label
			
			
			yPosition += heigth + espacamento; // configura a posi��o Y para o pr�ximo label do for
			++labelCount; // incrementa nosso 'labelCount' iterador
		} // fim do for
		

		xPosition = width + 15; // configura a posi��o X novamente com base na largura dos labels passados
		yPosition = 5; // configura a posi��o Y novamente (reseta a posi��o)
		width = 190; // configura a nova largura para os componentes JTextField		
		for(JTextField t : vetTextFields) { // la�o for para configurar todos os JTextFields
			
			t.setBounds(xPosition, yPosition, width, heigth); // configura as posi��es de cada campo de texto
			
			yPosition += heigth + espacamento; // configura a posi��o Y para o pr�ximo campo de texto do for
		} // fim do for
		
		yPosition = 5; // configura a posi��o do Y manualmente (terei que arrumar isso aqui)
		xPosition = width + 190; // configura a posi��o do X manualmente (terei que arrumar isso aqui)
		
		masculino.setBounds(xPosition, yPosition, width / 2, heigth); // configura a posi��o do elemento masculino
		feminino.setBounds(xPosition + width / 2, yPosition, width, heigth); // do feminino
		
		yPosition = heigth + espacamento; // configura novamente a posi��o do Y manualmente 
											// (terei que arrumar isso aqui)
		
		for(Component c : vetComponents) { // la�o for para configurar a posi��o dos componentes expeciais
			c.setBounds(xPosition, yPosition, width, heigth); // configura a posi��o do elemento
			
			yPosition += heigth + espacamento; // configura a posi��o do Y para o pr�ximo componente
		}
		
		width = 120; // redefine a largura
		yPosition += 70; // configura o Y
		xPosition -= 50; // configura o X
		confirmar.setBounds(xPosition, yPosition, width, heigth); // configura a posi��o do confirmar
		cancelar.setBounds(xPosition + width + espacamento, yPosition, width, heigth); // configura a posi��o
																					// do cancelar
		
	} // fim de setBoundsComponentsCadastro()
	
	// fun��o respons�vel por configurar as m�scaras
	public void setMasksFormatters() {
		
		try { // bloco try para tratar as exce��es
			
			rgfmt = new MaskFormatter("###.###.###-A"); // configura a mascara para o rg
			cpffmt = new MaskFormatter("###.###.###-#"); // configura a mascara para o cpf
			cepfmt = new MaskFormatter("####-###"); // configura a mascara para o cep
			celularfmt = new MaskFormatter("(##)#####-####"); // configura a mascara para o celular
			
			rgtxt = new JFormattedTextField(rgfmt); // utiliza o campo de texto formatado 'rgfmt'
			cpftxt = new JFormattedTextField(cpffmt); // utiliza o campo de texto formatado 'cpffmt'
			ceptxt = new JFormattedTextField(cepfmt); // utiliza o campo de texto formatado 'cepfmt'
			celulartxt = new JFormattedTextField(celularfmt); // utiliza o campo de texto formatado 'celularfmt'
			
		}catch(Exception e) { // bloco catch para capturar poss�veis exce��es
			e.printStackTrace(); // imprime a pilha do de informa��es da exce��o
			System.exit(-1); // finaliza o programa sem sucesso (-1 informando que houve um erro)
		}
	}

	// fun��o respons�vel por adicionar todos os componentes no JFrame
	public void addComponentsCadastro() {
		Component vetComponents[] = {nomeLabel, enderecoLabel, cidadeLabel, // vetor de Componentes
									bairroLabel, telefoneLabel, rgLabel,
									sexoLabel, cepLabel, estadoLabel,
									celularLabel, cpfLabel,
									nometxt, enderecotxt, cidadetxt, bairrotxt,
									telefonetxt, rgtxt, ceptxt, celulartxt, cpftxt,
									masculino, feminino, estados, confirmar, cancelar};
		
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
