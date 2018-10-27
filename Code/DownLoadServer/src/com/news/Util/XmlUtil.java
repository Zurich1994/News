package com.news.Util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.news.domain.Newsinfo;

public class XmlUtil {

	//标记位
	private final static int TITLE = 1;
	private final static int LINK = 2;
	private final static int PUBDATE = 3;
	private final static int AUTHOR = 4;
	private final static int DESCRIPTION = 5;
	//记录标记位的
	private int CURRENT = 0;
	private int REC = 0;  //区分先前的title,防止前面的title误解析
	
	
	public List<Newsinfo> list = null;
	public Newsinfo info = null;
	NewsHandler myhandler = new NewsHandler();
	public List<Newsinfo> getNews(InputStream is)
	{
		
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxparser = factory.newSAXParser();
			//XMLReader reader = saxparser.getXMLReader();
			//reader.setContentHandler(new NewsHandler());
			
			saxparser.parse(is, myhandler);
			System.out.println("here");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("啥也没有");
			
		}
		
		
		
		return list;
			
				
	}
	
	class NewsHandler extends DefaultHandler
	{

		@Override
		public void startDocument() throws SAXException {
			System.out.println("startDoc");
			
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("endDoc");
				return;
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			System.out.println("startEle----------<"+qName+">");
			if(qName.equals("channel"))
			{
				list = new ArrayList<Newsinfo>();
			}else if(qName.equals("title")&&REC == 1){
				CURRENT = TITLE;
			}else if(qName.equals("link")&&REC == 1){
				CURRENT = LINK;
			}else if(qName.equals("pubDate")){
				CURRENT = PUBDATE;
			}else if(qName.equals("author")){
				CURRENT = AUTHOR;
			}else if(qName.equals("description")&&REC == 1){
				CURRENT = DESCRIPTION;
			}else if(qName.equals("item")){
				REC = 1;
				info = new Newsinfo();
			}
			
			
			
			//super.startElement(uri, localName, qName, attributes);
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			System.out.println("endEle----------<"+qName+">");
			 if(qName.equals("title")&&REC == 1){
				CURRENT = 0;
			}else if(qName.equals("link")&&REC == 1){
				CURRENT = 0;
			}else if(qName.equals("pubDate")){
				CURRENT = 0;
			}else if(qName.equals("author")){
				CURRENT = 0;
			}else if(qName.equals("description")&&REC == 1){
				CURRENT = 0;
			}else if(qName.equals("item")){
				list.add(info);
			}
			
			
		//	super.endElement(uri, localName, qName);
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			
			String theString = new String(ch, start, length);
			System.out.println("characters--------<"+theString+">");
			if(CURRENT==TITLE&&REC==1)
			{
				info.setTitle(theString);
				
			}else if(CURRENT==LINK){
				info.setLink(theString);
			}else if(CURRENT==PUBDATE){
				info.setPubDate(theString);
			}else if(CURRENT==AUTHOR){
				info.setAuthor(theString);
			}else if(CURRENT==DESCRIPTION){
				info.setDescription(theString);
			}
			
				
		}
	}
			//super.characters(ch, start, length);
		
	
	


	
}
	
	