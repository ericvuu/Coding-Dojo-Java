import java.util.*;

public class PuzzleJavaTest{
  public static void main(String[] args){

    PuzzleJava testObj = new PuzzleJava();

    int[] sumAndGreater10Test = {3,5,1,2,7,9,8,13,25,32};
    System.out.println((testObj.printSumReturnGreater10(sumAndGreater10Test)));

    String[] shufflePrintLongerThan10Test = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
    System.out.println(testObj.shufflePrintLongerThan10(shufflePrintLongerThan10Test));

    String[] letters = {"A", "B", "C", "D","E", "F", "G", "H", "I", "J", "K", "L","M","N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    testObj.alphabetShuffleAndPrint(letters);

    System.out.println(Arrays.toString(testObj.tenRandomNumbers()));

    System.out.println(testObj.randomNumberSort());
    System.out.println(testObj.random5CharString());

    System.out.println(Arrays.toString(testObj.randomStringArray()));

  }
}
