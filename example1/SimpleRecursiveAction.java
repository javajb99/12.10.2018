package syncexample.ForkJoin1;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

	private int simulatedWork;
	
	public SimpleRecursiveAction(int simulatedWork) {
		this.simulatedWork = simulatedWork;
	}
	
	@Override
	protected void compute() {
		
		if( simulatedWork > 100 ) {
			
			System.out.println("Parallel execution and split the tasks..." + simulatedWork + " " + Thread.currentThread().getId());
			
			SimpleRecursiveAction simpleRecursiveAction1 = new SimpleRecursiveAction(simulatedWork/2);
			SimpleRecursiveAction simpleRecursiveAction2 = new SimpleRecursiveAction(simulatedWork/2);
			
			simpleRecursiveAction1.fork();
			simpleRecursiveAction2.fork();
			
			simpleRecursiveAction1.join();
			simpleRecursiveAction2.join();
			
		} else {
			
			System.out.println("No need for parallel execution, sequential is OK for this task..." + simulatedWork + " " + Thread.currentThread().getId());
		}
	}
}