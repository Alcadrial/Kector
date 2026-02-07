package com.alcadrial.kector.matrix;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.annotation.Angle;
import com.alcadrial.kector.shape.OrthoShape;
import com.alcadrial.kector.vector.Vector2f;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3i;
import com.alcadrial.kector.vector.Vector4f;
import com.alcadrial.kector.vector.axis.Axis;

public class Matrix4f {
	
	public static final Matrix4f IDENTITY = IdentityMatrix4f.IDENTITY;
	protected float[][] values;
	
	/**
	 * Initialize to identity.
	 */
	public Matrix4f()
	{
		values = new float[4][4];
		for (int i = 0; i < 4; i++) values[i][i] = 1;
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
	public Matrix4f(float[][] values)
	{
		this.values = new float[4][4];
		for (int i = 0; i < values.length; i++) System.arraycopy(values[i], 0, this.values[i], 0, values.length);
	}
	
	/**
	 * Reset to identity.
	 * 
	 * @return itself
	 */
	public Matrix4f identity()
	{
		values[0] = new float[] {1, 0, 0, 0};
		values[1] = new float[] {0, 1, 0, 0};
		values[2] = new float[] {0, 0, 1, 0};
		values[3] = new float[] {0, 0, 0, 1};
		return this;
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
		values[0][0] = 2 / width;
		values[1][1] = 2 / height;
		values[2][2] = -0.02F;
		values[0][3] = -1;
		values[1][3] = -1;
		values[2][3] = 0.9999F;
		return this;
	}
	
	/**
	 * Reset to an orthographic matrix of a box
	 * starting from (-width/2; -height/2; -0) to (width/2; height/2; 100),
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
		values[0][0] = 2 / width;
		values[1][1] = 2 / height;
		values[2][2] = -0.02F;
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
		values[0][0] = 2 / width;
		values[1][1] = 2 / height;
		values[2][2] = -2 / length;
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
		Vector3f start = boxShape.getStart();
		Vector3f end = boxShape.getEnd();
		values[0][0] = 2 / (end.x() - start.x());
		values[1][1] = 2 / (end.y() - start.y());
		values[2][2] = -2 / (end.z() - start.z());
		values[0][3] = -(end.x() + start.x()) / (end.x() - start.x());
		values[1][3] = -(end.y() + start.y()) / (end.y() - start.y());
		values[2][3] = -(end.z() + start.z()) / (end.z() - start.z());
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
		values[0][0] = 2 / width;
		values[1][1] = 2 / height;
		return this;
	}
	
	/**
	 * Reset to an orthographic matrix of a box
	 * starting from (-width/2; -height/2; -1) to (width/2; height/2; 1),
	 * centered in pos.
	 * 
	 * @param width of the box
	 * @param height of the box
	 * @param centerPos position of the center
	 * 
	 * @return itself
	 */
	public Matrix4f cursor(float width, float height, Vector2f centerPos)
	{
		return cursor(width, height, centerPos.x(), centerPos.y());
	}
	
	/**
	 * Reset to an orthographic matrix of a box
	 * starting from (-width/2; -height/2; -1) to (width/2; height/2; 1),
	 * centered in pos.
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
		values[0][0] = 2 / width;
		values[1][1] = 2 / height;
		values[0][3] = values[0][0] * centerX - 1;
		values[1][3] = values[1][1] * centerY - 1;
		values[2][3] = -1;
		return this;
	}
	
	/**
	 * Reset to a projection matrix of a box to a frustum
	 * starting from (-1; -1; -1) to (1; 1; 1).
	 * 
	 * @param fieldOfView fov in degrees
	 * @param maxDistance of view
	 * @param aspectRatio width / height
	 * 
	 * @return itself
	 */
	public Matrix4f project(@Angle(AngleUnit.RADIANS) float fieldOfView, float maxDistance, float minDistance, float aspectRatio)
	{
		identity();
		return project0(fieldOfView, maxDistance, minDistance, aspectRatio);
	}
	
	private Matrix4f project0(@Angle(AngleUnit.RADIANS) float fieldOfView, float maxDistance, float minDistance, float aspectRatio)
	{
		float scale = 1 / Math.tan(fieldOfView / 2);
		float frustum = maxDistance - minDistance;
		values[0][0] = scale / aspectRatio;
		values[1][1] = scale;
		values[2][2] = -(maxDistance + minDistance) / frustum;
		values[3][2] = -1;
		values[2][3] = -maxDistance * minDistance * 2 / frustum;
		return this;
	}
	
	/**
	 * Reset to a view (first person) matrix centered in position.
	 * 
	 * @param position position
	 * @param rotationX X axis rotation in degrees
	 * @param rotationY Y axis rotation in degrees
	 * 
	 * @return itself
	 */
	public Matrix4f view(Vector3f position, float rotationX, float rotationY)
	{
		identity();
		view(rotationX, rotationY);
		return multiply(new Matrix4f().translate(Vector3f.copyOf(position).opposite()));
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
	public Matrix4f scale(Vector3f vector)
	{
		values[0][0] = vector.x();
		values[1][1] = vector.y();
		values[2][2] = vector.z();
		return this;
	}
	
	/**
	 * Apply a scale
	 * 
	 * @param vector holding every axis scale value
	 * 
	 * @return itself
	 */
	public Matrix4f scaleRelative(Vector3f vector)
	{
		values[0][0] *= vector.x();
		values[1][1] *= vector.y();
		values[2][2] *= vector.z();
		return this;
	}
	
	/**
	 * Reset translation
	 * 
	 * @param vector holding every axis translation value
	 * 
	 * @return itself
	 */
	public Matrix4f translateTo(Vector3f vector)
	{
		values[0][3] = vector.x();
		values[1][3] = vector.y();
		values[2][3] = vector.z();
		return this;
	}
	
	/**
	 * Reset translation
	 * 
	 * @param vector holding every axis translation value
	 * 
	 * @return itself
	 */
	public Matrix4f translateTo(Vector3i vector)
	{
		values[0][3] = vector.x();
		values[1][3] = vector.y();
		values[2][3] = vector.z();
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
		values[0][3] = x;
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
		values[1][3] = y;
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
		values[2][3] = z;
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
		values[0][3] += x;
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
		values[1][3] += y;
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
		values[2][3] += z;
		return this;
	}
	
	/**
	 * Apply a translation
	 * 
	 * @param vector holding every axis translation value
	 * 
	 * @return itself
	 */
	public Matrix4f translate(Vector3f vector)
	{
		values[0][3] += vector.x();
		values[1][3] += vector.y();
		values[2][3] += vector.z();
		return this;
	}
	
	/**
	 * Apply a translation
	 * 
	 * @param vector holding every axis translation value
	 * 
	 * @return itself
	 */
	
	public Matrix4f translate(Vector3i vector)
	{
		values[0][3] += vector.x();
		values[1][3] += vector.y();
		values[2][3] += vector.z();
		return this;
	}
	
	/**
	 * Reset rotation around {@link Axis#X}
	 * 
	 * @param angle rotation value
	 * 
	 * @return itself
	 */
	public Matrix4f rotateX(@Angle(AngleUnit.RADIANS) float angle)
	{
		float cos = Math.cos(angle);
		float sin = Math.sin(angle);
		values[1][1] = cos;
		values[1][2] = -sin;
		values[2][1] = sin;
		values[2][2] = cos;
		return this;
	}
	
	/**
	 * Reset rotation around {@link Axis#Y}
	 * 
	 * @param angle rotation value
	 * 
	 * @return itself
	 */
	public Matrix4f rotateY(@Angle(AngleUnit.RADIANS) float angle)
	{
		float cos = Math.cos(angle);
		float sin = Math.sin(angle);
		values[0][0] = cos;
		values[0][2] = sin;
		values[2][0] = -sin;
		values[2][2] = cos;
		return this;
	}
	
	/**
	 * Reset rotation around {@link Axis#Z}
	 * 
	 * @param angle rotation value
	 * 
	 * @return itself
	 */
	public Matrix4f rotateZ(@Angle(AngleUnit.RADIANS) float angle)
	{
		float cos = Math.cos(angle);
		float sin = Math.sin(angle);
		values[0][0] = cos;
		values[0][1] = -sin;
		values[1][0] = sin;
		values[1][1] = cos;
		return this;
	}
	
	/**
	 * Reset rotation around {@link Axis#X} of angleX, then around {@link Axis#Y} of angleY
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
		values[0][0] = yCos;
		values[0][2] = ySin;
		values[1][0] = xSin * ySin;
		values[1][1] = xCos;
		values[1][2] = -xSin * yCos;
		values[2][0] = -xCos * ySin;
		values[2][1] = xSin;
		values[2][2] = xCos * yCos;
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
		float[][] self = new float[4][];
		for (int i = 0; i < 4; i++) System.arraycopy(values[i], 0, self[i] = new float[4], 0, 4);
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				float sum = 0;
				for (int k = 0; k < 4; k++) sum += self[i][k] * other.values[k][j];
				values[i][j] = sum;
			}
		}
		return this;
	}
	
	/**
	 * Apply this matrix over the vector
	 * 
	 * @param vector
	 * 
	 * @return a newly instanced trasformed vector
	 */
	public Vector4f multiply(Vector4f vector)
	{
		float x = vector.x();
		float y = vector.y();
		float z = vector.z();
		float w = vector.w();
		float X = x * values[0][0] + y * values[0][1] + z * values[0][2] + w * values[0][3];
		float Y = x * values[1][0] + y * values[1][1] + z * values[1][2] + w * values[1][3];
		float Z = x * values[2][0] + y * values[2][1] + z * values[2][2] + w * values[2][3];
		float W = x * values[3][0] + y * values[3][1] + z * values[3][2] + w * values[3][3];
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
		determinant += values[0][0] * (values[1][1] * (values[2][2] * values[3][3] - values[2][3] * values[3][2]) - values[1][2] * (values[2][1] * values[3][3] - values[2][3] * values[3][1]) + values[1][3] * (values[2][1] * values[3][2] - values[2][2] * values[3][1]));
		determinant -= values[0][1] * (values[1][0] * (values[2][2] * values[3][3] - values[2][3] * values[3][2]) - values[1][2] * (values[2][0] * values[3][3] - values[2][3] * values[3][0]) + values[1][3] * (values[2][0] * values[3][2] - values[2][2] * values[3][0]));
		determinant += values[0][2] * (values[1][0] * (values[2][1] * values[3][3] - values[2][3] * values[3][1]) - values[1][1] * (values[2][0] * values[3][3] - values[2][3] * values[3][0]) + values[1][3] * (values[2][0] * values[3][1] - values[2][1] * values[3][0]));
		determinant -= values[0][3] * (values[1][0] * (values[2][1] * values[3][2] - values[2][2] * values[3][1]) - values[1][1] * (values[2][0] * values[3][2] - values[2][2] * values[3][0]) + values[1][2] * (values[2][0] * values[3][1] - values[2][1] * values[3][0]));
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
				float d = values[i][j];
				values[i][j] = values[j][i];
				values[j][i] = d;
			}
		}
		return this;
	}
	
