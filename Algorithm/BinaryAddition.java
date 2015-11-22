import java.util.*;

public class BinaryAddition
{
 
 public static void main(String args[])
  {

int a;
int b;
String sa;
String sb;

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter two numbers: ");
    a = scanner.nextInt();
    b = scanner.nextInt();

    sa = Integer.toBinaryString(a);
    sb = Integer.toBinaryString(b);

    System.out.println(sa);
    System.out.println(sb);

  }

}
 
