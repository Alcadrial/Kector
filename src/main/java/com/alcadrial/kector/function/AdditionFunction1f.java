package com.alcadrial.kector.function;

import java.util.List;

/**
 * <p>A {@link Function1f} <i>f</i> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=mx" /></blockquote>
 * <p>where <i>m</i> is the angular coefficient of the line.</p>
 * @author Alcadrial
 */
public class AdditionFunction1f implements Function1f {
	
	private List<Function1f> functions;
	
	AdditionFunction1f(Function1f... functions)
	{
		this(List.of(functions));
	}
	
	AdditionFunction1f(List<Function1f> functions)
	{
		this.functions = functions.parallelStream().filter(f -> !f.isZero()).toList();
	}
	
	private AdditionFunction1f(List<Function1f> functions, boolean placeholder)
	{
		this.functions = functions;
	}
	
	@Override
	public Float apply(Float x)
	{
		return functions.parallelStream().collect(() -> new float[1], (v, f) -> v[0] += f.apply(x), (v, w) -> v[0] += w[0])[0];
	}
	
	@Override
	public AdditionFunction1f devirate()
	{
		return new AdditionFunction1f(functions.parallelStream().map(Function1f::devirate).filter(f -> !f.isZero()).toList(), true);
	}
	
	@Override
	public boolean isZero()
	{
		return functions.size() == 0;
	}
}
