package calculadora_PKG;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// classe Calculator_Frame que herda de JFrame
public final class Calculator_Frame extends JFrame{
	
	String numberOneString, numberTwoString;	// números renponsáveis por armazenar os 
								// números pressionados na calculadora
	String lastOperator;	// ultimo operador pressionado
	
	
	JMenuBar barraDeMenu = new JMenuBar();	// barra de menu da calculadora
	
	// itens da barra de menu
	JMenu exibir = new JMenu("Exibir");
	JMenu editar = new JMenu("Editar");
	JMenu ajuda = new JMenu("Ajuda");
	JMenu historicoEdit = new JMenu("Histórico");
	JMenu planilha = new JMenu("Planilha");
	
	ButtonGroup moduloDoCalculo = new ButtonGroup();
	ButtonGroup moduloDeConversoes = new ButtonGroup();
	
	JRadioButtonMenuItem hipoteca = new JRadioButtonMenuItem("Hipoteca");
	JRadioButtonMenuItem leasingDeVideo = new JRadioButtonMenuItem("Leasing de Video");
	JRadioButtonMenuItem combustivel1 = new JRadioButtonMenuItem("Economia de Combustível(Km/l)");
	JRadioButtonMenuItem combustivel2 = new JRadioButtonMenuItem("Economia de Combustível(l/100 Km)");
	JRadioButtonMenuItem padrao = new JRadioButtonMenuItem("Padrão");
	JRadioButtonMenuItem cientifica = new JRadioButtonMenuItem("Científica");
	JRadioButtonMenuItem programador = new JRadioButtonMenuItem("Programador");
	JRadioButtonMenuItem estatistica = new JRadioButtonMenuItem("Estatística");
	JCheckBoxMenuItem historico = new JCheckBoxMenuItem("Histórico");
	JCheckBoxMenuItem agrupDeDigitos = new JCheckBoxMenuItem("Agrupamento de Dígitos");
	JRadioButtonMenuItem basico = new JRadioButtonMenuItem("Básico");
	JRadioButtonMenuItem conversaoDeUnidades = new JRadioButtonMenuItem("Conversão de Unidades");
	JRadioButtonMenuItem calculoDeData = new JRadioButtonMenuItem("Calculo de Data");
	JMenuItem copiar = new JMenuItem("Copiar");
	JMenuItem colar = new JMenuItem("Colar");
	JMenuItem exibirAjuda = new JMenuItem("Exibir Ajuda");
	JMenuItem sobreACalculadora = new JMenuItem("Sobre a Calculadora");
	JMenuItem sair = new JMenuItem("Sair");
	JMenuItem copiarHistorico = new JMenuItem("Copiar Histórico");
	JMenuItem editarHistorico = new JMenuItem("Editar");
	JMenuItem cancelarEdit = new JMenuItem("Cancelar Edição");
	JMenuItem limpar = new JMenuItem("Limpar");
	
	
	// campo de texto da calculadora
	JTextArea txt = new JTextArea("0");
	
	
	// criação dos Botões base da calculadora
	JButton mc = new JButton("MC");
	JButton mr = new JButton("MR");
	JButton ms = new JButton("MS");
	JButton mMore = new JButton("M+");
	JButton mLess = new JButton("M-");
	JButton backSpace = new JButton("<-");
	JButton ce = new JButton("CE");
	JButton c = new JButton("C");
	JButton moreLess = new JButton("+/-");
	JButton square = new JButton("SQR");
	JButton seven = new JButton("7");
	JButton eight = new JButton("8");
	JButton nine = new JButton("9");
	JButton bar = new JButton("/");
	JButton percent = new JButton("%");
	JButton four = new JButton("4");
	JButton five = new JButton("5");
	JButton six = new JButton("6");
	JButton aster = new JButton("*");
	JButton oneX = new JButton("1/x");
	JButton one = new JButton("1");
	JButton two = new JButton("2");
	JButton three = new JButton("3");
	JButton less = new JButton("-");
	JButton equals = new JButton("=");
	JButton zero = new JButton("0");
	JButton comma = new JButton(",");
	JButton more = new JButton("+");
	
