package imageexif;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Scanner;

import com.drew.imaging.jpeg.JpegMetadataReader;  
import com.drew.metadata.Directory;  
import com.drew.metadata.Metadata;  
import com.drew.metadata.Tag;  
import com.drew.metadata.exif.ExifDirectory;  

public class exif {
	public static void main(String[] args) throws Exception {
	//  ‰»ÎÕº∆¨¬∑æ∂
		System.out.println("Please enter jpeg file name and path(eg:C://users/13102/Desktop/123.jpg)");
		Scanner path1 = new Scanner(System.in);
		String path = path1.next();
	//	String path = "c://users/13102/Desktop/123.jpg";
	//	String pathtxt = "C:\\Users\\13102\\Desktop\\123.txt";
		System.out.println("Please enter txt file name and path(eg:C:\\Users\\13102\\Desktop\\123.txt)");
		Scanner path2 = new Scanner(System.in);
		String pathtxt = path2.next();
		File jpegFile = new File(path);  
        Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);  
        Directory exif = metadata.getDirectory(ExifDirectory.class);  
        Iterator tags = exif.getTagIterator(); 
        File f = new File(pathtxt);
        f.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(f));
        while (tags.hasNext()) {  
            Tag tag = (Tag)tags.next();
            System.out.println(tag);
            out.write(tag+"\r\n");
        }
        out.flush();
        out.close();
    }  
}
