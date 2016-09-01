package parallel.guardedsuspension;

public class TestGuarde {

	public static void main(String[] args) {
		GrequestQueue queue = new GrequestQueue();
		
		for (int i = 0; i < 10; i++) {
			new ServerThread(queue, "ServerThread"+i).start();
		}
		
		for (int i = 0; i < 10; i++) {
			new ClientThread(queue, "ClientThread"+i).start();
		}
	}
	
}
