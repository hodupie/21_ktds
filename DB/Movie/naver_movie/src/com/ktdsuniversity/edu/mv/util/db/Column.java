package com.ktdsuniversity.edu.mv.util.db;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Column {

	/**
	 * 컬럼명
	 * @return
	 */
	String value() default "_DUMMY_";
	
	boolean isRequire() default false;
	
	/**
	 * List Generic 클래스
	 * @return
	 */
	Class<? extends Object> cls() default Object.class;
	
}
