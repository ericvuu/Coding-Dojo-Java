public class StringManipulatorTest{
  public static void main(String[] args){

    StringManipulator combineString = new StringManipulator();
    String str = combineString.trimAndConcat("    Hello     ","     World    ");
    System.out.println(str); // HelloWorld

    StringManipulator stringIDX1 = new StringManipulator();
    char letter = 'o';
    Integer a = stringIDX1.getIndexOrNull("Coding", letter);
    Integer b = stringIDX1.getIndexOrNull("Hello World", letter);
    Integer c = stringIDX1.getIndexOrNull("Hi", letter);
    System.out.println(a); // 1
    System.out.println(b); // 4
    System.out.println(c); // null

    StringManipulator stringIDX2 = new StringManipulator();
    String word = "Hello";
    String subString = "llo";
    String notSubString = "world";
    Integer d = stringIDX2.getIndexOrNull(word, subString);
    Integer e = stringIDX2.getIndexOrNull(word, notSubString);
    System.out.println(d); // 2
    System.out.println(e); // null

    StringManipulator shortString = new StringManipulator();
    String word1 = shortString.concatSubstring("Hello", 1, 2, "world");
    System.out.println(word1); // eworld

  }
}
