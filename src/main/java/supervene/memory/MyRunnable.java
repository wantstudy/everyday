package supervene.memory;

/**
 * http://ifeve.com/java-memory-model-6/
 * @author wangweiwei
 *
 */
public class MyRunnable implements Runnable{

	@Override
	 public void run() {
        methodOne();
    }

    @SuppressWarnings("unused")
	public void methodOne() {
        int localVariable1 = 45;

        MySharedObject localVariable2 =
            MySharedObject.sharedInstance;

        //... do more with local variables.

        methodTwo();
    }

    @SuppressWarnings("unused")
	public void methodTwo() {
        Integer localVariable1 = new Integer(99);

        //... do more with local variable.
    }


}
