public class Borrower {
    String name;
    String contact;
    String membershipID;

    public Borrower(String name, String contact, String membershipID) {
        this.name = name;
        this.contact = contact;
        this.membershipID = membershipID;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Contact: %s, Membership ID: %s", name, contact, membershipID);
    }
}
