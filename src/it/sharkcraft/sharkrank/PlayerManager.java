package it.sharkcraft.sharkrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.bukkit.entity.Player;

public class PlayerManager implements DataStream {

	String name;
	int kills, deaths;
	double money;
	
	static final String PLAYERS_DIR = "/players/";
	static final String PLAYERS_EXT = ".pl";
	static final String DATA_NAME = "name";
	static final String DATA_KILLS = "kills";
	static final String DATA_DEATHS = "death";
	static final String DATA_MONEY = "money";
	static final String SEP = ":";
	
	public PlayerManager(Player in) {
		
		this.name = in.getName();
		kills = 0;
		deaths = 0;
		money = 0;
	}
	
	public PlayerManager(String name) {
		
		this.name = name;
		kills = 0;
		deaths = 0;
		money = 0;
	}
	
	/**
	 * Incrementa la kill count del giocatore
	 */

	public void incKills() {
		
		kills++;
	}
	
	public void incDeaths() {
		
		deaths++;
	}
	
	public void setKills(int kills) {
		
		this.kills = kills;
	}
	
	public void setDeaths(int deaths) {
		
		this.deaths = deaths;
	}
	
	/**
	 * Restituisce la kill count del giocatore
	 * @return
	 */
	
	public int getKills() {	
		
		return kills;
	}
	
	public int getDeaths() {
		
		return deaths;
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
	
	private String genURI() {
		
		return PLAYERS_DIR + name + PLAYERS_EXT;
    }
	

	public void loadData() {
		
		InputStream fis = getClass().getResourceAsStream(genURI());
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		
		String line;
		
		try {
		
			while ((line = br.readLine()) != null) {

			    if (line.startsWith(DATA_KILLS)) {
					
					kills = Integer.parseInt(line.split(SEP)[1]);
					
				} else if (line.startsWith(DATA_DEATHS)) {
					
					deaths = Integer.parseInt(line.split(SEP)[1]);
					
				} else if (line.startsWith(DATA_MONEY)) {
					
					money = Double.parseDouble(line.split(SEP)[1]);
				}
			}
		
			br.close();
			
		} catch (IOException e) {
			
			System.err.print("In PlayerManager.loadData() :");
			e.printStackTrace();
		}
	}
	
	public void writeData() {
		
		File file = new File("." + genURI());
		
		if (file.exists()) {
			
			file.delete();
		}
		
		FileWriter writer;
		
		try {
			
			file.createNewFile();
			writer = new FileWriter(file, false);
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
			return;
		}
		
		BufferedWriter bw = new BufferedWriter(writer);
		
		try {
			
			bw.write(DATA_KILLS + SEP + String.valueOf(kills));
			bw.newLine();
			
			bw.write(DATA_DEATHS + SEP + String.valueOf(deaths));
			bw.newLine();
			
			bw.write(DATA_MONEY + SEP + String.valueOf(money));
			bw.newLine();
			
			bw.close();
			
		} catch (IOException e) {
			
			System.err.print("In PlayerManager.writeData() :");
			e.printStackTrace();
			return;
		}
	}
	
	public static void adjustResources() {
		
		File dir = new File("." + PLAYERS_DIR);
		
		if (!dir.exists()) {
			
			dir.mkdir();
		}
	}
	
}