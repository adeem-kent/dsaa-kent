public class Person implements Comparable<Person> {
	private String name;
	private int age;

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

	@Override
	public String toString() {
		return name + " (" + age + ")";
	}
}
