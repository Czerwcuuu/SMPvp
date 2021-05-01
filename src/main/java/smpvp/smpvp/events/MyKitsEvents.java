package smpvp.smpvp.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import smpvp.smpvp.SMPvp;
import smpvp.smpvp.commands.openKitGui;
import smpvp.smpvp.commands.openMyKits;
import smpvp.smpvp.inventories.AllKits;
import smpvp.smpvp.inventories.InventoryData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyKitsEvents implements Listener {
    SMPvp plugin = SMPvp.getInstance();
    Inventory newInv;


    @EventHandler
    public void onInventoryClick (InventoryClickEvent e) throws IOException {
        Inventory inv = openMyKits.inventories.get(e.getWhoClicked());
        if (e.getInventory() != inv) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        Player p = (Player) e.getWhoClicked();
        List<String> mykits = plugin.kitlist.getConfig().getStringList(p.getName()+".name");

        String kitName;
        if(plugin.kitlist.getConfig().contains(p.getName()+".name")){
            List<String> ConfigList = plugin.kitlist.getConfig().getStringList(p.getName()+".name");
            kitName = p.getName()+ (ConfigList.size()-1);
        }
        else{
            kitName = p.getName()+ 0;
        }


        if(e.getRawSlot() < mykits.size()){
            p.sendMessage("Kliknąłeś slot " + e.getRawSlot());
            p.closeInventory();
            InventoryData.RestoreInventory(kitName,p);
            newInv = InventoryData.inventories.get(p);
            p.openInventory(newInv);
        }

        p.sendMessage("Kliknąłeś slot " + e.getRawSlot());
    }

    @EventHandler
    public void onEditInventory (InventoryClickEvent e) throws IOException {
        newInv = InventoryData.inventories.get(e.getView().getPlayer());
        if (e.getInventory() != newInv) return;

        if(e.getRawSlot() < 5 || e.getRawSlot() == 18 || e.getRawSlot() == 43 || e.getRawSlot() == 44){
            e.setCancelled(true);
        }
        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        final Player p = (Player) e.getWhoClicked();



        if(e.getRawSlot() == 44){
            InventoryData inventoryData = new InventoryData(e.getView().getTitle(),e.getInventory(),p);
            inventoryData.Show();
        }

        p.sendMessage("Kliknąłeś slot " + e.getRawSlot());
        }


    boolean IsEquipable(ItemStack i)
    {
        ItemStack test = new ItemStack(i.getType());

        try
        {
            test.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        }
        catch(IllegalArgumentException e)
        {
            return false;
        }

        return true;
    }


}
