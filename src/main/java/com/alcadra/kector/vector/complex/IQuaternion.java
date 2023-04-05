package com.alcadra.kector.vector.complex;

import com.alcadra.kector.vector.Vector2f;
import com.alcadra.kector.vector.Vector3f;
import com.alcadra.kector.vector.Vector4f;

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
