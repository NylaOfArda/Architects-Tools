package nyla.architectTools.converter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import nyla.architectTools.util.NylaNBTUtil;
//import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTTagCompound;


public class ImprovedConverterMain {
	
	public static final String fileType = ".schematic";

	/*
	public static void main(String[] args) {	
		JFrame frame = setUpFrame();	
	}
	*/
	
	/**
	 * External GUI
	 * 
	 */
	private static JFrame setUpFrame() {
		JFrame frame = new JFrame("Architect's Tools");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(800,800);
	    
	    JPanel inputFileSec = new JPanel();
	    JPanel outputFileSec = new JPanel();
	    JPanel actionSec = new JPanel();
	    
	    JFileChooser chooser = new JFileChooser();
	    
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("SCHEMATIC FILE", "schematic");
	    chooser.setFileFilter(filter);
	    chooser.setAcceptAllFileFilterUsed(false);
	    
	    inputFileSec.add(chooser);
	    
	    JLabel label2 = new JLabel("Output File Name");
        JTextField outputName = new JTextField(20); 
	    outputFileSec.add(label2);
	    outputFileSec.add(outputName);
	    
    
	    JLabel instructions = new JLabel("Choose a base file and an output name");
	    JButton convertBut = new JButton("Convert");
	    actionSec.add(instructions);
	    actionSec.add(convertBut);
	    
	    convertBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(chooser.getSelectedFile() != null) {
					if(!outputName.getText().equals("")) {
						if(convertLogic(chooser.getSelectedFile().getAbsoluteFile(), chooser.getCurrentDirectory().toString(), outputName.getText(), instructions)) {
							instructions.setText("File succefully converted");
							
						}else {
							instructions.setText("Failed to convert");
						}
						
					}else {
						instructions.setText("please choose a name for your output file");
					}
				}else {
					instructions.setText("please choose a file you want to convert");
				}
				
			}
	    	
	    });
	    
	    
	    frame.getContentPane().add(BorderLayout.NORTH, inputFileSec);
	    frame.getContentPane().add(BorderLayout.CENTER, outputFileSec); 
	    frame.getContentPane().add(BorderLayout.SOUTH, actionSec); 
	    frame.setVisible(true);
	    return frame;
	}
	
	
	/**
	 * 
	 * 
	 */
	public static boolean convertLogic(File inputFile, String outputDir, String outputName, JLabel debuger) {
		debuger.setText(ConverterProcess.convertLogic(inputFile, outputDir, outputName));

		
		if(debuger.getText().equals("")) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
