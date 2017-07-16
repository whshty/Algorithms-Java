# Hash
## 1. Concept
* Used for speeding up searching
* Use Hash function to tell us the index of a given value
* Hashing : key - number


## 2. Collisions
#### 2.1. Description
When we put objects into a hashtable, it is possible that different objects (by the equals() method) might have the same hashcode. This is called a collision. Here is the example of collision. 

For example , Two different strings ""Aa" and "BB" have the same key: 

```
"Aa" = 'A' * 31 + 'a' = 2112
"BB" = 'B' * 31 + 'B' = 2112
```

#### 2.2. Solutions
##### 2.2.1. Separate Chaining
The idea is to make each cell of hash table point to a linked list of records that have same hash function value.

![alt text](https://github.com/RagingPsyduck/Data-Structures-and-Algorithms-in-Java/blob/master/Hash/hashChaining1.png)

##### 2.2.2. Linear Probing
Both bucketing and chaining essentially makes use of a second dimension to handle collisions. This is not the case for linear probing. Linear Probing uses just a regular one dimensional array

The insertion algorithm is as follows:

* Use hash function to find index for a record
* If that spot is already use use next available spot in a "higher" index. Treat the hash table as if it is round, if you hit the end of the hash table, go back to the front
Each contiguous group of records (groups of record in adjacent indices without any empty spots) in the table is called a cluster.


## 3. HashSet, HashMap and HashTable
* HaseSet
* HashMap
* HashTable