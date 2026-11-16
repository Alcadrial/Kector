# Kector

A Java math library to manage vectors, matrices, quaternions and more, with a focus on computer graphics and a complex interface hierarcy
to simplify management of different implementations and reduce one-time allocations.

The code is divided 4 sources:
- Generation code (/src/gen/java): A single file that generate code of vectors, quaternions and a shared VectorMath class to reduce duplicated code
- Generated code (/src/out/java): Vectors, quaternions and all their hierarchy
- Hand-writter code (/src/main/java): Mainly matrices (currently only Matrix4f), complex numbers and shapes
- Test code (/src/test/java): Currently only one test for Matrix4f

Classes are named based on their implementation in the format
`<DataType><PrimitiveType><Dimensions><ReadOnly>` where `<PrimitiveType>` is the first letter
of one of int, long, float or double, `<Dimensions>` if meaningful is a number of 2, 3 or 4
and `<ReadOnly>` is an 'r' that may not be present that indicates if the implementation is immutable
(read only), for example Vector4f is a 4-dimensional vector of floats that is mutable and
has mutating methods, instead Vector3lr is a 3-dimensional vector of longs that is immutable, another example
Quaterniond is a mutable Quaternion that uses doubles to memorize it's state. This
differentation is useful to specify what an api call is allowed to do with a given object.

Other utilities are also present:
- Annotations: Used to specify some characteristics of methods return values and parameters in place of a runtime check
- Math: An extension of the java util class Math
- AngleUnit: Util class to manage angles convertions and in combination with @Angle to specify the expected unit of a parameter or return value
- Shape: A collection of classes to represent simple shapes currently only for 3D floats
- Direction1f: A simple positive/negative Enum

# Build
To build the library just run:
```bash
./gradlew build
```
to publish to a maven repo instead:
```bash
./gradlew publish
```
The resulting jar contains only code from /src/out/java and /src/main/java
