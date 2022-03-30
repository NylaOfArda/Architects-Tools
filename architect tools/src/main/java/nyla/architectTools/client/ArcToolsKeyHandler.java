package nyla.architectTools.client;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import nyla.architectTools.ArcToolsMod;

public class ArcToolsKeyHandler {
	
	public static KeyBinding keyBindOpenConverter = new KeyBinding("Converter", Keyboard.KEY_V, "ArcTools");
	
	private static Minecraft mc = Minecraft.getMinecraft();
	
	public ArcToolsKeyHandler() {
		FMLCommonHandler.instance().bus().register(this);
		ClientRegistry.registerKeyBinding(keyBindOpenConverter);
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void KeyInputEvent(InputEvent.KeyInputEvent event) {
		if(keyBindOpenConverter.isPressed()) {
			mc.thePlayer.openGui(ArcToolsMod.instance, 36, mc.theWorld, 0, 0, 0);
		}
	}
	

}
