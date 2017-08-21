package com.pTest.frontController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pTest.Command.PCommand;
import com.pTest.Command.PGetInBCommand;
import com.pTest.Command.PGetMcodeCommand;
import com.pTest.Command.PGetOutBCommand;
import com.pTest.Command.PGetTCommand;
import com.pTest.Command.PGetTNumCommand;
import com.pTest.Command.PGetTYearCommand;
import com.pTest.Command.PGetYSMcodeCommand;
import com.pTest.Command.PGetYSScodeCommand;
import com.pTest.Command.PSetTCommand;
import com.pTest.Command.codeCheck.PMCodeCheckCommand;
import com.pTest.Command.insert.PBInsertCommand;
import com.pTest.Command.insert.PMInsertCommand;
import com.pTest.Command.codeCheck.PSCodeCheckCommand;
import com.pTest.Command.codeCheck.PTACheckCommand;
import com.pTest.Command.codeCheck.PTCheckCommand;
import com.pTest.Command.insert.PSInsertCommand;
import com.pTest.Command.insert.PTAInsertCommand;
import com.pTest.Command.insert.PTInsertCommand;
import com.pTest.Command.codeCheck.POMcodeCheckCommand;
import com.pTest.Command.insert.POMInsertCommand;
import com.pTest.Command.insert.POSInsertCommand;

/**
 * Servlet implementation class PFrontController
 */
@WebServlet("*.do")
public class PFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("UTF-8");
		String com = request.getRequestURI().substring(request.getContextPath().length());
		
		PCommand command = null;
		
		
		if(com.equals("/pMInsert.do")) {
			command = new PMInsertCommand();
			command.execute(request, response);
//			response.sendRedirect("insertSuccess.html");
		}
		if(com.equals("/pSInsert.do")) {
			command = new PSInsertCommand();
			command.execute(request, response);
//			response.sendRedirect("subjInsert.html");
		}
		if(com.equals("/mcodeCheck.do")) {
			command = new PMCodeCheckCommand();
			command.execute(request, response);
		}
		if(com.equals("/scodeCheck.do")) {
			command = new PSCodeCheckCommand();
			command.execute(request, response);
		}
		if(com.equals("/getMcode.do")) {
			command = new PGetMcodeCommand();
			command.execute(request, response);
		}
		if(com.equals("/oMInsert.do")) {
			command = new POMInsertCommand();
			command.execute(request, response);
		}
		if(com.equals("/oMCheck.do")) {
			command = new POMcodeCheckCommand();
			command.execute(request, response);
		}
		
		if(com.equals("/oSInsert.do")) {
			command = new POSInsertCommand();
			command.execute(request, response);
			response.sendRedirect("oSInsert.html");
		}
		if(com.equals("/getYSMcode.do")) {
			command = new PGetYSMcodeCommand();
			command.execute(request, response);
		}
		if(com.equals("/getYSScode.do")) {
			command = new PGetYSScodeCommand();
			command.execute(request, response);
		}
		if(com.equals("/pTInsert.do")) {
			command = new PTInsertCommand();
			command.execute(request, response);
			response.sendRedirect("testInsert.html");
		}
		if(com.equals("/getOutB.do")) {
			command = new PGetOutBCommand();
			command.execute(request, response);
		}
		if(com.equals("/getInB.do")) {
			command = new PGetInBCommand();
			command.execute(request, response);
		}
		if(com.equals("/pBInsert.do")) {
			command = new PBInsertCommand();
			command.execute(request, response);
			response.sendRedirect("bInsert.html");
		}
		if(com.equals("/getT.do")) {
			command = new PGetTCommand();
			command.execute(request, response);
		}
		if(com.equals("/taCheck.do")) {
			command = new PTACheckCommand();
			command.execute(request, response);
		}
		if(com.equals("/getTyear.do")) {
			command = new PGetTYearCommand();
			command.execute(request, response);
		}
		if(com.equals("/getTnum.do")) {
			command = new PGetTNumCommand();
			command.execute(request, response);
		}
		if(com.equals("/pTAInsert.do")) {
			command = new PTAInsertCommand();
			command.execute(request, response);
			response.sendRedirect("tAInsert.html");
		}
		if(com.equals("/tCheck.do")) {
			command = new PTCheckCommand();
			command.execute(request, response);
		}
		if(com.equals("/setT.do")) {
			command = new PSetTCommand();
			command.execute(request, response);
		}
							
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
