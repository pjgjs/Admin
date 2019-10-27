package member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import member.model.dao.MemberDao;
import member.model.vo.Member;

// 디비에 있는 정보 가져오는 것
public class MemberService {

	public MemberService() {}

	public Member selectMember(String userId, String userPwd) {
		
		Connection conn = null;
		Member memberOne = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
		memberOne = new MemberDao().selectMember(conn, userId, userPwd);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return memberOne;
	}
}
