package com.plugin.undercovermod;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.chat.Chat;

public class First extends JavaPlugin implements Listener {
	public static Chat chat = null;
	
	 private boolean setupChat()
	    {
	        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
	        if (chatProvider != null) {
	            chat = chatProvider.getProvider();
	        }

	        return (chat != null);
	    }

	
	
	
	
	
	public void onEnable(){
		if (!setupChat()){
			Player mod;
		getLogger().severe("PLUGIN REQUIRES VAULT, ERROR");
		Bukkit.getPluginManager().disablePlugin(this);
		}
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		logger.info(pdfFile.getName() + "by PresentingTulip has been enabled" + "Version: " + pdfFile.getVersion());
		registerConfig();
		
		
	}
	public void onDisable(){
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		logger.info(pdfFile.getName() + "by PresentingTulip has been enabled" + "Version: " + pdfFile.getVersion());
		
		
		
		
	}
	
	private void registerConfig(){
		getConfig().options().copyDefaults(true);
		saveConfig();
		
	}
	
	
	
	
	
	
	
	
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args ){
		Player player = (Player) sender;
		
		String umodoff;
		umodoff = ChatColor.translateAlternateColorCodes ('&',getConfig().getString("Umodoff prefix"));
		if (command.getName().equalsIgnoreCase("umodoff")){
			if (player.hasPermission("undercovermod.toggleop")){
		
	
				
				
				chat.getPlayerPrefix(player);
		
		
		 chat.setPlayerPrefix(player, (umodoff));
		 player.sendMessage(ChatColor.GREEN + "Prefix changed.");
		
			}else{
				player.sendMessage(ChatColor.RED + "You don't have permission.");
			}
		}
		String umodon;
		
		if (command.getName().equalsIgnoreCase("umodon")){
			umodon = ChatColor.translateAlternateColorCodes ('&',getConfig().getString("Umodon prefix"));
			if (player.hasPermission("undercovermod.togglemod")){
		
		chat.getPlayerPrefix(player);
		 chat.setPlayerPrefix(player, umodon);
		 player.sendMessage(ChatColor.GREEN + "Prefix changed.");
		
			}else{
				player.sendMessage(ChatColor.RED + "You don't have permission.");
			}
		
	
	
	
		
	}
		if (command.getName().equalsIgnoreCase("umodreg"))
			if (player.hasPermission("undercovermod.reg")){
		
		player.sendMessage(ChatColor.GREEN + "Prefix changed back to default.");
		chat.getPlayerPrefix(player);
		chat.setPlayerPrefix(player, (""));
		
		
		
		
		
			}
		return false;
}
	
	
}
		
