package community;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import design.CustomFont;
import design.RoundedButton; 
public class DetailWindow {

	JFrame frame;
	JPanel contentPane;
	NoticeDTO user;

	//String num;
	int boardNum;
	String name;
	String title;
	String date;
	String everything;
	
	static String dirpath = "BoardDetail";	//상세 내용 파일이 들어있는 폴더명

	public DetailWindow(NoticeDTO user) throws IOException {
		this.user = user;
		//num = user.getNum(); //등록번호
		name = user.getName();
		title = user.getTitle();
		date = user.getDate();
		
		
	
		// 기본 뷰 생성
		frame = new JFrame();
		frame.setTitle(name+"님의 게시글");
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		frame.setBounds(100, 100, 650, 500);
		
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (screenSize.width - frame.getWidth()) / 2;
	    int y = (screenSize.height - frame.getHeight()) / 2;
	    frame.setLocation(x, y);
	      
		frame.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		//Font font = new Font("굴림", Font.PLAIN, 13);
		Font fontButton = new Font("굴림", Font.PLAIN, 17);
		
		 Font font = CustomFont.suiteFont(18); // 12는 원하는 폰트 크기입니다.
		 frame.setFont(font);

//		JLabel titleTextLbl = new JLabel(title);
//		titleTextLbl.setFont(font);
//		titleTextLbl.setBounds(84, 5, 525, 21); 
//		contentPane.add(titleTextLbl);

		// 텍스트 내용 출력 -----------------------------------------------------

		JTextPane detailTextPane = new JTextPane();
		detailTextPane.setFont(font);
		detailTextPane.setEditable(false);
		JScrollPane scrollArea = new JScrollPane(detailTextPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		// 등록번호와 일치하는 상세 보드 내용 불러오기
		// 등록번호와 지정한 디렉토리 안에 이름이 일치하는 파일을 불러와 결과값 출력
		//System.out.println("등록번호 몇번 출력 할건가요? :" + num);
		FileInputStream input = new FileInputStream(dirpath + "\\" + name + ".txt");	
		InputStreamReader reader = new InputStreamReader(input, "UTF-8");
		BufferedReader br = new BufferedReader(reader);
		
		// 버퍼 리더의 경우 캐릭터 한글자식 출력을 하기 때문에
		// 해당 내용을 스트링 값으로 필드에 뿌려주기 위해 변환하는 코드
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
		} finally {

			br.close();
		}

		detailTextPane.setText(everything);

		scrollArea.setBounds(12, 58, 610, 161);
		scrollArea.setFont(font);
		contentPane.add(scrollArea);
		
		JTextPane textArea = new JTextPane();
		textArea.setFont(font);
		textArea.setEditable(false); // Make it non-editable if needed
		textArea.setBackground(new Color(238, 238, 238));
		JScrollPane area = new JScrollPane(textArea);
		area.setBounds(12, 220, 600, 180);
		area.setBorder(null);
		area.setFont(font);
		contentPane.add(area); // JScrollPane을 추가해야 스크롤 기능이 작동합니다.
        
        // 커스텀 텍스트 필드
        JTextField customTextField = new JTextField();
        customTextField.setBounds(12, 340, 513, 23);  
        contentPane.add(customTextField);
        
        // 텍스트 필드에 스크롤바 추가
        JScrollPane scrollPane = new JScrollPane(customTextField);
        scrollPane.setBounds(12, 400, 513, 43); 
        contentPane.add(scrollPane);
        
        // "완료" 버튼
        RoundedButton completeButton = new RoundedButton("완료");
        completeButton.setFont(fontButton);
        completeButton.setVerticalAlignment(SwingConstants.CENTER);
        completeButton.setHorizontalAlignment(SwingConstants.CENTER);
        completeButton.setBounds(537, 410, 90, 23); // 위치 조정 (텍스트 필드 크기에 맞춰 이동)
        contentPane.add(completeButton);

        // "완료" 버튼의 액션 리스너 등록
        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 텍스트 필드에서 입력된 내용 가져오기
                String newText = customTextField.getText();
                // 현재 textarea의 텍스트 가져오기
                String currentText = textArea.getText();
                // 기존 텍스트와 새로 입력된 텍스트를 합쳐서 textarea에 설정
                textArea.setText(currentText + "\n" + newText); // 기존 텍스트와 새로운 텍스트를 줄 바꿈으로 구분
                // 텍스트 필드 초기화
                customTextField.setText("");
                // "댓글관리.txt" 파일에 입력된 내용을 추가
                try {
                    FileWriter writer = new FileWriter("댓글관리.txt", true); // true를 넣어서 파일의 끝에 추가
                    writer.write(name+":"+newText + "\n");
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });   
     // "댓글관리.txt" 파일에서 name과 일치하는 댓글만 가져오기
        try {
            FileInputStream commentInput = new FileInputStream("댓글관리.txt");
            InputStreamReader commentReader = new InputStreamReader(commentInput, "UTF-8");
            BufferedReader commentBufferedReader = new BufferedReader(commentReader);
            StringBuilder commentStringBuilder = new StringBuilder();
            String commentLine = commentBufferedReader.readLine();
            
            while (commentLine != null) {
                // 댓글을 ':' 기준으로 나누어 작성자와 댓글 내용을 분리
                String[] parts = commentLine.split(":");
                if (parts.length == 2) {
                    String author = parts[0].trim();
                    String commentText = parts[1].trim();    
                    // name과 작성자가 같은 경우에만 댓글 내용을 추가
                    if (name.equals(author)) {
                        commentStringBuilder.append("- "+commentText).append("\n");
                    }
                }   
                commentLine = commentBufferedReader.readLine();
            }
            String comments = commentStringBuilder.toString();
            textArea.setText(comments);
            commentBufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        JLabel nameLbl = new JLabel("\uC791\uC131\uC790");
		nameLbl.setBounds(15, 33, 57, 15);
		nameLbl.setFont(font);
		contentPane.add(nameLbl);

		JLabel titleLbl = new JLabel("\uC81C \uBAA9");
		titleLbl.setBounds(15, 8, 57, 15);
		titleLbl.setFont(font);
		contentPane.add(titleLbl);
		
		JLabel titleField = new JLabel(title);
		titleField.setBounds(84, 5, 110, 21);
		titleField.setFont(font);
		contentPane.add(titleField);

		JLabel nameTextField = new JLabel(name);
		nameTextField.setBounds(84, 30, 110, 21);
		nameTextField.setFont(font);
		contentPane.add(nameTextField);

		JLabel dateLbl = new JLabel("\uB4F1\uB85D\uC77C");
		dateLbl.setBounds(228, 33, 57, 15);
		dateLbl.setFont(font);
		contentPane.add(dateLbl);

		JLabel nowDateLbl = new JLabel(date);
		nowDateLbl.setFont(font);
		nowDateLbl.setBounds(290, 32, 119, 15);
		contentPane.add(nowDateLbl);


	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}

