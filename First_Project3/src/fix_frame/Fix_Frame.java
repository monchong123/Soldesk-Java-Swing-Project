package fix_frame;

import javax.swing.*;

import Calendar.CalendarMain;
import community.Community;
import login.Home;
import view.MainF;
import view.bucketlist;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Fix_Frame extends JFrame {
	private static Fix_Frame instance;
	public Fix_Frame(JPanel e) {
	       Toolkit tk = Toolkit.getDefaultToolkit();//해상도
	       
	        setTitle("Mountain Together");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(((int) tk.getScreenSize().getWidth()) / 2 - 300, 
	            ((int) tk.getScreenSize().getHeight()) / 2 - 400,
	            600, 800);
	        getImage(e);//기본 배경 이미지
	        setVisible(true);
	    }
    
  //싱글톤 기법을 사용하려고 한다
    public static void getInstance(JPanel e) {
          //static으로 선언했으므로 해당 메서드가 생성자보다도 먼저 호출된다
          /*if(instance !=null) {
             instance.dispose();
          }
          */
          instance = new Fix_Frame(e);//생성자를 통해 기본 프레임 정의
          
          instance.getContentPane().removeAll();
          instance.getContentPane().add(e);
          
          instance.revalidate(); //레이아웃 관리자에게 레이아웃정보를 다시 계산하도록 지시
          instance.repaint(); //레이아웃을 새로 그린다
    }//getInstance()
    
  //기본 프레임 이미지를 저장하기 위한 메소드
  	public static void getImage(JPanel e) {
  		JPanel panel_S = new JPanel(new GridLayout(1, 4, 5, 10));
         JPanel panel_N = new JPanel();
         
         int width = 70;
         int height = 70;

         // 이전
         ImageIcon back = new ImageIcon(
                 new ImageIcon("Back.png").getImage().getScaledInstance(width, 90, Image.SCALE_DEFAULT));
         JLabel label1 = new JLabel(back);
         

         ImageIcon community = new ImageIcon(
                 new ImageIcon("Comm.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
         JLabel label2 = new JLabel(community);
         label2.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
            	 try {
            		Fix_Frame.getDispose();
					Fix_Frame.getInstance(new Community());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
             }
         });
        

         ImageIcon bucket = new ImageIcon(
                 new ImageIcon("check.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
         JLabel label3 = new JLabel(bucket);
			
			  label3.addMouseListener(new MouseAdapter() {
			  
			  @Override public void mouseClicked(MouseEvent e) {
				  Fix_Frame.getDispose();
				  Fix_Frame.getInstance(new bucketlist()); 
				  } 
			  });
			 

         ImageIcon cal = new ImageIcon(
                 new ImageIcon("Cal.png").getImage().getScaledInstance(width, height,  Image.SCALE_DEFAULT));
         JLabel label4 = new JLabel(cal);
         label4.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 Fix_Frame.getDispose();
                 Fix_Frame.getInstance(new CalendarMain()); 
             }
         });

         ImageIcon Logo = new ImageIcon(
                 new ImageIcon("logo2.png").getImage().getScaledInstance(280, 140, Image.SCALE_DEFAULT));
         JLabel label5 = new JLabel(Logo);
         label5.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
            	Fix_Frame.getDispose();
     			Fix_Frame.getInstance(new MainF());
             }
         });

         ImageIcon User = new ImageIcon(
                 new ImageIcon("logout.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
         JLabel label6 = new JLabel(User);
         label6.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
            	Fix_Frame.getDispose();
     			new Home();
             }
         });
        

         
         panel_S.add(label1); 
         panel_S.add(label2);
         
         panel_S.add(label3);
         
         panel_S.add(label4);
         
         
         panel_N.add(Box.createRigidArea(new Dimension(80, 0))); // 10 픽셀 간격을 줄 수 있습니다.
         panel_N.add(label5);
         panel_N.add(Box.createRigidArea(new Dimension(50, 0))); // 레이블5와 레이블6 사이의 간격
         panel_N.add(label6);
         
         panel_N.setBackground(new Color(187, 229, 255)); // 하늘색 배경 설정
         panel_S.setBackground(new Color(255, 255, 255)); 
         
         //e.add(panel_N, BorderLayout.NORTH);
         //e.add(panel_S, BorderLayout.SOUTH);
         panel_N.setBounds(0, 0, 600, 130);
         e.add(panel_N);
         panel_S.setBounds(-10, 615, 600, 150);
         e.add(panel_S);
  	}
  	public static JPanel getTopPanel() {
        // 상단 패널을 생성하고 반환합니다.
        JPanel panel_N = new JPanel();
        int width = 250;
        int height = 110;

        ImageIcon Logo = new ImageIcon(
                new ImageIcon("Logo.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        JLabel label5 = new JLabel(Logo);
        label5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Fix_Frame.getDispose();
                Fix_Frame.getInstance(new MainF());
            }
        });

        ImageIcon User = new ImageIcon(
                new ImageIcon("logout.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JLabel label6 = new JLabel(User);
        label6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
           	Fix_Frame.getDispose();
    			new Home();
            }
        });

        panel_N.add(Box.createRigidArea(new Dimension(100, 0))); // 10 픽셀 간격을 줄 수 있습니다.
        panel_N.add(label5);
        panel_N.add(Box.createRigidArea(new Dimension(100, 0))); // 레이블5와 레이블6 사이의 간격
        panel_N.add(label6);

        return panel_N;
    }
  	 public static JPanel getBottomPanel() {
         // 하단 패널을 생성하고 반환합니다.
         JPanel panel_S = new JPanel();
         int width = 130;
         int height = 110;

         // 이전
         ImageIcon back = new ImageIcon(
                 new ImageIcon("Back.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
         JLabel label1 = new JLabel(back);
         label1.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
            	Fix_Frame.getDispose();
            	new MainF();
             }
         });

         ImageIcon community = new ImageIcon(
                 new ImageIcon("Comm.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
         JLabel label2 = new JLabel(community);
         label2.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
            	Fix_Frame.getDispose();
            	try {
					new Community();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
             }
         });

         ImageIcon bucket = new ImageIcon(
                 new ImageIcon("check.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
         JLabel label3 = new JLabel(bucket);
         label3.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
            	Fix_Frame.getDispose();
            	new bucketlist();
             }
         });

         ImageIcon cal = new ImageIcon(
                 new ImageIcon("Cal.png").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
         JLabel label4 = new JLabel(cal);         

         panel_S.add(label1);
         panel_S.add(label2);
         panel_S.add(label3);
         panel_S.add(label4);

         return panel_S;
     }

	public static void getDispose() {
		instance.dispose();
	}
	
}
