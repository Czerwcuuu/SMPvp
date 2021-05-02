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
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import smpvp.smpvp.SMPvp;
import smpvp.smpvp.arenas.ArenaManager;
import smpvp.smpvp.arenas.NewArenas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class openMyKits implements CommandExecutor {

    SMPvp plugin = SMPvp.getInstance();
    public static HashMap<Player,Inventory> inventories = new HashMap<>();

    public Inventory inv;

    public boolean onCommand (CommandSender sender, Command cmd, String label, String[] arg){

        Player player = (Player) sender;
        if(NewArenas.playerIsInCustomArena(player)!=null) {
            player.sendMessage("Nie możesz tego użyć podczas walki|customowa");
            return false;
        }
        else if(ArenaManager.playerIsInArena(player)) {
            player.sendMessage("Nie możesz tego użyć podczas walki|zwykla");
            return false;
        }
        else if(label.equalsIgnoreCase("mojekity")){
            if(!(sender instanceof Player)){
                sender.sendMessage("Musisz być graczem!");
                return true;
            }
            //Otwórz gui z kitami
            createInv(player);
            openInventory(player);


        }
        return false;
    }

    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }

    public void createInv(Player p){
        inv = Bukkit.createInventory(null,27, ChatColor.GREEN+"Kity "+ p.getName());

        List<String> mykits = plugin.kitlist.getConfig().getStringList(p.getName()+".name");
        ItemStack item = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();

        for(int i=0; i<mykits.size(); i++){
            meta.setDisplayName(mykits.get(i));
            item.setItemMeta(meta);
            inv.setItem(i,item);
        }

        inventories.put(p,inv);

    }


}
