package bean.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import enumfile.ReturnInt;
import work.crypt.BCrypt;
import work.crypt.SHA256;

public class MemberDAOBean {
	/*
		����
		�۾�1 Singleton Start
		�۾�2 DB�����۾� 	
		�۾�3 �α��� ���� Ȯ��
	*/
	//�۾�1 Singleton Start-------------------->
	private static MemberDAOBean instance = new MemberDAOBean();
	//Singleton���� ���� �ϳ��� Ŭ������ �ϳ��� ��ü�� �����Ͽ� �۾�
	public static MemberDAOBean getInstance() {
    	return instance;
    }
	//END Singleton ----------------------------->
	
	/*�۾�2 DB�����۾� ---------------------------------*/
    private MemberDAOBean() {}
   
    private Connection getConnection() throws Exception {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource)envCtx.lookup("jdbc/homepage");
        return ds.getConnection();
    }
    /*END DB Connection------------------------------*/
    
    /*�۾�3 �α��� ���� Ȯ��------------------------------*/
    //�������� ���� id�� pass�� �޾� DB�� ��ġ�ϴ��� Ȯ�� �� ������� m_level�� int�� �迭�� ��ȯ
    public int[] getLoginCheck(String id, String pass) {
    	System.out.println("�α��� DAO����" + id + pass);
    	int iArr[] = new int[2];//������ int�迭
    	int rtIv = ReturnInt.FAIL.getValue();//������ ���� int�� ���¸� �������ش�.
    	//ReturnInt�� ���ϰ� ����� ���������� �̸� �����س��Ҵ�.
    	int m_level=0;
    	String sql = "";
    	Connection conn = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	SHA256 sha = SHA256.getInsatnce();
    	
    	try {
    		conn = getConnection();//DB�� ���������� ����
    		
    		String orgPass = pass;
            String shaPass = sha.getSha256(orgPass.getBytes());
    		
    		sql = "select pass, m_level from member where id=?";//���̵� ���� �н����带 �������� sql��
    		ps = conn.prepareStatement(sql);//sql���� �־��ش�.
    		ps.setString(1, id);//sql���� id�� ����
    		rs = ps.executeQuery();//DB���� ������ ������� ������� rs�� �޾ƿ´�.
    		System.out.println("�α��� sql���� ����");
    		if(rs.next()) {//DB�� id�� �ش��ϴ� ���� ���� ���
    			String dbpass= rs.getString("pass");
    			m_level = rs.getInt("m_level");
				if(BCrypt.checkpw(shaPass,dbpass)) rtIv = ReturnInt.SUCCESS.getValue();
				//��ȣ�� ������ 1�� ����
				else rtIv = ReturnInt.FAIL.getValue();
				//��ȣ�� Ʋ���� -1 ����
    		}else rtIv = ReturnInt.ERROR.getValue();
    		//0�� ���������μ� ���� ���̵��°��� �˸���. 
    	}catch(Exception ex) {ex.printStackTrace();} 
    	finally {
            if (rs != null)	try { rs.close(); } catch(SQLException ex) {}
            if (ps != null)	try { ps.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }    	
    	iArr[0] = rtIv; iArr[1] = m_level;//0���� �������� 1���� ����� ������ �����Ͽ� ����
    	return iArr;//��� ���� ����
    }
    /*END  �α��� ���� Ȯ��------------------------------*/
}
