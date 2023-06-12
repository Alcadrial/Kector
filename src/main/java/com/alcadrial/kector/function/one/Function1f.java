package com.alcadrial.kector.function.one;

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
		if (constant == 0) return ConstantFunction1f.ZERO_FUNCTION;
		return new ConstantFunction1f(constant);
	}
	
	static LinearFunction1f ofLinear(float m)
	{
		if (m == 0) return LinearFunction1f.ZERO_FUNCTION;
		if (m == 1) return LinearFunction1f.IDENTITY_FUNCTION;
		return new LinearFunction1f(m);
	}
	
	static AdditionFunction1f ofAddition(Function1f function0, Function1f function1)
	{
		return new AdditionFunction1f(function0, function1);
	}
	
	static MultiplicationFunction1f ofMultiplication(Function1f function0, Function1f function1)
	{
		return new MultiplicationFunction1f(function0, function1);
	}
	
	static PowerFunction1f ofPower(float power)
	{
		return new PowerFunction1f(power);
	}
	
	static PowerFunction1f ofPower(float a, float power)
	{
		return new PowerFunction1f(a, power);
	}
	
	static ExponentialFunction1f ofExponential()
	{
		return ExponentialFunction1f.EXPONENTIAL_FUNCTION;
	}
	
	static ExponentialFunction1f ofExponential(float base)
	{
		return new ExponentialFunction1f(base);
	}
	
	static CoefficientExponentialFunction1f ofExponential(float a, float base)
	{
		return new CoefficientExponentialFunction1f(a, base);
	}
	
	static LogarithmicFunction1f ofLn()
	{
		return LogarithmicFunction1f.LN_FUNCTION;
	}
	
	static LogarithmicFunction1f ofLog(float base)
	{
		return new LogarithmicFunction1f(base);
	}
	
	@Override
	Float apply(Float x);
	
	Function1f devirate();
	
	boolean isZero();
}
