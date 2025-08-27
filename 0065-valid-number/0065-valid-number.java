class Solution {
  public boolean isNumber(String s) {
    int eIndex = Math.max(s.indexOf('e'), s.indexOf('E'));
    eIndex = eIndex == -1? s.length() : eIndex;
    return (isInteger(s, 0, eIndex) || isDecimal(s, 0, eIndex)) 
        && (eIndex < s.length()? isInteger(s, eIndex + 1, s.length()) : true);
  }
  
  private boolean isInteger(String s, int beginIndex, int endIndex) {
    int i = getIndexAfterSign(s, beginIndex, endIndex);
    if (i < 0)
      return false;
    while (i < endIndex && Character.isDigit(s.charAt(i))) 
      i++;
    return i == endIndex;
  }
  
  private boolean isDecimal(String s, int beginIndex, int endIndex) {
    int i = getIndexAfterSign(s, beginIndex, endIndex);
    if (i < 0)
      return false;
    if (s.charAt(i) == '.' && i+1 == endIndex)
      return false;
    while (Character.isDigit(s.charAt(i)))
      i++;
    if (s.charAt(i) == '.')
      i++;
    while (i < endIndex && Character.isDigit(s.charAt(i)))
      i++;
    return i == endIndex;
  }
  
  private int getIndexAfterSign(String s, int beginIndex, int endIndex) {
    int i = beginIndex;
    if (i == endIndex)
      return -1;
    if (s.charAt(i) == '+' || s.charAt(i) == '-')
      if (++i == endIndex)
        return -1;
    return i;
  }
}