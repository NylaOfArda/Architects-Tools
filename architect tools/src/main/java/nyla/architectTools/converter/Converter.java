package nyla.architectTools.converter;

//import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTTagCompound;

public class Converter {
	
	private static Converter instance = null;
	
	public static Converter getInstance() {
		if(instance == null) {
			instance = new Converter();
		}
		return instance;
	}
	
	public byte[] getAddBlocks(NBTTagCompound fileStruct) {
		return fileStruct.getByteArray("AddBlocks");
	}
	
	/**
	 * Converter logic
	 * Works both ways (schematica to worldedit and vis versa)
	 * 
	 * Fixes an inconsitinsy with an indexed byte array where hexidecimal values are stored flipped.
	 * Fixes it by simply fliping the hexidecimal value
	 * 
	 */
	public void schematicaToWE_addBlocks(byte[] addBlocks) {
		
		int length = addBlocks.length;
		
		for(int b = 0; b < length; b++) {
			String builtStr = Integer.toHexString((int)addBlocks[b]);
			if(builtStr.length() == 1) {
				builtStr = "0" + builtStr;
			}
			StringBuilder input1 = new StringBuilder();
			 
	       
	        input1.append(builtStr);
	 
	      
	        input1.reverse();
	        
	        builtStr = input1.toString();
	        
	        String t = "0"; 
	        
	        int len = builtStr.length();
	        byte[] data = new byte[len / 2];
	        if(len > 1) {
	        	t = "";
		        for (int i = 0; i < len; i += 2) {
		            data[i / 2] = (byte) ((Character.digit(builtStr.charAt(i), 16) << 4)
		                                 + Character.digit(builtStr.charAt(i+1), 16));
		            t += data[i/2];
		        }
	        }
	        
	        
	        addBlocks[b] = Byte.parseByte(t);
		}
		
		
	}
	
	
}
