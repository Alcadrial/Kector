package com.alcadrial.kector.function.three;

import java.util.function.Function;

import com.alcadrial.kector.vector.Vector3f;

public interface Function3f extends Function<Vector3f, Vector3f> {
	
	static ConstantFunction3f ofZero()
	{
		return ConstantFunction3f.ZERO_FUNCTION;
	}
	
	static LinearFunction3f ofIdentity()
	{
		return LinearFunction3f.IDENTITY_FUNCTION;
	}
	
	static ConstantFunction3f ofConstant(Vector3f constant)
	{
		if (constant.equals(Vector3f.origin())) return ConstantFunction3f.ZERO_FUNCTION;
		return new ConstantFunction3f(constant);
	}
	
	static LinearFunction3f ofLinear(Vector3f m)
	{
		if (m.equals(Vector3f.origin())) return LinearFunction3f.ZERO_FUNCTION;
		if (m.equals(Vector3f.of(1, 1, 1))) return LinearFunction3f.IDENTITY_FUNCTION;
		return new LinearFunction3f(m);
	}
	
	static AdditionFunction3f ofAddition(Function3f function0, Function3f function1)
	{
		return new AdditionFunction3f(function0, function1);
	}
	
	static MultiplicationFunction3f ofMultiplication(Function3f function0, Function3f function1)
	{
		return new MultiplicationFunction3f(function0, function1);
	}
	
	static PowerFunction3f ofPower(Vector3f power)
	{
		return new PowerFunction3f(power);
	}
	
	static PowerFunction3f ofPower(Vector3f a, Vector3f power)
	{
		return new PowerFunction3f(a, power);
	}
	
	static ExponentialFunction3f ofExponential()
	{
		return ExponentialFunction3f.EXPONENTIAL_FUNCTION;
	}
	
	static ExponentialFunction3f ofExponential(Vector3f base)
	{
		return new ExponentialFunction3f(base);
	}
	
	static CoefficientExponentialFunction3f ofExponential(Vector3f a, Vector3f base)
	{
		return new CoefficientExponentialFunction3f(a, base);
	}
	
	static LogarithmicFunction3f ofLn()
	{
		return LogarithmicFunction3f.LN_FUNCTION;
	}
	
	static LogarithmicFunction3f ofLog(Vector3f base)
	{
		return new LogarithmicFunction3f(base);
	}
	
	@Override
	Vector3f apply(Vector3f x);
	
	Function3f devirate();
	
	boolean isZero();
}
