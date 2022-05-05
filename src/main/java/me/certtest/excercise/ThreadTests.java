/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.certtest.excercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/**
 *
 * @author Riccardo
 */

class Flip {
    private AtomicBoolean toFlip = new AtomicBoolean(false);
    
    public boolean get(){
	return toFlip.get();
    }
    
    public synchronized void toggle(){
	boolean oldValue = toFlip.get();
	boolean newValue = !oldValue;
	toFlip.set(newValue);
	System.out.println("Flipped oldValue "+oldValue+" to new value "+newValue);
    }
    
}

public class ThreadTests {
    
    static AtomicLong al = new AtomicLong(5L);
    
    static AtomicBoolean ab = new AtomicBoolean(true);
    
    public static void testSubmit() throws InterruptedException, ExecutionException{
	var s = Executors.newCachedThreadPool();
	Future f = s.submit(() -> System.out.println("aaaa"));
	s.shutdown();
	f.get();
    }
    
    static void testAtomicBoolean() throws InterruptedException{
	ab.compareAndSet(true, false);
	
	Flip flip = new Flip();
	
	System.out.println("Flip is "+ flip.get());
	var e = Executors.newCachedThreadPool();
	IntStream.rangeClosed(1, 15).forEach( i -> {
	    e.execute( ()-> flip.toggle() );
	});
	
	e.shutdown();
	e.awaitTermination(10, TimeUnit.SECONDS);
	
	System.out.println("Flip is "+ flip.get());

    }
    
    
    static void await(CyclicBarrier b){
	try{
	    System.out.println("Waiting n°: "+b.getNumberWaiting());
	    b.await();
	} catch(InterruptedException | BrokenBarrierException e){
	    System.err.println("ERROR "+e.getMessage());
	}
    }

    static void run(CyclicBarrier b){
	ExecutorService e = Executors.newFixedThreadPool(4);
	for (int i = 0; i < 12; i++) {
	    System.out.println("cycling #"+i);
	    e.execute( () -> await(b));
	}
	System.out.println("Shutting down");
	//e.shutdown();
    }
    
    static void executorServiceTest(){
	ExecutorService es = Executors.newSingleThreadExecutor();
	Future<Object> f = es.submit(() -> {
	    double a = 3.12345;
	    return a;
	});
	
	ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
	
    }
    
    static void testDataStructures(){
	var l = new ArrayList<Integer>( Arrays.asList(1,2,3) );
	
//	for (Integer integer : l) {
//	    l.add(1);
//	}
	
	var l2 = new CopyOnWriteArrayList<Integer>( Arrays.asList(1,2,3) );
	
	for (Integer integer : l2) {
	    l2.add(1);
	}
	
	System.out.println("CopyOnWriteArrayList is "+l2);
	
	var l3 = new LinkedBlockingQueue<Integer>( Arrays.asList(1,2,3) );
	
//	for (Integer integer : l3) {
//	    l3.offer(1);
//	}
	
	var l4 = Collections.synchronizedList(l);
//	for (Integer integer : l4) {
//	    l4.add(1);
//	}
	
	var l5 = new ConcurrentSkipListSet<Integer>(l);
	int count = 4;
//	for (Integer integer : l5) {
//	    l5.add(count++);
//	}
	System.out.println(l5);
	
    }

    public static void main(String[] args) throws InterruptedException {
	//run(new CyclicBarrier(4, () -> System.out.println("Ready!")));
	
//	testDataStructures();
	
	testAtomicBoolean();
	
    }
    
}
