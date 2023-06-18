package com.alcadrial.kector.function.threetoone;

import com.alcadrial.kector.function.MathFunction;
import com.alcadrial.kector.function.three.Function3f;
import com.alcadrial.kector.function.three.GradientFunction3f;
import com.alcadrial.kector.vector.Vector3f;

public interface Function3x1f extends MathFunction<Vector3f, Float> {
	
	@Override
	Float apply(Vector3f x);
	
	Function3x1f derivateX();
	Function3x1f derivateY();
	Function3x1f derivateZ();
	
	default GradientFunction3f gradient()
	{
		return Function3f.ofGradient(this);
	}
}
