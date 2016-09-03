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
		
		if(p.getName().equalsIgnoreCase("shkill")) {
			      try {
					p.sendMessage("§c§lTEST >>§r" + "§a" + u + "ha " + u.loadKills());
				} catch (IOException e) {
					e.printStackTrace();
				}
			  }		
		return false;
	}
	
	
}
