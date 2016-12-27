package dvd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Delete extends JFrame{
	public Delete(){
		JFrame frm = new JFrame(); 
		frm.setTitle("删除");
		frm.setLayout(null);
		frm.setBounds(600,250, 450, 300);
		frm.setVisible(true);
		
		JLabel label_delete = new JLabel();
		label_delete.setText("文件名：");
		label_delete.setBounds(20, 65, 85, 30);
		frm.getContentPane().add(label_delete);
		
		final JLabel label_Dtrue = new JLabel();
		label_Dtrue.setBounds(75, 150, 310, 30);
		frm.getContentPane().add(label_Dtrue);
		
		final JLabel label_Ptrue = new JLabel();
		label_Ptrue.setBounds(75, 180, 310, 30);
		frm.getContentPane().add(label_Ptrue);
		
		final JTextField text_read = new JTextField();
		text_read.setText("请输入要删除的文件名");
		text_read.setHorizontalAlignment(JTextField.CENTER);
		text_read.setBounds(75, 65, 310, 30);
		frm.getContentPane().add(text_read);
		
		JButton k = new JButton("返回");
		k.setBounds(335, 220, 70, 25);
		frm.getContentPane().add(k);
		kButtonHandler kHandler = new kButtonHandler();
		k.addActionListener(kHandler);
		
		JButton n = new JButton("删除");
		n.setBounds(165, 220, 70, 25);
		frm.getContentPane().add(n);
		n.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String name = text_read.getText();
				File file_d = new File("d:\\dvd\\Z1512480230\\" + name + ".txt");
					if (file_d.isFile()&&file_d.exists()){
						file_d.delete();
						label_Dtrue.setText("删除成功！");
					}
					else label_Dtrue.setText("未找到相应文件！");
			}
		});
		
		JButton p = new JButton("排序");
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
				label_Ptrue.setText("重新排序完成！");
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