	Calculator_Frame(){
		super("Calculadora");	// chama o construtor da super classe para setar o título
		
		Container ctn = this.getContentPane();	// passa a referência da janela para 'ctn'
		
		Insets inst = new Insets(0, 0, 0, 0);	// cria uma Inset pra setar a borda dos botões
		
		// adiciona os menus na barra de menu
		barraDeMenu.add(exibir);
		barraDeMenu.add(editar);
		barraDeMenu.add(ajuda);
		
		txt.setEditable(false);	// impossibilita a edição manual no 'txt' (JTextArea)
		
		// seta as posições respectivas de cada componente
		setPositionsOfComponents();
		
		// adiciona o 'barraDeMenu' como principal menuBar
		this.setJMenuBar(barraDeMenu);
		
		moduloDoCalculo.add(padrao);
		moduloDoCalculo.add(cientifica);
		moduloDoCalculo.add(programador);
		moduloDoCalculo.add(estatistica);
		
		moduloDeConversoes.add(basico);
		moduloDeConversoes.add(conversaoDeUnidades);
		moduloDeConversoes.add(calculoDeData);
		moduloDeConversoes.add(planilha);
		moduloDeConversoes.add(hipoteca);
		moduloDeConversoes.add(leasingDeVideo);
		moduloDeConversoes.add(combustivel1);
		moduloDeConversoes.add(combustivel2);
		
		planilha.add(hipoteca);
		planilha.add(leasingDeVideo);
		planilha.add(combustivel1);
		planilha.add(combustivel2);
		
		historicoEdit.add(copiarHistorico);
		historicoEdit.add(editarHistorico);
		historicoEdit.add(cancelarEdit);
		historicoEdit.add(limpar);
		
		limpar.setEnabled(false);
		cancelarEdit.setEnabled(false);
		editarHistorico.setEnabled(false);
		copiarHistorico.setEnabled(false);
		
		exibir.add(padrao);
		exibir.add(cientifica);
		exibir.add(programador);
		exibir.add(estatistica);
		exibir.add(historico);
		exibir.add(agrupDeDigitos);
		exibir.add(basico);
		exibir.add(conversaoDeUnidades);
		exibir.add(calculoDeData);
		exibir.add(planilha);
		
		editar.add(copiar);
		editar.add(colar);
		editar.add(historicoEdit);
		
		ajuda.add(exibirAjuda);
		ajuda.add(sobreACalculadora);
		ajuda.add(sair);
		
		// setando a borda de cada botão para não haver problemas com os '...' do swing
		mc.setMargin(inst);
		mr.setMargin(inst);
		ms.setMargin(inst);
		mMore.setMargin(inst);
		mLess.setMargin(inst);
		backSpace.setMargin(inst);
		ce.setMargin(inst);
		c.setMargin(inst);
		moreLess.setMargin(inst);
		square.setMargin(inst);
		seven.setMargin(inst);
		eight.setMargin(inst);
		nine.setMargin(inst);
		bar.setMargin(inst);
		percent.setMargin(inst);
		four.setMargin(inst);
		five.setMargin(inst);
		six.setMargin(inst);
		aster.setMargin(inst);
		oneX.setMargin(inst);
		one.setMargin(inst);
		two.setMargin(inst);
		three.setMargin(inst);
		less.setMargin(inst);
		equals.setMargin(inst);
		zero.setMargin(inst);
		comma.setMargin(inst);
		more.setMargin(inst);
		
		// adiciona os componentes à janela
		ctn.add(txt);
		ctn.add(mc);
		ctn.add(mr);
		ctn.add(ms);
		ctn.add(mMore);
		ctn.add(mLess);
		ctn.add(backSpace);
		ctn.add(ce);
		ctn.add(c);
		ctn.add(moreLess);
		ctn.add(square);
		ctn.add(seven);
		ctn.add(eight);
		ctn.add(nine);
		ctn.add(bar);
		ctn.add(percent);
		ctn.add(four);
		ctn.add(five);
		ctn.add(six);
		ctn.add(aster);
		ctn.add(oneX);
		ctn.add(one);
		ctn.add(two);
		ctn.add(three);
		ctn.add(less);
		ctn.add(equals);
		ctn.add(zero);
		ctn.add(comma);
		ctn.add(more);
		
		// chama um méthodo para configurar os listener dos componentes(botões)
		setListeners();
		
		try {
		    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
		    java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		this.setSize(220, 315);	// configura o tamanho da janela
		this.setResizable(false);	// impossibila a alteração do tamanho da janela manualmente
		this.setLayout(null);	// utiliza nenhum layout
		this.setVisible(true);	// torna a janela visivel
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	// fecha todos os processos envolvendo a janela quando
														// a janela for fechada
	}
	
	public void setPositionsOfComponents() {
		txt.setBounds(10, 10, 195, 50);
		mc.setBounds(10, 70, 35, 25);
		mr.setBounds(50, 70, 35, 25);
		ms.setBounds(90, 70, 35, 25);
		mMore.setBounds(130, 70, 35, 25);
		mLess.setBounds(170, 70, 35, 25);
		backSpace.setBounds(10, 100, 35, 25);
		ce.setBounds(50, 100, 35, 25);
		c.setBounds(90, 100, 35, 25);
		moreLess.setBounds(130, 100, 35, 25);
		square.setBounds(170, 100, 35, 25);
		seven.setBounds(10, 130, 35, 25);
		eight.setBounds(50, 130, 35, 25);
		nine.setBounds(90, 130, 35, 25);
		bar.setBounds(130, 130, 35, 25);
		percent.setBounds(170, 130, 35, 25);
		four.setBounds(10, 160, 35, 25);
		five.setBounds(50, 160, 35, 25);
		six.setBounds(90, 160, 35, 25);
		aster.setBounds(130, 160, 35, 25);
		oneX.setBounds(170, 160, 35, 25);
		one.setBounds(10, 190, 35, 25);
		two.setBounds(50, 190, 35, 25);
		three.setBounds(90, 190, 35, 25);
		less.setBounds(130, 190, 35, 25);
		equals.setBounds(170, 190, 35, 55);
		zero.setBounds(10, 220, 75, 25);
		comma.setBounds(90, 220, 35, 25);
		more.setBounds(130, 220, 35, 25);
	}
	
	public void setListeners() {
		CalculatorListener cl = new CalculatorListener();	// objeto para configuração dos ouvintes
		JButton btnVetOperators[] = {more, less, aster, bar, percent, square};	// vetor de operadores
		JButton btnVetNumbers[] = {one, two, three, four, five,	// vetor de números
									six, seven, eight, nine, zero};
		
		
		try {	// bloco try para tratar exceções
			ActionListener acResetCalcDefault = new ActionListener() {	// adiciona um ouvinte para reset
				// quando ativo, este reseta o TextArea da calculadora e a calculadora
				@Override
				public void actionPerformed(ActionEvent e) {
					numberOneString = null;
					numberTwoString = null;
					lastOperator = null;
					txt.setText("0");
				}
			};
			c.addActionListener(acResetCalcDefault);
			ce.addActionListener(acResetCalcDefault);
			cl.setSairOperation();
			for(JButton operator: btnVetOperators) {	// laço de repetição para configurar todos os operadores
				cl.setCalculatorOperationListener(operator);	// método para configurar o operador passado
																// por parâmetro
			}
			cl.setEqualsOperatorListener();		// método para configurar o operador de igualdade '='
			for(JButton number: btnVetNumbers) {	// laço de repetição para configurar todos os números
				cl.setCalculatorNumberListener(number);	// método para configurar o número passado por parâmetro
			}
			
			backSpace.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//String tempString = ;
					
				}
			});

		}catch(Exception e) {	// bloco de captura padrão para exceções inesperadas
			System.out.println("Exceção inesperada lançada.");	// avisa sobre a exceção
			System.out.println("mensagem: " + e.getMessage());	// imprime a mensagem da exceção
			System.out.println("Trilha da mensagem: " + e.getStackTrace());	// mostra a pilha de mensagens
			System.exit(1);	// fecha o programa informando um erro
		}
	}
	private final class CalculatorListener{	// classe dentro da classe
		
		// método responsável por configurar os operadores
		public void setCalculatorOperationListener(JButton operator) {
			
			operator.addActionListener(new ActionListener() {
				// quando ativo, este converte o texto de 'txt' para uma variável inteira
				// e depois o armazena em 'numberOne', após isso este configura
				// o 'lastOperator' com o texto do respectivo operador
				// e configura o novo texto para 'txt'
				@Override
				public void actionPerformed(ActionEvent e) {
					numberOneString = txt.getText();
					numberTwoString = null;
					lastOperator = operator.getText();
					txt.setText(txt.getText() + " " + operator.getText() + " ");
				}
			});
		}
		
		// método responsável por configurar o operador de igualdade (=)
		public void setEqualsOperatorListener() {
			
			equals.addActionListener(new ActionListener() {
				// este verifica qual o operador pressionado pelo usuário
				// presente em 'txt', filtra o texto, converte o texto após o operador
				// para um inteiro e o armazena em 'numberTwo'
				// após isso, este configura o texto de 'txt'
				// com a respectiva operação escolhida pelo usuário
				// caso nenhuma dessas operações existam, este retorna
				@Override
				public void actionPerformed(ActionEvent e) {
					
					double numberOne = Double.parseDouble(numberOneString);
					double numberTwo = (numberTwoString != null) 
							? Double.parseDouble(numberTwoString) : 0d;
					
					
					if(lastOperator.equals(more.getText())) {
						txt.setText(Double.toString(numberOne + numberTwo));
					}
					else if(lastOperator.equals(less.getText())) {
						txt.setText(Double.toString(numberOne - numberTwo));
					}
					else if(lastOperator.equals(aster.getText())) {
						txt.setText(Double.toString(numberOne * numberTwo));
					}
					else if(lastOperator.equals(bar.getText())) {
						txt.setText(Double.toString(numberOne / numberTwo));
					}
					else if(lastOperator.equals(percent.getText())) {
						txt.setText(Double.toString(numberOne % numberTwo));
					}
					else if(lastOperator.equals(square.getText())) {
						txt.setText(Double.toString(Math.sqrt(numberOne)));
					}
					else if(lastOperator == null)
						return;
				}
			});
		}
		
		// função para configurar os números
		public void setCalculatorNumberListener(JButton number) {
			
			number.addActionListener(new ActionListener() {
				// quando ativo, este configura o texto de 'txt'
				// com o respectivo número pressionado
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(!(txt.getText().equals("0")))
						txt.setText(txt.getText() + number.getText());
					
					else txt.setText(number.getText());
					
					if(numberOneString != null) {
						if(numberTwoString == null)
							numberTwoString = number.getText();
						
						else numberTwoString += number.getText();
					}
				}
			});
		}
		public void setSairOperation() {
			sair.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
	}
}
