import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.print(":");
    String num = reader.next();
    System.out.println(num);

    Pattern r = Pattern.compile("([0-9]*)/([0-9]*)");

    // r.matcher(num).group
    Matcher m = r.matcher(num);
    
    System.out.println( String.valueOf(m));
  }
}
