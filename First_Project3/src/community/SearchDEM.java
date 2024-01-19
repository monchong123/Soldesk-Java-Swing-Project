package community;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.swing.JScrollPane;

public class SearchDEM {


    static List<File> targetFiles = null;
    
    String line = "";

    static String Dir = "NoticeDTO.txt";    //검색할 파일
    static String word;         //검색할단어를,로 구분해서 나열
    static String save = "searchresult";       //검색결과가 저장될 파일명
    
    JScrollPane jsp;
                          
        public SearchDEM(String word) throws IOException, Exception {   

    	System.out.print("검색할 단어 입력 : ");
    	this.word = word;
    
        //읽어들일 파일 input stream 선언
        BufferedReader br = null;
        String[] words = word.split(",");
        

            //input stream object 생성
            br = new BufferedReader(new InputStreamReader(new FileInputStream(Dir), "utf-8"));
            
            //검색결과를 저장. 검색할때마다 같은 파일을 갱신함.
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(save + "\\" + "result" + ".txt"), "utf-8"));
            
            //각 파일의 한 라인씩 읽어들인다.
            while((line = br.readLine()) != null) {
            	
            	//라인 내용중 검색하고자  단어가 하나라도 있으면 파일에 기록한다.
                for(int j=0; j<words.length;j++)
                if(line.indexOf(words[j]) != -1) {
                    System.out.println(line);
                    writer.write(line.trim() + "\n");
                }
            }
            
            writer.flush();

            //input stream close.
            br.close();

            //output stream close.
            writer.close();
            MyTable mt = new MyTable(save + "\\" + "result" + ".txt");
            
            this.jsp = mt.scrolledTable;	//해당 타입의 테이블을 리턴
            

        }


		public static String getWord() {
			return word;
		}


		public static void setWord(String word) {
			SearchDEM.word = word;
		}


		public JScrollPane getJsp() {
			return jsp;
		}


		public void setJsp(JScrollPane jsp) {
			this.jsp = jsp;
		}


}
