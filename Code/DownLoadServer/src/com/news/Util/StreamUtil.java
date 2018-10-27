package com.news.Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtil {

	public static String getText(InputStream is)
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();	
		String text = null;
		int len = 0;
		byte[] buf = new byte[1024];
		
		try {
			while((len = is.read(buf))!=-1)
			{
				baos.write(buf, 0, len);
				
			}
			byte[] result = baos.toByteArray();
			
			is.close();
			baos.close();
			return new String(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
}
