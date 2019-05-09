package de.n1ck145.autoTool.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	private static Main main;
	public static String PREFIX = "§8[§4AutoTool§8] ";
	private FileConfiguration config;
	
	
	@Override
	public void onEnable() {
		main = this;
		this.config = getConfig();
		
		ArrayList<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		config.options().copyDefaults(true);
		config.addDefault("pickaxe", 1);
		config.addDefault("shovel", 2);
		config.addDefault("axe", 3);
		saveConfig();
		
		Bukkit.getPluginManager().registerEvents(new Events(), this);
		
		System.out.println(PREFIX + "§aPlugin gestartet!");
	}
	
	
	public static Main getMain() {
		return main;
	}
}
