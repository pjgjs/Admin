package member.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import member.model.vo.Member;

public class MemberDao {

	public Member selectMember(Connection conn, String userId, String userPwd) {
		
		Member mOne = null;
		Statement stmt = null;
		ResultSet rset = null;
	
		String query =
				"SELECT * FROM MEMBER WHERE MEMBER_ID='" + userId + "'and MEMBER_PWD = '"+ userPwd + "'";
		
		System.out.println("conn : " + conn);
		
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			if (rset.next()) {
				mOne = new Member();
				mOne.setName(rset.getString("MEMBER_NAME"));
				mOne.setUserId(rset.getString("MEMBER_ID"));
				mOne.setUserPwd(rset.getString("MEMBER_PWD"));
				
				System.out.println(mOne.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return mOne;
	}
}
