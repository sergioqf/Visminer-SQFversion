package data_base;

public class DbMysql implements IDbDAO{
	
	@Override
	public String setDb(){
		return "com.mysql.jdbc.Driver";
	}

	@Override
	public String setUrl() {
		return "jdbc:mysql://";
	}
	
	
}
