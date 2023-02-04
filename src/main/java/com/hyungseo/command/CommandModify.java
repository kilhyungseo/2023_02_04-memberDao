package com.hyungseo.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyungseo.exe.MemberDao;
import com.hyungseo.exe.MemberDto;

public class CommandModify implements BCommand {

	@Override
	public void action(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memberId");
		
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.getMemberInfo(sessionId);
		
		request.setAttribute("memberDto", dto);
	}

}
