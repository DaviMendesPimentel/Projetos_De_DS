package calculadora_PKG;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;

import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// classe Calculator_Frame que herda de JFrame
public final class Calculator_Frame extends JFrame{
	
	int numberOne, numberTwo;	// números renponsáveis por armazenar os 
								// números pressionados na calculadora
	String lastOperator;	// ultimo operador pressionado
	
	JMenuBar barraDeMenu = new JMenuBar();	// barra de menu da calculadora
	
	// itens da barra de menu
	JMenu exibir = new JMenu("Exibir");
	JMenu editar = new JMenu("Editar");
	JMenu ajuda = new JMenu("Ajuda");
	
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
		
		// adiciona o 'barraDeMenu' como principal menuBar
		this.setJMenuBar(barraDeMenu);
		
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
		
		this.setSize(220, 315);	// configura o tamanho da janela
		this.setResizable(false);	// impossibila a alteração do tamanho da janela manualmente
		this.setLayout(null);	// utiliza nenhum layout
		this.setVisible(true);	// torna a janela visivel
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	// fecha todos os processos envolvendo a janela quando
														// a janela for fechada
	}
	
	public void setListeners() {
		CalculatorListener cl = new CalculatorListener();	// objeto para configuração dos ouvintes
		JButton btnVetOperators[] = {more, less, aster, bar, percent};	// vetor de operadores
		JButton btnVetNumbers[] = {one, two, three, four, five,	// vetor de números
									six, seven, eight, nine, zero};
		
		
		try {	// bloco try para tratar exceções
			c.addActionListener(new ActionListener() {	// adiciona um ouvinte para as ações de 'c'
				// quando ativo, este reseta o TextArea da calculadora e a calculadora
				@Override
				public void actionPerformed(ActionEvent e) {
					numberOne = 0;
					numberTwo = 0;
					lastOperator = null;
					txt.setText("0");
				}
			});
			for(JButton operator: btnVetOperators) {	// laço de repetição para configurar todos os operadores
				cl.setCalculatorOperationListener(operator);	// método para configurar o operador passado
																// por parâmetro
			}
			cl.setEqualsOperatorListener();		// método para configurar o operador de igualdade '='
			for(JButton number: btnVetNumbers) {	// laço de repetição para configurar todos os números
				cl.setCalculatorNumberListener(number);	// método para configurar o número passado por parâmetro
			}
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
					numberOne = Integer.parseInt(txt.getText());
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
					String numVet[] = new String[2];
					numVet = txt.getText().split(lastOperator);
					
					numberTwo = Integer.parseInt(numVet[1].toString());
					if(lastOperator.equals("+")) {
						txt.setText(Integer.toString(numberOne + numberTwo));
					}
					else if(lastOperator.equals("-")) {
						txt.setText(Integer.toString(numberOne - numberTwo));
					}
					else if(lastOperator.equals("*")) {
						txt.setText(Integer.toString(numberOne * numberTwo));
					}
					else if(lastOperator.equals("/")) {
						txt.setText(Integer.toString(numberOne / numberTwo));
					}
					else if(lastOperator.equals("%")) {
						txt.setText(Integer.toString(numberOne % numberTwo));
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
				}
			});
		}
	}
}
