package lectures.part2oop

object OOBasics extends App {

  val person = new Person("yingying", 26)
  println(person.age)
  person.greet("daniel")
  person.greet()

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

//class Person(name: String, age: Int) // constructor
// class parameters are NOT FIELDS
// to confer class param to fields, add val
class Person(name: String, val age: Int = 0) {
  val x = 2 // field

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  def greet(): Unit = println(s"Hi, I am $name") //overloading

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val count: Int = 0) {
  def inc = new Counter(count + 1) // immutability
  def dec = new Counter(count - 1)

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}
