package com.alcadrial.kector.vector.complex;

import com.alcadrial.kector.annotation.NoZeroComponents;
import com.alcadrial.kector.annotation.Preserve;
import com.alcadrial.kector.annotation.Unitary;
import com.alcadrial.kector.vector.Vector2f;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector4f;

public interface IQuaternion {
	
	IQuaternion multiply(IQuaternion quaternion);
	IQuaternion conjugate();

	@Preserve({NoZeroComponents.class, Unitary.class})
	Vector3f rotate(Vector2f vector);
	@Preserve({NoZeroComponents.class, Unitary.class})
	Vector3f rotate(Vector3f vector);
	
	float r();
	float i();
	float j();
	float k();
	
	Vector4f rijk();
	Vector4f xyzw();
}
