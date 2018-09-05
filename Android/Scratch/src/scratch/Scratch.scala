package scratch

object Scratch extends App {

val l = List(2, 4, -6, 3, 1, 8, 7, 10, 0)
val p = (i : Int) => i % 2 == 0

def magic[T](elems: Seq[T], p: T => Boolean): Seq[Seq[T]] = elems match {
    case Seq() => Seq()
    case Seq(head, tail @ _*) if !p(head) => Seq(head) +: magic(tail, p)
    case xs => 
      val (prefix, rest) = xs span p
      prefix +: magic(rest, p)
  }

def magic2[T](elems: Seq[T], p: T => Boolean): Seq[Seq[T]] = {
  def iter(elems: Seq[T], out: Seq[Seq[T]]) : Seq[Seq[T]] = 
    elems match {
      case Seq() => out.reverse
      case Seq(head, tail @ _*) if !p(head) => iter(tail, Seq(head) +: out)
      case xs => 
        val (prefix, rest) = xs span p
        iter(rest, prefix +: out)
    }
  iter(elems, Seq())
}

val res = magic2(l,p)
println(res)
println(res.flatten)


}