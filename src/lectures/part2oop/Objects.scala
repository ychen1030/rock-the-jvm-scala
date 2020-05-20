package lectures.part2oop

object Objects {

  // Scala does NOT have class-level functionality ("static")
  object Person { // type + its only instance
    // class("static")-level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS

  println(Person.N_EYES) // 2

  def main(args: Array[String]): Unit = {
    // Scala object = SINGLETON INSTANCE

    val mary = new Person("mary")
    val john = new Person("john")
    println(mary == john) // false

    val person1 = Person
    val person2 = Person
    println(person1 == person2) // true

    var bobbie = Person(mary, john)
  }

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit

}
