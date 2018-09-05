package scratch

import collection.mutable.ArrayBuffer

object Scratch {

  val EXAMPLE = ArrayBuffer(("ab","cd"),("ef","gh"))
  
  def doit(xs: Seq[(String, String)]) = xs foreach println
  
//  @annotation.varargs
//  def getSeq[T](x: T*): Seq[T] = x
  
  @annotation.varargs
  def getSeq(x: String*): Seq[String] = x.toSeq
  
  def seqFromList[T](list: java.util.List[T]): Seq[T] = {
    import collection.JavaConverters._
    list.asScala
  }
  
  
  //doit(EXAMPLE)
  
}

