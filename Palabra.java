import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.Color;
import java.awt.Cursor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Palabra extends JFrame implements ActionListener{
	
	
	private JFrame ventana;
	private JButton botonAgregar;
	private JLabel textId;
	private JLabel longi;
	private JLabel polin;
	private JLabel inversa;
	private JLabel repetidas;
	private JTextField palabra;
	private JTextField caja2;
	private JTextField caja3;
	private JTextField caja4;
	private JTextField caja5;
	
	
	public Palabra() {
		
		configurarVentana();
		crearComponentes();

	}
	
	private void crearComponentes() {		
		botonAgregar = new JButton();
		botonAgregar.setText(" Verificar");
		botonAgregar.setBounds(380,80, 100, 30);
		botonAgregar.addActionListener(this);
		this.add(botonAgregar);
		
		textId = new JLabel();
		textId.setText(" Palabra: ");
		textId.setBounds(300,50, 80, 30);
		textId.setForeground(Color.darkGray);
		this.add(textId);
		
		
		palabra = new JTextField();
		palabra.setBounds(380,50,80,30);
		this.add(palabra);
		
		longi= new JLabel();
		longi.setText("longitud:" );
		longi.setBounds(200,200,80,30);
		this.add(longi);
		
		polin= new JLabel();
		polin.setText("palindromo:" );
		polin.setBounds(200,230,80,30);
		this.add(polin);
		
		inversa= new JLabel();
		inversa.setText("inversa:" );
		inversa.setBounds(200,260,80,30);
		this.add(inversa);
		
		repetidas= new JLabel();
		repetidas.setText("repetidas:" );
		repetidas.setBounds(200,290,80,30);
		this.add(repetidas);
		
		caja2= new JTextField();
		caja2.setBounds(280,200,80,30);
		this.add(caja2);
	
		caja4= new JTextField();
		caja4.setBounds(280,230,80,30);
		this.add(caja4);
		
		caja3= new JTextField();
		caja3.setBounds(280,260,80,30);
		this.add(caja3);

		caja5= new JTextField();
		caja5.setBounds(280,290,80,30);
		this.add(caja5);
	}

	private void configurarVentana() {
		

		this.setTitle("Palindromo.exe");
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.getContentPane().setBackground(Color.white);
	}

	
	public static void main(String[] args){
		Palabra ventana = new Palabra();
        ventana.setVisible(true);
       
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String frase = palabra.getText().toLowerCase();
		String inver="";
		String esp= ""; 
		int i=0;
		
		
		for(i=0; i<frase.length();i++) {
			if(frase.charAt(i)==' ') {
					
			}else {
				esp=esp + frase.charAt(i);
			}
		}
		
		int largo= esp.length();
		
		String longt= String.valueOf(largo);
		caja2.setText(longt);
		for(i=esp.length()-1;i>-1;i--) {
			inver= inver+esp.charAt(i);
		}
		caja3.setText(inver);
		
		if(esp.compareTo(inver)==0) {
			caja4.setText("si");
		}else {
			caja4.setText("no");
		}
		
		String[] repetidos= new String[frase.length()];
		int[] contadorRepetidos= new int[frase.length()];
		int contador=0;
		for (i=0; i<frase.length();i++) {
			for(int j=0;j<frase.length();j++) {
				if(frase.charAt(i)==frase.charAt(j)) {
					contadorRepetidos[i]+=1;
					repetidos[i]=String.valueOf(frase.charAt(i));
					
					}
			}
		}
		int mayor=0,aux=0;
		for (i=0; i<frase.length();i++) {
			if(i==0) {
				mayor=contadorRepetidos[0];
			}else if(mayor<=contadorRepetidos[i]) {
				mayor=contadorRepetidos[i];
				aux=i;
			}
		}
		caja5.setText(repetidos[aux]);
	}
}

