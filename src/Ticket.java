public class Ticket {

    private int rowNumber;
    private int seatNumber;
    private int price;
    private Person person;
    public Ticket(int row, int seat, int price, Person person) {

        this.rowNumber = row;
        this.seatNumber = seat;
        this.price = price;
        this.person = person;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getPrice() {
        return price;
    }

    public void print() {
        System.out.println("Ticket " + ": Name: " + person.getName() + " , Surname: " + person.getSurname() + " , Email: " +
                person.getEmail() + " , price: " + this.price + " , Row no.: " + this.rowNumber + " , Seat no.: " + this.seatNumber);
    }
}