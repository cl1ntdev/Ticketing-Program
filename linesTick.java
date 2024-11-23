import java.util.*;

public class linesTick {
    public static void tradeMark() {
        System.out.println(
                "                                        ==========================================================================================");
        System.out.println(
                "                                        <>* <>*                W H I T E       S T E L L A R       T I C K E T S           *<> *<>");
        System.out.println(
                "                                        ==========================================================================================");
    }

    public static void clrScreen() {
        for (int i = 0; i < 5; i++) {
            System.out.println(" ");
        }
    }

    public static String balNotif() {
        return "                                             > > > YOUR BALANCE IS LOW < < <";
    }

    static void reset() {
        Scanner scan = new Scanner(System.in);
        System.out.print("                                        Enter any key to proceed: ");
        String next = scan.nextLine();
        if (next.length() > 0) {
            return;
        } else {
            return;
        }
    }

    public static void recieptShow(String[] destination, String[] seatT, String[] passT, int[] prices,
            int[] seatTypePrice,
            int choice1, int choice2, int choice3, int discount) { // choice 1,2,3 here is the user previous choices in
                                                                   // oder to access the databse
        Scanner scan = new Scanner(System.in);
        String discountType = passT[choice3]; // name of the discount in the passenger type which is the choice 3 //
                                              // includes the discount which is the money
        int totAmPay = 0;
        int amount = 0;
        int change = 0;
        int noTicket = 0;
        boolean amValid = false;
        do {
            clrScreen();
            clrScreen();
            tradeMark();
            System.out.print("                                        Amount of Tickets: ");
            noTicket = scan.nextInt();
            totAmPay = noTicket * (prices[choice1] + seatTypePrice[choice2]) - discount; // formula in calculating the
                                                                                         // tot amount to be payed
            // maybe discount tyime the noTicket
            tradeMark();
            clrScreen();
            System.out.println("                                        Number of Ticket: " + "......" + noTicket); // show
                                                                                                                    // neccessary
                                                                                                                    // information
                                                                                                                    // in
                                                                                                                    // the
                                                                                                                    // transaction
            System.out.println(" ");
            System.out.println("                                        Destination: " + destination[choice1] + "......" // the
                                                                                                                         // destination
                                                                                                                         // array
                                                                                                                         // and
                                                                                                                         // the
                                                                                                                         // first
                                                                                                                         // choice
                    + prices[choice1]);
            System.out.println(" ");
            System.out.println("                                        Seat Type: " + seatT[choice2] + "......" // seattype
                                                                                                                 // array
                                                                                                                 // and
                                                                                                                 // the
                                                                                                                 // second
                                                                                                                 // choice
                    + seatTypePrice[choice2]);
            System.out.println(" ");
            System.out.println(
                    "                                        Passenger Type: " + discountType + "......" + discount);
            System.out.println(
                    "                                        Total: " + noTicket + " * " + "( " + prices[choice1]
                            + " + " + seatTypePrice[choice2] + ")" + " - " + discount + " = " + totAmPay);
            clrScreen();
            tradeMark();
            System.out.print("                                        Enter amount: ");
            amount = scan.nextInt();
            if (amount >= totAmPay) {// make sure that the amount is greater than what should be payed
                change = amount - totAmPay;
                amValid = true;
            } else {
                System.out.println(balNotif());
            }
        } while (!amValid);
        tradeMark();
        clrScreen();
        System.out.println("                                        Number of Ticket: " + "......" + noTicket);
        System.out.println(" ");
        System.out.println(
                "                                        Destination: " + destination[choice1] + "......"
                        + prices[choice1]);
        System.out.println(" ");
        System.out.println("                                        Seat Type: " + seatT[choice2] + "......"
                + seatTypePrice[choice2]);
        System.out.println(" ");
        System.out.println(
                "                                        Passenger Type: " + discountType + "......" + discount);
        System.out.println(
                "                                        Total: " + noTicket + " * " + "( " + prices[choice1] + " + "
                        + seatTypePrice[choice2] + ")" + " - " + discount + " = " + totAmPay);
        System.out.println(" ");
        System.out.println("                                        Payed Amount: " + amount);
        System.out.println(" ");
        System.out.println("                                        Change: " + change);

        clrScreen();
        tradeMark();
        reset();

    }

