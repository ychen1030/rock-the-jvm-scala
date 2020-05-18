package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  // JAVA functions
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.length)

  // Scala specific functions
  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // Scala specific: String interpolators

  // S-interpolators
  val name = "yingying"
  val age = 25
  val greeting = s"Hello, my name is $name and I am $age years old. " +
    s"I willl be turning ${age + 1} years old."
  println(greeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute."
  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline.")
  val escaped = "This is a \n newline."
  println(raw"$escaped")

}
