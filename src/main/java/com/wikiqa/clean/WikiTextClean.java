package com.wikiqa.clean;

import java.io.IOException;

import org.wikiclean.WikiClean;
import org.wikiclean.WikiCleanBuilder;
import org.wikiclean.WikipediaBz2DumpInputStream;

public class WikiTextClean {
	
	public static void main(String[] args){
		String bzfilePath="/home/chong/data/zhwiki/zhwiki-20150109-pages-articles.xml.bz2";
		try {
			WikipediaBz2DumpInputStream  inputReader=new WikipediaBz2DumpInputStream(bzfilePath);
			WikiCleanBuilder cleaner=new WikiCleanBuilder();
			WikiClean clean=cleaner.withTitle(true).withLanguage(WikiClean.WikiLanguage.ZH).build();
			String raw;
			while((raw=inputReader.readNext())!=null){
				String cleanText = clean.clean(raw);
				System.out.println(cleanText);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
