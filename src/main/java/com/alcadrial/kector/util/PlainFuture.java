package com.alcadrial.kector.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

public class PlainFuture<V> implements Future<V> {
	
	private Supplier<V> resultSupplier;
	private V result;
	
	public PlainFuture(Runnable resultSupplier)
	{
		this.resultSupplier = () -> {
			resultSupplier.run();
			return null;
		};
	}
	
	public PlainFuture(Supplier<V> resultSupplier)
	{
		this.resultSupplier = resultSupplier;
	}
	
	@Override
	public boolean cancel(boolean mayInterruptIfRunning)
	{
		return false;
	}
	
	@Override
	public boolean isCancelled()
	{
		return false;
	}
	
	@Override
	public boolean isDone()
	{
		return result != null;
	}
	
	@Override
	public V get() throws InterruptedException, ExecutionException
	{
		if (!isDone()) result = resultSupplier.get();
		return result;
	}
	
	@Override
	public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException
	{
		if (!isDone())
		{
			Thread t = new Thread(() -> {
				result = resultSupplier.get();
			}, "Future executor");
			t.setDaemon(true);
			t.start();
			t.join(unit.toMillis(timeout));
			if (!isDone()) throw new TimeoutException();
		}
		return result;
	}
}
