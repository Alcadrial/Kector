package com.alcadrial.kector.vector;

public interface NormalizableVector<V> {
	
	V unitary();
	
	default V normalize()
	{
		return unitary();
	}
}
