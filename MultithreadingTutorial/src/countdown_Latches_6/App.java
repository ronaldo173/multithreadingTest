package countdown_Latches_6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 3; i++) {
			executorService.submit(new Processors(latch));
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Processors implements Runnable {

	private CountDownLatch latch;

	public Processors(CountDownLatch latch) {
		// TODO Auto-generated constructor stub
		this.latch = latch;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Started..");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		latch.countDown();
		System.out.println("..finished");

	}

}