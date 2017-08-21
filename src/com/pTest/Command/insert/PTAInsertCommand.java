package com.pTest.Command.insert;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pTest.Command.PCommand;
import com.pTest.DAO.DAO;
import com.pTest.DTO.DTO;

public class PTAInsertCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		ArrayList<DTO> list = new ArrayList<DTO>();

		String[] tnums = request.getParameterValues("tnum");
		String[] tas = request.getParameterValues("ta");
		String sc = request.getParameter("scode");
		String ty = request.getParameter("tyear");
		
		for(int i = 0; i < tnums.length; i++) {
			DTO dto = new DTO();
			
			dto.setTnum(tnums[i]);
			dto.setTa(tas[i]);
			dto.setScode(sc);
			dto.setTyear(ty);
			list.add(dto);			
		}
		dao.tAInsert(list);

	}

}
