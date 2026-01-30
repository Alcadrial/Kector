package com.alcadrial.kector.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation used to indicate an internal object that is shared outside
 * without creating a defensive copy for performance and should be treated as read-only.
 */
@Retention(SOURCE)
@Target({METHOD, PARAMETER})
public @interface SharedInstance {
	
}
