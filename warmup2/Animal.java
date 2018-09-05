public abstract class Animal {

	protected String name;

	public abstract String speak();
	public abstract String getColor();
	public String getName() {
		return name;
	}

	public void printInfo() {
		System.out.println("Name: " + name + " Color:" + this.getColor() + " Saying: " + this.speak());
	}

}