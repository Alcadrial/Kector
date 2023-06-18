package com.alcadrial.kector.function.onetothree;

import com.alcadrial.kector.function.MathFunction;
import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function1x3f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=f_0(f_1(x))" alt="f(x)=f_0(f_1(x))"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?f_0" alt="f_0"/> is a function;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?f_1" alt="f_1"/> is a function;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public interface FunctionOfFunction1x3f<INNER> extends Function1x3f {
	
	MathFunction<INNER, Vector3f> getOuterFunction();
	MathFunction<Float, INNER> getInnerFunction();
}
