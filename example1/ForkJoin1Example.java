package syncexample.ForkJoin1;

import java.util.concurrent.ForkJoinPool;

public class ForkJoin1Example {

	public static void go()
	{
		System.out.println(Runtime.getRuntime().availableProcessors());
		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(400000000);
		forkJoinPool.invoke(simpleRecursiveAction);
		
		
	}
}