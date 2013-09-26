//Envelope
package com.example.budgetenvy;

public class Envelope {

    //private variables
    private int _id;
    private String _name = "New Envelope";
    private int _budget = 0;
    private int _balance = 0;

    //Empty constructor
    public Envelope() {

    }

    //Constructor
    public Envelope(int id, String name, int budget, int balance) {
        this._id = id;
        this._name = name;
        this._budget = budget;
        this._balance = balance;
    }

    //Constructor
    public Envelope(String name, int budget, int balance) {
        this._name = name;
        this._budget = budget;
        this._balance = balance;
    }

    //Get ID
    public int getID() {
        return this._id;
    }

    //Set ID
    public void setID(int id) {
        this._id = id;
    }

    //Get Name
    public String getName() {
        return this._name;
    }

    //Set Name
    public void setName(String name) {
        this._name = name;
    }

    //Get Budget
    public int getBudget() {
        return this._budget;
    }

    //Set Budget
    public void setBudget(int budget) {
        this._budget = budget;
    }

    //Get Balance
    public int getBalance() {
        return this._balance;
    }

    //Set Balance
    public void setBalance(int balance) {
        this._balance = balance;
    }
}
    /*
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
*/
