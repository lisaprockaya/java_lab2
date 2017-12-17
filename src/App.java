import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static App instance;
    private Graph graph;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public App(){}

    public App(Graph graph){
        this.graph = graph;
    }

    public synchronized static App getInstance(Graph graph){
        if (instance == null){
            instance = new App(graph);
        }
        return instance;
    }

    public synchronized void add_node() throws IOException{
        System.out.print("Enter name: ");
        String name = reader.readLine();
        int sig1 = 0;
        int sig2 = 0;
        while(sig1 == 0){
            for (int i = 0; i < graph.getNodeArrayList().size(); i++){
                if ((name.equals(graph.getNodeArrayList().get(i).getName()) == true)){
                    sig2++;
                }
            }
            if (sig2 == 0){
                sig1 = 1;
                sig2 = 0;
            }
            else{
                System.out.print("Error (This name already exists)! Try again!\nEnter name: ");
                name = reader.readLine();
                sig2 = 0;
            }
        }
        System.out.print("Enter description: ");
        String description = reader.readLine();
        graph.addNode(name,description);
    }

    public synchronized void add_connection() throws IOException{
        System.out.print("Available nodes: ");
        graph.printNodeArrayList();
        System.out.print("\nSelect the source node number: ");
        String source = reader.readLine();
        while ((Integer.parseInt(source) < 0) || (Integer.parseInt(source) >= graph.getNodeArrayList().size())){
            System.out.print("Error (Invalid source node number)! Try again!\nSelect the source node number: ");
            source = reader.readLine();
        }
        System.out.print("Select the receiver node number: ");
        String receiver = reader.readLine();
        while ((Integer.parseInt(receiver) < 0) || (Integer.parseInt(receiver) >= graph.getNodeArrayList().size())){
            System.out.print("Error (Invalid receiver node number)! Try again!\nSelect the receiver node number: ");
            receiver = reader.readLine();
        }
        System.out.print("Select attitude (OS - One-sided; DS - Double-sided):");
        String attitude = reader.readLine();
        while ((attitude.equals("OS") == false) && (attitude.equals("DS") == false)){
            System.out.print("Error (Invalid attitude type)! Try again!\nSelect attitude (OS - One-sided; DS - Double-sided): ");
            attitude = reader.readLine();
        }
        graph.addConnection(graph.getNodeArrayList().get(Integer.parseInt(source)),graph.getNodeArrayList().get(Integer.parseInt(receiver)),attitude);
    }

    public synchronized void build_and_show_adjacency_matrix(){
        graph.buildAM();
        System.out.print("Adjacency matrix:");
        graph.showAM();
    }

    public synchronized void build_and_show_incidence_matrix(){
        graph.buildIM();
        System.out.print("Incidence matrix:");
        graph.showIM();
    }
}
