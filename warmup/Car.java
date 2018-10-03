public class Car {
	private String make;
	private String model;
	private int year;

	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	@Override
	public boolean equals(Object o) {
		Car c = (Car)o;
		if (c.toString().equals(this.toString()))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = 31 * (make.hashCode() + model.hashCode()) + year;
		return hashCode;
	}

	public String toString() {
		return this.make + " " + this.model + " " + this.year;
	}
}