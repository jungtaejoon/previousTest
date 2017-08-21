package com.pTest.Command.insert;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pTest.Command.PCommand;
import com.pTest.DAO.DAO;
import com.pTest.DTO.DTO;

public class PTInsertCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		ArrayList<DTO> list = new ArrayList<DTO>();
//		int n = 0;
		ArrayList<DTO> list2 = new ArrayList<DTO>();
		ArrayList<DTO> list3 = new ArrayList<DTO>();
		
		String[] tnums = request.getParameterValues("tnum");
		String[] tqs = request.getParameterValues("tq");
		String[] b1s = request.getParameterValues("b1");
		String[] b2s = request.getParameterValues("b2");
		String[] b3s = request.getParameterValues("b3");
		String[] b4s = request.getParameterValues("b4");
		String[] outbsns = request.getParameterValues("outbsn");
		String[] inbns = request.getParameterValues("inbn");
		String sc = request.getParameter("scode");
		String ty = request.getParameter("tyear");
		
//		for(int i = 0; i < outbsns.length; i++) {
//			System.out.println(outbsns[i]);
//		}
		
		for(int i = 0; i < tnums.length; i++) {
			DTO dto = new DTO();
			
			dto.setTnum(tnums[i]);
			dto.setTq(tqs[i]);
			dto.setB1(b1s[i]);
			dto.setB2(b2s[i]);
			dto.setB3(b3s[i]);
			dto.setB4(b4s[i]);
			dto.setScode(sc);
			dto.setTyear(ty);
			if(outbsns != null ) {
				for(int j = 0; j < outbsns.length; j++) {
					if(outbsns[j].equals(tnums[i])) {
						DTO dt = new DTO();
						dt.setScode(sc);
						dt.setTyear(ty);
						dt.setOutbsn(outbsns[j]);
						dt.setOutbcap(request.getParameter("outbcap" + tnums[i]));
						list2.add(dt);
					}
				}
			}
			if(inbns != null ) {	
				for(int j = 0; j < inbns.length; j++) {
					if(inbns[j].equals(tnums[i])) {
						DTO dt = new DTO();
						dt.setScode(sc);
						dt.setTyear(ty);
						dt.setTnum(tnums[i]);
						list3.add(dt);
					}
				}
			}
			list.add(dto);			
		}

		
		dao.tInsert(list, list2, list3);

	}

}
