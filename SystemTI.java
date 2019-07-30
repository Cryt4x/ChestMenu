package de.cryt4x.invmenu.system;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SystemTI implements CommandExecutor, Listener
{
	
	
	private Player p; //Player who uses the command
	private Inventory inv; //Inventory of the menu
	
	//Inventory Creation
	
	//Inventory Creator
	private void ic1()
	{
		inv = Bukkit.createInventory(null, 9*3, "TI-Menu" );
		for (int i=0;i<27;i++) {  inv.setItem(i,aItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE,"§a§b§c")); }
		inv.setItem(0, aItem(Material.NETHER_STAR,"§5--GAMEMODES--"));
		inv.setItem(1, aItem(Material.GREEN_WOOL,"§aSurvival"));
		inv.setItem(2, aItem(Material.RED_WOOL, "§cCreative"));
		inv.setItem(3, aItem(Material.BLUE_WOOL, "§9Adventure"));
		inv.setItem(4, aItem(Material.YELLOW_WOOL, "§eSpectator"));
		inv.setItem(18, aItem(Material.NETHER_STAR, "§6TI-1"));
		inv.setItem(26, aItem(Material.NETHER_STAR, "§6TI-2"));
	}
	private void ic2()
	{
		inv = Bukkit.createInventory(null, 9*3, "TI-Menu2");
		for (int i=0;i<27;i++) { inv.setItem(i,aItem(Material.LIGHT_GRAY_STAINED_GLASS_PANE,"§cWIP")); }
		inv.setItem(18, aItem(Material.NETHER_STAR, "§6TI-1"));
	}
	
	//New Item with Custom Name Creator
	public ItemStack aItem(Material y, String s)
	{
		ItemStack x = new ItemStack(y);
		ItemMeta iMe = x.getItemMeta();
		iMe.setDisplayName(s);
		x.setItemMeta(iMe);
		return x;
	}
	
	//Command for opening TI-Menu-Inventory
	@Override
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args)
	{
		if (sender instanceof Player)
		{
			p = (Player) sender;
			if (p.hasPermission("cryt4xPL.invmenu.ti"))
			{
				if (args.length == 0)
				{
					ic1();
					p.openInventory(inv);
					p.sendMessage("§6TI was opened!");
				}else{p.sendMessage("§cPls use §6/ti$c!");}
			}else{p.sendMessage("§cYou don't have permission to do that!");}
		}else{sender.sendMessage("This command can only be executed by a player!");}
		return false;
	}

	//Event for Inventory-Click
	@EventHandler
	public void onEvent (InventoryClickEvent e)
	{
		//Bukkit.broadcastMessage("\nEvent Works!");//For development only
		if (e.getCurrentItem() != null && e.getClickedInventory().getHolder() == null)
		{
			//Bukkit.broadcastMessage(" \n \n \n \n \n \n \n"); //For development only
			//Bukkit.broadcastMessage("Bis 1"); //For development only
			if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§a§b§c"))
			{
				//Bukkit.broadcastMessage("Bis 2"); //For development only
				e.setCancelled(true);
				//Bukkit.broadcastMessage("Bis 2.2"); //For development only
			}
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§6TI-2"))
			{
				//Bukkit.broadcastMessage("Bis 3"); //For development only
				e.setCancelled(true);
				e.getWhoClicked().closeInventory();
				ic2();
				e.getWhoClicked().openInventory(inv);
				//Bukkit.broadcastMessage("Bis 3.1"); //For development only
			}
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§6TI-1"))
			{
				e.setCancelled(true);
				e.getWhoClicked().closeInventory();
				ic1();
				e.getWhoClicked().openInventory(inv);
			}
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§aSurvival"))
			{
				//Bukkit.broadcastMessage("Bis 4"); //For development only
				e.setCancelled(true);
				e.getWhoClicked().setGameMode(GameMode.SURVIVAL);
				e.getWhoClicked().closeInventory();
				//Bukkit.broadcastMessage("Bis 5"); //For development only
			}
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§cCreative"))
			{
				e.setCancelled(true);
				e.getWhoClicked().setGameMode(GameMode.CREATIVE);
				e.getWhoClicked().closeInventory();
			}
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§9Adventure"))
			{
				e.setCancelled(true);
				e.getWhoClicked().setGameMode(GameMode.ADVENTURE);
				e.getWhoClicked().closeInventory();
			}
			else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§eSpectator"))
			{
				e.setCancelled(true);
				e.getWhoClicked().setGameMode(GameMode.SPECTATOR);
				e.getWhoClicked().closeInventory();
			}
			else
			{
				e.setCancelled(true); 
				Bukkit.broadcastMessage("Bis end");
			}
			//Bukkit.broadcastMessage("finished"); //For development only
		}
		//else Bukkit.broadcastMessage("\nFailed!"); //For development only
	}
	
	
	
}
