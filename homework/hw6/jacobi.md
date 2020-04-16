**Routine Name:** jacobi

**Author:** Clarissa Labrum

**Language:** Java 

**Description/Purpose:** Thsi routine solves a system of equations for a 9-point stencil of a poisson equation.

**Input:** 

* int nx - column width
* int ny - row width
* double[][] A - initialized matrix
* double[] rhs - right hand side of system of equations
* double[] xold - past values from iteration
* double tolerance - how exact the result should be

**Output:** 

Returns an array of doubles that approximates the solution and prints out how many iterations were completed.

**Usage/Example:**


To use the routine the following call needs to be made.

    double[] x = EnneadiagMatrix.jacobi(nx,ny,A,rhs,xold,tolerance);

**Implementation/Code:** The following is the code for jacobi

    public static double[] jacobi(int nx, int ny, double[][] A, double[] rhs, double[] xold, double tolerance) {
        int width = nx * ny;
        double[] xnew = new double[width];
        double error = 0;
        int interations = 0;

        do {
            for (int i = 0; i < width; i++) {
                int row = i / nx;
                int col = i % nx;

                xnew[i] = xnew[i] - rhs[i];

                if (row - 1 != -1) {
                    xnew[i] = xnew[i] + A[1][i] * xold[i - nx];
                    if (col != 0) xnew[i] = xnew[i] + A[0][i] * xold[i - nx - 1];
                    if (col != nx -1) xnew[i] = xnew[i] + A[2][i] * xold[i - nx + 1];
                }
                if (row + 1 != nx - 1) {
                    xnew[i] = xnew[i] + A[7][i] * xold[i + nx];
                    if (col != 0) xnew[i] = xnew[i] + A[6][i] * xold[i + nx - 1];
                    if (col != nx -1) xnew[i] = xnew[i] + A[1][i] * xold[i + nx + 1];
                }
                if (col - 1 != -1) {
                    xnew[i] = xnew[i] + A[3][i] * xold[i - 1];
                }
                if (col + 1 != ny - 1) {
                    xnew[i] = xnew[i] + A[5][i] * xold[i + 1];
                }
            }
            for (int i = 0; i < width; i++) {
                xnew[i] = xnew[i] / A[4][i];
            }
            for (int i = 0; i < width; i++) {
                error += (xold[i] - xnew[i]) * (xold[i] - xnew[i]);
            }
            error = Math.sqrt(error);
            xold = xnew;
            interations++;
        }
        while (error > tolerance + 1);
        System.out.println("iterations: " + interations);
        return xnew;
    }

**Last Modified:** April/2020
