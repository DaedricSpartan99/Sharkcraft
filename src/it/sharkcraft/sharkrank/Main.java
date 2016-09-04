package it.sharkcraft.sharkrank;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
  
  public void onEnable()
  {
	Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
	Bukkit.getServer().getConsoleSender()
	.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + ChatColor.BOLD + "!" 
	+ ChatColor.GRAY + "] " + ChatColor.GRAY + "SharkRank Enabled");
	
}

public void onDisable()
  {
	Bukkit.getServer().getConsoleSender()
	.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + ChatColor.BOLD + "!" 
	+ ChatColor.GRAY + "] " + "SharkRank Disabled");
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
  {
    Player p = (Player) sender;
	PlayerManager u = new PlayerManager(p.getName());
    if (cmd.getName().equalsIgnoreCase("shkill")) {
    	if (args.length == 1) {
    		// Mostra KillStats Altrui
    	  if (args[0].equals(args[0])) {
    	    	p.sendMessage("§8[§c§l!§8] §9SharkRank> " + "§a" + args[0] + " §7ha §a" + u.kill_count + " §7kills.");
    	  }
    	  // Mostra le tue KillStats
      } else if (args.length == 0) {
      	p.sendMessage("§8[§c§l!§8] §9SharkRank> " + "§a" + u.getName() + " §7ha §a" + u.kill_count + " §7kills.");

      }
    
  } return false;
  }
}
