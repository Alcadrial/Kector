package com.alcadrial.kector.matrix;

import com.alcadrial.kector.AngleUnit;
import com.alcadrial.kector.Math;
import com.alcadrial.kector.annotation.Angle;
import com.alcadrial.kector.shape.OrthoShape;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.Vector4f;
import com.alcadrial.kector.vector.Vector4fr;
import com.alcadrial.kector.vector.axis.Axisf;

public class Matrix4f {
	
	public static final Matrix4f IDENTITY = IdentityMatrix4f.IDENTITY;
	protected float[] values;
	
	/**
	 * Initialize to identity.
	 */
	public Matrix4f()
	{
		values = new float[16];
		for (int i = 0; i < 4; i++) values[i * 5] = 1;
	}
	
	/**
	 * Create a copy of the sample.
	 * 
	 * @param sample to copy from
	 */
	public Matrix4f(Matrix4f sample)
	{
		this(sample.values);
	}
	
	/**
	 * Create a matrix using the given values.
	 * 
	 * @param values used to initialize this matrix
	 */
	public Matrix4f(float[] values)
	{
		this.values = new float[16];
		System.arraycopy(values, 0, this.values, 0, 16);
	}
	
	/**
	 * Reset to identity.
	 * 
	 * @return itself
	 */
	public Matrix4f identity()
	{
		for (int i = 0; i < 16; i++) values[i] = i % 5 == 0 ? 1 : 0;
		return this;
	}
	
	public Matrix4f set(int i, int j, float value)
	{
		values[i * 4 + j] = value;
		return this;
	}
	
	public float get(int i, int j)
	{
		return values[i * 4 + j];
	}
	
	/**
	 * Reset to an orthographic matrix of a box
	 * starting from (0; 0; 0) to (width; height; 100),
	 * centered in (width/2; height/2; 50).
	 * 
	 * @param width of the box
	 * @param height of the box
	 * 
	 * @return itself
	 */
	public Matrix4f orthographicPositive(float width, float height)
	{
		identity();
		set(0, 0, 2 / width);
		set(1, 1, 2 / height);
		set(2, 2, -0.02F);
		set(0, 3, -1);
		set(1, 3, -1);
		set(2, 3, 1);
		return this;
	}
	
	/**
	 * Reset to an orthographic matrix of a box
	 * starting from (-width/2; -height/2; 0) to (width/2; height/2; 100),
	 * centered in the origin.
	 * 
	 * @param width of the box
	 * @param height of the box
	 * 
	 * @return itself
	 */
	public Matrix4f orthographic(float width, float height)
	{
		identity();
		set(0, 0, 2 / width);
		set(1, 1, 2 / height);
		set(2, 2, -0.02F);
		set(2, 3, 1);
		return this;
	}
	
	/**
	 * Reset to an orthographic matrix of a box
	 * starting from (-width/2; -height/2; -length/2) to (width/2; height/2; length/2),
	 * centered in the origin.
	 * 
	 * @param width of the box
	 * @param height of the box
	 * @param length of the box
	 * 
	 * @return itself
	 */
	public Matrix4f orthographic(float width, float height, float length)
	{
		identity();
		set(0, 0, 2 / width);
		set(1, 1, 2 / height);
		set(2, 2, -2 / length);
		return this;
	}
	
	/**
	 * Reset to an orthographic matrix of the box,
	 * centered in the box center.
	 * 
	 * @param boxShape the box
	 * 
	 * @return itself
	 */
	public Matrix4f orthographic(OrthoShape boxShape)
	{
		identity();
		Vector3fr start = boxShape.getStart();
		Vector3fr end = boxShape.getEnd();
		set(0, 0, 2 / (end.x() - start.x()));
		set(1, 1, 2 / (end.y() - start.y()));
		set(2, 2, -2 / (end.z() - start.z()));
		set(0, 3, -(end.x() + start.x()) / (end.x() - start.x()));
		set(1, 3, -(end.y() + start.y()) / (end.y() - start.y()));
		set(2, 3, (end.z() + start.z()) / (end.z() - start.z()));
		return this;
	}
	
