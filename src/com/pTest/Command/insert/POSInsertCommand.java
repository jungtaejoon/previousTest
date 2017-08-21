package com.pTest.Command.insert;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pTest.Command.PCommand;
import com.pTest.DAO.DAO;
import com.pTest.DTO.DTO;

public class POSInsertCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		DAO dao = new DAO();
		ArrayList<DTO> list = new ArrayList<DTO>();
//		int n = 0;
		
		String[] scodes = request.getParameterValues("scode");
		String mc = request.getParameter("mcode");
		String ys = request.getParameter("yosaSeme");
		String gr = request.getParameter("grade");
		
	
//		System.out.println(request.getParameter("mcode"));
		
		for(int i = 0; i < scodes.length; i++) {
			DTO dto = new DTO();
			
			dto.setYosaSeme(ys);
			dto.setMcode(mc);
			dto.setScode(scodes[i]);
			dto.setGrade(gr);	
			
			list.add(dto);			
		}

		
		dao.oSInsert(list);
	}

}
