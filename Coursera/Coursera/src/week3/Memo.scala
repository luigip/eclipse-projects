package week3

import collection.mutable

object Memoization {

  class MFunc[A,R](f: A => R) extends (A => R) {
    private val cache = new mutable.HashMap[A,R]()
    def apply(a: A) = cache.getOrElseUpdate(a, f(a))
    def memo = this
  }

  implicit def functionIsMFunc[A,B](f: A => B) = new MFunc(f)


//  class MFunc2[A,B,R](f: (A, B) => R) extends ((A, B) => R) {
//    private val cache = new mutable.HashMap[(A, B),R]()
//    def apply(a: A, b: B) = cache.getOrElseUpdate((a, b), f(a, b))
//    def memo = this
//  }
//
//  implicit def memo[A,B,R](f: (A, B) => R) = new MFunc2(f)

}

object MemTest extends App {
  import Memoization._
  //test
  val f = {a: String => println("calculating " + a); a.length}.memo

  def g(s: String, c: Char): Int = { println("calculating " + s); s.count(c == _) }

  val h = (g _).tupled.memo
  
  def e0(x: Int) = x * 2
//  f("a")
//  f("bb")
//  f("cc")
//  f("bb")
//  f("a")
//  f("aaa")

  h("aac",'a')
  h("aac",'a')
  h("aac",'c')  
}