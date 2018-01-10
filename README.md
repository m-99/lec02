# 6.178 Lecture #2 - Variables, Methods, Strings, Enums, and Arrays

## Announcements
* Syllabus and class schedule have been posted to [Stellar](http://stellar.mit.edu/S/course/6/ia18/6.178/).
* Concerns? Anonymous feedback: http://bit.ly/6178feedback
* Problem Set 1 out tonight.

### Last Time
* Set up tools, import into Eclipse, simple Java, basic Git usage
* Review [Git commit and push](https://github.mit.edu/6178-2018/lec1#git-commit-and-push)

### Clone this Repo
* Open Terminal or Git Bash.
* Go into your 6.178 directory: for example, `cd ~/Documents/6.178`
* Run: `git clone git@github.mit.edu:6178-2018/lec2.git`
  * Issues? [Review SSH key setup](https://github.mit.edu/6178-2018/lec1#github).
  * Alternatives: `git clone https://github.mit.edu/6178-2017/lec2.git`, or use [personal access tokens](https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line/)

Unlike Lecture 1, you will not need to create or push to your own repo for lecture exercises from now on. Instead, we will install a new tool for Eclipse which allows you to *pair program* in class, and will automatically record your work online for the staff to check. You will also use this tool in 6.031.

### Install Constellation
* Go to [https://constellation.csail.mit.edu/](https://constellation.csail.mit.edu/)
* Click "Install the Constellation plug-in". Open up Eclipse and follow the instructions.
* Once Eclipse has restarted, you should see a "Collaborate" button along the bottom.
* Click "Collaborate", select "lec2", and click "OK".
* In the browser: if you wish to collaborate with someone, type in their joincode. If you wish to work by yourself, type in your own joincode.
* To verify your connection: type something in `Main.java`, and check that your work appears here: https://constellation.csail.mit.edu/edit/src/lec2/Main.java

## Methods
Methods are similar to functions in Python. They are attached to classes. For example.
```java
public class UnitConverter {

  // ... other variables and methods ...
  
  public static double fahrenheitToCelsius(double temperatureFahrenheit) {
    double ratio = 5.0 / 9.0;
    double offset = 32.0;
    return (temperatureFahrenheit - offset) * ratio;
  }

  // ... other variables and methods ...
  
}
```
A method is composed of 5 parts (in order): the modifiers, return type, method name, parameters, and the method body. (There is a 6th part, the exceptions list, which we won't talk about in this lecture.)

For the above example method:
* __modifier__ - `public`, `static`
  * `public` means the method is visible not just within this class, but to other classes in your program as well.
    * To prevent other classes from calling this method, we can make this `private`.
  * `static` means the method exists independently of any _instance_ of the class - more on that in future lectures. For now, think of it as a method that you can call directly from the `main` method.
* __return type__ - `double`
  * This means that this method returns a value of type `double`.
* __method name__ - `fahrenheitToCelsius`
  * The name of the method.
* __parameters__ - `(double temperatureFahrenheit)`
  * This method only has one parameter, but you can have multiple parameters separated by commas.
  * Parameters are declared with types, similar to variables: `<parameterType> <parameterName>`
* __method body__ - code between the curly braces
  * This code will be executed if the method is called.

To call this method from within the same class, just write the method name and provide the parameters necessary. Here we're storing the result in a `double` named `temperatureCelsius`:
```java
double temperatureCelsius = fahrenheitToCelsius(32.0); // 0.0
```

Now let's look back at the special `main` function:
```java
public class Main {

  // ... other variables and methods ...
  
  public static void main(String[] args) {
  }

  // ... other variables and methods ...
  
}
```
* __modifier__ - `public`, `static` (visible to other classes, independent of instance)
* __return type__ - `void` (special return type representing nothing returned)
* __method name__ - `main`
* __parameters__ - `(String[] args)` (a String array)
* __method body__ - the code to execute when the program runs

### Exercise: Write a method
Complete __TODO #1__ in `Main.java`.
* Create a method called `estimateRidePrice` in the same class, and allow it to take all the parameters necessary to calculate the estimated price for a ride from either Uber or Lyft.
* Modify the code in `main` to call that method instead of performing the calculations.

## Specifications
A method's __specification (or spec)__ is a set of comments attached to the method that tells the user of the program everything they need to know about the method. Specs are important for software engineers because they allow us to understand and use other people's programs _without reading the actual code_.

The job of a specification is to describe the output of the method given the inputs. If the inputs satisfy the requirements outlined in the spec, then the method will produce an output that satisfies the requirements outlined in the spec.

An example spec for the `fahrenheitToCelsius` method.
```java
/**
 * Converts the temperature in Fahrenheit to the temperature in Celsius
 * @param temperatureFahrenheit the temperature in Fahrenheit
 * @return the temperature in Celsius
 */
public static double fahrenheitToCelsius(double temperatureFahrenheit) {
  ...
}
```
The first line of the spec details what the method does in plain English. Each parameter, along with any constraints, is described in a `@param`. The return value, along with any constraints, is described in the `@return`.

### Exercise: Write a spec
Write a spec, formatted as above, for your `estimateRidePrice` method.

## More on Variables
Recall from [Lecture 1](https://github.mit.edu/6178-2018/lec1#types) that variables in Java are _statically typed_, meaning the declaration must include the type of the variable.
```java
int myAge = 23;
```

### Primitive Types
Java has a set of _primitive_ types which represent very simple data. These types are lowercased. The ones that we will deal with the most:
* `boolean` (true or false)
* `char` (single character)
* `int` (integer within ± 2^31)
* `double` (floating-point numbers)
* [a complete list](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)

You can think of primitive types as having __direct representation__ in the computer's memory. When you operate on a variable of type `int`, the data that gets shuttled around your computer's circuitry is the literal binary representation of that integer.

### Object Types
Java also has more complex types called _objects_. These types are typically uppercased. Any type which is not a primitive is an object. The simplest examples:
* [`String`](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html) (sequences of characters, like "Hello there")
* [Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html) (sequences of values of any type; more in a bit)
* [Enums](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html) (a finite set of named values; more in a bit)

Unlike primitives, which are represented as literal values in memory, variables of object types are represented as __references__ to the location of their actual data. This data has a potentially complex structure and usually takes up more space.

#### Operations on Objects
A major, practical difference between primitives and objects is that objects (defined as classes - more in future lectures) can define their own operations, accessed via `theObject.theOperation(parameters)`. For example, String has a `.length()` operation which allows you to count its number of characters. Primitives have no operations of their own - they are all pre-defined by the Java language itself (`+`, `%%`).
```java
String myName = "Richard";
int charactersInName = myName.length(); // 7
char thirdCharacterInName = myName.charAt(2); // 'c'
```

#### Comparisons: `==` vs `.equals()`
Sometimes we want to check whether two variables have the same value. For primitives, we use `==`; for objects, we use `.equals()`.
```java
int a, b;
boolean aEqualsB = a == b;
String c, d;
boolean cEqualsD = a.equals(d);
```

#### `null`
One unfortunate side effect of representing object types as references is that the reference can point to nothing - or `null`. You can't call operations on a variable whose value is `null`, since there is no object there.
```java
String myName = null;
int charactersInName = myName.length(); // Not allowed, will throw an error
```

### `final`
Variable declarations can have additional keywords attached to them. `final` is one such keyword, which means that the variable can only be assigned once. This is useful for defining constants whose values should never change.
```java
final int myAge = 21;
...
myAge = 22; // Not allowed, won't compile
```

### `static`
So far, we've dealt with variables defined within methods. We can also define variables within _classes_, outside of any method.
```java
public class Main {
    private static int counter = 0;
    
    public static int count() {
        counter++;
        return counter;
    }
}
```

The `counter` variable is visible to any method within the `Main` class. The `private` modifier means it cannot be accessed by other classes. Removing the `static` modifier would make it an _instance_ variable, which we will discuss in a future class.

#### Scope
Generally, variables can be accessed anywhere within the _closest enclosing set of curly braces {}_.
* Variables declared in a method can only be accessed within the method.
* Variables declared in a class can be accessed within the class.
  * `public` class variables can be accessed by other classes.
  * `static` vs. non-`static` has different semantics (future class).

## Arrays
Arrays represent fixed-size sequences of values. You can create arrays of any type, and they can be multidimensional:
```java
String[] months; // 1d String array
int[][] coordinates; // 2d int array
```

Since arrays are fixed-size, you have to declare its size when you assign its initial value:
```java
String[] months = new String[12];                  // months has 12 slots
char[] mit = new char[] {'I', 'H', 'T', 'F', 'P'}; // mit has 5 slots
```

You can obtain and assign values at specific indices in an array:
```java
char middleChar = mit[2]; // 'T'
mit[3] = 'P';             // mit is now IHTPP
```

In a future lecture, we will explore additional types in Java which can represent dynamically-sized sequences.

### Exercise: Create an Array
Complete __TODO #2__: create an array of type `String` called `months` with size 12. Populate each element of the array with the name of the month as a `String`.

#### A note on Aliasing
What does this do?
```java
int[] piDigits = new int[] {3, 1, 4, 1, 5, 9};
int[] myDigits = piDigits;
myDigits[3] = 7;
// What is the value of myDigits? What is the value of piDigits?
```
## Enums
Enum is a special data type that allows a variable to take on one of a predefined set of values. Each of these values is named, and is typically ALL_UPPERCASE.

An enum representing Direction:
```java
public enum Direction {
    NORTH, EAST, SOUTH, WEST
}
```

To declare a variable of type Direction:
```java
Direction direction = Direction.NORTH;
```

### Exercise: Create an Enum
Create an enum called `Day`, whose values are the days of the week. In Eclipse, select _File -> New -> Enum_. Make sure the package says `lec2`.

### Switch Statements with Enums
Recall [switch statements](https://github.mit.edu/6178-2018/lec1#switch-statements). These are most useful when dealing with Enums.
```java
Direction direction;
switch (direction) {
  case NORTH:
    System.out.println("You're heading north");
    break;
  case SOUTH:
    System.out.println("You're heading south");
    break;
  case EAST:
    System.out.println("You're heading east");
    break;
  case WEST:
    System.out.println("You're heading west");
    break;
  default:
    System.out.println("Unknown direction");
    break;
}
```
