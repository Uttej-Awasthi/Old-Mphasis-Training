package com;
class Booking implements Runnable{
	int avl=1;
	@Override
	public synchronized void run() {
		Thread t = Thread.currentThread();
		String name = t.getName();
				if(avl==1) {
					System.out.println(name+" got the ticket");
					avl = avl-1;
				}else {
					System.out.println(name+" sorry no ticket");
				}
	}
}
public class BookingApp {
	public static void main(String[] args) {
	Booking b1 = new Booking();			// new memory and avl =1
	//Booking b2 = new Booking();			// new memory and avl = 1
	//Booking b3 = new Booking();			// new memory and avl = 1
	Thread t1 = new Thread(b1);
	Thread t2 = new Thread(b1);
	Thread t3 = new Thread(b1);
	t1.setName("Ravi");
	t2.setName("Balaji");
	t3.setName("Mahesh");
	t1.start();
	t2.start();
	t3.start();
	}

}
