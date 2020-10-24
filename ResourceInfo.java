/*
 * Resource Information Class
 * 
 * .
 */
package systeminfo;

/**
 *
 * @author Qazi Zia Ullah
 */

public class ResourceInfo {

	/*
	 * Memory Variables
	 */
	long ram;
	long freeMemory;
	long usedMemory;
	long totalMemory;
	long actualFreeMemory;
	long actualUsedMemory;
	double freeMemoryPercent;
	double usedMemoryPercent;

	/*
	 * CPU Variables
	 */

	long cpuIrq;
	long cpuUserTime;
	long cpuIdleTime;
	long cpuTotalTime;

	double cpupercentage; // changes1
	double IdlePercent;
	double IrqPercent;
	double SoftIrqPercent;
	double StolenPercent;
	double CpuPerUsage;

	// Disk Usage long diskRB,long diskWB
	/*
	 * long diskRB; long diskWB;
	 */
	// long RxBytes;
	// long TxBytes;
	public ResourceInfo() {

	}

	public ResourceInfo(long ram, long freeMemory, long usedMemory,
			long totalMemory, long actualFreeMemory, long actualUsedMemory,
			double freeMemoryPercent, double usedMemoryPercent, long cpuIrq,
			long cpuUserTime, long cpuIdleTime, long cpuTotalTime,
			double cpupercentage, double IdlePercent, double IrqPercent,
			double SoftIrqPercent, double StolenPercent) // long RxBytes, long
															// TxBytes)//, long
															// diskRB,long
															// diskWB)
	{
		super();
		this.ram = ram;
		this.freeMemory = freeMemory;
		this.usedMemory = usedMemory;
		this.totalMemory = totalMemory;
		this.actualFreeMemory = actualFreeMemory;
		this.actualUsedMemory = actualUsedMemory;
		this.freeMemoryPercent = freeMemoryPercent;
		this.usedMemoryPercent = usedMemoryPercent;
		this.cpuIrq = cpuIrq;
		this.cpuUserTime = cpuUserTime;
		this.cpuIdleTime = cpuIdleTime;
		this.cpuTotalTime = cpuTotalTime;
		this.cpupercentage = cpupercentage;
		this.IdlePercent = IdlePercent;
		this.IrqPercent = IrqPercent;
		this.SoftIrqPercent = SoftIrqPercent;
		this.StolenPercent = StolenPercent;
		//this.CpuPerUsage = (StolenPercent + SoftIrqPercent + IrqPercent + cpupercentage)*100;
		// this.CPUPerUsage = CPUPerUsage;
                this.CpuPerUsage = (1-IdlePercent)*100;  //changed for this.CpuPerUsage = StolenPercent + SoftIrqPercent + IrqPercent + cpupercentage;
		// this.diskRB = diskRB;
		// this.diskWB = diskWB;
		// this.RxBytes = RxBytes;
		// this.TxBytes = TxBytes;
	}

	public long getRam() {
		return ram;
	}

	public void setRam(long ram) {
		this.ram = ram;
	}

	public long getFreeMemory() {
		return freeMemory;
	}

	public void setFreeMemory(long freeMemory) {
		this.freeMemory = freeMemory;
	}

	public long getUsedMemory() {
		return usedMemory;
	}

	public void setUsedMemory(long usedMemory) {
		this.usedMemory = usedMemory;
	}

	public long getTotalMemory() {
		return totalMemory;
	}

	public void setTotalMemory(long totalMemory) {
		this.totalMemory = totalMemory;
	}

	public long getActualFreeMemory() {
		return actualFreeMemory;
	}

	public void setActualFreeMemory(long actualFreeMemory) {
		this.actualFreeMemory = actualFreeMemory;
	}

	public long getActualUsedMemory() {
		return actualUsedMemory;
	}

	public void setActualUsedMemory(long actualUsedMemory) {
		this.actualUsedMemory = actualUsedMemory;
	}

	public double getFreeMemoryPercent() {
		return freeMemoryPercent;
	}

	public void setFreeMemoryPercent(double freeMemoryPercent) {
		this.freeMemoryPercent = freeMemoryPercent;
	}

	public double getUsedMemoryPercent() {
		return usedMemoryPercent;
	}

	public void setUsedMemoryPercent(double usedMemoryPercent) {
		this.usedMemoryPercent = usedMemoryPercent;
	}

	public long getCpuIrq() {
		return cpuIrq;
	}

	public void setCpuIrg(long cpuIrq) {
		this.cpuIrq = cpuIrq;
	}

