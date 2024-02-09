import newinterface.RunCasesInterface;
import stream.StreamUseCase;

public class Main {
    public static void main(String[] args) {
        // Reduce
       /* Reduce.sumNumbers();
        Reduce.concatLetters();
        Reduce.concatUpperCaseLetters();
        Reduce.sumNumbersParallel();
        Reduce.caculateUsersAge();
        //Reduce.divZeroExecption();
        //Reduce.catZeroExepction();
        Reduce.ratingAverage();*/

        // Stream
        //StreamUseCase.waysCreateFlowStream();
        //StreamUseCase.useDistinct();
        //StreamUseCase.anyMatchLetter();
        //StreamUseCase.filtering();
        StreamUseCase.testAddElementFirstArray();
        StreamUseCase.mapCovertToPath();

        //Interface:
        Main.printSeparetor();
        System.out.println("---------- Interface ------------");
        new RunCasesInterface();

    }

    public static void printSeparetor() {
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
}