package nyla.architectTools.converter;

import java.io.File;
import java.io.IOException;

import nyla.architectTools.ArcToolsMod;
import nyla.architectTools.util.NylaNBTUtil;
import net.minecraft.nbt.NBTTagCompound;

public class ConverterProcess {
	
	public static final String fileType = ".schematic";
	
	public static String convertLogic(File inputFile, String outputDir, String outputName) {
		String debuger;
		Converter util = Converter.getInstance();
		
		debuger = "Process got stuck: probably couldn't find required class";
		try {
			
			NBTTagCompound fileStruct = NylaNBTUtil.loadNBTFromFile(inputFile);
				
			byte[] addBlocks = util.getAddBlocks(fileStruct);
			
			util.schematicaToWE_addBlocks(addBlocks);

			NylaNBTUtil.saveNamedNBTToFile(new File(outputDir + "\\" + outputName), fileStruct, "Schematic");
			
			debuger = "";
			
		} catch (IOException ex) {
			debuger = "Something went wrong";
			ex.printStackTrace();
			return debuger;
		} catch(Exception e) {
			debuger = "Something else went wrong";
			return debuger;
		}
		return debuger;
		
	}
	
	public static void convertLogic(File inputFile, File outputFile) {
		convertLogic(inputFile, ArcToolsMod.worldeditFolderLoc.toString(), outputFile.getName());
	
	}

}
