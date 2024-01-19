package login;

import java.awt.Color;  
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.member.MemberController;
import controller.member.MemberList;
import design.RoundedButton;
import model.member.Member;



public class join extends JPanel{

	static String filename = "회원.txt";
	JPanel frameJoinPanel;
	
	 // 뒷배경 이미지를 위한 변수
    ImageIcon backgroundIcon;

	public join(JPanel homePanel) {
		this.frameJoinPanel = homePanel;
	
		
		// JPanel 구조
		setBackground(new Color(187, 229, 255));
		setLayout(null);
		setSize(600, 800);

		// 아이디, 비번 입력창
		JLabel ljoin = new JLabel("회 원 가 입");
		JLabel lID = new JLabel("아이디");
		JLabel lPW = new JLabel("비밀번호");
		JLabel lname = new JLabel("이름");
		JLabel ltel = new JLabel("전화번호");

		JTextField tfID = new JTextField(10);
		JPasswordField tfPW = new JPasswordField(10);
		JTextField tfname = new JTextField(10);
		JTextField tftel = new JTextField(10);

		ljoin.setSize(300, 40);
		ljoin.setLocation(getWidth() / 2 - 80, 60);
		ljoin.setFont(new Font("하늘보리체", Font.BOLD, 35));

		lID.setSize(100, 40);
		lID.setLocation(100, 200);
		lID.setFont(new Font("하늘보리체", Font.BOLD, 20));

		lPW.setSize(100, 40);
		lPW.setLocation(100, 250);
		lPW.setFont(new Font("하늘보리체", Font.BOLD, 20));

		lname.setSize(100, 40);
		lname.setLocation(100, 300);
		lname.setFont(new Font("하늘보리체", Font.BOLD, 20));


		ltel.setSize(100, 40);
		ltel.setLocation(100, 350);
		ltel.setFont(new Font("하늘보리체", Font.BOLD, 20));

		tfID.setSize(300, 40);
		tfID.setLocation(190, 200);
		tfID.setFont(new Font("하늘보리체", Font.BOLD, 20));

		tfPW.setSize(300, 40);
		tfPW.setLocation(190, 250);
		tfPW.setFont(new Font("하늘보리체", Font.BOLD, 20));
		tfPW.setEchoChar('*');

		tfname.setSize(300, 40);
		tfname.setLocation(190, 300);
		tfname.setFont(new Font("하늘보리체", Font.BOLD, 20));

		tftel.setSize(300, 40);
		tftel.setLocation(190, 350);
		tftel.setFont(new Font("하늘보리체", Font.BOLD, 20));

		add(ljoin);
		add(lID);
		add(lPW);
		add(lname);
		add(ltel);
		add(tfID);
		add(tfPW);
		add(tfname);
		add(tftel);
		

		// 하단의 버튼 설정
		RoundedButton btnDone = new RoundedButton("완료");
		RoundedButton btnHome = new RoundedButton("홈");

		btnDone.setSize(300, 40);
		btnDone.setLocation(150, 450);
		btnDone.setFont(new Font("하늘보리체", Font.BOLD, 20));

		btnHome.setSize(300, 40);
		btnHome.setLocation((int) btnDone.getLocation().getX(), (int) btnDone.getLocation().getY() + 50);

		btnHome.setFont(new Font("하늘보리체", Font.BOLD, 20));

		add(btnDone);
		add(btnHome);

		// 버튼 이벤트
		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String inputID = tfID.getText();
				String inputPW = new String(tfPW.getPassword());
				String inputName = tfname.getText();
				String inputTel = tftel.getText();

				if (!inputID.isEmpty() && (!inputPW.isEmpty()) && !inputName.isEmpty() && !inputTel.isEmpty()) {
					
					MemberController cm = new MemberController();
					ArrayList<Member> memberArr = cm.readFile(filename);
					MemberList memberList = new MemberList();

					for (int i = 0; i < memberArr.size(); i++) {
						memberList.addMember(memberArr.get(i));
					}

					String idCheck = memberList.joinMember(inputID);
					
					if(!idCheck.isEmpty()) {
						JOptionPane.showMessageDialog(null, idCheck);
						return;
					}

					try (BufferedWriter br = new BufferedWriter(new FileWriter("회원.txt", true))) {

						br.write(inputID+"/");
						br.write(inputPW+"/");
						br.write(inputName+"/");
						br.write(inputTel + "\n");

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "회원가입이 실패했습니다.");
					}

					JOptionPane.showMessageDialog(null, "회원가입에 성공했습니다.");
					dispose();
					new Home();

				} else {
					JOptionPane.showMessageDialog(null, "회원가입이 실패했습니다.");
				}

			}
		});

		
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home();
			}
		});

	}// 생성자
	
	//이부분이 있어야 이미지 배경화면 가능
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundIcon != null) {
            g.drawImage(backgroundIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }
	
	public void dispose() {
	    JFrame parent = (JFrame) this.getTopLevelAncestor();
	    parent.dispose();
	}
	
}
