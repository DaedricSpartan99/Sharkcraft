package it.sharkcraft.sharkrank;

import org.bukkit.entity.Player;

public class Commands {

	public static void shkill(Player sender, String args[]) {
		
		if (args.length > 1) {
			
			sender.sendMessage("Too much arguments");
			return;
		}
		
		PlayerManager u = new PlayerManager(sender);
		u.loadData();	// carica i dati del giocatore
		
		if (args.length == 1) {
    		
    		// Mostra KillStats Altrui
    		PlayerManager other = new PlayerManager(args[0]);
    		other.loadData();
    		
    	    sender.sendMessage("�8[�c�l!�8] �9SharkRank> " + "�a" + other.getName() + " �7ha �a" + other.getKills() + " �7kills.");
    	    
    	  // Mostra le tue KillStats
    	} else if (args.length == 0) {
    		
    		sender.sendMessage("�8[�c�l!�8] �9SharkRank> " + "�a" + u.getName() + " �7ha �a" + u.getKills() + " �7kills.");

    	}
	}
	
	public static void shdeath(Player sender, String args[]) {
		
		if (args.length > 1) {
			
			sender.sendMessage("Too much arguments");
			return;
		}
		
		PlayerManager u = new PlayerManager(sender);
		u.loadData();	// carica i dati del giocatore
		
		if (args.length == 1) {
    		
    		// Mostra KillStats Altrui
    		PlayerManager other = new PlayerManager(args[0]);
    		other.loadData();
    		
    	    sender.sendMessage("�8[�c�l!�8] �9SharkRank> " + "�a" + other.getName() + " �7ha �a" + other.getDeaths() + " �7deaths.");
    	    
    	  // Mostra le tue KillStats
    	} else if (args.length == 0) {
    		
    		sender.sendMessage("�8[�c�l!�8] �9SharkRank> " + "�a" + u.getName() + " �7ha �a" + u.getDeaths() + " �7deaths.");

    	}
	}
	
	public static void money(Player sender, String args[]) {
		
		if (args.length > 1) {
			
			sender.sendMessage("Too much arguments");
			return;
		}
		
		PlayerManager u = new PlayerManager(sender);
		u.loadData();	// carica i dati del giocatore
		
		if (args.length == 1) {
    		
    		// Mostra KillStats Altrui
    		PlayerManager other = new PlayerManager(args[0]);
    		other.loadData();
    		
    	    sender.sendMessage("�8[�c�l!�8] �9SharkRank> " + "�a" + other.getName() + " �7ha �a" + other.getMoney() + " �7euro.");
    	    
    	  // Mostra le tue KillStats
    	} else if (args.length == 0) {
    		
    		sender.sendMessage("�8[�c�l!�8] �9SharkRank> " + "�a" + u.getName() + " �7ha �a" + u.getMoney() + " �7euro.");

    	}
	}
}
