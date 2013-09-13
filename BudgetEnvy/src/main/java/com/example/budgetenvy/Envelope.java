//Envelope
package com.example.budgetenvy;

public class Envelope implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String name = "New Envelope";
    private int budget = 0;
    private int balance = 0;

    public void setName(String newName) {
        name = newName;
    }

    public void setBudget(int newBudget) {
        budget = newBudget;
    }

    public void setBalance(int newBalance) {
        balance = newBalance;
    }

    public String getName() {
        return name;
    }

    public int getBudget() {
        return budget;
    }

    public int getBalance() {
        return balance;
    }

    public void update() {
        //Update button text
        //this.setText(name + " . . . " + balance + "/" + budget);
        //MainActivity.btnList.get(MainActivity.envelopeList.indexOf(this)).setText(name + " . . . " + balance + "/" + budget);
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

}
