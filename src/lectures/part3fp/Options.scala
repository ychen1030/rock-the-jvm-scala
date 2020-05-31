package lectures.part3fp

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // unsafe APIs
  def unsafeMethod(): String = null
  // val result = Some(unsafeMethod()) // WRONG
  val result = Option(unsafeMethod())
  println(result)

  // chained methods
  def backupMethods(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethods()))

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // functions on Options
  println(myFirstOption.isEmpty) // false
  println(myFirstOption.get) // UNSAFE - DO NOT use this

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2)) // SOME(8)
  println(myFirstOption.filter(_ > 10)) // None
  println(myFirstOption.flatMap(x => Option( x * 10))) // Some(40)


  /*
    Exercise
   */
  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "176.45.62.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connceted" // connect to some server
  }
  object Connection {
    val random = new Random(System.nanoTime())
    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // try to establish a connection, if so - print the connect method
  val host = config.get("host")
  val port = config.get("port")
  val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))
  val connectionStatus = connection.map(c => c.connect)
  println(connectionStatus)
  connectionStatus.foreach(println)

  // chained calls
  config.get("host")
    .flatMap(h => config.get("port")
      .flatMap(p => Connection(h, p)))
    .map(connection => connection.connect)
    .foreach(println)

  // for comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  forConnectionStatus.foreach(println)
}
