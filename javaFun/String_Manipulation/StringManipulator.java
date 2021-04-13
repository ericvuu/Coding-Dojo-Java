public class StringManipulator{

  public String trimAndConcat(String str1, String str2){
    return str1.trim() + str2.trim();
  }

  public Integer getIndexOrNull(String strArg, char charArg){
    // indexOf will return -1 by default if not found
    if(strArg.indexOf(charArg) >= 0){
      return strArg.indexOf(charArg);
    } else {
      return null;
    }
  }

  public Integer getIndexOrNull(String str1, String str2){
    // indexOf will return -1 by default if not found
    if(str1.indexOf(str2) >= 0){
      return str1.indexOf(str2);
    } else {
      return null;
    }
  }

  public String concatSubstring(String str1, int int1, int int2, String str2){
    return str1.substring(int1, int2) + str2;
  }

}
