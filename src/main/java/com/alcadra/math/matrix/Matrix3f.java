package com.alcadra.math.matrix;

public class Matrix3f {
	
	private float[][] values = new float[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
	
	/**
	 * Initialize to identity
	 */
	public Matrix3f()
	{}
	
	/**
	 * Create a copy of the sample
	 * 
	 * @param sample to copy from
	 */
	public Matrix3f(Matrix3f sample)
	{
		for (int i = 0; i < values.length; i++) System.arraycopy(sample.values[i], 0, values[i], 0, sample.values.length);
	}
	
	/**
	 * Reset to identity
	 * 
	 * @return itself
	 */
	public Matrix3f identity()
	{
		values[0] = new float[] {1, 0, 0};
		values[1] = new float[] {0, 1, 0};
		values[2] = new float[] {0, 0, 1};
		return this;
	}
	
	public float[] toArray()
	{
		float[] array = new float[values.length * values.length];
		for (int i = 0; i < values.length; i++) System.arraycopy(values[i], i * values.length, array[i], i * values.length, values.length);
		return array;
	}
}
