package nyla.architectTools;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.client.Minecraft;
import nyla.architectTools.command.ArcTConverterCommand;

@Mod(modid = ArcToolsMod.MODID, version = ArcToolsMod.VERSION)
public class ArcToolsMod {

	public static final String MODID = "arctools";
	public static final String VERSION = "2.0 Beta";
	
	 @SidedProxy(clientSide = "nyla.architectTools.client.ArcToolsClientProxy", serverSide = "nyla.architectTools.ArcToolsCommonProxy")
	 public static ArcToolsCommonProxy proxy;
	    
	 @Instance("arctools")
	  public static ArcToolsMod instance;
	 
	public static File schematicaFolderLoc;
	public static File worldeditFolderLoc;
	 
    @EventHandler
    public void init(FMLInitializationEvent event){
    	schematicaFolderLoc = new File(Minecraft.getMinecraft().mcDataDir, "schematics");
		worldeditFolderLoc = new File(Minecraft.getMinecraft().mcDataDir, "config\\worldedit\\schematics");
    }
	
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
    	//event.registerServerCommand(new ArcTConverterCommand());
 
    }
    
    
    
}
