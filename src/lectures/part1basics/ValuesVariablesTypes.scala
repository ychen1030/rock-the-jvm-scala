package lectures.part1basics

object ValuesVariablesTypes extends App {

  // VALS are IMMUTABLE
  val x: Int = 42
  println(x)

  // COMPILER can infer types
  val y = 46
  println(y)

  // semicolon -- discouraged
  val aString: String = "hello"; val anotherString = "goodbye"

  val aBoolean : Boolean = false
  val aChar: Char = 'a'
  val aShort: Short = 4613 // 4bytes
  val aLong: Long = 234234436278435L // 8bytes
  val aFloat: Float = 2.0f

  // variables ... side effects
  var aVariable = 5
  aVariable = 6
}
