public class JavaProgram310 {
    public static void main(String[] args) {
        if (args.length == 3) { // this ensures that we have passed the correct amount of arguments into the program
            System.out.println("The command line arguments are:");
            int min = Integer.parseInt(args[0]); // convert arguments to int
            int max = Integer.parseInt(args[1]); // convert arguments to int
            int step_size = Integer.parseInt(args[2]); // convert arguments to int
            for (int i=min; i <= max; i=i+step_size) {
                double[][] matrix = new double[i][i]; // initialize matrix
                long startT = System.currentTimeMillis(); //start time
                init(matrix); //call row major
                long endT = System.currentTimeMillis(); // end time
                long startT1 = System.currentTimeMillis();
                init1(matrix); // call column major
                long endT1 = System.currentTimeMillis();
                double elapsedT = (endT - startT) / 1000.0; // calculate time
                double elapsedT1 = (endT1 - startT1) / 1000.0; // calculate time
                System.out.printf("m (#rows and cols): %s, elapsed time (row major): %.3f seconds, elapsed time (column major): %.3f seconds \n", i, elapsedT, elapsedT1);

            }
        

        } else {
            System.out.println("The incorrect number of command line arguments were entered. Try this in command line:");
            System.out.println("java FileName <min> <max> <step_size>");
        }
    }
    public static void init(double x[][]) { // function for traversing the matrix via rows
        int rows = x.length;
        int cols = x[0].length;
        double sum = 0.0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++, sum++){
                x[i][j] = sum; // initialize matrix with values 0 through max
            }
        }
    }
    public static void init1(double x[][]) { // function for traversing via columns
        int rows = x.length;
        int cols = x[0].length;
        double sum1 = 0.0;
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++, sum1++){
                x[i][j] = sum1; // initialize matrix with values 0 through max
            }
        }
    }
}