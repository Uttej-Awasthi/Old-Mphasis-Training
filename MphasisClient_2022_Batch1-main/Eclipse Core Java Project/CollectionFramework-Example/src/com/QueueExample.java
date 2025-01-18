package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue pq = new PriorityQueue();
		pq.add(3);
		pq.add(1);
		pq.add(5);
		pq.add(2);
		System.out.println(pq);
		System.out.println(" remove elements "+pq.poll());
		System.out.println(pq);
		System.out.println(" remove elements "+pq.poll());
		System.out.println(pq);
		Queue lq = new LinkedList();
		lq.add(3);
		lq.add(1);
		lq.add(5);
		lq.add(2);
		System.out.println(lq);
		System.out.println("Remove elements "+lq.poll());
		System.out.println(lq);
		System.out.println("Remove elements "+lq.poll());
	}

}
