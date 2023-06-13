package com.alcadrial.kector.function.one;

import com.alcadrial.kector.function.FunctionNxMf;

/**
 * <p>A {@link Function1f} <img src="http://latex.codecogs.com/png.latex?f" /> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=f_0(f_1(x))" /></blockquote>
 * <p>where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?f_0" /> is a function;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?f_1" /> is a function;</li>
 * </p>
 * 
 * @author Alcadrial
 */
public interface FunctionOfFunction1f<INNER> extends Function1f {
	
	FunctionNxMf<Float, INNER> getOuterFunction();
	FunctionNxMf<INNER, Float> getInnerFunction();
}
