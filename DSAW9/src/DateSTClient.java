public class DateSTClient {
    public static void main(String[] args) {
        // Create an instance of ST with Date as key and String as value
        ST<Date, String> dateEvents = new ST<>();

        // Insert some Date-Event pairs into the symbol table
        dateEvents.put(new Date(12, 25, 2021), "Christmas");
        dateEvents.put(new Date(1, 1, 2022), "New Year's Day");
        dateEvents.put(new Date(7, 4, 2022), "Independence Day");
        dateEvents.put(new Date(10, 31, 2022), "Halloween");

        // Retrieve an event based on a Date
        System.out.println("Event on 12/25/2021: " + dateEvents.get(new Date(12, 25, 2021)));
        System.out.println("Event on 1/1/2022: " + dateEvents.get(new Date(1, 1, 2022)));

        // Check if a specific Date exists in the symbol table
        System.out.println("Is there an event on 7/4/2022? " + dateEvents.contains(new Date(7, 4, 2022)));

        // Delete an event
        dateEvents.delete(new Date(10, 31, 2022));
        System.out.println("Is there an event on 10/31/2022? " + dateEvents.contains(new Date(10, 31, 2022)));

        // Print all the dates and their associated events
        System.out.println("\nAll events:");
        for (Date date : dateEvents.keys()) {
            System.out.println(date + ": " + dateEvents.get(date));
        }

        // Print the size of the symbol table
        System.out.println("\nNumber of events: " + dateEvents.size());
    }
}
