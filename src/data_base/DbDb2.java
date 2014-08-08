package data_base;

public class DbDb2 implements IDbDAO{
	
	@Override
	public String setDb(){
		return "com.ibm.db2.jcc.DB2Driver";
	}

	@Override
	public String setUrl() {
		return "jdbc:db2://";
	}
	
	
}
