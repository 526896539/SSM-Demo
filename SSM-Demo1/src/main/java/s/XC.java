package s;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class XC {
	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();  
		for (int i = 0; i < 10; i++) {  
		    final int index = i;  
		    try {  
		        Thread.sleep(index * 10);  
		    } catch (InterruptedException e) {  
		        e.printStackTrace();  
		    }  
		  
		    cachedThreadPool.execute(new Runnable() {  
		  
		        @Override  
		        public void run() {  
		            System.out.println(index);  
		        }  
		    });  
		} 
		cachedThreadPool.shutdownNow();
		
		System.out.println("¹Ø±Õ");
	}
	
 }

