package dvd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Read extends JFrame implements ActionListener{
	public Read() {
		JFrame frm = new JFrame(); 
		frm.setTitle("¼��");
		frm.setLayout(null);
		frm.setBounds(600,250, 450, 300);
		frm.setVisible(true);
		
		final JTextField text_read1 = new JTextField();
		text_read1.setText("������DVD���");
		text_read1.setHorizontalAlignment(JTextField.CENTER);
		text_read1.setBounds(75, 15, 310, 30);
		frm.getContentPane().add(text_read1);
		
		final JTextField text_read2 = new JTextField();
		text_read2.setText("�����������Ϣ����ʽ�����  ����  ����  �۸�");
		text_read2.setHorizontalAlignment(JTextField.LEFT);		
		text_read2.setBounds(75, 60, 310, 90);
		frm.getContentPane().add(text_read2);
		
		final JLabel label_Rtrue = new JLabel();
		label_Rtrue.setBounds(75, 150, 310, 30);
		frm.getContentPane().add(label_Rtrue);
		
		JButton k = new JButton("����");
		k.setBounds(335, 220, 70, 25);
		frm.getContentPane().add(k);
		kButtonHandler kHandler = new kButtonHandler();
		k.addActionListener(kHandler);
		
		JButton n = new JButton("¼��");
		n.setBounds(250, 220, 70, 25);
		frm.getContentPane().add(n);
		n.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String name = text_read1.getText();
				String information_read1 = text_read2.getText(); 
				File file = new File("d:\\dvd\\Z1512480230\\" + name + ".txt");
				try {
					file.createNewFile();
					FileWriter fw_read;
					fw_read = new FileWriter("d:\\dvd\\Z1512480230\\" + name + ".txt");
					fw_read.write(information_read1);
					fw_read.close();
					label_Rtrue.setText("����ɹ���");
					
				} catch (IOException e) {
					e.printStackTrace();
				}
								
			}
		});
		
		JLabel label_read1 = new JLabel();
		label_read1.setText("�ļ�����");
		label_read1.setBounds(20, 15, 85, 30);
		frm.getContentPane().add(label_read1);
		
		JLabel label_read2 = new JLabel();
		label_read2.setText("��    Ϣ��");
		label_read2.setBounds(20, 60, 85, 30);
		frm.getContentPane().add(label_read2);
		
	}
	
	class kButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			ManagerFunction ManagerFunction=new ManagerFunction();
			ManagerFunction.setVisible(true);
		}
	}
	public void actionPerformed(ActionEvent arg0) {
	}
	
}








