package com.alcadra.math.vector.complex;

import com.alcadra.math.vector.Vector2f;
import com.alcadra.math.vector.Vector3f;
import com.alcadra.math.vector.Vector4f;

public interface IQuaternion {
	
	IQuaternion multiply(IQuaternion quaternion);
	IQuaternion conjugate();
	
	Vector3f rotate(Vector2f vector);
	Vector3f rotate(Vector3f vector);
	
	float r();
	float i();
	float j();
	float k();
	
	Vector4f rijk();
	Vector4f xyzw();
}
