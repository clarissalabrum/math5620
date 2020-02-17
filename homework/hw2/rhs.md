**Routine Name:** rhs

**Author:** Clarissa Labrum

**Language:** Java. 

**Description/Purpose:** This method initializes the right hand side
matrix to solve a system of equations.

**Input:** the method expects the following parameters
* f - the array of function values f(x)
* alpha - boundary condition u(0)
* beta - boundary condition u(1)
* h - size between steps
* n - number of steps

**Output:** returns the initialized matrix

**Usage/Example:** To create a rhs matrix the following call needs to be
made.

    double[] F = TridiagMatrix.rhs(f, alpha, beta, h, size);
    
This call will set **F** to the initialized matrix.

**Implementation/Code:** The following is the code for rhs

    public static double[] rhs(double[] f, double alpha, double beta, double h, int n){
        double[] F = new double[n -1];
        double hsq = h * h;
        F[0] = (f[0] * hsq) - alpha;
        F[n -2] = (f[n -2] * hsq) -beta;
        for (int i = 1; i < (n - 2); i++){
            F[i] = f[i] * hsq;
        }
        return F;
    }

**Last Modified:** February/2020