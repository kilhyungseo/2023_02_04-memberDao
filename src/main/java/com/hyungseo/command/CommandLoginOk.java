package com.hyungseo.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyungseo.exe.MemberDao;

public class CommandLoginOk implements BCommand {

	@Override
	public void action(HttpServletRequest request, HttpServletResponse response) {
		
		String mid = request.getParameter("id");
		String mpw = request.getParameter("pw");
		
		MemberDao dao = new MemberDao();
		
		int loginResult = dao.loginCheck(mid, mpw); // 1이면 로그인 성공, 0이면 로그인 실패
		
		if(loginResult == 1){ //로그인 성공
			HttpSession session = request.getSession();
		
			session.setAttribute("memberId", mid); // 로그인 성공 세션에 아이디 저장
			session.setAttribute("ValidSession", "yes");
			System.out.println(session + "로그인 성공!!!");
		}else {
			System.out.println("로그인 실패!!! 아이디와 암호를 확인하세요 ");
		}

	}

}
