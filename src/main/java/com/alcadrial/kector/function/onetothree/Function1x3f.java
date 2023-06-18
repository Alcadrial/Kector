package com.alcadrial.kector.function.onetothree;

import com.alcadrial.kector.function.MathFunction;
import com.alcadrial.kector.function.one.Function1f;
import com.alcadrial.kector.function.three.Function3f;
import com.alcadrial.kector.vector.Vector3f;

public interface Function1x3f extends MathFunction<Float, Vector3f> {
	
	static ConstantFunction1x3f ofZero()
	{
		return ConstantFunction1x3f.ZERO_FUNCTION;
	}
	
	static LinearFunction1x3f ofToVector()
	{
		return LinearFunction1x3f.TO_VECTOR_FUNCTION;
	}
	
	static ConstantFunction1x3f ofConstant(Vector3f constant)
	{
		if (constant.equals(Vector3f.origin())) return ConstantFunction1x3f.ZERO_FUNCTION;
		return new ConstantFunction1x3f(constant);
	}
	
	static LinearFunction1x3f ofLinear(Vector3f m)
	{
		if (m.equals(Vector3f.origin())) return LinearFunction1x3f.ZERO_FUNCTION;
		if (m.equals(Vector3f.of(1, 1, 1))) return LinearFunction1x3f.TO_VECTOR_FUNCTION;
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
	
	static MultiplicationFunction1x3f ofMultiplication(Function1x3f function0, Function1f function1)
	{
		return ofMultiplication(function0, ofFunction(ofToVector(), function1));
	}
	
	static MonomialFunction1x3f ofMonomial(float grade)
	{
		return new MonomialFunction1x3f(grade);
	}
	
	static MonomialFunction1x3f ofMonomial(Vector3f a, float grade)
	{
		return new MonomialFunction1x3f(a, grade);
	}
	
	static Function1x3f ofFunction(Function1x3f outer, Function1f inner)
	{
		return new FunctionOfFunction1x3fOf1f1x3f(outer, inner);
	}
	
	static Function1x3f ofFunction(Function3f outer, Function1x3f inner)
	{
		return new FunctionOfFunction1x3fOf1x3f3f(outer, inner);
	}
	
	@Override
	Vector3f apply(Float x);
	
	Function1x3f devirate();
}
