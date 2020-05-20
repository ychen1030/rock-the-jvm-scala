package lectures.part2oop

object CaseClasses extends App {

  /*
    equals, hashCode, toString
   */
  case class Person(name: String, age: Int)

  // 1. class params are fields
  val jim = new Person("Jim", 34)
  println(jim.name, jim.age)

  // 2. sensible toString
  println(jim.toString)
  println(jim) // same as above, syntatic sugar

  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // true

  // 4. case classes have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. case classes are serializable
  // Akka

  // 7. case classes have extractor patterns = CCs can be used in Pattern Matching

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
}
