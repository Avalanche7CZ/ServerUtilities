package ftb.utils.mod.config;

import ftb.lib.FTBLib;
import ftb.lib.api.config.*;
import ftb.utils.world.ranks.Ranks;
import java.io.File;

public class FTBUConfig // FTBU
 {
    public static final ConfigFile configFile = new ConfigFile("ftbu");

    public static void load() {
        configFile.setFile(new File(FTBLib.folderLocal, "ftbu/config.json"));
        configFile.setDisplayName("FTBUtilities");
        configFile.addGroup("backups", FTBUConfigBackups.class);
        configFile.addGroup("commands", FTBUConfigCmd.class);
        configFile.addGroup("general", FTBUConfigGeneral.class);
        configFile.addGroup("login", FTBUConfigLogin.class);
        configFile.addGroup("tops", FTBUConfigTops.class);
        configFile.addGroup("chunkloading", FTBUConfigChunkloading.class);
        Ranks.load(configFile);

        ConfigRegistry.add(configFile);
        configFile.load();
    }
}
