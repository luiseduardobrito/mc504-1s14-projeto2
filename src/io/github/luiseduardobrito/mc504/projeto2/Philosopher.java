package io.github.luiseduardobrito.mc504.projeto2;

import java.util.Random;

public class Philosopher implements Runnable {

	private final int id;
	private final Chopstick leftChopStick;
	private final Chopstick rightChopStick;
	volatile boolean isTummyFull = false;
	private Random randomGenerator = new Random();
	private int noOfTurnsToEat = 0;

	public Philosopher(int id, Chopstick leftChopStick, Chopstick rightChopStick) {
		this.id = id;
		this.leftChopStick = leftChopStick;
		this.rightChopStick = rightChopStick;
	}

	@Override
	public void run() {

		try {
			while (!isTummyFull) {
				
				think();
				
				if (leftChopStick.pickUp(this, "left")) {
					if (rightChopStick.pickUp(this, "right")) {
						eat();
						rightChopStick.putDown(this, "right");
					}
					leftChopStick.putDown(this, "left");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private void think() throws InterruptedException {
		System.out.println(this + " is thinking");
		Thread.sleep(randomGenerator.nextInt(1000));
	}

	private void eat() throws InterruptedException {
		System.out.println(this + " is eating");
		noOfTurnsToEat++;
		Thread.sleep(randomGenerator.nextInt(1000));
	}

	public int getNoOfTurnsToEat() {
		return noOfTurnsToEat;
	}

	@Override
	public String toString() {
		return "Philosopher-" + id;
	}
}