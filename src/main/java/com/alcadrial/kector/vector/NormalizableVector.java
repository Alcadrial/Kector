package com.alcadrial.kector.vector;

import com.alcadrial.kector.annotation.Unitary;

public interface NormalizableVector<V> {
	
	@Unitary V unitary();
	
	default @Unitary V normalize()
	{
		return unitary();
	}
}
