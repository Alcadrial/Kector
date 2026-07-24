package com.alcadrial.kector;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;

import com.alcadrial.kector.Launch.Vector.Quaternion;

public class Launch {
	
	private static final String PACKAGE_ROOT = "com.alcadrial.kector";
	private static final String VECTOR_PACKAGE_NAME = "vector";
	private static final String MUTABLE_PACKAGE_NAME = "mutable";
	private static final String READ_ONLY_PACKAGE_NAME = "readonly";
	private static final String AXIS_PACKAGE_NAME = "axis";
	private static final String COMPLEX_PACKAGE_NAME = "complex";
	private static final String QUATERNION_PACKAGE_NAME = "quaternion";
	
	private static final String VECTOR_PACKAGE = PACKAGE_ROOT + "." + VECTOR_PACKAGE_NAME;
	private static final String VECTOR_MUTABLE_PACKAGE = VECTOR_PACKAGE + "." + MUTABLE_PACKAGE_NAME;
	private static final String VECTOR_READ_ONLY_PACKAGE = VECTOR_PACKAGE + "." + READ_ONLY_PACKAGE_NAME;
	private static final String AXIS_PACKAGE = VECTOR_PACKAGE + "." + AXIS_PACKAGE_NAME;
	private static final String COMPLEX_PACKAGE = VECTOR_PACKAGE + "." + COMPLEX_PACKAGE_NAME;
	private static final String COMPLEX_MUTABLE_PACKAGE = COMPLEX_PACKAGE + "." + MUTABLE_PACKAGE_NAME;
	private static final String COMPLEX_READ_ONLY_PACKAGE = COMPLEX_PACKAGE + "." + READ_ONLY_PACKAGE_NAME;
	private static final String QUATERNION_PACKAGE = VECTOR_PACKAGE + "." + QUATERNION_PACKAGE_NAME;
	private static final String QUATERNION_MUTABLE_PACKAGE = QUATERNION_PACKAGE + "." + MUTABLE_PACKAGE_NAME;
	private static final String QUATERNION_READ_ONLY_PACKAGE = QUATERNION_PACKAGE + "." + READ_ONLY_PACKAGE_NAME;
	
	public static void main(String[] args)
	{
		Path outDir = Path.of("src/out/java");
		
		try
		{
			Files.walkFileTree(outDir, new SimpleFileVisitor<>() {
				
				public FileVisitResult postVisitDirectory(@Nullable Path dir, @Nullable IOException e) throws IOException
				{
					if (outDir.equals(dir)) return FileVisitResult.TERMINATE;
					Files.delete(dir);
					return FileVisitResult.CONTINUE;
				}
				
				public FileVisitResult visitFile(@Nullable Path file, @Nullable BasicFileAttributes e) throws IOException
				{
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}
			});
			new Launch().gen(outDir);
		}
		catch (IOException e)
		{
			e.printStackTrace(System.out);
		}
	}
	
	void gen(Path parent) throws IOException
	{
		Path packageDir = parent.resolve(packageToPath(PACKAGE_ROOT));
		Files.createDirectories(packageDir);
		new Vector().gen(packageDir);
		genVectorMath(packageDir);
	}
	
