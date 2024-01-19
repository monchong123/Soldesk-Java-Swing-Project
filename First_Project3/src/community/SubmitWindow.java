package community;

import javax.swing.*;

import design.RoundedButton;
import fix_frame.Fix_Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubmitWindow {

    JFrame frame;

    private JPanel contentPane;
    private JTextField titleTextField;
    private JTextField nameTextField;

    static String save = "BoardDetail";    // 작성한 글을 저장할 디렉토리
    static String filePath = "NoticeDTO.txt"; // 게시판 일부 사항을 저장할 파일

    public SubmitWindow() {

        frame = new JFrame();
        frame.setTitle("새글 등록하기");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //frame.setSize(650, 500); // Set the frame size
        frame.setBounds(150, 100, 650, 500);
        contentPane = new JPanel();
        frame.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout()); 

        Font font = new Font("굴림", Font.PLAIN, 13);
        Font fontButton = new Font("굴림", Font.PLAIN, 17);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        JLabel titleLbl = new JLabel("\uC81C \uBAA9");
        titleLbl.setFont(font);
        topPanel.add(titleLbl);
        titleTextField = new JTextField("");    // 제목 글 작성 필드
        titleTextField.setColumns(30);
        topPanel.add(titleTextField);
        contentPane.add(topPanel, BorderLayout.NORTH);

        JTextPane detailTextPane = new JTextPane();    // 상세 글 내용 작성 필드
        JScrollPane scrollArea = new JScrollPane(detailTextPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);    // 스크롤 여부 옵션 부여
        contentPane.add(scrollArea, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout()); // Use BorderLayout for bottom panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout for input fields
        JLabel nameLbl = new JLabel("\uC791\uC131\uC790");
        nameLbl.setFont(font);
        inputPanel.add(nameLbl);
        nameTextField = new JTextField();    // 이름 넣을 텍스트 필드
        nameTextField.setColumns(10);
        inputPanel.add(nameTextField);
        JLabel dateLbl = new JLabel("\uB4F1\uB85D\uC77C");
        dateLbl.setFont(font);
        inputPanel.add(dateLbl);
        Date now = new Date();    // 현재 시각을 불러와, 글 작성 시간 등록
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strNow2 = sdf.format(now);
        JLabel nowDateLbl = new JLabel(strNow2);
        nowDateLbl.setFont(font);
        inputPanel.add(nowDateLbl);
        bottomPanel.add(inputPanel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(); 
        RoundedButton submitBtn = new RoundedButton("\uB4F1\uB85D");    // 등록하기 버튼
        submitBtn.setFont(fontButton);
        submitBtn.setVerticalAlignment(SwingConstants.CENTER);
        submitBtn.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(submitBtn);
        RoundedButton cancelBtn = new RoundedButton("\uCDE8\uC18C");    // 취소 버튼
        cancelBtn.setVerticalAlignment(SwingConstants.CENTER);
        cancelBtn.setHorizontalAlignment(SwingConstants.CENTER);
        cancelBtn.setFont(new Font("굴림", Font.PLAIN, 17));
        buttonPanel.add(cancelBtn);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        // 취소버튼 클릭 : 그냥 창 닫힘 --------------------------------------

        cancelBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // 저장버튼 클릭----------------------------------------------------

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleTextField.getText();
                String name = nameTextField.getText();
                String detail = detailTextPane.getText();

                if (!title.equals("") && !name.equals("") && !detail.equals("")) {
                    try {
                        String fileName ="BoardDetail/"+ name + ".txt";
                        BufferedWriter bw = new BufferedWriter(
                                new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));

                        // 상세글을 파일에 저장
                        bw.write(detail);
                        bw.close();

                        // 게시판 메인에 노출되는 파일에도 정보 추가
                        BufferedWriter mainBoardWriter = new BufferedWriter(
                                new OutputStreamWriter(new FileOutputStream(filePath, true), "utf-8"));
                        String lineToAppend = name + "\t" + title + "\t" + strNow2 + "\n";
                        mainBoardWriter.write(lineToAppend);
                        mainBoardWriter.close();

                        // 등록하면서, 필드 초기화, 창 닫음
                        JOptionPane.showMessageDialog(null, "등록되었습니다.");
                        titleTextField.setText("");
                        nameTextField.setText("");
                        detailTextPane.setText("");
                        frame.dispose();
                		Fix_Frame.getDispose();
    					Fix_Frame.getInstance(new Community());   
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "입력하지 않은 데이터가 있습니다.");    // 데이터 미입력시 출력
                }
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
