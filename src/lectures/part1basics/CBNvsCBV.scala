package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  calledByValue(System.nanoTime()) // 91731643065035, 91731643065035
  calledByName(System.nanoTime()) // 91731818784931, 91731818853208

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)
//  printFirst(infinite(), 34) stack overflow
  printFirst(34, infinite())
}
