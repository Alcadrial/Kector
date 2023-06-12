package com.alcadrial.kector.function.onetothree;

import java.util.function.Function;

import com.alcadrial.kector.vector.Vector3f;

public interface Function1x3f extends Function<Float, Vector3f> {
	
	static ConstantFunction1x3f ofZero()
	{
		return ConstantFunction1x3f.ZERO_FUNCTION;
	}
	
	static LinearFunction1x3f ofIdentity()
	{
		return LinearFunction1x3f.IDENTITY_FUNCTION;
	}
	
	static ConstantFunction1x3f ofConstant(Vector3f constant)
	{
		if (constant.equals(Vector3f.origin())) return ConstantFunction1x3f.ZERO_FUNCTION;
		return new ConstantFunction1x3f(constant);
	}
	
	static LinearFunction1x3f ofLinear(Vector3f m)
	{
		if (m.equals(Vector3f.origin())) return LinearFunction1x3f.ZERO_FUNCTION;
		if (m.equals(Vector3f.of(1, 1, 1))) return LinearFunction1x3f.IDENTITY_FUNCTION;
		return new LinearFunction1x3f(m);
	}
	
	static AdditionFunction1x3f ofAddition(Function1x3f function0, Function1x3f function1)
	{
		return new AdditionFunction1x3f(function0, function1);
	}
	
	static MultiplicationFunction1x3f ofMultiplication(Function1x3f function0, Function1x3f function1)
	{
		return new MultiplicationFunction1x3f(function0, function1);
	}
	
	static PowerFunction1x3f ofPower(float power)
	{
		return new PowerFunction1x3f(power);
	}
	
	static PowerFunction1x3f ofPower(Vector3f a, float power)
	{
		return new PowerFunction1x3f(a, power);
	}
	
	@Override
	Vector3f apply(Float x);
	
	Function1x3f devirate();
	
	boolean isZero();
}
