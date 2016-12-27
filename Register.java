package dvd;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.synth.SynthToggleButtonUI;

public class Register extends JFrame implements ActionListener{
	public Register(){
		setTitle("注册界面");
		setBounds(600,250,600,475);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(null);
		JLabel user =new JLabel("用户名");
		JLabel password =new JLabel("密  码");
		JLabel a_password =new JLabel("确认密码");
		user.setBounds(180,80,200,50);
		getContentPane().add(user);
		password.setBounds(180,160,175,25);
		getContentPane().add(password);
		a_password.setBounds(180,230,175,25);
		getContentPane().add(a_password);
		
		final JTextField Register_user =new JTextField(30);
		final JTextField Register_password =new JTextField();
		final JTextField Register_a_password =new JTextField();
		Register_user.setEditable(true);
		Register_password.setEditable(true);
		Register_a_password.setEditable(true);
		Register_user.setColumns(1);
		Register_password.setColumns(1);
		Register_a_password.setColumns(1);
		Register_user.setBounds(240, 90, 170, 25);
		getContentPane().add(Register_user);
		Register_password.setBounds(240, 160, 170, 25);
		getContentPane().add(Register_password);
		Register_a_password.setBounds(240, 230, 170, 25);
		getContentPane().add(Register_a_password);
		
		JButton confirm =new JButton("确定");
		JButton cancel =new JButton("取消");
		confirm .setBounds(140, 325, 130, 35);
		getContentPane().add(confirm );
		cancel.setBounds(340, 325, 130, 35); 
		getContentPane().add(cancel);
		
		Cancelclick cancel_b=new Cancelclick();
		cancel.addActionListener(cancel_b); 
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user,password,a_password;
				user=Register_user.getText();
				password=Register_password.getText();
				a_password=Register_a_password.getText();
				if(password.equals(a_password)){
				   File userDir=new File("d:\\dvd\\"+user);
				   if(userDir.mkdir()){
					   File passwordfile = new File("d:\\dvd\\"+user+"\\"+password);
					   try {
						   passwordfile.createNewFile();
						   setVisible(false);
						   JOptionPane.showMessageDialog(null, "注册成功");
						   Login login=new Login();
						   login.setVisible(true);
					   } catch (IOException e1) {
						   e1.printStackTrace();
					   }
				    }
				   else{
					    JOptionPane.showMessageDialog(null, "用户名已经存在");
						Register_user.setText("");
						Register_password.setText("");
						Register_a_password.setText("");
				   }
				   }
				else{
					JOptionPane.showMessageDialog(null, "两次密码不同");
					Register_user.setText("");
					Register_password.setText("");
					Register_a_password.setText("");
				}
		   }
		});
	}
	class Cancelclick implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			Login login=new Login();
			login.setVisible(true);
		}		
	}
	public void actionPerformed(ActionEvent e) {
	}
}


















