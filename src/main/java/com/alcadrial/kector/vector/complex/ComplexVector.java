package com.alcadrial.kector.vector.complex;

import com.alcadrial.kector.vector.Vector2f;

public interface ComplexVector extends Vector2f, Complex {
	
	@Override
	ComplexVector conjugate();
}
