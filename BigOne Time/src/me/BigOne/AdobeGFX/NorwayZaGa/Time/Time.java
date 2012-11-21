package me.BigOne.AdobeGFX.NorwayZaGa.Time;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Time extends JavaPlugin
{
	public ChatColor red = ChatColor.RED;
	public ChatColor gray = ChatColor.GRAY;
	public ChatColor green = ChatColor.GREEN;
	String console = red + "Denne kommandoen kan bare bli kjørt av en spiller!";
	String permission = red + "Du har ikke permission til dette!";
	String message1 = red + "skriv /tid <morgen - dag - kveld - natt>";

  
  public void onDisable() {
    System.out.println("=========( BigOne Time )=========");
    System.out.println("[BigOne Time] is disabled!");
  }

  public void onEnable() {
    System.out.println("=========( BigOne Time )=========");
    System.out.println("[BigOne Time] is enabled!");
  }
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
	  if (!(sender instanceof Player)) {
		  sender.sendMessage(ChatColor.RED + console);
		  return true;
	  }
	  Player p = (Player) sender;
	  if (command.getName().equalsIgnoreCase("tid")) {
		  if (!p.hasPermission("BigOne.time")) {
			  p.sendMessage(permission);
			  return true;
		  }
	  if (args.length == 0) {
		  p.sendMessage(message1);
		  return true;
	  }
		  if (args[0].equalsIgnoreCase("morgen") || args[0].equalsIgnoreCase("m")) {
			  p.sendMessage(green + "din tid ble forandret til " + gray + "morgen");
			  p.setPlayerTime(59000L, true);
			  return true;
		  }
	  if (args[0].equalsIgnoreCase("dag") || args[0].equalsIgnoreCase("d")) {
		  p.sendMessage(green + "din tid ble forandret til " + gray + "dag");
		  p.setPlayerTime(13000L, true);
		  return true;
	  }
	  if (args[0].equalsIgnoreCase("kveld") || args[0].equalsIgnoreCase("k")) {
		  p.sendMessage(green + "din tid ble forandret til " + gray + "kveld");
		  p.setPlayerTime(24000L, true);
		  return true;
	  }
	  if (args[0].equalsIgnoreCase("natt") || args[0].equalsIgnoreCase("n")) {
		  p.sendMessage(green + "din tid ble forandret til " + gray + "natt");
		  p.setPlayerTime(50000L, true);
		  return true;
	  }
	  if (args[0] != null) {
		  p.sendMessage(red + args[0] + " er ikke en gyldig tid");
	  }
	return false;
  }
	return false;
}
}