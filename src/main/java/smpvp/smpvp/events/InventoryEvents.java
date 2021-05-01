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
import smpvp.smpvp.commands.openKitGui;
import smpvp.smpvp.inventories.InventoryData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InventoryEvents implements Listener {

    //cancel drag
    @EventHandler
    public void onInventoryDrag (InventoryDragEvent e){
        if(e.getInventory() == openKitGui.inv){
            if(Integer.parseInt(e.getInventorySlots().toString()) > 0){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryClick (InventoryClickEvent e) throws IOException {
        if (e.getInventory() != openKitGui.inv) return;

        if(e.getRawSlot() < 4 || e.getRawSlot() == 18 || e.getRawSlot() == 43 || e.getRawSlot() == 44){
            e.setCancelled(true);
        }
        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        final Player p = (Player) e.getWhoClicked();




        if(e.getRawSlot() == 44){
            //zapisz ekwipunek
            InventoryData inventoryData = new InventoryData("Test2",e.getInventory(),p);
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
