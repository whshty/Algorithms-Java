# Lambda Expressions

## Concept

One Parameter
If the method you are matching your Java lambda expression against takes one parameter, you can write the lambda expression like this:

```java
(param) -> System.out.println("One parameter: " + param);
```

Notice the parameter is listed inside the parentheses.

When a lambda expression takes a single parameter, you can also omit the parentheses, like this:

```java
param -> System.out.println("One parameter: " + param);
```
Multiple Parameters
If the method you match your Java lambda expression against takes multiple parameters, the parameters need to be listed inside parentheses. Here is how that looks in Java code:

```java
(p1, p2) -> System.out.println("Multiple parameters: " + p1 + ", " + p2);
```

Only when the method takes a single parameter can the parentheses be omitted.

## Example

```java
public class Solution {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(e->System.out.print(e));
        list.forEach(System.out::print);
    }
}
```

