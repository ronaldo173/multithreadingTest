package Callable_13;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();

		Future<Integer> getedTime = executorService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub 
				Random random = new Random();
				int timeRand = random.nextInt(2500);
				
				System.out.println("..starting");
				Thread.sleep(timeRand);
				System.out.println("time waited: " + timeRand + "\n..finished!");
				
				return timeRand;
			}
		});
		executorService.shutdown();
		executorService.awaitTermination(100, TimeUnit.SECONDS);
		System.out.println("Future geted:" + getedTime.get());
	}

}
