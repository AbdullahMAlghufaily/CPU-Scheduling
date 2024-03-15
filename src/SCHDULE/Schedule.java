package SCHDULE;
import java.util.ArrayList; 
import java.util.List;

import SCHDULE.MENU;
import SCHDULE.PCB;
public class Schedule {
	private int currentTime;
	private final MENU Object;
	public Schedule(MENU Object) {
		
	this.Object = Object;
	this.currentTime = 0;
	}
	public void schedule() {
		
	switch (Object.schedullingAlgorithm) {
	case "FCFS":
	executeFCFS(MENU.readyQueue);
	break;
	case "RR": 
		executeRR(MENU.readyQueue, 10);
	break;
	case "MLFQ":
	executeMLFQ(MENU.readyQueue);
	break;
	default:
	break; }
	
	}
	private void executeFCFS(List<PCB> readyQueue) {
	while (!MENU.readyQueue.isEmpty()) {
	PCB job = MENU.readyQueue.get(0);
	if (job.getST() == -1) { 
	job.setST(currentTime); 
	for (int i = 0; i < job.getBurstTime(); i++) {
		System.out.print("-"); }
	System.out.print("P" + job.getId() + " ");
}
	for (int i = 0; i < job.getBurstTime(); i++) {
		System.out.print("-"); }
		currentTime += job.getBurstTime();
		job.setEN(currentTime);
		job.setTurnaroundTime(currentTime);
		job.setWaitingTime(job.getTurnaroundTime() - job.getBurstTime());
		System.out.print(" " + currentTime + " |");
		Object.availableMemory += job.getRequiredMemory(); 
		}
		}
	
	private void executeRR(List<PCB> readyQueue, int quantum) { 
			List<PCB> job = new ArrayList<>(readyQueue);
		while (!job.isEmpty()) {
		PCB currentJob = job.get(0);
		if (currentJob.getST() == -1) {
		currentJob.setST(currentTime); 
		}
		if (currentJob.getREM() <= quantum) { 
			System.out.print("P" + currentJob.getId() + " ");
			for (int i = 0; i < currentJob.getREM(); i++) {
		System.out.print("-"); }
		currentTime += currentJob.getREM();
		currentJob.setEN(currentTime);
		currentJob.setTurnaroundTime(currentTime); 
		currentJob.setWaitingTime(currentJob.getTurnaroundTime() - currentJob.getBurstTime());
		System.out.print(" " + currentTime + " |");
		Object.availableMemory += currentJob.getRequiredMemory();
		readyQueue.remove(currentJob);
		job.remove(currentJob); } else {
		System.out.print("P" + currentJob.getId() + " "); 
		for (int i = 0; i < quantum; i++) {
		System.out.print("-"); }
		currentTime += quantum;
		System.out.print(" " + currentTime + " |");
		currentJob.setREM(currentJob.getREM() - quantum);
		job.remove(currentJob); // We remove the job to add it in the end of queue
		job.add(currentJob); // Add the job in the end of queue
		}
		} }
		private void executeMLFQ(List<PCB> readyQueue) { 
			List<PCB> queue1 = new ArrayList<>(); 
			List<PCB> queue2 = new ArrayList<>(); 
			List<PCB> queue3 = new ArrayList<>();
		readyQueue.forEach((job) -> {
		queue1.add(job); });
		while (!queue1.isEmpty() || !queue2.isEmpty() || !queue3.isEmpty()) { 
			while (!queue1.isEmpty()) {
		PCB currentJob = queue1.get(0);
		if (currentJob.getST() == -1) {
			currentJob.setST(currentTime); 
			
			}
			if (currentJob.getREM() <= 8) {
			System.out.print("P" + currentJob.getId() + " "); 
			for (int i = 0; i < currentJob.getREM(); i++) {
			System.out.print("-"); }
			currentTime += currentJob.getREM();
			currentJob.setEN(currentTime);
			currentJob.setTurnaroundTime(currentTime); 
			currentJob.setWaitingTime(currentJob.getTurnaroundTime() - currentJob.getBurstTime());
			System.out.print(" " + currentTime + " |");
			Object.availableMemory += currentJob.getRequiredMemory();
			queue1.remove(currentJob);
			readyQueue.remove(currentJob);
			} else {
			System.out.print("P" + currentJob.getId() + " ");
			for (int i = 0; i < 8; i++) {
			System.out.print("-"); }
			
			currentTime += 8;
			System.out.print(" " + currentTime + " |"); 
			currentJob.setREM(currentJob.getREM() - 8);
			Object.availableMemory += currentJob.getRequiredMemory();
			queue1.remove(currentJob);
			queue2.add(currentJob); }
			}
			while (!queue2.isEmpty()) {
			PCB currentJob = queue2.get(0);
			if (currentJob.getREM() <= 16) {
			System.out.print("P" + currentJob.getId() + " "); 
			for (int i = 0; i < currentJob.getREM(); i++) {
			System.out.print("-"); }
			currentTime += currentJob.getREM();
			currentJob.setEN(currentTime);
			currentJob.setTurnaroundTime(currentTime); 
			currentJob.setWaitingTime(currentJob.getTurnaroundTime() - currentJob.getBurstTime());
			System.out.print(" " + currentTime + " |");
			Object.availableMemory += currentJob.getRequiredMemory();
			queue2.remove(currentJob);
			readyQueue.remove(currentJob);
			} else {
			System.out.print("P" + currentJob.getId() + " "); 
			for (int i = 0; i < 16; i++) {
			System.out.print("-"); }
			currentTime += 16;
			System.out.print(" " + currentTime + " |"); 
			currentJob.setREM(currentJob.getREM() - 16);
			
			Object.availableMemory += currentJob.getRequiredMemory();
			readyQueue.remove(currentJob);
			queue2.remove(currentJob);
			queue3.add(currentJob); }
			}
			while (!queue3.isEmpty()) {
			PCB job = queue3.get(0); 
			if (job.getST() == -1) {
			job.setST(currentTime);
			}
			System.out.print("P" + job.getId() + " ");
			for (int i = 0; i < job.getREM(); i++) {
			System.out.print("-"); }
			currentTime += job.getREM();
			job.setEN(currentTime);
			job.setTurnaroundTime(currentTime); 
			job.setWaitingTime(job.getTurnaroundTime() - job.getBurstTime());
			System.out.print(" " + currentTime + " |");
			Object.availableMemory += job.getRequiredMemory();
			queue3.remove(job); }
			} }
}