	/**
	 * Reset to an orthographic matrix of a box
	 * starting from (-width/2; -height/2; -1) to (width/2; height/2; 1).
	 * 
	 * @param width of the box
	 * @param height of the box
	 * 
	 * @return itself
	 */
	public Matrix4f plane(float width, float height)
	{
		identity();
		set(0, 0, 2 / width);
		set(1, 1, 2 / height);
		set(2, 2, -1);
		return this;
	}
	
	/**
	 * Reset to an orthographic matrix of a box
	 * starting from (-width/2; -height/2; -1) to (width/2; height/2; 1),
	 * translated by centerPos.
	 * 
	 * @param width of the box
	 * @param height of the box
	 * @param centerPos position of the center
	 * 
	 * @return itself
	 */
	public Matrix4f cursor(float width, float height, Vector2fr centerPos)
	{
		return cursor(width, height, centerPos.x(), centerPos.y());
	}
	
	/**
	 * Reset to an orthographic matrix of a box
	 * starting from (-width/2; -height/2; -1) to (width/2; height/2; 1),
	 * translated by (centerX; centerY).
	 * 
	 * @param width of the box
	 * @param height of the box
	 * @param centerX x position of the center
	 * @param centerY y position of the center
	 * 
	 * @return itself
	 */
	public Matrix4f cursor(float width, float height, float centerX, float centerY)
	{
		identity();
		set(0, 0, 2 / width);
		set(1, 1, 2 / height);
		set(0, 3, -get(0, 0) * centerX);
		set(1, 3, -get(1, 1) * centerY);
		set(2, 2, -1);
		return this;
	}
	
	/**
	 * Reset to a projection matrix of a box to a frustum
	 * starting from (-1; -1; -1) to (1; 1; 1).
	 * 
	 * @param fieldOfView
	 * @param maxDistance of view
	 * @param aspectRatio width / height
	 * 
	 * @return itself
	 */
	public Matrix4f project(@Angle(AngleUnit.RADIANS) float fieldOfView, float maxDistance, float minDistance, float aspectRatio)
	{
		identity();
		float scale = Math.tan(fieldOfView / 2);
		float frustum = maxDistance - minDistance;
		set(0, 0, 1 / scale);
		set(1, 1, aspectRatio / scale);
		set(2, 2, -(maxDistance + minDistance) / frustum);
		set(3, 2, -1);
		set(2, 3, -2 * maxDistance * minDistance / frustum);
		set(3, 3, 0);
		return this;
	}
	
	/**
	 * Reset to a projection matrix of a box to a frustum
	 * starting from (-1; -1; 0) to (1; 1; 1).
	 * 
	 * @param fieldOfView
	 * @param maxDistance of view
	 * @param aspectRatio width / height
	 * 
	 * @return itself
	 */
	public Matrix4f projectPositiveZ(@Angle(AngleUnit.RADIANS) float fieldOfView, float maxDistance, float minDistance, float aspectRatio)
	{
		identity();
		float scale = Math.tan(fieldOfView / 2);
		float frustum = maxDistance - minDistance;
		set(0, 0, 1 / scale);
		set(1, 1, aspectRatio / scale);
		set(2, 2, -(maxDistance) / frustum);
		set(3, 2, -1);
		set(2, 3, -maxDistance * minDistance / frustum);
		set(3, 3, 0);
		return this;
	}
	
	/**
	 * Reset to a view (first person) matrix centered in position.
	 * 
	 * @param position position
	 * @param rotationX X axis rotation
	 * @param rotationY Y axis rotation
	 * 
	 * @return itself
	 */
	public Matrix4f view(Vector3fr position, float rotationX, float rotationY)
	{
		identity();
		view(rotationX, rotationY);
		return multiply(new Matrix4f()
			.translateX(-position.x())
			.translateY(-position.y())
			.translateZ(-position.z())
		);
	}
	
	/**
	 * Reset to a view matrix.
	 * 
	 * @param rotationX X axis rotation
	 * @param rotationY Y axis rotation
	 * 
	 * @return itself
	 */
	public Matrix4f view(@Angle(AngleUnit.RADIANS) float rotationX, @Angle(AngleUnit.RADIANS) float rotationY)
	{
		rotateX(rotationX);
		return multiply(new Matrix4f().rotateY(rotationY));
	}
	
