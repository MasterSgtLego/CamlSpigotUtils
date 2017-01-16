package com.camlacademy.spigot.utils;

import org.bukkit.event.Listener;

public class CamlListenerBase implements Listener{
	protected CamlPluginBase plugin;

	public CamlListenerBase(CamlPluginBase plugin) {
		super();
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	}
	
	
}
