package io.github.luiseduardobrito.mc504.projeto2;

import java.util.Random;
import java.util.concurrent.locks.Lock;

class Philosopher implements Runnable {

	private Random numGenerator = new Random();
	private int id;

	private Lock leftChopstick;
	private Lock rightChopstick;

	public Philosopher(int id, Lock leftChopstick, Lock rightChopstick) {
		this.id = id;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
	}

	public void run() {
		try {
			while (true) {
				think();
				pickUpLeftChopstick();
				pickUpRightChopstick();
				eat();
				putDownChopsticks();
			}
		} catch (InterruptedException e) {
			Window.addText("Philosopher " + id + " was interrupted.\n");
		}
	}

	private void think() throws InterruptedException {
		Window.addText("Philosopher " + id + " is thinking.\n");
		Thread.sleep(numGenerator.nextInt(10) * 1000);
	}

	private void pickUpLeftChopstick() {
		leftChopstick.lock();
		Window.addText("Philosopher " + id + " is holding 1 chopstick.\n");
	}

	private void pickUpRightChopstick() {
		rightChopstick.lock();
	}

	private void eat() throws InterruptedException {
		Window.addText("Philosopher " + id + " is eating.\n");
		Thread.sleep(numGenerator.nextInt(10));
	}

	private void putDownChopsticks() {
		leftChopstick.unlock();
		rightChopstick.unlock();
	}
}