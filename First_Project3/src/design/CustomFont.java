package design;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

public class CustomFont {

    public static Font loadFont(float size) {
        try {
            // 현재 디렉토리에서 폰트 파일을 로드합니다.
            File fontFile = new File("NPSfont_extrabold.ttf");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            return customFont.deriveFont(Font.PLAIN, size);
        } catch (Exception e) {
            e.printStackTrace();
            // 에러 발생 시 기본 폰트를 반환하거나 적절한 대체 폰트를 반환할 수 있습니다.
            return new Font("Arial", Font.PLAIN, (int)size);
        }
    }
    
    public static Font suiteFont(float size) {
        try {
            // 현재 디렉토리에서 폰트 파일을 로드합니다.
            File fontFile = new File("SUITE-Medium.ttf");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            return customFont.deriveFont(Font.BOLD, size);
        } catch (Exception e) {
            e.printStackTrace();
            // 에러 발생 시 기본 폰트를 반환하거나 적절한 대체 폰트를 반환할 수 있습니다.
            return new Font("Arial", Font.PLAIN, (int)size);
        }
    }
    
    
}