package com.spring.pro29.ex01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	
	@Override
	public String toString() {
		String info = id+", "+pwd+", "+name+", "+email;
		return info;
	}
}
