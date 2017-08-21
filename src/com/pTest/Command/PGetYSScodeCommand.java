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

public class PGetYSScodeCommand implements PCommand {

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

		ArrayList<DTO> list = new ArrayList<DTO>();
		list = dao.getYSScode(request.getParameter("yosaSeme"), request.getParameter("mcode"), request.getParameter("grade"));
		Gson gson = new Gson();
//		gson.toJson(majList);
		try {
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(gson.toJson(list));
	}

}
