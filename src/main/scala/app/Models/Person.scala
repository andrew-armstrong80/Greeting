package app.Models

/**
  * Created by digital001832 on 29/01/18.
  */
class Person(name : String, age: Int, val accounts: Seq[BankAccount] = Nil) {

  private val excludedNames: List[String] = List ("Andy", "Craig", "Allan", "Mark")

  def this(name : String, age : Int) = this  (
    name = name,
    age = age,
    accounts = List(SavingsAccount ("123", 0.00))
  )


  def this(name : String) = this (
    name = name,
    age = 0,
    accounts = List(SavingsAccount ("123", 0.00))
  )

  def this (firstName : String,
            lastName : String) = this(
    name = s"$firstName $lastName",
    age = 37,
    accounts = List(SavingsAccount ("153434", 0.00))
  )


  private val years : String = if(age == 1) "year" else "years"

  def speak() : String = {
    if (excludedNames.contains(name)) {
      "You don't get a hello!!!\n"
    } else {
      s"Hello $name, you are $age $years old.\nYour banking details are: \n$accounts"
    }
  }

}
