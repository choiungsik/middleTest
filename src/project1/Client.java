package project1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat.Encoding;

public class Client {

	private BufferedReader br;        // 클라이언트에서 받은 메세지를 읽는 버퍼메모리를 가진 리더
	private PrintWriter pw;           // 클라이언트로 메세지를 보내는 프린트라이터
	private Socket soc;               // 클라이언트 소켓
	private Scanner scan;             // 사용자가 입력한 데이터를 읽는 스캐너
	
	
	public Client() {
		init();
	}
	
	public void init() {
		
		try {
			soc = new Socket("localhost", 8981);        // 자신의 아이피를 통해 8981포트에 접속 시도(서버에 따라 다른 포트를 설정해서 접속하도록 설정)
			System.out.println("Accept to Server Success!");    // 열려있는 서버에 접속
			
			br = new BufferedReader(new InputStreamReader(soc.getInputStream()));    // 연결된 서버에서 정보받을 준비
			pw = new PrintWriter(soc.getOutputStream());                             // 연결된 서버에 정보 보낼 준비
			
			scan = new Scanner(System.in);                                           // 사용자가 입력한 데이터를 읽을 준비
			
			System.out.println("Now, you can chat!");    // 채팅활성화
			String inputData = "";   // 보낼 메세지
			
			while (!inputData.equals("disconnect")) {    // 사용자가 disconnect라고 입력하거나 강제종료될 때까지 무한반복
				System.out.print("to Server > ");        // 서버에 메세지를 보냄
				pw.println(scan.nextLine());             // 사용자가 적은 메세지
				pw.flush();                              // 프린트라이터를 초기화시켜 실질적으로 메세지 전송
				
				System.out.println("from Server > "+br.readLine());   // 서버가 보낸 정보를 읽고 출력해줌
				
			}
			
			soc.close();  // 서버가 닫히면 클라이언트 소켓 종료
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();  // 오류시 오류확인
		}
		
		
	}
	
	public static void main(String[] args) {
		new Client();
	}
	
	
}
