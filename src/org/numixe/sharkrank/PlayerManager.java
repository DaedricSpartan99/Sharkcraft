package org.numixe.sharkrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

	String name;
	int kill_count;
	
	public PlayerManager(String name) {
		
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
	
	public boolean loadKills() throws IOException {
		
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
		
		String newline = name + ": " + String.valueOf(kill_count);
		
		// check for existing name
		
		List<String> lines = new ArrayList<String>();
		
		String line;
		
		File kll = new File("kills.yml");
		
		if (!kll.exists()) {
			
			kll.createNewFile();
		}
		
		InputStream fis = new FileInputStream("kills.yml");
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		
		while ((line = br.readLine()) != null) {

			if (!line.startsWith(name)) {
				
				lines.add(line);
			}
		}
		
		// no name found
		
		br.close();
			
		lines.add(newline);
		
		kll.delete();
		kll.createNewFile();			// create new one
		
		FileWriter writer = new FileWriter("kills.yml", false);
		BufferedWriter bw = new BufferedWriter(writer);
        
		for (String l : lines) {
			
			bw.write(l);
			bw.newLine();
		}
		
		bw.close();
	}
}
