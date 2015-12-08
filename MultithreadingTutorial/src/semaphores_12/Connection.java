package semaphores_12;

import java.util.concurrent.Semaphore;

public class Connection {
	private static Connection instance = new Connection();
	private int countConnections = 0;
	private Semaphore semaphore = new Semaphore(10);

	private Connection() {
	}

	public static Connection getInstance() {
		return instance;
	}

	public void connect() {
		try {
			semaphore.acquire();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			doConnect();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	public void doConnect() throws InterruptedException {

		synchronized (this) {
			countConnections++;
			System.out.println("Current connections: " + countConnections);
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (this) {
			countConnections--;
		}

	}
}
