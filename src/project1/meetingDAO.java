package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class meetingDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet result;
	String mem_id = "kpg123";
	ArrayList<meetingVO> list = new ArrayList<meetingVO>();
	
	private void getConnection() {

		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			// 이 경우도 진행될지 안될지 모르는 상황이니 try ~catch 문으로 실행시켜야 정상작동함
			if (result != null) {
				result.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public int joinMeeting(meetingVO vo) {

		int cnt = 0;

		try {
			getConnection();

			String sql = "insert into meetings values(meet_id_seq.nextval, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem_id);
			psmt.setString(2, vo.getMeetName());
			psmt.setInt(3, vo.getPersonnel());
			psmt.setString(4, vo.getMeetInter());
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("서버상 sql오류");
		} finally {
			close();
		}

		return cnt;
	}


	public ArrayList<meetingVO> selectAll() {
		
		try {
			getConnection();
			
			String sql = "select * from meetings";
			psmt = conn.prepareStatement(sql);
			result = psmt.executeQuery();
			
			while (result.next()) {
				int meetid = result.getInt("meetID");
				String memid = result.getString("memID");
				String meetName = result.getString("meetNAME");
				int personnel = result.getInt("personnel");
				String meetInter = result.getString("meetInter");
				meetingVO vo = new meetingVO(meetid, memid, meetName, personnel, meetInter);
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public int delete(meetingVO vo) {

		int cnt = 0;

		try {
			getConnection();

			String sql = "delete meetings where meet_id = ? and mem_pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getMeetID());
			psmt.setString(2, vo.getMemID());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
}
