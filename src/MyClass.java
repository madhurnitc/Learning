import java.util.Scanner;

public class MyClass {


     public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String FAILURE = "Failure";
        String SUCCESS = "SUCCESS";
        String RECIEVED = "RECIEVED";
        String EXPECTED = "EXPECTED";
        Scanner sc = new Scanner(System.in);

        int testCases = Integer.parseInt(sc.next());
        sc.nextLine();

        while(sc.hasNext()){

        }
        for(int i = 0; i<testCases; i++){
            String line = sc.nextLine();
            System.out.println("Line " +  line);
            String[] splittedArray = line.split("\\s+");
            int inputSize = splittedArray.length;
            int max =0;
            boolean errorOccured = false;
            for(int j = 0; j< inputSize; j++){
                try {
                    int event = Integer.parseInt(splittedArray[j]);
                    if(event > max) {
                        max = event;
                    }

                }catch(Exception e) {
                    errorOccured = true;
                    System.out.println(FAILURE + "=>" + "WRONG INPUT (" + i+1 + ")" );
                }
            }

            if(!errorOccured){
                if( max == inputSize) {
                    System.out.println(SUCCESS + "=> " + RECIEVED + ": " + max );
                }else {
                    System.out.println(FAILURE + "=> " + RECIEVED + ": " +inputSize + ", "+ EXPECTED + ": " +max );
                }
            }

        }
    }
}