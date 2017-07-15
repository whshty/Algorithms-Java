# Hash
## Concept
* Used for speeding up searching
* Use Hash function to tell us the index of a given value
* Hashing : key - number


## Collisions
#### Description
When we put objects into a hashtable, it is possible that different objects (by the equals() method) might have the same hashcode. This is called a collision. Here is the example of collision. 

For example , Two different strings ""Aa" and "BB" have the same key: 

```
"Aa" = 'A' * 31 + 'a' = 2112
"BB" = 'B' * 31 + 'B' = 2112
```

#### Solutions
* Separate Chaining

The idea is to make each cell of hash table point to a linked list of records that have same hash function value.


* Linear Probing


## HashSet, HashMap and HashTable
* HaseSet
* HashMap
* HashTable