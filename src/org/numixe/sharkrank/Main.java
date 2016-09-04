package org.numixe.sharkrank;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
  implements Listener
{
  
  public void onEnable()
  {
	    Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "SharkRank attivato");
    getServer().getPluginManager().registerEvents(this, this);
  }
  
  public void onDisable()
  {
    Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "SharkRank disattivato");
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
  {
    Player p = (Player) sender;
    PlayerManager u = new PlayerManager(p.getName());
    if (CommandLabel.equalsIgnoreCase("shkill")) {
    	p.sendMessage(u.getName() + "Funziona: " + u.kill_count);
      }
    return false;
  }
}
