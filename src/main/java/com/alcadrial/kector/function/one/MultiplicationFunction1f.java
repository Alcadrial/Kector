package com.alcadrial.kector.function.one;

import com.alcadrial.kector.util.StringUtils;

/**
 * <p>A {@link Function1f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=f_0(x)\times f_1(x)" alt="f(x)=f_0(x)\times f_1(x)"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?f_0" alt="f_0"/> is a function;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?f_1" alt="f_0"/> is a function;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public class MultiplicationFunction1f implements Function1f {
	
	private Function1f f0;
	private Function1f f1;
	
	MultiplicationFunction1f(Function1f function0, Function1f function1)
	{
		f0 = function0;
		f1 = function1;
	}
	
	@Override
	public Float apply(Float x)
	{
		return f0.apply(x) * f1.apply(x);
	}
	
	@Override
	public AdditionFunction1f devirate()
	{
		Function1f fd0 = f0.devirate();
		Function1f fd1 = f1.devirate();
		if (fd0.isZero())
		{
			if (fd1.isZero()) return Function1f.ofAdditionZeroZero();
			return Function1f.ofAdditionZero(fd1);
		}
		if (fd1.isZero()) return Function1f.ofAdditionZero(fd0);
		return Function1f.ofAddition(Function1f.ofMultiplication(fd0, f1), Function1f.ofMultiplication(f0, fd1));
	}
	
	public Function1f getFunction0()
	{
		return f0;
	}
	
	public Function1f getFunction1()
	{
		return f1;
	}
	
	@Override
	public boolean isZero()
	{
		return f0.isZero() || f1.isZero();
	}
	
	@Override
	public String toString()
	{
		String s = f0.toString();
		if (s.equals("0")) return "0";
		String s0 = f1.toString();
		if (s.equals("1")) return s0;
		if (s.equals("-1") ^ s0.startsWith("-")) return "-" + s0;
		if (s0.equals("0")) return "0";
		if (s0.equals("1") || s0.equals("-1")) return s;
		return StringUtils.multiplicationBounds(s) + "*" + StringUtils.multiplicationBounds(s0);
	}
}
