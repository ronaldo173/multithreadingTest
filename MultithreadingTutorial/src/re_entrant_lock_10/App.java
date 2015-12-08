package re_entrant_lock_10;

public class App {
	public static void main(String[] args) {
		Runner runner = new Runner();

		System.out.println("hello..");

		Thread threadFirst = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					runner.firstTHread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread threadSecond = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					runner.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		threadFirst.start();
		threadSecond.start();

		try {
			threadFirst.join();
			threadSecond.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		runner.finished();
	}

}
