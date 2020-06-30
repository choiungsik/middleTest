package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	String mem_id = "";
	int meet_id = 1;


	ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
	
	private void getConnection() {

		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("클래스오류");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql오류");
		}
	}

	private void close() {
		try {
			// 이 경우도 진행될지 안될지 모르는 상황이니 try ~catch 문으로 실행시켜야 정상작동함
			if (rs != null) {
				rs.close();
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

	public int join(ReviewVO vo) {

		int cnt = 0;

		try {
			getConnection();

			String sql = "insert into reviews values(review_no_seq.nextval, " + mem_id + ", " + meet_id
					+ ", ?, ?, ?, default)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getReview_star());
			psmt.setString(2, vo.getReview_title());
			psmt.setString(3, vo.getReview_cont());

			System.out.println("|");
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	public ArrayList<ReviewVO> selectAll() {


		try {
			getConnection();

			String sql = "select * from reviews where meet_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, meet_id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int re_id = rs.getInt("REVIEW_ID");
				String id = rs.getString("MEM_ID");
				int meet_id = rs.getInt("MEET_ID");
				int re_star = rs.getInt("REVIEW_STAR");
				String re_title = rs.getString("REVIEW_TITLE");
				String re_cont = rs.getString("REVIEW_CONT");
				ReviewVO vo = new ReviewVO(re_id, id, meet_id, re_star, re_title, re_cont);
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public String reviewNameSelect(int count) {
		String name = "";

		getConnection();
		try {
			String sql = "select * from reviews where meet_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, meet_id);
			rs = psmt.executeQuery();
			for (int i = 0; i < count; i++) {
				rs.next();
			}
			while (rs.next()) {
				// list.add()
				name = rs.getString("mem_id");
				// 아이디와 비밀번호를 가져오면 그 줄에 있는 이름을 string name에 넣음
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return name;

	}
	
	public String reviewTitleSelect(int count) {
		String title = "";
		getConnection();
		try {
			String sql = "select * from reviews where meet_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, meet_id);
			rs = psmt.executeQuery();
			for (int i = 0; i < count; i++) {
				rs.next();
			}
			if (rs.next()) {
				// list.add()
				title = rs.getString("REVIEW_TITLE");
				// 아이디와 비밀번호를 가져오면 그 줄에 있는 이름을 string name에 넣음
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return title;

	}
	
	public String reviewContSelect(int count) {
		String cont = "";
		getConnection();
		try {
			String sql = "select * from reviews where meet_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, meet_id);
			rs = psmt.executeQuery();
			for (int i = 0; i < count; i++) {
				rs.next();
			}
			if (rs.next()) {
				// list.add()
				cont = rs.getString("REVIEW_CONT");
				// 아이디와 비밀번호를 가져오면 그 줄에 있는 이름을 string name에 넣음
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return cont;

	}
	
	public int reviewStarSelect(int count) {
		int star = 0;
		getConnection();
		try {
			String sql = "select * from reviews where meet_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, meet_id);
			rs = psmt.executeQuery();
			for (int i = 0; i < count; i++) {
				rs.next();
			}
			if (rs.next()) {
				// list.add()
				star = rs.getInt("REVIEW_STAR");
				// 아이디와 비밀번호를 가져오면 그 줄에 있는 이름을 string name에 넣음
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}
		return star;

	}

	public int delete(ReviewVO vo) {

		int cnt = 0;

		try {
			getConnection();

			String sql = "delete reviews where review_id = ? and mem_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getReview_id());
			psmt.setString(2, vo.getMem_id());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

}
