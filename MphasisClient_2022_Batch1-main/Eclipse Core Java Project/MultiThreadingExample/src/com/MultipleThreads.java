package com;
class Task implements Runnable{
	@Override
	public void run() {
		Thread t = Thread.currentThread();			// user-defined thread details. 
		String name = t.getName();
		System.out.println(name);
	}
}
public class MultipleThreads {
	public static void main(String[] args) {
	Thread t = Thread.currentThread();			// pre-defined default thread details. 
	System.out.println(t);
	Task tt = new Task();
	Thread t1 = new Thread(tt);
	Thread t2 = new Thread(tt);
	Thread t3 = new Thread(tt);
	t1.setName("Ravi");
	t2.setName("Ajay");
	t3.setName("Seeta");
	t1.start();
	t2.start();
	t3.start();
	}

}
