package com.univesre.ffmpeg;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException; 

/**
 * @ClassName: Main
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年7月11日 下午6:02:15
 */
public class Main {
	
	public static boolean amrToMp3(String localPath, String targetFilePath) {  
		  
        try {  
  
            System.out.println("**************  ffmpeg ****************");  
  
            java.lang.Runtime rt = Runtime.getRuntime(); 
            ///usr/local/Cellar/ffmpeg
            String command = "/usr/local/Cellar/ffmpeg -i " + localPath + " " + targetFilePath;   
  
            Process proc = rt.exec(command);  
            InputStream stderr = proc.getErrorStream();  
            InputStreamReader isr = new InputStreamReader(stderr);  
            BufferedReader br = new BufferedReader(isr);  
            String line = null;  
            StringBuffer sb = new StringBuffer();  
            while ((line = br.readLine()) != null)  
                sb.append(line);  
  
            System.out.println("ffmpeg Process errorInfo: " + sb.toString());  
  
            int exitVal = proc.waitFor();  
            System.out.println("ffmpeg Process exitValue: " + exitVal);  
  
            return true;  
        } catch (Exception e) {  
            System.out.println("ffmpeg exec cmd Exception " + e.toString());  
        }  
        return false;  
    }  
      
    public static void main(String[] args) {  
        String path1 = "/Users/univesre/Desktop/ykhd.amr";  
        String path2 = "/Users/univesre/Desktop/bb.mp3";  
        amrToMp3(path1, path2);  
    }  

//	public static void main(String[] args) throws Exception {  
////        String path1 = "Audio/ykhd.amr"; 
////        String path2 = "Audio/yyyy.mp3";  
////        changeToMp3(path1, path2);  
//        
//        File source = new File("/Users/univesre/desktop/ykhd.amr");
//        System.out.println(source.exists());
//        System.out.println(source.canRead());
//		File targe = new File("/Users/univesre/desktop/ykhd.mp3");
//		
//		Encoder encoder = new Encoder();
//		AudioAttributes audio = new AudioAttributes();
//		try {
//			for(String ss : encoder.getSupportedEncodingFormats()) {
//				System.out.println(ss);
//			}
//			audio.setCodec("libmaplame");
//			EncodingAttributes attrs = new EncodingAttributes();
//			attrs.setFormat("mp3");
//			attrs.setAudioAttributes(audio);
//			encoder.encode(source, targe, attrs);
//		
//		} catch (EncoderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }  
//  
//    public static void changeToMp3(String sourcePath, String targetPath) {  
//    		
//	    	
// 
//        File source = new File(sourcePath); 
//        File target = new File(targetPath); 
//        
//        AudioAttributes audio = new AudioAttributes();  
//        Encoder encoder = new Encoder();  
//  
//        audio.setCodec("libmp3lame");  
//        EncodingAttributes attrs = new EncodingAttributes();  
//        attrs.setFormat("mp3");  
//        attrs.setAudioAttributes(audio);  
//  
//        try {  
//            encoder.encode(source, target, attrs);  
//        } catch (IllegalArgumentException e) {  
//            e.printStackTrace();  
//        } catch (InputFormatException e) {  
//            e.printStackTrace();  
//        } catch (EncoderException e) {  
//            e.printStackTrace();  
//        }
//    }  
}
