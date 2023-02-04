package com.hyungseo.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {
	
	public void action(HttpServletRequest request, HttpServletResponse response);

}
