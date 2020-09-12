package com.spring.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Board {
	private int bno;
	private String title;
	private String writer;
	private String content;
	private int hit;
	private String regdate;
	private String updatedate;
}
