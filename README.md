# katas-java
Leap Years (easy, boolean logic)
- Minesweeper : making a minesweeper game (TODO : put in other file)

## -- Leap Years --
## -- Composite --
https://tamasgyorfi.wordpress.com/2012/10/09/composite-design-pattern-kata/
### Draw composite 
Implement an application that can draw (no, you don’t really have to draw, just implement the data structures) pictures using rectangles and circles. 
A picture can be made from primitives (rectangles and circles), primitives combined with other pictures (one or more primitives and at least one other picture – which is composed of primitives), and several pictures combined. (Spoiler: circles and rectangles are leaves, pictures are composite objects)

### Directory and Files composite
Implement an application that can compute (yes, you really have to compute) 
the size of a directory. 
The size of a directory is equal to the sum of all the files it contains plus the 
size of its subdirectories. (Hint: you might want to wrap java.io.File objects inside your Leaf and Composite classes. 

## -- Linked List --
### intersection
Given two (singly) linked lists, determine if the two lists intersect. Return the
intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
kth node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting
### partition (leetcode)
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes 
greater than or equal to x.
## -- Matrixes --
### Matrix rotate
Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
## -- Stack and Queues --
### Recursive into iterative
Use a stack to implement a recursive algorithm iteratively
### Min value stack (TODO)
How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.