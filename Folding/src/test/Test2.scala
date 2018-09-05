//package test
//import org.scalatest.FunSuite
//import org.scalatest.matchers.ShouldMatchers
//import folding.Matr
//import org.junit.runner.RunWith
//import org.scalatest.junit.JUnitRunner
//
//@RunWith(classOf[JUnitRunner])
//class Test extends FunSuite with ShouldMatchers {
//
//  test("LT")   { Matr(2).folds("LT")   should equal ( Seq(2,1,3,4) ) }
//  test("RB")   { Matr(2).folds("RB")   should equal ( Seq(3,4,2,1) ) }
//  test("RBLT") { Matr(4).folds("RBLT") should equal ( Seq(2,3,15,14,13,16,4,1,5,8,12,9,10,11,7,6) ) }
//  test("LLTT") { Matr(4).folds("LLTT") should equal ( Seq(12,9,10,11,7,6,5,8,4,1,2,3,15,14,13,16) ) }
//  
//  test("Seq 1") { Matr(Seq(2,1,3,4)).unfold should equal ("LT") }
//  test("Seq 2") { Matr(Seq(3,4,2,1)).unfold should equal ("RB") }
//  test("Seq 3") { Matr(Seq(2,3,15,14,13,16,4,1,5,8,12,9,10,11,7,6)).unfold should equal ("RBLT") }
//  test("Seq 4") { Matr(Seq(12,9,10,11,7,6,5,8,4,1,2,3,15,14,13,16)).unfold should equal ("LLTT") }
//  
//}