import java.lang.Math;

public class FiniteDiffCoeff {
    private double[][] A;
    private double[] xrow;
    private double[] b;
    private double[] sol;

     public FiniteDiffCoeff(int k, double xbar, double[] x){
         A = new double[x.length][x.length];
         xrow = new double[x.length];
         for (int i = 0; i < x.length; i++) {
             xrow[i] = x[i] - xbar;
         }
         for (int i = 1; i < x.length; i++){
             for (int j = 0; j < x.length; j++){
                 A[i][j] = Math.pow(xrow[i], i) / factorial(i);
             }
         }
         b = new double[x.length];
         for (int i = 0; i < x.length; i++){
             b[i] = 0;
         }
         b[k] = 1;

         sol = new double[x.length];
         sol = matrixSolver(A, b);
     }

    public double[] getSol() {
        return sol;
    }

    private static int factorial(int n)
    {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public double[] matrixSolver(double[][] A, double[] b){
         double[] x = new double[b.length];
         for (int k = 1; k < (b.length - 1); k++){
             for (int i = k + 1; i < b.length; i++){
                 double factor = A[i][k] / A[k][k];
                 for (int j = k + 1; j < b.length; j++){
                     A[i][j] = A[i][j] - factor * A[k][j];
                 }
                 b[i] = b[i] - factor * b[k];
             }
         }
         x[b.length - 1] = b[b.length - 1] / A[b.length - 1][b.length - 1];
         for (int i = b.length - 2; i >= 0; i--){
             x[i] = b[i];
             for (int j = i + 1; j < b.length; j++){
                 x[i] = x[i] - A[i][j] * x[j];
             }
             x[i] = x[i] / A[i][i];
         }
         return x;
    }
}
