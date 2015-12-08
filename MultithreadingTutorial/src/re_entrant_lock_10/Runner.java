package re_entrant_lock_10;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private int count = 0;

	public void firstTHread() throws InterruptedException {
		lock.lock();
		condition.await();

		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();

		System.out.println("Press return key..");
		new Scanner(System.in).nextLine();
		System.out.println("Fot return key!");

		condition.signal();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("...finished..");
		System.out.println("COunt is: " + count);
	}

	private void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}
}
