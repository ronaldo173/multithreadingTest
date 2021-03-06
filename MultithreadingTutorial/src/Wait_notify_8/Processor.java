package Wait_notify_8;

import java.util.Scanner;

public class Processor {

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running....");
			wait();
			System.out.println("..resumed!");
		}

	}

	public void consume() throws InterruptedException {

		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);

		synchronized (this) {
			System.out.println("Waiting for return key..");
			String c = scanner.nextLine();
			System.out.println("..key pressed: " + c);
			notify();
		}
	}
}
