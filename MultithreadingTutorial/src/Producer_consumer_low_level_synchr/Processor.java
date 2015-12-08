package Producer_consumer_low_level_synchr;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author Alex
 *
 *         It's simple low level PRODUCER and CONSUMER simple wait & notify
 *
 *         +testJavaDoc
 */
public class Processor {
	private LinkedList<Integer> list = new LinkedList<>();
	private final int LIMIT = 10;
	private final Object lock = new Object();

	public void produce() throws InterruptedException {
		int value = 0;

		while (true) {
			synchronized (lock) {
				while (list.size() == LIMIT) {
					lock.wait();

				}
				list.add(value++);
				// System.out.println("Prodecer added: " + value + " ;qeeue
				// size: " + list.size());
				lock.notify();
			}
		}
	}

	public void consume() throws InterruptedException {
		// System.out.println("...consume...");
		while (true) {
			synchronized (lock) {
				while (list.size() == 0) {
					lock.wait();
				}

				int value = list.removeFirst();
				System.out.print("Removed valuse is: " + value);
				System.out.println(" ;now list size: " + list.size());
				lock.notify();
			}
			Thread.sleep(new Random().nextInt(1000));
		}
	}

}
