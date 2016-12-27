package dvd;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class LoginFunction extends JFrame implements ActionListener{
	public LoginFunction(){
		setTitle("»¶Ó­µÇÂ½£¡");
		setLayout(null);
		setResizable(false);
		setBounds(600,250, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
				
		JButton k = new JButton("²éÑ¯");
		k.setBounds(15, 40, 80, 30);
		getContentPane().add(k);
		k.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame b =new JFrame();
				b.setBounds(450,260,500,300);
				
				JTextArea output = new JTextArea();
				output.setRows(20);
				output.setColumns(30);
				JScrollPane outputScrollPane = new JScrollPane();
				outputScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				b.getContentPane().add(outputScrollPane);
				outputScrollPane.setViewportView(output);
				
				b.setResizable(false);
				b.setVisible(true);
				
				try {
					File file =new File("d:\\dvd\\Z1512480230");
					File[] number = file.listFiles();
					 for (int i = 1; i < number.length ; i++){
					   FileReader fileoutstream = new FileReader("d:\\dvd\\Z1512480230\\"+i+".txt");
					   BufferedReader buf = new BufferedReader(fileoutstream);
					   output.append(buf.readLine());
					   output.append("\n");
					 }
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}

		});	
		JButton j = new JButton("×âÁÞ");
		j.setBounds(15, 80, 80, 30);
		getContentPane().add(j);
		
		
		JButton m = new JButton("ÍË»¹");
		m.setBounds(15, 120, 80, 30);
		getContentPane().add(m);
		
		JButton n = new JButton("ÍË³ö");
		n.setBounds(15, 200, 80, 30);
		getContentPane().add(n);
		
		
		ImagePanel ip = new ImagePanel();
		ip.setBounds(110, 10, 300, 230);
		getContentPane().add(ip);
		
	}
	
	class ImagePanel extends JPanel{
		Image img;	
		public void paint(Graphics g){
			try{
				img = ImageIO.read(new File("./DVD.png"));
			}catch(IOException e){
				e.printStackTrace();
			}
			g.drawImage(img, 0, 0, 300, 300, null);
		}
	}


	public void actionPerformed(ActionEvent e) {
	}
}