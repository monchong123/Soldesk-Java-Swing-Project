package view;

import javax.swing.*;

import fix_frame.Fix_Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DoSelected extends JPanel {
    private JLabel label;

    public DoSelected(String regionName) {
        setLayout(null);

        label = new JLabel();
        label.setBounds(90, 100, 500, 500); // 위치와 크기 설정
        add(label);

        // 지역 이름에 따라 이미지 설정
        if (regionName.equals("전라도")) {
            setImage("jeolla.png");
            
            ImageIcon gpsIcon1 = new ImageIcon("Bookmark.png");
            Image gps1a = gpsIcon1.getImage();
            Image scaleGps1 = gps1a.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            ImageIcon gpsBtn1 = new ImageIcon(scaleGps1);
            JButton gps1 = new JButton(gpsBtn1);
            gps1.setBounds(400, 400, 30, 30);
            add(gps1);
            
            gps1.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					Fix_Frame.getDispose();
	     			Fix_Frame.getInstance(new Info());
				}
			});
            
            ImageIcon gpsIcon2 = new ImageIcon("Bookmark.png");
            Image gps2a = gpsIcon2.getImage();
            Image scaleGps2 = gps2a.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            ImageIcon gpsBtn2 = new ImageIcon(scaleGps2);
            JButton gps2 = new JButton(gpsBtn2);
            gps2.setBounds(250, 200, 30, 30);
            add(gps2); 
            
            
            
        } else if (regionName.equals("충청도")) {
            setImage("choongchung.png");
        } else if (regionName.equals("경기도")) {
            setImage("gyeongi.png");
        } else if (regionName.equals("강원도")) {
            setImage("gangwon.png");
        } else if (regionName.equals("경상도")) {
            setImage("gyeongsang.png");
        }
    }

    // 이미지 설정하는 메서드
    private void setImage(String imagePath) {
        try {
        	 BufferedImage image = ImageIO.read(new File(imagePath));
             Image scaledImage = image.getScaledInstance(400, 400, Image.SCALE_SMOOTH); // 이미지 크기 변경
             ImageIcon icon = new ImageIcon(scaledImage);
             label.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
