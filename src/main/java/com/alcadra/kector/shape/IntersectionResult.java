package com.alcadra.kector.shape;

import com.alcadra.kector.vector.Vector3f;

public class IntersectionResult {
	
	private boolean clip;
	private Vector3f penetrationStart, penetration;
	
	public IntersectionResult(boolean clip, Vector3f penetrationStart, Vector3f penetration)
	{
		this.clip = clip;
		this.penetrationStart = penetrationStart;
		this.penetration = penetration;
	}
	
	public boolean isClip()
	{
		return clip;
	}
	
	public Vector3f getPenetrationStart()
	{
		return penetrationStart;
	}
	
	public Vector3f getPenetration()
	{
		return penetration;
	}
}
