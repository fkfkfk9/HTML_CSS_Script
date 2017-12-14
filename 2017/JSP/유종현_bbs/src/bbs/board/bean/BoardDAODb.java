package bbs.board.bean;

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
		�۾�5 �Խ��� INSERT
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
            System.out.println("�÷� �� ��� �����");
            pstmt = conn.prepareStatement("select count(*) from board");
            rs = pstmt.executeQuery();

            if (rs.next()) 
            	rtIv= rs.getInt(1);
            	System.out.println(rtIv);
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
            	do{
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
                	//if(list.size() == pageSize) break;
            	} while(rs.next());           	      	
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
	
	/*�۾�5 �Խ��� INSERT------------------------------*/
	public int insertBoard(BoardBeanDb bbd) {
		int rtIs = 0;		
		Connection conn = null;
        PreparedStatement ps = null;
        String sql="";
        
		int num = bbd.getNum();//������� �۹�ȣ 0�� ��� ����� �ƴϴ�.
		int ref = bbd.getRef();//������� �׷�ȭ ���̵�
		int re_step = bbd.getRe_step();//�׷쳻�� ���Ǽ���
		int re_level = bbd.getRe_level();//�������� �鿩����
		try {
            conn = getConnection();
            if (num!=0){//��� - ������� �۹�ȣ ����
  		      sql="update board set re_step=re_step+1 where ref= ? and re_step> ?";
              ps = conn.prepareStatement(sql);
              ps.setInt(1, ref);
  			  ps.setInt(2, re_step);
  			  ps.executeUpdate();
  			  re_step=re_step+1;
  			  re_level=re_level+1;
  		    }else{//����� - �۹�ȣ ����
  			  re_step=0;
  			  re_level=0;
  		    }
            sql = "insert into board(num, writer,subject,passwd,reg_date,";
		    sql+="re_step,re_level, content, ip, ref) values(board_seq.nextval,?";
		    if(num == 0) sql+=",?,?,?,?,?,?,?,board_seq.currval)";
		    else sql+=",?,?,?,?,?,?,?,?)";
		    System.out.println(sql);
		    ps = conn.prepareStatement(sql);
		    ps.setString(1, bbd.getWriter());
		    ps.setString(2, bbd.getSubject());
		    ps.setString(3, bbd.getPasswd());
		    ps.setTimestamp(4, bbd.getReg_date());
		    ps.setInt(5, re_step);
		    ps.setInt(6, re_level);
		    ps.setString(7, bbd.getContent());
		    ps.setString(8, bbd.getIp());
		    if(num != 0) ps.setInt(9, ref);
		    rtIs = ps.executeUpdate();
		}catch(Exception ex) { ex.printStackTrace();
		}finally{
            if (ps != null) try{ ps.close(); }catch(SQLException ex) {}
            if (conn != null) try{ conn.close(); }catch(SQLException ex) {}
        }		
		return rtIs;
	}
	/*END �Խ��� INSERT-------------------------------*/
	
}
