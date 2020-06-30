package project1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket server_soc;  // ��������
	private BufferedReader br;        // Ŭ���̾�Ʈ���� ���� �޼����� �д� ���۸޸𸮸� ���� ����
	private PrintWriter pw;           // Ŭ���̾�Ʈ�� �޼����� ������ ����Ʈ������
	private Socket soc;               // Ŭ���̾�Ʈ ����
	
	public Server() {
		init();
	}
	
	public void init() {
		
		try { 
			server_soc = new ServerSocket(8981);      // ���� ������, 8981 ��Ʈ ��������
			System.out.println("Server is ready!");   // ���� �غ�Ϸ� ��Ʈ
			System.out.println("wait for client..."); // Ŭ���̾�Ʈ ������
			
			soc = server_soc.accept();  // Ŭ���̾�Ʈ�� ���� ����(������ ������ ������ ������)
			System.out.println("Client has accepted!");
			
			br = new BufferedReader(new InputStreamReader(soc.getInputStream()));   // Ŭ���̾�Ʈ�� �Է��� ������ �������� input��Ʈ��
			pw = new PrintWriter(soc.getOutputStream());  // ������ ������ Ŭ���̾�Ʈ���� ���������ִ� output��Ʈ��
			
			String readData = ""; // ���� ������ = �޼���
			
			while (!(readData = br.readLine()).equals(null)) {     // ������ ������ ������ ������ �ݺ�
				System.out.println("from client > " + readData);   // Ŭ���̾�Ʈ�� ������ �޼����� ���
				pw.println(readData);                              // �޾ƿ� �޼����� �ٸ� Ŭ���̾�Ʈ���� ������
				pw.flush();     // ����Ʈ�������� �޸� �ʱ�ȭ,  ������ ������ ���۽���
			}
			
			soc.close();  // ������ �������� �ڵ����� Ŭ���̾�Ʈ ���� ����
					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();    // ������ �޼������
		}
		
	}
	
	
	public static void main(String[] args) {
		new Server();
	}
	
}