	public long getCpuUserTime() {
		return cpuUserTime;
	}

	public void setCpuUserTime(long cpuUserTime) {
		this.cpuUserTime = cpuUserTime;
	}

	public long getCpuIdleTime() {
		return cpuIdleTime;
	}

	public void setCpuIdleTime(long cpuIdleTime) {
		this.cpuIdleTime = cpuIdleTime;
	}

	public long getCpuTotalTime() {
		return cpuTotalTime;
	}

	public void setCpuTotalTime(long cpuTotalTime) {
		this.cpuTotalTime = cpuTotalTime;
	}

	// / CPU Percentage//////////////////
	public double getCombined() { // changes Sum of User + Sys + Nice + Wait
		return cpupercentage;
	}

	public double getIdle() {
		return IdlePercent;
	}

	public double getIrq() {
		return IrqPercent;
	}

	public double getSoftIrq() {
		return SoftIrqPercent;
	}

	public double getStolen() {
		return StolenPercent;
	}

	public double getCpuUsage() {
		return CpuPerUsage;
	}

	// Disk usage
	/*
	 * public long getReadBytes() { return diskRB; } public long getWriteBytes()
	 * { return diskWB; }
	 * 
	 * public long getRxBytes(){ return RxBytes; } public long getTxBytes(){
	 * return TxBytes; }
	 */
	public void displayResouceInfo() {
		// System.out.print("Ram: " + ram);
		// System.out.print(" : " + freeMemory);
		// System.out.print("Used Memory : " + usedMemory);
		// System.out.print(" : " + totalMemory);
		// System.out.print(" : " + actualFreeMemory);
		// System.out.print(" : " + actualUsedMemory);
		// System.out.print(" : " + freeMemoryPercent);
		// System.out.print(" Memory Percentage: " + usedMemoryPercent);

		// System.out.print("\tCPU: " + cpuIrq);
		// System.out.print(" : " + cpuUserTime);
		// System.out.print(" : " + cpuIdleTime);
		// System.out.println(" : " + cpuTotalTime);
		// System.out.println(" : " + cpupercentage);
		// System.out.println("CPU Idle percentage : " + ((IdlePercent)*100));
		// System.out.println(" : " + IrqPercent);
		// System.out.println(" : " + SoftIrqPercent);
		// System.out.println(" CPU Usage percentage: " + ((StolenPercent
		// +SoftIrqPercent + IrqPercent + cpupercentage )*100));
		// double arr[]=new double[10];
		// int a=0;
		// arr[a]=((StolenPercent +SoftIrqPercent + IrqPercent + cpupercentage
		// )*100);
		System.out.println("CPU %: " + getCpuUsage());
		// System.out.println("CPU index: " + a);
		// a=a+1;
		// System.out.println("Disk Read Bytes: " + diskRB );
		// System.out.println("Disk Write Bytes: " + diskWB );
		// System.out.println("Received Network Bytes:" + RxBytes);
		// System.out.println("Received Network Bytes:" + TxBytes);
	}

	public void displayResouceInfo2() {
		System.out.println("*******  Memory Info ******* ");
		System.out.println("Ram: " + ram);
		System.out.println("Free Memory: " + freeMemory);
		System.out.println("Used Memory: " + usedMemory);
		System.out.println("Total Memory: " + totalMemory);
		System.out.println("Actual Free Memory: " + actualFreeMemory);
		System.out.println("Actual Used Memory: " + actualUsedMemory);
		System.out.println("Free Memory Percent: " + freeMemoryPercent);
		System.out.println("Used Memory Percent: " + usedMemoryPercent);

		System.out.println("\n*******  CPU Info ******* ");
		System.out.println("cpu Irq: " + cpuIrq);
		System.out.println("Cpu User Time: " + cpuUserTime);
		System.out.println("Cpu Ide Time: " + cpuIdleTime);
		System.out.println("Cpu Total Time: " + cpuTotalTime);
		System.out.println("Cpu Total percent usage: " + cpupercentage);
		System.out.println("Idle CPU percent usage: " + IdlePercent);
		System.out.println(" H/W Interrupt percent usage  " + IrqPercent);
		System.out.println(" Soft Interrupt percent usage " + SoftIrqPercent);
		System.out.println(" Stolen CPU percent usage" + StolenPercent);
		System.out.println(" : " + ((StolenPercent + SoftIrqPercent + IrqPercent + cpupercentage) * 100));
		// System.out.println("Disk Read Bytes: " + diskRB );
		// System.out.println("Disk Write Bytes: " + diskWB );
	}
}
