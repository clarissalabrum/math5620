# Homework 5

## Task 1

The finite difference code for nonlinear elliptic problem uses the 
existing class TrigiagMatrix and its methods [tridiag](https://github.com/clarissalabrum/math5620/blob/master/homework/hw2/tridiag.md), 
[rhs](https://github.com/clarissalabrum/math5620/blob/master/homework/hw2/rhs.md), and 
[solver](https://github.com/clarissalabrum/math5620/blob/master/homework/hw2/solver.md) 
as well a new method made to print the results 
[printResults]()

The method [nonlinearTridiag]() 
was added to the TridiagMatrix class. *Don't know how to change the 
function of the problem without rewriting the code*. This task requires 
the following line of code.

    A = tridiag(size, 1, -2 + h * h * Math.cos(U[i]), 1);

For this task the method was given the following parameters:

* double alpha = 1
* double beta = -1
* double h = 1/(size-1)
* int size = 20
* double[] U = {0,0,...,0}
* double[] f = {0,0,...,0}

The results were:

    1.0,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,-1.0
    1.0,0.9080678,0.8136201,0.7169186,0.6182312,0.5178313,0.4159969,0.3130102,0.2091564,0.1047233,-0.0000000,-0.1047233,-0.2091564,-0.3130102,-0.4159969,-0.5178313,-0.6182312,-0.7169186,-0.8136201,-0.9080678,-1.0
    1.0,0.9049222,0.8083021,0.7103044,0.6110961,0.5108462,0.4097257,0.3079069,0.2055632,0.1028693,0.0000000,-0.1028693,-0.2055632,-0.3079069,-0.4097257,-0.5108462,-0.6110961,-0.7103044,-0.8083021,-0.9049222,-1.0
    1.0,0.9049423,0.8083360,0.7103465,0.6111415,0.5108907,0.4097656,0.3079393,0.2055861,0.1028811,-0.0000000,-0.1028811,-0.2055861,-0.3079393,-0.4097656,-0.5108907,-0.6111415,-0.7103465,-0.8083360,-0.9049423,-1.0
    1.0,0.9049422,0.8083358,0.7103463,0.6111412,0.5108904,0.4097653,0.3079391,0.2055859,0.1028810,0.0000000,-0.1028810,-0.2055859,-0.3079391,-0.4097653,-0.5108904,-0.6111412,-0.7103463,-0.8083358,-0.9049422,-1.0
    1.0,0.9049422,0.8083358,0.7103463,0.6111412,0.5108904,0.4097653,0.3079391,0.2055859,0.1028810,-0.0000000,-0.1028810,-0.2055859,-0.3079391,-0.4097653,-0.5108904,-0.6111412,-0.7103463,-0.8083358,-0.9049422,-1.0


## Task 2

This task does not require iteration to solve. The main diagonal just needs
to be set to -2 + h^2. This problem also needs the following parameters. 

* double alpha = 1
* double beta = -1
* double h = 1/(size-1)
* int size = 20
* double[] f = {0,0,...,0}

The output will be:

    1.0,0.9080678,0.8136201,0.7169186,0.6182312,0.5178313,0.4159969,0.3130102,0.2091564,0.1047233,-0.0000000,-0.1047233,-0.2091564,-0.3130102,-0.4159969,-0.5178313,-0.6182312,-0.7169186,-0.8136201,-0.9080678,-1.0


## Task 3

Initialize pentadiagonal matrix - [pentadiag]()

Initialize right hand side - [pentaRHS]()

## Task 4

## Task 5

## Task 6

I started the task by first learning more about elliptic operators on 
[wikipedia](https://en.wikipedia.org/wiki/Elliptic_operator). Elliptic operators
are best for steady-state smooth functions. These types of problems commonly 
arise in electrostatics and continuum mechanics and in the heat equation we 
have been studying. We use finite difference methods on these types of problems
to get an approximation of the solution.

[Finite Difference Methods for Elliptic Equations](https://www.wias-berlin.de/people/john/LEHRE/NUM_PDE_FUB_19/num_pde_fub_2.pdf)