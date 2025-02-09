package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous functions (LAMBDA)
  val doubler: Int => Int = x => x * 2
  val doubler2 = (x: Int) => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething)
  println(justDoSomething())

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  // rewrite the "special" adder as an anonymous function
  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3))
  println(superAdd(3)(4)) // 7

}