	/**
	 * Calculate this matrix inverse.
	 * 
	 * @return this matrix inverse
	 * @throws ArithmeticException if this matrix has no inverse or if it's determinant is zero
	 */
	public Matrix4f inverse()
	{
		if (Float.isNaN(1 / determinant())) throw new ArithmeticException("divide by zero");
		float[][] matrixBlock = new float[4][8];
		
		for (int j = 0; j < 4; j++)
		{
			for (int i = 0; i < 4; i++) matrixBlock[j][i] = values[j][i];
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
		for (int i = 0; i < 4; i++) for (int j = 0; j < 4; j++) matrix.values[i][j] = matrixBlock[i][4 + j];
		return matrix;
	}
	
	public float[] toArray()
	{
		return new float[] {
			values[0][0], values[0][1], values[0][2], values[0][3],
			values[1][0], values[1][1], values[1][2], values[1][3],
			values[2][0], values[2][1], values[2][2], values[2][3],
			values[3][0], values[3][1], values[3][2], values[3][3]
		};
	}
	
	public float[] toTransposedArray()
	{
		return new float[] {
			values[0][0], values[1][0], values[2][0], values[3][0],
			values[0][1], values[1][1], values[2][1], values[3][1],
			values[0][2], values[1][2], values[2][2], values[3][2],
			values[0][3], values[1][3], values[2][3], values[3][3]
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
			for (int j = 0; j < 4; j++) ss.append(values[i][j]).append(", ");
			ss.setCharAt(ss.length() - 2, ']');
			ss.setCharAt(ss.length() - 1, ',');
			ss.append(" ");
		}
		ss.setCharAt(ss.length() - 2, '}');
		return ss.substring(0, ss.length() - 1);
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
