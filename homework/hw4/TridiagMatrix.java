public class TridiagMatrix {

   //no constructors

   public static double[][] tridiag(int n, double asval, double adval, double alval){

       double[][] output = new double[3][n];

       for (int i = 0; i < n - 1; i++) {
           output[1][i] = adval;
       }
       for (int i = 0; i < n - 2; i++) {
           output[0][i] = alval;
           output[2][i] = asval;
       }
       return output;
   }

   public static double[][] linearTridiag(int n, double[] a){
       double[][] output = new double[3][n];

       double[] avea = new double[n+1];
       avea[0] = a[0];
       avea[avea.length-1] = a[a.length-1];
       for (int i = 0; i < a.length-1; i++) {
           avea[i+1] = .5 * (a[i] + a[i+1]);
       }

       for (int i = 0; i < n - 1; i++) {
           output[1][i] = -1 * (avea[i] + avea[i+1]);
       }
       for (int i = 0; i < n - 2; i++) {
           output[0][i] = avea[i+1];
           output[2][i] = avea[i+1];
       }
       return output;
   }

   public static double[] rhs(double[] f, double alpha, double beta, double h, int n){
        double[] F = new double[n -1];
        double hsq = h * h;
        F[0] = (f[0] * hsq) - alpha;
        F[n -2] = (f[n -2] * hsq) -beta;
        for (int i = 1; i < (n - 2); i++){
            F[i] = f[i] * hsq;
        }
        return F;
   }

    public static double[] solver(double[] F, double[][] tricoeff, int n){
       //Full Matrix Reduction
        for (int i = 0; i < (n - 2); i++){
            double factor = tricoeff[0][i] / tricoeff[1][i];
            tricoeff[0][i] = tricoeff[0][i] - (factor * tricoeff[1][i]);
            tricoeff[1][i+1] = tricoeff[1][i+1] - (factor * tricoeff[2][i]);
            F[i+1] = F[i+1] - factor * F[i];
        }
        //Back Substitution
        double[] x = new double[n-1];
        x[n - 2] = F[n - 2] / tricoeff[1][n -2];
        for (int i = n - 3; i >= 0; i--){
            x[i] = F[i] - tricoeff[2][i] * x[i+1];
            x[i] = x[i] / tricoeff[1][i];
        }
        return x;
    }
}
