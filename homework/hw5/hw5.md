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
* double h = 2/(size-1)
* int size = 20
* double[] U = {0,0,...,0}
* double[] f = {0,0,...,0}

The results were:

    1.0,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,-1.0
    1.0,0.9345973,0.8588390,0.7735645,0.6797186,0.5783413,0.4705557,0.3575562,0.2405948,0.1209676,-0.0000000,-0.1209676,-0.2405948,-0.3575562,-0.4705557,-0.5783413,-0.6797186,-0.7735645,-0.8588390,-0.9345973,-1.0
    1.0,0.9197782,0.8335011,0.7417369,0.6450897,0.5441956,0.4397189,0.3323474,0.2227880,0.1117619,-0.0000000,-0.1117619,-0.2227880,-0.3323474,-0.4397189,-0.5441956,-0.6450897,-0.7417369,-0.8335011,-0.9197782,-1.0
    1.0,0.9201949,0.8342110,0.7426256,0.6460538,0.5451440,0.4405737,0.3330452,0.2232803,0.1120162,0.0000000,-0.1120162,-0.2232803,-0.3330452,-0.4405737,-0.5451440,-0.6460538,-0.7426256,-0.8342110,-0.9201949,-1.0
    1.0,0.9201832,0.8341911,0.7426008,0.6460268,0.5451175,0.4405498,0.3330256,0.2232665,0.1120091,0.0000000,-0.1120091,-0.2232665,-0.3330256,-0.4405498,-0.5451175,-0.6460268,-0.7426008,-0.8341911,-0.9201832,-1.0
    1.0,0.9201835,0.8341917,0.7426015,0.6460276,0.5451182,0.4405505,0.3330262,0.2232669,0.1120093,-0.0000000,-0.1120093,-0.2232669,-0.3330262,-0.4405505,-0.5451182,-0.6460276,-0.7426015,-0.8341917,-0.9201835,-1.0


## Task 2

This task does not require iteration to solve. The main diagonal just needs
to be set to -2 + h^2. This problem also needs the following parameters. 

* double alpha = 1
* double beta = -1
* double h = 2/(size-1)
* int size = 20
* double[] f = {0,0,...,0}

The output will be:

    1.0,0.9345973,0.8588390,0.7735645,0.6797186,0.5783413,0.4705557,0.3575562,0.2405948,0.1209676,-0.0000000,-0.1209676,-0.2405948,-0.3575562,-0.4705557,-0.5783413,-0.6797186,-0.7735645,-0.8588390,-0.9345973,-1.0


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