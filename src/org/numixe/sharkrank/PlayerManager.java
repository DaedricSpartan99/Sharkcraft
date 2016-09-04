package org.numixe.sharkrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

	String name;
	int kill_count;
	
	static final String KILLS_FILE = "/kills.yml";
	
	public PlayerManager(String name) {
		
		this.name = name;
		kill_count = 0;
	}
	
	/**
	 * Incrementa la kill_count del giocatore
	 */

	public void incKillCount() {
		
		kill_count++;
	}
	
	public void setKillCount(int kill_count) {
		
		this.kill_count = kill_count;
	}
	
	/**
	 * Restituisce la kill_count del giocatore
	 * @return
	 */
	
	public int getKillCount() {	
		
		return kill_count;
	}
	
	/**
	 * Restituisce il nome del giocatore
	 * @return
	 */
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	/**
	 * Carica dal file kills.yml la kill_count relativa al giocatore
	 * @return
	 * @throws IOException
	 */
	
	public boolean loadKills() {
		
		String line;
		
		InputStream fis = getClass().getResourceAsStream(KILLS_FILE);
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		
		try {
		
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
			
		} catch (IOException e) {
			
			System.err.print("In PlayerManager.loadkills() :");
			e.printStackTrace();
		}
		
		kill_count = 0;
		return false;
	}
	
	/**
	 * Sovrascrive la kill_count relativa al giocatore nel file kills.yml
	 * @throws IOException
	 * @throws URISyntaxException 
	 */
	
	public void writeKills() {
		
		String newline = name + ": " + String.valueOf(kill_count);
		
		// check for existing name
		
		List<String> lines = new ArrayList<String>();
		
		String line;
		
		File kll;
		
		try {
			
			kll = new File(getClass().getResource(KILLS_FILE).toURI());
			
		} catch (URISyntaxException e) {
			
			System.err.print("In PlayerManager.writeKills() :");
			e.printStackTrace();
			return;
			
		} catch (NullPointerException e) {
			
			File f = new File("./plugin.yml");

			try {
				
				f.createNewFile();	// generate new kills.yml
				kll = new File(getClass().getResource(KILLS_FILE).toURI());
				
			} catch (IOException e1) {
				
				System.err.print("In PlayerManager.writeKills() :");
				e1.printStackTrace();
				return;
				
			} catch (URISyntaxException e1) {
				
				System.err.print("In PlayerManager.writeKills() :");
				e1.printStackTrace();
				return;
			}
		}
		
		InputStream fis;
		
		try {
			
			fis = new FileInputStream(kll);
			
		} catch (FileNotFoundException e) {
			
			System.err.print("In PlayerManager.writeKills() :");
			e.printStackTrace();
			return;
		}
		
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		
		try {
		
			while ((line = br.readLine()) != null) {

				if (!line.startsWith(name)) {
				
					lines.add(line);
				}
			}
		
			// no name found
		
			br.close();
			
		} catch (IOException e) {
			
			System.err.print("In PlayerManager.writeKills() :");
			e.printStackTrace();
			return;
		}
			
		lines.add(newline);
		
		try {
		
			kll.delete();
			kll.createNewFile();			// create new one
		
			FileWriter writer = new FileWriter(kll, false);
			BufferedWriter bw = new BufferedWriter(writer);
        
			for (String l : lines) {
			
				bw.write(l);
				bw.newLine();
			}
			
			bw.close();
		
		} catch (IOException e) {
			
			System.err.print("In PlayerManager.writeKills() :");
			e.printStackTrace();
		}
	}
	
}