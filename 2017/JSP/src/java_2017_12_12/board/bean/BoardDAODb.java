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
		����
		�۾�1 Singleton Start
		�۾�2 DB�����۾� 
		�۾�3 �Խ����� ���� �� �޾ƿ���
		�۾�4 �Խ����� ��� ���� �޾ƿ���
	*/
	
	//�۾�1 Singleton Start-------------------->
	private static BoardDAODb instance = new BoardDAODb();
	//Singleton���� ���� �ϳ��� Ŭ������ �ϳ��� ��ü�� �����Ͽ� �۾�
	public static BoardDAODb getInstance() {return instance;}
		
	private BoardDAODb(){}
	//END Singleton ----------------------------->
		
	/*�۾�2 DB�����۾� ---------------------------------*/
	private Connection getConnection() throws Exception{
		//DBCP Pool API
		Context con = new InitialContext();
		Context envcon = (Context)con.lookup("java:comp/env");
		DataSource ds = (DataSource)envcon.lookup("jdbc/jsptest");
		//jspstudy�� �� �п� : jsptest
		return ds.getConnection();
	}
	/*END DB Connection------------------------------*/
	
	/*�۾�3 �Խ����� ���� �� �޾ƿ���-----------------------*/
	public int getArticleCnt() {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
		int rtIv = 0;
		
		try {
            conn = getConnection();
            System.out.println("��� �����");
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
	/*END �Խ����� ���� �� �޾ƿ���-----------------------*/
	
	/*�۾�4 �Խ����� ��� ���� �޾ƿ���---------------------*/
	public List<BoardBeanDb> getArticle() {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<BoardBeanDb> list = null;
        try {
            conn = getConnection();
            System.out.println("�۸�� DB �����");
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
	/*END �Խ����� ��� ���� �޾ƿ���----------------------*/
}
