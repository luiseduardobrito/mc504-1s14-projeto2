package io.github.luiseduardobrito.mc504.projeto2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

	private static final int NO_OF_PHILOSOPHER = 10;
	private static final int SIMULATION_MILLIS = 1000 * 10;

	public static class SleepConst {
		public static final int MIN = 500;
		public static final int MAX = 3000;
	}

	public static void main(String[] args) {

		ExecutorService executorService = null;

		Philosopher[] philosophers = null;
		try {

			philosophers = new Philosopher[NO_OF_PHILOSOPHER];

			Chopstick[] chopSticks = new Chopstick[NO_OF_PHILOSOPHER];

			for (int i = 0; i < NO_OF_PHILOSOPHER; i++) {
				chopSticks[i] = new Chopstick(i);
			}

			executorService = Executors.newFixedThreadPool(NO_OF_PHILOSOPHER);

			for (int i = 0; i < NO_OF_PHILOSOPHER; i++) {
				philosophers[i] = new Philosopher(i, chopSticks[i],
						chopSticks[(i + 1) % NO_OF_PHILOSOPHER]);
				executorService.execute(philosophers[i]);
			}

			Thread.sleep(SIMULATION_MILLIS);

			for (Philosopher philosopher : philosophers) {
				philosopher.isTummyFull = true;
			}

		} catch (InterruptedException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {

			executorService.shutdown();

			while (!executorService.isTerminated()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			for (Philosopher philosopher : philosophers) {
				System.out.println(philosopher + " => No of Turns to Eat ="
						+ philosopher.getNoOfTurnsToEat());
			}
		}
	}
}
