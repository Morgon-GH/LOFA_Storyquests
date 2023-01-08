package de.morgon.LegendsOfArrol.configs;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlayerCoordinatesConfig {

    private static File file2;
    private static FileConfiguration customFile2;

    //finds or generates the config file
    public static void setup(){

        file2 = new File(Bukkit.getServer().getPluginManager().getPlugin("LegendsOfArrol").getDataFolder(), "playercoordinates.yml");

        if(!file2.exists()){
            try{
                file2.createNewFile();
            }catch (IOException e){}
        }
        customFile2 = YamlConfiguration.loadConfiguration(file2);
    }

    public static FileConfiguration get(){
         return customFile2;
    }

    public static void save(){
        try{
            customFile2.save(file2);
        }catch (IOException e){
            System.out.println("Couldn't save Progress Config");
        }
    }
    public static void reload(){
        customFile2 = YamlConfiguration.loadConfiguration(file2);
    }
}
