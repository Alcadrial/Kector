package com.alcadrial.kector.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation used in a method returning an Iterable<T> to indicate that objects returned by
 * the next() call are temporary and their may expire after the next call to next(),
 * as such a copy must be done in order to store its value for future computations.
 */
@Retention(SOURCE)
@Target({METHOD})
public @interface Temporary {
	
}
