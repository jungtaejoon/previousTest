package com.pTest.Command.codeCheck;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pTest.Command.PCommand;
import com.pTest.DAO.DAO;

public class POMcodeCheckCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int n = 0;
		String str = "YES";
		DAO dao = new DAO();
		PrintWriter writer;
		try {
			writer = response.getWriter();
			
			n = dao.oMCodeChk(request.getParameter("mcode"), request.getParameter("yosaSeme"));
//			System.out.println(n);
			if(n == 1) {
				str = "NO";
				
				writer.print(str);
//					writer.flush();
			} else {
				str = "YES";
//					System.out.println(str);
				writer.print(str);
//					writer.flush();
			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
