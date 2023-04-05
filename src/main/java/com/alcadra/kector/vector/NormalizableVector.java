package com.alcadra.kector.vector;

public interface NormalizableVector<V> {
	
	V unitary();
	
	default V normalize()
	{
		return unitary();
	}
}
