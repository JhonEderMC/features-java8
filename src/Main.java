import methodreference.MethodReference;
import newinterface.RunCasesInterface;
import stream.StreamUseCase;

public class Main {
    public static void main(String[] args) {
        // Reduce
        //Main.printSeparetor();
        //System.out.println("---------- Reduce ------------");
       /* Reduce.sumNumbers();
        Reduce.concatLetters();
        Reduce.concatUpperCaseLetters();
        Reduce.sumNumbersParallel();
        Reduce.caculateUsersAge();
        //Reduce.divZeroExecption();
        //Reduce.catZeroExepction();
        Reduce.ratingAverage();
        Main.printSeparetor();*/

        // Stream
        //Main.printSeparetor();
        //System.out.println("---------- Stream ------------");
        //StreamUseCase.waysCreateFlowStream();
        //StreamUseCase.useDistinct();
        //StreamUseCase.anyMatchLetter();
        //StreamUseCase.filtering();
        StreamUseCase.testAddElementFirstArray();
        StreamUseCase.mapCovertToPath();
        //Main.printSeparetor();

        //Interface:
        Main.printSeparetor();
        System.out.println("---------- Interface ------------");
        new RunCasesInterface();
        Main.printSeparetor();

        //Method Reference
        Main.printSeparetor();
        System.out.println("---------- Method Reference ------------");
        MethodReference.staticMethodReference();
        MethodReference.referenceInstanceMethod();
        MethodReference.referenceInstanceMethodObjectParticularType();
    }

    public static void printSeparetor() {
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
}