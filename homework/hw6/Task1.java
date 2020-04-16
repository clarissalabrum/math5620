  public static void main(String[] args) {
      int nx = 3;
      int ny = 3;
      int width = nx * ny;
      double h = 1;
      double tolerance = 0.000001;

      double[][] A = PentadiagMatrix.pentadiag(nx,ny);

      int[] x = {1,2,3};
      int[] y = {1,2,3};
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

      double[] rhs = PentadiagMatrix.pentaRHS(nx,ny,cond,f,h);

      double[] xold = new double[width];
      for (int i = 0; i < xold.length; i++) {
          xold[i] = 2;
      }

      double[] xnew = PentadiagMatrix.gaussSeidel(nx,ny,A,rhs,xold,tolerance);

      PentadiagMatrix.printResults(xnew);
  }
