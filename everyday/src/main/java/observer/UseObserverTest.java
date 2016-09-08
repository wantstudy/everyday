package observer;

public class UseObserverTest {

	public static void main(String[] args) {
		LookPeople lk = new LookPeople();
		SeeDoor seeDoor = new SeeDoor();
		lk.addObserver(seeDoor);
		lk.notifyObservers();
	}
}
