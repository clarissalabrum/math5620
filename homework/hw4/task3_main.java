 public static void main(String[] args) {
      ArrayList<Double> h_error = new ArrayList<>();
      ArrayList<Double> h_list = new ArrayList<>();

      int _size = 2049;
      double _h = 1.0 / (_size - 1);
      double _alpha = 0;
      double _beta = 0;
      double[] _x = new double[_size];
      double[] _f = new double[_size - 1];
      double[] _asval = new double[_size-1];
      double[] _adval = new double[_size-1];
      double[] _alval = new double[_size-1];

      _x[0] = 0;
      _x[_x.length - 1] = 1;
      for (int i = 1; i < _x.length - 1; i++) {
          _x[i] = _x[i - 1] + _h;
      }

      for (int i = 1; i < _x.length-1; i++) {
          double v = Math.PI * _h / 2 * Math.cos(_x[i] * Math.PI);
          double sin = Math.sin(_x[i] * Math.PI);
          _alval[i-1] = sin + v;
          _asval[i-1] = sin - v;
          _adval[i-1] = -2 * sin;
      }

      for (int i = 1; i < _f.length; i++) {
          _f[i] = _x[i] - _x[i] * _x[i];
      }

      double[][] _A = TridiagMatrix.tridiag(_size - 1, _asval, _adval, _alval);
      double[] _F = TridiagMatrix.rhs(_f, _alpha, _beta, _h, _size - 1);
      double[] u = TridiagMatrix.solver(_F, _A, _size - 1);


      for (int k = 8; k < 1030; k=k*2) {
          int size = k+1;
          double h = 1.0 / (size - 1);
          h_list.add(h);
          double alpha = 0;
          double beta = 0;
          double[] x = new double[size];
          double[] f = new double[size - 1];
          double[] asval = new double[size-1];
          double[] adval = new double[size-1];
          double[] alval = new double[size-1];

          x[0] = 0;
          x[x.length - 1] = 1;
          for (int i = 1; i < x.length - 1; i++) {
              x[i] = x[i - 1] + h;
          }

          for (int i = 1; i < f.length; i++) {
              f[i] = x[i] - x[i] * x[i];
          }

          for (int i = 1; i < x.length-1; i++) {
              double v = Math.PI * _h / 2 * Math.cos(_x[i] * Math.PI);
              double sin = Math.sin(_x[i] * Math.PI);
              alval[i-1] = sin + v;
              asval[i-1] = sin - v;
              adval[i-1] = -2 * sin;
          }
          //Get Approx
          double[][] A = TridiagMatrix.tridiag(size - 1, asval, adval, alval);
          double[] F = TridiagMatrix.rhs(f, alpha, beta, h, size - 1);
          double[] U = TridiagMatrix.solver(F, A, size - 1);

          //2 Norm
          double[] error = new double[U.length];
          for (int i = 0; i < U.length; i++) {
              error[i] = U[i]-u[i];
          }
          double total_error = 0;
          for (double v : error) {
              total_error += v * v;
          }
          h_error.add(Math.sqrt(total_error));
      }
      for (double val: h_error) {
          System.out.println(val);
      }
      System.out.println(TridiagMatrix.rateOfConverg(h_error, h_list));
}
