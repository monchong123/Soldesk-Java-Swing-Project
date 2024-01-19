package Calendar; 
import java.awt.*;
import javax.swing.*;

import design.CustomFont;
import design.RoundButton;

import java.awt.event.*;
import java.util.*;

public class CalendarSwing extends JPanel implements ActionListener {
    private RoundButton prevBtn, nextBtn;
    private JComboBox<Integer> yearCombo, monthCombo;
    private JPanel calendarPanel;
    private Calendar date;
    private int year, month;
    private int currentYear, currentMonth;
    private CalendarMain parent;

    public CalendarSwing(CalendarMain parent) {
        this.parent = parent;

        date = Calendar.getInstance();
        date.setFirstDayOfWeek(Calendar.SUNDAY); // 일요일부터 시작하도록 설정
        currentYear = date.get(Calendar.YEAR);
        currentMonth = date.get(Calendar.MONTH) + 1;
        year = currentYear;
        month = currentMonth;

        setLayout(new BorderLayout());

        JPanel selectPanel = new JPanel();
        selectPanel.setBackground(new Color(187, 229, 255));
        prevBtn = new RoundButton("◀");
        nextBtn = new RoundButton("▶");
        yearCombo = new JComboBox<>();
        monthCombo = new JComboBox<>();

        prevBtn.addActionListener(this);
        nextBtn.addActionListener(this);

        for (int i = currentYear - 50; i <= currentYear + 50; i++) {
            yearCombo.addItem(i);
        }
        yearCombo.setSelectedItem(currentYear);
        for (int i = 1; i <= 12; i++) {
            monthCombo.addItem(i);
        }
        monthCombo.setSelectedItem(currentMonth);

        yearCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                year = (int) yearCombo.getSelectedItem();
                refreshCalendar(year, month);
            }
        });
        monthCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                month = (int) monthCombo.getSelectedItem();
                refreshCalendar(year, month);
            }
        });

        selectPanel.add(prevBtn);
        selectPanel.add(yearCombo);
        selectPanel.add(new JLabel("년"));
        selectPanel.add(monthCombo);
        selectPanel.add(new JLabel("월"));
        selectPanel.add(nextBtn);

        calendarPanel = new JPanel(new GridLayout(7, 7));
        calendarPanel.setBackground(new Color(187, 229, 255)); // 배경색을 설정

        add(selectPanel, BorderLayout.NORTH);
        add(calendarPanel, BorderLayout.CENTER);

        setCalendar(currentYear, currentMonth);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevBtn) {
            if (month == 1) {
                year--;
                month = 12;
            } else {
                month--;
            }
        } else if (e.getSource() == nextBtn) {
            if (month == 12) {
                year++;
                month = 1;
            } else {
                month++;
            }
        }
        yearCombo.setSelectedItem(year);
        monthCombo.setSelectedItem(month);
        refreshCalendar(year, month);
    }

    public void refreshCalendar(int year, int month) {
        calendarPanel.removeAll();
        String[] dayOfWeek = { "일", "월", "화", "수", "목", "금", "토" };

        for (String day : dayOfWeek) {
            JLabel label = new JLabel(day);
            label.setHorizontalAlignment(SwingConstants.CENTER);

            if (day.equals("일")) {
                label.setForeground(Color.RED);
            } else if (day.equals("토")) {
                label.setForeground(Color.BLUE);
            }

            calendarPanel.add(label);
        }

        date.set(year, month - 1, 1);
        int firstDayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        int lastDayOfMonth = date.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int dayNumber = i * 7 + j + 2 - firstDayOfWeek;
                if (dayNumber >= 1 && dayNumber <= lastDayOfMonth) {
                   RoundButton dayButton = new RoundButton(Integer.toString(dayNumber));
                    
                    dayButton.setVerticalTextPosition(SwingConstants.TOP);
                    dayButton.addActionListener(new DateButtonListener(year, month, dayNumber));
                    //dayButton.setBounds(0, 0,5, 5);
                    JPanel dayPanel = new JPanel(new BorderLayout());
                   
                    
                    JTextArea memoText = new JTextArea();
                    memoText.setEditable(false);
                    memoText.setBackground(Color.WHITE); // 텍스트 입력 전 배경색은 흰색
                    dayPanel.add(dayButton, BorderLayout.NORTH);
                    dayPanel.add(memoText, BorderLayout.CENTER);
                    Font customFont = CustomFont.loadFont(12);
                    memoText.setFont(customFont);

                    if (j == 6) { // 토요일 파란색
                        dayButton.setForeground(Color.BLUE);
                    } else if (j == 0) { // 일요일 빨간색
                        dayButton.setForeground(Color.RED);
                    }

                    calendarPanel.add(dayPanel);
                } else {
                    calendarPanel.add(new JLabel());
                }
            }
        }

        currentYear = year;
        currentMonth = month;

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    public void setCalendar(int year, int month) {
        this.year = year;
        this.month = month;
        refreshCalendar(year, month);
    }

    private class DateButtonListener implements ActionListener {
        private int year, month, day;

        public DateButtonListener(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public void actionPerformed(ActionEvent e) {
            parent.dateClicked(year, month, day);
        }
    }

    public void addMemo(int year, int month, int day, String memoText) {
        JTextArea memoTextArea = findMemoTextArea(year, month, day);
        if (memoTextArea != null) {
            memoTextArea.setText(memoText);
            if (memoText.isEmpty()) {
                memoTextArea.setBackground(Color.WHITE); // 공란이면 배경색을 흰색으로 설정
            } else {
                memoTextArea.setBackground(new Color(204, 255, 204)); // 메모가 있는 경우 배경색 변경
            }
        }
    }

    private JTextArea findMemoTextArea(int year, int month, int day) {
        Component[] components = calendarPanel.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                JPanel dayPanel = (JPanel) component;
                Component[] dayComponents = dayPanel.getComponents();
                for (Component dayComponent : dayComponents) {
                    if (dayComponent instanceof JTextArea) {
                        JButton button = (JButton) dayPanel.getComponent(0);
                        int buttonDay = Integer.parseInt(button.getText());
                        if (buttonDay == day) {
                            return (JTextArea) dayComponent;
                        }
                    }
                }
            }
        }
        return null;
    }
}