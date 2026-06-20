package com.alcadrial.kector.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.RECORD_COMPONENT;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.alcadrial.kector.AngleUnit;

@Retention(SOURCE)
@Target({FIELD, METHOD, PARAMETER, LOCAL_VARIABLE, ANNOTATION_TYPE, TYPE_PARAMETER, TYPE_USE, RECORD_COMPONENT})
public @interface Angle {
	
	AngleUnit value() default AngleUnit.RADIANS;
}
