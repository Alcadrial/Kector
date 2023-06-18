package com.alcadrial.kector.function;

import java.util.function.Function;

public interface MathFunction<IN, OUT> extends Function<IN, OUT> {
	
	@Override
	OUT apply(IN x);
	
	boolean isZero();
}
