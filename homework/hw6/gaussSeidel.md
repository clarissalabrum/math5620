**Routine Name:** gaussSeidel

**Author:** Clarissa Labrum

**Language:** Java 

**Description/Purpose:** Solve a poisson equation using the Gauss Seidel Method

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

    double[] x = PentadiagMatrix.gaussSeidel(nx,ny,A,rhs,xold,tolerance);

**Implementation/Code:** The following is the code for gaussSeidel

    
    public static double[] gaussSeidel(int nx, int ny, double[][] A, double[] rhs, double[] x, double tolerance) {
        int width = nx * ny;
        double[] xold = new double[width];
        double error = 0;
        int interations = 0;

        do {

            for (int i = 0; i < width; i++) {
                x[i] = -1 * rhs[i];
            }
            for (int i = 0; i < width - 1; i++) {
                x[i] = x[i] + A[1][i] * x[i + 1];
                x[i] = x[i] + A[3][i] * x[i];
            }
            for (int i = 0; i < width - nx; i++) {
                x[i] = x[i] + A[0][i] * x[i + nx];
                x[i] = x[i] + A[4][i] * x[i];
            }
            for (int i = 0; i < width; i++) {
                x[i] = x[i] / A[2][i];
            }
            for (int i = 0; i < width; i++) {
                error += (x[i] - xold[i]) * (x[i] - xold[i]);
            }
            error = Math.sqrt(error);
            interations++;
            xold = x;
        }
        while (error > tolerance + 1);
        System.out.println("iterations: " + interations);
        return x;
    }

**Last Modified:** April/2020
