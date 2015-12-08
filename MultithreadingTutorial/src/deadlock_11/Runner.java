package deadlock_11;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private Account account1 = new Account();
	private Account account2 = new Account();

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();

	private void acquireLocks(Lock l1, Lock l2) throws InterruptedException {
		while (true) {
			boolean gotFIrstLock = false;
			boolean gotSecondLock = false;

			try {
				gotFIrstLock = l1.tryLock();
				gotSecondLock = l2.tryLock();
			} finally {
				if (gotFIrstLock && gotSecondLock) {
					return;
				}
				if (gotFIrstLock) {
					l1.unlock();
				}
				if (gotSecondLock) {
					l2.unlock();
				}
			}

			// loks not acquired
			Thread.sleep(1);
		}
	}

	public void firthThread() throws InterruptedException {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			acquireLocks(lock1, lock2);
			try {
				Account.transfer(account1, account2, 100);
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	
	
	
	
	

	public void secondThread() {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			try {
				acquireLocks(lock1, lock2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Account.transfer(account1, account2, 100);
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}

	}

	public void finished() {
		int bal1 = account1.getBalance();
		int bal2 = account2.getBalance();
		System.out.println("Account 1 balanse is: " + bal1);
		System.out.println("Account 2 balanse is: " + bal2);
		System.out.println("..Total balance is: " + (bal1 + bal2));
	}
}
