package com.spring.pro29.ex03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleVO {
	private int articleNO;
	private String writer;
	private String title;
	private String content;
	
	@Override
	public String toString() {
		String info = "";
		info += "\n"+articleNO+"\n"
		        +writer+"\n"
		        +title+"\n"
		        +content;
		return info;
	}
}
