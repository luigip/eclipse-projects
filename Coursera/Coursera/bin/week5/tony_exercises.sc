package week5

object tony_exercises {

	import tony_exercises0._
	import Exercises._
	
	val One = Succ(Zero)                      //> One  : week5.tony_exercises0.Succ = 1
	val Two = Succ(One)                       //> Two  : week5.tony_exercises0.Succ = 2
	
	add(One, Two)                             //> res0: week5.tony_exercises0.Natural = 3
	
	val list123 = new Cons(1, new Cons(2, new Cons(3, Empty)))
                                                  //> list123  : week5.tony_exercises0.Cons[Int] = List(1, 2, 3)
  val list456 = new Cons(4, new Cons(5, new Cons(6, Empty)))
                                                  //> list456  : week5.tony_exercises0.Cons[Int] = List(4, 5, 6)
	
	sum(list123)                              //> res1: Int = 6
	
	length(list123)                           //> res2: Int = 3

  map[Int, String](list123, x => (x * 12).toString.reverse)
                                                  //> res3: week5.tony_exercises0.List[String] = List(21, 42, 63)
  
  filter[Int](list123, _ % 2 != 0)                //> res4: week5.tony_exercises0.List[Int] = List(1, 3)
  
  append(list123, list456)                        //> res5: week5.tony_exercises0.List[Int] = List(1, 2, 3, 4, 5, 6)
  
  val xxs = Cons(list123, Cons(list456, Empty))   //> xxs  : week5.tony_exercises0.Cons[week5.tony_exercises0.Cons[Int]] = List(Li
                                                  //| st(1, 2, 3), List(4, 5, 6))
  
  flatten(xxs)                                    //> res6: week5.tony_exercises0.List[Int] = List(1, 2, 3, 4, 5, 6)
  
  flatMap[Int, Int](list123, x => Cons(x, Cons(x * 10, Empty)) )
                                                  //> res7: week5.tony_exercises0.List[Int] = List(1, 10, 2, 20, 3, 30)
  maximum(list123)                                //> res8: Int = 3
  maximum(new Cons(2, Cons(5, Cons(3, Empty))))   //> res9: Int = 5
  maximum2(new Cons(2, Cons(5, Cons(3, Empty))))  //> res10: Int = 5
  
  reverse(list123)                                //> res11: week5.tony_exercises0.List[Int] = List(3, 2, 1)
}