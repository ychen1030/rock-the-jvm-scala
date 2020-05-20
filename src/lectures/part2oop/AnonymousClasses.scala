package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahahahha")
  }

  println(funnyAnimal.getClass) // class lectures.part2oop.AnonymousClasses$$anon$1

  class Person(name: String) {
    def sayHi: Unit = println(s"hi, my name is $name")
  }
  val jim = new Person("Jim") {
    override def sayHi: Unit = println("How can I help?")
  }
  // works abstract class and non-abstract class
}
