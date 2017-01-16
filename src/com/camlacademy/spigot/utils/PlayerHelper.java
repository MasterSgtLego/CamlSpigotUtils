package com.camlacademy.spigot.utils;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerHelper {
	private JavaPlugin plugin;

	public PlayerHelper(JavaPlugin plugin) {
		super();
		this.plugin = plugin;
		this.plugin.getLogger().info("PlayerHelper loaded");
	}
	
	
	public ItemStack getFirstArrowStack(Player player) {

		if (player.getInventory() != null && player.getInventory().getStorageContents() != null) {

			for (ItemStack item : player.getInventory().getStorageContents()) {
				if (item == null) {
					// this must be an empty slot in the inventory.
					// We will ignore it and "continue" to the next iteration of
					// the loop
					continue;
				}

				Material material = item.getType();

				if (material.equals(Material.ARROW)) {
					// this is the first arrow we encountered, so we will return
					// it.
					// the first arrow stack encountered is always the arrow
					// stack being fired.
					return item;
				}
			}
		}

		// if we got this far, the player must not have had an arrow in their
		// inventory
		return null;
	}

	@SuppressWarnings("deprecation")
	public ItemStack getItemInHand(Player player) {
		if (player == null)
			return null;

		// if this is not null, return it, otherwise, try another method.
		if (player.getItemInHand() != null) {
			return player.getItemInHand();
		}

		// if this is not null, return it, otherwise, try another method.
		if (player.getEquipment() != null && player.getEquipment().getItemInHand() != null) {
			return player.getEquipment().getItemInHand();
		}

		// if this is not null, return it, otherwise, try another method.
		if (player.getInventory() != null && player.getInventory().getItemInHand() != null) {
			return player.getInventory().getItemInHand();
		}

		// if we got this far, the player either does not have anything in their
		// hand, or our code needs to be updated/fixed
		return null;
	}

	public void replaceEntityWithNamedArrow(Entity entity, ItemStack itemInHand, Player player, String arrowName) {

		// create arrow for entity
		ItemStack arrow = new ItemStack(Material.ARROW);
		
		if(arrowName != null){
			ItemMeta meta = arrow.getItemMeta();
			meta.setDisplayName(arrowName);
			arrow.setItemMeta(meta);
		}

		// drop the arrow
		entity.getWorld().dropItem(entity.getLocation(), arrow);

		// remove the entity
		entity.remove();

		// remove one arrow from the players hand
		if (itemInHand.getAmount() == 1) {
			// player only has one arrow in their hand, so we remove the entire
			// "stack"
			player.getInventory().remove(itemInHand);
		} else {
			// player must have more than one arrow in their hand, so we set the
			// amount equal to what it was minus one
			itemInHand.setAmount(itemInHand.getAmount() - 1);
		}
	}
	
}
