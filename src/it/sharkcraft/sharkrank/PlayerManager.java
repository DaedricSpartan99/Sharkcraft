package it.sharkcraft.sharkrank;

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
		death = 0;
		money = 0;
	}
	
	public PlayerManager(String name) {
		
		this.name = name;
		kills = 0;
		death = 0;
		money = 0;
	}
	
	/**
	 * Incrementa la kill count del giocatore
	 */

	public void incKills() {
		
		kills++;
	}
	
	public void incDeaths() {
		
		death++;
	}
	
	public void setKills(int kills) {
		
		this.kills = kills;
	}
	
	public int setDeaths(int deaths) {
		
		this.deaths = deaths;
	}
	
	/**
	 * Restituisce la kill_count del giocatore
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
	
	/**
	 * Carica dal file kills.yml la kill_count relativa al giocatore
	 * @return
	 * @throws IOException
	 */
	
	@Override
	public void loadData() {
		
		InputStream fis = getClass().getResourceAsStream(genURI());
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		
		String line;
		
		try {
		
			while ((line = br.readLine()) != null) {

			    if (line.startsWith(DATA_KILLS) {
					
					kills = Integer.parseInt(line.split(SEP)[1]);
					
				} else if (line.startsWith(DATA_DEATHS) {
					
					deaths = Integer.parseInt(line.split(SEP)[1]);
					
				} else if (line.startsWith(DATA_MONEY) {
					
					money = Double.parseDouble(line.split(SEP)[1]);
				}
			}
		
			br.close();
			
		} catch (IOException e) {
			
			System.err.print("In PlayerManager.loadData() :");
			e.printStackTrace();
		}
	}
	
	@Override
	public void writeData() {
		
		File file = new File("." + genURI());
		
		if (file.exists()) {
			
			file.delete();
		}
		
		file.createNewFile();
		
		FileWriter writer = new FileWriter(file, false);
		BufferedWriter bw = new BufferedWriter(writer);
		
		try {
			
			bw.write(DATA_KILLS + SEP + String.valueOf(kills));
			bw.writeNewLine();
			
			bw.write(DATA_DEATHS + SEP + String.valueOf(deaths));
			bw.writeNewLine();
			
			bw.write(DATA_MONEY + SEP + String.valueOf(money));
			bw.writeNewLine();
			
			bw.close();
			
		} catch (IOException e) {
			
			System.err.print("In PlayerManager.writeData() :");
			e1.printStackTrace();
			return;
		}
	}
	
}