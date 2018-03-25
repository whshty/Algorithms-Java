# Lambda Expressions

## Concept

```
(param1,param2, ..., paramN) -> {
  statment1;
  statment2;
  //.............
  return statmentM;
}
```


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
## Stream

```java
list.stream().map((x) -> x*x).forEach(System.out::println);
```

## Mapreduce

```java
List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
int sum = list.stream().map(x -> x*x).reduce((x,y) -> x + y).get();
System.out.println(sum);
```

## Collector

Accumulate names into a List

```java
List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());
```

Accumulate names into a TreeSet

```java
Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
```

Convert elements to strings and concatenate them, separated by commas

```java
String joined = things.stream()
                      .map(Object::toString)
                      .collect(Collectors.joining(", "));
``` 
                      
Compute sum of salaries of employee        

```java
int total = employees.stream()
                     .collect(Collectors.summingInt(Employee::getSalary)));
```       

Group employees by department     

```java
Map<Department, List<Employee>> byDept
         = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));
```  

Compute sum of salaries by department

```java
Map<Department, Integer> totalByDept
         = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingInt(Employee::getSalary)));
```

Partition students into passing and failing

```java
Map<Boolean, List<Student>> passingFailing = students.stream().collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
```
 
 
 
