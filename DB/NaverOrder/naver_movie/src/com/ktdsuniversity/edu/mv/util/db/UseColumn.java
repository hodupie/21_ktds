package com.ktdsuniversity.edu.mv.util.db;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface UseColumn {

	/**
	 * 키 컬럼 변수명
	 * @return
	 */
	String keyVarName() default "";
	/**
	 * 키 컬럼명
	 * @return
	 */
	String keyColum() default "";
	
	/**
	 * 키 컬럼 변수 타입
	 * @return
	 */
	Class<?> keyType() default Object.class;
	
}
