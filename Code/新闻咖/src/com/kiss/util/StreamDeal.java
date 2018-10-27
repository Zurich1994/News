package com.kiss.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamDeal {

	public static String StreamData(InputStream is)
	{
		byte[] buf = new byte[1024];	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = 0;
		try {
			while((len=is.read(buf))!=-1)
			{
				baos.write(buf, 0, len);
			}
			
			byte[] result = baos.toByteArray();
			
			is.close();
			baos.close();
			return new String(result);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
}
