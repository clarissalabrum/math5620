**Routine Name:** Jacobi

**Author:** Clarissa Labrum

**Language:** Java 

**Description/Purpose:** Computes Jacobi Iteration on a system of equations

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

    double[] x = PentadiagMatrix.jacobi(nx,ny,A,rhs,xold,tolerance);

**Implementation/Code:** The following is the code for jacobi

     public static double[] jacobi(int nx, int ny, double[][] A, double[] rhs, double[] xold, double tolerance){
        int width = nx * ny;
        double[] xnew = new double[width];
        double error = 0;
        int interations = 0;

        do {
            for (int i = 0; i < width; i++) {
                xnew[i] = -1 * rhs[i];
            }
            for (int i = 0; i < width - 1; i++) {
                xnew[i] = xnew[i] + A[1][i] * xold[i+1];
                xnew[i] = xnew[i] + A[3][i] * xold[i];
            }
            for (int i = 0; i < width - nx; i++) {
                xnew[i] = xnew[i] + A[0][i] * xold[i + nx];
                xnew[i] = xnew[i] + A[4][i] * xold[i];
            }
            for (int i = 0; i < width; i++) {
                xnew[i] = xnew[i] / A[2][i];
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
