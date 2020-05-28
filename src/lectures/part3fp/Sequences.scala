package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  // Seq
  val aSequence = Seq(1, 2, 3, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2)) // 3
  println(aSequence ++ Seq(5, 6, 7))
  println(Seq(7, 5, 9).sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (11 until 20).foreach(x => println(x))

  // Lists
  val aList = List(1, 2, 3)
  val prepended = 42 +: aList :+ 89
  println(prepended) // List(42, 1, 2, 3, 89)

  val apples5 = List.fill(5)("apple")
  println(apples5) // List(apple, apple, apple, apple, apple)
  println(aList.mkString("-|-")) // 1-|-2-|-3

  // Arrays
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3)
  println(threeElements.length)
  threeElements.foreach(println)

  // mutations
  numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" ")) // 1 2 0 4

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq) // ArraySeq(1, 2, 0, 4)

  // Vectors
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector) // Vector(1, 2, 3)

  // vectors vs lists
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector
  // keeps reference to tail
  // update an element in the middle takes long time
  println(getWriteTime(numbersList))
  // depth of the tree is small
  // needs to replace and entire 32-element chuck
  println(getWriteTime(numbersVector))

}
