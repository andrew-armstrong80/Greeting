package app

import scala.io.StdIn


abstract class BankAccount(accountNumber : String, balance: Double) {

  def withdraw(amount : Double) : BankAccount
  def deposit(amount : Double) : BankAccount
}

class SavingsAccount(accountNumber: String, balance : Double) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Double): BankAccount = {
    if ((balance - amount) < 0) {
    println(s"You have insufficient funds")
    this
  } else {
      val deducted = balance - amount
      println(s"Balance after deductions: $deducted")
      new SavingsAccount(accountNumber, deducted)
    }
  }
  override def deposit(amount: Double):BankAccount = {
  new SavingsAccount(accountNumber, balance + amount)
  }
}

class CashISAAccount(accountNumber: String, balance : Double) extends BankAccount(accountNumber, balance)  {

  override def withdraw(amount: Double): BankAccount = {
      println(s"You are not allowed to withdraw from this kind of account!!")
      this
  }
  override def deposit(amount: Double):BankAccount = {
    new CashISAAccount(accountNumber, balance + amount)
  }
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

  val cashISAAccount = new CashISAAccount("6789", 200.00)
  val cashISAAccount200 = cashISAAccount.deposit(200.00)

  val name = Prompt.ask("What is your name? ")
  val age = Prompt.ask("How old are you? ")

  val p = new Person (name, age.toInt)

  println(p.speak())


}
