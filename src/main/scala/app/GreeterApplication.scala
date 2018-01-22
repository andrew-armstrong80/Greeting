package app

import scala.io.StdIn

/**
  * Created by digital001832 on 22/01/18.
  */
object GreeterApplication extends App {

  def greet(name : String) : Unit = {
    if (name == "Andy"){
      println(s"You don't get a hello!")
    } else {
      println(s"Hello $name")
    }
  }

  val name = StdIn.readLine("What is your name? ")

  greet(name)

}
