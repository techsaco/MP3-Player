package edu.uga.cs1302.mp3files;

/**
 * MP3File.java contains code for the methods used to control the device
 * @author Divya Yendaoally
 * @version 1.8
 * @since 0.3
 */
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;

import javax.sound.sampled.UnsupportedAudioFileException;
public class MyMP3Files {
	public static void main (String [] args) {
	
		
		System.out.println("Please enter a directory name: ");
		Scanner keyboard = new Scanner(System.in);
		String directoryName = keyboard.nextLine();
		
		//system./divya/desktop/hello.java
		//if ((directoryName.substring(directoryName.length() - 4, directoryName.length())).equals(".mp3")
		
			
		SimpleArrayList songs = new SimpleArrayList();
		
		 File[] fileArray=new File(directoryName).listFiles(); ///Users/Divya/Downloads/sample_music
		
		
		 SimpleArrayList <MP3File> mp3List = new SimpleArrayList<>();
		
		 try {
		 for(File f: fileArray) // loop thru all files
        {

           if(f.getName().endsWith(".mp3")) // to deal with the .mp3 files.
            {                 
        	   	
        	   	 			
        	   		MP3File objMp3 = new MP3File(f.getPath());
        	   		
        	   		
        	   		
        	   		mp3List.add(objMp3);
        	   		
            }  // End of If mp3
           
         }  // Close For File Array
        	   		
        	   		
        	  String answer="";
        	  
        	  MP3File objMp3 = null;
      	ListIterator <MP3File> itr = mp3List.listIterator(-1);
      	
      
			
        	  // Print all Elements using Iterator.
        	  while(itr.hasNext())
              
        	  		{
        		  		objMp3 = (MP3File) itr.next();
        		  		
        		  		if(objMp3 != null) {
        		  		
        		       
        		        System.out.println( "Author: " + objMp3.album );
        		        System.out.println( "Album:  " + objMp3.author );
        		        System.out.println( "Title:  " + objMp3.title);
        		        System.out.println( "Date:   " + objMp3.date);
        		        System.out.println( "-------------------------- " );
        		  		}
        	  		}
        	  	
        	
        	  // End Print All elements using Iterator.
        	  
        	  ListIterator <MP3File> itr1 = mp3List.listIterator(-1);
        	   			do {
        	   			
        	   			System.out.println("• n, move to the next file, if present; otherwise print end of the list;\n" + 
        	   					"• b, move to the previous file, if present; otherwise print top of the list;\n" + 
        	   					"• i, print the information about the current file, including its path;\n" + 
        	   					"• p, play the current file;\n" + 
        	   					"• h, print a short help information about these commands;\n" + 
        	   					"• q, quit the program.");
        	   			answer = keyboard.nextLine();
        	   			
        	   			int count = 0;
        	   			switch(answer)
        	   			{
        	   				case "n" : 
        	   							
        	   					
        	   					if (itr1.hasNext() == false)
        	   					{
        	   						System.out.println("End of the list");
        	   					}
        	   					
        	   					else
        	   					{
        	   					objMp3 = (MP3File) itr1.next();
        	   					System.out.println( "Author: " + objMp3.album );
        	        		        System.out.println( "Album:  " + objMp3.author );
        	        		        System.out.println( "Title:  " + objMp3.title);
        	        		        System.out.println( "Date:   " + objMp3.date);
        	        		        System.out.println( "-------------------------- " );
        	   						
        	   					}
        	   						
        	   						  
        	   					break;
        	   				case "b" : 
        	   					if (itr1.hasPrevious() == false)
        	   					{
        	   						System.out.println("Top of the list");
        	   					}
        	   					
        	   					else
        	   					{
        	   						objMp3 = (MP3File) itr1.previous();
            	   					System.out.println( "Author: " + objMp3.album );
            	        		        System.out.println( "Album:  " + objMp3.author );
            	        		        System.out.println( "Title:  " + objMp3.title);
            	        		        System.out.println( "Date:   " + objMp3.date);
            	        		        System.out.println( "-------------------------- " );
        	   					}
        	   					break;
        	   				case "i" :   
        	   					
        	   				objMp3 = (MP3File) itr1.next();
        	   				MP3File objCurr =(MP3File)itr1.previous();
        	   				System.out.println("Path Name: " + objCurr.pathName);
    	   					System.out.println( "Author: " + objCurr.album );
	        		        System.out.println( "Album:  " + objCurr.author );
	        		        System.out.println( "Title:  " + objCurr.title);
	        		        System.out.println( "Date:   " + objCurr.date);
	        		        System.out.println( "-------------------------- " );
        	   					break;
        	   				case "p" : 	
        	   					objMp3 = (MP3File) itr1.next();
            	   				MP3File objCurr1 =(MP3File)itr1.previous();
        	   					objCurr1.play();
        	   							
        	   					break;
        	   				case "h" :	System.out.println("Press n, to view the next file."
        	   						+ "Press b to view the previous file"
        	   						+ "Press i to be able to see more information on the file"
        	   						+ "Press p if you would like to play the current file"
        	   						+ "Press h, to see the information you see right now"
        	   						+ "Press q if you would like to exit the program.");
        	   					break;
        	   				case "q" :	System.exit(0);
        	   					break;
        	   				default:		System.out.println("Error. Please enter a valid letter: ");
        	   							
        	   					break;
        	   			
        	   			}
        	   			
        	   			
        	   			
        	   			
        	   		} while (answer != "q");
        	   		
        	   		  		
            }
	   		catch (UnsupportedAudioFileException ex) {
	   			System.out.println(ex.toString());
	   			
	   		}
	   		
	   		catch (IOException ex) {
	   			System.out.println(ex.toString());
	   			
	   		}
   			                 
	
}
}