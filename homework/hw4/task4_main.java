public static void main(String[] args) throws FileNotFoundException {
    ArrayList<String> filenum = ReadFromFile("data.txt");
    double[] numbers = new double[filenum.size()];

    double[] x = new double[numbers.length];
    double[] f = new double[numbers.length - 1];
    double h = 1.0/(numbers.length-1);
    for (int i = 0; i < filenum.size(); i++) {
        numbers[i] = Double.parseDouble(filenum.get(i));
    }
    x[0] = 0;
    x[x.length - 1] = 1;
    for (int i = 1; i < x.length - 1; i++) {
        x[i] = x[i - 1] + h;
    }
    for (int i = 1; i < f.length; i++) {
        f[i] = x[i] - x[i] * x[i];
    }

    double[][] A = TridiagMatrix.linearTridiag(numbers.length, numbers);
    double[] F = TridiagMatrix.rhs(f, 0, 0, h, numbers.length);
    double[] U = TridiagMatrix.solver(F, A, numbers.length);
    for (int i = 0; i < U.length; i++) {
        TridiagMatrix.printResults(0,0,U);
    }


}

private static ArrayList<String> ReadFromFile(String fileName) throws FileNotFoundException {
    fileName = "data/" + fileName;
    String line = "";
    ArrayList<String> numbers = new ArrayList<>();

    // pass the path to the file as a parameter
    File file = new File(fileName);
    Scanner sc = new Scanner(file);

    while (sc.hasNextLine()) {
        line = sc.nextLine();
        if (!line.equals("")) {
            String [] subLine = line.split(" ");
            for (String subword:subLine) {

                if (!subword.equals("")) {
                    numbers.add(subword.replace(" ", ""));
                }
            }
        }
    }
    return numbers;
}
