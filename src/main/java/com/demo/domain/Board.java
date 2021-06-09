package com.demo.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString(exclude = "userName")
@EqualsAndHashCode(of="boardNo")
@Data //@ToString, @Getter, @Setter, @EqualsAndHashCode, @RequireArgsConstructor ÇÕÄ£°Í
public class Board {

	private int boardNo;
	@NonNull
	private String title;
	private String content;
	private String writer;
	private LocalDateTime regDate;
	
	
	public static void main(String[] args) {
		Board board = new Board();
		System.out.println(board);

	}

}
