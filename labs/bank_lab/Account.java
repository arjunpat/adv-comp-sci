public class Account {
	private String name;
	private double balance;
	private int pin;
	private boolean access;

	public Account(String name, double balance, int pin) {
		this.name = name;
		this.balance = balance;
		this.pin = pin;
	}

	public String getName() { return name; }

	public double getBalance() { return balance; }

	public boolean getAccess() { return access; }

	public void setAccess(int pin) {
		if (this.pin == pin)
			this.access = true;
	}

	public void withdraw(double amt) {
		if (access && amt <= balance)
			balance = balance - amt;
	}

	public void deposit(double amt) {
		if (access)
			balance += amt;
	}

}