package cadastro.pkg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.Component;

public class Cadastro extends JFrame{
	
	JLabel nomeLabel = new JLabel("Nome: ");
	JLabel enderecoLabel = new JLabel("Endereço: ");
	JLabel cidadeLabel = new JLabel("Cidade: ");
	JLabel bairroLabel = new JLabel("Bairro: ");
	JLabel telefoneLabel = new JLabel("Telefone: ");
	JLabel rgLabel = new JLabel("RG: ");
	
	JTextField nometxt = new JTextField();
	JTextField enderecotxt = new JTextField();
	JTextField cidadetxt = new JTextField();
	JTextField bairrotxt = new JTextField();
	JTextField telefonetxt = new JTextField();
	JTextField rgtxt = new JTextField();
	
	public Cadastro(){
		super("Tela de Cadastro");
		
		Container paine = this.getContentPane();
		
		this.setBoundsComponentsCadastro();
		this.addComponentsCadastro();
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(500, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public void setBoundsComponentsCadastro() {
		int xPosition = 5, yPosition = 5, width = 60, heigth = 20;
		JLabel vetButtons[] = {nomeLabel, enderecoLabel, cidadeLabel,
								bairroLabel, telefoneLabel, rgLabel};
		
		JTextField vetTextFields[] = {nometxt, enderecotxt, cidadetxt, bairrotxt,
									telefonetxt, rgtxt};
		
		for(JLabel l : vetButtons) {
			l.setBounds(xPosition, yPosition, width, heigth);
			
			
			yPosition += heigth;
		}
		
		xPosition += width;
		yPosition = 5;
		width = 120;
		for(JTextField t : vetTextFields) {
			t.setBounds(xPosition, yPosition, width, heigth);
			
			yPosition += heigth;
		}
		
	}

	public void addComponentsCadastro() {
		Component vetComponents[] = {nomeLabel, enderecoLabel, cidadeLabel,
									bairroLabel, telefoneLabel, rgLabel,
									nometxt, enderecotxt, cidadetxt, bairrotxt,
									telefonetxt, rgtxt};
		
		for(Component c : vetComponents)
			this.add(c);
	}
	
	public static void main(String[] args) {
		Cadastro cad = new Cadastro();
	}

}
