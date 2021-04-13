import java.util.Arrays;

public class BasicJavaTest{
  public static void main(String[] args){

    BasicJava testObj = new BasicJava();

    testObj.print1To255();
    testObj.printOdd1To255();
    testObj.printSum();

    int[] x = {1,3,5,7,9,13};
    testObj.interateArray(x);
    testObj.findMax(x);

    int[] testAvg = {2,10,3};
    testObj.getAverage(testAvg);

    System.out.println(testObj.arrayOfOdd());

    int[] squareArrayTest = {1, 5, 10, -2};
    System.out.println(Arrays.toString(testObj.squareValues(squareArrayTest)));

    int[] negativeNumTest = {1, 5, 10, -2};
    System.out.println(Arrays.toString(testObj.eliminateNegativeNumbers(negativeNumTest)));

    int[] maxMinAvgTest = {1, 5, 10, -2};
    System.out.println(Arrays.toString(testObj.maxMinAvg(maxMinAvgTest)));

    int[] shiftingValuesTest = {1, 5, 10, 7, -2};
    System.out.println(Arrays.toString(testObj.shiftingValues(shiftingValuesTest)));

  }
}
