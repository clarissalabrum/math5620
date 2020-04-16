public static void main(String[] args) {
        for (int k = 1; k >3; k++) {
            double h = 1 / Math.pow(10,k);
            int nx = (int) (3 / h);
            int ny = (int) (3 / h);
            int width = nx * ny;
            double tolerance = 0.0001;


            double[][] A = PentadiagMatrix.pentadiag(nx, ny);
            double x[] = new double[nx];
            double y[] = new double[ny];
            x[0] = y[0] = h;

            for (int i = 1; i < nx; i++) {
               x[i] = x[i-1] + h;
                y[i] = y[i-1] + h;

            }
            double[] f = new double[width];
            for (int i = 0; i < f.length; i++) {
                int row = i / nx;
                int col = i % nx;
                f[i] = x[col] * y[row];
            }

            double[][] cond = new double[4][nx];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < nx; j++) {
                    cond[i][j] = 2;
                }
            }

            double[] rhs = PentadiagMatrix.pentaRHS(nx, ny, cond, f, h);

            double[] xold = new double[width];
            for (int i = 0; i < xold.length; i++) {
                xold[i] = 1;
            }

            double[] xnew = PentadiagMatrix.conjugateGradient(nx, ny, A, rhs, xold, tolerance);

            PentadiagMatrix.printResults(xnew);
        }
    }
