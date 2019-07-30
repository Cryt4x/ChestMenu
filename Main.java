package de.cryt4x.invmenu.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.cryt4x.invmenu.commands.InvMenuInfo;
import de.cryt4x.invmenu.system.SystemTI;

public class Main extends JavaPlugin
{
	private static Main plugin;
	public void onEnable ()
	{
		plugin = this;
		
		//Server-Console Output
		System.out.println("[InvMenu] Inventory-Menu (ctpl4) loaded!");
		
		//Plugin-Info
		getCommand("invmenuinfo").setExecutor(new InvMenuInfo());
		
		//Commands
		getCommand("ti").setExecutor(new SystemTI());
		
		//Listeners
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new SystemTI(), this);
	}
	public static Main getPlugin() {
		return plugin;
	}
}
