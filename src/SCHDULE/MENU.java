package SCHDULE;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import SCHDULE.Loadmemory;
import SCHDULE.PCB;
import SCHDULE.Read;

public class MENU {
	public int availableMemory = 1024;
	
	public String schedullingAlgorithm = "RR";
	public static Queue<PCB> jobQueue = new LinkedList<>();
	public static Queue<PCB> jobQueueRM = new LinkedList<>(); // Another jobqueue that we modify on it the bursttime
	public static List<PCB> readyQueue = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("Welcome ");
		
		Read readingjob = new Read("/Users/abdullahalghufaily/Desktop/OS Project/Untitled.txt");
		Thread readingjobThread = new Thread(readingjob); // Thread to read jobs from file
		readingjobThread.start(); // Start the thread
		
		
		// Wait for readingjobThread to complete
		try {
			readingjobThread.join(); 
		}
		catch(InterruptedException e) {
			
		}
		System.out.println("\nGantt Chart:");
		Loadmemory loadmemory = new Loadmemory();
		Thread loadmemoryThread = new Thread(loadmemory);//Thread to load jobs to readyqueue based on available memory
		loadmemoryThread.start(); // Start the thread
		
		// wait for loadmemoryThread to complete
		try {
			loadmemoryThread.join();
		}
		catch (InterruptedException e) {
		
		}
	    double totalWaitingTime = 0.0;
	    double totalTurnaroundTime = 0.0;
	    for(PCB job : jobQueueRM) {
	   	 totalWaitingTime += job.getWaitingTime();
	   	 totalTurnaroundTime += job.getTurnaroundTime();
	    }
	    double averageWaitingTime = totalWaitingTime / jobQueueRM.size();
	    double averageTurnaroundTime = totalTurnaroundTime / jobQueueRM.size();
	    System.out.println("\n\nAverage Waiting Time : " + averageWaitingTime );
	    System.out.println("Average Turnaround Time : " + averageTurnaroundTime);
	    System.out.println("\nAlgorithm Execution Details : ");
	    jobQueueRM.forEach((job) -> { System.out.println("Job ID: " + job.getId() + " , Start Time : " + job.getST() + " , End Time : " + job.getEN());
	    
	    });
	}

	}

