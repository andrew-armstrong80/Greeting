package app.Models

/**
  * Created by digital001832 on 29/01/18.
  */
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
