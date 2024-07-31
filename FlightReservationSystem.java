import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FlightReservationSystem {
   private List<Ticket> bookedTickets = new ArrayList();

   public FlightReservationSystem() {
   }

   public void bookTicket(String var1, int var2, String var3, String var4, int var5) {
      Passenger var6 = new Passenger(var1, var2);
      Flight var7 = new Flight(var3, var4, var5);
      Ticket var8 = new Ticket(var6, var7, var5);
      this.bookedTickets.add(var8);
      System.out.println("Ticket booked successfully! Ticket number: " + var8.getTicketNumber());
   }

   public void displayTicket(int var1) {
      Iterator var2 = this.bookedTickets.iterator();

      Ticket var3;
      do {
         if (!var2.hasNext()) {
            System.out.println("Ticket with ticket number " + var1 + " not found.");
            return;
         }

         var3 = (Ticket)var2.next();
      } while(var3.getTicketNumber() != var1);

      System.out.println("Ticket Number: " + var3.getTicketNumber());
      System.out.println("Passenger: " + var3.getPassenger().getName());
      System.out.println("Departure: " + var3.getFlight().getDeparture());
      System.out.println("Destination: " + var3.getFlight().getDestination());
      System.out.println("Number of seats: " + var3.getNumberOfSeats());
   }

   public void cancelTicket(int var1) {
      Iterator var2 = this.bookedTickets.iterator();

      Ticket var3;
      do {
         if (!var2.hasNext()) {
            System.out.println("Ticket with ticket number " + var1 + " not found.");
            return;
         }

         var3 = (Ticket)var2.next();
      } while(var3.getTicketNumber() != var1);

      var2.remove();
      System.out.println("Ticket number " + var1 + " cancelled successfully.");
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      FlightReservationSystem var2 = new FlightReservationSystem();

      while(true) {
         while(true) {
            System.out.println("1. Book Ticket");
            System.out.println("2. Display Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            int var3 = var1.nextInt();
            switch (var3) {
               case 1:
                  System.out.println("Enter passenger name:");
                  String var4 = var1.next();
                  System.out.println("Enter passenger age:");
                  int var5 = var1.nextInt();
                  System.out.println("Enter departure:");
                  String var6 = var1.next();
                  System.out.println("Enter destination:");
                  String var7 = var1.next();
                  System.out.println("Enter number of seats:");
                  int var8 = var1.nextInt();
                  var2.bookTicket(var4, var5, var6, var7, var8);
                  break;
               case 2:
                  System.out.println("Enter ticket number:");
                  int var9 = var1.nextInt();
                  var2.displayTicket(var9);
                  break;
               case 3:
                  System.out.println("Enter ticket number to cancel:");
                  int var10 = var1.nextInt();
                  var2.cancelTicket(var10);
                  break;
               case 4:
                  System.out.println("Exiting program...");
                  System.exit(0);
               default:
                  System.out.println("Invalid choice!");
            }
         }
      }
   }
}
