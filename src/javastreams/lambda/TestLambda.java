package javastreams.lambda;

interface IMathOperations {
    Integer baseOperation();
}

public class TestLambda {
    Integer firstNumber = 5;
    static Integer secondNumber = 2;

    public static void main(String[] args) {
        TestLambda test = new TestLambda();
        test.testMathOperations(82, 21, 19);
    }

    void testMathOperations(Integer thirdNumber, Integer sixthNumber, final Integer seventhNumber) {
        Integer fourthNumber = 42;
        Integer fifthNumber = 8;
        fifthNumber += 1;
        sixthNumber = sixthNumber != null ? 1 : 0;
        // seventhNumber=5;// Compile time error seventhNumber is a final parameter.A new value can't be assigned
        printResult(() -> firstNumber * 2);
        printResult(() -> secondNumber + 2);
        printResult(() -> thirdNumber - 2);
        printResult(() -> fourthNumber / 2);
        //printResult(()-> fifthNumber + 2); //Compile time error fifthNumber is not an effective final variable
        // printResult(()-> sixthNumber + 2);//Compile time error fifthNumber is not an effective final parameter

    }

    void printResult(IMathOperations item) {
        System.out.println(item.baseOperation());
    }


}
