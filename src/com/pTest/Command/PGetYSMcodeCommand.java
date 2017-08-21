package com.pTest.Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pTest.DAO.DAO;
import com.pTest.DTO.DTO;

public class PGetYSMcodeCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("EUC-KR");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DAO dao = new DAO();

		ArrayList<DTO> majList = new ArrayList<DTO>();
		majList = dao.getYSMcode(request.getParameter("yosaSeme"));
		Gson gson = new Gson();
//		gson.toJson(majList);
		try {
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(majList));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(gson.toJson(majList));
	}

}