    public static void passengerTypes(String[] des, String[] seatT, String[] passT, int[] prices, int[] seatTypePrice,
            int[] passengerTypePrice,
            int choice1, int choice2) {
        int i = 0;
        int choice = 0;
        int discount = 0; // only used for showing discount
        int discountBase = 0; // use to pass the passenger type
        Scanner scan = new Scanner(System.in);
        boolean isChoosedPass = false;

        do {

            tradeMark();
            clrScreen();
            for (String s : passT) {// traverse the passenger seats
                switch (s) {
                    case "Regular":
                        discount = 0; // update discount to be shown in iteration depending on the passenger
                        break;
                    case "Student":
                        discount = 50;
                        break;
                    case "Senior/PWD":
                        discount = 150;
                        break;
                    default:

                        break;
                }
                if (choice == i) {
                    System.out.println(
                            "                                        > " + s + " ......... " + discount + " Discount"); // discount
                                                                                                                        // used
                                                                                                                        // here
                } else {
                    System.out.println(
                            "                                        " + s + " .......... " + discount + " Discount");
                }
                i++;
            }
            clrScreen();
            clrScreen();
            tradeMark();
            System.out.print(
                    "                                        W/w -> up || D/d -> down || C/c -> confirm            Choice: ");
            String chBase = scan.nextLine();

            switch (chBase) {
                case "d": // increment choice to go down 0,1,2,3 like indexing of the array which is in
                          // the ops
                    if (choice >= passT.length - 1) {
                        choice = 0;
                    } else {
                        choice++;
                    }
                    i = 0;
                    break;
                case "w":

                    if (choice == 0) {
                        choice = 0;
                    } else {
                        choice--;
                    }
                    i = 0;
                    break;
                case "c":
                    int basePassengerPrice = passengerTypePrice[choice];
                    discountBase = basePassengerPrice;

                    recieptShow(des, seatT, passT, prices, seatTypePrice, choice1, choice2, choice, discountBase); // after
                                                                                                                   // choosing
                                                                                                                   // passengestypes
                                                                                                                   // move
                                                                                                                   // on
                                                                                                                   // to
                                                                                                                   // reciept
                                                                                                                   // showing
                                                                                                                   // calculation,
                    // choice1 and 2 here is the previous choices the choice is the choice within
                    // this function
                    isChoosedPass = true; // if the user confirms the will be true, ending the loop to proceed
                    break;

                default:
                    choice = 0;
                    break;
            }
            clrScreen();
            clrScreen();
        } while (!isChoosedPass);
    }

    public static void displaySeatTypes(String[] destination, String[] seatT, String[] passT, int[] prices,
            int[] seatTypePrice, int[] passengerTypePrice,
            int choice1) {

        int i = 0;
        int choice = 0;
        boolean isChoosedTourist = false;
        Scanner scan = new Scanner(System.in);
        do {

            tradeMark();
            clrScreen();
            for (String s : seatT) { // display seat types
                if (choice == i) {
                    System.out.println(
                            "                                        > " + s + " ......... " + seatTypePrice[i]);
                } else {
                    System.out.println(
                            "                                        " + s + " .......... " + seatTypePrice[i]);
                }
                i++;
            }
            clrScreen();
            clrScreen();
            tradeMark();
            System.out.print(
                    "                                        W/w -> up || D/d -> down || C/c -> confirm            Choice: ");
            String chBase = scan.nextLine();

            switch (chBase) {
                case "d": // increment choice to go down 0,1,2,3 like indexing of the array which is in
                          // the ops
                    if (choice >= seatT.length - 1) {
                        choice = 0;
                    } else {
                        choice++;
                    }
                    i = 0;
                    break;
                case "w":

                    if (choice == 0) {
                        choice = 0;
                    } else {
                        choice--;
                    }
                    i = 0;
                    break;
                case "c":
                    i = 0;
                    passengerTypes(destination, seatT, passT, prices, seatTypePrice, seatTypePrice, choice1, choice);// choice
                                                                                                                     // 1
                                                                                                                     // is
                                                                                                                     // the
                    // previous choice, choice
                    // is the second choice
                    // here
                    isChoosedTourist = true;
                    break;

                default:
                    i = 0;
                    choice = 0;
                    break;
            }
            clrScreen();
            clrScreen();
        } while (!isChoosedTourist);
    }

    public static void main(String[] args) {
        String[] destination = { "Dumaguete to Manila", "Dumagete to Cebu", "Dumaguete to Bayawan",
                "Dumaguete to Brazil", "Dumaguete to Spain" };
        String[] seatTypes = { "Economy", "Tourist", "Business Class" };
        String[] passType = { "Regular", "Student", "Senior/PWD" };
        int[] prices = { 100, 200, 300, 400, 500 };
        int[] seatTypePrice = { 0, 100, 200 };
        int[] passengerTypePrice = { 0, 50, 150 };

        Scanner scan = new Scanner(System.in);
        int choice = 0;
        int i = 0;
        do {
            i = 0; // reset each input for the prices to show accordingly
            tradeMark();
            clrScreen();
            for (String s : destination) {
                if (choice == i) { // display arrow according to what iteration
                    System.out.println("                                        > " + s + " ......... " + prices[i]);
                } else {
                    System.out.println("                                        " + s + " .......... " + prices[i]);
                }
                i++;
            }
            clrScreen();
            clrScreen();
            tradeMark();
            System.out.print(
                    "                                        W/w -> up || D/d -> down || C/c -> confirm            Choice: ");
            String chBase = scan.nextLine();

            switch (chBase) {
                case "d": // increment choice to go down 0,1,2,3 like indexing of the array which is in
                          // the ops
                    if (choice >= destination.length - 1) {
                        choice = 0;
                    } else {
                        choice++;
                    }
                    break;
                case "w":

                    if (choice == 0) {
                        choice = 0;
                    } else {
                        choice--;
                    }
                    break;
                case "c":
                    displaySeatTypes(destination, seatTypes, passType, prices, seatTypePrice, passengerTypePrice,
                            choice); // after the main
                    // menu next
                    // scene will be
                    // the display
                    // seats
                    choice = 0;
                    break;

                default:
                    choice = 0;
                    break;
            }
            clrScreen();
            clrScreen();
        } while (true); // program still run after each transaction
    }
}