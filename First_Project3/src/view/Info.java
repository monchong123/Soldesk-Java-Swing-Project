package view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static view.Constant.EXPLANATION;
import static view.Constant.LEVEL_BASIC;
import static view.Constant.MOUNTAIN_NAME_BASIC;
import static view.Constant.PLACE_URL_BASIC;
import static view.Constant.ROAD_ADDRESS_NAME_BASIC;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MountainDB.MountainInfo;
import MountainDB.MountainList;
import design.CustomFont;
import fix_frame.Fix_Frame;

public class Info extends JPanel { // 산 정보가 보여지는 창
    public List<String> itemList; // 항목을 저장할 ArrayList

    public Info() {
        this(null, null);
    }

    public Info(ActionEvent e, String string) {
        if (itemList == null) {
             itemList = new ArrayList<>(); // itemList 초기화 (최초 생성 시에만)
         }
        // JPanel 구조
        setBackground(new Color(187, 229, 255));
        setLayout(null);
        MountainList mountainlist = new MountainList();
        // 이미지 부분
        // 선택한 산 이름에 해당하는 정보 가져오기
        MountainInfo selectedMountain = null;
        String doname = null;
        String place = null;
        for (MountainInfo info : mountainlist.Info()) {
            if (info.getMountainName().equals(string)) {
                selectedMountain = info;
                break;
            }
        }

        if (selectedMountain != null) {
        	ImageIcon originalIcon = new ImageIcon(selectedMountain.getImageUrl());
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(364, 280, Image.SCALE_SMOOTH);
            ImageIcon mountainImage = new ImageIcon(scaledImage);
            JLabel fImage=new JLabel(mountainImage);
            fImage.setSize(364, 280);
            fImage.setLocation(18, 140);
            add(fImage);
            doname = selectedMountain.getDoname();
            place = selectedMountain.getPlaceUrl();
            final String finalplace = place; // final 변수로 선언
            final String finaldoname = doname; // final 변수로 선언

            JLabel story = new JLabel("<html><body>" + MOUNTAIN_NAME_BASIC + selectedMountain.getMountainName() + "<br>"
                    + ROAD_ADDRESS_NAME_BASIC + selectedMountain.getPlace() + "<br>" + LEVEL_BASIC
                    + selectedMountain.getLevel() + "<br>" + PLACE_URL_BASIC + "<a href='"
                    + selectedMountain.getPlaceUrl() + "'>" + selectedMountain.getPlaceUrl() + "</a><br>" + EXPLANATION
                    + selectedMountain.getExplanation() + "</body></html>");
            
            Font customFont = CustomFont.suiteFont(11); 
            story.setFont(customFont);
            final String temp = selectedMountain.getMountainName();
            story.setSize(580, 185);
            story.setLocation(10, 430);
            story.setBackground(new Color(255, 255, 255));

            // 클릭 가능한 링크를 처리하는 MouseAdapter 추가
            story.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(new URI(finalplace));
                        } catch (IOException | URISyntaxException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
            add(story);

            ImageIcon book = new ImageIcon("Bookmark.png");
            Image bookmark1 = book.getImage();
            Image scaleBm = bookmark1.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            ImageIcon bookBtn = new ImageIcon(scaleBm);
            JButton bookmark = new JButton(bookBtn);
            bookmark.setBounds(530, 140, 30, 30);
            bookmark.setBorderPainted(false);
            bookmark.setContentAreaFilled(false);
            bookmark.setFocusPainted(false);
            add(bookmark);

            bookmark.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!isMountainNameExistInFile(temp)) {
                        Fix_Frame.getDispose();
                        
                        bucketlist bucketListPanel = new bucketlist();
                        bucketListPanel.addBookmarkToUI(temp, 3); // bucketlist UI에만 산 이름 추가

                        Fix_Frame.getInstance(bucketListPanel);
                    }
                }
            });

            // 뒤로가기 버튼
            JButton back = new JButton("");
            back.setBounds(30, 620, 100, 100);
            back.setBorderPainted(false);
            back.setContentAreaFilled(false);
            back.setFocusPainted(false);
            add(back);
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                    if ("경기도".equals(finaldoname)) {
                        Fix_Frame.getDispose();
                        Fix_Frame.getInstance(new Gyeongido());
                    } else if ("경상도".equals(finaldoname)) {
                        Fix_Frame.getDispose();
                        Fix_Frame.getInstance(new Gyeongsangdo());
                    } else if ("충청도".equals(finaldoname)) {
                        Fix_Frame.getDispose();
                        Fix_Frame.getInstance(new Choongchungdo());
                    } else if ("강원도".equals(finaldoname)) {
                        Fix_Frame.getDispose();
                        Fix_Frame.getInstance(new Gangwondo());
                    } else if ("전라도".equals(finaldoname)) {
                        Fix_Frame.getDispose();
                        Fix_Frame.getInstance(new Jeollado());
                    }
                }
            });
        }
    }

    public void addItem(String item) {
        if (item != null && !item.isEmpty()) {
            itemList.add(item); // ArrayList에 값 추가
        }
    }
    public void saveBookmark(String mountainName) {
        List<String> existingBookmarks = new ArrayList<>();
        
        // bookmark.txt에서 현재 북마크들을 읽어오기
        try (BufferedReader reader = new BufferedReader(new FileReader("bookmark.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                existingBookmarks.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 산의 이름이 리스트에 이미 있다면 추가하지 않음
        if (!existingBookmarks.contains(mountainName)) {
            existingBookmarks.add(mountainName);
        }

        // 수정된 북마크 리스트를 다시 파일에 쓰기
        try (FileWriter writer = new FileWriter("bookmark.txt")) {
            for (String bookmark : existingBookmarks) {
                writer.write(bookmark + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean isMountainNameExistInFile(String mountainName) {
        File file = new File("bookmark.txt");
        if (!file.exists()) {
            return false;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(mountainName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}