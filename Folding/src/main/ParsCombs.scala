package main

sealed trait Tree
case class Leaf(words: Seq[String]) extends Tree
case class Branch(left: Tree, right: Tree) extends Tree

object Tree {
  
  def newTreeRec(data: Data): Tree = data match {
    case d if d.leafTest => Leaf(d.xs)
    case d => Branch(newTreeRec(Data(d.part1)), newTreeRec(Data(d.part2)))
  }
  
  /*
   * While-version not finished
   */
  
  def newTreeWhile(data: Data): Tree = {
    
    trait Frame
    case class StackFrame(
        data: Data, 
        parent: Frame, 
        var rtnVal: Tree, 
        var complete: Boolean
        ) extends Frame {
      def nextFrame = {}
    }
    case object TopFrame extends Frame
    
    var stack = collection.immutable.Stack.empty[StackFrame]
    
    var currentFrame = StackFrame(data, TopFrame, null, false)
    val topFrame = currentFrame
    
    while (topFrame.complete == false) {
      
      currentFrame.rtnVal = currentFrame.data match {        
        case d if d.leafTest => 
          currentFrame.complete = true
          Leaf(d.xs)
        
        case d => 
          currentFrame.complete = false
          Branch(StackFrame(Data(d.part1), currentFrame, null, false).rtnVal, 
                 StackFrame(Data(d.part2), currentFrame, null, false).rtnVal)
      }
    }
    
    
    sys.error("todo")
  }
  
  case class Data(xs: Seq[String]) {
    def areSame(x: String) = x.charAt(0) == xs.head.charAt(0)
    val leafTest = xs forall areSame
    val (part1, part2) = xs partition areSame    
  }
  
}

object TreeTest extends App {
  import Tree._
  val str = """I'm a bit embarassed to admit this, but I seem to be pretty stumped by what should be a simple programming problem. I'm building a decision tree implementation, and have been using recursion to take a list of labeled samples, recursively split the list in half, and turn it into a tree"""
  val xs: Seq[String] = str.replaceAll("[,.]", "").split(" ").map(_.toLowerCase).toList
  val tree = newTreeRec(Data(xs))
  println(tree)
}