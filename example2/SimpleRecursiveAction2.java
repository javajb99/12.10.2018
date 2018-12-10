package syncexample.ForkJoin1;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveAction2 extends RecursiveTask<Integer> {

	private int simulatedWork;
	
	public SimpleRecursiveAction2(int simulatedWork) {
		this.simulatedWork = simulatedWork;
	}
	
	@Override
	protected Integer compute() {
		
		if( simulatedWork > 100 ) {
			
			System.out.println("Parallel execution and split the tasks..." + simulatedWork);
			
			SimpleRecursiveAction2 simpleRecursiveAction1 = new SimpleRecursiveAction2(simulatedWork/2);
			SimpleRecursiveAction2 simpleRecursiveAction2 = new SimpleRecursiveAction2(simulatedWork/2);
			
			simpleRecursiveAction1.fork();
			simpleRecursiveAction2.fork();
			
			int solution = 0;
			solution = solution + simpleRecursiveAction1.join();
			solution = solution + simpleRecursiveAction2.join();
			
			return solution;
			
		} else {
			System.out.println("No need for parallel execution, sequential is OK for this task..." );
			return  simulatedWork;
		}
	}
}


