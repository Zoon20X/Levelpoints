package levelpoints.otherPluginConnections;

import com.songoda.epicspawners.api.events.SpawnerPlaceEvent;
import com.songoda.epicspawners.spawners.spawner.Spawner;
import levelpoints.lp.LP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class EpicSpawners implements Listener {
    private Plugin plugin = LP.getPlugin(LP.class);
    private LP lp = LP.getPlugin(LP.class);

    public EpicSpawners(LP lp) {

    }

    @EventHandler
    public void onSpawnerPlace(SpawnerPlaceEvent event){
        Spawner spawner = event.getSpawner();
        Player player = event.getPlayer();
        File userdata = new File(lp.userFolder, player.getUniqueId() + ".yml");
        FileConfiguration UsersConfig = YamlConfiguration.loadConfiguration(userdata);
        if(lp.ESConfig.getBoolean("DebugName")){
            player.sendMessage(spawner.getIdentifyingName().toString());
        }

        if(UsersConfig.getInt(player.getName() + ".level") >= lp.ESConfig.getInt(spawner.getIdentifyingName().toString())){

        }else{
            event.setCancelled(true);
        }

    }
}
