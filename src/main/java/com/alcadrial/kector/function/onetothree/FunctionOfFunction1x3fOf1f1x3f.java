package com.alcadrial.kector.function.onetothree;

import com.alcadrial.kector.function.one.Function1f;
import com.alcadrial.kector.vector.Vector3f;

class FunctionOfFunction1x3fOf1f1x3f implements FunctionOfFunction1x3f<Float> {
	
	private Function1x3f outer;
	private Function1f inner;
	
	FunctionOfFunction1x3fOf1f1x3f(Function1x3f outer, Function1f inner)
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
		return Function1x3f.ofMultiplication(Function1x3f.ofFunction(outer.devirate(), inner), inner.derivate());
	}
	
	@Override
	public Function1x3f getOuterFunction()
	{
		return outer;
	}
	
	@Override
	public Function1f getInnerFunction()
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
