package SCHDULE;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import SCHDULE.MENU;
import SCHDULE.PCB;
public class Read implements Runnable {
	private final String fileName;
	MENU myObject = new MENU(); 
	public Read( String fileName) {
	this.fileName = fileName; }
	@Override
	public void run() {
	try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	String line;
	int id = 1;
	while ((line = reader.readLine()) != null) { 
		String[] parts = line.split(":|;");
	int burstTime = Integer.parseInt(parts[1]);
	int requiredMemory = Integer.parseInt(parts[2]);
	PCB job = new PCB(id, burstTime, burstTime, requiredMemory);
	MENU.jobQueue.add(job);
	MENU.jobQueueRM.add(job);
	id++; }
	} catch (IOException e) {
	} }
}

