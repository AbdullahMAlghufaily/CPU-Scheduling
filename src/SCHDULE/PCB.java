package SCHDULE;

public class PCB {
	private int id;
	private String state;
	private int burstTime;
	private final int requiredMemory;
	private int turnaroundTime;
	private int waitingTime;
	private int ST;
	private int EN;
	private int REM;
	
	public PCB(int id, int burstTime, int REM, int requiredMemory) {
		this.id = id;
		this.burstTime = burstTime;
		this.REM = REM;
		this.requiredMemory = requiredMemory;
		this.state = "New";
		this.turnaroundTime = 0;
		this.waitingTime = 0;
		this.ST = -1;
		this.EN = 0;
		}
		public int getId() {
		return id;
}
		public void setId(int id) {
			this.id = id; }
			public String getState() {
			return state; }
			public void setState(String state) {
			this.state = state; }
			public int getBurstTime() {
			return burstTime; }
			public void setBurstTime(int burstTime) {
			this.burstTime = burstTime; }
			public int getREM() {
			return REM; }
			public void setREM(int REM) {
			this.REM = REM; }
			public int getRequiredMemory() {
			return requiredMemory; }
			public int getTurnaroundTime() {
			return turnaroundTime; }
			public void setTurnaroundTime(int turnaroundTime) {
			this.turnaroundTime = turnaroundTime; }
			public int getWaitingTime() {
			return waitingTime; }
			public void setWaitingTime(int waitingTime) {
			this.waitingTime = waitingTime; }
			public int getST() {
			return ST; }
			public void setST(int ST) {
			this.ST = ST; }
			public int getEN() {
			return EN; }
			public void setEN(int EN) {
			this.EN = EN; }
		
}
