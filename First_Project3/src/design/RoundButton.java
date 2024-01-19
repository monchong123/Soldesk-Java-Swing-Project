package design;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.io.File;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
//import java.io.File;


public class RoundButton extends JButton { 
	
	public RoundButton() { 
		super(); 
		loadCustomFont();
		decorate(); 
	} 
	
	public RoundButton(String text) { 
		super(text); 
		loadCustomFont();
		decorate(); 
		
	} 
	
	public RoundButton(Action action) { 
		super(action);
		loadCustomFont();
		decorate(); 
		
	} 
	
	public RoundButton(Icon icon) { 
		super(icon);
		loadCustomFont();
		decorate(); 
		
	} 
	
	public RoundButton(String text, Icon icon) { 
		super(text, icon); 
		loadCustomFont();
		decorate(); 
		
	} 
	
	private void loadCustomFont() {
        try {
            File fontFile = new File("NPSfont_extrabold.ttf"); // 폰트 파일 경로
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            setFont(customFont.deriveFont(Font.PLAIN, 16)); // 크기 15로 설정 (원하는 크기로 변경)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	protected void decorate() { 
		setBorderPainted(false); 
		setOpaque(false); 
		
	} 
	
	@Override 
	protected void paintComponent(Graphics g) { 
		 loadCustomFont();
		 Color c = new Color(216, 237, 231); //버튼배경색 결정
         Color o=Color.BLACK; //글자색 결정
         //Font font = new Font(getFont().getName(), Font.BOLD, getFont().getSize()); // 굵은체 글꼴 설정

		
        int width = getWidth(); 	
		int height = getHeight(); 
		Graphics2D graphics = (Graphics2D) g; 
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		
		if (getModel().isArmed()) { 
			graphics.setColor(c); 
			//graphics.setFont(font);
			
		} else if (getModel().isRollover()) { 
			//graphics.setColor(new Color(187,229,255));
			graphics.setColor(c.brighter()); 
			
		} else { 
			graphics.setColor(c); 
			
		} 
		
		graphics.fillRoundRect(0, 0, width, height, 10, 10); 
		FontMetrics fontMetrics = graphics.getFontMetrics(); 
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
		int textX = (width - stringBounds.width) / 2; 
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
		graphics.setColor(o); 
		graphics.setFont(getFont()); 
		graphics.drawString(getText(), textX, textY); 
		graphics.dispose(); super.paintComponent(g); 
		
	}

	
	
	
	
}
