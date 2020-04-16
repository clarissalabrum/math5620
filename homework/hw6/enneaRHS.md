**Routine Name:** enneaRHS

**Author:** Clarissa Labrum

**Language:** Java 

**Description/Purpose:** Create the right hand side of values for a system of equations for a 9-point stencil

**Input:** 

* int nx - width in x direction
* int ny - width is y direction
* double[][] cond - 2D array that holds the conditional values for the edges, code explains which side is represented
* double[] f - funtional values that the poisson equation equals
* double h - step size

**Output:** Returns a 1D array with the new RHS values.

**Usage/Example:**

To use this routine that problem already needs to be established with the conditional and functional values. Then the user can use the 
next statement to create the RHS of the problem.

    double[] rhs = enneaRHS(nx, ny, cond, f, h);

**Implementation/Code:** The following is the code for enneaRHS

    public static double[] enneaRHS(int nx, int ny, double[][] cond, double[] f, double h) {
        int width = nx * ny;

        //cond[0] top
        //cond[1] left
        //cond[2] right
        //cond[3] bottom

        for (int k = 0; k < width; k++) {
            int row = k / nx;
            int col = k % nx;

            f[k] = f[k] * h * h * 6;
            if (row - 1 == -1) {
                f[k] = f[k] - cond[3][col];
                if (col != 0) f[k] -= cond[3][col-1];
                if (col != nx -1) f[k] -= cond[3][col+1];
            }
            if (row + 1 == nx - 1) {
                f[k] = f[k] - cond[0][col];
                if (col != 0) f[k] -= cond[0][col-1];
                if (col != nx -1) f[k] -= cond[0][col+1];
            }
            if (col - 1 == -1) {
                f[k] = f[k] - cond[1][row];
                if (row != 0) f[k] -= cond[1][row-1];
                if (row != nx -1) f[k] -= cond[1][row+1];
            }
            if (col + 1 == ny - 1) {
                f[k] = f[k] - cond[2][row];
                if (row != 0) f[k] -= cond[2][row-1];
                if (row != ny -1) f[k] -= cond[2][row+1];
            }
        }
        return f;
    }

**Last Modified:** April/2020
