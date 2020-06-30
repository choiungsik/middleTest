package project1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat.Encoding;

public class Client {

	private BufferedReader br;        // Ŭ���̾�Ʈ���� ���� �޼����� �д� ���۸޸𸮸� ���� ����
	private PrintWriter pw;           // Ŭ���̾�Ʈ�� �޼����� ������ ����Ʈ������
	private Socket soc;               // Ŭ���̾�Ʈ ����
	private Scanner scan;             // ����ڰ� �Է��� �����͸� �д� ��ĳ��
	
	
	public Client() {
		init();
	}
	
	public void init() {
		
		try {
			soc = new Socket("localhost", 8981);        // �ڽ��� �����Ǹ� ���� 8981��Ʈ�� ���� �õ�(������ ���� �ٸ� ��Ʈ�� �����ؼ� �����ϵ��� ����)
			System.out.println("Accept to Server Success!");    // �����ִ� ������ ����
			
			br = new BufferedReader(new InputStreamReader(soc.getInputStream()));    // ����� �������� �������� �غ�
			pw = new PrintWriter(soc.getOutputStream());                             // ����� ������ ���� ���� �غ�
			
			scan = new Scanner(System.in);                                           // ����ڰ� �Է��� �����͸� ���� �غ�
			
			System.out.println("Now, you can chat!");    // ä��Ȱ��ȭ
			String inputData = "";   // ���� �޼���
			
			while (!inputData.equals("disconnect")) {    // ����ڰ� disconnect��� �Է��ϰų� ��������� ������ ���ѹݺ�
				System.out.print("to Server > ");        // ������ �޼����� ����
				pw.println(scan.nextLine());             // ����ڰ� ���� �޼���
				pw.flush();                              // ����Ʈ�����͸� �ʱ�ȭ���� ���������� �޼��� ����
				
				System.out.println("from Server > "+br.readLine());   // ������ ���� ������ �а� �������
				
			}
			
			soc.close();  // ������ ������ Ŭ���̾�Ʈ ���� ����
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();  // ������ ����Ȯ��
		}
		
		
	}
	
	public static void main(String[] args) {
		new Client();
	}
	
	
}
