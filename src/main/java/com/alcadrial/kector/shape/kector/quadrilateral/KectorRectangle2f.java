package com.alcadrial.kector.shape.kector.quadrilateral;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.shape.api.curve.Segment2f;
import com.alcadrial.kector.shape.api.quadrilateral.Rectangle2f;
import com.alcadrial.kector.shape.kector.curve.KectorSegment2fAB;
import com.alcadrial.kector.vector.Vector2f;

public class KectorRectangle2f implements Rectangle2f {
	
	private Vector2f position;
	private Vector2f size;
	
	public KectorRectangle2f(Vector2f position, Vector2f size)
	{
		this.position = Vector2f.copyOfImmutable(position);
		this.size = Vector2f.copyOfImmutable(size);
	}
	
	@Override
	public Vector2f getA()
	{
		return position.add(size.x(), 0);
	}
	
	@Override
	public Vector2f getB()
	{
		return position.add(size);
	}
	
	@Override
	public Vector2f getC()
	{
		return position.add(0, size.y());
	}
	
	@Override
	public Vector2f getD()
	{
		return position;
	}
	
	@Override
	public Vector2f getRigthUpVertex()
	{
		if (size.y() < 0)
		{
			if (size.x() < 0) return getD();
			return getC();
		}
		if (size.x() < 0) return getA();
		return getB();
	}
	
	@Override
	public Vector2f getRigthDownVertex()
	{
		if (size.y() < 0)
		{
			if (size.x() < 0) return getA();
			return getB();
		}
		if (size.x() < 0) return getD();
		return getC();
	}
	
	@Override
	public Vector2f getLeftUpVertex()
	{
		if (size.y() < 0)
		{
			if (size.x() < 0) return getC();
			return getD();
		}
		if (size.x() < 0) return getB();
		return getA();
	}
	
	@Override
	public Vector2f getLeftDownVertex()
	{
		if (size.y() < 0)
		{
			if (size.x() < 0) return getB();
			return getA();
		}
		if (size.x() < 0) return getC();
		return getD();
	}
	
	@Override
	public Segment2f getSegmentAB()
	{
		return new KectorSegment2fAB(getA(), getB());
	}
	
	@Override
	public Segment2f getSegmentBC()
	{
		return new KectorSegment2fAB(getB(), getC());
	}
	
	@Override
	public Segment2f getSegmentCD()
	{
		return new KectorSegment2fAB(getC(), getD());
	}
	
	@Override
	public Segment2f getSegmentDA()
	{
		return new KectorSegment2fAB(getD(), getA());
	}
	
	@Override
	public Segment2f getSegmentAC()
	{
		return new KectorSegment2fAB(getA(), getC());
	}
	
	@Override
	public Segment2f getSegmentDB()
	{
		return new KectorSegment2fAB(getD(), getB());
	}
	
	@Override
	public float getABLength()
	{
		return Math.abs(size.x());
	}
	
	@Override
	public float getBCLength()
	{
		return Math.abs(size.y());
	}
	
	@Override
	public float getCDLength()
	{
		return Math.abs(size.x());
	}
	
	@Override
	public float getDALength()
	{
		return Math.abs(size.y());
	}
	
	@Override
	public float getPerimeter()
	{
		return 2 * (size.x() + size.y());
	}
	
	@Override
	public float getArea()
	{
		return size.x() * size.y();
	}
	
	@Override
	public float getWidth()
	{
		return size.x();
	}
	
	@Override
	public float getHeight()
	{
		return size.y();
	}
	
	@Override
	public Vector2f getPosition()
	{
		return position;
	}
	
	@Override
	public Angle getAngleRdLdX()
	{
		return null;
	}
	
	@Override
	public Angle getAngleLuLdY()
	{
		return null;
	}
}