	/**
	 * Reset scale
	 * 
	 * @param vector holding every axis scale value
	 * 
	 * @return itself
	 */
	public Matrix4f scale(Vector3fr vector)
	{
		set(0, 0, vector.x());
		set(1, 1, vector.y());
		set(2, 2, vector.z());
		return this;
	}
	
	/**
	 * Apply a scale
	 * 
	 * @param vector holding every axis scale value
	 * 
	 * @return itself
	 */
	public Matrix4f scaleRelative(Vector3fr vector)
	{
		set(0, 0, get(0, 0) * vector.x());
		set(1, 1, get(1, 1) * vector.y());
		set(2, 2, get(2, 2) * vector.z());
		return this;
	}
	
	/**
	 * Reset translation
	 * 
	 * @param vector holding every axis translation value
	 * 
	 * @return itself
	 */
	public Matrix4f translateTo(Vector3fr vector)
	{
		set(0, 3, vector.x());
		set(1, 3, vector.y());
		set(2, 3, vector.z());
		return this;
	}
	
	/**
	 * Reset translation
	 * 
	 * @param vector holding every axis translation value
	 * 
	 * @return itself
	 */
	public Matrix4f translateTo(Vector3ir vector)
	{
		set(0, 3, vector.x());
		set(1, 3, vector.y());
		set(2, 3, vector.z());
		return this;
	}
	
	/**
	 * Reset X axis translation
	 * 
	 * @param x translation value
	 * 
	 * @return itself
	 */
	public Matrix4f translateXTo(float x)
	{
		set(0, 3, x);
		return this;
	}
	
	/**
	 * Reset Y axis translation
	 * 
	 * @param y translation value
	 * 
	 * @return itself
	 */
	public Matrix4f translateYTo(float y)
	{
		set(1, 3, y);
		return this;
	}
	
	/**
	 * Reset Z axis translation
	 * 
	 * @param z translation value
	 * 
	 * @return itself
	 */
	public Matrix4f translateZTo(float z)
	{
		set(2, 3, z);
		return this;
	}
	
	/**
	 * Apply a translation by the X axis
	 * 
	 * @param x translation value
	 * 
	 * @return itself
	 */
	public Matrix4f translateX(float x)
	{
		set(0, 3, get(0, 3) + x);
		return this;
	}
	
	/**
	 * Apply a translation by the Y axis
	 * 
	 * @param y translation value
	 * 
	 * @return itself
	 */
	public Matrix4f translateY(float y)
	{
		set(1, 3, get(1, 3) + y);
		return this;
	}
	
	/**
	 * Apply a translation by the Z axis
	 * 
	 * @param z translation value
	 * 
	 * @return itself
	 */
	public Matrix4f translateZ(float z)
	{
		set(2, 3, get(2, 3) + z);
		return this;
	}
	
	/**
	 * Apply a translation
	 * 
	 * @param vector holding every axis translation value
	 * 
	 * @return itself
	 */
	public Matrix4f translate(Vector3fr vector)
	{
		set(0, 3, get(0, 3) + vector.x());
		set(1, 3, get(1, 3) + vector.y());
		set(2, 3, get(2, 3) + vector.z());
		return this;
	}
	
	/**
	 * Apply a translation
	 * 
	 * @param vector holding every axis translation value
	 * 
	 * @return itself
	 */
	
	public Matrix4f translate(Vector3ir vector)
	{
		set(0, 3, get(0, 3) + vector.x());
		set(1, 3, get(1, 3) + vector.y());
		set(2, 3, get(2, 3) + vector.z());
		return this;
	}
	
	/**
	 * Reset rotation around {@link Axisf#X}
	 * 
	 * @param angle rotation value
	 * 
	 * @return itself
	 */
	public Matrix4f rotateX(@Angle(AngleUnit.RADIANS) float angle)
	{
		float cos = Math.cos(angle);
		float sin = Math.sin(angle);
		set(1, 1, cos);
		set(1, 2, -sin);
		set(2, 1, sin);
		set(2, 2, cos);
		return this;
	}
	
