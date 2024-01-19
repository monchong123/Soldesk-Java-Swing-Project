package view;
import static view.Constant.MOUNTAIN_NAME_BASIC;
import static view.Constant.ROAD_ADDRESS_NAME_BASIC;
import static view.Constant.LEVEL_BASIC;
import static view.Constant.PLACE_URL_BASIC;
import static view.Constant.EXPLANATION;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MountainDB.MountainList;


public class FrameGetMountainInfo extends JPanel{
	
	public FrameGetMountainInfo(MountainList mountainlist, int i) {
		// JPanel 구조
        setBackground(new Color(187, 229, 255));
        setLayout(null);        
        setSize(400, 700);
        
      //JLabel fImage=new JLabel(HtmlUtils.imgHtmlParser(mountainlist.Info().get(0).getImageUrl()));
        ImageIcon originalIcon = new ImageIcon(mountainlist.Info().get(i).getImageUrl());
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(364, 280, Image.SCALE_SMOOTH);
        ImageIcon mountainImage = new ImageIcon(scaledImage);
        JLabel fImage=new JLabel(mountainImage);
        fImage.setSize(364,280);
        fImage.setLocation(18,70);
        add(fImage);
        JLabel story = new JLabel("<HTML><body>"+ MOUNTAIN_NAME_BASIC + mountainlist.Info().get(i).getMountainName()+"<br>"
        							+ROAD_ADDRESS_NAME_BASIC+mountainlist.Info().get(i).getPlace()+"<br>"+
        							LEVEL_BASIC+mountainlist.Info().get(i).getLevel()+"<br>"+
        							PLACE_URL_BASIC+mountainlist.Info().get(i).getPlaceUrl()+"<br>"+
        							EXPLANATION+mountainlist.Info().get(i).getExplanation());
  
		story.setSize(580, 185);
		story.setLocation(20, 350);
		story.setBackground(new Color(255, 255, 255));
		add(story);
	}
}
