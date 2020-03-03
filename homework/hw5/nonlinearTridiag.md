**Routine Name:** nonlinearTridiag

**Author:** Clarissa Labrum

**Language:** Java 

**Description/Purpose:** Solve a nonlinear elliptic BVP problem

**Input:** The method requires the following parameters.

* double alpha - starting boundary condition
* double beta - ending boundary condition
* double h = 1/(size-1)
* int size - number of spaces in between points
* double[] U - array of initial guesses
* double[] f - array of functional values for the rhs

**Output:** This method will display the initial guess for the problem
and then 5 iterations using the new result for each iteration. The
output of the results will be an iteration per line with commas in
between.


**Usage/Example:**

This method is called with the following statement.

    TridiagMatrix.nonlinearTridiag(alpha, beta, h, size, U, f);

The output from the lines above will be in the same form as the following.

    1.0,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,0.0000000,-1.0
    1.0,0.9080678,0.8136201,0.7169186,0.6182312,0.5178313,0.4159969,0.3130102,0.2091564,0.1047233,-0.0000000,-0.1047233,-0.2091564,-0.3130102,-0.4159969,-0.5178313,-0.6182312,-0.7169186,-0.8136201,-0.9080678,-1.0
    1.0,0.9049222,0.8083021,0.7103044,0.6110961,0.5108462,0.4097257,0.3079069,0.2055632,0.1028693,0.0000000,-0.1028693,-0.2055632,-0.3079069,-0.4097257,-0.5108462,-0.6110961,-0.7103044,-0.8083021,-0.9049222,-1.0
    1.0,0.9049423,0.8083360,0.7103465,0.6111415,0.5108907,0.4097656,0.3079393,0.2055861,0.1028811,-0.0000000,-0.1028811,-0.2055861,-0.3079393,-0.4097656,-0.5108907,-0.6111415,-0.7103465,-0.8083360,-0.9049423,-1.0
    1.0,0.9049422,0.8083358,0.7103463,0.6111412,0.5108904,0.4097653,0.3079391,0.2055859,0.1028810,0.0000000,-0.1028810,-0.2055859,-0.3079391,-0.4097653,-0.5108904,-0.6111412,-0.7103463,-0.8083358,-0.9049422,-1.0
    1.0,0.9049422,0.8083358,0.7103463,0.6111412,0.5108904,0.4097653,0.3079391,0.2055859,0.1028810,-0.0000000,-0.1028810,-0.2055859,-0.3079391,-0.4097653,-0.5108904,-0.6111412,-0.7103463,-0.8083358,-0.9049422,-1.0


The first line it the initial guess with the boundary conditions and 
the following lines are the iterations converging to the solution.

**Implementation/Code:** The following is the code for nonlinearTridiag

[nonlinearTridiag]()

    public static void nonlinearTridiag(double alpha, double beta, double h, int size, double[] U, double[] f) {
        double[][] A = new double[size][size];

        printResults(alpha, beta, U);

        for (int j = 0; j < 5; j++) {
            System.out.println();
            for (int i = 0; i < U.length; i++) {
                A = tridiag(size, 1, -2 + h * h * Math.cos(U[i]), 1);
            }
            double[] F = rhs(f, alpha, beta, h, size);
            U = solver(F, A, size);
            printResults(alpha, beta, U);
        }
    }

**Last Modified:** March/2020
