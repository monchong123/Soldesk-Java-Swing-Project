package community;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import community.SearchWindow;
import design.RoundedButton;
import fix_frame.Fix_Frame;
import view.MainF;

public class Community extends JPanel {

	private JTextField textField;
	private MyTable mt;
	private ArrayList<NoticeDTO> list;

	public Community() throws Exception {
		setLayout(null); // 자유배치
		setBackground(new Color(187, 229, 255));

		JLabel lblNewLabel = new JLabel("검색");
		lblNewLabel.setBounds(20, 570, 80, 30);

		Font labelFont = lblNewLabel.getFont();
		int fontSize = 20; // 폰트 크기
		lblNewLabel.setFont(new Font(labelFont.getName(), Font.BOLD, fontSize));
		add(lblNewLabel);

		// 검색창
		textField = new JTextField();
		textField.setBounds(70, 570, 120, 30);
		add(textField);
		textField.setColumns(10);
	 

		RoundedButton btnNewButton = new RoundedButton("Search!"); // 검색버튼
		btnNewButton.setBounds(200, 570, 80, 30);
		add(btnNewButton); 

		// 글 작성 버튼
		RoundedButton BtnUpload = new RoundedButton("글작성");
		BtnUpload.setBounds(470, 570, 80, 30);
		add(BtnUpload); // 버튼을 패널에 추가

		mt = new MyTable("NoticeDTO.txt"); // 해당 텍스트 파일을 JScrollPane 타입으로 리턴

		mt.scrolledTable.setBackground(Color.white);
		mt.scrolledTable.setPreferredSize(new Dimension(100, 100)); // 크기 조정
		mt.scrolledTable.setBounds(0, 130, 590, 430); // x, y, 가로, 세로
		add(mt.scrolledTable);

		// 등록하기 누름 (새창 열려야 함)
		BtnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SubmitWindow sw = new SubmitWindow();
				sw.frame.setVisible(true);
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
		// 검색하기
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String search = textField.getText();
				System.out.println("serach:" + search);

				if ("".equals(search)) {
					JOptionPane.showMessageDialog(null, "검색어를 입력해주세요.", "Warning Message", JOptionPane.WARNING_MESSAGE);
					textField.requestFocus();

				} else {
					try {

						SearchDEM sdem; // 필드에 입력한 검색어를 통해서 JScrollPane으로 리턴 받은 후 다시 새창을 통해서 결과값 출력
						sdem = new SearchDEM(search);

						JScrollPane jp = sdem.jsp;

						SearchWindow test2 = new SearchWindow(jp);
						test2.frame.setVisible(true);

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
