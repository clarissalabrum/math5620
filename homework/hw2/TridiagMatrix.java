public class TridiagMatrix {

   double[] as;
   double[] ad;
   double[] al;
   double[] F;
   int size;

   public TridiagMatrix(int width){
       size = width;

       as = new double[size-2];
       ad = new double[size-1];
       al = new double[size-2];

       for (int i = 0; i < (size-1); i++){
           ad[i] = -2;
           if(i == (size - 2)) {
               break;
           }
           as[i] = 1;
           al[i] = 1;
       }
   }

   public double[] rhs(double[] f, double alpha, double beta, double h){
        F = new double[size -1];
        double hsq = h * h;
        F[0] = (f[0] * hsq) - alpha;
        F[size -2] = (f[size -2] * hsq) -beta;
        for (int i = 1; i < (size - 2); i++){
            F[i] = f[i] * hsq;
        }
        return F;
   }

    public double[] solver(double[] F){
       //Full Matrix Reduction
        for (int i = 0; i < (size - 2); i++){
            double factor = al[i] / ad[i];
            al[i] = al[i] - (factor * ad[i]);
            ad[i+1] = ad[i+1] - (factor * as[i]);
            F[i+1] = F[i+1] - factor * F[i];
        }
        //Back Substitution
        double[] x = new double[size-1];
        x[size - 2] = F[size - 2] / ad[size -2];
        for (int i = size - 3; i >= 0; i--){
            x[i] = F[i] - as[i] * x[i+1];
            x[i] = x[i] / ad[i];
        }
        return x;
    }
}
