package java_2017_12_12.board.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAODb {
	/*
		목차
		작업1 Singleton Start
		작업2 DB연결작업 
		작업3 게시판의 글의 수 받아오기
		작업4 게시판의 모든 내용 받아오기
	*/
	
	//작업1 Singleton Start-------------------->
	private static BoardDAODb instance = new BoardDAODb();
	//Singleton패턴 구성 하나의 클래스로 하나의 객체만 생성하여 작업
	public static BoardDAODb getInstance() {return instance;}
		
	private BoardDAODb(){}
	//END Singleton ----------------------------->
		
	/*작업2 DB연결작업 ---------------------------------*/
	private Connection getConnection() throws Exception{
		//DBCP Pool API
		Context con = new InitialContext();
		Context envcon = (Context)con.lookup("java:comp/env");
		DataSource ds = (DataSource)envcon.lookup("jdbc/jsptest");
		//jspstudy는 집 학원 : jsptest
		return ds.getConnection();
	}
	/*END DB Connection------------------------------*/
	
	/*작업3 게시판의 글의 수 받아오기-----------------------*/
	public int getArticleCnt() {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
		int rtIv = 0;
		
		try {
            conn = getConnection();
            System.out.println("디비 연결됨");
            pstmt = conn.prepareStatement("select count(*) from board");
            rs = pstmt.executeQuery();

            if (rs.next()) 
            	rtIv= rs.getInt(1);
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
        }
		return rtIv;
	}
	/*END 게시판의 글의 수 받아오기-----------------------*/
	
	/*작업4 게시판의 모든 내용 받아오기---------------------*/
	public List<BoardBeanDb> getArticle() {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<BoardBeanDb> list = null;
        try {
            conn = getConnection();
            System.out.println("글목록 DB 연결됨");
            pstmt = conn.prepareStatement(
            		"select * from board order by ref desc, re_step asc");
            rs = pstmt.executeQuery();

            if(rs.next()) {
            	list = new ArrayList<BoardBeanDb>();
            	while(rs.next()) {
            		BoardBeanDb bbd = new BoardBeanDb();
                	bbd.setNum(rs.getInt(1));
                	bbd.setWriter(rs.getString(2));
                	bbd.setSubject(rs.getString(3));
                	bbd.setPasswd(rs.getString(4));
                	bbd.setReg_date(rs.getTimestamp(5));
                	bbd.setReadcount(rs.getInt(6));
                	bbd.setRef(rs.getInt(7));
                	bbd.setRe_step(rs.getInt(8));
                	bbd.setRe_level(rs.getInt(9));
                	bbd.setContent(rs.getString(10));
                	bbd.setIp(rs.getString(11));
                	list.add(bbd);
            	}            	      	
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try{ rs.close(); }catch(SQLException ex) {}
            if (pstmt != null) try{ pstmt.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
        }
        return list;
	}
	/*END 게시판의 모든 내용 받아오기----------------------*/
}
