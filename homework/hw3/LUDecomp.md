**Routine Name:** LUDecomp

**Author:** Clarissa Labrum

**Language:** Java. 

**Description/Purpose:** LUDecomp initiates a tridiagional matrix of an indicated size 
and then preforms a LU Decomposition of the matrix.

**Input:** The Class constructor requires a number of steps, the function values at the 
steps in the form of an array, the Dirichlet Boundary conditions called alpha and beta, and
the h which is found with the step size.

**Output:** The class will create an object of the LUDecomp in which it will print out 
the final solution to the console.

**Usage/Example:**

To create an instance of the class a statement of the following form is needed.

    new LUDecomp(n, f, alpha, beta, h);
    
Where n, f, alpha, beta, and h were described in the input section. if n were to be 8, f(x)
were defined to be 0, alpha is 1 and beta is 3. then the outout would look like the following.

    Solution for 8 Mesh Points
    1.0
    0.6900634765625
    0.380126953125
    0.26025390625
    0.2705078125
    0.416015625
    0.76953125
    1.5078125
    3.0
    
THe LUDecomp solves the equation in the form Ax=b, in which the points printed out are the
x matrix values.

**Implementation/Code:** The following is the code for LUDecomp

   XXXXXXXXXXXXXXXXXX

**Last Modified:** September/2017