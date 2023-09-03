package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.balance = balance;
        this.name = name;
        this.minBalance = minBalance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        try {
            int accountNo = digits;
            int sumOfDigit = 0;
            while(accountNo > 0) {
                int digit = accountNo%10;
                sumOfDigit += digit;
                accountNo /= 10;
            }
            if(sumOfDigit == sum) {
                return Integer.toString(digits);
            } else {
                throw new Exception("Account Number can not be generated");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        return null;
    }

    public void deposit(double amount) {
        if(amount > 0) this.balance += amount;
        //add amount to balance
    }

    public void withdraw(double amount) throws Exception {
        try{
            if(amount < this.balance) {
                if(this.balance - amount >= this.minBalance) {
                    this.balance -= amount;
                } else {
                    throw new Exception("Insufficient Balance");
                }
            } else {
                throw new Exception("Amount exceeds available balance");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

    }

}