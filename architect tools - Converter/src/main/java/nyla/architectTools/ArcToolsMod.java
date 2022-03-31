package nyla.architectTools;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Blocks;

@Mod(modid = ArcToolsMod.MODID, version = ArcToolsMod.VERSION)
public class ArcToolsMod {

	public static final String MODID = "arctools";
	public static final String VERSION = "1.0";
	
	 @SidedProxy(clientSide = "nyla.architectTools.client.ArcToolsClientProxy", serverSide = "nyla.architectTools.ArcToolsCommonProxy")
	 public static ArcToolsCommonProxy proxy;
	    
	 @Instance("arctools")
	  public static ArcToolsMod instance;
	 
    @EventHandler
    public void init(FMLInitializationEvent event){
    	
    }
	
}
