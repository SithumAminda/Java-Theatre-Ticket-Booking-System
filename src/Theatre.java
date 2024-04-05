import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Theatre {
    static int[] row1 = new int[12];
    static int[] row2 = new int[16];
    static int[] row3 = new int[20];
    static int [][] rows={row1,row2,row3};
    static ArrayList<Ticket> ticket_data= new ArrayList<Ticket>();
    static ArrayList<Ticket> ticket_sort= new ArrayList<Ticket>();

    public static void main(String[] args) {
        System.out.println("welcome to the New theater " );

        while (true) {
            try {
                System.out.println("-------------------------------------------------\n" +
                        "Please select an option: \n" +
                        "1) Buy a ticket \n" +
                        "2) Print seating area \n" +
                        "3) Cancel ticket \n" +
                        "4) List available seats \n" +
                        "5) Save to file \n" +
                        "6) Load from file \n" +
                        "7) Print ticket information and total price \n" +
                        "8) Sort tickets by price \n" +
                        "0) Quit \n" +
                        "-------------------------------------------------\n " +
                        "Enter option: " );

                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                if (input<0 || input>8) {
                    System.out.println("Invalid input");
                    continue;
                }
                switch (input) {
                    case 1:
                        buy_ticket();
                        break;
                    case 2:
                        print_seating_area();
                        break;
                    case 3:
                        cancel_ticket();
                        break;
                    case 4:
                        show_available();
                        break;
                    case 5:
                        save();
                        break;
                    case 6:
                        load();
                        break;
                    case 7:
                        show_ticket_info();
                        break;
                    case 8:
                        sort_tickets();
                        break;
                    case 0:
                        System.out.println("Bye!");
                        exit(0);
                }
            }
            catch(Exception e){
                System.out.println("invalid Input");
            }
        }
    }
    static void buy_ticket() {
        Scanner scanner = new Scanner(System.in);
        int rowNumber;
        int seatNumber;
        int price;

        while (true) {
            System.out.print("Enter your row number : " );

            try {
                rowNumber = scanner.nextInt();
                if (rowNumber < 1 || rowNumber > 3) {
                    System.out.println("Invalid row no." );
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                scanner.nextLine();
                }
            }

        int[] row;
        if (rowNumber == 1)
            row = row1;
        else if (rowNumber == 2)
            row = row2;
        else
            row = row3;

        while (true) {
            System.out.print("Enter your seat number :" );
            try {
                seatNumber = scanner.nextInt();
                if (rowNumber == 1 && seatNumber > 12 || rowNumber == 2 && seatNumber > 16 || rowNumber == 3 && seatNumber > 20 || seatNumber < 1) {
                    System.out.println("Invalid seat number" );
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Invalid Input");
                scanner.nextLine();
            }
        }

            scanner.nextLine();

            if (row[seatNumber - 1] == 0) {

                System.out.print("Enter your Name :");
                String name= scanner.nextLine();

                System.out.print("Enter your Surname :");
                String surname = scanner.nextLine();

                System.out.print("Enter email:");
                String email=scanner.nextLine();

                while (true) {
                    System.out.print("Enter Ticket Price: ");
                    try {
                        price=scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        scanner.nextLine();
                    }
                }

                row[seatNumber - 1] = 1;
                Person person = new Person(name, surname, email);
                Ticket ticket = new Ticket(rowNumber, seatNumber, price, person);
                ticket_data.add(ticket);
                ticket_sort.add(ticket);

                System.out.println("You have successfully booked" );
            }
            else {
                System.out.println("This is already booked" );
            }
    }
    static void print_seating_area() {

        System.out.println("" );
        System.out.println("   ***********" );
        System.out.println("   *  STAGE  *" );
        System.out.println("   ***********" );

        System.out.println(" " );
        System.out.print("    " );

        for (int i = 0; i < 12; i++) {
            if (i == 6)
                System.out.print(" " );
            if (row1[i] == 0)
                System.out.print("O" );
            else
                System.out.print("X" );
        }
        System.out.println(" " );
        System.out.print("  " );
        for (int j = 0; j < 16; j++) {
            if (j == 8)
                System.out.print(" " );
            if (row2[j] == 0)
                System.out.print("O" );
            else
                System.out.print("X" );
        }
        System.out.println(" " );
        for (int k = 0; k < 20; k++) {
            if (k == 10)
                System.out.print(" " );
            if (row3[k] == 0)
                System.out.print("O" );
            else
                System.out.print("X" );
        }
        System.out.println("" );
    }
    static void cancel_ticket() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter row no. :");
                int rowNumber = scanner.nextInt();

                if (rowNumber > 3 || rowNumber < 1) {
                    System.out.println("invalid row number");
                    continue;
                }

                System.out.print("Enter seat no. :");
                int seatNumber = scanner.nextInt();

                if (rowNumber == 1 && seatNumber > 12 || rowNumber == 2 && seatNumber > 16 || rowNumber == 3 && seatNumber > 20 || seatNumber < 1) {
                    System.out.println("Invalid seat number");
                    continue;
                }


                if (rowNumber == 1) {
                    if (row1[seatNumber - 1] == 1) {
                        row1[seatNumber - 1] = 0;
                        System.out.println("Seat is now Available");

                    } else {
                        System.out.println("Not occupied");
                    }

                }
                if (rowNumber == 2) {
                    if (row2[seatNumber - 1] == 1) {
                        row2[seatNumber - 1] = 0;
                        System.out.println("Seat is now Available");

                    } else {
                        System.out.println("Not occupied");
                    }

                }
                if (rowNumber == 3) {
                    if (row3[seatNumber - 1] == 1) {
                        row3[seatNumber - 1] = 0;
                        System.out.println("Seat is now Available");
                    } else {
                        System.out.println("Not occupied");
                    }

                }
                for (int i = 0; i < ticket_data.size(); i++) {
                    if (ticket_data.get(i).getRowNumber() == rowNumber && ticket_data.get(i).getSeatNumber() == seatNumber)
                        ticket_data.remove(i);

                    if (ticket_sort.get(i).getRowNumber() == rowNumber && ticket_sort.get(i).getSeatNumber() == seatNumber)
                        ticket_sort.remove(i);
                }
            }
            catch (Exception e){
                System.out.println("Invalid input");
            }
            break;
        }
    }
    static void show_available(){
        System.out.print("Row 1:");
        for(int i=0; i<12; i++){
            if(row1[i] == 0){
                System.out.print(i + 1+" ");
            }
        }
        System.out.println(" ");
        System.out.print("Row 2:");
        for(int i=0; i<16; i++){
            if(row2[i] == 0){
                System.out.print(i + 1+" ");
            }
        }
        System.out.println(" ");
        System.out.print("Row 3:");
        for(int i=0; i<20; i++){
            if(row3[i] == 0){
                System.out.print(i + 1+" ");
            }
        }
        System.out.println("");
    }
    static void save(){
        try{
            FileWriter rows_data= new FileWriter("data_save.txt");
            //rows_data.write(Arrays.deepToString(rows));

            for (int[] row: rows) {
                for (int aSeat: row) {
                    rows_data.write(Integer.toString(aSeat));
                }
                rows_data.write("\n");
            }

            System.out.println("File saved Successfully");
            rows_data.close();

        } catch (IOException e) {
            System.out.println("Saving not successful");
            throw new RuntimeException(e);
        }
    }
    static void load(){
        try{
            File data_save=new File("data_save.txt");
            Scanner rows_data= new Scanner(data_save);

            ArrayList<String> lines = new ArrayList<String>();

            for (int i = 0; i < 3; i++) {
                String data_input=rows_data.nextLine();
                lines.add(data_input);
            }

            rows_data.close();

            for (int i = 0; i < 12; i++) {
                String line1 = lines.get(0);
                row1[i] = Character.getNumericValue(line1.charAt(i));
            }

            for (int i = 0; i < 16; i++) {
                String line2 = lines.get(1);
                row2[i] = Character.getNumericValue(line2.charAt(i));
            }

            for (int i = 0; i < 20; i++) {
                String line3 = lines.get(2);
                row3[i] = Character.getNumericValue(line3.charAt(i));
            }

            System.out.println("Successfully loaded.");


        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while loading");
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Something Went Wrong!");
        }

    }
    static void show_ticket_info() {
        if (ticket_data.isEmpty()) {
            System.out.println("No ticket information");
        }
        else {
            int x=0;
            int total = 0;
            for (Ticket tickets :ticket_data) {
                tickets.print();
                total += ticket_data.get(x).getPrice();
                x+=1;
            }
            System.out.println("Total : " + total);
        }
    }
    static void sort_tickets()  {
        if (ticket_sort.isEmpty()) {
            System.out.println("No ticket information!");
        }
        else {
            int bottom = ticket_sort.size() - 2;
            Ticket temp;
            boolean exchanged = true;

            while (exchanged) {
                exchanged =false;

                for (int i = 0; i <= bottom; i++) {
                    int price1 = ticket_sort.get(i).getPrice();
                    int price2 = ticket_sort.get(i + 1).getPrice();

                    if (price1 > price2) {
                        temp =ticket_sort.get(i);
                        ticket_sort.set(i, ticket_sort.get(i + 1));
                        ticket_sort.set(i + 1, temp);
                        exchanged = true;
                    }
                }
                bottom--;
            }

            for (Ticket tickets:ticket_sort)
                tickets.print();
        }
    }
}