**Routine Name:** rateOfConverg

**Author:** Clarissa Labrum

**Language:** Java 

**Description/Purpose:** This routine finds the convergence rate for an elliptic problem

**Input:** This rountine requires the following parameters

* ArrayList<Double> h_error - array list of the 2 norm errors for each h tested.
* ArrayList<Double> h_list - array list of the h's being used in each approximation.

**Output:** This routine returns the convergence rate

**Usage/Example:**

A call to this program first requires the user to run an approximation with difference 
size h's (interval size between mess points). They then need to create two ArrayLists.
The first contains all the h's used. The other is where the 2 Norm of the error is 
stored. The last step is to make the following call and it will return a double that 
is the rate of convergence.

      TridiagMatrix.rateOfConverg(h_error, h_list));


**Implementation/Code:** The following is the code for rateOfConverg

    public static double rateOfConverg(ArrayList<Double> h_error, ArrayList<Double> h_list){
       double[][] regA = new double[2][2];
       double[] regF = new double[2];
       double sum_h_list = 0;
       double sum_h_list_sqr = 0;
       double sum_h_error = 0;
       double sum_h_errlist = 0;

       for (int i = 0; i < h_error.size(); i++) {
            h_error.set(i,Math.log(h_error.get(i)));
            h_list.set(i,Math.log(h_list.get(i)));
        }

        for (int i = 0; i < h_error.size(); i++) {
            sum_h_list += h_list.get(i);
            sum_h_list_sqr += h_list.get(i)*h_list.get(i);
            sum_h_error += h_error.get(i);
            sum_h_errlist += h_list.get(i)*h_error.get(i);
        }
        regA[0][0] = h_list.size();
        regA[1][0] = sum_h_list;
        regA[0][1] = sum_h_list;
        regA[1][1] = sum_h_list_sqr;
        regF[0] = sum_h_error;
        regF[1] = sum_h_errlist;

        //regression solution
        double factor = regA[1][0] / regA[0][0];
        regA[1][1] = regA[1][1] - regA[0][1] * factor;
        regF[1] = regF[1] - regF[0] * factor;
        return  regF[1] / regA[1][1];
    }

**Last Modified:** March/2020
