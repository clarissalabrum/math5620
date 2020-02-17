**Routine Name:** solver

**Author:** Clarissa Labrum

**Language:** Java. 

**Description/Purpose:** this method solves a system of equations that
can be written in the form **AU=F** where **A** is a tridiagonal matrix.

**Input:** This method expected the following parameters
* double[] F - this is the rhs matrix that is initialized with the rhs method
* double[][] A - this is the initialized tridiagonal matrix
*int n- number of steps

**Output:** this method returns the solution or the **U** matrix.

**Usage/Example:**

To use this method a call of the following form is needed. 

    double[] U = TridiagMatrix.solver(F, A, size);
    
This call will set the array **U** to the solution of the system **AU=F**.

**Implementation/Code:** The following is the code for solver

    public static double[] solver(double[] F, double[][] A, int n){
       //Full Matrix Reduction
        for (int i = 0; i < (n - 2); i++){
            double factor = A[0][i] / A[1][i];
            A[0][i] = A[0][i] - (factor * A[1][i]);
            A[1][i+1] = A[1][i+1] - (factor * A[2][i]);
            F[i+1] = F[i+1] - factor * F[i];
        }
        //Back Substitution
        double[] x = new double[n-1];
        x[n - 2] = F[n - 2] / A[1][n -2];
        for (int i = n - 3; i >= 0; i--){
            x[i] = F[i] - A[2][i] * x[i+1];
            x[i] = x[i] / A[1][i];
        }
        return x;
    }

**Last Modified:** February/2020