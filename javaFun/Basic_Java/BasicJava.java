import java.util.*;

public class BasicJava{
  public void print1To255(){
    for(int i = 1; i < 256; i++){
      System.out.println(i);
    }
  }

  public void printOdd1To255(){
    for(int i = 1; i < 256; i++){
      if(i % 2 == 1){
         System.out.println(i);
      }
    }
  }

  public void printSum(){
    int total = 0;
    for(int i = 1; i < 256; i++){
      total+= i;
      System.out.println("New number: " + i + " Sum: " + total);
    }
  }

  public void interateArray(int[] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }

  public void findMax(int[] arr){
    int maxNum = arr[0];
    for(int i = 1; i < arr.length; i++){
      if(maxNum < arr[i]){
        maxNum = arr[i];
      }
    }
    System.out.println("The max number in the array is " + maxNum);
  }

  public void getAverage(int[] arr){
    int total = 0;
    for(int i = 0; i < arr.length; i++){
      total += arr[i];
    }
    int average = total/arr.length;
    System.out.println("The average is " + average);
  }

  public ArrayList arrayOfOdd(){
    ArrayList<Integer> y = new ArrayList<Integer>();
    for(int i = 1; i < 256; i++){
       if(i % 2 == 1){
         y.add(i);
      }
    }
    return y;
  }

  public int[] squareValues(int[] arr){
    for(int i = 0; i < arr.length; i++){
      int squareVal = (int) arr[i] * arr[i];
      arr[i] = squareVal;
    }
    return arr;
  }

  public  int[] eliminateNegativeNumbers(int[] arr){
      for(int i = 0; i < arr.length; i++){
        if(arr[i] < 0){
          arr[i] = 0;
        }
    }
    return arr;
  }

  public int[] maxMinAvg(int[] arr){
    int total = 0;
    int maxNum = arr[0];
    int minNum = arr[0];

    for(int i = 0; i < arr.length; i++){
      if(arr[i] > maxNum){
        maxNum = arr[i];
      } else {
        minNum = arr[i];
      }
      total += arr[i];
    }
    int avg = total/arr.length;
    int[] output = {maxNum, minNum, avg};
    return output;
  }

  public int[] shiftingValues(int[] arr){
    for(int i = 1; i < arr.length; i++){
      arr[i-1] = arr[i];
    }
    arr[arr.length-1] = 0;
    return arr;
  }


}
