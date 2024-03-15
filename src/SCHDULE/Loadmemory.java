package SCHDULE;

import SCHDULE.MENU;
import SCHDULE.PCB;
import SCHDULE.Schedule;

public class Loadmemory implements Runnable {
	MENU object = new MENU();
	Schedule scheduler = new Schedule(object);
	public void run() {
	while (!MENU.jobQueue.isEmpty()) {
	PCB job = MENU.jobQueue.peek();
	if (job.getRequiredMemory() <= object.availableMemory) {
	MENU.readyQueue.add(job);
	MENU.jobQueue.remove();
	object.availableMemory -= job.getRequiredMemory(); // Decrease the available memory by the amount the process utilize
	} 
	else {
	scheduler = new Schedule(object);
	scheduler.schedule(); }
	}
	scheduler.schedule(); }
}
