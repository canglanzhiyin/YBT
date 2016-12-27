
																																																																																																																																																														package dvd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class returnf extends JFrame{
	public returnf(){
		JFrame frm = new JFrame(); 
		frm.setTitle("欢迎归还小店的光碟");
		frm.setLayout(null);
		frm.setBounds(600,250, 450, 300);
		frm.setVisible(true);
		
		
		
		final JLabel label_Dtrue = new JLabel();
		label_Dtrue.setBounds(75, 150, 310, 30);
		frm.getContentPane().add(label_Dtrue);
		
		final JLabel label_Ptrue = new JLabel();
		label_Ptrue.setBounds(75, 180, 310, 30);
		frm.getContentPane().add(label_Ptrue);
		
		final JTextField text_read = new JTextField();
		text_read.setText("请输入要归还的碟片的序号");
		text_read.setHorizontalAlignment(JTextField.CENTER);
		text_read.setBounds(75, 65, 310, 30);
		frm.getContentPane().add(text_read);
		
		final JTextField text_read1 = new JTextField();
		text_read1.setText("请输入要归还的碟片的数量");
		text_read1.setHorizontalAlignment(JTextField.CENTER);
		text_read1.setBounds(75, 105, 310, 30);
		frm.getContentPane().add(text_read1);
		
		JButton k = new JButton("返回");
		k.setBounds(335, 220, 70, 25);
		frm.getContentPane().add(k);
		kButtonHandler kHandler = new kButtonHandler();
		k.addActionListener(kHandler);
		
		JButton n = new JButton("我还！");
		n.setBounds(165, 220, 70, 25);
		frm.getContentPane().add(n);
		n.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String name = text_read.getText();
				String number = text_read1.getText();
				int number1=Integer.parseInt(number);
				File file_d = new File("d:\\dvd\\Z1512480230\\" + name + ".txt");
				
				
				
				String a="d:\\dvd\\Z1512480230\\";
			     String c=".txt";
			     String b=a+name+c;
			     
				Scanner sc;
				try {
					sc = new Scanner(new File(""+b));
					  String zifu = sc.nextLine();
					     String[] gg=zifu.split(" ");
					     int caozuo=Integer.parseInt(gg[2]);
					     caozuo=caozuo+number1;
					     System.out.println("fuck");
					   
					     String gengxin=gg[0]+" "+gg[1]+" "+caozuo+" "+gg[3];
					     
					     File f = new File(""+b);
					     FileWriter fw =  new FileWriter(f);
					     fw.write(""+gengxin);
					     fw.close();
						
						if (number1>=0){
								
								label_Dtrue.setText("归还成功，谢谢惠顾！");
							}
							else label_Dtrue.setText("失败");
					     
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				

			}
		});
		
		
		JButton p = new JButton("打赏");
		p.setBounds(250, 220, 70, 25);
		frm.getContentPane().add(p);
		p.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String name = text_read.getText();
				int flag = 1;
				while(flag == 1){
					File file_p = new File("d:\\dvd\\Z1512480230\\" + name + ".txt");
					if(file_p.exists()){
						flag = 0;
					}
					else {
						int i;
						String j;
						i = Integer.parseInt(name);
						i++;
						j = String.valueOf(i);
						File file_p1 = new File("d:\\dvd\\Z1512480230\\" + j + ".txt");
						File file_p2 = new File("d:\\dvd\\Z1512480230\\" + name + ".txt");
						boolean f = file_p1.renameTo(file_p2);
						name = String.valueOf(i);
						int l;
						String m;
						l = Integer.parseInt(name);
						l++;
						m = String.valueOf(l);
						File file_p3 = new File("d:\\dvd\\Z1512480230\\" + m + ".txt");
						if (file_p3.exists()){  
							flag = 1;
						}
						else {
							flag = 0;
						}
					}
				}
				label_Ptrue.setText("打赏成功，谢谢爷");
			}
		});
	}
	
	class kButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			ManagerFunction ManagerFunction=new ManagerFunction();
			ManagerFunction.setVisible(true);
		}
	}
	
}

