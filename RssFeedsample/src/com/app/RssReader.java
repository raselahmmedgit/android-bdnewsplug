package com.app;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class RssReader {

	private String rssUrl;
	
	public RssReader(String rssUrl){
		this.rssUrl = rssUrl;
	}
	
	public List<RssFeedModel> GetItems() throws Exception
	{
		SAXParserFactory sAXParserFactory = SAXParserFactory.newInstance();
		SAXParser sAXParser = sAXParserFactory.newSAXParser();
		
		RssFeedParseHandler rssFeedParseHandler = new RssFeedParseHandler();
		sAXParser.parse(rssUrl, rssFeedParseHandler);
		
		return rssFeedParseHandler.GetItems();
	}
	
}
