import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

	public static void main(String[] args) {

		ExecutorService threadPool =  new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(),
	            new ThreadPoolExecutor.CallerRunsPolicy());
		
		for(int i=0; i < 10; i++)
		{
			threadPool.execute(new  Runnable() {
				public void run() {
					System.out.println("aaaa___" + Thread.currentThread().getName());
				}
			});
		}
		
		threadPool.execute(new  Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
				System.out.println("xxxx");
				//while(true){}
			}
		});
		
		System.out.println("almost");
		threadPool.shutdownNow();
		
	}
	
}
