package com.alcadra.math.matrix;

import com.alcadra.math.Math;
import com.alcadra.math.angle.Angle;
import com.alcadra.math.angle.AngleUnit;
import com.alcadra.math.shape.OrthoShape;
import com.alcadra.math.vector.Vector2f;
import com.alcadra.math.vector.Vector3f;
import com.alcadra.math.vector.Vector3i;
import com.alcadra.math.vector.Vector4f;
import com.alcadra.math.vector.axis.Axis;

public class Matrix4f {
	
	private static final Matrix4f VIEW_REFINER_MATRIX_0 = new Matrix4f().translate(Vector3f.of(0, 0, -2));
	private static final Matrix4f VIEW_REFINER_MATRIX_1 = new Matrix4f().rotate(Axis.Y, 180);
	public static final Matrix4f IDENTITY = IdentityMatrix4f.IDENTITY;
	protected float[][] values;
	
	/**
	 * Initialize to identity
	 */
	public Matrix4f()
	{
		values = new float[4][4];
		for (int i = 0; i < 4; i++) values[i][i] = 1;
	}
	
	/**
	 * Create a copy of the sample
	 * 
	 * @param sample to copy from
	 */
	public Matrix4f(Matrix4f sample)
	{
		values = new float[4][4];
		for (int i = 0; i < values.length; i++) System.arraycopy(sample.values[i], 0, values[i], 0, sample.values.length);
	}
	
	/**
	 * Reset to identity
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
	 * centered in (width/2; height/2; 50)
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
	 * centered in the origin
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
	 * centered in the origin
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
	 * centered in the box center
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
	 * starting from (-width/2; -height/2; -1) to (width/2; height/2; 1),
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
	 * centered in pos
	 * 
	 * @param width of the box
	 * @param height of the box
	 * @param mousePos position of the center
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
	 * centered in pos
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
	 * starting from (-1; -1; -1) to (1; 1; 1)
	 * 
	 * @param fieldOfView fov in degrees
	 * @param maxDistance of view
	 * @param aspectRatio width / height
	 * 
	 * @return itself
	 */
	public Matrix4f project(float fieldOfView, float maxDistance, float minDistance, float aspectRatio)
	{
		identity();
		return project0((float) AngleUnit.RADIANS.fromDegrees(fieldOfView), maxDistance, minDistance, aspectRatio);
	}
	
	/**
	 * Reset to a projection matrix of a box to a frustum
	 * starting from (-1; -1; -1) to (1; 1; 1)
	 * 
	 * @param fieldOfView fov
	 * @param maxDistance of view
	 * @param aspectRatio width / height
	 * 
	 * @return itself
	 */
	public Matrix4f project(Angle fieldOfView, float maxDistance, float minDistance, float aspectRatio)
	{
		identity();
		return project0(fieldOfView.asFloat(AngleUnit.RADIANS), maxDistance, minDistance, aspectRatio);
	}
	
	private Matrix4f project0(float fieldOfViewRads, float maxDistance, float minDistance, float aspectRatio)
	{
		float scale = 1 / Math.tan(fieldOfViewRads / 2);
		float frustum = maxDistance - minDistance;
		values[0][0] = scale * aspectRatio;
		values[1][1] = scale;
		values[2][2] = -(maxDistance + minDistance) / frustum;
		values[2][3] = -1;
		values[3][2] = -maxDistance * minDistance * 2 / frustum;
		return this;
	}
	
	/**
	 * Reset to a view (first person) matrix centered in position
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
		rawView(rotationX, rotationY);
		return multiply(new Matrix4f().translate(Vector3f.copyOf(position).opposite()));
	}
	
	/**
	 * Reset to a view (first person) matrix centered in position
	 * 
	 * @param position position
	 * @param rotationX X axis rotation
	 * @param rotationY Y axis rotation
	 * 
	 * @return itself
	 */
	public Matrix4f view(Vector3f position, Angle rotationX, Angle rotationY)
	{
		identity();
		rawView(rotationX, rotationY);
		return translate(Vector3f.copyOf(position).opposite());
	}
	
	/**
	 * Reset to a view (third person) matrix centered in position
	 * 
	 * @param position position
	 * @param rotationX X axis rotation in degrees
	 * @param rotationY Y axis rotation in degrees
	 * 
	 * @return itself
	 */
	public Matrix4f awayView(Vector3f position, float rotationX, float rotationY)
	{
		identity();
		translate(Vector3f.copyOf(position).opposite());
		rawView(rotationX, rotationY);
		return multiply(VIEW_REFINER_MATRIX_0);
	}
	
	/**
	 * Reset to a view (third person) matrix centered in position
	 * 
	 * @param position position
	 * @param rotationX X axis rotation
	 * @param rotationY Y axis rotation
	 * 
	 * @return itself
	 */
	public Matrix4f awayView(Vector3f position, Angle rotationX, Angle rotationY)
	{
		identity();
		translate(Vector3f.copyOf(position).opposite());
		rawView(rotationX, rotationY);
		return multiply(VIEW_REFINER_MATRIX_0);
	}
	
