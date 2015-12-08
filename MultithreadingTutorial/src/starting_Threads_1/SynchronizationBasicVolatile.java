package starting_Threads_1;

import java.util.Scanner;

public class SynchronizationBasicVolatile {
	public static void main(String[] args) throws InterruptedException {
		Processor processor = new Processor();
		processor.start();

		System.out.println("Press any key to stop");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		processor.shutDownThread();
	}

}

class Processor extends Thread {

	private volatile boolean running = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (running) {
			System.out.println("hello!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutDownThread() {
		running = false;
		System.out.println("stooped");
	}

}