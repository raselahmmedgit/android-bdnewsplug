package com.app;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class RssFeedParseHandler extends DefaultHandler {
	
	//RssFeedModel List
	private List<RssFeedModel> rssFeedModelList;
	
	Boolean currentElement = false;
    String currentValue = "";
	
	//Used to reference item while parsing
	private RssFeedModel currentRssFeedModel;
    
	/**
	//RssFeedModel List
	private List<RssFeedModel> rssFeedModelList;
	
	//Used to reference item while parsing
	private RssFeedModel currentRssFeedModel;
	
	//Parsing title indicator
	private boolean parsingTitle;
	
	//Parsing link indicator
	private boolean parsingLink;
	**/
	
	
	public RssFeedParseHandler()
	{
		rssFeedModelList = new ArrayList<RssFeedModel>();
	}
	
	public List<RssFeedModel> GetItems()
	{
		return rssFeedModelList;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes)
	throws SAXException{
		// TODO Auto-generated method stub
		//super.startElement(uri, localName, qName, attributes);
		
		/**
		if("content-item".equals(qName))
		{
			currentRssFeedModel = new RssFeedModel();
		}
		else if("title".equals(qName))
		{
			parsingTitle = true;
		}
		else if("url".equals(qName))
		{
			parsingLink = true;
		}
		**/
		
		currentElement = true;
        currentValue = "";

        if (localName.equals("item"))
        {
        	currentRssFeedModel = new RssFeedModel();
        }
		
	}

	@Override
	public void endElement(String uri, String localName, String qName)
	throws SAXException{
		// TODO Auto-generated method stub
		//super.endElement(uri, localName, qName);
		
		/**
		if("content-item".equals(qName))
		{
			currentRssFeedModel = null;
		}
		else if("title".equals(qName))
		{
			parsingTitle = false;
		}
		else if("url".equals(qName))
		{
			parsingLink = false;
		}
		**/
		
		currentElement = false;

        if (localName.equals("title")) 
        {
        	
        	currentRssFeedModel.setTitle(currentValue);
        	
        }
        else if (localName.equals("description"))
        {
        	
        	currentRssFeedModel.setDescription(currentValue);
        	
        }
        else if (localName.equals("pubDate")) 
        {
        	
        	currentRssFeedModel.setPubDate(currentValue);
        	
        }
        else if (localName.equals("link"))
        {
        	
        	currentRssFeedModel.setLink(currentValue);
        	
        }
        else if (localName.equals("item")) 
        {
        	
        	rssFeedModelList.add(currentRssFeedModel);
        	
        }
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
	throws SAXException{
		// TODO Auto-generated method stub
		//super.characters(ch, start, length);
		
		/**
		if(parsingTitle)
		{
			if(currentRssFeedModel != null)
			{
				currentRssFeedModel.setTitle(new String(ch, start, length));
			}
		}
		else if(parsingLink)
		{
			if(currentRssFeedModel != null)
			{
				currentRssFeedModel.setLink(new String(ch, start, length));
				parsingLink = false;
			}
			
		}
		
		rssFeedModelList.add(currentRssFeedModel);
		**/
		
		if (currentElement) 
        {
            currentValue = currentValue + new String(ch, start, length);
        }
		
	}
	
}
