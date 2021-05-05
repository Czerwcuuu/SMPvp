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
import smpvp.smpvp.Statics;
import smpvp.smpvp.configs.Config;

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
    public boolean editing = false;



    public InventoryData(String name,Inventory inv,Player p, boolean editing) throws IOException {
        this.name = name;
        this.inv = inv;
        this.p = p;
        this.editing = editing;


        SaveInventory();
    }


    void SaveInventory() throws IOException {
        YamlConfiguration c = new YamlConfiguration();
        c.set("inventory.content", inv.getContents());

        List<String> ConfigList = plugin.kitlist.getConfig().getStringList(p.getName()+".name");

        if(plugin.kitlist.getConfig().getStringList(p.getName()+".name").size()>=26)
        {
            p.sendMessage("§4§lNie możesz zapisać więcej kitów!");
        }

        if(ConfigList.contains(name)){
            if(!editing){
            name = name+1;
            }
            else{
                p.sendMessage("§a§lZapisano pomyślnie!");
            }
        }
        c.save(new File(plugin.getDataFolder()+"/kits", name+".yml"));

        //debugs
        AllKits.AddKit(name,p.getName());
        //Bukkit.broadcastMessage("Kit gracza:"+AllKits.getKitName(p.getName()));
    }

    public static void RemoveKit(String Name,Player p){
        File dir = new File(plugin.getDataFolder()+"/kits", Name+".yml");
        dir.delete();

        List<String> ConfigList = plugin.kitlist.getConfig().getStringList(p.getName()+".name");

        //Bukkit.broadcastMessage(String.valueOf(ConfigList.indexOf(Name)));
        //Bukkit.broadcastMessage(Name);

        ConfigList.remove(Name);
        plugin.kitlist.getConfig().set(p.getName()+".name",ConfigList);
        plugin.kitlist.saveConfig();

    }

    @SuppressWarnings("unchecked")
    public static void RestoreInventory(String Name,Player p){
        //Bukkit.broadcastMessage(Name+".yml");
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder()+"/kits", Name+".yml"));
        ItemStack[] content = ((List<ItemStack>) Objects.requireNonNull(c.get("inventory.content"))).toArray(new ItemStack[0]);

        //Bukkit.broadcastMessage(content[0].toString());
        //Bukkit.broadcastMessage(String.valueOf(content.length));

        Inventory inv = Bukkit.createInventory(null,45, Name);
        ItemStack item = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<String>();
        lore.add("test");
        //ODWZORUJ WYGLĄD KITU
        for(int i=0; i<content.length; i++){

            if(i==41){
                assert meta != null;
                item.setType(Material.RED_STAINED_GLASS_PANE);
                meta.setDisplayName(ChatColor.DARK_BLUE + "USUN");
                lore.set(0,ChatColor.GRAY + "Kliknij zeby usunąć swój kit");
                meta.setLore(lore);
                item.setItemMeta(meta);
                inv.setItem(Statics.DELETE_BUTTON,item);
            }
            else if(i==42){
                assert meta != null;
                item.setType(Material.PURPLE_STAINED_GLASS_PANE);
                meta.setDisplayName(ChatColor.DARK_BLUE + "WEŹ KIT");
                lore.set(0,ChatColor.GRAY + "Kliknij zeby sprawdzić swój kit");
                meta.setLore(lore);
                item.setItemMeta(meta);
                inv.setItem(Statics.GETKIT_BUTTON,item);
            }
            else{
                inv.setItem(i,content[i]);
            }

        }
        inventories.put(p,inv);
    }



    public void Show(){
        //Bukkit.broadcastMessage(String.valueOf(inv.getSize()));
        //Bukkit.broadcastMessage(inv.getItem(0).toString());

    }


}
