package tutorial;

public class StrartingThreads {
	static int value;

	public static void main(String[] args) {
		// 1 way
		new Runner().start();
		new Runner().start();

		// 2 way
		new Thread(new RunnerImplement()).start();
		new Thread(new RunnerImplement()).start();
	}
}

class Runner extends Thread {// 1 way

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			StrartingThreads.value++;
			System.out.println("From thead.." + i + " value: " + StrartingThreads.value);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class RunnerImplement implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 10; i > 0; i--) {
			StrartingThreads.value++;
			System.out.println("Thread..Implement Runnable..." + i + " value.." + StrartingThreads.value);
			// try {
			// Thread.sleep(150);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}
	}

}