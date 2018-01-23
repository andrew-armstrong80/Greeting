package app

import scala.io.StdIn


abstract class BankAccount(accountNumber : String,
                           balance: Double) {

  def withdraw(amount : Double) : BankAccount
  def deposit(amount : Double) : BankAccount
}

class SavingsAccount(accountNumber: String, balance : Double) extends BankAccount(accountNumber, balance) {

  override def deposit(amount: Double) : BankAccount = new SavingsAccount (accountNumber, balance + amount)

  override def withdraw(amount: Double) : BankAccount = new SavingsAccount (accountNumber, balance - amount)
}

class CashISAAccount(accountNumber: String, balance : Double) extends BankAccount(accountNumber, balance)  {

  override def deposit(amount: Double) : BankAccount =  new CashISAAccount(accountNumber, balance + amount)

  override def withdraw(amount: Double) : BankAccount = new CashISAAccount(accountNumber, balance - amount)
}

class Person(name : String, age : Int) {

  private val years : String = if(age==1) "year" else "years"

  def speak() : String = {
    if (name == "Andy") {
      "You don't get a hello!"
    } else {
      s"Hello $name, you are $age $years old."
    }
  }
}


object Prompt {

  def ask(message : String) : String = StdIn.readLine(message)
}

object GreeterApplication extends App {

  val savingsAccount = new SavingsAccount("12345", 100.00)
  val savingsPlus100 = savingsAccount.deposit(100.00)

  val name = Prompt.ask("What is your name? ")
  val age = Prompt.ask("How old are you? ")

  val p = new Person (name, age.toInt)

  println(p.speak())








 // val name = StdIn.readLine("What is your name? ")

  //greet(name)

}
