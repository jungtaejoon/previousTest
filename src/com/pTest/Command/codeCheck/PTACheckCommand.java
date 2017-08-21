package com.pTest.Command.codeCheck;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pTest.Command.PCommand;
import com.pTest.DAO.DAO;

public class PTACheckCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int n = 0;
		String ta = null;
		String str = "YES";
		DAO dao = new DAO();
		PrintWriter writer;
		try {
			writer = response.getWriter();
		
			ta = dao.tAChk(request.getParameter("scode"), request.getParameter("tyear"), request.getParameter("tnum"));
//			System.out.println(ta);
//			System.out.println(request.getParameter("ta"));
			n = tACompare(request.getParameter("ta"), ta);
//			System.out.println(n);
			if(n == 0) {
				str = "wrong";
				writer.print(str);
			} 
			else {
				str = "YES";
				writer.print(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int tACompare(String ta1, String ta2) {
		int n = 0;
		if(ta2.equalsIgnoreCase("a")) {
			if(ta1.equals("1") || ta1.equals("2")) n = 1;
		}
		else if(ta2.equalsIgnoreCase("b")) {
			if(ta1.equals("1") || ta1.equals("3")) n = 1;
		}
		else if(ta2.equalsIgnoreCase("c")) {
			if(ta1.equals("1") || ta1.equals("4")) n = 1;
		}
		else if(ta2.equalsIgnoreCase("d")) {
			if(ta1.equals("2") || ta1.equals("3")) n = 1;
		}
		else if(ta2.equalsIgnoreCase("e")) {
			if(ta1.equals("2") || ta1.equals("4")) n = 1;
		}
		else if(ta2.equalsIgnoreCase("f")) {
			if(ta1.equals("3") || ta1.equals("4")) n = 1;
		}
		else if(ta2.equalsIgnoreCase("g")) {
			if(ta1.equals("1") || ta1.equals("2") || ta1.equals("3")) n = 1;
		}
		else if(ta2.equalsIgnoreCase("h")) {
			if(ta1.equals("1") || ta1.equals("2") || ta1.equals("4")) n = 1;
		}
		else if(ta2.equalsIgnoreCase("i")) {
			if(ta1.equals("1") || ta1.equals("3") || ta1.equals("4")) n = 1;
		}
		else if(ta2.equalsIgnoreCase("j")) {
			if(ta1.equals("2") || ta1.equals("3") || ta1.equals("4")) n = 1;
		}
		else if(ta2.equalsIgnoreCase("k")) n = 1;
		else if(ta1.equals(ta2)) n = 1;
		return n;
	}

}
