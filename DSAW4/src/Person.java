public class Person implements Comparable<Person> {
	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person other) {
		// return this.age - other.age; // Natural ordering by age

		if (this.age > other.age)
			return 1;
		if (this.age < other.age)
			return -1;
		return 0;
	}
}

//The Comparable interface contains one abstract method called compareTo, which is used to compare two objects
// you can define with the same class
