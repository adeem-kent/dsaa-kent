public class PersonClient {
    public static void main(String[] args) {
        // Create two Person objects
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);

        // Compare the two Person objects using compareTo
        int comparisonResult = person1.compareTo(person2);
        // positive if person1 is greater than person2

        // Output the result of the comparison
        if (comparisonResult > 0) {
            System.out.println(person1.name + " is older than " + person2.name);
        } else if (comparisonResult < 0) {
            System.out.println(person1.name + " is younger than " + person2.name);
        } else {
            System.out.println(person1.name + " and " + person2.name + " are the same age");
        }
    }
}
