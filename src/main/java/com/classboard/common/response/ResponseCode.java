package com.classboard.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * lulumedic
 * 코드 정의
 * @author Jayden
 * @since 2022.01.09
 */
@AllArgsConstructor
@Getter
public enum ResponseCode {
	ERROR("ERROR"),
	SUCCESS("SUCCESS"),

	TRUE("true"), //toast grid 데이터조회 성공시 반환값 
	;

	private final String code;
}
