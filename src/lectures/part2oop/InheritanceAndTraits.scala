package lectures.part2oop

object InheritanceAndTraits extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"
    protected def eat = println("nomnom")
    //private: accessible by this only
    //protected: only accessible inside subclass
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }
  val dog = new Dog("domestic")
  dog.eat

  // type substitution (board: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
//  unknownAnimal.eat // crunch, crunch


  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1: use final on the method/val
  // 2: use final on the entire class itself
  // 3: sealed the class = extend classes in THIS FILE, but prevent extension in other files
}
