package tess4j;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.*;
import net.sourceforge.tess4j.*;

public class Test 
{
	public static void main(String args[])throws IOException
	{
		String result  = "";
        long totalTime = 0;
        long endTime   = 0;
        long startTime = 0;
        String source = "C:\\Users\\vbollapr\\workspace\\Image Extraction\\sample_data\\eurotext.png";
        File imageFile = new File(source);
        Tesseract instance = new Tesseract();
        instance.setDatapath("C:\\Users\\vbollapr\\workspace\\Image Extraction\\tessdata");

        try
        {
        	System.out.println("Scanning for plugins...\n");
            ImageIO.scanForPlugins();
            
            System.out.println("Processing imagefile...\n");
            startTime = System.currentTimeMillis();
            result = instance.doOCR(imageFile);
            endTime = System.currentTimeMillis();
            
            totalTime = endTime - startTime;
            
            System.out.println("Total Time Taken For OCR: " + (totalTime / 1000) +" secs\n");
            
            System.out.println(result);
            
            System.out.println("\n Competed!!");
        } 
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
	}

}
