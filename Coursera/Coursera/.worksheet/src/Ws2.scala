object Ws2 {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(193); 
  
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, a + acc)
    }
    
    loop(a, 0)
  };System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""")}
}