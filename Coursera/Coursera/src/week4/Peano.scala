package week4

// Peano numbers
object WorkSheet extends App {
  val one = new Succ(Zero)
  val two = one + one
  val three = two.successor
  
  println(three - one)
}

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  def isZero: Boolean = true
  def predecessor: Nat = throw new UnsupportedOperationException("Zero.predecessor")
  def + (that: Nat): Nat = that
  def - (that: Nat): Nat = if (that.isZero) this else sys.error("Out of bounds")
  override def toString = "Zero"
}

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false
  def predecessor: Nat = n
  def + (that: Nat): Nat = if (that.isZero) this else new Succ(n + that)
  def - (that: Nat): Nat = if (that.isZero) this else n - that.predecessor
  override def toString = "Succ("+n.toString+")"
}