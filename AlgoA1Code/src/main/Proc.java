package main;

public class Proc {
	
	private String procLabel;
	private int vRuntime;
	
	public Proc(String procLabel, int vRuntime) {
		this.procLabel = procLabel;
		this.vRuntime = vRuntime;
	}
	
	public String getProcLabel() {
		return this.procLabel;
	}
	
	public int getvRuntime() {
		return this.vRuntime;
	}
}
