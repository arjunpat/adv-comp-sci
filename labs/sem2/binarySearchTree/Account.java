public class Account implements Comparable<Account> {
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
}