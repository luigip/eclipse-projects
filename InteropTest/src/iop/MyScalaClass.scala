package iop

class MyScalaClass {}

object MyScalaObject {
  def main(args: Array[String]) {
    val jc = new MyJavaClass
    println(jc.name)
    println(jc.doit)
    jc.proc(11)
  }  
  
  def method(s: String) = s.reverse
  val value = 123
}