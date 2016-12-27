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


public class ManagerFunction extends JFrame implements ActionListener{
	public  ManagerFunction(){
		setTitle("»¶Ó­µÇÂ½£¡");
		setLayout(null);
		setResizable(false);
		setBounds(600,250, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
				
		JButton k = new JButton("²éÑ¯");
		k.setBounds(15, 1, 80, 30);
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
					 for (int i = 1; i <=number.length-1 ; i++){
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
		JButton j = new JButton("Â¼Èë");
		j.setBounds(15, 40, 80, 30);
		getContentPane().add(j);
		kButtonHandler kHandler = new kButtonHandler();
		j.addActionListener(kHandler);
		
		JButton i = new JButton("É¾³ý");
		i.setBounds(15, 80, 80, 30);
		getContentPane().add(i);
		jButtonHandler jHandler = new jButtonHandler();
		i.addActionListener(jHandler);
		
		JButton zujie = new JButton("×â½è");
		zujie.setBounds(15, 120, 80, 30);
		getContentPane().add(zujie);
		zujieButtonHandler zujieHandler = new zujieButtonHandler();
		zujie.addActionListener(zujieHandler);
		
		JButton guihuan = new JButton("¹é»¹");
		guihuan.setBounds(15, 160, 80, 30);
		getContentPane().add(guihuan);
		guihuanButtonHandler guihuanHandler = new guihuanButtonHandler();
		guihuan.addActionListener(guihuanHandler);
		
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
	class kButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				Read r = new Read();
			}catch(Exception e_r){
				e_r.printStackTrace();
			}
		}
	}
	class jButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Delete d = new Delete();
		}
	}
	class zujieButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lend l = new lend();
		}
	}
	class guihuanButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			returnf r = new returnf();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
	}
}