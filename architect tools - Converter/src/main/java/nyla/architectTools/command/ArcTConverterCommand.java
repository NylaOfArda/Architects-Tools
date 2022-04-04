package nyla.architectTools.command;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import nyla.architectTools.ArcToolsMod;
import nyla.architectTools.converter.ConverterProcess;

public class ArcTConverterCommand extends CommandBase{

	@Override
	public String getCommandName() {
		return "convert_schem";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "convert_schem <input file name> <output file name>";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		
		if(ArcToolsMod.schematicaFolderLoc.exists() && ArcToolsMod.worldeditFolderLoc.exists()) {
			String[] sanitisedStrings = extractFileNames(args);
			String inputName = sanitisedStrings[0];
			String outputName = sanitisedStrings[1];
			File inputFile = new File(ArcToolsMod.schematicaFolderLoc, inputName + ConverterProcess.fileType);
			File outputFile = new File(ArcToolsMod.worldeditFolderLoc, outputName + ConverterProcess.fileType);
			if(inputFile.exists()) {
				if(!outputFile.exists()) {
					//ConverterProcess.convertLogic(inputFile, ArcToolsMod.schematicaFolderLoc.toString(), args[1]);
				}else {
					sender.addChatMessage(new ChatComponentText("Output file name: " + inputName + " already exists"));
				}
			}else {
				sender.addChatMessage(new ChatComponentText("Input file name: " + outputName + " doesn't exists"));
			}
		}
		
	}
	
	public static String[] extractFileNames(String[] args) {
		String inN = args[0];
		String outN = args[1];
		int len = args.length;
		
		//Extract with ""
		if(len > 1) {
			String fullArgs = args[0];
			for(int i = 1; i > len; i++) {
				fullArgs += " " + args[i];
			}
			Pattern p = Pattern.compile("\"([^\"]*)\"");
			Matcher m = p.matcher(fullArgs);
			int counter = 0;
			while(m.find()) {
				System.out.println(m.group(1));
				/*if(counter == 0) {
					inN = m.group(1);
				}else if(counter == 1){
					outN = m.group(1);
				}
				counter++;
				*/
			}
			
		}
		
		/*
		if(len > 2) {
			
		}else if(len == 2){
			inN = args[0];
			outN = args[1];
		}else {
			inN = args[0];
			outN = args[0] + "_converted";
		}
		*/
		
		return new String[]{inN, outN};
	}
	
	
	/*private static String sanatiseString(String in) {
		String out = in;
		
		if()
		
		return out;
	}
	*/
	

}
