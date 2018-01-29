package app.Models

/**
  * Created by digital001832 on 29/01/18.
  */
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
