package interapting_thread;

import java.util.Random;

public class App {
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Starting...");

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Random rndom = new Random();

				for (int i = 0; i < 1E8; i++) {
					// if(Thread.currentThread().isInterrupted()){
					// System.out.println("Interupted!");
					// break;
					// }
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("interupted from catch");
						break;
					}
					Math.sin(rndom.nextDouble());
				}

			}
		});
		t1.start();
		t1.sleep(500);
		t1.interrupt();
		t1.join();
		System.out.println("finished from main!");
	}

}
