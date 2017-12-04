package db;

public class DbInfo {
	private final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private final String ID = "jsp_user";
	private final String PW = "1111";
	public String getURL() {return URL;}
	public String getID() {	return ID;}
	public String getPW() {	return PW;}			
}
