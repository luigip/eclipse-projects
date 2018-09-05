package euler

/*
Rules deduced:

4 consecutive UNITS I, X, C, M can be reduced to subtractive pair
2,3,4 consecutive FIVES V, L, D reduce to X,XV,XX etc

VIIII
VIV <- ? how to reduce
 If a subtractive pair occurs where the larger part (V) is a FIVE and the
 same as the previous numeral, replace larger part with higher UNIT
 
Recurse until no change
*/

object P089 extends App {
  val nums = io.Source.fromURL(getClass.getResource("roman.txt")).getLines.toList

  case class Num(ch: Char, value: Int, tween: Boolean)
  val numerals = Set(Num('I',1,false), Num('V',5,true), Num('X',10,false),Num('L',50,true),Num('C',100,false),Num('D',500,true),Num('M',1000,false))
  val numeralsMap = numerals.map(x => x.ch -> x).toMap

  val charsTotal = nums.map(_.length).sum 
  
  def makeString(es: Seq[Seq[Num]]): String = (es flatMap (_ map (_.ch))).mkString
                                               
  def elems(num: Seq[Num]): Seq[Seq[Num]] = num.tail.foldLeft(Vector(Vector(num.head))){ case (acc, n) =>
    // add to existing
    if (acc.last.last == n || acc.last.last.value < n.value) acc.init :+ (acc.last :+ n)
    else acc :+ Vector(n)
  }                                            
  
  def reduceElem(e: Seq[Num]): Seq[Num] = {
    if (e.length == 4 && e.toSet.size == 1 && e.head.value < 1000 && !e.head.tween)
      Seq(e.head, numerals.find(_.value == e.head.value * 5).get)
    else if (e.length > 1 && e.toSet.size == 1 && e.head.tween)
      (if (e.length % 2 == 0) Seq.fill(e.length/2)(e.head) else Seq.fill(e.length/2)(e.head) :+ numerals.find(_.value == e.head.value * 5).get)
    else e
  }                                           
  
  def combineElems(es: Seq[Seq[Num]]): Seq[Seq[Num]] = es.tail.foldLeft(Seq(es.head)){ case (a, b) =>
    // tween followed by subtractive pair of same tween
    if (b.size == 2 && b(0).value < b(1).value && a.last.last == b(1) && b(1).tween)
      a.init :+ Seq(b(0), numerals.find(_.value == b(1).value * 2).get)
    else a :+ b
  }                                              
     
  def repeatCombine(es: Seq[Seq[Num]]): Seq[Seq[Num]] = {
    val ce = combineElems(es)
    if (ce == es) es else repeatCombine(ce)
  }                                               

  val rs = (nums).map(_.toSeq map numeralsMap).map(elems).map(_ map reduceElem).map(repeatCombine).map(makeString)

  val rlen = rs.map(_.length).sum 
  val result = charsTotal - rlen 
  println(result)
}