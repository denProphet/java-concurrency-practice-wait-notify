package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	TaskPoolSolver poolSolver = new TaskPoolSolver();
	TaskFabric taskFabric = new TaskFabric();

	Thread worker = new Thread(new Runnable() {
		@Override
		public void run() {
			while (true){
				Runnable task = poolSolver.startTaskPoolSolving();
				task.run();
			}
		}
	});

	worker.start();
		for (int i = 0; i < 5; i++) {
			poolSolver.addTask(taskFabric.getTask());
		}

    }
}
