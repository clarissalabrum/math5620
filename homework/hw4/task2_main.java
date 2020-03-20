public static void main(String[] args) {
      ArrayList<Double> h_error = new ArrayList<>();
      ArrayList<Double> h_list = new ArrayList<>();

      for (int k = 8; k < 257; k=k*2) {
          int size = k+1;
          double h = 1.0 / (size - 1);
          h_list.add(h);
          double alpha = 0;
          double beta = 0;
          double[] x = new double[size];
          double[] u = new double[size];
          u[0] = alpha;
          u[u.length - 1] = beta;
          x[0] = 0;
          x[x.length - 1] = 1;
          for (int i = 1; i < x.length - 1; i++) {
              x[i] = x[i - 1] + h;
          }
          for (int i = 1; i < x.length - 1; i++) {
              u[i] = (1.0 / 6) * Math.pow(x[i], 3) - (1.0 / 12) *
                      Math.pow(x[i], 4) - (1.0 / 12) * x[i];
          }
          double[] f = new double[size - 1];
          for (int i = 1; i < f.length; i++) {
              f[i] = x[i] - x[i] * x[i];
          }
          double[] asval = new double[size];
          double[] adval = new double[size];
          for (int i = 0; i < size; i++) {
              asval[i] = 1;
              adval[i] = -2;
          }
          double[][] A = TridiagMatrix.tridiag(size - 1, asval, adval, asval);
          double[] F = TridiagMatrix.rhs(f, alpha, beta, h, size - 1);
          double[] U = TridiagMatrix.solver(F, A, size - 1);
          double[] error = new double[U.length];
          for (int i = 0; i < U.length; i++) {
              error[i] = U[i]-u[i+1];
          }
          double total_error = 0;
          for (double v : error) {
              total_error += v * v;
          }
          h_error.add(Math.sqrt(total_error));
      }
      System.out.println(TridiagMatrix.rateOfConverg(h_error, h_list));
}
