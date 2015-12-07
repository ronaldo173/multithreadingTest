package LockObjects_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

	private Random random = new Random();
	private List<Integer> list = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	private Object objectLock1 = new Object();
	private Object objectLock2 = new Object();

	public void stageOne() {
		synchronized (objectLock1) {

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(random.nextInt(100));
		}
	}

	public synchronized void stageTwo() {
		synchronized (objectLock2) {

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public void main() {
		System.out.println("Стартовали...");
		long start = System.currentTimeMillis();

		Thread t1 = createThread();
		Thread t2 = createThread();
		Thread t3 = createThread();
		Thread t4 = createThread();
		Thread t5 = createThread();
		Thread t6 = createThread();
		Thread t7 = createThread();
		Thread t8 = createThread();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();

		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
			t7.join();
			t8.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("Закончили.....");
		System.out.println("Time of work: " + (end - start)  + "msecs");
		System.out.println("list1: " + list.size() + " ..list2: " + list2.size());

	}

	private Thread createThread() {
		return new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				process();
			}
		});
	}

}
