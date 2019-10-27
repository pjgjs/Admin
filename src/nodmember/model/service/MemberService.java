package nodmember.model.service;

import nodmember.model.vo.Member;

public class MemberService {

	private Member [] member = new Member [20];
	private int index = 0;
	
	public MemberService() {
		member[index++] = new Member("admin","4885","관리자");
		member[index++] = new Member("khiei","1111","당산지원");
		member[index++] = new Member("hello","2222","자바왕");
		member[index++] = new Member("Java","3333","재밌어용");
	}

	public Member selectMember(String userId, String userPwd) {
		
		for(int i = 0 ; i <index; i++) {
			if(member[i].getUserId().equals(userId)&&member[i].getUserPwd().equals(userPwd)) {
				return member[i];
			}
		}
		return null;
	}

	public boolean updateMember(String userId,String userPwd,String userName) {
		System.out.println(userId+ " " + userPwd + " " + userName);
		
		for(int i =0 ; i<index; i++) {
			if(member[i].getUserId().equals(userId)) {
				member[i].setUserPwd(userPwd);
				member[i].setName(userName);
				return true;
			}
		}
		return false;
	}
}
