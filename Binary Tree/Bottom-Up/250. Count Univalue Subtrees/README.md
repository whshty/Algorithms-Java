Here int[] works like a wrap. When you pass (int[])arr to a method, it creates a new reference point to the same object as arr and pass the new reference to the method. Hence when you change for example arr[0] in the method call, since both of the references point to the same object, it will reflect on arr in the parent call;
int is a primitive type, you pass a int variable to a method it simply makes a copy of the variable and pass it to the method.

For example:

```
void parentMethod() {
  int a = 0;
  int[] arr = new int[1];
  childMethod1(a, arr);
  System.out.print(a); //it will print 0;
  System.out.print(arr[0]); //it will print 1;
}

void childMethod(int a, int[] arr) {
  a++;
  arr[0]++;
}

```