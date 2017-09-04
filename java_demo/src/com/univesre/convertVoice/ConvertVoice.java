package com.univesre.convertVoice;

import java.io.File;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;

/**
 * @ClassName: ConvertVoice
 * @Description: TODO
 * @author: UNIVESRE
 * @date: 2017年7月11日 下午5:52:37
 * <href="http://blog.csdn.net/qllinhongyu/article/details/29817297">, Platform: Windows;
 */
public class ConvertVoice {

	public static void main(String[] args) throws Exception {
		change();
	}
	public static void change() {
		
		File source = new File("/Users/UNIVESRE/Desktop/ykhd.amr");
		File target = new File("/Users/UNIVESRE/Desktop/converted.mp3");
		AudioAttributes audio = new AudioAttributes();
		Encoder encoder = new Encoder();
		
		audio.setCodec("libmp3lame");
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp3");
		attrs.setAudioAttributes(audio);
	
		try {
			encoder.encode(source, target, attrs);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InputFormatException e) {
			e.printStackTrace();
		} catch (EncoderException e) {
			e.printStackTrace();
		}
	}
}

/*
 * it.sauronsoftware.jave.InputFormatException
	at it.sauronsoftware.jave.Encoder.parseMultimediaInfo(Encoder.java:659)
	at it.sauronsoftware.jave.Encoder.encode(Encoder.java:840)
	at it.sauronsoftware.jave.Encoder.encode(Encoder.java:713)
	at com.univesre.convertVoice.ConvertVoice.change(ConvertVoice.java:29)
	at com.univesre.convertVoice.ConvertVoice.main(ConvertVoice.java:14)
 */
