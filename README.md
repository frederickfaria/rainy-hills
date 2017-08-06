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

# SOLUTION:

The solution was implemented with Java Platform Enterprise Edition (Java EE) APIs as showed bellow:

controller:
MainServlet.java: Main servlet that get the request of browser with the user input using method post.
service:                      
CoreService.java: Local interface for the ejb who contains the code to solve the problem. 
CoreServiceImpl.java: EJB Stateless implementing CoreService as it local interface, overriding the method fillWater 
descriptor:
web.xml: Deployment Descriptor for the J2EE application. Contains the servlet and ejb definition.
jsp: 
index.jsp: JSP file who contains the content to show in the browser. Implements Bootstrap 3.3.7
test:
CoreServiceTest.java: Unit test class for fillWater method of CoreServiceImpl.java