import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
  public ArrayList printSumReturnGreater10(int[] arr){
    ArrayList<Integer> outputArray = new ArrayList<Integer>();
    int total = 0;
    for(int i = 0; i < arr.length; i++){
      if(arr[i] > 10){
        outputArray.add(arr[i]);
      }
      total += arr[i];
    }
    System.out.println(total);
    return outputArray;
  }

  public ArrayList shufflePrintLongerThan10(String[] arr){
    Collections.shuffle(Arrays.asList(arr));
    ArrayList<String> outputArray = new ArrayList<String>();
    for(int i = 0; i < arr.length; i++){
      System.out.println(arr[i]);
      if(arr[i].length() > 5){
        outputArray.add(arr[i]);
      }
    }
    return outputArray;
  }

  public void alphabetShuffleAndPrint(String[] arr){
    Collections.shuffle(Arrays.asList(arr));
    System.out.println("The last letter of the array is: " + arr[25]);
    if(arr[0] != "A" || arr[0] != "E" || arr[0] != "I" || arr[0] != "O" || arr[0] != "U"){
      System.out.println("The first letter of the array is not a vowel");
    } else {
      System.out.println("The first letter of the array is: " + arr[0]);
    }
  }

  public int[] tenRandomNumbers(){
    int[] outputArray;
    outputArray = new int[10];
    Random r = new Random();
    for(int i = 0; i < 10; i++){
      int randomNum = r.nextInt(100 - 55) + 55;
      outputArray[i] = randomNum;
    }
    return outputArray;
  }

  public ArrayList randomNumberSort(){
    ArrayList<Integer> outputArray = new ArrayList<Integer>();
    Random r = new Random();
    for(int i = 0; i < 10; i++){
      int randomNum = r.nextInt(100 - 55) + 55;
      outputArray.add(randomNum);
    }
    Collections.sort(outputArray);
    System.out.println("The smallest number of the array is: " + outputArray.get(0));
    System.out.println("The smallest number of the array is: " + outputArray.get(9));
    return outputArray;
  }

  public String random5CharString(){
    String output = "";
    String[] letters = {"A", "B", "C", "D","E", "F", "G", "H", "I", "J", "K", "L","M","N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    Random r = new Random();
    for(int i = 0; i < 5; i++){
      int position = r.nextInt(25);
      output += letters[position];
    }
    return output;
  }

  public String[] randomStringArray(){
    String[] output;
    output = new String[10];
    for(int i = 0; i < 10; i++){
      String word = random5CharString();
      output[i] = word;
    }
    return output;
  }
}
