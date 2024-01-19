package community;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class SearchWindow {

	private JPanel contentPane;
	JScrollPane jp;
	JFrame frame;
	
	//검색한 결과를 띄울 새창.
	public SearchWindow(JScrollPane jp2) {
		this.jp = jp2;

		frame = new JFrame();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
		frame.setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		contentPane.add(jp);
		
		
	}
		
}
