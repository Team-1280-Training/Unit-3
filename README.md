# Unit 3: Conditional Statements

## Introduction
We use conditional statements to control the flow of our program depending on certain conditions. These statements allow programs to perform different actions based on whether a boolean condition is true or false.

### Table of Contents
- [Introduction](#introduction)
    - [Table of Contents](#table-of-contents)
- [Scanner](#scanner)
    - [>Exercise: User Input](#exercise-user-input)
- [Block Statements](#block-statements)
    - [Variable Scope](#variable-scope)
- [If, Else, and Else If Statements](#if-else-and-else-if-statements)
    - [If Statements](#if-statements)
    - [Else Statements](#else-statements)
    - [Else If Statements](#else-if-statements)
    - [>Exercise: Fossil Classification](#exercise-fossil-classification)
- [Switch Statements](#switch-statements)
    - [>Exercise: Polygon Identification](#exercise-polygon-identification)
- [Nested Conditional Statements](#nested-conditional-statements)
    - [>Exercise: Dove Photography](#exercise-dove-photography)
- [Recap](#recap)
- [>>Project: Final Grade Calculator](#project-final-grade-calculator)

[Feedback](#feedback) \
[License](#license)

## Scanner
<sub>(Detour)</sub>

Currently, none of your programs receive user input, and so they run the same way every time. To make future exercises and projects more interactive, you'll learn about getting keyboard input with `Scanner`.

First, in order to be able to use it, insert this line before everything (probably at line 1):
```java
import java.util.Scanner;
```

Now, you can create a scanner object in your program with the following variable declaration:
```java
Scanner scanner = new Scanner(System.in);
```

Then, the object can be used to get values from user input. Here are the common expressions:
- `scanner.nextInt()` gives an `int`
- `scanner.nextDouble()` gives a `double`
- `scanner.nextLine()` gives the rest of the line, a `String`
- `scanner.next()` gives the next word, a `String`

When one of these expressions is evaluated, the program will wait for the user to type in something into the console (where output also goes) and press enter. \
Typically, some sort of prompt is printed before using these, to alert the user: either `System.out.println()` (input is on next line) or `System.out.print()` (input is on same line as prompt).

> **Note:** You may see an orange underline on `scanner`, which is a warning from VS Code. This specific warning that appears when declaring a `Scanner` variable can be ignored. \
> To disable it, click on the underlined text. Then, click on the *light bulb* to the left, or press `Ctrl`+`.` . \
> Then in the dropdown, click `Ignore compiler problem(s)` under `Quick Fix` section, (2nd option). \
> Generally, it is not recommended to close a `Scanner` of `System.in`.

Also, except for `.nextLine()`, the user can enter multiple values on a single line.

**<u>Warning:</u>** if you use `.nextLine()` after a different input, then the scanner will still be on the same input line, and `.nextLine()` will just instantly take the rest of the line, typically an empty string (nothing). \
To prevent this, put `scanner.nextLine();` as a statement by itself to 'consume' the rest of the emptied line.
```java
int number = scanner.nextInt();
scanner.nextLine(); // Get rid of the newline from the previous input
String text1 = scanner.nextLine();
String text2 = scanner.nextLine();
```

Also, here's a useful example of a simple implementation for a boolean (yes or no) answer:
```java
System.out.print("Proceed (y/n)? ");
if (scanner.nextLine().equalsIgnoreCase("y")) {
    // yes
} else {
    // no
}
```

### >Exercise: User Input
[`UserInput.java`](UserInput.java) \
Write a simple program that processes some input.

- Prompt the user for a string, then print that string with any added text or effects of your choice
- Then, prompt the user for an integer, and print `Squared: ` followed by the integer squared

<details><summary>Solution code</summary>

```java
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String string = scanner.nextLine();
        System.out.println("**" + string + "!**");
        System.out.println("Enter an integer:");
        int integer = scanner.nextInt();
        System.out.println("Squared: " + integer * integer);
    }
}
```
Input/output:
```
Enter a string:
hello
**hello!**
Enter an integer:
5
Squared: 25
```

</details>

## Block Statements
Conditional statements are not the usual one-line statements. They are **block statements** that contain **block(s)** of multiple other statements. \
A block is marked by **braces `{}`**, and its body is conventionally **indented** a level to make it easy to see. \
<u>Do not use semicolons `;` to end block statements</u>, as the braces are already enough. \
Sometimes called compound statements.

Blocks are typically part of a block statement or other construct, though plain blocks are possible.

### Variable Scope
**Scope** is the region of the program where a given variable can be accessed. \
Until Unit 5, all of your variables are **local** variables inside the same one local scope. \
A local variable's scope is restricted to the enclosing block that the declaration is in. (And only after the declaration of course.)
```java
public class Main {
    public static void main(String[] args) {
        // neither x nor y accessible on this line
        int x = 0;
        {
            // Braces mark a block of code
            int y = 0;
            // both x and y are accessible on this line
        }
        // only x is accessible on this line
    }
}
```
A local variable can only have one declaration within its local scope.

## If, Else, and Else If Statements

### If Statements
If statements are the most basic conditional statements. These statements check if a condition is true, and execute a block of code if it is, or skip the block if it is not.

If statements look like this:
```java
if (condition) {
    // code to execute if the condition is true
}
// any code outside of the brackets is not part of the if statement
```

Examples!
```java
int x = 1;
int y = 5;

if (x < y) {
    System.out.println("x is less than y!");
}

if (x == 2) {
    System.out.println("x is equal to 2!");
}

// only `x is less than y!` will print because, 1 less than 5 is true, but 1 equals 2 is false.
```

### Else Statements
Else statements are used with if statements to specify a block of code to be executed if the previous condition(s) are false.

An else statement can only be placed right after an if statement or else if statement.

Else statements look like this:
```java
if (condition) {
    // code to execute if this condition is true
} else {
    // code to execute otherwise (if this condition is false)
}
```
These statements will execute *either* the code in the if statement *or* the code in the else statement, never both blocks!

Examples!
```java
int a = 40;
int b = 20;

if (a / b == 3) {
    System.out.println(">:|");
} else {
    System.out.println(":D");
}
// `:D` will be printed because the condition is false, so the code inside the if statement will not run. Instead, the program will execute the code inside the else statement.

if (a - b > 10) {
    System.out.println("o_o");
} else {
    System.out.println(";)");
}
// `o_o` will be printed because the condition is true, so the code inside the if statement will run. This means the program will not execute the code in the else statement.
```

### Else If Statements
Else if statements are used to execute code only if the previous condition(s) were false and another condition is true. This allows a program to check multiple conditions in sequence.

An else if statement can only be placed right after an if statement or else if statement.

Else if statements look like this:
```java
if (condition1) {
    // code to execute if condition1 is true
} else if (condition2) {
    // code to execute if condition2 is true
} else {
    // code to execute if all conditions are false
}
```
Note that again, only one block of code from this statement will be run by the program.  The else if statement is run only if condition1 is false. If condition1 is true, the code in the else if statement will not be run even if condition2 is true.

In short, a chain of conditionals begins with a single if statement, then is followed by an arbitrary number of else if statements, and then is optionally ended with an else statement. Only the first statement of the chain that doesn't have a false condition gets executed.

### >Exercise: Fossil Classification
[`FossilClassification.java`](FossilClassification.java) \
You're an archaeologist classifying recently excavated fossils for shipment to a museum. The museum wants you to sort the fossils by periods in the Mesozoic Era: Triassic (252-202 million years ago (mya)), Jurassic (201-145 mya), and Cretaceous (144-66 mya)

1. Use a `Scanner` to read an `int` age from the user with prompt `Fossil age:`. Remember to import `java.util.Scanner`!
2. Create a series of if and else if statements that uses the fossil age to print the period it's from. If it belongs to none of the periods, print `._.` instead.
3. Run the program for the age of a compsognathus fossil (a bipedal, chicken-sized carnivorous dinosaur) from around 147 mya.

<details><summary>Solution code</summary>

Your conditions don't have to look exactly like this (as long as they work!)
```java
import java.util.Scanner;

public class FossilClassification {
    public static void main(String[] args) throws Exception {
        // Write your code below!
        Scanner scanner = new Scanner(System.in);
        System.out.println("Fossil age: ");
        int age = scanner.nextInt();

        if (age >= 202 && age <= 253) {
            System.out.println("This is a fossil from the Triassic period!");
        } else if (age >= 145 && age <= 201) {
            System.out.println("This is a fossil from the Jurassic period!");
        } else if (age >= 66 && age <= 144) {
            System.out.println("This is a fossil from the Cretaceous period!");
        } else {
            System.out.println("._.");
        }
    }
}
```
Output:
```
Fossil age:
147
This is a fossil from the Jurassic period!
```
</details>

## Switch Statements
We use switch statements to check one value against a series of values. Switch statements are often more readable than chaining if-else statements, but can only be used when you're assessing the exact value of a single thing.

A switch statement operates on a single expression, has an arbitrary number of cases, and may optionally have a default case. If there is no default case and the value doesn't match any cases, nothing is executed.

Example structure:
```java
switch (expression) {
    case value1:
        // code to execute if expression equals value1
        break;
    case value2:
        // code to execute if expression equals value2
        break;
    default:
        // code to execute if expression doesn't match any cases
}
```

Let's break down what's happening in this statement:
- `switch (expression)` is declaring that `expression` is the value to be used and compared in each case.
- `case value1:` is saying that *in the case that* `variable` is equal to `value1`, run the code following it.
- `break` is the keyword that tells the program it can exit the switch statement. If you omit it, execution will continue through the next case (without checking), and this can be used to have multiple cases execute the same code.
- `default` specifies the code to be run if none of the cases match `expression`. It's usually put as the last case of a switch statement, in which case it doesn't need a `break`.

Only most integer-like data types and `String` can be used for switch statements. `double` and other types cannot be used.

> **Under the hood:** You may have noticed that the cases aren't blocks of code (they lack braces). \
> The cases are actually just markers/tags: Java uses the switch value to **jump** to the corresponding case; then, it simply executes code normally (where cases are ignored because they are just tags). \
> This is why `break` is usually needed, to separate the code of different cases.

If you are using a switch statement (or a conditional chain) to assign to a variable, then make sure that the variable is guaranteed to have an assigned value. \
Java will error if a variable is possibly uninitialized. \
Avoid this error by giving the variable an initial value before the switch statement, having a `default` case that assigns a value, or having a `default` case that exits the code. \
Erroring example:
```java
boolean confirmation;
String input = "yes";
switch (input.toLowerCase()) { // Convert to lowercase for case-insensitive matching
    case "y":
    case "yes":
        confirmation = true;
        break;
    case "n":
    case "no":
        confirmation = false;
        break;
}
System.out.println(confirmation); // ERROR! confirmation might not have been initialized
// For example, if input is something like "Hi"
```
Fixed code:
```java
boolean confirmation; // (Alternatively, initialize confirmation to false here)
String input = "yes";
switch (input.toLowerCase()) { // Convert to lowercase for case-insensitive matching
    case "y":
    case "yes":
        confirmation = true;
        break;
    case "n":
    case "no":
    default: // Default to no
        confirmation = false;
        break;
}
System.out.println(confirmation); // Output: true
```

### >Exercise: Polygon Identification
[`PolygonIdentification.java`](PolygonIdentification.java) \
You're a very bored math teacher and want to write a program that can classify basic polygons by number of sides.

1. Prompt the user for and read the number of sides.
2. Create a switch statement  with cases for a polygon with 3, 4, 5, or 6 sides.
3. Print the correct name of the polygon (3 sides = triangle, 4 sides = quadrilateral, 5 sides = pentagon, 6 sides = hexagon).
4. If none match, print `figure it out yourself >:(` instead.
5. Time to test! Run your program with your `sides` variable to `3`, `5`, and `200`
6. Your program should output: `triangle`, `pentagon`, and `figure it out yourself >:(`.

<details><summary>Solution code</summary>

```java
import java.util.Scanner;

public class PolygonIdentification {
    public static void main(String[] args) throws Exception {
        // Write your code below!
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of sides:");
        int sides = scanner.nextInt();

        switch (sides) {
            case 3:
                System.out.println("Triangle!");
                break;
            case 4:
                System.out.println("Quadrilateral!");
                break;
            case 5:
                System.out.println("Pentagon!");
                break;
            case 6:
                System.out.println("Hexagon!");
                break;
            default:
                System.out.println("figure it out yourself >:(");

        }
    }
}
```
Output:
```
Number of sides:
3
Triangle!
```
```
Number of sides:
5
Pentagon!
```
```
Number of sides:
200
figure it out yourself >:(
```
</details>

## Nested Conditional Statements
Since conditional statements are *statements*, we can **nest** conditional statements by putting one statement inside another!

Here is what that can look like:
```java
if (condition1) {
    // code to execute if condition1 is true
    if (condition2) {
        // code to execute if both conditions are true
    }
} else {
    // code to execute if condition1 is not true
}
```

Examples!
```java
boolean isWhale = true;
boolean isDolphin = false;

if (isWhale) {
    System.out.println("Whale Spotted!");
    if (isDolphin) {
        System.out.println("It's a dolphin!!");
    }
} else {
    System.out.println("Just a regular fish... TT-TT");
}
```
While we could check `isWhale` and `isDolphin` separately, since dolphins *are* whales, we only need to check if it's a dolphin if it's also a whale. If it isn't a whale, we automatically know it isn't a dolphin, and don't have to do the extra check.

> **Tip:** Be sure to use proper indentation levels at all times. This makes it clear what each block encompasses, something that can otherwise be confusing to new programmers if their indentation is off.

### >Exercise: Dove Photography
[`DovePhotography.java`](DovePhotography.java) \
You're a wildlife photographer trying to get pictures of different types of doves (specifically birds from the Columbidae family), but your favorites are blue eyed ground doves (which have orange feathers and blue eyes). Thankfully, they aren't hard to spot; they have many distinct traits that you can look for.

1. Your camera can automatically classify the `family`, `featherColor`, and `eyeColor` of birds you focus the lens on. Prompt and read user input for this data.
2. When a dove is identified, print: `Dove! Take pictures!`
3. When a blue eyed ground dove is identified, also print: `Cooler dove!! Take many pictures!!`
4. If the bird is not a dove, print: `Meh bird... let's find a different one.`
5. Time to test! Run your program with these different values:
    - a. European Turtle Dove: `columbidae` family, `brown` feathers, `orange` eyes.
    - b. Asian Emerald Cuckoo: `cuculidae` family, `green` feathers, `orange` eyes.
    - c. Blue Eyed Ground Dove: `columbidae` family, `orange` feathers, `blue` eyes.
6. Your program should output:
    - a. `Dove! Take pictures!`
    - b. `Meh bird... let's find a different one.`
    - c. `Cooler dove!! Take many pictures!!`

<details><summary>Solution code</summary>

```java
import java.util.Scanner;

public class DovePhotography {
    public static void main(String[] args) throws Exception {
        // Write your code below!
        Scanner scanner = new Scanner(System.in);

        System.out.println("Family of bird: ");
        String family = scanner.nextLine();
        System.out.println("Feather color: ");
        String featherColor = scanner.nextLine();
        System.out.println("Eye color: ");
        String eyeColor = scanner.nextLine();

        if (family.equals("columbidae")) {
            System.out.println("Dove! Take pictures!");
            if (featherColor.equals("orange") && eyeColor.equals("blue")) {
                System.out.println("Cooler dove!! Take many pictures!!");
            }
        } else {
            System.out.println("Meh bird... let's find a different one.");
        }
    }
}

```
Output:
```
Family of bird:
columbidae
Feather color:
brown
Eye color:
orange
Dove! Take pictures!
```
```
Family of bird:
cuculidae
Feather color:
green
Eye color:
orange
Meh bird... let's find a different one.
```
```
Family of bird:
columbidae
Feather color:
orange
Eye color:
blue
Dove! Take pictures!
Cooler dove!! Take many pictures!!
```
</details>

## Recap
- Use `Scanner` with methods `nextInt()`, `nextDouble()`, `nextLine()` to receive user input
- Block statements involve blocks of other statements delimited with braces `{}`
- A local variable is accessible in its enclosing block, and may only be declared once in the whole local scope
- `if` statements execute a block a code if a boolean condition is `true`
- `else` statements run when all other conditions in the conditional chain are `false`, and don't have a condition themselves
- `else if` statements execute if all previous conditions in the conditional chain are `false` and another condition is `true`
- `switch` statements take a single value and jump to the matching `case`, or `default` if none match
- Block statements such as conditional statements can be nested inside each other

<!--
### Keyboard Shortcuts
-->

## >>Project: Final Grade Calculator
At the end of most units, there is a project that is also reviewed by the mentors.

Create a program that calculates the minimum percent the user needs on the final in order to get a specified letter grade. \
[`Grade.java`](Grade.java)

The user inputs:
- Their **current** grade percentage
- What percentage the final is of the grade, the **weight**
- A letter grade `A` `B` `C` `D` that the user wants to get (`F` is not applicable), the **target**

The minimum percentage for $A$ is $90.0\%$, $B$ is $80.0\%$, $C$ is $70.0\%$, $D$ is $60.0\%$. $F$ is anything below that.

The program outputs the minimum percentage needed on the final, to get an overall grade of the target letter or higher. \
It also must display the letter grade that the outputted percentage on the final would correspond to.

This minimum is given by (where all numbers are percents e.g. `90.0`):
```math
minimum = current + 100 * \frac{target - current}{weight}
```
```
minimum = current + 100.0 * (target - current) / weight
```
If the user gives an invalid input for the letter grade, warn the user, and act as if the input were instead an `A`. \
Assume that the two inputted percentages are valid and positive.

Example input/output (wording does not have to exactly match the examples for projects):
```
Current grade percentage:
92.2
Final weight percentage:
10 
Target letter grade:
A
Final minimum percentage needed: 70.19999999999997% (C)
```

## Feedback
Please provide feedback if you have any. \
Also, please give an estimate of how much time you spent on this unit.

<details><summary>Possible feedback points</summary>

- Confusing explanations
- Knowledge, skills, or procedures that were required but weren't taught
- Too fast or too slow explanations; pacing
- Too hard or too easy exercises
- Step-by-step instructions that are not comprehensive/thorough enough, or didn't work
- Seemingly unnecessary or ineffective information or exercises
- Any improvements (e.g. wording) or more effective ways/formats to teach
</details>

___



## License
© 2025 @aatle, @spacepotatoes3, @gjgarson, @KaitoTLex

This work is licensed under a [Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/).
