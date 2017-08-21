package com.pTest.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.pTest.DTO.DTO;

public class DAO {
private DataSource dataSource;
    
    public DAO() {
    	           
        try {
        	Context context = new InitialContext();
        	dataSource = (DataSource)context.lookup("java:comp/env/jdbc/mariadb");
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
    public int mCodeChk(String culval) {
		String table = "major";
		String cul = "mcode";
		String query = "select "+ cul + " from " + table + " where " + cul + " = ?";
		
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int n = 0;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, culval);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				n = 1;
			}else n = 0;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return n;
	}
    public int sCodeChk(String culval) {
		String table = "subj";
		String cul = "scode";
		String query = "select "+ cul + " from " + table + " where " + cul + " = ?";
		
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int n = 0;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, culval);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				n = 1;
			}else n = 0;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return n;
	}
    public int majorInsert(DTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		String query = "insert into major (mcode, mname) values (?, ?)";
		int n = 0;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, dto.getMcode());
			ps.setString(2, dto.getMname());
			
			n = ps.executeUpdate();
			
			if(n == 1) {
				System.out.println("insert success");
			} else { 
				System.out.println("insert fail");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return n;
	}
    public int subjInsert(DTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		String query = "insert into subj (scode, sname, mcode, morc) values (?, ?, ?, ?)";
		int n = 0;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, dto.getScode());
			ps.setString(2, dto.getSname());
			ps.setString(3, dto.getMcode());
			ps.setString(4, dto.getMorc());
			
			n = ps.executeUpdate();
			
			if(n == 1) {
				System.out.println("insert success");
			} else { 
				System.out.println("insert fail");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return n;
	}
    public ArrayList<DTO> getMcode() {
    	
    	ArrayList<DTO> mList = new ArrayList<DTO>();
    	
		String query = "select * from major";
		
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
    	
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setMcode(rs.getString("mcode"));
				dto.setMname(rs.getString("mname"));
//				System.out.println(dto.getMcode());
//				System.out.println(dto.getMname());
				mList.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return mList;		
	}
    public int oMCodeChk(String culval1, String culval2) {
		String table = "openedmaj";
		String cul1 = "mcode";
		String cul2 = "yosaSeme";
		String query = "select "+ cul1 + " from " + table + " where " + cul1 + " = ? and " + cul2 + " = ?";
		
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int n = 0;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, culval1);
			ps.setString(2, culval2);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				n = 1;
			}
			else n = 0;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return n;
	}
    public int oMInsert(DTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		String query = "insert into openedmaj (yosaSeme, mcode) values (?, ?)";
		int n = 0;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, dto.getYosaSeme());
			ps.setString(2, dto.getMcode());

			n = ps.executeUpdate();
			
			if(n == 1) {
				System.out.println("insert success");
			} else { 
				System.out.println("insert fail");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return n;
	}
	public void oSInsert(ArrayList<DTO> list) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		String query = "insert into openedsubj (yosaSeme, mcode, scode, grade) values (?, ?, ?, ?)";
				
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			Iterator<DTO> it = list.iterator();
			
			while(it.hasNext()) {
				DTO dto = new DTO();
				dto = it.next();
				ps.setString(1, dto.getYosaSeme());
				ps.setString(2, dto.getMcode());
				ps.setString(3, dto.getScode());
				ps.setString(4, dto.getGrade());
			
				ps.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<DTO> getYSMcode(String yosaSeme) {
		// TODO Auto-generated method stub
    	ArrayList<DTO> list = new ArrayList<DTO>();
    	
		String query = "select * from major, openedmaj where major.mcode = openedmaj.mcode and yosaSeme = ?";
		
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
    	
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, yosaSeme);
						
			rs = ps.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setMcode(rs.getString("mcode"));
				dto.setMname(rs.getString("mname"));
//				System.out.println(dto.getMcode());
//				System.out.println(dto.getMname());
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<DTO> getYSScode(String yosaSeme, String mcode, String grade) {
		// TODO Auto-generated method stub
		ArrayList<DTO> list = new ArrayList<DTO>();
    	
		String query = "select * from subj, openedsubj where subj.scode = openedsubj.scode and yosaSeme = ? and openedsubj.mcode = ? and grade = ?";
		
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
    	
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, yosaSeme);
			ps.setString(2, mcode);
			ps.setString(3, grade);
						
			rs = ps.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setScode(rs.getString("Scode"));
				dto.setSname(rs.getString("Sname"));
//				System.out.println(dto.getScode());
//				System.out.println(dto.getSname());
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public void tInsert(ArrayList<DTO> list, ArrayList<DTO> list2, ArrayList<DTO> list3) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement pschk = null;
		PreparedStatement psu = null;

		PreparedStatement pso = null;
		PreparedStatement psochk = null;
		PreparedStatement psou = null;

		PreparedStatement psi = null;
		PreparedStatement psichk = null;
		
		String query = "insert into pt (tnum, tq, b1, b2, b3, b4, scode, tyear) values (?, ?, ?, ?, ?, ?, ?, ?)";
		String qchk = "select tnum from pt where scode = ? and tyear = ? and tnum = ?;";
		String qu = "update pt set tq = ?, b1 = ?, b2 = ?, b3 = ?, b4 = ? where scode =? and tyear = ? and tnum = ?;";

		String qo = "insert into outb (scode, tyear, outbsn, outbcap) values (?, ?, ?, ?)";
		String qochk = "select outbsn from outb where scode = ? and tyear = ? and outbsn = ?;";
		String qou = "update outb set outbcap = ? where scode = ? and tyear = ? and outbsn = ?;";

		String qi = "insert into inb (scode, tyear, tnum) values (?, ?, ?)";
		String qichk = "select tnum from inb where scode = ? and tyear = ? and tnum = ?;";
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			pschk = con.prepareStatement(qchk);
			psu = con.prepareStatement(qu);
			pso = con.prepareStatement(qo);
			psochk = con.prepareStatement(qochk);
			psou = con.prepareStatement(qou);
			psi = con.prepareStatement(qi);
			psichk = con.prepareStatement(qichk);
			
			Iterator<DTO> it = list.iterator();
			
			while(it.hasNext()) {
				DTO dto = new DTO();
				dto = it.next();
				
				pschk.setString(1, dto.getScode());
				pschk.setString(2, dto.getTyear());
				pschk.setString(3, dto.getTnum());
				ResultSet rs = pschk.executeQuery();
				
				if(rs.next()) {
					psu.setString(1, dto.getTq());
					psu.setString(2, dto.getB1());
					psu.setString(3, dto.getB2());
					psu.setString(4, dto.getB3());
					psu.setString(5, dto.getB4());
					psu.setString(6, dto.getScode());
					psu.setString(7, dto.getTyear());
					psu.setString(8, dto.getTnum());
					psu.executeUpdate();
				}
				else{
					ps.setString(1, dto.getTnum());
					ps.setString(2, dto.getTq());
					ps.setString(3, dto.getB1());
					ps.setString(4, dto.getB2());
					ps.setString(5, dto.getB3());
					ps.setString(6, dto.getB4());
					ps.setString(7, dto.getScode());
					ps.setString(8, dto.getTyear());
					ps.executeUpdate();
				}
				try {
					if(rs != null) rs.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			it = list2.iterator();
			while(it.hasNext()) {
				DTO dto = new DTO();
				dto = it.next();

				psochk.setString(1, dto.getScode());
				psochk.setString(2, dto.getTyear());
				psochk.setString(3, dto.getOutbsn());
				ResultSet rs = psochk.executeQuery();
				
				if(rs.next()) {
					psou.setString(1, dto.getOutbcap());
					psou.setString(2, dto.getScode());
					psou.setString(3, dto.getTyear());
					psou.setString(4, dto.getOutbsn());
					psou.executeUpdate();
				}
				else{
					pso.setString(1, dto.getScode());
					pso.setString(2, dto.getTyear());
					pso.setString(3, dto.getOutbsn());
					pso.setString(4, dto.getOutbcap());
					pso.executeUpdate();
				}
				try {
					if(rs != null) rs.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}	
			it = list3.iterator();
			while(it.hasNext()) {
				DTO dto = new DTO();
				dto = it.next();

				psichk.setString(1, dto.getScode());
				psichk.setString(2, dto.getTyear());
				psichk.setString(3, dto.getTnum());
				ResultSet rs = psichk.executeQuery();
				
				if(rs.next()) {
					continue;
				}
				else {
					psi.setString(1, dto.getScode());
					psi.setString(2, dto.getTyear());
					psi.setString(3, dto.getTnum());
					psi.executeUpdate();
				}
				try {
					if(rs != null) rs.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}

			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(pschk != null) pschk.close();
				if(psu != null) psu.close();
				if(pso != null) pso.close();
				if(psochk != null) psochk.close();
				if(psou != null) psou.close();
				if(psi != null) psi.close();
				if(psichk != null) psichk.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<DTO> getOutB(String scode, String tyear) {
		// TODO Auto-generated method stub
    	ArrayList<DTO> list = new ArrayList<DTO>();
    	
		String query = "select * from outb where scode = ? and tyear = ?";
		
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
    	
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, scode);
			ps.setString(2, tyear);
						
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("outbcap") != null && rs.getString("outbsrc") != null) {
					continue;
				}
				else if(rs.getString("outbcap") != null) {
					DTO dto = new DTO();
					dto.setOutbsn(rs.getString("outbsn"));
					dto.setOutbcap(rs.getString("outbcap"));
//					System.out.println(dto.getOutbsn());
					list.add(dto);
				}
				else if(rs.getString("outbsrc") != null) {
					DTO dto = new DTO();
					dto.setOutbsn(rs.getString("outbsn"));
					dto.setOutbsrc(rs.getString("outbsrc"));
//					System.out.println(dto.getOutbsn());
					list.add(dto);
				}
				else {
					DTO dto = new DTO();
					dto.setOutbsn(rs.getString("outbsn"));
					list.add(dto);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<DTO> getInB(String scode, String tyear) {
		// TODO Auto-generated method stub
    	ArrayList<DTO> list = new ArrayList<DTO>();
    	
		String query = "select * from inb where scode = ? and tyear = ?";
		
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
    	
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, scode);
			ps.setString(2, tyear);
						
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("inbsrc") != null) continue;
				DTO dto = new DTO();
				dto.setTnum(rs.getString("tnum"));
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public void bInsert(ArrayList<DTO> oList, ArrayList<DTO> iList) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pso = null;
		PreparedStatement psi = null;
		PreparedStatement psocheck = null;
		PreparedStatement psicheck = null;
		PreparedStatement psoupdate = null;
		PreparedStatement psiupdate = null;

		
		String qo = "insert into outb (scode, tyear, outbsn, outbcap, outbsrc) values (?, ?, ?, ?, ?)";
		String qi = "insert into inb (scode, tyear, tnum, inbsrc) values (?, ?, ?, ?)";
		String qocheck = "select * from outb where scode = ? and tyear = ? and outbsn = ?";
		String qicheck = "select * from inb where scode = ? and tyear = ? and tnum = ?";
		String qoupdate = "update outb set outbcap = ?, outbsrc = ? where scode = ? and tyear = ? and outbsn = ?";
		String qiupdate = "update inb set inbsrc = ? where scode = ? and tyear = ? and tnum = ?";
		
		
		try {
			con = dataSource.getConnection();
			pso = con.prepareStatement(qo);
			psi = con.prepareStatement(qi);
			psocheck = con.prepareStatement(qocheck);
			psicheck = con.prepareStatement(qicheck);
			psoupdate = con.prepareStatement(qoupdate);
			psiupdate = con.prepareStatement(qiupdate);
			
			Iterator<DTO> itO = oList.iterator();
			Iterator<DTO> itI = iList.iterator();
			
			while(itO.hasNext()) {
				DTO dto = new DTO();
				dto = itO.next();
//				System.out.println(dto.getOutbsn());
				psocheck.setString(1, dto.getScode());
				psocheck.setString(2, dto.getTyear());
				psocheck.setString(3, dto.getOutbsn());
				ResultSet rs = psocheck.executeQuery();
				if(rs.next()) {
					psoupdate.setString(1, dto.getOutbcap());
					psoupdate.setString(2, dto.getOutbsrc());
					psoupdate.setString(3, dto.getScode());
					psoupdate.setString(4, dto.getTyear());
					psoupdate.setString(5, dto.getOutbsn());
					psoupdate.executeUpdate();
				}
				else {
					pso.setString(1, dto.getScode());
					pso.setString(2, dto.getTyear());
					pso.setString(3, dto.getOutbsn());
					pso.setString(4, dto.getOutbcap());
					pso.setString(5, dto.getOutbsrc());
					pso.executeUpdate();
				}
				rs.close();
			}
			while(itI.hasNext()) {
				DTO dto = new DTO();
				dto = itI.next();
				psicheck.setString(1, dto.getScode());
				psicheck.setString(2, dto.getTyear());
				psicheck.setString(3, dto.getTnum());
				ResultSet rs = psicheck.executeQuery();
				if(rs.next()) {
					psiupdate.setString(1, dto.getInbsrc());
					psiupdate.setString(2, dto.getScode());
					psiupdate.setString(3, dto.getTyear());
					psiupdate.setString(4, dto.getTnum());
					psiupdate.executeUpdate();
				}
				else {
					psi.setString(1, dto.getScode());
					psi.setString(2, dto.getTyear());
					psi.setString(3, dto.getTnum());
					psi.setString(4, dto.getInbsrc());
					psi.executeUpdate();
				}
			}

			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(psocheck != null) psocheck.close();
				if(psicheck != null) psicheck.close();
				if(psoupdate != null) psoupdate.close();
				if(psiupdate != null) psiupdate.close();
				if(pso != null) pso.close();
				if(psi != null) psi.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<DTO> getT(String scode, String tyear) {
		// TODO Auto-generated method stub
		ArrayList<DTO> list = new ArrayList<DTO>();
    	
		String query = "select pto.tnum, tq, b1, b2, b3, b4, outbcap, outbsrc, inbsrc from (";
		query += "select pt.tnum, tq, b1, b2, b3, b4, outbcap, outbsrc, pt.scode, pt.tyear from pt ";
		query += "left outer join outb ";
		query += "on pt.tnum = outb.outbsn and pt.scode = outb.scode and ";
		query += "pt.tyear = outb.tyear where pt.scode = ? and pt.tyear = ?)pto ";
		query += "left outer join inb ";
		query += "on pto.tnum = inb.tnum and pto.scode = inb.scode and ";
		query += "pto.tyear = inb.tyear where pto.scode = ? and pto.tyear = ?;";
		
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
    	
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, scode);
			ps.setString(2, tyear);
			ps.setString(3, scode);
			ps.setString(4, tyear);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setTnum(rs.getString("tnum"));
				dto.setTq(rs.getString("tq"));
				dto.setB1(rs.getString("b1"));
				dto.setB2(rs.getString("b2"));
				dto.setB3(rs.getString("b3"));
				dto.setB4(rs.getString("b4"));
				dto.setOutbcap(rs.getString("outbcap"));
				dto.setOutbsrc(rs.getString("outbsrc"));
				dto.setInbsrc(rs.getString("inbsrc"));
//				System.out.println(dto.getOutbcap());
				list.add(dto);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public String tAChk(String scode, String tyear, String tnum) {
		// TODO Auto-generated method stub
		String query = "select ta from pt where scode = ? and tyear = ? and tnum = ?;";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String n = null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, scode);
			ps.setString(2, tyear);
			ps.setString(3, tnum);
			rs = ps.executeQuery();
			if(rs.next()) {
				n = rs.getString("ta");
			}
			else n = null;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return n;
	}
	public ArrayList<DTO> getTYear(String scode) {
		// TODO Auto-generated method stub
		ArrayList<DTO> list = new ArrayList<DTO>();
    	
		String query = "select distinct tyear from pt where scode = ?;";
		
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
    	
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, scode);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setTyear(rs.getString("tyear"));
				list.add(dto);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public ArrayList<DTO> getTnum(String scode, String tyear) {
		// TODO Auto-generated method stub
    	ArrayList<DTO> list = new ArrayList<DTO>();
    	
		String query = "select tnum, ta from pt where scode = ? and tyear = ?";
		
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
    	
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, scode);
			ps.setString(2, tyear);
						
			rs = ps.executeQuery();
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setTnum(rs.getString("tnum"));
				dto.setTa(rs.getString("ta"));
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public void tAInsert(ArrayList<DTO> list) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		
		String query = "update pt set ta = ? where scode = ? and tyear = ? and tnum = ?";
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			Iterator<DTO> it = list.iterator();
			
			while(it.hasNext()) {
				DTO dto = new DTO();
				dto = it.next();
				ps.setString(1, dto.getTa());
				ps.setString(4, dto.getTnum());
				ps.setString(2, dto.getScode());
				ps.setString(3, dto.getTyear());
				ps.executeUpdate();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public int tChk(String scode, String tyear) {
		// TODO Auto-generated method stub
		String query = "select tnum from pt where scode = ? and tyear = ?;";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int n = 0;
		
		try {
//			System.out.println(scode);
//			System.out.println(tyear);
//			System.out.println(tnum);
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, scode);
			ps.setString(2, tyear);
			rs = ps.executeQuery();
			if(rs.next()) {
				n = 1;
			}
			else n = 0;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return n;
	}
	public ArrayList<DTO> setT(String scode, String tyear) {
		// TODO Auto-generated method stub
		ArrayList<DTO> list = new ArrayList<DTO>();
    	
		String query = "select pto.tnum, tq, b1, b2, b3, b4, outbsn, outbcap, inb.tnum from (";
		query += "select pt.tnum, tq, b1, b2, b3, b4, outbsn, outbcap, pt.scode, pt.tyear from pt ";
		query += "left outer join outb ";
		query += "on pt.tnum = outb.outbsn and pt.scode = outb.scode and ";
		query += "pt.tyear = outb.tyear where pt.scode = ? and pt.tyear = ?)pto ";
		query += "left outer join inb ";
		query += "on pto.tnum = inb.tnum and pto.scode = inb.scode and ";
		query += "pto.tyear = inb.tyear where pto.scode = ? and pto.tyear = ?;";
		
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
    	
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, scode);
			ps.setString(2, tyear);
			ps.setString(3, scode);
			ps.setString(4, tyear);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				DTO dto = new DTO();
				dto.setTnum(rs.getString("pto.tnum"));
				dto.setTq(rs.getString("tq"));
				dto.setB1(rs.getString("b1"));
				dto.setB2(rs.getString("b2"));
				dto.setB3(rs.getString("b3"));
				dto.setB4(rs.getString("b4"));
				dto.setOutbsn(rs.getString("outbsn"));
				dto.setOutbcap(rs.getString("outbcap"));
				dto.setInbn(rs.getString("inb.tnum"));
				list.add(dto);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
