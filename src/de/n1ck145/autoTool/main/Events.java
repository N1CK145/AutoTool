package de.n1ck145.autoTool.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener{

	FileConfiguration conf = Main.getMain().getConfig();
	
	List<Integer> axe = conf.getIntegerList("axe");
	List<Integer> pick = conf.getIntegerList("pickaxe");
	List<Integer> shov = conf.getIntegerList("shovel");
	
	ArrayList<Material> tools_shovel = new ArrayList<>();
	ArrayList<Material> tools_axe = new ArrayList<>();
	ArrayList<Material> tools_pick = new ArrayList<>();
	
	public Events() {
		tools_shovel.add(Material.DIAMOND_SPADE);
		tools_shovel.add(Material.IRON_SPADE);
		tools_shovel.add(Material.STONE_SPADE);
		tools_shovel.add(Material.WOOD_SPADE);
		tools_shovel.add(Material.GOLD_SPADE);
		
		tools_axe.add(Material.DIAMOND_AXE);
		tools_axe.add(Material.IRON_AXE);
		tools_axe.add(Material.STONE_AXE);
		tools_axe.add(Material.WOOD_AXE);
		tools_axe.add(Material.GOLD_AXE);
		
		tools_pick.add(Material.DIAMOND_PICKAXE);
		tools_pick.add(Material.IRON_PICKAXE);
		tools_pick.add(Material.STONE_PICKAXE);
		tools_pick.add(Material.WOOD_PICKAXE);
		tools_pick.add(Material.GOLD_PICKAXE);
	}

	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void attackBlockEvent(PlayerInteractEvent e) {
		if(e.getAction() == Action.LEFT_CLICK_BLOCK) {
			Material m = e.getClickedBlock().getType();
			Inventory inv = e.getPlayer().getInventory();
			
			if(pick.contains(m.getId())) {
				for(int i = 0; i < 8; i++) {
					ItemStack item = inv.getItem(i);
					
					
					
					if(!tools_pick.contains(e.getPlayer().getItemInHand().getType())) {
						if (item != null && tools_pick.contains(item.getType())) {
							inv.setItem(i, e.getPlayer().getItemInHand());
							e.getPlayer().setItemInHand(item);
						}
					}
					
				}
					
			}else if(axe.contains(m.getId())) {
				for(int i = 0; i < 8; i++) {
					ItemStack item = inv.getItem(i);

					if(!tools_axe.contains(e.getPlayer().getItemInHand().getType())) {
						if (item != null && tools_axe.contains(item.getType())) {
							inv.setItem(i, e.getPlayer().getItemInHand());
							e.getPlayer().setItemInHand(item);
						}
					}
				}
			}else if(shov.contains(m.getId())) {
				for(int i = 0; i < 8; i++) {
					ItemStack item = inv.getItem(i);					
					
					if(!tools_shovel.contains(e.getPlayer().getItemInHand().getType())) {
						if (item != null && tools_shovel.contains(item.getType())) {
							inv.setItem(i, e.getPlayer().getItemInHand());
							e.getPlayer().setItemInHand(item);
						}
					}
					
				}
			}
		}
	}
	
}
