import java.io.Serializable;

public class Account implements Comparable<Account>, Serializable {
	private String firstName, lastName;
	private int pin;
	private double balance;
	
	public Account(String firstName, String lastName, int pin, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pin = pin;
		this.balance = balance;
	}

	public String getCompareString() {
		return lastName + ", " + firstName;
	}

	public boolean equals(Object o) {
		Account a = (Account)o;
		return getCompareString().equals(a.getCompareString());
	}

	public int compareTo(Account a) {
		return getCompareString().compareTo(a.getCompareString());
	}

	public String toString() {
		return getCompareString();
	}

	public int getPin() {
		return pin;
	}

	public double getBalance() {
		return balance;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public void setLastName(String name) {
		this.lastName = name;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}