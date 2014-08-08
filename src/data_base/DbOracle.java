package data_base;

public class DbOracle implements IDbDAO{

	@Override
	public String setDb(){
		return "oracle.jdbc.driver.OracleDriver";
	}

	@Override
	public String setUrl() {
		return "jdbc:oracle:thin:@//";
	}




}
