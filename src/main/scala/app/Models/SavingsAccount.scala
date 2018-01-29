package app.Models

/**
  * Created by digital001832 on 29/01/18.
  */
class SavingsAccount(accountNumber: String,
                     balance : Double) extends BankAccount(accountNumber,balance) {

  override def deposit(amount: Double): BankAccount = new SavingsAccount(accountNumber, balance + amount)
  override def withdraw(amount: Double): BankAccount = new SavingsAccount(accountNumber, balance - amount)

}
