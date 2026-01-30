package com.alcadrial.kector.shape.utils;

import java.util.Iterator;
import java.util.function.Function;

public class FixedSizeIterator<E> implements Iterator<E> {
	
	private int size;
	private int index;
	private Function<Integer, E> builder;
	
	public static <E> Iterator<E> of(int size, Function<Integer, E> builder)
	{
		return new FixedSizeIterator<>(size, builder);
	}
	
	private FixedSizeIterator(int size, Function<Integer, E> builder)
	{
		this.size = size;
		this.builder = builder;
	}
	
	@Override
	public boolean hasNext()
	{
		return index < size;
	}
	
	@Override
	public E next()
	{
		return builder.apply(index++);
	}
}
