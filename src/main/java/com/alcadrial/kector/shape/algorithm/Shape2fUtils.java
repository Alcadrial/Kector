package com.alcadrial.kector.shape.algorithm;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.misc.Direction1f;
import com.alcadrial.kector.shape.api.curve.Line2f;
import com.alcadrial.kector.shape.api.curve.SemiLine2f;
import com.alcadrial.kector.shape.api.quadrilateral.AASquare2f;
import com.alcadrial.kector.shape.kector.curve.KectorSemiLine2fAngle;
import com.alcadrial.kector.shape.kector.curve.KectorSemiLine2fConstant;
import com.alcadrial.kector.vector.Vector2f;

public class Shape2fUtils {
	
	public static IntersectionLineLine2f intersect(Line2f r, Line2f s)
	{
		return new IntersectionLineLine2f(r, s);
	}
	
	public static IntersectionAASquareAASquare2f intersect(AASquare2f s0, AASquare2f s1)
	{
		return new IntersectionAASquareAASquare2f(s0, s1);
	}
	
	/**
	 * Generate the {@link SemiLine2f} from the generator and an offset.
	 * <p>
	 * The origin is calculated from the offset, that is the distance between the origin 
	 * and the point of intersection with the x-axis if the generator is vertical otherwise the y-axis.
	 * 
	 * @param generator the generator
	 * @param offset the distance between the "center" of the generator and the origin
	 * @param direction wether x positive or x negative
	 * @return a new SemiLine2f
	 */
	public static SemiLine2f getSemiLine(Line2f generator, float offset, Direction1f direction)
	{
		return switch (generator.getAngleSpecialization())
		{
			case CONSTANT ->
			{
				float m = generator.getAngularCoefficient();
				if (Float.isInfinite(m)) yield new KectorSemiLine2fConstant(Vector2f.of(generator.getHorizontalTranslation(), offset), m, direction);
				float a = Math.atan(m);
				yield new KectorSemiLine2fConstant(Vector2f.of(offset * Math.cos(a), generator.getVerticalTranslation() + offset * Math.sin(a)), m, direction);
			}
			case ANGLE ->
			{
				Angle a = direction.isPositive() ? generator.getAngle() : generator.getAngle().opposite();
				if (a.equals(Angle.HALF_PI_RAD)) yield new KectorSemiLine2fAngle(a, Vector2f.of(generator.getHorizontalTranslation(), offset));
				float af = a.asFloat(AngleUnit.RADIANS);
				yield new KectorSemiLine2fAngle(a, Vector2f.of(offset * Math.cos(af), generator.getVerticalTranslation() + offset * Math.sin(af)));
			}
		};
	}
}
