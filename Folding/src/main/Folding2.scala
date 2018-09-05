//package folding
//
//class Matr(val mx: IndexedSeq[IndexedSeq[IndexedSeq[Int]]]) {
//  import Matr._
//  type Matrix = IndexedSeq[IndexedSeq[IndexedSeq[Int]]]
////  val sideLen = mx.
//  
//  def leftFold : Matrix = mx map { r => 
//    val (a, b) = r splitAt (r.size / 2) 
//    (a.reverse, b).zipped map (_.reverse ++ _)
//  }
//  
//  def rightFold: Matrix = mx map { r => 
//    val (a, b) = r splitAt (r.size / 2) 
//    (b.reverse, a).zipped map (_.reverse ++ _)
//  }
// 
//  def topFold   : Matrix = mx.transpose.leftFold.transpose
//  def bottomFold: Matrix = mx.transpose.rightFold.transpose
//  
//  def folds(input: String): Seq[Int] = input match {
//    case "" => mx(0)(0)
//    case s  => s.head match {
//      case 'L' => leftFold.folds(s.tail)
//      case 'R' => rightFold.folds(s.tail)
//      case 'T' => topFold.folds(s.tail)
//      case 'B' => bottomFold.folds(s.tail)
//    }
//  }
//  
//  def unfold: String = { 
////    val m0: Matrix = Vector(Vector(Vector(input: _*)))
//       
//    def go(m: Matrix, out: String): String = {
//      val tl = m.head.head
//      val bl = m.last.head
//      val tr = m.head.last
//      if (m.length == sideLen && m.head.length == sideLen) out.reverse
//      else if (tl.head == tl.last - 1)       go(leftUnfold(m),   out + 'L')
//      else if (tr.head == tr.last + 1)       go(rightUnfold(m),  out + 'R')
//      else if (tl.head == tl.last - sideLen) go(topUnfold(m),    out + 'T')
//      else if (bl.head == bl.last + sideLen) go(bottomUnfold(m), out + 'B')
//      else sys.error("no fold found " + m) 
//    }
//    go(m0, "")
//  }  
//  
//  
//  def leftUnfold(m: Matrix): Matrix = m map { r =>
//    val (a, b) = r.map(e => e.splitAt(e.size / 2)).unzip
//    a.map(_.reverse).reverse ++ b
//  }
//  
//  def rightUnfold(m: Matrix): Matrix = m map { r =>
//    val (a, b) = r.map(e => e.splitAt(e.size / 2)).unzip
//    b ++ a.map(_.reverse).reverse
//  }
//  
//  def topUnfold(m: Matrix): Matrix = leftUnfold(m.transpose).transpose
//  def bottomUnfold(m: Matrix): Matrix = rightUnfold(m.transpose).transpose
//  
//}
//
//object Matr {
//  
//  //type Matrix = IndexedSeq[IndexedSeq[IndexedSeq[Int]]]
//  
//  def apply(folds: Int) = new Matr(initial(folds))
//  
//  def apply(input: Seq[Int]) = new Matr(Vector(Vector(Vector(input: _*))))
//  
//  def initial(folds: Int): IndexedSeq[IndexedSeq[IndexedSeq[Int]]] = {
//    val sideLen = math.pow(2, folds / 2).toInt
//    (1 to sideLen * sideLen) map (Vector(_)) grouped sideLen toIndexedSeq
//  }
//  
//  implicit def toMatr(m: IndexedSeq[IndexedSeq[IndexedSeq[Int]]]): Matr = new Matr(m)
//}