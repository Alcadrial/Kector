package com.alcadrial.kector.shape.kector.quadrilateral;

import com.alcadrial.kector.shape.api.curve.Segment2f;
import com.alcadrial.kector.shape.api.quadrilateral.AASquare2f;
import com.alcadrial.kector.shape.kector.curve.KectorSegment2fAB;
import com.alcadrial.kector.vector.Vector2f;

public class KectorSquare2f implements AASquare2f {
	
	private float size;
	private Vector2f position;
	
	public KectorSquare2f(float size, Vector2f position)
	{
		if (size == 0) throw new IllegalStateException("Point degenerated square cannot be a Square2f");
		this.position = Vector2f.copyOfImmutable(position);
		if (size > 0) this.size = size;
		else
		{
			this.size = -size;
			this.position = this.position.subtractAll(this.size);
		}
	}
	
	@Override
	public float getWidth()
	{
		return size;
	}
	
	@Override
	public float getHeight()
	{
		return size;
	}
	
	@Override
	public Vector2f getPosition()
	{
		return position;
	}
	
	@Override
	public Vector2f getA()
	{
		return position.add(size, 0);
	}
	
	@Override
	public Vector2f getB()
	{
		return position.add(size, size);
	}
	
	@Override
	public Vector2f getC()
	{
		return position.add(0, size);
	}
	
	@Override
	public Vector2f getD()
	{
		return position;
	}
	
	@Override
	public Vector2f getRigthUpVertex()
	{
		return getB();
	}
	
	@Override
	public Vector2f getRigthDownVertex()
	{
		return getC();
	}
	
	@Override
	public Vector2f getLeftUpVertex()
	{
		return getA();
	}
	
	@Override
	public Vector2f getLeftDownVertex()
	{
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
		return size;
	}
	
	@Override
	public float getBCLength()
	{
		return size;
	}
	
	@Override
	public float getCDLength()
	{
		return size;
	}
	
	@Override
	public float getDALength()
	{
		return size;
	}
	
	@Override
	public float getPerimeter()
	{
		return 4 * size;
	}
	
	@Override
	public float getArea()
	{
		return size * size;
	}
	
	@Override
	public float getSize()
	{
		return size;
	}
}
