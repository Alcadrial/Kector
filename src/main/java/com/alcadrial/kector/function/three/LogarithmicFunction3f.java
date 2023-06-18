package com.alcadrial.kector.function.three;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function3f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(\vec{x})=log_{\vec{b}}(\vec{x})" alt="f(\vec{x})=log_{\vec{b}}(\vec{x})"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{b}" alt="\vec{b}"/> is the base;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public class LogarithmicFunction3f implements Function3f {
	
	static final LogarithmicFunction3f LN_FUNCTION = new LogarithmicFunction3f(Vector3f.of(Math.EF, Math.EF, Math.EF)) {
		
		@Override
		public Vector3f apply(Vector3f x)
		{
			return Math.log(x);
		}
		
		@Override
		public Function3f derivateX()
		{
			return INVERSE_LN_FUNCTION;
		}
		
		@Override
		public Function3f derivateY()
		{
			return INVERSE_LN_FUNCTION;
		}
		
		@Override
		public Function3f derivateZ()
		{
			return INVERSE_LN_FUNCTION;
		}
	};
	static final MonomialFunction3f INVERSE_LN_FUNCTION = Function3f.ofMonomial(Vector3f.of(-1, -1, -1));
	
	private Vector3f base;
	private Vector3f correction;
	
	LogarithmicFunction3f(Vector3f base)
	{
		this.base = base;
		correction = Math.log(base);
	}
	
	@Override
	public Vector3f apply(Vector3f x)
	{
		return Math.log(x).multiply(correction);
	}
	
	@Override
	public Function3f derivateX()
	{
		return Function3f.ofMonomial(correction, Vector3f.of(-1, -1, -1));
	}
	
	@Override
	public Function3f derivateY()
	{
		return Function3f.ofMonomial(correction, Vector3f.of(-1, -1, -1));
	}
	
	@Override
	public Function3f derivateZ()
	{
		return Function3f.ofMonomial(correction, Vector3f.of(-1, -1, -1));
	}
	
	@Override
	public boolean isZero()
	{
		return false;
	}
	
	public Vector3f getBase()
	{
		return base;
	}
}
