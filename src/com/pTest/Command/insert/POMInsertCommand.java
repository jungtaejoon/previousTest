package com.pTest.Command.insert;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pTest.Command.PCommand;
import com.pTest.DAO.DAO;
import com.pTest.DTO.DTO;

public class POMInsertCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DTO dto = new DTO();
		DAO dao = new DAO();
		int n = 0;
		dto.setYosaSeme(request.getParameter("yosaSeme"));
		dto.setMcode(request.getParameter("mcode"));
//		dto.setMname(request.getParameter("mname"));
//		dto.setScode(request.getParameter("scode"));
//		dto.setSubject(request.getParameter("subject"));
//		dto.setGrade(request.getParameter("grade"));
		
		n = dao.oMInsert(dto);
		
		if(n == 1) {
			response.setContentType("text/html; charset=utf-8");
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('입력 성공!');");
				out.println("location.href='oMInsert.html';");
				out.println("</script>");
				out.flush();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else { 
			response.setContentType("text/html; charset=utf-8");
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('입력 실패!');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
