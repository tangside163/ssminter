import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest2 {
	public static void main(String[] args) {
		
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		threadPool.execute( new Runnable() {
			public void run() {
				while(true){}
			}
		});
		
		threadPool.shutdownNow();
		
		
	}
}
