package org.numixe.sharkrank;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {}
	public void onDisable() {}
	
	public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {
		
		
		Player p = (Player) sender;
		if(p.getName().equalsIgnoreCase("lol")) {
			File k = new File("kills.yml");
			if (p.getKillCount() == 0) {
				
			}
		}
			
		return false;
	}
	
	
}
