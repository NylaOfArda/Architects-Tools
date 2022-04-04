package nyla.architectTools.client;

import net.minecraft.client.Minecraft;
import nyla.architectTools.ArcToolsCommonProxy;
import nyla.architectTools.client.gui.ConverterGUI;

public class ArcToolsClientProxy extends ArcToolsCommonProxy{
	
	public static ArcToolsKeyHandler keyHandler = new ArcToolsKeyHandler();
	
	@Override
	public void openMyGui() {
		Minecraft.getMinecraft().displayGuiScreen(new ConverterGUI());
	}

}
