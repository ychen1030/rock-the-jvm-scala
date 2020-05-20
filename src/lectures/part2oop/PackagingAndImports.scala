package lectures.part2oop

import playground.{Cinderella => Cin}

import java.util.Date
import java.sql.{Date => sqlDate}

object PackagingAndImports extends App {

  val writer = new Writer("yingying", "chen", 2020)

  val princess = new Cin

  // packages are in hierarchy
  // matching folder structure.

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  val date = new Date
  val sqlDate = new sqlDate(2020, 5, 20)

  // default imports
  // java.lang - String, Object, Exception
  // scala - int, Nothing, Function
  // scala.Predef - println
}
