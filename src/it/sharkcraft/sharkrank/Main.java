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
	  PlayerManager.adjustResources();	// creates players directory if doesn't exist
	  
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
  
  public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)	{
	  
	Player p = (Player) sender;
	
    if (cmd.getName().equalsIgnoreCase("shkill")) {
    	
    	Commands.shkill(p, args);	// process shkill
    	
    } else if (cmd.getName().equalsIgnoreCase("shdeath")) {
    	
    	Commands.shdeath(p, args);	// process shdeath
    	
    } else if (cmd.getName().equalsIgnoreCase("money")) {
    	
    	Commands.money(p, args);
    }
    
    return false;
  }
}