	/**
	 * Reset rotation around {@link Axisf#Y}
	 * 
	 * @param angle rotation value
	 * 
	 * @return itself
	 */
	public Matrix4f rotateY(@Angle(AngleUnit.RADIANS) float angle)
	{
		float cos = Math.cos(angle);
		float sin = Math.sin(angle);
		set(0, 0, cos);
		set(0, 2, sin);
		set(2, 0, -sin);
		set(2, 2, cos);
		return this;
	}
	
	/**
	 * Reset rotation around {@link Axisf#Z}
	 * 
	 * @param angle rotation value
	 * 
	 * @return itself
	 */
	public Matrix4f rotateZ(@Angle(AngleUnit.RADIANS) float angle)
	{
		float cos = Math.cos(angle);
		float sin = Math.sin(angle);
		set(0, 0, cos);
		set(0, 1, -sin);
		set(1, 0, sin);
		set(1, 1, cos);
		return this;
	}
	
	/**
	 * Reset rotation around {@link Axisf#X} of angleX, then around {@link Axisf#Y} of angleY
	 * 
	 * @param angleX rotation value
	 * @param angleY rotation value
	 * 
	 * @return itself
	 */
	public Matrix4f rotateXY(@Angle(AngleUnit.RADIANS) float angleX, @Angle(AngleUnit.RADIANS) float angleY)
	{
		float xCos = Math.cos(angleX);
		float xSin = Math.sin(angleX);
		float yCos = Math.cos(angleY);
		float ySin = Math.sin(angleY);
		set(0, 0, yCos);
		set(0, 2, ySin);
		set(1, 0, xSin * ySin);
		set(1, 1, xCos);
		set(1, 2, -xSin * yCos);
		set(2, 0, -xCos * ySin);
		set(2, 1, xSin);
		set(2, 2, xCos * yCos);
		return this;
	}
	
