package it.sharkcraft.sharkrank;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

	@SuppressWarnings("unused")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player e = event.getPlayer();
		/**
		 * Codice per inserire i data nel file
		 */
		
	}
	
	@SuppressWarnings("unused")
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player e = event.getPlayer();
		/**
		 * Codice per inserire i data nel file
		 */
		
	}

}
