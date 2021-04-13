import java.util.*;

public class ListsOfExceptions{
  public ArrayList makeList(){
    ArrayList<Object> myList = new ArrayList<Object>();
    myList.add("13");
    myList.add("hello world");
    myList.add(48);
    myList.add("Goodbye World");

    for(int i = 0; i < myList.size(); i++) {
      try{
        Integer castedValue = (Integer) myList.get(i);
        System.out.print(myList.get(i) + " was converted to an integer.");
      } catch (Exception e){
        System.out.print("Error occured at index " + i + ", value: " + myList.get(i));
      }
    }
    return myList;
  }

}
