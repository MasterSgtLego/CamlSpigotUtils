package com.camlacademy.spigot.utils;

import org.bukkit.plugin.java.JavaPlugin;

public class CamlPluginBase extends JavaPlugin{
	protected PlayerHelper playerHelper;
	
	@Override
	public void onEnable() {
		super.onEnable();
		getConfig().options().copyDefaults(true);
		saveConfig();
		playerHelper = new PlayerHelper(this);
	}

	public PlayerHelper getPlayerHelper() {
		return playerHelper;
	}
	
	
}
