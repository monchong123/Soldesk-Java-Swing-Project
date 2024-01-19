package login;

import java.awt.Color;  
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import controller.member.MemberController;
import controller.member.MemberList;
import controller.member.MemberToken;
import design.RoundedButton;
import fix_frame.Fix_Frame;
import model.member.Member;
import view.Info;
import view.MainF;


public class login extends JPanel {
	   
    static String filename = "회원.txt";
    JPanel frameLoginPanel;

    public login(JPanel homePanel) {
       this.frameLoginPanel = homePanel;

       // JPanel 구조
       setBackground(new Color(187, 229, 255));
       setLayout(null);
       setSize(600, 800);

       // 아이디, 비번 입력창
       JLabel lID = new JLabel("ID");
       JLabel lPW = new JLabel("PW");
       JTextField tfID = new JTextField(10);
       JPasswordField tfPW = new JPasswordField(10);

       lID.setSize(300, 50);
       lID.setLocation(getWidth() / 4 - 50, 120); 
       lID.setFont(new Font("하늘보리체", Font.BOLD, 25));

       lPW.setSize(300, 50);
       lPW.setLocation(getWidth() / 4 - 50, 190);
       lPW.setFont(new Font("하늘보리체", Font.BOLD, 25));

       tfID.setSize(300, 50);
       tfID.setLocation(getWidth() / 4 + 70, 120);
       tfID.setFont(new Font("하늘보리체", Font.BOLD, 22));

       tfPW.setSize(300, 50);
       tfPW.setLocation(getWidth() / 4 + 70, 190);
       tfPW.setFont(new Font("하늘보리체", Font.BOLD, 22));
       tfPW.setEchoChar('*');

       add(lID);
       add(lPW);
       add(tfID);
       add(tfPW);

       // 하단의 버튼 설정
       RoundedButton btnLogin = new RoundedButton("로그인");
       RoundedButton btnJoin = new RoundedButton("회원가입");
       RoundedButton btnFindID = new RoundedButton("아이디 찾기");
       RoundedButton btnFindPassword = new RoundedButton("비밀번호 찾기");
       

       btnLogin.setSize(300, 40);
       btnLogin.setLocation(getWidth() / 4, 400);
       btnLogin.setFont(new Font("하늘보리체", Font.BOLD, 22));

       btnJoin.setSize(300, 40);
       btnJoin.setLocation((int) btnLogin.getLocation().getX(), (int) btnLogin.getLocation().getY() + 75);
       btnJoin.setFont(new Font("하늘보리체", Font.BOLD, 22));
       
       
       btnFindID.setSize(150, 40);
         btnFindID.setLocation((int) btnJoin.getLocation().getX(), (int) btnJoin.getLocation().getY() + 75);
         btnFindID.setFont(new Font("하늘보리체", Font.BOLD, 14));

         btnFindPassword.setSize(150, 40);
         btnFindPassword.setLocation((int) btnJoin.getLocation().getX() + 150, (int) btnJoin.getLocation().getY() + 75);
         btnFindPassword.setFont(new Font("하늘보리체", Font.BOLD, 14));


       add(btnLogin);
       add(btnJoin);
       add(btnFindID);
       add(btnFindPassword);
       


       // 버튼 이벤트
       // tfID와 tfPW 텍스트 필드에 액션 리스너를 추가합니다.
       ActionListener loginActionListener = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               MemberController cm = new MemberController();
               ArrayList<Member> memberArr = cm.readFile(filename);
               MemberList memberList = new MemberList();

               for (int i = 0; i < memberArr.size(); i++) {
                   memberList.addMember(memberArr.get(i));
               }

               String id = tfID.getText();
               String idCheck = memberList.loginMember(id);

               if (idCheck.isEmpty()) {
                   JOptionPane.showMessageDialog(null, "아이디를 확인해주세요.");
               } else {
                   if (idCheck.equals(new String(tfPW.getPassword()))) {
                       MemberToken.tokenID = id;
                       JOptionPane.showMessageDialog(null, id + "님, 환영합니다!");
                       dispose();
                       Fix_Frame.getInstance(new MainF());
                   } else {
                       JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
                   }
               }
           }
       };

       btnLogin.addActionListener(loginActionListener); // 로그인 버튼에도 동일한 액션 리스너를 추가
       tfID.addActionListener(loginActionListener);     // 아이디 입력 필드에서 엔터키를 누르면 동작
       tfPW.addActionListener(loginActionListener);     // 비밀번호 입력 필드에서 엔터키를 누르면 동작

       btnJoin.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {

             frameLoginPanel.removeAll();
             frameLoginPanel.add(new join(homePanel));
             frameLoginPanel.revalidate();
             frameLoginPanel.repaint();

          }
       });
       
       btnFindID.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                findID();
            }
        });

        btnFindPassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                findPassword();
            }
        });


    }// 생성자
    
    // 아이디 찾기 메서드
     public void findID() {
            String name = JOptionPane.showInputDialog("등록된 이름을 입력하세요.");
            String phone = JOptionPane.showInputDialog("등록된 전화번호를 입력하세요.");

            MemberController cm = new MemberController();
            ArrayList<Member> members = cm.readFile(filename);

            for (Member m : members) {
                if (m.getName().equals(name) && m.getTel().equals(phone)) {
                    JOptionPane.showMessageDialog(null, "당신의 아이디는: " + m.getId() + " 입니다.");
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "일치하는 회원 정보가 없습니다.");
        }

        // 비밀번호 찾기 메서드
     
        public void findPassword() {
            String id = JOptionPane.showInputDialog("아이디를 입력하세요.");
            String name = JOptionPane.showInputDialog("등록된 이름을 입력하세요.");
            String phone = JOptionPane.showInputDialog("등록된 전화번호를 입력하세요.");

            MemberController cm = new MemberController();
            ArrayList<Member> members = cm.readFile(filename);

            for (Member m : members) {
                if (m.getId().equals(id)&&m.getName().equals(name) && m.getTel().equals(phone)) {
                    JOptionPane.showMessageDialog(null, "당신의 비밀번호는: " + m.getPw() + " 입니다.");
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "일치하는 회원 정보가 없습니다.");
        }

    
    public void dispose() {
        JFrame parent = (JFrame) this.getTopLevelAncestor();
        parent.dispose();
    }
    


 }