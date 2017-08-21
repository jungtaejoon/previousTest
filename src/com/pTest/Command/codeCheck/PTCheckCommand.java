package com.pTest.Command.codeCheck;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pTest.Command.PCommand;
import com.pTest.DAO.DAO;

public class PTCheckCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int n = 0;
		String str = "YES";
		DAO dao = new DAO();
		PrintWriter writer;
		try {
			writer = response.getWriter();
			n = dao.tChk(request.getParameter("scode"), request.getParameter("tyear"));
			if(n == 1) {
				str = "YES";
				writer.print(str);
			} else {
				str = "NO";
				writer.print(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
