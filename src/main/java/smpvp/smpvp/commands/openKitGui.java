package smpvp.smpvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import smpvp.smpvp.SMPvp;
import smpvp.smpvp.Statics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class openKitGui implements CommandExecutor {

    SMPvp plugin = SMPvp.getInstance();
    public static HashMap<Player,Inventory> inventories = new HashMap<>();

    public Inventory inv;

    public boolean onCommand (CommandSender sender, Command cmd, String label, String[] arg){

        if(label.equalsIgnoreCase("kit")){
            if(!(sender instanceof Player)){
                sender.sendMessage("Musisz być graczem!");
                return true;
            }
            Player player = (Player) sender;
            //Otwórz gui
            createInv(player);
            //player.openInventory(inv);
            openInventory(player);


        }
        return false;
    }
    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory() == inv) {
            e.setCancelled(true);
        }
    }

    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }

    public void createInv(Player p){

        inv = Bukkit.createInventory(null,45, ChatColor.GREEN+"Kit Generator |"+p.getName());

        ItemStack item = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();
        //Głowa
        meta.setDisplayName(ChatColor.DARK_BLUE + "HELM");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Przeciągnij hełm pod ten slot");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(0,item);

        //Klata
        meta.setDisplayName(ChatColor.DARK_BLUE + "ZBROJA");
        lore.set(0,ChatColor.GRAY + "Przeciągnij zbroje pod ten slot");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(1,item);

        //Spodnie
        meta.setDisplayName(ChatColor.DARK_BLUE + "SPODNIE");
        lore.set(0,ChatColor.GRAY + "Przeciągnij spodnie pod ten slot");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(2,item);

        //Spodnie
        meta.setDisplayName(ChatColor.DARK_BLUE + "BUTY");
        lore.set(0,ChatColor.GRAY + "Przeciągnij buty pod ten slot");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(3,item);


        //Reszta
        item.setType(Material.GREEN_STAINED_GLASS_PANE);
        meta.setDisplayName(ChatColor.GREEN + "RESZTA:");
        lore.set(0,ChatColor.GRAY + "Przeciagaj przedmioty na prawo od tego slotu ->");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(18,item);

        //Zapisz kit
        item.setType(Material.GREEN_GLAZED_TERRACOTTA);
        meta.setDisplayName(ChatColor.GREEN + "ZAPISZ");
        lore.set(0,ChatColor.GRAY + "Zapisz swój kit");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(Statics.SAVE_BUTTON,item);

        //Anuluj
        item.setType(Material.RED_GLAZED_TERRACOTTA);
        meta.setDisplayName(ChatColor.RED + "ANULUJ");
        lore.set(0,ChatColor.GRAY + "Anuluj tworzenie kitu");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(Statics.CANCEL_BUTTON,item);

        inventories.put(p,inv);
    }


}
