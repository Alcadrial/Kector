package com.alcadrial.kector.shape.kector.quadrilateral;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.shape.api.curve.Segment2f;
import com.alcadrial.kector.shape.api.quadrilateral.AARectangle2f;
import com.alcadrial.kector.shape.kector.curve.KectorSegment2fAB;
import com.alcadrial.kector.vector.Vector2f;

public class KectorAARectangle2f implements AARectangle2f {
	
	private Vector2f position;
	private float width;
	private float height;
	
	public KectorAARectangle2f(Vector2f position, float width, float height)
	{
		this.position = Vector2f.copyOfImmutable(position);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public Vector2f getA()
	{
		return position.add(height, 0);
	}
	
	@Override
	public Vector2f getB()
	{
		return position.add(height, width);
	}
	
	@Override
	public Vector2f getC()
	{
		return position.add(0, width);
	}
	
	@Override
	public Vector2f getD()
	{
		return position;
	}
	
	@Override
	public Vector2f getRigthUpVertex()
	{
		if (height < 0)
		{
			if (width < 0) return getD();
			return getC();
		}
		if (width < 0) return getA();
		return getB();
	}
	
	@Override
	public Vector2f getRigthDownVertex()
	{
		if (height < 0)
		{
			if (width < 0) return getA();
			return getB();
		}
		if (width < 0) return getD();
		return getC();
	}
	
	@Override
	public Vector2f getLeftUpVertex()
	{
		if (height < 0)
		{
			if (width < 0) return getC();
			return getD();
		}
		if (width < 0) return getB();
		return getA();
	}
	
	@Override
	public Vector2f getLeftDownVertex()
	{
		if (height < 0)
		{
			if (width < 0) return getB();
			return getA();
		}
		if (width < 0) return getC();
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
		return Math.abs(width);
	}
	
	@Override
	public float getBCLength()
	{
		return Math.abs(height);
	}
	
	@Override
	public float getCDLength()
	{
		return Math.abs(width);
	}
	
	@Override
	public float getDALength()
	{
		return Math.abs(height);
	}
	
	@Override
	public float getPerimeter()
	{
		return 2 * (width + height);
	}
	
	@Override
	public float getArea()
	{
		return width * height;
	}
	
	@Override
	public float getWidth()
	{
		return width;
	}
	
	@Override
	public float getHeight()
	{
		return height;
	}
	
	@Override
	public Vector2f getPosition()
	{
		return position;
	}
}
