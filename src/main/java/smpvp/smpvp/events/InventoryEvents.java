package smpvp.smpvp.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import smpvp.smpvp.SMPvp;
import smpvp.smpvp.Statics;
import smpvp.smpvp.commands.openKitGui;
import smpvp.smpvp.inventories.InventoryData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InventoryEvents implements Listener {

    SMPvp plugin = SMPvp.getInstance();
    //cancel drag
    @EventHandler
    public void onInventoryDrag (InventoryDragEvent e){
        Inventory inv = openKitGui.inventories.get(e.getWhoClicked());
        if(e.getInventory() == inv){
            if(Integer.parseInt(e.getInventorySlots().toString()) > 0){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryClick (InventoryClickEvent e) throws IOException {
        Inventory inv = openKitGui.inventories.get(e.getWhoClicked());
        if (e.getInventory() != inv) return;
        if(e.getRawSlot() < Statics.EQUIPABLE_SLOTS || e.getRawSlot() == 18 || e.getRawSlot() == 43 || e.getRawSlot() == 44){
            e.setCancelled(true);
        }
        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        final Player p = (Player) e.getWhoClicked();




        if(e.getRawSlot() == Statics.SAVE_BUTTON){
            String kitName;
            if(plugin.kitlist.getConfig().contains(p.getName()+".name")){
                List<String> ConfigList = plugin.kitlist.getConfig().getStringList(p.getName()+".name");
                kitName = p.getName()+ ConfigList.size();
            }
            else{
                kitName = p.getName()+ 0;
            }

            InventoryData inventoryData = new InventoryData(kitName,e.getInventory(),p);
            inventoryData.Show();
            p.closeInventory();
        }
        else if(e.getRawSlot() == Statics.CANCEL_BUTTON){
            p.closeInventory();
        }


        p.sendMessage("Kliknąłeś slot " + e.getRawSlot());
    }

    public void getKit(String kitName,Player p){

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
