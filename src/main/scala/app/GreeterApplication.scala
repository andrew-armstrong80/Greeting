package scala.app

import app.Models.{BankAccount, CashISASavingsAccount, Person, SavingsAccount}
import app.views.Prompt

import scala.io.StdIn





object GreetingsApplication extends App {


  val savingsAccount = new SavingsAccount("12345", 100.00)
  val savingsPlus100 = savingsAccount.deposit(100.00)

  val name : String = Prompt.ask("What is your name? ")
  val age : String = Prompt.ask("How old are you? ")

  val p : Person = new Person(name, age.toInt)

  val child = new Person("David")
  val p2 = new Person("Andy", "Armstrong")

  val cashISA = new CashISASavingsAccount("123456", 0.00)
  val isaDeposited = cashISA.deposit(1000.00)
  val withdrawFromISA = isaDeposited.withdraw(200.00)
  val personWithCashISA = new Person("Loyal customer", 56, withdrawFromISA)

  val superAccount = new CashISASavingsAccount("123456", 0.00, depositThreshold = 1000.00).deposit(1000.00).withdraw(300.00)
  val superPersonWithISA = new Person("Super Loyal customer", 56, superAccount)




  println(p.speak())
  println(child.speak())
  println(p2.speak())


}