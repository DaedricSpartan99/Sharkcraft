package org.numixe.sharkrank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

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
	
	public boolean loadKill() throws IOException {
		
		String line;
		
		InputStream fis = new FileInputStream("kills.yml");
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		
		while ((line = br.readLine()) != null) {

			if (line.startsWith(name)) {
				
				// name found
				
				kill_count = Integer.parseInt(line.split(":")[1]);
				br.close();
				return true;
			}
		}
		
		// no name found
		
		br.close();
		kill_count = 0;
		return false;
	}
	
	public void writeKill() throws IOException {
		
		boolean name_found = false;
		int nline = 0;
		
		String newline = name + ": " + String.valueOf(kill_count);
		
		// check for existing name
		
		String line;
		
		InputStream fis = new FileInputStream("kills.yml");
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		
		while ((line = br.readLine()) != null) {

			if (line.startsWith(name)) {
				
				// name found
				
				br.close();
				name_found = true;
				break;
			}
			
			nline++;
		}
		
		// no name found
		
		br.close();
		
		
		
		if (name_found) {
			
			FileWriter writer = new FileWriter("file.txt", false);
	        writer.write("");
		}
	}
}