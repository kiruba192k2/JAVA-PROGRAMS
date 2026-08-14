
class Ticketbookingthread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("==============================================");
            System.out.println("      Railway Reservation System");
            System.out.println("==============================================");
            System.out.println();
            System.out.println("Ticket Booking Started...");
            Thread.sleep(1000);
            System.out.println("Passenger Name : Rama");
            System.out.println("Train No       : 12623");
            System.out.println("Source         : Chennai");
            System.out.println("Destination    : Bangalore");
            System.out.println();
            System.out.println("Ticket Booking Completed.");
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class SeatalocationThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("------------------------------------------");
            System.out.println("Seat Allocation Started...");
            Thread.sleep(1000);
            System.out.println("Coach : S2");
            System.out.println("Seat No : 25");
            System.out.println("Seat Allocated Successfully.");
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Paymentthread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("------------------------------------------");
            System.out.println("Payment Processing Started...");
            Thread.sleep(2000);
            System.out.println("Ticket Fare : 75");
            System.out.println("Payment Successful.");
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Ticketgenerationthread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("------------------------------------------");
            System.out.println("Ticket Generation Started...");
            Thread.sleep(1000);
            System.out.println("Generating E-Ticket...");
            Thread.sleep(1000);
            System.out.println("Ticket Generated Successfully.");
            System.out.println("------------------------------------------");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Railwayticketbooking {

    public static void main(String[] args) {
        Ticketbookingthread booking = new Ticketbookingthread();
        Paymentthread payment = new Paymentthread();
        SeatalocationThread seat = new SeatalocationThread();
        Ticketgenerationthread ticket = new Ticketgenerationthread();
        try {
            booking.start();
            booking.join();
            payment.start();
            payment.join();
            System.out.println("Payment Thread Alive : " + payment.isAlive());
            System.out.println();
            seat.start();
            seat.join();
            ticket.start();
            ticket.join();
            System.out.println("******** Ticket Booked Successfully ********");
            System.out.println("==============================================");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
