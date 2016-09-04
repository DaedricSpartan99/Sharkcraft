package org.numixe.sharkrank;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {}
	public void onDisable() {}
	
	public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		PlayerManager u = new PlayerManager(p.getName());
		
		try {
			u.loadKills();		// carica dal file la kill_count relativa al giocatore
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		if(p.getName().equalsIgnoreCase("shkill")) {
			
				p.sendMessage("�c�lTEST >>�r" + "�a" + u.getName() + "ha " + u.getKillCount());
				
				// stampa il nome del giocatore + la killcount
				
		}		
		
		return false;
	}
	
	
}
