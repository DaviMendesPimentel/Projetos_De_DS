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
	JLabel enderecoLabel = new JLabel("Endereço: ");
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
		super("Tela de Cadastro"); // configura o título da janela através do construtor de JFrame()
		
		this.setMasksFormatters();
		this.setBoundsComponentsCadastro(); // configura a posição de todos os componentes da janela
		this.addComponentsCadastro(); // adiciona todos os componentes na janela
		
		confirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		this.setLayout(null); // configura o layout como null
		this.setVisible(true); // configura a visibilidade da janela
		this.setSize(600, 400); // configura o tamanho da janela
		this.setResizable(false); // torna o tamanho da janela inalterável pelo usuário
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // configura a ação de 'fechar' da janela
	}// fim do construtor
	
	// função responsável por posicionar cada componente no JFrame
	public void setBoundsComponentsCadastro() {
		int 	xPosition = 5, // cria e configura a posição X
				yPosition = 5, // cria e configura a posição Y
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
		
		for(JLabel l : vetLabels) { // laço for para configurar todos os JLabels
			if(labelCount % 7 == 0) { // verifica se está configurando o sétimo label
				xPosition = width + 250; // caso sim, configura a posição de X para 'width + 250'
				yPosition = 5; // configura/reseta a posição de Y para 5
			} // fim do for
			
			l.setBounds(xPosition, yPosition, width, heigth); // configura as posições de cada label
			
			
			yPosition += heigth + espacamento; // configura a posição Y para o próximo label do for
			++labelCount; // incrementa nosso 'labelCount' iterador
		} // fim do for
		

		xPosition = width + 15; // configura a posição X novamente com base na largura dos labels passados
		yPosition = 5; // configura a posição Y novamente (reseta a posição)
		width = 190; // configura a nova largura para os componentes JTextField		
		for(JTextField t : vetTextFields) { // laço for para configurar todos os JTextFields
			
			t.setBounds(xPosition, yPosition, width, heigth); // configura as posições de cada campo de texto
			
			yPosition += heigth + espacamento; // configura a posição Y para o próximo campo de texto do for
		} // fim do for
		
		yPosition = 5; // configura a posição do Y manualmente (terei que arrumar isso aqui)
		xPosition = width + 190; // configura a posição do X manualmente (terei que arrumar isso aqui)
		
		masculino.setBounds(xPosition, yPosition, width / 2, heigth); // configura a posição do elemento masculino
		feminino.setBounds(xPosition + width / 2, yPosition, width, heigth); // do feminino
		
		yPosition = heigth + espacamento; // configura novamente a posição do Y manualmente 
											// (terei que arrumar isso aqui)
		
		for(Component c : vetComponents) { // laço for para configurar a posição dos componentes expeciais
			c.setBounds(xPosition, yPosition, width, heigth); // configura a posição do elemento
			
			yPosition += heigth + espacamento; // configura a posição do Y para o próximo componente
		}
		
		width = 120; // redefine a largura
		yPosition += 70; // configura o Y
		xPosition -= 50; // configura o X
		confirmar.setBounds(xPosition, yPosition, width, heigth); // configura a posição do confirmar
		cancelar.setBounds(xPosition + width + espacamento, yPosition, width, heigth); // configura a posição
																					// do cancelar
		
	} // fim de setBoundsComponentsCadastro()
	
	// função responsável por configurar as máscaras
	public void setMasksFormatters() {
		
		try { // bloco try para tratar as exceções
			
			rgfmt = new MaskFormatter("###.###.###-A"); // configura a mascara para o rg
			cpffmt = new MaskFormatter("###.###.###-#"); // configura a mascara para o cpf
			cepfmt = new MaskFormatter("####-###"); // configura a mascara para o cep
			celularfmt = new MaskFormatter("(##)#####-####"); // configura a mascara para o celular
			
			rgtxt = new JFormattedTextField(rgfmt); // utiliza o campo de texto formatado 'rgfmt'
			cpftxt = new JFormattedTextField(cpffmt); // utiliza o campo de texto formatado 'cpffmt'
			ceptxt = new JFormattedTextField(cepfmt); // utiliza o campo de texto formatado 'cepfmt'
			celulartxt = new JFormattedTextField(celularfmt); // utiliza o campo de texto formatado 'celularfmt'
			
		}catch(Exception e) { // bloco catch para capturar possíveis exceções
			e.printStackTrace(); // imprime a pilha do de informações da exceção
			System.exit(-1); // finaliza o programa sem sucesso (-1 informando que houve um erro)
		}
	}

	// função responsável por adicionar todos os componentes no JFrame
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
		
		for(Component c : vetComponents) // laço for para adicionar os componentes do vetor no JFrame
			this.add(c); // adiciona o componente ao JFrame
		
		radioGroup.add(masculino);
		radioGroup.add(feminino);
		
		
		
	} // fim de addComponentsCadastro()
	
	
	// função main:
	public static void main(String[] args) {
		Cadastro cad = new Cadastro(); // cria um objeto Cadastro para inicializar a janela
	}

}
