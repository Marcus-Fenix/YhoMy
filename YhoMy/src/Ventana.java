import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import twitter4j.Status;
import twitter4j.TwitterException;


public class Ventana extends JFrame{
	
	MyTwitterController twitter; 
	private JLabel post, etiqueta;
	private int y = 1;
	private JPanel Comenta = new JPanel();
	private JTextField comentario;
	private JButton publicar;
	
	public Ventana() throws TwitterException{
		etiqueta = new JLabel();
		publicar = new JButton();
		comentario = new JTextField();
		Comenta = new JPanel();
		
		Comenta.setSize(800, 100);
		this.setLayout(null);
		//new BorderLayout();
		this.setSize(900, 700);
		this.setTitle("Twitter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		twitter = new MyTwitterController();
		
		//-------panel de comentarios----------
		comentario.setBounds(300, 600, 400, 30);
		etiqueta.setText("publicacion");
		etiqueta.setBounds(200, 600, 100, 30);
		publicar.setText("Publicar");
		publicar.setBounds(700, 600, 100, 30);
		this.add(comentario);
		this.add(etiqueta);
		this.add(publicar);
		///--------------------------------------
		
		Comenta.setBounds(0,0 ,this.getWidth(),550);
		Comenta.setBackground(Color.white);
		
		//twitter.postTweet("hola mundo");
		List<Status> st = twitter.getTimeLine();
		for(Status stu: st){
			post = new JLabel(stu.getUser().getName() + " : " + stu.getText());
			Comenta.setLayout(new  GridLayout(30,30,5,5));
			Comenta.add(post);
		}
		this.add(Comenta);
		
	}

}
