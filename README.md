# 6.178 Lecture #2 - Variables, Methods, Strings, Enums, and Arrays

## More Logistics
* [Instructions on Cloning & Submitting Psets](https://github.mit.edu/6178-2017/pset-instructions)
* You will be given a suite of tests but there are also a suite of hidden tests that staff will use to give you additional feedback. You will not be penalized if you do not pass the hidden suite of tests.
* You will pass the pset if you pass all the tests that were given to you.
* You can review the [Syllabus](https://stellar.mit.edu/S/course/6/ia17/6.178/courseMaterial/topics/topic1/syllabus/Syllabus/Syllabus.pdf) on Stellar for more information.
* We have a schedule of our classes on Stellar [here](https://stellar.mit.edu/S/course/6/ia17/6.178/courseMaterial/topics/topic1/resource/Schedule_(1)/Schedule_(1).pdf)
* If you didn't get a repo for pset #1, please let us know by filling out [this Google form](https://goo.gl/forms/TDHtVW5f3ncpWImE2).
* Please sign up for the [Piazza](https://piazza.com/class/ixbeg17oz79vm) to get updated on pset revisions and other things.

### Clone this Repo

* Open Terminal or Git Bash.
* Go into your 6.178 directory: for example, `cd ~/Documents/6.178`
* Run: `git clone git@github.mit.edu:6178-2018/lec2.git`
  * If that didn't work, try `git clone https://github.mit.edu/6178-2017/lec2.git`.
  * You should not need to put in your username or password if you setup your SSH keys correctly.
  * If you did not set up your SSH keys, refer to [Lecture 1](https://github.mit.edu/6178-2018/lec1#github).
* `cd lec2`

Unlike Lecture 1, you will not need to create your own repo for lecture exercises from now on. Instead, we will install a new tool for Eclipse which allows you to *pair program* in class, and will automatically record your work online for the staff to check.

### Install Constellation

* Go to [https://constellation.csail.mit.edu/](https://constellation.csail.mit.edu/)
* Click "Install the Constellation plug-in". Open up Eclipse and follow the instructions.
* Once Eclipse has restarted, you should see a "Collaborate" button along the bottom.

TODO Blurb about how to use, whether we require partners, etc

## Variables

## Methods
Methods are similar to functions in Python. Let's look at this example below.

```
public static double fahrenheitToCelsius(double tempFahrenheit) {
  double tempCelsius;
  tempCelsius = (tempFahrenheit - 32.0) * 5.0 / 9.0;
  return tempCelsius;
}
```
A method is composed of 6 parts (in order): the modifiers, return type, method name, parameters, an exception list (we'll discuss this in a later lecture), and the method body.

For the above example method:

* __modifier__ - `public`, `static`
  * `public` means the method is visible to the "world" (not just visible to the class itself).
  * `static` means the method exists independently of any instance of the class. Usually only uses variables given as parameters and not instance variables.
  * You'll learn more about these modifiers in a future lecture about classes.
* __return type__ - `double`
  * This means that this method returns a variable of type `double`.
* __method name__ - `fahrenheitToCelsius`
  * The name of the method must be unique to the class to prevent __overloading__.
  * __Overloading__ means that two methods have the same method name but different parameters. You can read more about them [here](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
* __parameters__ - `(double temperatureFahrenheit)`
  * This method only has one parameter, but you can have as many parameters as you want in methods.
  * parameters must be declared as `<parameterType> <parameterName>`
* __exception list__ - N/A
  * This method doesn't have an exception list so don't worry about this. We'll discuss exceptions in a future lecture.
* __method body__ - anything in between the curly braces
  * Any code between the curly braces of the method will be executed if the method is called. 

To call this method, just write the method name and provide the parameters necessary. Here we're storing the result in a `double` named `tempCelsius`:
```
double tempCelsius = fahrenheitToCelsius(32.0); // should be 0.0
```

Now with our knowledge of methods and how they are written, how is the special `main` function written?

```
public static void main(String[] args) {
}
```
* __modifier__ - `public`, `static`
* __return type__ - `void`
* __method name__ - `main`
* __parameters__ - `(String[] args)`

### Exercise 1: Write the `estimateRidePrice` method.
__TODO:__ In your personal `lec2-<kerberos>` repo, modify lines 20 & 21 in `Main.java` where we assign `uberPrice` and `lyftPrice` so that we abstract this calculation away into a method. To do this, create a method called `estimateRidePrice`. Allow this method to take all the parameters necessary to calculate the estimated price for an Uber and for a Lyft.

## Specifications
We won't go into depth with specifications, but you can read more about them [here](http://web.mit.edu/6.005/www/fa16/classes/06-specifications/specs/). __Specifications (or specs)__ is a set of comments before a method that tells people all they need to know about the method. Specs are important for software engineers because they allow us to read about what a method does _without actually reading the code_. Specs should have enough information for anyone to understand what the method does and should give enough wiggle room for an engineer to implement the method.

Specs solidify inputs and outputs to a method. If inputs to the method satisfy the requirements outlined in the specs, then the method will guarantee an output that satisfies the requirements outlined in the specs.

Below is an example of a spec for the same `fahrenheitToCelsius` method.

```
/**
* Converts the temperature in Fahrenheit to the temperature in Celsius
* @param tempFahrenheit the temperature in Fahrenheit
* @return the temperature in Celsius
*/
public static double fahrenheitToCelsius(double tempFahrenheit) {
  double tempCelsius;
  tempCelsius = (tempFahrenheit - 32.0) * 5.0 / 9.0;
  return tempCelsius;
}
```
The first line of the spec details what the method does in plain English. `@param` tells us the name of the parameter and what it is in plain English. `@return` tells us what the method will return in plain English.

### Exercise 2: Add specs to your `estimateRidePrice` method.
__TODO:__ Write some specs for your `estimateRidePrice` method. Be sure to write out all the parts of the spec.

## Switch Statements
Switch statements are similar to if statements but is a shorter form. There is a special `default` case after all the other cases. Each case has to end with a `break;` statement.

```
String monthString;
switch (month) {
  case 1:
    monthString = "January";
    break;
  case 2:
    monthString = "February";
    break;
  // More case statements for the rest of the month...
  default:
    monthString = "Invalid Month";
    break;
}
```
## Enums
Enum is a special data type that enables for a variable to be a set of predefined constants. The variable must be equal to one of the values that have been predefined for it. Internally the class represents the different constants as integers.

Below is an example of an enum Direction:
```
public enum Direction {
    NORTH, EAST, SOUTH, WEST
}
```

To declare a variable as the enum Direction:
```
Direction direction = Direction.NORTH;
```

### Exercise 3: Create the `Day` Enum
__TODO__: In your personal `lec2-<kerberos>` repo, create an enum called `Day`. A variable of type `Day` can be any of the days of the week.

## Strings

To create a String literal:
```
String name = "Jennifer";
```
Here are some helpful methods that come with `String`:
```
String firstName = "Jennifer";

// Get the length of a String
int len = firstName.length(); // should be 8

// Get the character at a specific index (0-indexed) of the String
char secondLetter = firstName.charAt(1); // should be 'e'

// Concatenating two strings
String lastName = "Zhang";
String fullName = firstName.concat(lastName);
```
You can read more about Strings [here](https://docs.oracle.com/javase/tutorial/java/data/strings.html)

## Arrays
You can create 1d or 2d arrays:
```
String[] months; // 1d array
int[][] coordinates; // 2d array
```

You can't dynamically allocate space for arrays. Therefore, you have to declare an array's size at assignment:
```
String[] months; // 1d array
months = new String[12];
```

You can index into an array as so:
```
char firstNameArray = {'J', 'e', 'n', 'n', 'i', 'f', 'e', 'r'};
char firstInitial = firstNameArray[0]; // should be 'J'
```
You can read more about arrays [here](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html). In a later lecture we'll learn more about more useful data types other than arrays that are very similar to arrays.

### Exercise 4: Create a `months` array and populate it.
__TODO__: Create an array of type `String` called `months` of size 12. Populate each element of the array with the name of the month as a `String`.

## Final Exercise
__TODO__: Push all your work for today's lecture exercises to your personal lec2 repo (`https://github.mit.edu/6178-2017/lec2-<kerberos>`).
Review how to do so in the [Git Workflow section](https://github.mit.edu/6178-2017/lec2#git-workflow). In short, follow these steps:
```
git add .
git commit -m <some message here>
git push origin master
```
