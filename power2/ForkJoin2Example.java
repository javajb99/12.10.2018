package fork1;

import java.util.concurrent.ForkJoinPool;

public class ForkJoin2Example {

	public static void go()
	{
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		SimpleRecursiveAction2 simpleRecursiveAction = new SimpleRecursiveAction2(8);
		System.out.println( forkJoinPool.invoke(simpleRecursiveAction) );
		
		
	}
}