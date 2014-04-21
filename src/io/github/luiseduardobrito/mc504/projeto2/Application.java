package io.github.luiseduardobrito.mc504.projeto2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Application {

	private static final int NUM_PHILOSOPHERS = 5;

	public static void main(String[] args) {

		Window.createAndShow();
		
		Lock[] chopsticks = new ReentrantLock[NUM_PHILOSOPHERS];

		for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
			chopsticks[i] = new ReentrantLock();
		}

		Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];

		for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
			philosophers[i] = new Philosopher(i, chopsticks[i],
					chopsticks[(i + 1) % NUM_PHILOSOPHERS]);
			new Thread(philosophers[i]).start();
		}
	}
}
