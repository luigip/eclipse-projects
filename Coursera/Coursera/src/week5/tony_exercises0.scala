package week5

object tony_exercises0 {
  sealed trait List[+A] {
    override def toString = {
      def toScalaList(t: List[A]): scala.List[A] = t match {
        case Empty => Nil
        case Cons(h, t) => h :: toScalaList(t)
      }
      toScalaList(this).toString
    }
  }
  
  final case object Empty extends List[Nothing]
  final case class Cons[A](h: A, t: List[A]) extends List[A]
 
  object List {
    
	def foldRight[A, B](as: List[A], b: B, f: (A, B) => B): B = as match {
	  case Empty => b
	  case Cons(h, t) => f(h, foldRight(t, b, f))
	}
	 
	def foldLeft[A, B](as: List[A], b: B, f: (B, A) => B): B = as match {
	  case Empty => b
	  case Cons(h, t) => foldLeft(t, f(b, h), f)
	}
	 
	def reduceRight[A](as: List[A], f: (A, A) => A): A = as match {
	  case Empty => error("bzzt. reduceRight on empty list")
	  case Cons(h, t) => foldRight(t, h, f)
	}
	 
	def reduceLeft[A](as: List[A], f: (A, A) => A): A = as match {
	  case Empty => error("bzzt. reduceLeft on empty list")
	  case Cons(h, t) => foldLeft(t, h, f)
	}
	 
	def unfold[A, B](b: B, f: B => Option[(A, B)]): List[A] = f(b) match {
	  case Some((a, b)) => Cons(a, unfold(b, f))
	  case scala.None => Empty
    }
  }
  
  sealed trait Natural {
	override def toString = {
	  def toInt(n: Natural): Int = n match {
	    case Zero => 0
	    case Succ(x) => 1 + toInt(x)
	  }
	  toInt(this).toString
	}
  }
	
  final case object Zero extends Natural
  final case class Succ(c: Natural) extends Natural
		 
  object Exercises {
	import List._	 
	// Exercise 1
	// Relative Difficulty: 1
	// Correctness: 2.0 marks
	// Performance: 0.5 mark
	// Elegance: 0.5 marks
	// Total: 3
	def add(x: Natural, y: Natural): Natural = y match {
	  case Zero    => x
	  case Succ(z) => add(Succ(x), z)
	}
	 
	// Exercise 2
	// Relative Difficulty: 2
	// Correctness: 2.5 marks
	// Performance: 1 mark
	// Elegance: 0.5 marks
	// Total: 4
	def sum(is: List[Int]): Int = foldLeft[Int, Int](is, 0, _ + _)
	 
	// Exercise 3
	// Relative Difficulty: 2
	// Correctness: 2.5 marks
	// Performance: 1 mark
	// Elegance: 0.5 marks
	// Total: 4
	def length[A](as: List[A]): Int = as match {
	  case Empty       => 0
	  case Cons(x, xs) => 1 + length(xs)
	}
	 
	// Exercise 4
	// Relative Difficulty: 5
	// Correctness: 4.5 marks
	// Performance: 1.0 mark
	// Elegance: 1.5 marks
	// Total: 7
	def map[A, B](as: List[A], f: A => B): List[B] = as match {
	  case Empty => Empty
	  case Cons(x, xs) => Cons(f(x), map(xs, f))
	}
	 
	// Exercise 5
	// Relative Difficulty: 5
	// Correctness: 4.5 marks
	// Performance: 1.5 marks
	// Elegance: 1 mark
	// Total: 7
	def filter[A](as: List[A], f: A => Boolean): List[A] = as match {
	  case Empty       => Empty
	  case Cons(x, xs) => if (f(x)) Cons(x, filter(xs, f))
	                      else filter(xs, f)
	}
	 
	// Exercise 6
	// Relative Difficulty: 5
	// Correctness: 4.5 marks
	// Performance: 1.5 marks
	// Elegance: 1 mark
	// Total: 7
	def append[A](x: List[A], y: List[A]): List[A] = x match {
	  case Empty       => y
	  case Cons(z, zs) => Cons(z, append(zs, y))
	}
	 
	// Exercise 7
	// Relative Difficulty: 5
	// Correctness: 4.5 marks
	// Performance: 1.5 marks
	// Elegance: 1 mark
	// Total: 7
	def flatten[A](as: List[List[A]]): List[A] = as match {
	  case Empty       => Empty
	  case Cons(x, xs) => x match {
	    case Empty       => flatten(xs)
	    case Cons(y, ys) => Cons(y, flatten(Cons(ys, xs)))
	  }
	}
	 
	// Exercise 8
	// Relative Difficulty: 7
	// Correctness: 5.0 marks
	// Performance: 1.5 marks
	// Elegance: 1.5 mark
	// Total: 8
	
	// easy way
	// def flatMap[A, B](as: List[A], f: A => List[B]): List[B] = flatten(map(as, f))

	// performant way
	def flatMap[A, B](as: List[A], f: A => List[B]): List[B] = as match {
	  case Empty       => Empty
	  case Cons(x, xs) => append(f(x), flatMap(xs, f))
	}  
	  
	// Exercise 9
	// Relative Difficulty: 8
	// Correctness: 3.5 marks
	// Performance: 3.0 marks
	// Elegance: 2.5 marks
	// Total: 9
	
	// simple, poor performance
//	def maximum(is: List[Int]): Int = is match {
//	  case Empty => error("maximum on empty list")
//	  case Cons(x, Empty) => x
//	  case Cons(x, xs) => if (x > maximum(xs)) x else maximum(xs)
//	}

	// good performance
	def maximum(is: List[Int]): Int = {
	  def iter(js: List[Int], m: Int): Int = js match {
	    case Empty => m
	    case Cons(x, xs) => if (x > m) iter(xs, x) 
	                        else       iter(xs, m)
	  }
	  is match {
	    case Empty => error("maximum on empty list")
	    case Cons(x, xs) => iter(xs, x)
	  }
	}
	
	def maximum2(is: List[Int]): Int = 
	  reduceLeft[Int](is, (x,y) => if (x > y) x else y)
	
	 
	// Exercise 10
	// Relative Difficulty: 10
	// Correctness: 5.0 marks
	// Performance: 2.5 marks
	// Elegance: 2.5 marks
	// Total: 10
	def reverse[A](as: List[A]): List[A] = 
	  foldLeft[A, List[A]](as, Empty, (acc,x) => Cons(x, acc))
  }
}