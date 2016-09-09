package supervene.basis;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntergerTest {

	public static void main(String[] args) {
		testAtomicInteger();
	}

	private static void testAtomicInteger() {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		System.out.println(atomicInteger.get());
		System.out.println(atomicInteger.getAndIncrement());
		System.out.println(atomicInteger.get());
		System.out.println(atomicInteger.getAndDecrement());
	}
}
