package Producer_consumer_low_level_synchr;

public class App {

	public static void main(String[] args)  {

		final Processor processor = new Processor();
		Thread producerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread consumeThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		producerThread.start();
		consumeThread.start();
		
		System.out.println("...main:finished!...");
	}
}
