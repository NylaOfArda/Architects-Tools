package nyla.architectTools.client.gui;

import java.io.File;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ChatComponentText;
import nyla.architectTools.ArcToolsMod;
import nyla.architectTools.converter.ConverterProcess;

public class ConverterGUI extends GuiScreen{
	
	private GuiButton convertBut = null;
	private GuiTextField inputNameTF;
	private GuiTextField outputNameTF;
	
	//public static File schematicaFolderLoc;
	//public static File worldeditFolderLoc;

	@Override
	public void initGui() {
		//schematicaFolderLoc = new File(Minecraft.getMinecraft().mcDataDir, "schematics");
		//worldeditFolderLoc = new File(Minecraft.getMinecraft().mcDataDir, "config\\worldedit\\schematics");

		//C:\Users\User\AppData\Roaming\.minecraft\config\worldedit\schematics
		
		
		inputNameTF = new GuiTextField(this.fontRendererObj, 5, 5, 200, 20);
		inputNameTF.setMaxStringLength(50);
		inputNameTF.setText("Input File Name");
		inputNameTF.setFocused(true);
		
		outputNameTF = new GuiTextField(this.fontRendererObj, 5, 50, 200, 20);
		outputNameTF.setMaxStringLength(50);
		outputNameTF.setText("Output File Name");
		//outputNameTF.setFocused(true);
		
		convertBut = new GuiButton(1, 5, 100, 200, 20, "Convert");
		this.buttonList.add(this.convertBut);
		
		
	}
	
	@Override
	public void drawScreen(int x, int y, float ticks) {
		
		this.drawDefaultBackground();
		
		this.inputNameTF.drawTextBox();
		this.outputNameTF.drawTextBox();
		
		super.drawScreen(x, y, ticks);
	}
	
	@Override
	public void actionPerformed(GuiButton but) {
		if(but.id == 1) {
			if(ArcToolsMod.schematicaFolderLoc.exists()) {
				File inputF = new File(ArcToolsMod.schematicaFolderLoc, inputNameTF.getText() + ConverterProcess.fileType);
				File outputF = new File(ArcToolsMod.worldeditFolderLoc, outputNameTF.getText() + ConverterProcess.fileType);
				if(inputF.exists()){
					if(!outputF.exists()) {
						ConverterProcess.convertLogic(inputF, outputF);
						this.mc.thePlayer.addChatComponentMessage(new ChatComponentText("File converted and saved to .minecraft/config/worldedit/schematics"));
					}else {
						this.mc.thePlayer.addChatComponentMessage(new ChatComponentText("A file with that name already exists in the output folder"));
					}
				}else {
					this.mc.thePlayer.addChatComponentMessage(new ChatComponentText("A file with that name doesn't exist in the input folder"));
				}
			}
		}
	}
	
	public void updateScreen() {
		super.updateScreen();
		if(inputNameTF.isFocused()) {
			this.inputNameTF.updateCursorCounter();
		}else if(outputNameTF.isFocused()) {
			this.outputNameTF.updateCursorCounter();
		}
	}
	
	protected void keyTyped(char par1, int par2) {
		if(!( par2== Keyboard.KEY_E  &&  (this.inputNameTF.isFocused() || this.outputNameTF.isFocused()))) super.keyTyped(par1, par2);
		if(inputNameTF.isFocused()) {
			this.inputNameTF.textboxKeyTyped(par1, par2);
		}else if(outputNameTF.isFocused()) {
			this.outputNameTF.textboxKeyTyped(par1, par2);
		}
	}
	
	protected void mouseClicked(int x, int y, int btn) {
		super.mouseClicked(x, y, btn);
		this.inputNameTF.mouseClicked(x, y, btn);
		this.outputNameTF.mouseClicked(x, y, btn);
		
	}
	
}
