package Calendar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import fix_frame.Fix_Frame;
import view.MainF;

public class CalendarMain extends JPanel { // JPanel을 확장하도록 수정
    private static final long serialVersionUID = 1L;
    private CalendarSwing calendarSwing;

    /**
     * CalendarMain 클래스의 생성자입니다.
     * 
     * @param title 윈도우 제목으로 사용될 문자열
     */
    public CalendarMain() {
        setLayout(null);
        setBackground(new Color(187, 229, 255));
        setSize(600, 800);
        /*
        JPanel fixFrameTopPanel = Fix_Frame.getTopPanel();
        add(fixFrameTopPanel, BorderLayout.NORTH);
	*/
        calendarSwing = new CalendarSwing(this);
        calendarSwing.setBounds(10, 150, 570, 450);
        add(calendarSwing);
        /*
        JPanel fixFrameBottomPanel = Fix_Frame.getBottomPanel();
        add(fixFrameBottomPanel, BorderLayout.SOUTH);
*/
        
        setVisible(true);
        
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
    }

    /**
     * 날짜를 클릭할 때 호출되는 메서드입니다.
     * 
     * @param year  클릭한 날짜의 연도
     * @param month 클릭한 날짜의 월
     * @param day   클릭한 날짜의 일
     */
    public void dateClicked(int year, int month, int day) {
        // 날짜를 클릭했을 때 MemoFrame을 생성하고 CalendarSwing 객체를 MemoFrame에 전달합니다.
        new MemoFrame(year, month, day, calendarSwing);
    }

    /**
     * 프로그램의 진입점입니다. main 메서드에서 프로그램을 시작합니다.
     * 
     * @param args 프로그램 실행 시 전달되는 명령행 인수 (사용하지 않음)
     */
    
    
    
}
