package java_2017_12_08.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import crypt.BCrypt;
import crypt.SHA256;

public class MemberDAODb {
	final int CONFIRM = 1;//db�۾��� ���� ó���Ǿ�����
	final int NOPASS = 0;//�н����尡 Ʋ�����
	final int NOID = -1;//���̵� Ʋ�����
	/*
		����
		�۾�1 Singleton Start
		�۾�2 DB�����۾� 
		�۾�3 ȸ�� ����
		�۾�4 ���̵� �ߺ� üũ
		�۾�5 ȸ������ ���� insert
	*/
	
	//�۾�1 Singleton Start-------------------->
	private static MemberDAODb instance = new MemberDAODb();
	//Singleton���� ���� �ϳ��� Ŭ������ �ϳ��� ��ü�� �����Ͽ� �۾�
	public static MemberDAODb getInstance() {return instance;}
		
	private MemberDAODb(){}
	//END Singleton ----------------------------->
		
	/*�۾�2 DB�����۾� ---------------------------------*/
	private Connection getConnection() throws Exception{
		//DBCP Pool API
		Context con = new InitialContext();
		Context envcon = (Context)con.lookup("java:comp/env");
		DataSource ds = (DataSource)envcon.lookup("jdbc/jspstudy");
		return ds.getConnection();
	}
	/*END DB Connection------------------------------*/
	
	/*�۾�3 ȸ�� ���� ------------------------------*/
	public int userCheck(String id, String passwd) {//���ϰ��� ���ڷ� ���ش�.
		String sql = "";//sql���� �����ϱ� ���� ����
		int rtIv = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		SHA256 sha = SHA256.getInsatnce();
		try {
			conn = getConnection();
			String shaPass = sha.getSha256(passwd.getBytes());
			sql = "select passwd from member2 where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String dbpasswd= rs.getString("passwd"); 
				if(BCrypt.checkpw(shaPass,dbpasswd))
					rtIv = CONFIRM; //��������
				else
					rtIv = NOPASS; //��й�ȣ Ʋ��
			}else {
				rtIv = NOID;//���̵� Ʋ��
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (ps != null) try { ps.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return rtIv;//����� ����
	}
	/*END ȸ�� ���� -------------------------------*/
	
	/*�۾�4 ���̵� �ߺ� üũ ------------------------------*/
	public int idCheck(String id) {
		String sql = "";//sql���� �����ϱ� ���� ����
		int rtIv = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			sql = "select count(*) from member2 where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1) >= 1) {
					rtIv = NOID; //�ߺ��� ���̵� ���� -1
				}else if(rs.getInt(1) == 0){
					rtIv = CONFIRM; //�ߺ��� ���̵� ���� 1
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (ps != null) try { ps.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return rtIv;
	}
	/*END ���̵� �ߺ� üũ ------------------------------*/
	
	/*�۾�5 ȸ������ ���� insert -------------------------*/
	public int insertMember(String id, String passwd, String name, String addr, String tel) {
		String sql = "";//sql���� �����ϱ� ���� ����
		int result = 0;
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		Connection conn = null;
		PreparedStatement ps = null;
		SHA256 sha = SHA256.getInsatnce();
		try {
			String orgPass = passwd;
            String shaPass = sha.getSha256(orgPass.getBytes());
        	String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());
			conn = getConnection();
			sql = "insert into MEMBER2 values(?, ?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, id);ps.setString(2, bcPass);ps.setString(3, name);
			ps.setTimestamp(4, reg_date);ps.setString(5, addr);ps.setString(6, tel);
			System.out.println(id + "," + name + "," + reg_date + "," + addr + "," + tel);
			System.out.println(bcPass);
			result = ps.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
            if (ps != null) try { ps.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return result;
	}
	/*END ȸ������ ���� insert -------------------------*/
}