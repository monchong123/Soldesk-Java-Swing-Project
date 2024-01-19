package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import design.RoundedButton;
import fix_frame.Fix_Frame;

import java.awt.event.ItemEvent;    
import java.awt.event.ItemListener;  

public class bucketlist extends JPanel {
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private List<JComboBox<Integer>> comboBoxes; // comboBoxes 리스트 추가
    private boolean isModified = false; // 변경 사항이 있는지를 저장하는 변수

    public bucketlist() {
        this(null);
        
    }
    
    
    public bucketlist(String[] items) {
        // JPanel 구조
        setBackground(new Color(187, 229, 255));
        setLayout(null);
        setVisible(true);

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        
        //리스트의 글씨 크기조절
        list.setFont(new Font(list.getFont().getName(), list.getFont().getStyle(), 18));
        
        

        if (items != null) {
            for (String item : items) {
                listModel.addElement(item); // itemList에 있는 항목을 리스트에 추가
            }
        }

        comboBoxes = new ArrayList<>(); // comboBoxes 리스트 초기화
        
        
        // 파일에서 북마크 정보 불러오기
        loadBookmarks();

    
       

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(30, 150, 450, 420); // 리스트의 위치와 크기를 설정
        add(scrollPane);
        
        // 저장 버튼 추가
        RoundedButton saveButton = new RoundedButton("저장");
        saveButton.setBounds(330, 575, 80, 30);
        add(saveButton);
        
       

     // 저장 버튼 클릭 이벤트 처리
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isModified) { // 만약 변경 사항이 있다면
                    saveBookmarks(); // 변경 사항을 파일에 저장합니다.
                    loadBookmarks(); // UI를 업데이트하여 정렬된 목록을 바로 보여줍니다.
                    isModified = false; // 변경 사항을 저장했으므로 isModified를 false로 설정합니다.
                }
            }
        });
        
        // 리셋 버튼 추가
        RoundedButton resetButton = new RoundedButton("리셋");
        resetButton.setBounds(410, 575, 80, 30);
        add(resetButton);

        // 리셋 버튼 클릭 이벤트 처리
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetBookmarks(); // 리셋 버튼 클릭 시 북마크 정보 리셋
            }
        });
        
        // 삭제 버튼 추가
        RoundedButton deleteButton = new RoundedButton("삭제");
        deleteButton.setBounds(490, 575, 80, 30);
        add(deleteButton);
        
        // 삭제 버튼 클릭 이벤트 처리
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               deleteBookmarks(); // 리셋 버튼 클릭 시 북마크 정보 리셋 
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
               Fix_Frame.getDispose();
                Fix_Frame.getInstance(new MainF());
               
            }
        });
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // 더블 클릭
                    int selectedIndex = list.getSelectedIndex();
                    if (selectedIndex >= 0) {
                        String selectedName = listModel.getElementAt(selectedIndex);
                        // Info 클래스에 선택된 이름을 전달하여 해당하는 정보 화면을 표시
                        Fix_Frame.getDispose();
                        Fix_Frame.getInstance(new Info(null, selectedName));
                        System.out.println(selectedName);
                    }
                }
            }
        });
    }
    
    private void loadBookmarks() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("bookmark.txt"));
            String line;
            Map<String, Integer> tempBookmarksWithRank = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" "); 

                if (parts.length > 1) {
                    String rankStr = parts[1].replaceAll("[^0-9]", "");
                    int rank = Integer.parseInt(rankStr);
                    tempBookmarksWithRank.put(parts[0], rank);
                }
            }
            reader.close();

            // 순위를 기준으로 정렬
            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(tempBookmarksWithRank.entrySet());
            sortedEntries.sort(Map.Entry.comparingByValue());

            listModel.clear();
            for (JComboBox<Integer> comboBox : comboBoxes) {
                this.remove(comboBox);
            }
            comboBoxes.clear();

            // 정렬된 항목을 listModel 및 comboBoxes에 추가
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                listModel.addElement(entry.getKey());

                JComboBox<Integer> comboBox = new JComboBox<>(new DefaultComboBoxModel<>(new Integer[]{0, 1, 2, 3, 4, 5}));
                comboBox.setSelectedIndex(entry.getValue());
                
                comboBox.setBounds(490, 150 + (listModel.size() - 1) * 27, 50, 20);
                
             // 여기서 JComboBox의 높이를 가져와 JList의 항목 높이로 설정합니다.
                int comboBoxHeight = comboBox.getPreferredSize().height;
                list.setFixedCellHeight(comboBoxHeight);
          

                comboBox.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            isModified = true;
                        }
                    }
                });

                comboBoxes.add(comboBox);
                add(comboBox);
            }

            this.revalidate();
            this.repaint();

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    
    private void saveBookmarks() {
        try {
            // 모든 현재 UI의 북마크와 콤보 박스 값을 가져와서 맵에 저장
            Map<String, Integer> currentBookmarkMap = new HashMap<>();
            for (int i = 0; i < listModel.getSize(); i++) {
                String bookmark = listModel.getElementAt(i);
                int comboBoxIndex = comboBoxes.get(i).getSelectedIndex();
                currentBookmarkMap.put(bookmark, comboBoxIndex);
            }

            // 순위를 기준으로 정렬
            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(currentBookmarkMap.entrySet());
            sortedEntries.sort(Map.Entry.comparingByValue());

            // 정렬된 순서대로 파일에 기록
            BufferedWriter writer = new BufferedWriter(new FileWriter("bookmark.txt"));
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                writer.write(entry.getKey() + " " + entry.getValue() + "순위");
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        isModified = true;
    }
    
    private void resetBookmarks() {
        // bookmark.txt 파일을 삭제하여 리셋
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("bookmark.txt"));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 리스트 초기화
        listModel.removeAllElements();
        
        // 모든 콤보박스를 패널에서 제거하고 comboBoxes 리스트 초기화
        for (JComboBox<Integer> comboBox : comboBoxes) {
            this.remove(comboBox);
        }
        comboBoxes.clear();
        
        // UI 갱신
        this.revalidate();
        this.repaint();
    }
    
    
    private void deleteBookmarks() {
        int selectedIndex = list.getSelectedIndex();
        if (selectedIndex >= 0) {
            // 선택된 항목의 인덱스를 가져오기
            listModel.remove(selectedIndex); // 리스트에서 항목 제거

            JComboBox<Integer> toRemoveComboBox = comboBoxes.remove(selectedIndex); // comboBoxes에서 해당 항목의 콤보박스 제거
            this.remove(toRemoveComboBox); // JPanel에서 콤보박스 제거

            // 이 부분은 다른 콤보박스들의 위치를 업데이트하기 위해 사용됩니다. 삭제된 항목 아래의 모든 콤보박스를 위로 이동시킵니다.
            for (int i = selectedIndex; i < comboBoxes.size(); i++) {
                JComboBox<Integer> comboBox = comboBoxes.get(i);
                comboBox.setBounds(490, 150 + (i * 30), 50, 20);
            }

            this.revalidate(); // UI를 갱신하여 콤보박스 제거 반영
            this.repaint(); // UI 다시 그리기

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("bookmark.txt"));
                for (int i = 0; i < listModel.getSize(); i++) {
                    String bookmark = listModel.getElementAt(i);
                    int comboBoxIndex = comboBoxes.get(i).getSelectedIndex(); // 드롭 박스에서 선택한 인덱스 가져오기
                    writer.write(bookmark + " " + comboBoxIndex + "순위"); // 북마크와 선택된 드롭 박스 값을 저장
                    writer.newLine();
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
 // 새롭게 추가된 saveBookmarks 메서드. 특정 산의 이름과 순위를 저장합니다.
    public void saveBookmarks(String mountainName, int rank) {
        // 산 이름이 이미 listModel에 있는지 확인
        if (listModel.contains(mountainName)) {
            return; // 이미 있으면 메서드 종료
        }

        try {
            // 모든 현재 UI의 북마크와 콤보 박스 값을 가져와서 맵에 저장
            Map<String, String> currentBookmarkMap = new HashMap<>();
            for (int i = 0; i < listModel.getSize(); i++) {
                String bookmark = listModel.getElementAt(i);
                int comboBoxIndex = comboBoxes.get(i).getSelectedIndex();
                currentBookmarkMap.put(bookmark, comboBoxIndex + "순위");
            }

            // 새로운 산을 북마크에 추가
            currentBookmarkMap.put(mountainName, rank + "순위");

            // 새로운 파일을 작성하여 현재 UI의 모든 북마크와 콤보 박스 값을 기록
            BufferedWriter writer = new BufferedWriter(new FileWriter("bookmark.txt"));
            for (Map.Entry<String, String> entry : currentBookmarkMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
            writer.close();
            
            // UI 갱신 코드
            listModel.addElement(mountainName); // 산 이름 추가
            JComboBox<Integer> comboBox = new JComboBox<>(new DefaultComboBoxModel<>(new Integer[]{0, 1, 2, 3, 4, 5}));
            comboBox.setSelectedIndex(rank);
            comboBox.setBounds(490, 150 + (listModel.size() - 1) * 30, 50, 20);
            comboBoxes.add(comboBox);
            add(comboBox);
            this.revalidate(); // UI 갱신
            this.repaint(); // UI 다시 그리기

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
 // 산의 이름과 순위를 UI에만 저장하도록 수정된 메서드
    public void addBookmarkToUI(String mountainName, int rank) {
        if (listModel.contains(mountainName)) {
            return;
        }

        // UI 갱신 코드
        listModel.addElement(mountainName); // 산 이름 추가
        JComboBox<Integer> comboBox = new JComboBox<>(new DefaultComboBoxModel<>(new Integer[]{0, 1, 2, 3, 4, 5}));
        comboBox.setSelectedIndex(0);
        comboBox.setBounds(490, 150 + (listModel.size() - 1) * 30, 50, 20);
        comboBoxes.add(comboBox);
        add(comboBox);
        this.revalidate(); // UI 갱신
        this.repaint(); // UI 다시 그리기
        
        isModified = true; // 데이터가 변경되었음을 나타냄
    }
}


