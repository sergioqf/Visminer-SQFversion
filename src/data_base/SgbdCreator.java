package data_base;

public abstract class SgbdCreator{

	
	
	public static IDbDAO create(String chose) {
		
			if( chose.equalsIgnoreCase("oracle")) {
				return new DbOracle();			
			} else if ( chose.equalsIgnoreCase("mysql")) {
				return new DbMysql();
			} else if ( chose.equalsIgnoreCase("ibm db2")) {
				return new DbDb2();
			} else {
				throw new IllegalArgumentException (" Tipo de SGBD n‹o suportado ");
			}
	}

	

}
