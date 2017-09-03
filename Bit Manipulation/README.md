# Bit Manipulation

### Tips
#### Binary Search ( >>> vs >> )
When we are trying to find the mid value, we can use 

```
mid = ( low + high ) >>> 1
```
The >>> operator is unsigned right bit-shift operator in Java. It effectively divides the operator by 2 to the power of the rigth operand.

The logical right shift (v >>> n) returns a value in which the bits in v have been shifted to the right by n bit positions, and 0's are shifted in from the left side. Consider shifting 8-bit values, written in binary:

The right shift logical operator (>>> N) shifts bits to the right by N positions, discarding the sign bit and padding the N left-most bits with 0's. For example:

```
-1 (in 32-bit): 11111111111111111111111111111111
```

after a >>> 1 operation becomes:

```
2147483647: 01111111111111111111111111111111
```

The right shift arithmetic operator (>> N) also shifts bits to the right by N positions, but preserves the sign bit and pads the N left-most bits with 1's. For example:

```
-2 (in 32-bit): 11111111111111111111111111111110
```

after a >> 1 operation becomes:

```
-1: 11111111111111111111111111111111
```