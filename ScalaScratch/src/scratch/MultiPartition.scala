package scratch
import scala.collection.generic.CanBuildFrom
import scala.collection.mutable.ArrayBuffer

object MultiPartition extends App {

  def multiPartition[T, C[X] <: Traversable[X]](xs: C[T])(fs: T => Boolean *)(implicit cbf: CanBuildFrom[C[_],T,C[_]]) = {
    
    val builders = Vector.fill(fs.length)(cbf())
    for (e <- xs) {
      val i = fs.indexWhere(f => f(e))
      if (i >= 0) builders(i) += e
    }
    
    builders.map(_.result)
  }
  
  def multiPartition2[T: Manifest](xs: Traversable[T])(fs: T => Boolean *) = {
    val builders = Vector.fill(fs.length)(ArrayBuffer.empty[T])
    for (e <- xs) {
      val i = fs.indexWhere(f => f(e))
      if (i >= 0) builders(i) += e
    }
    builders.map(_.toArray)    
  }
  
  
  
  
  
  // ----------TEST---------------
  
  case class Person(val name: String, val age: Int)
  
  val people = Array(Person("Doris", 100), Person("Barry", 60), Person("Mary", 45), Person("Justin", 16))
  
  val Seq(minors, adults, seniors) = multiPartition2(people)(_.age < 18, p => 18 < p.age && p.age < 65, _.age > 65)
  
//  println(minors, adults, seniors)
  println(minors mkString " ")
  println(adults mkString " ")
  println(seniors mkString " ")
}  