	/**
	 * Apply the given matrix on this
	 * 
	 * @param other matrix
	 * 
	 * @return itself
	 */
	public Matrix4f multiply(Matrix4f other)
	{
		float[] self = new float[16];
		System.arraycopy(values, 0, self, 0, 16);
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				float sum = 0;
				for (int k = 0; k < 4; k++) sum += self[i * 4 + k] * other.get(k, j);
				set(i, j, sum);
			}
		}
		return this;
	}
	
	/**
	 * Apply this matrix over the vector
	 * 
	 * @param vector
	 * 
	 * @return a newly instanced transformed vector
	 */
	public Vector4f multiply(Vector4fr vector)
	{
		float x = vector.x();
		float y = vector.y();
		float z = vector.z();
		float w = vector.w();
		float X = x * get(0, 0) + y * get(0, 1) + z * get(0, 2) + w * get(0, 3);
		float Y = x * get(1, 0) + y * get(1, 1) + z * get(1, 2) + w * get(1, 3);
		float Z = x * get(2, 0) + y * get(2, 1) + z * get(2, 2) + w * get(2, 3);
		float W = x * get(3, 0) + y * get(3, 1) + z * get(3, 2) + w * get(3, 3);
		return Vector4f.of(X, Y, Z, W);
	}
	
	/**
	 * Calculate this matrix determinant
	 * 
	 * @return this matrix determinant
	 */
	public float determinant()
	{
		float determinant = 0;
		determinant += get(0, 0) * (get(1, 1) * (get(2, 2) * get(3, 3) - get(2, 3) * get(3, 2)) - get(1, 2) * (get(2, 1) * get(3, 3) - get(2, 3) * get(3, 1)) + get(1, 3) * (get(2, 1) * get(3, 2) - get(2, 2) * get(3, 1)));
		determinant -= get(0, 1) * (get(1, 0) * (get(2, 2) * get(3, 3) - get(2, 3) * get(3, 2)) - get(1, 2) * (get(2, 0) * get(3, 3) - get(2, 3) * get(3, 0)) + get(1, 3) * (get(2, 0) * get(3, 2) - get(2, 2) * get(3, 0)));
		determinant += get(0, 2) * (get(1, 0) * (get(2, 1) * get(3, 3) - get(2, 3) * get(3, 1)) - get(1, 1) * (get(2, 0) * get(3, 3) - get(2, 3) * get(3, 0)) + get(1, 3) * (get(2, 0) * get(3, 1) - get(2, 1) * get(3, 0)));
		determinant -= get(0, 3) * (get(1, 0) * (get(2, 1) * get(3, 2) - get(2, 2) * get(3, 1)) - get(1, 1) * (get(2, 0) * get(3, 2) - get(2, 2) * get(3, 0)) + get(1, 2) * (get(2, 0) * get(3, 1) - get(2, 1) * get(3, 0)));
		return determinant;
	}
	
	/**
	 * Transpose this matrix
	 * 
	 * @return itself
	 */
	public Matrix4f transpose()
	{
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				float d = get(i, j);
				set(i, j, get(j, i));
				set(j, i, d);
			}
		}
		return this;
	}
	
	/**
	 * Calculate this matrix inverse.
	 * 
	 * @return this matrix inverse in a new instance
	 * @throws ArithmeticException if this matrix has no inverse or if it's determinant is zero
	 */
	public Matrix4f inverse()
	{
		if (Float.isNaN(1 / determinant())) throw new ArithmeticException("divide by zero");
		float[][] matrixBlock = new float[4][8];
		
		for (int j = 0; j < 4; j++)
		{
			for (int i = 0; i < 4; i++) matrixBlock[j][i] = get(j, i);
			for (int i = 0; i < 4; i++) matrixBlock[j][4 + i] = j == i ? 1 : 0;
		}
		for (int j = 0; j < 4; j++)
		{
			for (int i = 0; i < 4; i++)
			{
				if (i != j)
				{
					if (matrixBlock[i][j] != 0)
					{
						float k = matrixBlock[i][j] / matrixBlock[j][j];
						for (int o = 0; o < 8; o++) matrixBlock[i][o] -= matrixBlock[j][o] * k;
					}
				}
				else if (matrixBlock[i][j] != 1)
				{
					if (matrixBlock[i][j] != 0)
					{
						float k = 1 / matrixBlock[i][j];
						for (int o = 0; o < 8; o++) matrixBlock[i][o] *= k;
					}
					else
					{
						int r = i;
						
						for (int o = 0; o < 4; o++)
						{
							if (matrixBlock[o][j] != 0)
							{
								r = o;
								break;
							}
						}
						
						float[] c = matrixBlock[i];
						matrixBlock[r] = matrixBlock[i];
						matrixBlock[i] = c;
					}
				}
			}
		}
		
		Matrix4f matrix = new Matrix4f();
		for (int i = 0; i < 4; i++) for (int j = 0; j < 4; j++) matrix.set(i, j, matrixBlock[i][4 + j]);
		return matrix;
	}
	
	public float[] toArray()
	{
		return values;
	}
	
	public float[] toTransposedArray()
	{
		return new float[] {
			get(0, 0), get(1, 0), get(2, 0), get(3, 0),
			get(0, 1), get(1, 1), get(2, 1), get(3, 1),
			get(0, 2), get(1, 2), get(2, 2), get(3, 2),
			get(0, 3), get(1, 3), get(2, 3), get(3, 3)
		};
	}
	
	@Override
	public String toString()
	{
		StringBuilder ss = new StringBuilder(16 * 6 + 10);
		ss.append("Matrix{");
		for (int i = 0; i < 4; i++)
		{
			ss.append("[");
			for (int j = 0; j < 4; j++) ss.append(get(i, j)).append(", ");
			ss.setCharAt(ss.length() - 2, ']');
			ss.setCharAt(ss.length() - 1, ',');
			ss.append(" ");
		}
		ss.setCharAt(ss.length() - 2, '}');
		return ss.substring(0, ss.length() - 1);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj instanceof Matrix4f m)
		{
			for (int i = 0; i < 4; i++) for (int j = 0; j < 4; j++)
			{
				if (!Math.looseEquals(get(i, j), m.get(i, j))) return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Gets an already instanced unmodifiable identity matrix.
	 * 
	 * @return an immutable identity matrix
	 */
	public static Matrix4f getIdentity()
	{
		return IDENTITY;
	}
}
