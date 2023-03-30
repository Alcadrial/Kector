package com.alcadra.math.vector;

public interface NormalizableVector<V> {
	
	V unitary();
	
	default V normalize()
	{
		return unitary();
	}
}
