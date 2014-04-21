package io.github.luiseduardobrito.mc504.projeto2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Application {

	private static final int NUM_PHILOSOPHERS = 5;

	public static void main(String[] args) {
		
		// Cria e prepara janela de estado
		Window.createAndShow();
		
		// Inicializa lista de talheres com Locks
		Lock[] chopsticks = new ReentrantLock[NUM_PHILOSOPHERS];
		
		// Instancia talheres
		for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
			chopsticks[i] = new ReentrantLock();
		}
		
		// Inicializa lista de filosofos
		Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
		
		// Instancia filosofos
		for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
			philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % NUM_PHILOSOPHERS]);
			new Thread(philosophers[i]).start();
		}
	}
}
