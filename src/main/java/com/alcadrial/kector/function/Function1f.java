package com.alcadrial.kector.function;

import java.util.List;
import java.util.function.Function;

public interface Function1f extends Function<Float, Float> {
	
	static ConstantFunction1f ofZero()
	{
		return ConstantFunction1f.ZERO_FUNCTION;
	}
	
	static LinearFunction1f ofIdentity()
	{
		return LinearFunction1f.IDENTITY_FUNCTION;
	}
	
	static ConstantFunction1f ofConstant(float constant)
	{
		if (constant == 0) return ofZero();
		return new ConstantFunction1f(constant);
	}
	
	static LinearFunction1f ofLinear(float m)
	{
		if (m == 0) return LinearFunction1f.ZERO_FUNCTION;
		return new LinearFunction1f(m);
	}
	
	static AdditionFunction1f ofAddition(List<Function1f> functions)
	{
		return new AdditionFunction1f(functions);
	}
	
	static AdditionFunction1f ofAddition(Function1f... functions)
	{
		return new AdditionFunction1f(functions);
	}
	
	static PowerFunction1f ofPower(float power)
	{
		return new PowerFunction1f(power);
	}
	
	static PowerFunction1f ofPower(float a, float power)
	{
		return new PowerFunction1f(a, power);
	}
	
	@Override
	Float apply(Float x);
	
	Function1f devirate();
	
	boolean isZero();
}
