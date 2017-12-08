package java_2017_12_08.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import work.crypt.BCrypt;
import work.crypt.SHA256;

public class MemberDAODb {
	final int CONFIRM = 1;//db작업이 정상 처리되었을때
	final int NOPASS = 0;//패스워드가 틀린경우
	final int NOID = -1;//아이디가 틀린경우
	
	//작업1 Singleton Start-------------------->
	private static MemberDAODb instance = new MemberDAODb();
	//Singleton패턴 구성 하나의 클래스로 하나의 객체만 생성하여 작업
	public static MemberDAODb getInstance() {return instance;}
		
	private MemberDAODb(){}
	//END Singleton ----------------------------->
		
	/*작업2 DB연결작업 ---------------------------------*/
	private Connection getConnection() throws Exception{
		//DBCP Pool API
		Context con = new InitialContext();
		Context envcon = (Context)con.lookup("java:comp/env");
		DataSource ds = (DataSource)envcon.lookup("jdbc/jsptest");
		return ds.getConnection();
	}
	/*END DB Connection------------------------------*/
	
	/*작업3 회원 인증 ------------------------------*/
	public int userCheck(String id, String passwd) {//리턴값을 숫자로 해준다.
		String sql = "";//sql문을 정의하기 위한 변수
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
					rtIv = CONFIRM; //인증성공
				else
					rtIv = NOPASS; //비밀번호 틀림
			}else {
				rtIv = NOID;//아이디 틀림
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (ps != null) try { ps.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return rtIv;//결과값 리턴
	}
	/*END 회원 인증 -------------------------------*/
}
