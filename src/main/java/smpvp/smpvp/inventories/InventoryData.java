package smpvp.smpvp.inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import smpvp.smpvp.SMPvp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class InventoryData {
    static SMPvp plugin = SMPvp.getInstance();
    public String name = "test";
    public Inventory inv;
    public Player p;
    public static HashMap<Player,Inventory> inventories = new HashMap<>();


    public InventoryData(String name,Inventory inv,Player p) throws IOException {
        this.name = name;
        this.inv = inv;
        this.p = p;

        SaveInventory();
    }


    void SaveInventory() throws IOException {
        YamlConfiguration c = new YamlConfiguration();
        c.set("inventory.content", inv.getContents());
        c.save(new File(plugin.getDataFolder()+"/kits", name+".yml"));

        //debugs
        AllKits.AddKit(name,p.getName());
        //Bukkit.broadcastMessage("Kit gracza:"+AllKits.getKitName(p.getName()));
    }

    @SuppressWarnings("unchecked")
    public static void RestoreInventory(String Name,Player p){
        Bukkit.broadcastMessage(Name+".yml");
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder()+"/kits", Name+".yml"));
        ItemStack[] content = ((List<ItemStack>) Objects.requireNonNull(c.get("inventory.content"))).toArray(new ItemStack[0]);

        Bukkit.broadcastMessage(content[0].toString());
        Bukkit.broadcastMessage(String.valueOf(content.length));

        Inventory inv = Bukkit.createInventory(null,45, Name);

        for(int i=0; i<content.length; i++){
            inv.setItem(i,content[i]);
        }
        //Bukkit.broadcastMessage(inv.toString());
        /*
        helmet = inv.getItem(9);
        helmet = inv.getItem(10);
        helmet = inv.getItem(12);
        helmet = inv.getItem(13);

        for(int i=19; i<27; i++ ){
            rest.set(i-19,inv.getItem(i));
        }
        */
        inventories.put(p,inv);
    }


    public void GiveKit(Player p){

    }



    public void Show(){
        Bukkit.broadcastMessage(String.valueOf(inv.getSize()));
        Bukkit.broadcastMessage(inv.getItem(0).toString());

    }


}
