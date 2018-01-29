package app.views

import scala.io.StdIn

/**
  * Created by digital001832 on 29/01/18.
  */
object Prompt {

  def ask(message : String) : String = StdIn.readLine(message)
}
