package project1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket server_soc;  // 서버소켓
	private BufferedReader br;        // 클라이언트에서 받은 메세지를 읽는 버퍼메모리를 가진 리더
	private PrintWriter pw;           // 클라이언트로 메세지를 보내는 프린트라이터
	private Socket soc;               // 클라이언트 소켓
	
	public Server() {
		init();
	}
	
	public void init() {
		
		try { 
			server_soc = new ServerSocket(8981);      // 현재 아이피, 8981 포트 서버형성
			System.out.println("Server is ready!");   // 서버 준비완료 멘트
			System.out.println("wait for client..."); // 클라이언트 연결중
			
			soc = server_soc.accept();  // 클라이언트의 서버 접속(접속할 때까지 서버는 대기상태)
			System.out.println("Client has accepted!");
			
			br = new BufferedReader(new InputStreamReader(soc.getInputStream()));   // 클라이언트가 입력한 내용을 가져오는 input스트림
			pw = new PrintWriter(soc.getOutputStream());  // 가져온 정보를 클라이언트에게 각각보내주는 output스트림
			
			String readData = ""; // 보낼 데이터 = 메세지
			
			while (!(readData = br.readLine()).equals(null)) {     // 상대방의 접속이 끊어질 때까지 반복
				System.out.println("from client > " + readData);   // 클라이언트가 보내준 메세지를 출력
				pw.println(readData);                              // 받아온 메세지를 다른 클라이언트에게 보내줌
				pw.flush();     // 프린트파이터의 메모리 초기화,  실질적 데이터 전송실행
			}
			
			soc.close();  // 접속이 끊어지면 자동으로 클라이언트 소켓 종료
					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();    // 오류시 메세지출력
		}
		
	}
	
	
	public static void main(String[] args) {
		new Server();
	}
	
}
