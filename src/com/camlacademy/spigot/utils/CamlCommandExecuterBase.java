package com.camlacademy.spigot.utils;

import org.bukkit.command.CommandExecutor;

public abstract class CamlCommandExecuterBase implements CommandExecutor{
	protected CamlPluginBase plugin;

	public CamlCommandExecuterBase(CamlPluginBase plugin, String commandName) {
		super();
		this.plugin = plugin;
		this.plugin.getCommand(commandName).setExecutor(this);
	}
	
	
}
