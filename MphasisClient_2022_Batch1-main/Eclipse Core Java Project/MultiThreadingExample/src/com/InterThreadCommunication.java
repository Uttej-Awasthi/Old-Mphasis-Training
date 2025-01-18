package com;
class Abc implements Runnable{
	@Override
	public synchronized void run() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		for(int i=0;i<10;i++) {
			System.out.println(name+" "+i);
							try {
								Thread.sleep(1000);
								if(i==5 && name.equals("Raj")) {
									wait();						// i == 5 and name is Raj  we are calling wait() method belong object. 
								}
								if(i==6 && name.equals("Ajay")) {
									notify();			// resume suspended thread if any thread waiting 
									wait();
									;	
								}
							}catch(Exception e) {}
		}
	};
}
public class InterThreadCommunication {
	public static void main(String[] args) {
	Abc obj = new Abc();
	Thread t1 = new Thread(obj);
	Thread t2 = new Thread(obj);
	Thread t3 = new Thread(obj);
     t1.setName("Raj");
     t2.setName("Ajay");
     t3.setName("Mahesh");
     t1.start(); t2.start(); t3.start();
	}

}
