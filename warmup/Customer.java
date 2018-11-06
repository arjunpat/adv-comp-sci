
public class Customer {

	private String name, phoneNumber;

	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String toString() {
		return "Name: " + name + " Phone number: " + phoneNumber;
	}


}