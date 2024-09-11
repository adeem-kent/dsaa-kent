public final class Date implements Comparable<Date> {
    private final int month;
    private final int day;
    private final int year;

    // Constructor
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // equals method that compares objects properly
    @Override
    public boolean equals(Object y) {
        if (y == this) return true;              // Check for reference equality
        if (y == null) return false;             // Check for null
        if (!(y instanceof Date)) return false;  // Use instanceof to allow comparison with subclasses

        Date that = (Date) y;
        return this.day == that.day &&
               this.month == that.month &&
               this.year == that.year;           // Compare fields
    }

    // Implementing the compareTo method for Comparable interface
    @Override
    public int compareTo(Date that) {
        if (this.year != that.year) {
            return this.year - that.year;
        } else if (this.month != that.month) {
            return this.month - that.month;
        } else {
            return this.day - that.day;
        }
    }

    // Override hashCode to be consistent with equals
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + day;
        hash = 31 * hash + month;
        hash = 31 * hash + year;
        return hash;
    }

    // toString method for pretty printing
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
