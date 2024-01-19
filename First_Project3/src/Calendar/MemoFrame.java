package Calendar;

import javax.swing.*;
import design.RoundedButton;
import java.awt.*;
import java.awt.event.*;

public class MemoFrame extends JFrame {
   private JTextArea memoArea;
   private int year, month, day;
   private CalendarSwing calendarSwing;
   private JSpinner spinner; // 알람 설정을 위한 JSpinner

   public MemoFrame(int year, int month, int day, CalendarSwing calendarSwing) {
      super(year + "년 " + month + "월 " + day + "일 메모");
      this.year = year;
      this.month = month;
      this.day = day;
      this.calendarSwing = calendarSwing;

      setBounds(
          (Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2,
          (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2,
          400, 300
      );

      memoArea = new JTextArea();
      JScrollPane scrollPane = new JScrollPane(memoArea);   
      add(scrollPane);

      RoundedButton saveButton = new RoundedButton("저장");
      saveButton.addActionListener(new SaveButtonListener());
      
      RoundedButton alarmButton = new RoundedButton("알람설정");
      alarmButton.addActionListener(new alarmButtonListener());

      SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 60, 1);
      spinner = new JSpinner(spinnerModel);
      JLabel spinnerLabel = new JLabel("알람 시간 (일): ");

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(spinnerLabel);
      buttonPanel.add(spinner);
      buttonPanel.add(saveButton);
      buttonPanel.add(alarmButton);
      add(buttonPanel, BorderLayout.SOUTH);

      String memoText = MemoData.getMemo(year, month, day);
      memoArea.setText(memoText);

      setVisible(true);
   }

   private class SaveButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         String memoText = memoArea.getText();
         MemoData.setMemo(year, month, day, memoText);
         calendarSwing.addMemo(year, month, day, memoText);
         setVisible(false);
      }
   }
 
   private class alarmButtonListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
          int minutes = (int) spinner.getValue();
          int delayInMillis = minutes*1000; // 이렇게하면 초단위
          System.out.println(minutes + "일 후에 알람이 울립니다");

          Timer timer = new Timer(delayInMillis, new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  openAlarmFrame();
              }
          });
          timer.setRepeats(false);
          timer.start();
      }
   }

   private void openAlarmFrame() {
       JFrame alarmFrame = new JFrame(year + "년 " + month + "월 " + day + "일 알람");
       alarmFrame.setSize(500, 300);
       String al = memoArea.getText();
       JLabel alarmLabel = new JLabel(al);

       Font labelFont = alarmLabel.getFont();
       int fontSize = 50; //폰트 크기
       alarmLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSize));

       alarmLabel.setHorizontalAlignment(JLabel.CENTER);
       alarmFrame.add(alarmLabel);

       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       int x = (screenSize.width - alarmFrame.getWidth()) / 2;
       int y = (screenSize.height - alarmFrame.getHeight()) / 2;
       alarmFrame.setLocation(x, y);

       alarmFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       alarmFrame.setVisible(true);
   }
}


 