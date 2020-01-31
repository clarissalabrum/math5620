**Routine Name:** TridiagMatrix

**Author:** Clarissa Labrum

**Language:** Java 

**Description/Purpose:** TrigdiagMatrix is a java class that when an instance of the class is made a tridiagional matrix is initialized
with the specified size. The tridiagonal matrix is used to solve an elliptic problem.

**Input:** 

* The constructor of the class, TridiagMatrix, accepts the size of the elliptic problem, how many points are used in the 
approximation method. 
* The method rhs takes a double array of the function values, the boundy conditions alpha and beta, and the h of the 
problem which is usually the width between the points. 
* The solver method accepts the array that is returned from the rhs method.

**Output:** 

* The rhs method returns the right hand sign array. 
* The solver method returns the solution to the elliptic problem.

**Usage/Example:**

When an instance of the TridiagMatrix class is created with size n, the constructor creates the three diagional rows as one dimensional
arrays.

* ad is the main diagional of size n-1 intialized to the value -2.
* as is the super diagional and al is the lower. Both are size n-2 and are initialized to 1.

Creating an instance of the class would look like the following:
  
    TridiagMatrix A = new TridiagMatrix(size);

To create the right hand side array the rhs method is called with the arguments specified in the input. The method then returns the right
hand side array. 

A call to this method would look as follows:

    double[] rhs = A.rhs(f, alpha, beta, h);
  
To use the solver method the rhs array needs to be sent to the solver. The solver will use the rhs array and the initialized diagional
arrays to solve the elliptic problem. The mothos with return the solution array.

    double[] sol = A.solver(rhs);


**Implementation/Code:** The following is the code for TridiagMatrix.

[TridiagMatrix](https://github.com/clarissalabrum/math5620/blob/master/homework/hw2/TridiagMatrix.java)

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

**Last Modified:** January/2020
