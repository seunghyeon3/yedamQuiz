package com.yedam.quiz.comm;

public class StringUtil {
	
	public static String abbr(String text) {
		return abbr(text, 10);
	}
	
	public static String abbr(String text, int size) {
		if (text==null) {
			return "";
		}
		String tagRemove = text.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
		tagRemove = tagRemove.substring(0, tagRemove.length()<size?tagRemove.length():size );
		return tagRemove;
	}
}