	/**
	 * Reset to a view (third person) matrix centered in position with an inverted view
	 * 
	 * @param position position
	 * @param rotationX X axis rotation in degrees
	 * @param rotationY Y axis rotation in degrees
	 * 
	 * @return itself
	 */
	public Matrix4f invertedAwayView(Vector3f position, float rotationX, float rotationY)
	{
		identity();
		translate(Vector3f.copyOf(position).opposite());
		rawView(rotationX, rotationY);
		multiply(VIEW_REFINER_MATRIX_1);
		return multiply(VIEW_REFINER_MATRIX_0);
	}
	
	/**
	 * Reset to a view (third person) matrix centered in position with an inverted view
	 * 
	 * @param position position
	 * @param rotationX X axis rotation
	 * @param rotationY Y axis rotation
	 * 
	 * @return itself
	 */
	public Matrix4f invertedAwayView(Vector3f position, Angle rotationX, Angle rotationY)
	{
		identity();
		translate(Vector3f.copyOf(position).opposite());
		rawView(rotationX, rotationY);
		multiply(VIEW_REFINER_MATRIX_1);
		return multiply(VIEW_REFINER_MATRIX_0);
	}
	
	/**
	 * Reset to a view (first person) matrix
	 * 
	 * @param rotationX X axis rotation in degrees
	 * @param rotationY Y axis rotation in degrees
	 * 
	 * @return itself
	 */
	public Matrix4f rawView(float rotationX, float rotationY)
	{
		rotate(Axis.X, rotationX);
		return multiply(new Matrix4f().rotate(Axis.Y, rotationY));
	}
	
	/**
	 * Reset to a view (first person) matrix
	 * 
	 * @param rotationX X axis rotation
	 * @param rotationY Y axis rotation
	 * 
	 * @return itself
	 */
	public Matrix4f rawView(Angle rotationX, Angle rotationY)
	{
		rotate(Axis.X, rotationX);
		return multiply(new Matrix4f().rotate(Axis.Y, rotationY));
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
	 * Reset rotation
	 * 
	 * @param axis rotation axis, must be orthogonal to X, Y or Z
	 * @param angle rotation value degrees
	 * 
	 * @return itself
	 */
	public Matrix4f rotate(Axis axis, float angle)
	{
		float r = (float) AngleUnit.RADIANS.fromDegrees(angle);
		float cos = Math.cos(r);
		float sin = Math.sin(r);
		float coss = 1 - cos;
		float x = axis.x();
		float y = axis.y();
		float z = axis.z();
		float xCoss = x * coss;
		float yCoss = y * coss;
		float zCoss = z * coss;
		float xSin = x * sin;
		float ySin = y * sin;
		float zSin = z * sin;
		values[0][0] = x * xCoss + cos;
		values[0][1] = x * yCoss - zSin;
		values[0][2] = x * zCoss + ySin;
		values[1][0] = y * xCoss + zSin;
		values[1][1] = y * yCoss + cos;
		values[1][2] = y * zCoss - xSin;
		values[2][0] = z * xCoss - ySin;
		values[2][1] = z * yCoss + xSin;
		values[2][2] = z * zCoss + cos;
		return this;
	}
	
	/**
	 * Reset rotation
	 * 
	 * @param axis rotation axis, must be orthogonal to X, Y or Z
	 * @param angle rotation value degrees
	 * 
	 * @return itself
	 */
	public Matrix4f rotate(Axis axis, Angle angle)
	{
		float r = angle.asFloat(AngleUnit.RADIANS);
		float cos = Math.cos(r);
		float sin = Math.sin(r);
		float coss = 1 - cos;
		float x = axis.x();
		float y = axis.y();
		float z = axis.z();
		float xCoss = x * coss;
		float yCoss = y * coss;
		float zCoss = z * coss;
		float xSin = x * sin;
		float ySin = y * sin;
		float zSin = z * sin;
		values[0][0] = x * xCoss + cos;
		values[0][1] = x * yCoss - zSin;
		values[0][2] = x * zCoss + ySin;
		values[1][0] = y * xCoss + zSin;
		values[1][1] = y * yCoss + cos;
		values[1][2] = y * zCoss - xSin;
		values[2][0] = z * xCoss - ySin;
		values[2][1] = z * yCoss + xSin;
		values[2][2] = z * zCoss + cos;
		return this;
	}
	
	/**
	 * Apply the other matrix on this
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
	 * @return the trasformed vector
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
	 * Calculate this matrix inverse
	 * 
	 * @return this matrix inverse
	 */
	public Matrix4f inverse()
	{
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
						
						for (int o = 0; o < 8; o++)
						{
							float c = matrixBlock[i][o];
							matrixBlock[r][o] = matrixBlock[i][o];
							matrixBlock[i][o] = c;
						}
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
		return new float[] {values[0][0], values[0][1], values[0][2], values[0][3], values[1][0], values[1][1], values[1][2], values[1][3], values[2][0], values[2][1], values[2][2], values[2][3], values[3][0], values[3][1], values[3][2], values[3][3]};
	}
	
	@Override
	public String toString()
	{
		String s = "Matrix{";
		for (int i = 0; i < 4; i++)
		{
			s += "[";
			for (int j = 0; j < 4; j++) s += values[i][j] + ", ";
			s = s.substring(0, s.length() - 2) + "], ";
		}
		return s.substring(0, s.length() - 2) + "}";
	}
	
	/**
	 * Get an already instanced unmodifiable identity matrix
	 * 
	 * @return
	 */
	public static Matrix4f getIdentity()
	{
		return IDENTITY;
	}
}
