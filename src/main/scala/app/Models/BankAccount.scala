package app.Models

/**
  * Created by digital001832 on 29/01/18.
  */
abstract class BankAccount(accountNumber : String,
                           val balance: Double) {

  def withdraw(amount: Double) : BankAccount

  def deposit(amount: Double) : BankAccount

  override def toString: String = s"Account number: $accountNumber \nBalance: $balance \n "

}