	void genVectorMath(Path parent) throws IOException
	{
		try (PrintStream stream = new PrintStream(Files.newOutputStream(parent.resolve("VectorMath.java"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)))
		{
			//NOTE: VECTOR MATH
			StringBuilder imports = new StringBuilder();
			imports.append(buildStaticImport(PACKAGE_ROOT, "Math"));
			for (int k : Vector.nonZeroMinorKeys(4)) for (Vector.ElementType t : Vector.ElementType.values()) imports.append(buildImport(VECTOR_PACKAGE, Vector.getType(k, t, true)));
			for (Vector.ElementType t : Vector.ElementType.floatingValues())
			{
				imports.append(buildImport(VECTOR_PACKAGE, Vector.getType(3, t, false)));
				imports.append(buildImport(QUATERNION_PACKAGE, Quaternion.getType(t, true)));
			}
			String javadoc = null;
			
			stream.append(buildClassHeader(PACKAGE_ROOT, imports.toString(), javadoc, "VectorMath", null, null));
			StringBuilder ss = new StringBuilder(300);
			for (int k0 : Vector.nonZeroMinorKeys(4)) for (Vector.ElementType t0 : Vector.ElementType.values())
			{
				String v0 = Vector.getType(k0, t0, true);
				Vector.ElementType f = t0.floatingPointType();
				String params = v0 + " v";
				
				//unary operations
				ss.append("return ");
				for (int k = 0; k < k0; k++) ss
					.append("v.")
					.append(Vector.componentsNames[k])
					.append("() * v.")
					.append(Vector.componentsNames[k])
					.append("() + ");
				ss.setLength(ss.length() - 2);
				ss.replace(ss.length() - 1, ss.length(), ";");
				stream.append(indent(buildStaticMethod(t0.typeName, "squareLength", params, ss.toString()), 1));
				ss.setLength(0);
				ss.append("return ");
				for (int k = 0; k < k0; k++) ss
					.append("abs(v.")
					.append(Vector.componentsNames[k])
					.append("()) + ");
				ss.setLength(ss.length() - 2);
				ss.replace(ss.length() - 1, ss.length(), ";");
				stream.append(indent(buildStaticMethod(t0.typeName, "absoluteLength", params, ss.toString()), 1));
				stream.append(indent(buildStaticMethod(t0.typeName, "absoluteSize", params, buildDelegateReturnBody("absoluteLength", "v")), 1));
				stream.append(indent(buildStaticMethod(f.typeName, "length", params, "return sqrt(squareLength(v));"), 1));
				stream.append(indent(buildStaticMethod(f.typeName, "size", params, buildDelegateReturnBody("length", "v")), 1));
				ss.setLength(0);
				ss.append(t0.typeName)
					.append(" a = abs(v.x()), b;\n");
				for (int k = 1; k < k0; k++)
				{
					String n = Vector.componentsNames[k];
					ss.append("b = abs(v.")
						.append(n)
						.append("());\n")
						.append("if (a < b) a = b;\n");
				}
				ss.append("return a;");
				stream.append(indent(buildStaticMethod(t0.typeName, "maxSize", params, ss.toString()), 1));
				ss.setLength(0);
				
				//binary operations
				for (int k1 : Vector.nonZeroMinorKeys(4)) if (k1 >= k0) for (Vector.ElementType t1 : Vector.ElementType.values()) if (t1.ordinal() >= t0.ordinal())
				{
					String v1 = Vector.getType(k1, t1, true);
					params = v0 + " v, " + v1 + " w";
					Vector.ElementType d = Vector.ElementType.getDominant(t0, t1);
					Vector.ElementType hd = t0 == t1 ? d.highPrecisionType() : d;
					
					//high reduction (vector op vector)
					ss.append("return ");
					for (int k = 0; k < k0; k++) ss
						.append("(v.")
						.append(Vector.componentsNames[k])
						.append("() - w.")
						.append(Vector.componentsNames[k])
						.append("()) * (v.")
						.append(Vector.componentsNames[k])
						.append("() - w.")
						.append(Vector.componentsNames[k])
						.append("()) + ");
					ss.setLength(ss.length() - 2);
					ss.replace(ss.length() - 1, ss.length(), ";");
					stream.append(indent(buildStaticMethod(hd.typeName, "squareDistance", params, ss.toString()), 1));
					ss.setLength(0);
					ss.append("return ");
					for (int k = 0; k < k0; k++) ss
						.append("abs(v.")
						.append(Vector.componentsNames[k])
						.append("() - w.")
						.append(Vector.componentsNames[k])
						.append("()) + ");
					ss.setLength(ss.length() - 2);
					ss.replace(ss.length() - 1, ss.length(), ";");
					stream.append(indent(buildStaticMethod(hd.typeName, "absoluteDistance", params, ss.toString()), 1));
					ss.setLength(0);
					ss.append("return ");
					for (int k = 0; k < k0; k++) ss
						.append("v.")
						.append(Vector.componentsNames[k])
						.append("() * w.")
						.append(Vector.componentsNames[k])
						.append("() + ");
					ss.setLength(ss.length() - 2);
					ss.replace(ss.length() - 1, ss.length(), ";");
					stream.append(indent(buildStaticMethod(hd.typeName, "dotProduct", params, ss.toString()), 1));
					ss.setLength(0);
					
					//float reduction (vector op vector)
					ss.append("return (")
						.append(d.typeName)
						.append(") sqrt(squareDistance(v, w));");
					stream.append(indent(buildStaticMethod(d.typeName, "distance", params, ss.toString()), 1));
					ss.setLength(0);
					
					//reduction (vector op vector)
					ss.append(d.typeName)
						.append(" a = abs(v.x() - w.x()), b;\n");
					for (int k = 1; k < k0; k++)
					{
						String n = Vector.componentsNames[k];
						ss.append("b = abs(v.")
							.append(n)
							.append("() - w.")
							.append(n)
							.append("());\n")
							.append("if (a < b) a = b;\n");
					}
					ss.append("return a;");
					stream.append(indent(buildStaticMethod(d.typeName, "maxDistance", params, ss.toString()), 1));
					ss.setLength(0);
					
					//comparisons
					ss.append("return ");
					for (int k = 0; k < k0; k++) ss
						.append("v.")
						.append(Vector.componentsNames[k])
						.append("() == w.")
						.append(Vector.componentsNames[k])
						.append("() && ");
					ss.setLength(ss.length() - 4);
					ss.append(";");
					stream.append(indent(buildStaticMethod("boolean", "equals", params, ss.toString()), 1));
					ss.setLength(0);
					
					ss.append("return ");
					for (int k = 0; k < k0; k++) ss
						.append("Math.looseEquals(v.")
						.append(Vector.componentsNames[k])
						.append("(), w.")
						.append(Vector.componentsNames[k])
						.append("()) && ");
					ss.setLength(ss.length() - 4);
					ss.append(";");
					stream.append(indent(buildStaticMethod("boolean", "looseEquals", params, ss.toString()), 1));
					ss.setLength(0);
					stream.append("\n");
				}
			}
			
			for (Vector.ElementType qt : Vector.ElementType.floatingValues())
			{
				String quaternionType = Quaternion.getType(qt, true);
				for (Vector.ElementType vt : Vector.ElementType.floatingValues())
				{
					Vector.ElementType d = Vector.ElementType.getDominant(vt, qt);
					String vectorType = Vector.getType(3, vt, false);
					
					ss.append(d.typeName).append(" x = v.x(), y = v.y(), z = v.z();\n")
						.append(d.typeName).append(" i = q.i(), j = q.j(), k = q.k(), r = q.r();\n")
						.append(d.typeName).append(" i2 = i * i, j2 = j * j, k2 = k * k, r2 = r * r;\n")
						.append("return v.setAll(");
					if (vt != d) ss.append("(").append(vt.typeName).append(") (");
					ss.append("x * (r2 + i2 - j2 - k2) + 2 * (y * (i * j - r * k) + z * (i * k + r * j))");
					if (vt != d) ss.append(")");
					ss.append(", ");
					if (vt != d) ss.append("(").append(vt.typeName).append(") (");
					ss.append("y * (r2 - i2 + j2 - k2) + 2 * (x * (r * k + i * j) + z * (-r * i + j * k))");
					if (vt != d) ss.append(")");
					ss.append(", ");
					if (vt != d) ss.append("(").append(vt.typeName).append(") (");
					ss.append("z * (r2 - i2 - j2 + k2) + 2 * (x * (-r * j + i * k) + y * (r * i + j * k))");
					if (vt != d) ss.append(")");
					ss.append(");");
					
					stream.append(indent(buildStaticMethod(vectorType, "rotate", quaternionType + " q, " + vectorType + " v", ss.toString()), 1));
					ss.setLength(0);
				}
			}
			
			stream.append(buildClassFooter());
		}
	}
	
	class Vector {
		
		enum ElementType {
			
			INT("int", "i"),
			LONG("long", "l"),
			FLOAT("float", "f"),
			DOUBLE("double", "d"),;
			
			private static final ElementType[] FLOATING_VALUES = new ElementType[] {FLOAT, DOUBLE};
			
			static ElementType getDominant(ElementType t0, ElementType t1)
			{
				return t0.ordinal() < t1.ordinal() ? t1 : t0;
			}
			
			static ElementType[] floatingValues()
			{
				return FLOATING_VALUES;
			}
			
			String typeName;
			String prefix;
			
			ElementType(String typeName, String prefix)
			{
				this.typeName = typeName;
				this.prefix = prefix;
			}
			
			boolean isIntegerType()
			{
				return this == INT || this == LONG;
			}
			
			ElementType floatingPointType()
			{
				return this == INT ? FLOAT : this == LONG ? DOUBLE : this;
			}
			
			ElementType integerType()
			{
				return this == FLOAT ? INT : this == DOUBLE ? LONG : this;
			}
			
			ElementType highPrecisionType()
			{
				return this == INT ? LONG : this == FLOAT ? DOUBLE : DOUBLE;
			}
		}
		
		static String[] componentsNames = {"x", "y", "z", "w"};
		static String[] types;
		static
		{
			types = new String[minorKeys(4).length * ElementType.values().length * 2];
			
			int i = 0;
			for (int k : minorKeys(4)) for (ElementType t : ElementType.values())
			{
				types[i++] = "Vector" + k + t.prefix;
				types[i] = types[i++ - 1] + "r";
			}
		}
		
		static String getType(int components, ElementType type, boolean readOnly)
		{
			return types[(components == 0 ? 0 : components - 1) * (2 * ElementType.values().length) + type.ordinal() * 2 + (readOnly ? 1 : 0)];
		}
		
		void gen(Path parent) throws IOException
		{
			Path packageDir = parent.resolve(VECTOR_PACKAGE_NAME);
			Files.createDirectories(packageDir);
			new Complex().gen(packageDir);
			new Quaternion().gen(packageDir);
			new ReadOnly().gen(packageDir);
			new Mutable().gen(packageDir);
			new Axis().gen(packageDir);
			
			record Key(int k, @Nullable ElementType t) {}
			
			Map<Key, Supplier<String>> extras = new HashMap<>();
			extras.put(new Key(3, null), () -> "");
			
			for (int k : minorKeys(4)) if (k > 0) for (ElementType t : ElementType.values())
			{
				for (boolean r : new boolean[] {false, true})
				{
					genInterface(packageDir, k, t, r, extras.get(new Key(k, t)));
				}
				genAbstract(packageDir, k, t, null);
			}
		}
		
		void genInterface(Path directory, int components, ElementType elementType, boolean readOnly, @Nullable Supplier<String> extra) throws IOException
		{
			String mutableClazzName = getType(components, elementType, false);
			String readOnlyClazzName = getType(components, elementType, true);
			String clazzName = readOnly ? readOnlyClazzName : mutableClazzName;
			try (PrintStream stream = new PrintStream(Files.newOutputStream(directory.resolve(clazzName + ".java"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)))
			{
				//NOTE: VECTOR INTERFACE
				StringBuilder imports = new StringBuilder();
				if (elementType.isIntegerType()) imports.append("import java.math.RoundingMode;\n");
				if (readOnly) imports.append(buildImportReadOnlyVector(components, elementType));
				else imports.append(buildImportMutableVector(components, elementType));
				if (!imports.isEmpty()) imports.setLength(imports.length() - 1);
				
				String extendsClazzName = null;
				if (!readOnly) extendsClazzName = readOnlyClazzName + (components > 2 ? ", " : "");
				else if (components > 2) extendsClazzName = "";
				if (components > 2) extendsClazzName += getType(components - 1, elementType, readOnly);
				stream.append(buildInterfaceHeader(VECTOR_PACKAGE, imports.toString(), buildClassJavadoc(components, elementType, readOnly), clazzName, extendsClazzName));
				
				if (components > 0)
				{
					//factories
					stream.append(indent(buildStandardFactories(components, elementType, readOnly, mutableClazzName), 1));
					
					for (int k : minorKeys(components)) if (k > 0) for (ElementType t : ElementType.values())
					{
						String params = getType(k, t, true) + " value";
						String args = "value";
						
						if (k < components)
						{
							params += ", " + buildComponentParams(k, components, t);
							args += ", " + buildComponentArgs(k, components);
						}
						if (elementType.isIntegerType() && !t.isIntegerType())
						{
							params += ", RoundingMode roundingMode";
							args += ", roundingMode";
						}
						stream
							.append(indent(buildFactory(clazzName, "of", params, (readOnly ? "ReadOnly" : "Mutable") + mutableClazzName, args), 1))
							.append("\n");
					}
					
					if (!readOnly)
					{
						// vector op vector
						for (String name : new String[] {"add", "subtract", "multiply", "divide", "crossProduct", "projectiveCrossProduct"})
						{
							if (components != 3 && name.equals("crossProduct")) continue;
							if (components != 4 && name.equals("projectiveCrossProduct")) continue;
							for (ElementType t : ElementType.values())
							{
								if (elementType.isIntegerType() && !t.isIntegerType())
								{
									stream.append(indent(buildInterfaceMethod(clazzName, name, getType(components, t, true) + " vector, RoundingMode roundingMode"), 1));
								}
								else
								{
									stream.append(indent(buildInterfaceMethod(clazzName, name, getType(components, t, true) + " vector"), 1));
								}
							}
							stream.append(indent(buildInterfaceMethod(clazzName, name, buildComponentParams(components, elementType)), 1));
							if (elementType.isIntegerType()) stream.append(indent(buildInterfaceMethod(clazzName, name, buildComponentParams(components, elementType.floatingPointType(), "RoundingMode roundingMode")), 1));
							else stream.append(indent(buildInterfaceMethod(clazzName, name, buildComponentParams(components, elementType.integerType())), 1));
							
							if (!name.equals("crossProduct") && !name.equals("projectiveCrossProduct"))
							{
								name += "All";
								if (elementType.isIntegerType()) stream.append(indent(buildInterfaceMethod(clazzName, name, elementType.floatingPointType().typeName + " value, RoundingMode roundingMode"), 1));
								else stream.append(indent(buildInterfaceMethod(clazzName, name, elementType.integerType().typeName + " value"), 1));
								stream.append(indent(buildInterfaceMethod(clazzName, name, elementType.typeName + " value"), 1));
							}
							stream.append("\n");
						}
						//transformations
						for (String name : new String[] {"opposite", "absolute", "conjugate", "normalize", "unitary"})
						{
							stream.append(indent(buildInterfaceMethod(clazzName, name, ""), 1));
						}
						stream.append("\n");
					}
					if (readOnly)
					{
						//high reduction vector
						for (String name : new String[] {"squareLength", "absoluteLength", "absoluteSize"})
						{
							stream.append(indent(buildInterfaceMethod(elementType.highPrecisionType().typeName, name, ""), 1));
						}
						//float reduction vector
						for (String name : new String[] {"length", "size"})
						{
							stream.append(indent(buildInterfaceMethod(elementType.floatingPointType().typeName, name, ""), 1));
						}
						//reduction vector
						for (String name : new String[] {"maxSize"})
						{
							stream.append(indent(buildInterfaceMethod(elementType.typeName, name, ""), 1));
						}
						stream.append("\n");
						//high reduction (vector op vector)
						for (String name : new String[] {"squareDistance", "absoluteDistance", "dotProduct"})
						{
							for (ElementType t : ElementType.values())
							{
								ElementType d = ElementType.getDominant(t, elementType);
								if (t == elementType) d = d.highPrecisionType();
								stream.append(indent(buildInterfaceMethod(d.typeName, name, getType(components, t, true) + " vector"), 1));
							}
						}
						//float reduction (vector op vector)
						for (String name : new String[] {"distance"})
						{
							for (ElementType t : ElementType.values())
							{
								ElementType d = ElementType.getDominant(t, elementType);
								stream.append(indent(buildInterfaceMethod(d.floatingPointType().typeName, name, getType(components, t, true) + " vector"), 1));
							}
						}
						//reduction (vector op vector)
						for (String name : new String[] {"maxDistance"})
						{
							for (ElementType t : ElementType.values())
							{
								ElementType d = ElementType.getDominant(t, elementType);
								stream.append(indent(buildInterfaceMethod(d.typeName, name, getType(components, t, true) + " vector"), 1));
							}
						}
						stream.append("\n");
						//comparisons
						stream.append(indent(buildInterfaceMethod("int", "hashcode", ""), 1));
						for (ElementType t : ElementType.values())
						{
							stream.append(indent(buildInterfaceMethod("boolean", "equals", getType(components, t, true) + " vector"), 1));
						}
						stream.append("\n");
						//comparisons
						for (String name : new String[] {"isGreater", "isMinor"})
						{
							for (ElementType t : ElementType.values())
							{
								stream.append(indent(buildInterfaceMethod("boolean", name, getType(components, t, true) + " vector"), 1));
							}
						}
						stream.append("\n");
					}
					//getters
					for (int k : nonZeroMinorParamsCount(components))
					{
						stream.append(indent(buildInterfaceMethod(elementType.typeName, "get" + componentsNames[k - 1].toUpperCase(), ""), 1));
						stream.append(indent(buildInterfaceMethod(elementType.typeName, componentsNames[k - 1], ""), 1));
					}
					stream.append("\n");
					if (!readOnly)
					{
						//setters
						for (int k : nonZeroMinorParamsCount(components))
						{
							stream.append(indent(buildInterfaceMethod(clazzName, "set" + componentsNames[k - 1].toUpperCase(), elementType.typeName + " " + componentsNames[k - 1]), 1));
							stream.append(indent(buildInterfaceMethod(clazzName, componentsNames[k - 1], elementType.typeName + " " + componentsNames[k - 1]), 1));
						}
						stream.append("\n");
						stream.append(indent(buildInterfaceMethod(clazzName, "setAll", buildComponentParams(components, elementType)), 1));
						for (ElementType t : ElementType.values())
						{
							if (elementType.isIntegerType() && !t.isIntegerType()) stream.append(indent(buildInterfaceMethod(clazzName, "setAll", getType(components, t, true) + " vector, RoundingMode roundingMode"), 1));
							else stream.append(indent(buildInterfaceMethod(clazzName, "setAll", getType(components, t, true) + " vector"), 1));
						}
						stream.append("\n");
					}
				}
				stream.append(buildClassFooter());
			}
		}
		
		void genAbstract(Path directory, int components, ElementType elementType, @Nullable Supplier<String> extra) throws IOException
		{
			String interfaceName = getType(components, elementType, false);
			String readOnlyInterfaceName = getType(components, elementType, true);
			String clazzName = "Abstract" + interfaceName;
			try (PrintStream stream = new PrintStream(Files.newOutputStream(directory.resolve(clazzName + ".java"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)))
			{
				//NOTE: VECTOR ABSTRACT
				String imports = "";
				imports += buildImport("java.util", "Objects");
				imports += buildImport("org.jspecify.annotations", "Nullable");
				imports += buildImport(PACKAGE_ROOT, "VectorMath");
				String smallerAbstractVectorClassName = components <= 2 ? null : "Abstract" + getType(components - 1, elementType, false);
				stream.append(buildAbstractHeader(VECTOR_PACKAGE, imports, null, clazzName, smallerAbstractVectorClassName, readOnlyInterfaceName));
				stream.append(indent(buildCostructor("protected", clazzName, "", null), 1));
				stream.append("\n");
				
				//high reduction vector
				for (String name : new String[] {"squareLength", "absoluteLength", "absoluteSize"})
				{
					stream.append(indent(buildMethod("public", elementType.highPrecisionType().typeName, name, "", buildDelegateReturnBody("VectorMath." + name, "this")), 1));
				}
				//float reduction vector
				for (String name : new String[] {"length", "size"})
				{
					stream.append(indent(buildMethod("public", elementType.floatingPointType().typeName, name, "", buildDelegateReturnBody("VectorMath." + name, "this")), 1));
				}
				//reduction vector
				for (String name : new String[] {"maxSize"})
				{
					stream.append(indent(buildMethod("public", elementType.typeName, name, "", buildDelegateReturnBody("VectorMath." + name, "this")), 1));
				}
				stream.append("\n");
				//high reduction (vector op vector)
				for (String name : new String[] {"squareDistance", "absoluteDistance", "dotProduct"})
				{
					for (ElementType t : ElementType.values())
					{
						ElementType d = ElementType.getDominant(t, elementType);
						if (t == elementType) d = d.highPrecisionType();
						stream.append(indent(buildMethod("public", d.typeName, name, getType(components, t, true) + " vector", buildDelegateReturnBody("VectorMath." + name, swapAndMix("this", "vector", ", ", t.ordinal() < elementType.ordinal()))), 1));
					}
				}
				//float reduction (vector op vector)
				for (String name : new String[] {"distance"})
				{
					for (ElementType t : ElementType.values())
					{
						ElementType d = ElementType.getDominant(t, elementType);
						stream.append(indent(buildMethod("public", d.floatingPointType().typeName, name, getType(components, t, true) + " vector", buildDelegateReturnBody("VectorMath." + name, swapAndMix("this", "vector", ", ", t.ordinal() < elementType.ordinal()))), 1));
					}
				}
				//reduction (vector op vector)
				for (String name : new String[] {"maxDistance"})
				{
					for (ElementType t : ElementType.values())
					{
						ElementType d = ElementType.getDominant(t, elementType);
						stream.append(indent(buildMethod("public", d.typeName, name, getType(components, t, true) + " vector", buildDelegateReturnBody("VectorMath." + name, swapAndMix("this", "vector", ", ", t.ordinal() < elementType.ordinal()))), 1));
					}
				}
				stream.append("\n");
				//comparisons
				stream.append(indent(buildMethod("public", "int", "hashcode", "", buildDelegateReturnBody("Objects.hash", buildDelegateComponentArgs(components))), 1));
				for (ElementType t : ElementType.values())
				{
					stream.append(indent(buildMethod("public", "boolean", "equals", getType(components, t, true) + " v", buildDelegateReturnBody("VectorMath.looseEquals", swapAndMix("this", "v", ", ", t.ordinal() < elementType.ordinal()))), 1));
				}
				stream.append(indent("""
					@Override
					public boolean equals(@Nullable Object obj)
					{
					""", 1));
				for (ElementType t : ElementType.values())
				{
					stream.append(indent("""
						if (obj instanceof Vector%s%sr v) return equals(v);
						""".formatted(components, t.prefix), 2));
				}
				if (components > 2)
				{
					stream.append(indent("""
							return super.equals(obj);
						}
						""", 1));
				}
				else
				{
					stream.append(indent("""
							return false;
						}
						""", 1));
				}
				
				stream.append("\n");
				StringBuilder ss = new StringBuilder();
				for (String nameOp : new String[] {"> isGreater", "< isMinor"})
				{
					String[] s = nameOp.split(" ");
					String name = s[1];
					String op = s[0];
					for (ElementType t : ElementType.values())
					{
						
						ss.append("return ");
						for (int k = 0; k < components; k++) ss
							.append(componentsNames[k])
							.append("() ")
							.append(op)
							.append(" v.")
							.append(componentsNames[k])
							.append("() && ");
						ss.setLength(ss.length() - 4);
						ss.append(";");
						stream.append(indent(buildMethod("public", "boolean", name, getType(components, t, true) + " v", ss.toString()), 1));
						ss.setLength(0);
					}
				}
				stream.append("\n");
				
				//getters
				for (int k : nonZeroMinorParamsCount(components))
				{
					stream.append(indent(buildMethod("public", elementType.typeName, "get" + componentsNames[k - 1].toUpperCase(), "", "return " + componentsNames[k - 1] + "();"), 1));
				}
				stream.append("\n");
				
				stream.append(buildClassFooter());
			}
		}
		
		void genOverrides(PrintStream stream, int components, ElementType elementType, boolean readOnly, String returnType, boolean delegate) throws IOException
		{
			genUniqueOverrides(stream, components, elementType, readOnly, returnType, delegate);
			if (!readOnly)
			{
				for (String name : new String[] {"add", "subtract", "multiply", "divide"})
				{
					name += "All";
					if (elementType.isIntegerType()) stream.append(indent(buildOverrideMethod(returnType, name, elementType.floatingPointType().typeName + " value, RoundingMode roundingMode", "value, roundingMode", delegate), 1));
					else stream.append(indent(buildOverrideMethod(returnType, name, elementType.integerType().typeName + " value", "value", delegate), 1));
					stream.append(indent(buildOverrideMethod(returnType, name, elementType.typeName + " value", "value", delegate), 1));
				}
				stream.append("\n");
				
				//transformations
				for (String name : new String[] {"opposite", "absolute", "conjugate"})
				{
					stream.append(indent(buildOverrideMethod(returnType, name, "", "", delegate), 1));
				}
				stream.append("\n");
				
				//setters
				for (int k : nonZeroMinorParamsCount(components))
				{
					stream.append(indent(buildOverrideMethod(returnType, "set" + componentsNames[k - 1].toUpperCase(), elementType.typeName + " " + componentsNames[k - 1], componentsNames[k - 1], delegate), 1));
					stream.append(indent(buildOverrideMethod(returnType, componentsNames[k - 1], elementType.typeName + " " + componentsNames[k - 1], componentsNames[k - 1], delegate), 1));
				}
				stream.append("\n");
				stream.append(indent(buildOverrideMethod(returnType, "setAll", buildComponentParams(components, elementType), buildComponentArgs(components), delegate), 1));
				for (ElementType t : ElementType.values())
				{
					if (elementType.isIntegerType() && !t.isIntegerType()) stream.append(indent(buildOverrideMethod(returnType, "setAll", getType(components, t, true) + " vector, RoundingMode roundingMode", "vector, roundingModex", delegate), 1));
					else stream.append(indent(buildOverrideMethod(returnType, "setAll", getType(components, t, true) + " vector", "vector", delegate), 1));
				}
				stream.append("\n");
			}
		}
		
		private void genUniqueOverrides(PrintStream stream, int components, ElementType elementType, boolean readOnly, String returnType, boolean delegate) throws IOException
		{
			//NOTE: VECTOR OVERRIDES
			if (!readOnly)
			{
				// vector op vector
				for (String name : new String[] {"add", "subtract", "multiply", "divide"})
				{
					for (ElementType t : ElementType.values())
					{
						if (elementType.isIntegerType() && !t.isIntegerType())
						{
							stream.append(indent(buildOverrideMethod(returnType, name, getType(components, t, true) + " vector, RoundingMode roundingMode", "vector, roundingMode", delegate), 1));
						}
						else
						{
							stream.append(indent(buildOverrideMethod(returnType, name, getType(components, t, true) + " vector", "vector", delegate), 1));
						}
					}
					stream.append(indent(buildOverrideMethod(returnType, name, buildComponentParams(components, elementType), buildComponentArgs(components), delegate), 1));
					if (elementType.isIntegerType()) stream.append(indent(buildOverrideMethod(returnType, name, buildComponentParams(components, elementType.floatingPointType(), "RoundingMode roundingMode"), buildComponentArgs(components, "roundingMode"), delegate), 1));
					else stream.append(indent(buildOverrideMethod(returnType, name, buildComponentParams(components, elementType.integerType()), buildComponentArgs(components), delegate), 1));
				}
			}
			
			if (components > 2) genUniqueOverrides(stream, components - 1, elementType, readOnly, returnType, delegate);
		}
		
		String buildImportInterfaceVector(int components, ElementType elementType)
		{
			return buildImport(VECTOR_PACKAGE, "Vector" + components + elementType.prefix);
		}
		
		String buildImportReadInterfaceVector(int components, ElementType elementType)
		{
			return buildImport(VECTOR_PACKAGE, "Vector" + components + elementType.prefix + "r");
		}
		
		String buildImportAbstractVector(int components, ElementType elementType)
		{
			return buildImport(VECTOR_PACKAGE, "AbstractVector" + components + elementType.prefix);
		}
		
		String buildImportMutableVector(int components, ElementType elementType)
		{
			return buildImport(VECTOR_MUTABLE_PACKAGE, "MutableVector" + components + elementType.prefix);
		}
		
		String buildImportReadOnlyVector(int components, ElementType elementType)
		{
			return buildImport(VECTOR_READ_ONLY_PACKAGE, "ReadOnlyVector" + components + elementType.prefix);
		}
		
		String buildClassJavadoc(int components, ElementType elementType, boolean readOnly)
		{
			return """
				/**
				 * A %3$s%1$s-dimensional vector {%2$s}
				 */""".formatted(components, buildComponentArgs(components).toUpperCase(), readOnly ? "read-only " : "");
		}
		
		String buildStandardFactories(int components, ElementType elementType, boolean readOnly, String clazzName)
		{
			String resultClazzName = clazzName;
			if (readOnly) resultClazzName += "r";
			String implClazzName = (readOnly ? "ReadOnly" : "Mutable") + clazzName;
			StringBuilder ss = new StringBuilder();
			if (readOnly)
			{
				ss.append(buildMethod("static", resultClazzName, "of", "", "return " + implClazzName + ".ZERO;")).append("\n");
				if (components == 4) ss.append(buildMethod("static", resultClazzName, "ofProjective", "", "return " + implClazzName + ".PROJECTIVE_ZERO;")).append("\n");
			}
			else
			{
				ss.append(buildFactory(resultClazzName, "of", "", implClazzName, "0, ".repeat(components).substring(0, 3 * components - 2))).append("\n");
			}
			ss.append(buildFactory(resultClazzName, "of", buildComponentParams(components, elementType), implClazzName, buildComponentArgs(components))).append("\n");
			ElementType floatingPointType = elementType.floatingPointType();
			if (floatingPointType != elementType && components > 0)
			{
				ss.append(buildFactory(resultClazzName, "of", buildComponentParams(components, floatingPointType, "RoundingMode roundingMode"), implClazzName, buildComponentArgs(components, "roundingMode")))
					.append("\n");
			}
			return ss.toString();
		}
		
		String buildComponentParams(int components, ElementType elementType, String... extra)
		{
			return buildComponentParams(0, components, elementType, extra);
		}
		
		String buildComponentParams(int offset, int components, ElementType elementType, String... extra)
		{
			if (components <= 0) return "";
			StringBuilder ss = new StringBuilder();
			for (int k = offset; k < components; k++) ss.append(elementType.typeName).append(" ").append(componentsNames[k]).append(", ");
			for (String s : extra) ss.append(s).append(", ");
			return ss.substring(0, ss.length() - 2);
		}
		
		String buildSpreadArgs(int components, String argName, String... extra)
		{
			if (components == 0) return "";
			StringBuilder ss = new StringBuilder();
			for (int k = 0; k < components; k++) ss.append(argName).append(", ");
			for (String s : extra) ss.append(s).append(", ");
			return ss.substring(0, ss.length() - 2);
		}
		
		String buildDelegateComponentArgs(int components, String... extra)
		{
			if (components == 0) return "";
			StringBuilder ss = new StringBuilder();
			for (int k = 0; k < components; k++) ss.append(componentsNames[k]).append("(), ");
			for (String s : extra) ss.append(s).append(", ");
			return ss.substring(0, ss.length() - 2);
		}
		
		String buildComponentArgs(int components, String... extra)
		{
			return buildComponentArgs(0, components, extra);
		}
		
		String buildComponentArgs(int offset, int components, String... extra)
		{
			if (components == 0) return "";
			StringBuilder ss = new StringBuilder();
			for (int k = offset; k < components; k++) ss.append(componentsNames[k]).append(", ");
			for (String s : extra) ss.append(s).append(", ");
			return ss.substring(0, ss.length() - 2);
		}
		
		String buildDelegateArgs(int components, ElementType toType, ElementType fromType, @Nullable String objectName)
		{
			return buildDelegateArgs(0, components, toType, fromType, objectName, false, componentsNames);
		}
		
		String buildDelegateArgs(int components, ElementType toType, ElementType fromType, @Nullable String objectName, boolean forceCast)
		{
			return buildDelegateArgs(0, components, toType, fromType, objectName, forceCast, componentsNames);
		}
		
		String buildDelegateArgs(int offset, int components, ElementType toType, ElementType fromType, @Nullable String objectName)
		{
			return buildDelegateArgs(offset, components, toType, fromType, objectName, false, componentsNames);
		}
		
		String buildDelegateArgs(int offset, int components, ElementType toType, ElementType fromType, @Nullable String objectName, boolean forceCast)
		{
			return buildDelegateArgs(offset, components, toType, fromType, objectName, forceCast, componentsNames);
		}
		
		String buildDelegateArgs(int offset, int components, ElementType toType, ElementType fromType, @Nullable String objectName, boolean forceCast, String[] names)
		{
			if (components <= offset) return "";
			if (toType.isIntegerType() && !fromType.isIntegerType())
			{
				StringBuilder ss = new StringBuilder();
				for (int k = offset; k < components; k++)
				{
					if (toType == ElementType.INT) ss.append("toInt(");
					else ss.append("toLong(");
					if (objectName != null) ss.append(objectName).append(".");
					ss.append(names[k]);
					if (objectName != null) ss.append("()");
					ss.append(", roundingMode), ");
				}
				return ss.substring(0, ss.length() - 2);
			}
			if (forceCast || toType.highPrecisionType() == fromType)
			{
				StringBuilder ss = new StringBuilder();
				for (int k = offset; k < components; k++)
				{
					ss.append("(")
						.append(toType.typeName)
						.append(") ");
					if (objectName != null) ss.append(objectName).append(".");
					ss.append(componentsNames[k]);
					if (objectName != null) ss.append("()");
					ss.append(", ");
				}
				return ss.substring(0, ss.length() - 2);
			}
			if (objectName != null)
			{
				StringBuilder ss = new StringBuilder();
				for (int k = offset; k < components; k++)
				{
					ss.append(objectName).append(".")
						.append(componentsNames[k])
						.append("()")
						.append(", ");
				}
				return ss.substring(0, ss.length() - 2);
			}
			return buildComponentArgs(offset, components);
		}
		
		String buildDelegateSetBody(int components, ElementType toType, ElementType fromType, @Nullable String objectName)
		{
			if (components == 0) return "return this;";
			StringBuilder ss = new StringBuilder(50);
			ss.append("return ");
			if (toType.isIntegerType() && !fromType.isIntegerType())
			{
				for (int k = 0; k < components; k++)
				{
					ss.append(componentsNames[k]).append("(");
					if (toType == ElementType.INT) ss.append("toInt(");
					else ss.append("toLong(");
					if (objectName != null) ss.append(objectName).append(".");
					ss.append(componentsNames[k]);
					if (objectName != null) ss.append("()");
					ss.append(", roundingMode)).");
				}
			}
			else
			{
				for (int k = 0; k < components; k++)
				{
					ss.append(componentsNames[k]).append("(");
					if (toType.highPrecisionType() != toType && toType.highPrecisionType() == fromType) ss.append("(").append(toType.typeName).append(") ");
					if (objectName != null) ss.append(objectName).append(".");
					ss.append(componentsNames[k]);
					if (objectName != null) ss.append("()");
					ss.append(").");
				}
			}
			return ss.replace(ss.length() - 1, ss.length(), ";").toString();
		}
		
		String buildToStringBody(String className, int components)
		{
			StringBuilder ss = new StringBuilder(25);
			ss.append("StringBuilder ss = new StringBuilder(25);\n");
			ss.append("return ss.append(\"").append(className).append("{\").append(");
			for (int k = 0; k < components; k++) ss.append(componentsNames[k]).append("()).append(\", \").append(");
			ss.setLength(ss.length() - 12);
			ss.append("}\").toString();");
			return ss.toString();
		}
		
		static int[] minorKeys(int k)
		{
			return switch (k)
			{
				case 0 -> new int[] {0};
				case 1 -> new int[] {0};
				case 2 -> new int[] {0, 2};
				case 3 -> new int[] {0, 2, 3};
				default -> new int[] {0, 2, 3, 4};
			};
		}
		
		static int[] nonZeroMinorKeys(int k)
		{
			return switch (k)
			{
				case 0 -> new int[] {};
				case 1 -> new int[] {};
				case 2 -> new int[] {2};
				case 3 -> new int[] {2, 3};
				default -> new int[] {2, 3, 4};
			};
		}
		
		static int[] minorParamsCount(int k)
		{
			return switch (k)
			{
				case 0 -> new int[] {0};
				case 1 -> new int[] {0, 1};
				case 2 -> new int[] {0, 1, 2};
				case 3 -> new int[] {0, 1, 2, 3};
				default -> new int[] {0, 1, 2, 3, 4};
			};
		}
		
		static int[] nonZeroMinorParamsCount(int k)
		{
			return switch (k)
			{
				case 0 -> new int[] {};
				case 1 -> new int[] {1};
				case 2 -> new int[] {1, 2};
				case 3 -> new int[] {1, 2, 3};
				default -> new int[] {1, 2, 3, 4};
			};
		}
		
		String buildApplyOperation(int components, char operation)
		{
			StringBuilder ss = new StringBuilder();
			for (int k = 0; k < components; k++)
			{
				ss.append("this.").append(componentsNames[k]).append(" ").append(operation).append("= ").append(componentsNames[k]).append(";\n");
			}
			ss.append("return this;");
			return ss.toString();
		}
		
		class Complex {
			
			void gen(Path parent) throws IOException
			{
				Path packageDir = parent.resolve(COMPLEX_PACKAGE_NAME);
				Files.createDirectories(packageDir);
				new Mutable().gen(packageDir);
				new ReadOnly().gen(packageDir);
				
				for (ElementType t : ElementType.values())
				{
					genInterface(packageDir, t);
				}
			}
			
			void genInterface(Path directory, ElementType elementType) throws IOException
			{
				String clazzName = "Complex" + elementType.prefix;
				try (PrintStream stream = new PrintStream(Files.newOutputStream(directory.resolve(clazzName + ".java"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)))
				{
					//NOTE: COMPLEX INTERFACE
				}
			}
			
			class Mutable {
				
				void gen(Path parent) throws IOException
				{
					Path packageDir = parent.resolve(MUTABLE_PACKAGE_NAME);
					Files.createDirectories(packageDir);
					
					for (ElementType t : ElementType.values())
					{
						genMutable(packageDir, t);
					}
				}
				
				void genMutable(Path directory, ElementType elementType) throws IOException
				{
					String interfaceName = "Complex" + elementType.prefix;
					String clazzName = "Mutable" + interfaceName;
					try (PrintStream stream = new PrintStream(Files.newOutputStream(directory.resolve(clazzName + ".java"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)))
					{
						//NOTE: COMPLEX MUTABLE
					}
				}
			}
			
			class ReadOnly {
				
				void gen(Path parent) throws IOException
				{
					Path packageDir = parent.resolve(READ_ONLY_PACKAGE_NAME);
					Files.createDirectories(packageDir);
					
					for (ElementType t : ElementType.values())
					{
						genReadOnly(packageDir, t);
					}
				}
				
				void genReadOnly(Path directory, ElementType elementType) throws IOException
				{
					String interfaceName = "Complex" + elementType.prefix;
					String clazzName = "ReadOnly" + interfaceName;
					try (PrintStream stream = new PrintStream(Files.newOutputStream(directory.resolve(clazzName + ".java"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)))
					{
						//NOTE: COMPLEX READ ONLY
					}
				}
			}
		}
		
		class Quaternion {
			
			void gen(Path parent) throws IOException
			{
				Path packageDir = parent.resolve(QUATERNION_PACKAGE_NAME);
				Files.createDirectories(packageDir);
				new Mutable().gen(packageDir);
				new ReadOnly().gen(packageDir);
				
				for (ElementType t : ElementType.floatingValues()) for (boolean r : new boolean[] {false, true})
				{
					genInterface(packageDir, t, r);
				}
			}
			
			static String[] componentsNames = {"i", "j", "k", "r"};
			static String[] types;
			static
			{
				types = new String[ElementType.floatingValues().length * 2];
				
				int i = 0;
				for (ElementType t : ElementType.floatingValues())
				{
					types[i++] = "Quaternion" + t.prefix;
					types[i] = types[i++ - 1] + "r";
				}
			}
			
			static String getType(ElementType type, boolean readOnly)
			{
				return types[(type.ordinal() - 2) * 2 + (readOnly ? 1 : 0)];
			}
			
			void genInterface(Path directory, ElementType elementType, boolean readOnly) throws IOException
			{
				String vectorClazzName = Vector.getType(4, elementType, readOnly);
				String implClazzName = (readOnly ? "ReadOnly" : "Mutable") + getType(elementType, false);
				String clazzName = getType(elementType, readOnly);
				try (PrintStream stream = new PrintStream(Files.newOutputStream(directory.resolve(clazzName + ".java"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)))
				{
					//NOTE: QUATERNION INTERFACE
					StringBuilder imports = new StringBuilder();
					imports.append(buildImport(PACKAGE_ROOT, "Math"));
					imports.append(buildImport(PACKAGE_ROOT + ".annotation", "Angle"));
					imports.append(buildImport(PACKAGE_ROOT + ".annotation", "Direction"));
					if (readOnly) imports.append(buildImport(PACKAGE_ROOT + ".annotation", "Preserve"));
					if (readOnly) imports.append(buildImport(PACKAGE_ROOT + ".annotation", "Unitary"));
					imports.append(buildImport(VECTOR_PACKAGE, vectorClazzName));
					if (!readOnly)
					{
						for (int k : nonZeroMinorKeys(4)) for (ElementType t : ElementType.values())
						{
							imports.append(buildImport(VECTOR_PACKAGE, Vector.getType(k, t, true)));
						}
						imports.append(buildImport(QUATERNION_MUTABLE_PACKAGE, implClazzName));
					}
					else
					{
						for (ElementType t : ElementType.floatingValues())
						{
							imports.append(buildImport(VECTOR_PACKAGE, Vector.getType(3, t, false)));
						}
						imports.append(buildImport(VECTOR_PACKAGE, Vector.getType(3, ElementType.INT, true)));
						imports.append(buildImport(QUATERNION_READ_ONLY_PACKAGE, implClazzName));
					}
					StringBuilder extend = new StringBuilder();
					extend.append(vectorClazzName);
					if (!readOnly) extend.append(", ").append(getType(elementType, true));
					
					stream.append(buildInterfaceHeader(QUATERNION_PACKAGE, imports.toString(), null, clazzName, extend.toString()));
					
					//factories
					StringBuilder ss = new StringBuilder();
					stream.append(indent(buildFactory(clazzName, "of", buildComponentParams(0, 4, elementType), implClazzName, buildComponentArgs(0, 4)), 1));
					
					for (ElementType t : ElementType.floatingValues())
					{
						stream.append(indent(buildFactory(clazzName, "of", getType(t, true) + " q", implClazzName, "q"), 1));
					}
					
					ss.append(elementType.typeName).append(" angleValue = angle / 2, s = Math.sin(angleValue);");
					stream.append(indent(buildFactory(clazzName, "ofAxis", "@Direction Vector3ir axis, @Angle float angle", implClazzName, "axis.x() * s, axis.y() * s, axis.z() * s, Math.cos(angleValue)", indent(ss.toString(), 1)), 1));
					ss.setLength(0);
					
					ss.append(elementType.typeName).append(" xCos = Math.cos(xRotation), xSin = Math.sin(xRotation);\n");
					ss.append(elementType.typeName).append(" yCos = Math.cos(yRotation), ySin = Math.sin(yRotation);\n");
					ss.append(elementType.typeName).append(" zCos = Math.cos(zRotation), zSin = Math.sin(zRotation);");
					stream.append(indent(buildFactory(clazzName, "ofAngles", "@Angle float xRotation, @Angle float yRotation, @Angle float zRotation", implClazzName, "xSin * yCos * zCos - xCos * ySin * zSin, xCos * ySin * zCos + xSin * yCos * zSin, xCos * yCos * zSin - xSin * ySin * zCos, xCos * yCos * zCos + xSin * ySin * zSin", indent(ss.toString(), 1)), 1));
					ss.setLength(0);
					stream.append("\n");
					
					if (!readOnly)
					{
						//multiply
						for (ElementType t : ElementType.floatingValues())
						{
							stream.append(indent(buildInterfaceMethod(clazzName, "multiply", getType(t, true) + " q"), 1));
						}
						stream.append("\n");
						//setters
						for (int k = 0; k < 4; k++)
						{
							stream.append(indent(buildInterfaceMethod(clazzName, "set" + componentsNames[k].toUpperCase(), elementType.typeName + " " + componentsNames[k]), 1));
							stream.append(indent(buildInterfaceMethod(clazzName, componentsNames[k], elementType.typeName + " " + componentsNames[k]), 1));
						}
					}
					else
					{
						//rotate
						for (ElementType t : ElementType.floatingValues())
						{
							stream.append(indent("@Preserve({Unitary.class})\n", 1));
							stream.append(indent(buildInterfaceMethod(Vector.getType(3, t, false), "rotate", Vector.getType(3, t, false) + " v"), 1));
						}
						stream.append("\n");
						//getters
						for (int k = 0; k < 4; k++)
						{
							stream.append(indent(buildInterfaceMethod(elementType.typeName, "get" + componentsNames[k].toUpperCase(), ""), 1));
							stream.append(indent(buildInterfaceMethod(elementType.typeName, componentsNames[k], ""), 1));
						}
					}
					genOverrides(stream, 4, elementType, readOnly, clazzName, false);
					
					stream.append(buildClassFooter());
				}
			}
			
			String buildComponentParams(int offset, int components, ElementType elementType, String... extra)
			{
				if (components <= 0) return "";
				StringBuilder ss = new StringBuilder();
				for (int k = offset; k < components; k++) ss.append(elementType.typeName).append(" ").append(componentsNames[k]).append(", ");
				for (String s : extra) ss.append(s).append(", ");
				return ss.substring(0, ss.length() - 2);
			}
			
			String buildComponentArgs(int offset, int components, String... extra)
			{
				if (components == 0) return "";
				StringBuilder ss = new StringBuilder();
				for (int k = offset; k < components; k++) ss.append(componentsNames[k]).append(", ");
				for (String s : extra) ss.append(s).append(", ");
				return ss.substring(0, ss.length() - 2);
			}
			
			String buildToStringBody(String className, int components)
			{
				StringBuilder ss = new StringBuilder(25);
				ss.append("StringBuilder ss = new StringBuilder(25);\n");
				ss.append("return ss.append(\"").append(className).append("{\").append(");
				for (int k = 0; k < components; k++) ss.append(componentsNames[k]).append("()).append(\"").append(componentsNames[k]).append(" + \").append(");
				ss.setLength(ss.length() - 14);
				ss.append("}\").toString();");
				return ss.toString();
			}
			
			class Mutable {
				
				void gen(Path parent) throws IOException
				{
					Path packageDir = parent.resolve(MUTABLE_PACKAGE_NAME);
					Files.createDirectories(packageDir);
					
					for (ElementType t : ElementType.floatingValues())
					{
						genMutable(packageDir, t);
					}
				}
				
				void genMutable(Path directory, ElementType elementType) throws IOException
				{
					String vectorClazzName = "MutableVector4" + elementType.prefix;
					String interfaceName = "Quaternion" + elementType.prefix;
					String clazzName = "Mutable" + interfaceName;
					try (PrintStream stream = new PrintStream(Files.newOutputStream(directory.resolve(clazzName + ".java"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)))
					{
						//NOTE: QUATERNION MUTABLE
						StringBuilder imports = new StringBuilder();
						imports.append(buildImport(PACKAGE_ROOT, "VectorMath"));
						imports.append(buildImport(VECTOR_MUTABLE_PACKAGE, vectorClazzName));
						for (int k : nonZeroMinorKeys(4)) for (ElementType t : ElementType.values())
						{
							imports.append(buildImport(VECTOR_PACKAGE, Vector.getType(k, t, true)));
						}
						for (ElementType t : ElementType.floatingValues())
						{
							imports.append(buildImport(VECTOR_PACKAGE, Vector.getType(3, t, false)));
						}
						imports.append(buildImport(QUATERNION_PACKAGE, getType(elementType, false)));
						for (ElementType t : ElementType.floatingValues())
						{
							imports.append(buildImport(QUATERNION_PACKAGE, getType(t, true)));
						}
						stream.append(buildClassHeader(QUATERNION_MUTABLE_PACKAGE, imports.toString(), null, clazzName, vectorClazzName, interfaceName));
						
						//constructors
						stream.append(indent(buildCostructor("public", clazzName, buildComponentParams(0, 4, elementType), buildDelegateBody("super", buildComponentArgs(0, 4))), 1));
						
						for (ElementType t : ElementType.floatingValues())
						{
							stream.append(indent(buildCostructor("public", clazzName, getType(t, true) + " q", buildDelegateBody("this", buildDelegateArgs(0, 4, elementType, t, "q", true, componentsNames))), 1));
						}
						stream.append("\n");
						
						//multiply
						for (ElementType t : ElementType.floatingValues())
						{
							StringBuilder ss = new StringBuilder();
							ss.append(elementType.typeName).append(" i0 = i(), j0 = j(), k0 = k(), r0 = r();\n");
							ss.append(t.typeName).append(" i1 = q.i(), j1 = q.j(), k1 = q.k(), r1 = q.r();\n");
							ss.append("i(");
							if (elementType != t) ss.append("(").append(elementType.typeName).append(") (");
							ss.append("r0 * i1 + i0 * r1 + j0 * k1 - k0 * j1");
							if (elementType != t) ss.append(")");
							ss.append(");\n");
							ss.append("j(");
							if (elementType != t) ss.append("(").append(elementType.typeName).append(") (");
							ss.append("r0 * j1 + j0 * r1 - i0 * k1 + k0 * i1");
							if (elementType != t) ss.append(")");
							ss.append(");\n");
							ss.append("k(");
							if (elementType != t) ss.append("(").append(elementType.typeName).append(") (");
							ss.append("r0 * k1 + k0 * r1 + i0 * j1 - j0 * i1");
							if (elementType != t) ss.append(")");
							ss.append(");\n");
							ss.append("r(");
							if (elementType != t) ss.append("(").append(elementType.typeName).append(") (");
							ss.append("r0 * r1 - i0 * i1 - j0 * j1 - k0 * k1");
							if (elementType != t) ss.append(")");
							ss.append(");\n");
							ss.append("return this;");
							
							stream.append(indent(buildMethod("public", interfaceName, "multiply", getType(t, true) + " q", ss.toString()), 1));
						}
						stream.append("\n");
						
						//rotate
						for (ElementType t : ElementType.floatingValues())
						{
							stream.append(indent(buildMethod("public", Vector.getType(3, t, false), "rotate", Vector.getType(3, t, false) + " v", buildDelegateReturnBody("VectorMath.rotate", "this, v")), 1));
						}
						stream.append("\n");
						
						//getters
						for (int k = 0; k < 4; k++)
						{
							stream.append(indent(buildMethod("public", elementType.typeName, "get" + componentsNames[k].toUpperCase(), "", buildDelegateReturnBody(componentsNames[k], "")), 1));
							stream.append(indent(buildMethod("public", elementType.typeName, componentsNames[k], "", "return " + Vector.componentsNames[k] + "();"), 1));
						}
						stream.append("\n");
						
						//setters
						for (int k = 0; k < 4; k++)
						{
							stream.append(indent(buildMethod("public", interfaceName, "set" + componentsNames[k].toUpperCase(), buildComponentParams(k, 1 + k, elementType), buildDelegateReturnBody(componentsNames[k], componentsNames[k])), 1));
							stream.append(indent(buildMethod("public", interfaceName, componentsNames[k], buildComponentParams(k, 1 + k, elementType), buildDelegateReturnBody(Vector.componentsNames[k], componentsNames[k])), 1));
						}
						stream.append("\n");
						
						//overrides
						genOverrides(stream, 4, elementType, false, interfaceName, true);
						
						//toString
						stream.append(indent(buildMethod("public", "String", "toString", "", buildToStringBody(interfaceName, 4)), 1));
						
						stream.append(buildClassFooter());
					}
				}
			}
			
			class ReadOnly {
				
				void gen(Path parent) throws IOException
				{
					Path packageDir = parent.resolve(READ_ONLY_PACKAGE_NAME);
					Files.createDirectories(packageDir);
					
					for (ElementType t : ElementType.floatingValues())
					{
						genReadOnly(packageDir, t);
					}
				}
				
				void genReadOnly(Path directory, ElementType elementType) throws IOException
				{
					String interfaceName = "Quaternion" + elementType.prefix + "r";
					String vectorClazzName = "ReadOnly" + Vector.getType(4, elementType, false);
					String clazzName = "ReadOnlyQuaternion" + elementType.prefix;
					try (PrintStream stream = new PrintStream(Files.newOutputStream(directory.resolve(clazzName + ".java"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)))
					{
						//NOTE: QUATERNION READ ONLY
						StringBuilder imports = new StringBuilder();
						imports.append(buildImport(VECTOR_READ_ONLY_PACKAGE, vectorClazzName));
						imports.append(buildImport(PACKAGE_ROOT, "VectorMath"));
						for (ElementType t : ElementType.floatingValues())
						{
							imports.append(buildImport(VECTOR_PACKAGE, Vector.getType(3, t, false)));
						}
						for (ElementType t : ElementType.floatingValues())
						{
							imports.append(buildImport(QUATERNION_PACKAGE, "Quaternion" + t.prefix + "r"));
						}
						stream.append(buildClassHeader(QUATERNION_READ_ONLY_PACKAGE, imports.toString(), null, clazzName, vectorClazzName, interfaceName));
						
						//constructors
						stream.append(indent(buildCostructor("public", clazzName, buildComponentParams(0, 4, elementType), buildDelegateBody("super", buildComponentArgs(0, 4))), 1));
						
						for (ElementType t : ElementType.floatingValues())
						{
							stream.append(indent(buildCostructor("public", clazzName, getType(t, true) + " q", buildDelegateBody("this", buildDelegateArgs(0, 4, elementType, t, "q", true, componentsNames))), 1));
						}
						stream.append("\n");
						
						//rotate
						for (ElementType t : ElementType.floatingValues())
						{
							stream.append(indent(buildMethod("public", Vector.getType(3, t, false), "rotate", Vector.getType(3, t, false) + " v", buildDelegateReturnBody("VectorMath.rotate", "this, v")), 1));
						}
						stream.append("\n");
						//getters
						for (int k = 0; k < 4; k++)
						{
							stream.append(indent(buildMethod("public", elementType.typeName, "get" + componentsNames[k].toUpperCase(), "", buildDelegateReturnBody(componentsNames[k], "")), 1));
							stream.append(indent(buildMethod("public", elementType.typeName, componentsNames[k], "", "return " + Vector.componentsNames[k] + "();"), 1));
						}
						//toString
						stream.append(indent(buildMethod("public", "String", "toString", "", buildToStringBody(interfaceName, 4)), 1));
						
						stream.append(buildClassFooter());
					}
				}
			}
		}
		
		class ReadOnly {
			
			void gen(Path parent) throws IOException
			{
				Path packageDir = parent.resolve(READ_ONLY_PACKAGE_NAME);
				Files.createDirectories(packageDir);
				
				record Key(int k, @Nullable ElementType t) {}
				
				Map<Key, Supplier<String>> extras = new HashMap<>();
				extras.put(new Key(3, null), () -> "");
				
				for (int k : nonZeroMinorKeys(4))
				{
					for (ElementType t : ElementType.values())
					{
						genReadOnly(packageDir, k, t, extras.get(new Key(k, t)));
					}
				}
			}
			
			void genReadOnly(Path directory, int components, ElementType elementType, Supplier<String> extra) throws IOException
			{
				String interfaceName = "Vector" + components + elementType.prefix;
				String abstractName = "Abstract" + interfaceName;
				String clazzName = "ReadOnly" + interfaceName;
				try (PrintStream stream = new PrintStream(Files.newOutputStream(directory.resolve(clazzName + ".java"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)))
				{
					//TODO: VECTOR READ ONLY
					stream.append(buildClassHeader(VECTOR_READ_ONLY_PACKAGE, buildImports(components, elementType), null, clazzName, abstractName, null));
					
					stream.append(indent("public static final " + clazzName + " ZERO = new " + clazzName + "(" + "0, ".repeat(components).substring(0, 3 * components - 2) + ");\n", 1));
					if (components == 4) stream.append(indent("public static final " + clazzName + " PROJECTIVE_ZERO = new " + clazzName + "(0, 0, 0, 1);\n", 1));
					stream.append("\n");
					for (int k = 0; k < components; k++)
					{
						stream.append(indent(buildField("protected final", elementType.typeName, componentsNames[k]), 1));
					}
					stream.append("\n");
					
					//constructors
					for (int k : minorKeys(components)) for (ElementType t : ElementType.values())
					{
						String typeName = getType(k, t, true);
						String params;
						String args;
						if (k == 0)
						{
							params = buildComponentParams(components, t);
							args = buildDelegateArgs(components, elementType, t, null, true);
						}
						else if (k < components)
						{
							params = typeName + " vector, " + buildComponentParams(k, components, t);
							args = buildDelegateArgs(k, elementType, t, "vector") + ", " + buildDelegateArgs(k, components, elementType, t, null);
						}
						else
						{
							params = typeName + " vector";
							args = buildDelegateArgs(components, elementType, t, "vector");
						}
						if (elementType.isIntegerType() && !t.isIntegerType())
						{
							params += ", RoundingMode roundingMode";
						}
						if (k == 0 && t == elementType)
						{
							stream.append(indent(buildCostructor("public", clazzName, params, buildCopyCostructorBody(componentsNames, 0, components)), 1));
						}
						else
						{
							stream.append(indent(buildCostructor("public", clazzName, params, "this(" + args + ");"), 1));
						}
					}
					stream.append("\n");
					//getters
					for (int k = 0; k < components; k++)
					{
						String name = componentsNames[k];
						stream.append(indent(buildMethod("public", elementType.typeName, name, "", "return " + name + ";"), 1));
					}
					//toString
					stream.append(indent(buildMethod("public", "String", "toString", "", buildToStringBody(interfaceName + "r", components)), 1));
					
					stream.append(buildClassFooter());
				}
			}
			
			String buildImports(int components, ElementType elementType)
			{
				StringBuilder ss = new StringBuilder();
				if (elementType.isIntegerType()) ss.append("import java.math.RoundingMode;\n");
				if (elementType.isIntegerType()) ss.append(buildStaticImport(PACKAGE_ROOT, "Math"));
				ss.append(buildImportAbstractVector(components, elementType));
				for (int k : nonZeroMinorKeys(components))
				{
					for (ElementType t : ElementType.values())
					{
						ss.append(buildImportReadInterfaceVector(k, t));
					}
				}
				return ss.substring(0, ss.length() - 1);
			}
		}
		
		class Mutable {
			
			void gen(Path parent) throws IOException
			{
				Path packageDir = parent.resolve(MUTABLE_PACKAGE_NAME);
				Files.createDirectories(packageDir);
				
				record Key(int k, @Nullable ElementType t) {}
				
				Map<Key, Supplier<String>> extras = new HashMap<>();
				extras.put(new Key(3, null), () -> "");
				
				for (int k : nonZeroMinorKeys(4))
				{
					for (ElementType t : ElementType.values())
					{
						genMutable(packageDir, k, t, extras.get(new Key(k, t)));
					}
				}
			}
			
			void genMutable(Path directory, int components, ElementType elementType, Supplier<String> extra) throws IOException
			{
				String interfaceName = "Vector" + components + elementType.prefix;
				String abstractName = "Abstract" + interfaceName;
				String clazzName = "Mutable" + interfaceName;
				try (PrintStream stream = new PrintStream(Files.newOutputStream(directory.resolve(clazzName + ".java"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)))
				{
					//TODO: VECTOR MUTABLE
					stream.append(buildClassHeader(VECTOR_MUTABLE_PACKAGE, buildImports(components, elementType), null, clazzName, abstractName, interfaceName));
					
					for (int k = 0; k < components; k++)
					{
						stream.append(indent(buildField("protected", elementType.typeName, componentsNames[k]), 1));
					}
					stream.append("\n");
					
					//constructors
					for (int k : minorKeys(components)) for (ElementType t : ElementType.values())
					{
						String typeName = getType(k, t, true);
						String params;
						String args;
						if (k == 0)
						{
							params = buildComponentParams(components, t);
							args = buildDelegateArgs(components, elementType, t, null, true);
						}
						else if (k < components)
						{
							params = typeName + " vector, " + buildComponentParams(k, components, t);
							args = buildDelegateArgs(k, elementType, t, "vector") + ", " + buildDelegateArgs(k, components, elementType, t, null);
						}
						else
						{
							params = typeName + " vector";
							args = buildDelegateArgs(components, elementType, t, "vector");
						}
						if (elementType.isIntegerType() && !t.isIntegerType())
						{
							params += ", RoundingMode roundingMode";
						}
						if (k == 0 && t == elementType)
						{
							stream.append(indent(buildCostructor("public", clazzName, params, buildCopyCostructorBody(componentsNames, 0, components)), 1));
						}
						else
						{
							stream.append(indent(buildCostructor("public", clazzName, params, "this(" + args + ");"), 1));
						}
					}
					stream.append("\n");
					for (int k : Vector.nonZeroMinorKeys(components)) for (Vector.ElementType t : Vector.ElementType.values())
					{
						// vector op vector
						for (String opName : new String[] {"+add", "-subtract", "*multiply", "/divide"})
						{
							String name = opName.substring(1);
							char op = opName.charAt(0);
							
							{
								String params = getType(k, t, true) + " vector";
								if (elementType.isIntegerType() && !t.isIntegerType()) params += ", RoundingMode roundingMode";
								String delegateArgs = buildDelegateArgs(0, k, elementType, t, "vector");
								
								stream.append(indent(buildMethod("public", interfaceName, name, params, buildDelegateReturnBody(name, delegateArgs)), 1));
							}
							
							if (elementType == t || elementType == t.floatingPointType()) stream.append(indent(buildMethod("public", interfaceName, name, buildComponentParams(k, t), buildApplyOperation(k, op)), 1));
							else if (elementType.floatingPointType() == t) stream.append(indent(buildMethod("public", interfaceName, name, buildComponentParams(k, t, "RoundingMode roundingMode"), buildDelegateReturnBody(name, buildDelegateArgs(components, elementType, t, null))), 1));
							stream.append("\n");
						}
						if (components >= 3 && k == 3)
						{
							String name = "crossProduct";
							
							{
								String params = getType(k, t, true) + " vector";
								if (elementType.isIntegerType() && !t.isIntegerType()) params += ", RoundingMode roundingMode";
								String delegateArgs = buildDelegateArgs(0, k, elementType, t, "vector");
								
								stream.append(indent(buildMethod("public", interfaceName, name, params, buildDelegateReturnBody(name, delegateArgs)), 1));
							}

							StringBuilder ss = new StringBuilder();
							for (int l = 0; l < 3; l++)
							{
								ss.append(elementType.typeName).append(" ").append(componentsNames[l]).append("0 = ")
									.append("this.").append(componentsNames[(l + 1) % 3]).append(" * ").append(componentsNames[(l + 2) % 3]).append(" - ")
									.append("this.").append(componentsNames[(l + 2) % 3]).append(" * ").append(componentsNames[(l + 1) % 3]).append(";\n");
							}
							for (int l = 0; l < 3; l++)
							{
								ss.append("this.").append(componentsNames[l]).append(" = ").append(componentsNames[l]).append("0;\n");
							}
							ss.append("return this;");
							if (elementType == t || elementType == t.floatingPointType()) stream.append(indent(buildMethod("public", interfaceName, name, buildComponentParams(k, t), ss.toString()), 1));
							else if (elementType.floatingPointType() == t) stream.append(indent(buildMethod("public", interfaceName, name, buildComponentParams(k, t, "RoundingMode roundingMode"), buildDelegateReturnBody(name, buildDelegateArgs(k, elementType, t, null))), 1));
							stream.append("\n");
						}
						if (components == 4 && k == 4)
						{
							String name = "projectiveCrossProduct";
							
							{
								String params = getType(k, t, true) + " vector";
								if (elementType.isIntegerType() && !t.isIntegerType()) params += ", RoundingMode roundingMode";
								String delegateArgs = buildDelegateArgs(0, k, elementType, t, "vector");
								
								stream.append(indent(buildMethod("public", interfaceName, name, params, buildDelegateReturnBody(name, delegateArgs)), 1));
							}

							StringBuilder ss = new StringBuilder();
							for (int l = 0; l < 3; l++)
							{
								ss.append(elementType.typeName).append(" ").append(componentsNames[l]).append("0 = ")
									.append("this.").append(componentsNames[(l + 1) % 3]).append(" * ").append(componentsNames[(l + 2) % 3]).append(" - ")
									.append("this.").append(componentsNames[(l + 2) % 3]).append(" * ").append(componentsNames[(l + 1) % 3]).append(";\n");
							}
							for (int l = 0; l < 3; l++)
							{
								ss.append("this.").append(componentsNames[l]).append(" = ").append(componentsNames[l]).append("0;\n");
							}
							ss.append("this.").append(componentsNames[3]).append(" *= ").append(componentsNames[3]).append(";\n");
							ss.append("return this;");
							if (elementType == t || elementType == t.floatingPointType()) stream.append(indent(buildMethod("public", interfaceName, name, buildComponentParams(k, t), ss.toString()), 1));
							else if (elementType.floatingPointType() == t) stream.append(indent(buildMethod("public", interfaceName, name, buildComponentParams(k, t, "RoundingMode roundingMode"), buildDelegateReturnBody(name, buildDelegateArgs(components, elementType, t, null))), 1));
							stream.append("\n");
						}
						//setters
						{
							String args = getType(k, t, true) + " vector";
							if (elementType.isIntegerType() && !t.isIntegerType()) args += ", RoundingMode roundingMode";
							stream.append(indent(buildMethod("public", interfaceName, "setAll", args, buildDelegateSetBody(k, elementType, t, "vector")), 1));
						}
					}
					//transformations
					StringBuilder ss = new StringBuilder(50);
					for (int k = 0; k < components; k++) ss
						.append(componentsNames[k])
						.append(" = -").append(componentsNames[k])
						.append(";\n");
					ss.append("return this;");
					stream.append(indent(buildMethod("public", interfaceName, "opposite", "", ss.toString()), 1));
					ss.setLength(0);
					for (int k = 0; k < components; k++) ss
						.append(componentsNames[k])
						.append(" = abs(").append(componentsNames[k])
						.append(");\n");
					ss.append("return this;");
					stream.append(indent(buildMethod("public", interfaceName, "absolute", "", ss.toString()), 1));
					ss.setLength(0);
					for (int k = 1; k < components; k++) ss
						.append(componentsNames[k])
						.append(" = -").append(componentsNames[k])
						.append(";\n");
					ss.append("return this;");
					stream.append(indent(buildMethod("public", interfaceName, "conjugate", "", ss.toString()), 1));
					ss.setLength(0);
					if (elementType.isIntegerType())
					{
						ss.append(elementType.typeName).append(" a = abs(x()), b;\n");
						ss.append("int").append(" i = 0;\n");
						for (int k = 1; k < components; k++) ss
							.append("b = abs(")
							.append(Vector.componentsNames[k])
							.append("());\n")
							.append("if (a < b)\n")
							.append("{\n")
							.append("\ta = b;\n")
							.append("\ti = ").append(k).append(";\n")
							.append("}\n");
						ss.append("switch (i)\n")
							.append("{\n");
						for (int k = 0; k < components; k++)
						{
							ss.append("\tcase ").append(k).append(" -> {\n");
							for (int l = 0; l < components; l++)
							{
								if (l != k) ss.append("\t\t").append(componentsNames[l]).append(" = 0;\n");
								else ss.append("\t\t").append(componentsNames[l]).append(" /= a;\n");
							}
							ss.append("\t}\n");
						}
						ss.append("}\n");
						
						ss.append("return this;");
						stream.append(indent(buildMethod("public", interfaceName, "normalize", "", ss.toString()), 1));
						ss.setLength(0);
					}
					else
					{
						stream.append(indent(buildMethod("public", interfaceName, "normalize", "", buildDelegateReturnBody("divideAll", "length()")), 1));
					}
					stream.append(indent(buildMethod("public", interfaceName, "unitary", "", buildDelegateReturnBody("normalize", "")), 1));
					stream.append("\n");
					
					// vector opAll
					for (String name : new String[] {"add", "subtract", "multiply", "divide"})
					{
						String nameAll = name + "All";
						String delegateArgs = buildSpreadArgs(components, "value");
						if (elementType.isIntegerType()) stream.append(indent(buildMethod("public", interfaceName, nameAll, elementType.floatingPointType().typeName + " value, RoundingMode roundingMode", buildDelegateReturnBody(name, delegateArgs, "roundingMode")), 1));
						else stream.append(indent(buildMethod("public", interfaceName, nameAll, elementType.integerType().typeName + " value", buildDelegateReturnBody(name, delegateArgs)), 1));
						stream.append(indent(buildMethod("public", interfaceName, nameAll, elementType.typeName + " value", buildDelegateReturnBody(name, delegateArgs)), 1));
					}
					stream.append("\n");
					//getters
					for (int k = 0; k < components; k++)
					{
						String name = componentsNames[k];
						stream.append(indent(buildMethod("public", elementType.typeName, name, "", "return " + name + ";"), 1));
					}
					//setters
					for (int k = 0; k < components; k++)
					{
						String name = componentsNames[k];
						stream.append(indent(buildMethod("public", interfaceName, "set" + name.toUpperCase(), elementType.typeName + " " + name, buildDelegateReturnBody(name, name)), 1));
						stream.append(indent(buildMethod("public", interfaceName, name, elementType.typeName + " " + name, "this." + name + " = " + name + ";\nreturn this;"), 1));
					}
					for (int k : nonZeroMinorKeys(components))
					{
						stream.append(indent(buildMethod("public", interfaceName, "setAll", buildComponentParams(k, elementType), buildDelegateSetBody(k, elementType, elementType, null)), 1));
					}
					//toString
					stream.append(indent(buildMethod("public", "String", "toString", "", buildToStringBody(interfaceName, components)), 1));
					
					stream.append(buildClassFooter());
				}
			}
			
			String buildImports(int components, ElementType elementType)
			{
				StringBuilder ss = new StringBuilder();
				if (elementType.isIntegerType()) ss.append("import java.math.RoundingMode;\n");
				ss.append(buildStaticImport(PACKAGE_ROOT, "Math"));
				ss.append(buildImportAbstractVector(components, elementType));
				ss.append(buildImportInterfaceVector(components, elementType));
				for (int k : nonZeroMinorKeys(components))
				{
					for (ElementType t : ElementType.values())
					{
						ss.append(buildImportReadInterfaceVector(k, t));
					}
				}
				return ss.substring(0, ss.length() - 1);
			}
		}
		
		class Axis {
			
			void gen(Path parent) throws IOException
			{
				Path packageDir = parent.resolve(AXIS_PACKAGE_NAME);
				Files.createDirectories(packageDir);
				
				record Key(int k, @Nullable ElementType t) {}
				
				Map<Key, Supplier<String>> extras = new HashMap<>();
				extras.put(new Key(3, null), () -> "");
				
				for (ElementType t : ElementType.values())
				{
					genAbstract(packageDir, t);
				}
			}
			
			void genAbstract(Path directory, ElementType elementType) throws IOException
			{
				String abstractClazzName = "AbstractVector4" + elementType.prefix;
				String readOnlyInterfaceName = "Vector4" + elementType.prefix + "r";
				String clazzName = "Axis" + elementType.prefix;
				try (PrintStream stream = new PrintStream(Files.newOutputStream(directory.resolve(clazzName + ".java"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)))
				{
					//NOTE: AXIS
					StringBuilder imports = new StringBuilder();
					imports.append(buildImport("java.util", "Locale"));
					imports.append(buildImport("org.jspecify.annotations", "Nullable"));
					imports.append(buildImport(VECTOR_PACKAGE, abstractClazzName));
					imports.append(buildImport(VECTOR_PACKAGE, readOnlyInterfaceName));
					stream.append(buildHeader(AXIS_PACKAGE, imports.toString(), null, "public final", "class", clazzName, null, null));
					stream.append(indent("""
						public static final X X = new X();
						public static final NX NEGATIVE_X = new NX();
						public static final Y Y = new Y();
						public static final NY NEGATIVE_Y = new NY();
						public static final Z Z = new Z();
						public static final NZ NEGATIVE_Z = new NZ();
						public static final W W = new W();
						public static final NW NEGATIVE_W = new NW();
						
						static @Nullable %1$s valueOf(String name)
						{
							return switch (name.toLowerCase(Locale.ROOT))
							{
								case "x" -> X;
								case "y" -> Y;
								case "z" -> Z;
								case "w" -> W;
								case "-x" -> NEGATIVE_X;
								case "-y" -> NEGATIVE_Y;
								case "-z" -> NEGATIVE_Z;
								case "-w" -> NEGATIVE_W;
								default -> null;
							};
						}
						
						/**
						 * Returns an array containing the value of every <code>Axis</code> in this interface in the order: X, -X, Y, -Y, Z, -Z, W, -W
						 *
						 * @return an array of <code>Axis</code>
						 */
						static %1$s[] values()
						{
							return new %1$s[] {X, NEGATIVE_X, Y, NEGATIVE_Y, Z, NEGATIVE_Z, W, NEGATIVE_W};
						}
						
						/**
						 * Returns an array containing the value of every positive <code>Axis</code> in this interface in the order: X, Y, Z, W
						 *
						 * @return an array of <code>Axis</code>
						 */
						static %1$s[] positiveValues()
						{
							return new %1$s[] {X, Y, Z, W};
						}
						
						/**
						 * Returns an array containing the value of every negative <code>Axis</code> in this interface in the order: -X, -Y, -Z, -W
						 *
						 * @return an array of <code>Axis</code>
						 */
						static %1$s[] negativeValues()
						{
							return new %1$s[] {NEGATIVE_X, NEGATIVE_Y, NEGATIVE_Z, NEGATIVE_W};
						}
						""".formatted(readOnlyInterfaceName), 1));
					stream.append("\n");
					
					String[] names = new String[] {"X", "Y", "Z", "W"};
					for (int k = 0; k < 4; k++)
					{
						stream.append(indent("public static final class " + names[k] + " extends " + abstractClazzName + " implements " + readOnlyInterfaceName + " {\n\n", 1));
						for (int l = 0; l < 4; l++)
						{
							stream.append(indent("""
								@Override
								public %1$s %2$s()
								{
									return %3$s;
								}
								""".formatted(elementType.typeName, Vector.componentsNames[l], l == k ? 1 : 0), 2));
						}
						//toString
						stream.append(indent(buildMethod("public", "String", "toString", "", "return \"Axis{" + names[k] + "}\";"), 2));
						
						stream.append(indent(buildClassFooter(), 1));
						stream.append("\n");
						stream.append(indent("public static final class N" + names[k] + " extends " + abstractClazzName + " implements " + readOnlyInterfaceName + " {\n\n", 1));
						for (int l = 0; l < 4; l++)
						{
							stream.append(indent("""
								@Override
								public %1$s %2$s()
								{
									return %3$s;
								}
								""".formatted(elementType.typeName, Vector.componentsNames[l], l == k ? -1 : 0), 2));
						}
						//toString
						stream.append(indent(buildMethod("public", "String", "toString", "", "return \"Axis{-" + names[k] + "}\";"), 2));
						
						stream.append(indent(buildClassFooter(), 1));
						stream.append("\n");
					}
					
					stream.append(buildClassFooter());
				}
			}
			
			String buildImports(int components, ElementType elementType)
			{
				StringBuilder ss = new StringBuilder();
				if (elementType.isIntegerType()) ss.append("import java.math.RoundingMode;\n");
				ss.append(buildStaticImport(PACKAGE_ROOT, "Math"));
				ss.append(buildImportAbstractVector(components, elementType));
				ss.append(buildImportInterfaceVector(components, elementType));
				for (int k : nonZeroMinorKeys(components))
				{
					for (ElementType t : ElementType.values())
					{
						ss.append(buildImportReadInterfaceVector(k, t));
					}
				}
				return ss.substring(0, ss.length() - 1);
			}
		}
	}
	
	public static String buildImport(String packageName, String className)
	{
		return "import " + packageName + "." + className + ";\n";
	}
	
	public static String buildStaticImport(String packageName, String className)
	{
		return "import static " + packageName + "." + className + ".*;\n";
	}
	
	public static String buildInterfaceHeader(String packageName, String imports, @Nullable String javadoc, String name, @Nullable String extendClasses)
	{
		return buildHeader(packageName, imports, javadoc, "public", "interface", name, extendClasses, null, null);
	}
	
	public static String buildClassHeader(String packageName, String imports, @Nullable String javadoc, String name, @Nullable String extendClasses, @Nullable String implementClasses)
	{
		return buildHeader(packageName, imports, javadoc, "public", "class", name, extendClasses, implementClasses, null);
	}
	
	public static String buildAbstractHeader(String packageName, String imports, @Nullable String javadoc, String name, @Nullable String extendClasses, @Nullable String implementClasses)
	{
		return buildHeader(packageName, imports, javadoc, "public abstract", "class", name, extendClasses, implementClasses, null);
	}
	
	public static String buildEnumHeader(String packageName, String imports, @Nullable String javadoc, String name, @Nullable String implementClasses)
	{
		return buildHeader(packageName, imports, javadoc, "public", "enum", name, null, implementClasses, null);
	}
	
	public static String buildHeader(String packageName, String imports, @Nullable String javadoc, String visibility, String type, String name, @Nullable String extendClasses, @Nullable String implementClasses)
	{
		return buildHeader(packageName, imports, javadoc, visibility, type, name, extendClasses, implementClasses, null);
	}
	
	public static String buildHeader(String packageName, String imports, @Nullable String javadoc, String visibility, String type, String name, @Nullable String extendClasses, @Nullable String implementClasses, @Nullable String permitClasses)
	{
		String s0 = javadoc == null ? "" : "\n\n" + javadoc;
		String s1 = extendClasses == null ? "" : " extends " + extendClasses;
		String s2 = implementClasses == null ? "" : " implements " + implementClasses;
		String s3 = permitClasses == null ? "" : " permits " + permitClasses;
		return """
			package %1$s;
			
			%2$s%3$s
			%4$s %5$s %6$s%7$s%8$s%9$s {
			
			""".formatted(packageName, imports, s0, visibility, type, name, s1, s2, s3);
	}
	
	public static String buildFactory(String output, String name, String params, String object, String args)
	{
		return buildFactory(output, name, params, object, args, null);
	}
	
	public static String buildFactory(String output, String name, String params, String object, String args, @Nullable String compute)
	{
		if (compute != null) return """
			static %1$s %2$s(%3$s)
			{
			%6$s
				return new %4$s(%5$s);
			}
			""".formatted(output, name, params, object, args, compute);
		return """
			static %1$s %2$s(%3$s)
			{
				return new %4$s(%5$s);
			}
			""".formatted(output, name, params, object, args);
	}
	
	public static String buildParametricFactory(String types, String output, String name, String params, String object, String args)
	{
		return """
			static <%6$s> %1$s %2$s(%3$s)
			{
				return new %4$s(%5$s);
			}
			""".formatted(output, name, params, object, args, types);
	}
	
	public static String buildField(String visibility, String type, String name)
	{
		return """
			%1$s %2$s %3$s;
			""".formatted(visibility, type, name);
	}
	
	public static String buildCostructor(String visibility, String name, String params, @Nullable String body)
	{
		if (body == null) return "%1$s %2$s(%3$s) {}\n".formatted(visibility, name, params);
		return """
			%1$s %2$s(%3$s)
			{
			%4$s
			}
			""".formatted(visibility, name, params, indent(body, 1));
	}
	
	public static String buildCopyCostructorBody(String... vars)
	{
		return buildCopyCostructorBody(vars, 0, vars.length);
	}
	
	public static String buildCopyCostructorBody(String[] vars, int offset, int size)
	{
		if (vars.length == 0) return "";
		StringBuilder ss = new StringBuilder(vars.length * 20);
		for (int i = offset; i < size; i++)
		{
			ss.append("this.").append(vars[i])
				.append(" = ").append(vars[i])
				.append(";").append("\n");
		}
		return ss.substring(0, ss.length() - 1);
	}
	
	public static String swapAndMix(String s0, String s1, String j, boolean swap)
	{
		if (swap) return s1 + j + s0;
		return s0 + j + s1;
	}
	
	public static String buildDelegateReturnBody(String methodName, String args, String... extra)
	{
		StringBuilder ss = new StringBuilder();
		ss.append("return ")
			.append(methodName)
			.append("(")
			.append(args);
		for (String s : extra) ss.append(", ").append(s);
		return ss.append(");")
			.toString();
	}
	
	public static String buildDelegateBody(String methodName, String args)
	{
		StringBuilder ss = new StringBuilder();
		return ss
			.append(methodName)
			.append("(")
			.append(args)
			.append(");")
			.toString();
	}
	
	public static String buildInterfaceMethod(String resultType, String name, String params)
	{
		return """
			%1$s %2$s(%3$s);
			""".formatted(resultType, name, params);
	}
	
	public static String buildOverrideMethod(String resultType, String name, String params, String args, boolean delegate)
	{
		if (delegate) return """
			@Override
			public %1$s %2$s(%3$s)
			{
				return (%1$s) super.%2$s(%4$s);
			}
			""".formatted(resultType, name, params, args);
		return """
			@Override
			%1$s %2$s(%3$s);
			""".formatted(resultType, name, params);
	}
	
	public static String buildMethod(@Nullable String visibility, String resultType, String name, String params, String body)
	{
		if (visibility == null) return """
			%1$s %2$s(%3$s)
			{
			%4$s
			}
			""".formatted(resultType, name, params, indent(body, 1));
		return """
			%4$s %1$s %2$s(%3$s)
			{
			%5$s
			}
			""".formatted(resultType, name, params, visibility, indent(body, 1));
	}
	
	public static String buildStaticMethod(String resultType, String name, String params, String body)
	{
		return """
			public static %1$s %2$s(%3$s)
			{
			%4$s
			}
			""".formatted(resultType, name, params, indent(body, 1));
	}
	
	public static String buildClassFooter()
	{
		return "}";
	}
	
	public static Path packageToPath(String packageName)
	{
		return Path.of(packageName.replaceAll("\\.", "/"));
	}
	
	@SuppressWarnings("null")
	public static String indent(String s, int n)
	{
		if (s.isEmpty()) return "";
		if (n <= 0) return s;
		boolean blankNewLine = s.endsWith("\n");
		String spaces = "\t".repeat(n);
		return s.lines().map(s0 -> spaces + s0).collect(Collectors.joining("\n", "", blankNewLine ? "\n" : ""));
	}
}
