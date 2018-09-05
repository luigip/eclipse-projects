package folding

object Folding3 {
  
  type Matrix = IndexedSeq[IndexedSeq[IndexedSeq[Int]]]
  
  def initial(folds: Int): Matrix = {
    val sideLen = math.pow(2, folds / 2).toInt
    (1 to sideLen * sideLen) map (Vector(_)) grouped sideLen toIndexedSeq
  }
  
  def leftFold (m: Matrix): Matrix = m map { r => 
    val (a, b) = r splitAt (r.size / 2) 
    (a.reverse, b).zipped map (_.reverse ++ _)
  }
  
  def rightFold(m: Matrix): Matrix = m map { r => 
    val (a, b) = r splitAt (r.size / 2) 
    (b.reverse, a).zipped map (_.reverse ++ _)
  }
 
  def topFold   (m: Matrix): Matrix = leftFold(m.transpose).transpose
  def bottomFold(m: Matrix): Matrix = rightFold(m.transpose).transpose
  
  def fold(input: String): Seq[Int] = {
    def go(in: String, m: Matrix): Seq[Int] = in match {
      case "" => m(0)(0)
      case s  => go(s.tail, s.head match {
        case 'L' => leftFold(m)
        case 'R' => rightFold(m)
        case 'T' => topFold(m)
        case 'B' => bottomFold(m)
      })
    }
    go(input, initial(input.length))
  }
  
  def unfold(input: Seq[Int]): String = { 
    val m0: Matrix = Vector(Vector(Vector(input: _*)))
    val sideLen = math.sqrt(input.length).toInt   
    def go(m: Matrix, out: String): String = {
      val tl = m.head.head
      if (m.length == sideLen && m.head.length == sideLen) out.reverse
      else if (tl.head == tl.last - 1)       go(leftUnfold(m),   out + 'L')
      else if (tl.head == tl.last + 1)       go(rightUnfold(m),  out + 'R')
      else if (tl.head == tl.last - sideLen) go(topUnfold(m),    out + 'T')
      else if (tl.head == tl.last + sideLen) go(bottomUnfold(m), out + 'B')
      else sys.error("no fold found " + m) 
    }
    go(m0, "")
  }  
  
  
  def leftUnfold(m: Matrix): Matrix = m map { r =>
    val (a, b) = r.map(e => e.splitAt(e.size / 2)).unzip
    a.map(_.reverse).reverse ++ b
  }
  
  def rightUnfold(m: Matrix): Matrix = m map { r =>
    val (a, b) = r.map(e => e.splitAt(e.size / 2)).unzip
    b ++ a.map(_.reverse).reverse
  }
  
  def topUnfold(m: Matrix): Matrix = leftUnfold(m.transpose).transpose
  def bottomUnfold(m: Matrix): Matrix = rightUnfold(m.transpose).transpose
  
}









