package view;

import javax.swing.*;
import javax.swing.border.Border;

import design.RoundedButton;
import fix_frame.Fix_Frame;
//import sframe.FrameBase;
//import sframe.FrameButtonBar;
//import sframe.TradSulInfo;
//import sframe.LocalFrame.ChungcheongIntro;
//import sframe.LocalFrame.JejuIntro;
//import sframe.LocalFrame.JeonlaIntro;
//import sframe.LocalFrame.KangoneIntro;
//import sframe.LocalFrame.KyeongsangIntro;
//import sframe.LocalFrame.KyeonkiIntro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainF extends JPanel {
	private Image backgroundImage; // 배경 이미지를 위한 멤버 변수
	
    public MainF() {
    	/*
    	 // 이미지 로드
        ImageIcon icon = new ImageIcon("산 배경.png"); // 여기서 이미지 파일 경로를 적어주세요.
        backgroundImage = icon.getImage();
       
        
        // JPanel 구조
        setBackground(new Color(187, 229, 255));
        setLayout(null);
        
        // 버튼 생성 및 추가
        RoundedButton jeolla = new RoundedButton("전라도");
        jeolla.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 20));
        
        RoundedButton chunchung = new RoundedButton("충청도");
        chunchung.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 20));
        
        RoundedButton gyeonggi = new RoundedButton("경기도");
        gyeonggi.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 20));
        
        RoundedButton gangwon = new RoundedButton("강원도");
        gangwon.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 20));
        
        RoundedButton gyungsang = new RoundedButton("경상도");
        gyungsang.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 20));
        
        
        // 버튼의 크기와 위치 설정
        jeolla.setBounds(80, 480, 200, 50);
        chunchung.setBounds(80, 400, 200, 50);
        gyeonggi.setBounds(190, 320, 200, 50);
        gangwon.setBounds(300, 400, 200, 50);
        gyungsang.setBounds(300, 480, 200, 50);

        // 각 버튼에 액션 리스너 추가
        jeolla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fix_Frame.getDispose();
                Fix_Frame.getInstance(new Jeollado());
                System.out.println("전라도 클릭");
            }
        });

        chunchung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fix_Frame.getDispose();
                Fix_Frame.getInstance(new Choongchungdo());
                System.out.println("충청도 클릭");
            }
        });

        gyeonggi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fix_Frame.getDispose();
                Fix_Frame.getInstance(new Gyeongido());
                System.out.println("경기도 클릭");
            }
        });

        gangwon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fix_Frame.getDispose();
                Fix_Frame.getInstance(new Gangwondo());
                System.out.println("강원도 클릭");
            }
        });

        gyungsang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fix_Frame.getDispose();
                Fix_Frame.getInstance(new Gyeongsangdo());
                System.out.println("경상도 클릭");
            }
        });

        // 버튼을 패널에 추가
        add(jeolla);
        add(chunchung);
        add(gyeonggi);
        add(gangwon);
        add(gyungsang);
        setVisible(true);
    }

    // 배경 이미지를 그리기 위한 paintComponent 오버라이드
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        } */
    	
    	// JPanel 구조
    			setBackground(new Color(187, 229, 255));
    			//setBackground(new Color(204, 153, 102));
    			//ImageIcon icon = new ImageIcon("산 배경.png");
    			//backgroundImage = icon.getImage();
    			setLayout(null);
    			setSize(600, 800);

    			// 소개 제목
    			//ImageIcon introL = new ImageIcon("img/intro/lcTitle.png");
    			//JLabel introLc = new JLabel(introL);
    			//introLc.setSize(400, 80);
    			//introLc.setLocation(45, 20);
    			
    			//add(introLc);

    			// 지역 버튼 이미지 출력
    			ImageIcon kkBt = new ImageIcon("lc_kk.png");
    			ImageIcon kkBtr = new ImageIcon("lc_kkr.png");
    			ImageIcon koBt = new ImageIcon("lc_ko.png");
    			ImageIcon koBtr = new ImageIcon("lc_kor.png");
    			ImageIcon ccBt = new ImageIcon("lc_cc.png");
    			ImageIcon ccBtr = new ImageIcon("lc_ccr.png");
    			ImageIcon jlBt = new ImageIcon("lc_jl.png");
    			ImageIcon jlBtr = new ImageIcon("lc_jlr.png");
    			ImageIcon ksBt = new ImageIcon("lc_ks.png");
    			ImageIcon ksBtr = new ImageIcon("lc_ksr.png");
    			ImageIcon jjBt = new ImageIcon("lc_jj.png");
    			ImageIcon jjBtr = new ImageIcon("lc_jjr.png");

    			// 경기도
    			JButton btnKk = new JButton(kkBtr);
    			btnKk.setBackground(new Color(243, 244, 226));
    			btnKk.setSize(90, 125);
    			btnKk.setLocation(180, 175);
    			btnKk.setContentAreaFilled(false);
    			btnKk.setBorderPainted(false);
    			btnKk.setFocusPainted(false);
    			
    			// 경기도 버튼 롤오버
    			btnKk.setRolloverEnabled(getFocusTraversalKeysEnabled());
    			btnKk.setRolloverIcon(kkBt);

    			
    			// 강원도
    			JButton btnKo = new JButton(koBtr);
    			btnKo.setBackground(new Color(243, 244, 226));
    			btnKo.setSize(110, 100);
    			btnKo.setLocation(270, 170);
    			btnKo.setContentAreaFilled(false);
    			btnKo.setBorderPainted(false);
    			btnKo.setFocusPainted(false);
    			
    			// 강원도 버튼 롤오버
    			btnKo.setRolloverEnabled(getFocusTraversalKeysEnabled());
    			btnKo.setRolloverIcon(koBt);

    			
    			// 충청도
    			JButton btnCc = new JButton(ccBtr);
    			btnCc.setBackground(new Color(243, 244, 226));
    			btnCc.setSize(105, 90);
    			btnCc.setLocation(180, 300);
    			btnCc.setContentAreaFilled(false);
    			btnCc.setBorderPainted(false);
    			btnCc.setFocusPainted(false);
    			
    			// 충청도 버튼 롤오버
    			btnCc.setRolloverEnabled(getFocusTraversalKeysEnabled());
    			btnCc.setRolloverIcon(ccBt);

    			// 전라도
    			JButton btnJl = new JButton(jlBtr);
    			btnJl.setBackground(new Color(243, 244, 226));
    			btnJl.setSize(100, 160);
    			btnJl.setLocation(170, 390);
    			btnJl.setContentAreaFilled(false);
    			btnJl.setBorderPainted(false);
    			btnJl.setFocusPainted(false);
    			
    			// 전라도 버튼 롤오버
    			btnJl.setRolloverEnabled(getFocusTraversalKeysEnabled());
    			btnJl.setRolloverIcon(jlBt);
    			

    			// 경상도
    			JButton btnKs = new JButton(ksBtr);
    			btnKs.setBackground(new Color(243, 244, 226));
    			btnKs.setSize(130, 230);
    			btnKs.setLocation(290, 270);
    			btnKs.setContentAreaFilled(false);
    			btnKs.setBorderPainted(false);
    			btnKs.setFocusPainted(false);

    			// 경상도 버튼 롤오버
    			btnKs.setRolloverEnabled(getFocusTraversalKeysEnabled());
    			btnKs.setRolloverIcon(ksBt);
    			
    			
				/*
				 * // 제주도 JButton btnJj = new JButton(jjBtr); btnJj.setBackground(new Color(243,
				 * 244, 226)); btnJj.setSize(80, 40); btnJj.setLocation(160, 550 );
				 * btnJj.setContentAreaFilled(false); btnJj.setBorderPainted(false);
				 * btnJj.setFocusPainted(false);
				 */
    			
    			// 경상도 버튼 롤오버
    			//btnJj.setRolloverEnabled(getFocusTraversalKeysEnabled());
    			//btnJj.setRolloverIcon(jjBt);
    					

    			// 지역 버튼 삽입
    			add(btnKk);
    			add(btnKo);
    			add(btnCc);
    			add(btnJl);
    			add(btnKs);
    			//add(btnJj);
    			

    			// 지역 버튼 연결 이벤트
    			
    			btnKk.addActionListener(new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
    	                Fix_Frame.getDispose();
    	                Fix_Frame.getInstance(new Gyeongido());
    	                System.out.println("경기도 클릭");
    	            }
    	        });

    			btnKo.addActionListener(new ActionListener() {
    		            @Override
    		            public void actionPerformed(ActionEvent e) {
    		                Fix_Frame.getDispose();
    		                Fix_Frame.getInstance(new Gangwondo());
    		                System.out.println("강원도 클릭");
    		            }
    		        });

    			
    			btnCc.addActionListener(new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
    	                Fix_Frame.getDispose();
    	                Fix_Frame.getInstance(new Choongchungdo());
    	                System.out.println("충청도 클릭");
    	            }
    	        });
    			
    			btnJl.addActionListener(new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
    	                Fix_Frame.getDispose();
    	                Fix_Frame.getInstance(new Jeollado());
    	                System.out.println("전라도 클릭");
    	            }
    	        });
    			
    			btnKs.addActionListener(new ActionListener() {
    		            @Override
    		            public void actionPerformed(ActionEvent e) {
    		                Fix_Frame.getDispose();
    		                Fix_Frame.getInstance(new Gyeongsangdo());
    		                System.out.println("경상도 클릭");
    		            }
    		        });
    			
    			

    			//btnJj.addActionListener(new ActionListener() {

    			//	@Override
    			//	public void actionPerformed(ActionEvent e) {
    					
    			//		FrameBase.getInstance(new JejuIntro("제주"));

    			//	}
    			//});

    			// 뒤로가기
    			//ImageIcon back = new ImageIcon("img/backBtn.png");
    			//ImageIcon backr = new ImageIcon("img/backBtnR.png");
    			//JButton btnBck = new JButton(back);
    			//btnBck.setSize(240, 60);
    			//btnBck.setLocation(((int) getSize().getWidth() / 2) - 120, 
    			//		(int) getLocation().getY() / 2 + 620);
    			//btnBck.setContentAreaFilled(false);
    			//btnBck.setBorderPainted(false);
    			//btnBck.setFocusPainted(false);
    			
    			// 뒤로가기 버튼 롤오버
    			//btnBck.setRolloverEnabled(getFocusTraversalKeysEnabled());
    			//btnBck.setRolloverIcon(backr);

    			//add(btnBck);
    			
    			//btnBck.addActionListener(new ActionListener() {

    			//	@Override
    			//	public void actionPerformed(ActionEvent e) {
    			//		FrameBase.getDispose();
    			//		FrameBase.getInstance(new TradSulInfo());

    			//	}
    			//});
    			

    			// 하단 메뉴바
    			//FrameButtonBar fr_UnderBtn = new FrameButtonBar();
    			//add(fr_UnderBtn);

    			// 지도 이미지 삽입
    			//ImageIcon sulMap = new ImageIcon("map.png");
    			ImageIcon sulMap = new ImageIcon(new ImageIcon("map2.png").getImage().getScaledInstance(340,450,  Image.SCALE_DEFAULT));
    			//JLabel sulLocal = new JLabel(sulMap);
    			//sulLocal.setSize(340, 500);
    			//sulLocal.setLocation(120, 110);
    			//add(sulLocal);
    			
    			//ImageIcon sulMap = new ImageIcon("map.png");
    			JLabel sulLocal = new JLabel(sulMap);
    			sulLocal.setSize(340, 500);
    			sulLocal.setLocation(120, 110);
				/*
				 * // Border 생성 (둥근 테두리) Border roundedBorder =
				 * BorderFactory.createLineBorder(Color.BLACK, 5, true);
				 * sulLocal.setBorder(roundedBorder);
				 * 
				 * // 컴포넌트의 모서리를 둥글게 만듭니다.
				 * sulLocal.setBorder(BorderFactory.createEtchedBorder(Color.WHITE,
				 * Color.BLACK));
				 * 
				 * // 컴포넌트의 내용 영역에 테두리를 그리지 않습니다. sulLocal.setBorderPainted(false);
				 * 
				  
				 */
    			add(sulLocal);
    			// 포스터 이미지
    			//ImageIcon backG = new ImageIcon("img/Sub_BG.png");
    			//JLabel lblbackG = new JLabel(backG);
    			//lblbackG.setSize(500, 800);
    			//lblbackG.setLocation(0, 0);
    			//add(lblbackG);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
