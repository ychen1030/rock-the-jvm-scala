package lectures.part3fp

import scala.annotation.tailrec

object TuplesAndMaps extends App {

  //tuples = finite ordered "lists"
  val aTuple = (2, "hello scala") // Syntatic sugar for new Tuple(2, "...")

  println(aTuple._1, aTuple._2)
  println(aTuple.copy(_2 = "goodbye java"))
  println(aTuple.swap) // ("hello, scala", 2)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), ("Daniel", 789)).withDefaultValue(-1)
  // syntatic sugar ("Jim" -> 555, "Daniel" -> 789)
  println(phoneBook)

  // map ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim")) // 555
  println(phoneBook("Yingying")) // -1

  // add a pairing
  val newPairing = "Mary" -> 123
  val newPhoneBook = phoneBook + newPairing // a new phoneBook because map is immutable
  println(newPhoneBook)

  // functions on maps
  // map, flatMap, filter
  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filter keys
  println(phoneBook.view.filterKeys(x => x.startsWith("J")).toMap)
  //mapValues
  println(phoneBook.view.mapValues(number => number * 10).toMap)

  // conversions to other collections
  println(phoneBook.toList) // List((Jim,555), (Daniel,789))
  println(List(("Jim",555), ("Daniel",789)).toMap) // Map(Jim -> 555, Daniel -> 789)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
  // HashMap(J -> List(James, Jim), A -> List(Angela), M -> List(Mary), B -> List(Bob), D -> List(Daniel))

  /*
    1. What would happen if I had two original entries "Jim" -> 500 and "JIM" -> 900
       The first data is lost, CAREFUL with mapping keys!

    2. Overly simplified social network based on maps
       Person = String
       - add a person to the network
       - remove
       - friend (mutual)
       - unfriend

       - number of friends of a persion
       - person with most friends
       - how many people have NO friends
       - if there's a social connection between two people (direct or not)
   */
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Jim", "Bob")
  val testNet = friend(jimBob, "Bob", "Mary")
  println(testNet)

  def nFriends(network:Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size
  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(person => person._2.size)._1
  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.count(_._2.isEmpty)
  println(nPeopleWithNoFriends(testNet)) // 0

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople ++ network(person))
      }
    }
    bfs(b, Set(), network(a) + a)
  }
  println(socialConnection(testNet, "Mary", "Jim")) // true
}
