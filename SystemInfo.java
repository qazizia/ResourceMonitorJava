/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systeminfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
//import.org.hyperic.sigar.NetInterfaceStat;
//import org.hyperic.sigar.NetInterfaceStat;
//import org.hyperic.sigar.FileSystem;
//import org.hyperic.sigar.FileSystemUsage;
//import org.hyperic.sigar.Mem;
//import org.hyperic.sigar.NetInterfaceStat;

public class SystemInfo {

	static int interval;
	static Timer timer;

	// private String name;

	public ResourceInfo getResourceInfo() {

		Sigar sigar = null;
		ResourceInfo resourceInfo = null;

		try {

			sigar = new Sigar();
			
			Cpu cpu = sigar.getCpu();

			Mem memory = sigar.getMem();

			CpuPerc perc = sigar.getCpuPerc();
		
			// ///////////////////////// for all resources
			resourceInfo = new ResourceInfo(memory.getRam(),
					memory.getFree(), memory.getUsed(), memory.getTotal(),
					memory.getActualFree(), memory.getActualUsed(),
					memory.getFreePercent(), memory.getUsedPercent(),
					cpu.getIrq(), cpu.getUser(), cpu.getIdle(), cpu.getTotal(),
					perc.getCombined(), perc.getIdle(), perc.getIrq(),
					perc.getSoftIrq(), perc.getStolen());
		
			// /// Only for CPU
			
			//float x = (float) resourceInfo.getCpuIrq();
			//System.out.println(x);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resourceInfo;
	}

	// /////////////////////////ADDDDDitions
	/*
	 * public void getDiskUsage(Sigar sigar) { try {
	 * 
	 * FileSystem[] fss = sigar.getFileSystemList();
	 * 
	 * System.out.println("\n*******  Disk Usage ******* "); for (int i = 0; i <
	 * fss.length && fss[i].getSysTypeName().equals("NTFS") ; i++) {
	 * 
	 * FileSystemUsage diskUsage = sigar.getFileSystemUsage(fss[i].toString());
	 * 
	 * System.out.println("Details of Drive: " + fss[i]);
	 * 
	 * //System.out.println("Disk Reads=" + diskUsage.getDiskReads());
	 * System.out.println("Disk Read Bytes =" + diskUsage.getDiskReadBytes());
	 * //System.out.println("Disk Writes=" + diskUsage.getDiskWrites());
	 * System.out.println("Disk Write Bytes =" + diskUsage.getDiskWriteBytes()
	 * ); } } catch (Exception e) // SigarException e to Exception e {
	 * System.out.println("Failed to get DiskUsage"); } }
	 * 
	 * 
	 * public void getNetStats(Sigar sigar) {
	 * 
	 * try {
	 * 
	 * for (String ifName : sigar.getNetInterfaceList()) {
	 * 
	 * NetInterfaceStat stat = sigar.getNetInterfaceStat(ifName);
	 * 
	 * if (stat.getRxBytes() > 0) {
	 * 
	 * System.out.println("\n*******  Network Info ******* ");
	 * System.out.println("NetworkInterface: " + ifName);
	 * 
	 * System.out.println("RxBytes: " + stat.getRxBytes());
	 * //System.out.println("RxPackets: " + stat.getRxPackets());
	 * System.out.println("TxBytes: " + stat.getTxBytes());
	 * //System.out.println("TxPackets: " + stat.getTxPackets());
	 * System.out.println("RxDropped: " + stat.getRxDropped());
	 * System.out.println("TxDropped: " + stat.getTxDropped());
	 * System.out.println("RxErrors: " + stat.getRxErrors());
	 * System.out.println("TxErrors: " + stat.getTxErrors()); break; } } } catch
	 * (Exception e) // SigarException e to Exception e {
	 * System.out.println("Unable to retrieve network statistics."); }
	 * 
	 * }
	 * 
	 * public FileSystem[] getFileSystemList(Sigar sigar){ FileSystem[] fss =
	 * null; try { fss = sigar.getFileSystemList(); }catch (Exception e) //
	 * SigarException e to Exception e { System.out.println(
	 * "Failed to get FileSystem list"); }
	 * 
	 * return fss; }
	 */
	// /////////////////addd end
	
	public double[] getCpuUsageList(){
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter number of intervals => : ");
		int totalIntervals = sc.nextInt();

		final double usageList[] = new double[totalIntervals];

		try {
			int i = 0;
			
			System.out.println("\nGetting CPU Usage with 5 Seconds Delay for each interval. Please wait.... ");
			
			while (i < totalIntervals) {				
				ResourceInfo resourceInfo = getResourceInfo();
				usageList[i++] = resourceInfo.getCpuUsage();
				Thread.sleep(5000);  // 5 Second Delay
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
		
		return usageList;
	}

	public static void main(String[] args) {
		SystemInfo info = new SystemInfo(); // added here
		info.getCpuUsageList();
	}

}

/*
 * try { for (String ni : sigar.getNetInterfaceList()) { NetInterfaceStat
 * netStat = sigar.getNetInterfaceStat(ni); total+=netStat.getRxBytes(); } }
 * catch (SigarException e) { e.printStackTrace(); }
 */