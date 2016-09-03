package core;

public class Player {

	String name;
	int kill_count;
	
	public Player(String name) {
		
		this.name = name;
		kill_count = 0;
	}

	public void incKillCount() {
		
		kill_count++;
	}
	
	public void setKillCount(int kill_count) {
		
		this.kill_count = kill_count;
	}
	
	public int getKillCount() {
		
		return kill_count;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
}
