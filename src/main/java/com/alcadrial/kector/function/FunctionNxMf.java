package com.alcadrial.kector.function;

import java.util.function.Function;

public interface FunctionNxMf<IN, OUT> extends Function<IN, OUT> {
	
	@Override
	OUT apply(IN x);
	
	FunctionNxMf<IN, OUT> devirate();
}
