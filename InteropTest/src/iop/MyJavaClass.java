package iop;

public class MyJavaClass {
  public String name = "xyz";
  public int doit() {return 69;}
  public void proc(int x) {System.out.println(x);}
  
  public static void main(String[] args) {
    String s = MyScalaObject.method("abc");
    System.out.println(s);
    int n = MyScalaObject.value();
    System.out.println(n);
    
  }
}
