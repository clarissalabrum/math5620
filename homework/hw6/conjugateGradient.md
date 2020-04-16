**Routine Name:** conjugateGradient

**Author:** Clarissa Labrum

**Language:** Java 

**Description/Purpose:** Solves a poisson system of equations using conjugate gradient

**Input:** 

* int nx - column width
* int ny - row width
* double[][] A - initialized matrix
* double[] f - right hand side of system of equations
* double[] u - past values from iteration
* double tolerance - how exact the result should be

**Output:** 

Returns an array of doubles that approximates the solution and prints out how many iterations were completed.


**Usage/Example:**

To use the routine the following call needs to be made.

    double[] x = PentadiagMatrix.conjugateGradient(nx,ny,A,f,u,tolerance);

**Implementation/Code:** The following is the code for conjugateGradient

    public static double[] conjugateGradient(int nx, int ny, double[][] A, double[] f, double[] u, double tolerance) {
        int width = nx * ny;
        double error = 0;
        int interations = 0;
        double[] r = new double[width];
        double[] rold = new double[width];
        double[] p = new double[width];
        double[] w;
        double alpha;
        double beta;


        double[] Au = multiplyMatrices(A, u);
        for (int i = 0; i < r.length; i++) {
            r[i] = f[i] - Au[i];
        }
        for (int i = 0; i < r.length; i++) {
            p[i] = r[i];
        }

        do {
            for (int i = 0; i < r.length; i++) {
                rold[i] = r[i];
            }

            w = multiplyMatrices(A, p);
            alpha = multiplyMatrices(r, r) / multiplyMatrices(p, w);
            for (int i = 0; i < u.length; i++) {
                u[i] = u[i] + alpha * p[i];
                r[i] = r[i] + alpha * w[i];
            }
            beta = multiplyMatrices(r, r) / multiplyMatrices(rold, rold);
            for (int i = 0; i < p.length; i++) {
                p[i] = r[i] + beta * p[i];
            }

            for (int i = 0; i < width; i++) {
                error += (r[i] - rold[i]) * (r[i] - rold[i]);
            }
            error = Math.sqrt(error);
            interations++;
        }
        while (error > tolerance +1);
        System.out.println("iterations: " + interations);

        return r;
    }

**Last Modified:** April/2020
