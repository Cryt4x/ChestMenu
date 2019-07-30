package de.cryt4x.invmenu.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.cryt4x.invmenu.main.Main;



/**
 * 
 * @author CryT4x
 * @version 0.1
 * 
 * WebSite: https://cryt4x.blogspot.com/
 * 
 * Following parameters have to been set in "plugin.yml" to get this code working:
 * 		name:
 * 		author:
 * 		version:
 * 		api-version:
 * 		website:
 * 
 * Add <getCommand("<COMMAND_NAME>").setExecutor(new InfoCommand());>
 * Write the Author(s) between <""> in line 73
 * The names will be shown exactly as you wrote it between <"">
 * 
 * InGame:		Command has colors
 * Console:		Command is in a Box (dynamic size)
 * 
 */

public class InvMenuInfo implements CommandExecutor //implements Command class
{
	//Draws a line out of <int i> times <String s>
	public String spacer(String s, int i)
	{
		String x = "";
		for (int k = 0; k <= i;k++) x += s;
		return x;
	}

	//Command
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (sender instanceof Player) //When you use this command InGame
		{
			Player player = (Player) sender;
			if (args.length == 0)
			{
				//InGame Chat-Output
				player.sendMessage("§d//====================================\\\\\n||");
				player.sendMessage("§d||§e Plugin Name: §b"+Main.getPlugin().getDescription().getName());
				player.sendMessage("§d||§e Author: §cCryT4x");
				player.sendMessage("§d||§e Website: §b"+Main.getPlugin().getDescription().getWebsite());
				player.sendMessage("§d||§e Version: §b"+Main.getPlugin().getDescription().getVersion());
				player.sendMessage("§d||§e APIVersion: §b"+Main.getPlugin().getDescription().getAPIVersion());
				player.sendMessage("§d||\n\\\\====================================//");
			}
		}
		else if (sender instanceof ConsoleCommandSender) //When you use this command in console
		{
			//String Array with plugin informations
			String info[] = 
				{
					Main.getPlugin().getDescription().getName(),
					Main.getPlugin().getDescription().getWebsite(),
					Main.getPlugin().getDescription().getVersion(),
					Main.getPlugin().getDescription().getAPIVersion(),
					"CryT4x"
				};
			int infoL = 0; //Length (amount char symbols) of longest plugin information
			for (int i = 0;i < 5;i++) //Length of longest plugin information
			{
				if (infoL < info[i].length()) infoL = info[i].length();
			}
			
			//First two lines of information box
			System.out.println("//=============="+spacer("=", infoL)+"\\\\");
			System.out.println("||              "+spacer(" ", infoL)+"||");
			
			//Forcing all informations to have the same length
			for (int k = 0; k < 5; k++)
			{
				while (info[k].length() < infoL)
				{
					info[k] += " ";
				}
			}
			
			//Console Chat-Output (information box)
			System.out.println("|| Plugin Name: "+info[0]+" ||");
			System.out.println("|| Author:      "+info[4]+" ||");
			System.out.println("|| Website:     "+info[1]+" ||");
			System.out.println("|| Version:     "+info[2]+" ||");
			System.out.println("|| APIVersion:  "+info[3]+" ||");
			System.out.println("||              "+spacer(" ", infoL)+"||");
			System.out.println("\\\\=============="+spacer("=", infoL)+"//");
		}
		return false;
	}
}
