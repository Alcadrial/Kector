package com.alcadrial.kector.function.onetothree;

import com.alcadrial.kector.function.three.Function3f;
import com.alcadrial.kector.vector.Vector3f;

class FunctionOfFunction1x3fOf1x3f3f implements FunctionOfFunction1x3f<Vector3f> {
	
	private Function3f outer;
	private Function1x3f inner;
	
	FunctionOfFunction1x3fOf1x3f3f(Function3f outer, Function1x3f inner)
	{
		this.outer = outer;
		this.inner = inner;
	}
	
	@Override
	public Vector3f apply(Float x)
	{
		return outer.apply(inner.apply(x));
	}
	
	@Override
	public MultiplicationFunction1x3f devirate()
	{
		//return Function1x3f.ofMultiplication(Function1x3f.ofFunction(outer.derivate(), inner), inner.devirate());
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Function3f getOuterFunction()
	{
		return outer;
	}
	
	@Override
	public Function1x3f getInnerFunction()
	{
		return inner;
	}
	
	@Override
	public boolean isZero()
	{
		return inner.isZero();
	}
	
	@Override
	public String toString()
	{
		if (outer.isZero()) return "0";
		String s = outer.toString();
		String s0 = inner.toString();
		int x = s.indexOf("x");
		return s.substring(0, x) + "(" + s0 + ")" + s.substring(x + 1);
	}
}
