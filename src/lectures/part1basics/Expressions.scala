package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(!(1 == x))
  // ! && ||

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF expression

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER write this again

  // EVERYTHING in Scala is an Expression!

  var aVariable = 2
  aVariable += 3
  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue) // ()

  // side effects: println(), whiles, reassigning

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }
}
