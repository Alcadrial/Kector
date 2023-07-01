package com.alcadrial.kector.function.one;

class FunctionOfFunction1fOf1f1f implements FunctionOfFunction1f<Float> {
	
	private Function1f outer;
	private Function1f inner;
	
	FunctionOfFunction1fOf1f1f(Function1f outer, Function1f inner)
	{
		this.outer = outer;
		this.inner = inner;
	}
	
	@Override
	public Float apply(Float x)
	{
		return outer.apply(inner.apply(x));
	}
	
	@Override
	public MultiplicationFunction1f derivate()
	{
		return Function1f.ofMultiplication(Function1f.ofFunction(outer.derivate(), inner), inner.derivate());
	}
	
	@Override
	public Function1f getOuterFunction()
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
