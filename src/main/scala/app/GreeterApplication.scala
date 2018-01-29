package scala.app

import scala.io.StdIn


abstract class BankAccount(accountNumber : String,
                           val balance: Double) {

  def withdraw(amount: Double) : BankAccount

  def deposit(amount: Double) : BankAccount

  override def toString: String = s"Account number: $accountNumber \nBalance: $balance \n "

}

class SavingsAccount(accountNumber: String,
                     balance : Double) extends BankAccount(accountNumber,balance) {

  override def deposit(amount: Double): BankAccount = new SavingsAccount(accountNumber, balance + amount)
  override def withdraw(amount: Double): BankAccount = new SavingsAccount(accountNumber, balance - amount)

}


final class CashISASavingsAccount(accountNumber: String, balance: Double, private val depositThreshold: Double = 200.00)
  extends SavingsAccount(accountNumber, balance) {


  override def deposit(amount: Double): BankAccount = {
    if (amount > depositThreshold) {
      val difference = amount - depositThreshold
      println(s"You can't deposit more than £$depositThreshold, Excess: $difference")
      new CashISASavingsAccount(accountNumber, balance + depositThreshold)
    } else {
      new CashISASavingsAccount(accountNumber, balance + amount)
    }
  }
}




class Person(name : String, age: Int, private val bankAccount: BankAccount) {

  def this(name : String, age : Int) = this (
    name = name,
    age = age,
    bankAccount = new SavingsAccount ("123", 0.00))

  def this(name : String) = this (
    name = name,
    age = 0,
    bankAccount = new SavingsAccount ("123", 0.00))

  def this (firstName : String,
            lastName : String) = this(
    name = s"$firstName $lastName",
    age = 37,
    bankAccount = new SavingsAccount("153434", 0.00)
  )


  private val years : String = if(age == 1) "year" else "years"

  def speak() : String = {
    if (name == "Andy") {
      "You don't get a hello."
    } else {
      s"Hello $name, you are $age $years old.\nYour banking details: \n$bankAccount"
    }
  }

}

object Prompt {

  def ask(message : String) : String = StdIn.readLine(message)

}

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