package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import MountainDB.MountainList;
import fix_frame.Fix_Frame;

public class Choongchungdo extends JPanel{
	   private Image backgroundImage; // 배경 이미지를 위한 멤버 변수
	   private JLabel label;
	   
	   public Choongchungdo() {       
	      this(null);      
	   }
	   public Choongchungdo(JPanel e) {
	      
	       // 이미지 로드
	        ImageIcon icon = new ImageIcon("산 배경.png"); // 여기서 이미지 파일 경로를 적어주세요.
	        backgroundImage = icon.getImage();
	      // JPanel 구조
	        setBackground(new Color(187, 229, 255));
	        setLayout(null);
	        
	        
	        //소백산
	        ImageIcon gpsIcon1 = new ImageIcon("pin.png");
	        Image gps1a = gpsIcon1.getImage();
	        Image scaleGps1 = gps1a.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	        ImageIcon gpsBtn1 = new ImageIcon(scaleGps1);
	        JButton gps1 = new JButton(gpsBtn1);
	        gps1.setBounds(400, 240, 30, 30);      
	        gps1.setBorderPainted(false);   
	        gps1.setContentAreaFilled(false);
	        gps1.setFocusPainted(false);
	        JLabel label1 = new JLabel("소백산");
	        label1.setBounds(400, 270, 60, 30);
	        add(label1);
	        
	        
	        //계룡산
	        ImageIcon gpsIcon2 = new ImageIcon("pin.png");
	        Image gps2a = gpsIcon2.getImage();
	        Image scaleGps2 = gps2a.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	        ImageIcon gpsBtn2 = new ImageIcon(scaleGps2);
	        JButton gps2 = new JButton(gpsBtn2);
	        gps2.setBounds(220, 430, 30, 30);      
	        gps2.setBorderPainted(false);   
	        gps2.setContentAreaFilled(false);
	        gps2.setFocusPainted(false);
	        JLabel label2 = new JLabel("계룡산");
	        label2.setBounds(220, 460, 60, 30);
	        add(label2);
	        
	        
	        //칠갑산
	        ImageIcon gpsIcon3 = new ImageIcon("pin.png");
	        Image gps3a = gpsIcon3.getImage();
	        Image scaleGps3 = gps3a.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	        ImageIcon gpsBtn3 = new ImageIcon(scaleGps3);
	        JButton gps3 = new JButton(gpsBtn3);
	        gps3.setBounds(170, 370, 30, 30);       
	        gps3.setBorderPainted(false);   
	        gps3.setContentAreaFilled(false);
	        gps3.setFocusPainted(false);
	        JLabel label3 = new JLabel("칠갑산");
	        label3.setBounds(170, 400, 60, 30);
	        add(label3);
	        
	        
	        //용봉산
	        ImageIcon gpsIcon4 = new ImageIcon("pin.png");
	        Image gps4a = gpsIcon4.getImage();
	        Image scaleGps4 = gps4a.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	        ImageIcon gpsBtn4 = new ImageIcon(scaleGps4);
	        JButton gps4 = new JButton(gpsBtn4);
	        gps4.setBounds(130, 300, 30, 30);       
	        gps4.setBorderPainted(false);   
	        gps4.setContentAreaFilled(false);
	        gps4.setFocusPainted(false);
	        JLabel label4 = new JLabel("용봉산");
	        label4.setBounds(130, 330, 60, 30);
	        add(label4);
	        
	        
	        //속리산
	        ImageIcon gpsIcon5 = new ImageIcon("pin.png");
	        Image gps5a = gpsIcon5.getImage();
	        Image scaleGps5 = gps5a.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	        ImageIcon gpsBtn5 = new ImageIcon(scaleGps5);
	        JButton gps5 = new JButton(gpsBtn5);
	        gps5.setBounds(300, 300, 30, 30);        
	        gps5.setBorderPainted(false);   
	        gps5.setContentAreaFilled(false);
	        gps5.setFocusPainted(false);
	        JLabel label5 = new JLabel("속리산");
	        label5.setBounds(300, 330, 60, 30);
	        add(label5);
	        
	        //랜덤주사위버튼
	        ImageIcon ran = new ImageIcon("dice.png");
	        Image ran1a = ran.getImage();
	        Image scaleRan = ran1a.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	        ImageIcon ranBtn = new ImageIcon(scaleRan);
	        JButton random = new JButton(ranBtn);
	        random.setBounds(520, 520, 40, 40);        
	        random.setBorderPainted(false);   
	        random.setContentAreaFilled(false);
	        random.setFocusPainted(false);
	        
	        JButton back = new JButton("");
	        back.setBounds(30, 620, 100, 100);     
	        back.setBorderPainted(false);   
	        back.setContentAreaFilled(false);
	        back.setFocusPainted(false);
	        
	        add(gps1);
	        add(gps2); 
	        add(gps3);
	        add(gps4);
	        add(gps5);
	        add(back);
	        add(random);
	        
	        random.addActionListener(new ActionListener() {         
	         @Override
	         public void actionPerformed(ActionEvent e) {
	             String[] mountainNames = {"소백산", "계룡산", "칠갑산", "용봉산", "속리산"};

	                 // 랜덤으로 산 이름 선택
	                 int randomIndex = (int) (Math.random() * mountainNames.length);
	                 String selectedMountainName = mountainNames[randomIndex];

	                 Fix_Frame.getDispose();
	                 Fix_Frame.getInstance(new Info(e, selectedMountainName));
	         }
	      });
	        
	        back.addActionListener(new ActionListener() {         
	         @Override
	         public void actionPerformed(ActionEvent e) {
	             Fix_Frame.getDispose();
	                Fix_Frame.getInstance(new MainF());
	         }
	      });
	        label = new JLabel();
	        label.setBounds(90, 100, 500, 500); // 위치와 크기 설정
	        add(label);      
	      
	      setImage("충청도.png");
	      
	        gps1.addActionListener(new ActionListener() {            
	           @Override
	            public void actionPerformed(ActionEvent e) {
	               Fix_Frame.getDispose();
	                
	            Fix_Frame.getInstance(new Info(e,"소백산"));
	            }
	      });        
	        gps2.addActionListener(new ActionListener() {            
	           @Override
	            public void actionPerformed(ActionEvent e) {
	               Fix_Frame.getDispose();
	                Fix_Frame.getInstance(new Info(e,"계룡산"));
	            }
	      });      
	        gps3.addActionListener(new ActionListener() {            
	           @Override
	            public void actionPerformed(ActionEvent e) {
	               Fix_Frame.getDispose();
	                
	            Fix_Frame.getInstance(new Info(e,"칠갑산"));
	            }
	      });
	        gps4.addActionListener(new ActionListener() {            
	           @Override
	            public void actionPerformed(ActionEvent e) {
	               Fix_Frame.getDispose();
	                
	            Fix_Frame.getInstance(new Info(e,"용봉산"));
	            }
	      });
	        
	        gps5.addActionListener(new ActionListener() {            
	           @Override
	            public void actionPerformed(ActionEvent e) {
	               Fix_Frame.getDispose();
	                
	            Fix_Frame.getInstance(new Info(e,"속리산"));
	            }
	      });
	        
	   }
	   private void setImage(String imagePath) {
	        try {
	            BufferedImage image = ImageIO.read(new File(imagePath));
	             Image scaledImage = image.getScaledInstance(500, 500, Image.SCALE_SMOOTH); // 이미지 크기 변경
	             ImageIcon icon = new ImageIcon(scaledImage);
	             label.setIcon(icon);
	             
	          // 테두리를 만들고 적용
	              //Border border = BorderFactory.createLineBorder(new Color(125, 82, 133), 5);
	             
	             //label.setBorder(border);

	          // 이미지 크기에 맞게 label 크기 설정
	             label.setBounds(30, 130, scaledImage.getWidth(this), scaledImage.getHeight(this));

	            // label.setBorder(border);
	             label.setIcon(icon);
	             
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	     // FrameGetMountainInfo 클래스 호출 메서드
	    private void callFrameGetMountainInfo(MountainList mountainlist, int mountainIndex) {
	        Fix_Frame.getDispose();
	        Fix_Frame.getInstance(new FrameGetMountainInfo(mountainlist, mountainIndex));
	    }
	    
	 // 배경 이미지를 그리기 위한 paintComponent 오버라이드
	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        if (backgroundImage != null) {
	            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
	        }
	    }
	}
