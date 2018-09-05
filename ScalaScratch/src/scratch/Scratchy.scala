package scratch
import scala.annotation.varargs

object Testy {
  
  @annotation.varargs
  def printMe(xs: String *) {xs foreach println}
  
}

object Shuffler extends App {
  
  import java.util.Collections
  import java.util.Arrays
  import collection.mutable.ArrayBuffer
  
  
  val xs = new ArrayBuffer[Int]() {
    def shuffle(a: Int, b: Int) {
       array
      
      Collections.shuffle(Arrays.asList(array: _*).subList(a, b))
    }
  }
  
  xs ++= (0 to 9)    // xs = ArrayBuffer(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  println(xs)
  xs.shuffle(3, 8)   // xs = ArrayBuffer(0, 1, 2, 4, 6, 5, 7, 3, 8, 9)
  println(xs)
}