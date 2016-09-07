package proxy.staticproxy;

public class DBQueryProxy implements IDBQuery{

	private static DBQuery query;
	
	static{
		if(query == null){
			query = new DBQuery();
		}
	}
	
	@Override
	public String request() {
		return query.request();
	}
	
	public static void main(String[] args) {
		DBQueryProxy proxy = new DBQueryProxy();
		String request = proxy.request();
		System.out.println(request);
	}

}
