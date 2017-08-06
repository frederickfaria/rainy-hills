# Rainy Hills
Full stack web application, implemented with J2EE 7 to solve the Rainy Hills Problem

# THE PROBLEM:
INPUT: array of integers
OUTPUT: integer number, further called "volume"

Imagine that the array describes profile of a surface, for example:

            |
        |   |
        | | |   |
        |-|-|-|-|
ARRAY:  3,2,4,1,2

Now imagine that there was a heavy rain, and all possible "holes" are filled with water. In this case, we have volume == 2 units of water:

            |
        | # |
        |-|-| # |
        |-|-|-|-|
ARRAY:  3,2,4,1,2

Another example, here we have volume == 8 units of water:

        |    
        | # # # # |
        | # # # | |
        |-|-|-#-|-|
ARRAY:  4,1,1,0,2,3

# TASK:
* correctness and clarity of the algorithm
* readable and maintainable code
* "real" enterprise application: layered, testable, deployable, documented

Write an application which takes an array as an input, and calculates the volume of water which remained after the rain, in units.
The application shall be deployable in a EJB container of your choice(preferably either JBoss, Wildfly, Glassfish, or TomEE).
Make a statement on complexity of your solution (time and memory), and if possibly discuss complexity of an optimal solution.

