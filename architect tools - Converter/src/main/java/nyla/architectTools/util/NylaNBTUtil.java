package nyla.architectTools.util;

import java.io.BufferedOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;

//import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTBase;

public class NylaNBTUtil {
	
	public static NBTTagCompound loadNBTFromFile(File file) throws FileNotFoundException, IOException{
		if(file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			NBTTagCompound nbt = CompressedStreamTools.readCompressed((InputStream)fis);
			fis.close();
			return nbt;
			
		}
		System.out.println("File does not exist");
		return new NBTTagCompound();
	}
	
	public static void saveNBTToFile(File file, NBTTagCompound nbt) throws FileNotFoundException, IOException {
        CompressedStreamTools.writeCompressed((NBTTagCompound)nbt, (OutputStream)new FileOutputStream(file));
		
    }
	
	public static void saveNamedNBTToFile(File file, NBTTagCompound nbt, String tag) throws FileNotFoundException, IOException {
		
		try (DataOutputStream dataoutputstream = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream((OutputStream)new FileOutputStream(file))))) {
			
			NBTTagCompound.func_150298_a("Schematic", (NBTBase)nbt, dataoutputstream);
			
		}
		
	}

}




