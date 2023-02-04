package com.hyungseo.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyungseo.exe.MemberDao;

public class CommandDelOk implements BCommand {

	@Override
	public void action(HttpServletRequest request, HttpServletResponse response) {
			
				HttpSession session = request.getSession();
				String sessionId = (String)session.getAttribute("memberId");
				MemberDao dao = new MemberDao();
				int delResult = dao.delOk(sessionId); //삭제 성공하면 1반
				if(delResult == 1){
					session.invalidate();
					System.out.println("Delete Ok");
					
				}else{ //삭제 실패
					
					System.out.println("Delete Error");


				}

	}

}
