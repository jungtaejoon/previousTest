package com.pTest.Command.insert;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pTest.Command.PCommand;
import com.pTest.DAO.DAO;
import com.pTest.DTO.DTO;

public class PBInsertCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("EUC-KR");
		String uploadFolder = "BImg";
		String path = request.getServletContext().getRealPath(uploadFolder);
		int maxSize = 1024 * 1024 * 200;
		String encType = "EUC-KR";
//		System.out.println(path);
		File p = new File(path);
		if(!p.exists()) {
			p.mkdirs();
		}
		try {
			MultipartRequest multi = new MultipartRequest(request, path, maxSize, encType, new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			String[] hvo = multi.getParameterValues("hvo");
			String[] hvi = multi.getParameterValues("hvi");
			Vector<String> outbsrcs = new Vector<String>();
			Vector<String> inbsrcs = new Vector<String>();
//			System.out.println(multi.getFile("outbsrc1"));
			while(files.hasMoreElements()) {
				String fname = (String)files.nextElement();
//				System.out.println(fname + "!!!");
				if(fname.substring(0, 7).equals("outbsrc")) {
					outbsrcs.add(fname);
				}
				else if(fname.substring(0, 6).equals("inbsrc")){
					inbsrcs.add(fname);
				}
				else {
					System.out.println("files Error!!");
					System.exit(-1);
				}
			}
//			for(int i = 0; i < outbsrcs.size(); i++) {
//				System.out.println(outbsrcs.get(i));
//				System.out.println(outbsrcs.size());
//			}
//			for(int i = 0; i < inbsrcs.size(); i++) {
//				System.out.println(inbsrcs.get(i));
//			}
			
			ArrayList<DTO> oList = new ArrayList<DTO>();
			ArrayList<DTO> iList = new ArrayList<DTO>();
			if(hvo != null) {
				for(int i = 0; i < hvo.length; i++) {
					DTO dto = new DTO();
					dto.setScode(multi.getParameter("scode"));
					dto.setTyear(multi.getParameter("tyear"));
					for(int j = 0; j < outbsrcs.size(); j++) {
						if(outbsrcs.get(j).substring(7).equals(hvo[i]) && multi.getFile(outbsrcs.get(j)) != null) {
//							System.out.println(dto.getScode());
//							System.out.println(multi.getFile(outbsrcs.get(j)).toString().indexOf(uploadFolder));
//							System.out.println(multi.getFile(outbsrcs.get(j)).toString().substring(multi.getFile(outbsrcs.get(j)).toString().indexOf(uploadFolder)));
							dto.setOutbsrc(multi.getFile(outbsrcs.get(j)).toString().substring(multi.getFile(outbsrcs.get(j)).toString().indexOf(uploadFolder)));
						}
					}
					dto.setOutbsn(multi.getParameter("outbsn" + hvo[i]));
					dto.setOutbcap(multi.getParameter("outbcap" + hvo[i]));
//					System.out.println(dto.getScode());
//					System.out.println(dto.getTyear());
//					System.out.println(dto.getOutbsn());
//					System.out.println(dto.getOutbcap());
//					System.out.println(dto.getOutbsrc());
					oList.add(dto);
				}				
			}
			if(hvi != null) {
				for(int i = 0; i < hvi.length; i++) {
					DTO dto = new DTO();
					dto.setScode(multi.getParameter("scode"));
					dto.setTyear(multi.getParameter("tyear"));
					for(int j = 0; j < inbsrcs.size(); j++) {
						if(inbsrcs.get(j).substring(6).equals(hvi[i]) && multi.getFile(inbsrcs.get(j)) != null) {
							dto.setInbsrc(multi.getFile(inbsrcs.get(j)).toString().substring(multi.getFile(inbsrcs.get(j)).toString().indexOf(uploadFolder)));
						}
					}
					dto.setTnum(multi.getParameter("tnum" + hvi[i]));
//					System.out.println(dto.getScode());
//					System.out.println(dto.getTyear());
//					System.out.println(dto.getTnum());
//					System.out.println(dto.getInbsrc());
					iList.add(dto);
				}
			}
//			System.out.println("!!!!!!!");
			DAO dao = new DAO();
			dao.bInsert(oList, iList);
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}

}
