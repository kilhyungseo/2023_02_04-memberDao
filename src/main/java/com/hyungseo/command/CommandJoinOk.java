package com.hyungseo.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyungseo.exe.MemberDao;

public class CommandJoinOk implements BCommand {

	@Override
	public void action(HttpServletRequest request, HttpServletResponse response) {
		
		String mid = request.getParameter("id");
		String mpw = request.getParameter("pw");
		String mname = request.getParameter("name");
		String memail = request.getParameter("email");
		
		int resultInt = 0;
		
		MemberDao dao = new MemberDao();
		int checkId = dao.checkId(mid); // 1이면 가입하려는 아이디가 이미 존재
		
		if (checkId == 0){
			resultInt = dao.joinMember(mid, mpw, mname, memail); // 1이면 삽입 성공
		}else{
			System.out.println("가입하려는 아이디가 이미 존재합니다.");
			
		}
		if(resultInt == 1){
			System.out.println("가입성공!!!");
			
		}else{
			System.out.println("가입실!!!");

		}

	}

}
