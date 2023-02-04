package com.hyungseo.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyungseo.exe.MemberDao;
import com.hyungseo.exe.MemberDto;

public class CommandModifyOk implements BCommand {

	@Override
	public void action(HttpServletRequest request, HttpServletResponse response) {
					String mid = request.getParameter("id");
					String mpw = request.getParameter("pw");
					String mname = request.getParameter("name");
					String memail = request.getParameter("email");
					
					MemberDao dao = new MemberDao();
					int resultFlag = dao.modify(mid, mpw, mname, memail);  // 1이면 수정성공
					
					if(resultFlag == 1 ){
						HttpSession session = request.getSession();
						String sessionId = (String)session.getAttribute("memberId");
						MemberDto dto = dao.getMemberInfo(sessionId);
						request.setAttribute("memberDto", dto);
						System.out.println("수정성공");
					}else{
						
					}

	}

}
