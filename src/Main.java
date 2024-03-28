import collect.CollectMethodUse;
import emptyList.EmptyList;
import methodreference.MethodReference;
import newinterface.RunCasesInterface;
import optional.UseOptional;
import paralell.Paralell;
import reduce.Reduce;
import stream.StreamUseCase;

public class Main {
    public static void main(String[] args) {
        // Reduce
        Main.printSeparetor();
        System.out.println("---------- Reduce ------------");
        Reduce.sumNumbers();
        Reduce.range();
        Reduce.concatLetters();
        Reduce.concatUpperCaseLetters();
        Reduce.sumNumbersParallel();
        Reduce.caculateUsersAge();
        //Reduce.divZeroExecption();
        //Reduce.catZeroExepction();
        Reduce.ratingAverage();
        Reduce.minNumber();
        Reduce.maxNumber();
        Main.printSeparetor();

        //Collector
        Main.printSeparetor();
        System.out.println("---------- Collector ------------");
        CollectMethodUse.toListString();
        CollectMethodUse.toListStringJoining();
        CollectMethodUse.toListPrice();
        CollectMethodUse.toSumAll();
        CollectMethodUse.averagePrice();
        CollectMethodUse.intSummaryStatistics();
        CollectMethodUse.toGroupingBy();
        CollectMethodUse.toMapPartionedBy();
        CollectMethodUse.toCollectingAndThen();
        CollectMethodUse.toCustomCollector();
        Main.printSeparetor();

        // Stream
        Main.printSeparetor();
        System.out.println("---------- Stream ------------");
        StreamUseCase.streamOfArray();
        StreamUseCase.streamBuilder();
        StreamUseCase.streamGenerate();
        StreamUseCase.streamIterate();
        StreamUseCase.streamPrimitivesIntLongDouble();
        StreamUseCase.StreamOfString();
        StreamUseCase.waysCreateFlowStream();
        StreamUseCase.useDistinct();
        StreamUseCase.anyMatchLetter();
        StreamUseCase.filtering();
        StreamUseCase.testAddElementFirstArray();
        StreamUseCase.mapCovertToPath();
        StreamUseCase.streamReferencing();
        StreamUseCase.pipeline();
        StreamUseCase.lazyInvocation();
        StreamUseCase.orderOfExecution();
        Main.printSeparetor();

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

        //Optional
        Main.printSeparetor();
        System.out.println("---------- Optional ------------");
        UseOptional.orElseGet();
        UseOptional.defaultAdressIfnotIxist();
        UseOptional.listUserAdress();
        Main.printSeparetor();

        //Paralell
        Main.printSeparetor();

        System.out.println("---------- Parallel ------------");
        Paralell.isParalell();
        Paralell.bigPrice();
        Paralell.intStreamParalell();
        Paralell.sequential();
        Main.printSeparetor();

        //EmptyList
        Main.printSeparetor();
        System.out.println("---------- EmptyList ------------");
        EmptyList.handlingNullPointerExeptionBeforeJava8();

    }

    public static void printSeparetor() {
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
}