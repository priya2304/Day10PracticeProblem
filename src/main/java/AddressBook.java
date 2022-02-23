public class AddressBook {

    /*UC2 - add a new Contact to Address Book*/

    public AddressBook(int index, Person person) {
        this.index = index;
        this.person = person;
    }

    private int index;
    private Person person;

    public int getIndex() {
        return index;
    }

    public int setIndex(int index) {
        return this.index = index;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "index=" + index +
                ", person=" + person +
                '}';
    }


}
