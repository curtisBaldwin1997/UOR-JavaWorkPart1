package uk.ac.reading.fv017739.CurtisBaldwin.prepwork;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class TestFileChooser {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileFilter filter = new FileFilter() {

			@Override
			public boolean accept(File f) {
				if(f.getAbsolutePath().endsWith(".txt")) return true;
				if(f.isDirectory()) return true;
				return false;
			}

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "txt";
			}
			
		};
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File selFile = chooser.getSelectedFile();
			System.out.println("You chose to open this file: " + selFile.getName());
			System.out.print("It was a ");
			if(selFile.isFile()){ //exits and is a file
				System.out.println("file");
			} else {
				System.out.println("directory");
			}
			
			try {
				FileWriter writer = new FileWriter(selFile);
				PrintWriter dataStream = new PrintWriter(writer);
				
				dataStream.println(true);
				
				dataStream.close();				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
