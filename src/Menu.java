import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static void main(String[] args) throws IOException{
        App app = App.getInstance(new Graph());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sig = 0;
        String sw;
        System.out.println("1) Add node\n2) Add connection\n3) Build and show Adjacency matrix\n4) Build and show Incidence matrix\n0) Exiting the program");
        while (sig ==0){
            System.out.print("\nEnter the command number: ");
            sw = reader.readLine();
            switch (sw){
                case "1":
                    try{
                        Thread ant = new AddNodeThread(app);
                        ant.start();
                        ant.join();
                    }
                    catch (InterruptedException e) {}
                    break;
                case "2":
                    try{
                        Thread act = new AddConnectionThread(app);
                        act.start();
                        act.join();
                    }
                    catch (InterruptedException e) {}
                    break;
                case "3":
                    try{
                        Thread amt = new AdjacencyMatrixThread(app);
                        amt.start();
                        amt.join();
                    }
                    catch (InterruptedException e) {}
                    break;
                case "4":
                    try{
                        Thread imt = new IncidenceMatrixThread(app);
                        imt.start();
                        imt.join();
                    }
                    catch (InterruptedException e) {}
                    break;
                case "0":
                    System.out.print("End of the program");
                    sig++;
                    break;
                default:
                    System.out.println("Invalid command number!");
                    break;
            }
        }
    }
}
