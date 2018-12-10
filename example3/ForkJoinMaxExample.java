package fork1;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinMaxExample {

	public static int THREASHOLD = 5;
	
	public static void go()
	{
		
		long[] nums = initializeNums();
		THREASHOLD =  nums.length / Runtime.getRuntime().availableProcessors();
		
		SequentialMaxFind normalMaxFind = new SequentialMaxFind();
		
		long start = System.currentTimeMillis();
		System.out.println("Max: " + normalMaxFind.sequentialMaxFinding(nums, nums.length));
		System.out.println("Sequential Time taken: " + (System.currentTimeMillis() - start) + "ms");

		System.out.println();
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		MaximumFindTask findTask = new MaximumFindTask(nums, 0, nums.length);
		
		start = System.currentTimeMillis();
		System.out.println("Max: " + forkJoinPool.invoke(findTask));
		System.out.println("Parallel Time taken: " + (System.currentTimeMillis() - start) + "ms");
	}

	private static long[] initializeNums() {
		
		Random random = new Random();
		
		long[] nums = new long[300_000_000];
		
		for(int i=0;i<300000000;++i)
			nums[i] = random.nextInt(100);
		
		return nums;
	}
}
