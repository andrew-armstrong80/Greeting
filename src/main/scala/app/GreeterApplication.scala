package app

import scala.io.StdIn

class Person(name : String) {

  def speak() : String = {
    if (name == "Andy") {
      "You don't get a hello!"
    } else {
      "Hello " + name
    }
  }
}

object Prompt {

  def ask(message : String) : String = StdIn.readLine(message)
}

object GreeterApplication extends App {

  val n = Prompt.ask("What is your name? ")

  val p = new Person (n)

  println(p.speak())






  def greet(name : String) : Unit = {
    if (name == "Andy"){
      println(s"You don't get a hello!")
    } else {
      println(s"Hello $name")
    }
  }

 // val name = StdIn.readLine("What is your name? ")

  //greet(name)

}
