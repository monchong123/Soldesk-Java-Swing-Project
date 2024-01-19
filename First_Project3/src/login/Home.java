package login;

import java.awt.Color;  
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import design.RoundedButton;



public class Home extends JFrame {
	
	JScrollPane scrollPane;
	ImageIcon icon;

	public Home() {
		
		
		setTitle("mountain");
		setSize(600, 800);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		icon = new ImageIcon("logo2.png");
		
		//이미지 크기 수정하기위한 코드
		Image scaledImage = icon.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);
		
		JPanel panel = new JPanel() {

			public void paintComponent(Graphics g) {
				
				super.paintComponent(g);//이부분을 여기로 올려야 배경색 변경가능
				g.drawImage(icon.getImage(), 0, 50, null);//산 로고 위치 수정

				setOpaque(false);
				
				
				
			}
			
			
		};
		panel.setOpaque(true); // 패널을 불투명하게 만듭니다.
		panel.setBackground(new Color(187,229,255)); // 배경색을 빨강으로 설정합니다.
		
		

		RoundedButton btnLogin = new RoundedButton("로그인");
		RoundedButton btnJoin = new RoundedButton("회원가입");

		panel.setLayout(null);

		btnLogin.setSize(250, 50);
		btnLogin.setLocation(getWidth()/3- 35, 450);
		btnLogin.setFont(new Font("하늘보리체", Font.BOLD, 26));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		

		btnJoin.setSize(250, 50);
		btnJoin.setLocation(getWidth()/3- 35, 550);
		btnJoin.setFont(new Font("하늘보리체", Font.BOLD, 26));
		btnJoin.setContentAreaFilled(false);
		btnJoin.setBorderPainted(false);
		
		
		

		panel.add(btnLogin);
		panel.add(btnJoin);

		scrollPane = new JScrollPane(panel);
		setContentPane(scrollPane);

		setVisible(true);
		
		//로그인 버튼 
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panel.removeAll();
				panel.add(new login(panel));
				panel.revalidate();
				panel.repaint();

			}
		});

		// 회원가입 버튼
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(new join(panel));
				panel.revalidate();
				panel.repaint();
			}
		});

	}
}