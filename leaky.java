import java.util.*;

public class leaky {
    static final int BUCKET = 1000, RATE = 100;

    static void send(int size) {
        if (size > BUCKET) {
            System.out.println("Bucket Overflow");
            return;
        }
        while (size > 0) {
            int sent = Math.min(size, RATE);
            System.out.println(sent + " bytes sent");
            size -= sent;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of packets: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("No Packets to Send");
            return;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter size of packet " + i + ": ");
            send(sc.nextInt());
        }
        sc.close();
    }
}


//input
/* 
Enter number of packets: 3
Enter size of packet 1: 250
Enter size of packet 2: 1200
Enter size of packet 3: 380
*/
