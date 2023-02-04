package com.hyungseo.exe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.hyungseo.command.BCommand;
import com.hyungseo.command.CommandDelOk;
import com.hyungseo.command.CommandJoinOk;
import com.hyungseo.command.CommandLoginOk;
import com.hyungseo.command.CommandLogoutOk;
import com.hyungseo.command.CommandModify;
import com.hyungseo.command.CommandModifyOk;

/**
 * Servlet implementation class MembersController
 */
@WebServlet("*.do")
public class MembersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doAction(request, response);

	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			String uri = request.getRequestURI();
			String conPath = request.getContextPath();
			String command = uri.substring(conPath.length());
			String viewPage = null;
			System.out.println(command);
			
			if(command.equals("/main.do")) {
				viewPage = "/main.jsp";
			}else if(command.equals("/login.do")) {
				viewPage = "/login.jsp";
			}else if(command.equals("/modifyInfo.do")) {
				BCommand bCommand = new CommandModify();
				bCommand.action(request, response);
				
				viewPage = "/modify.jsp";	
			}else if(command.equals("/joinMemberOk.do")) {
				BCommand bCommand = new CommandJoinOk();
				bCommand.action(request, response);
				
				viewPage = "/login.jsp";

			}else if(command.equals("/loginOk.do")) {
				BCommand	 bCommand = new CommandLoginOk();
				bCommand.action(request, response);
				
				viewPage = "/main.jsp";
				
				}else if(command.equals("/logout.do")) {
					BCommand bCommand = new CommandLogoutOk();
					bCommand.action(request, response);
					
					viewPage = "/login.jsp";
				
				}else if(command.equals("/delOk.do")) {
					BCommand bCommand = new CommandDelOk();
					bCommand.action(request, response);
					
					viewPage = "/login.jsp";

				}else if(command.equals("/modifyOk.do")) {
					BCommand bCommand = new CommandModifyOk();
					bCommand.action(request, response);
					
					viewPage = "/modifyOk.jsp";
					
				}else if(command.equals("/join.do")){
					
					viewPage = "/join.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
	}
}
