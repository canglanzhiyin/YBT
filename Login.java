package dvd;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Login extends JFrame implements ActionListener{
	public Login(){
		
		setTitle("DVD租赁系统");
		setBounds(600,250,600,475);
		setLayout(new BorderLayout());
		setResizable(false);
		
		setLayout(null);
		final JTextField login_user =new JTextField();
		final JTextField login_password =new JTextField();
		login_user.setEditable(true);
		login_password.setEditable(true);
		login_user.setColumns(1);
		login_password.setColumns(1);
		login_user.setBounds(220, 313, 170, 25);
		getContentPane().add(login_user);
		login_password.setBounds(220, 345, 170, 25);
		getContentPane().add(login_password);
		
		JLabel user =new JLabel("用户名");
		JLabel password =new JLabel("密  码");
		user.setBounds(177,310,175,25);
		getContentPane().add(user);
		password.setBounds(177,345,175,25);
		getContentPane().add(password);
		
		JButton login =new JButton("登陆");
		JButton register =new JButton("注册");
		login.setBounds(140, 387, 140, 30);
		getContentPane().add(login);
		register.setBounds(310, 387, 140, 30);
		getContentPane().add(register);
		
		ImagePanel ip = new ImagePanel();
		ip.setBounds(0, 0, 600, 400);
		getContentPane().add(ip);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Buttonclick register_b=new Buttonclick();
		register.addActionListener(register_b);
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String user,password;
				user=login_user.getText();
				password=login_password.getText();
				File userDir=new File("d:\\dvd\\"+user);
				if(userDir.mkdir()){
					JOptionPane.showMessageDialog(null, "用户名不存在");
					login_user.setText("");
					login_password.setText("");
					userDir.delete();
				}
				else{
					File passwordfile = new File("d:\\dvd\\"+user+"\\"+password);
					if(passwordfile.exists()){
						JOptionPane.showMessageDialog(null, "登录成功");
						if(userDir.getName().equals("Z1512480230")){
							setVisible(false);
							ManagerFunction ManagerFunction=new ManagerFunction();
							ManagerFunction.setVisible(true);
						}
						else{
							setVisible(false);
							LoginFunction LoginFunction=new LoginFunction();
							LoginFunction.setVisible(true);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "密码错误");
						login_password.setText("");
					}
				}
			}		
		});
	}
	class ImagePanel extends JPanel{
		Image img;
		public void paint(Graphics g){
			try{
				img = ImageIO.read(new File("./picture.jpg"));
			}catch (IOException e){
				e.printStackTrace();
			}
			g.drawImage(img, 0, 0,600,300,null);
		}
	}
	class Buttonclick implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			Register register=new Register();
			register.setVisible(true);
		}		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}






