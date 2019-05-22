package com.bp.baseProject.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface UserTypeAnnotation {
	
	String value() default "";

}
