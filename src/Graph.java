import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    //Adjacency matrix
    private List<List<Integer>> amArrayList = new ArrayList<>();
    //Incidence matrix
    private List<List<Integer>> imArrayList = new ArrayList<>();
    private List<Node> nodeArrayList= new ArrayList<>();
    private List<Connection> connectionsArrayList = new ArrayList<>();
    private int n = 0;

    public List<List<Integer>> getAmArrayList() {
        return amArrayList;
    }

    public void setAmArrayList(List<List<Integer>> amArrayList) {
        this.amArrayList = amArrayList;
    }

    public List<List<Integer>> getImArrayList() {
        return imArrayList;
    }

    public void setImArrayList(List<List<Integer>> imArrayList) {
        this.imArrayList = imArrayList;
    }

    public List<Node> getNodeArrayList() {
        return nodeArrayList;
    }

    public void setNodeArrayList(List<Node> nodeArrayList) {
        this.nodeArrayList = nodeArrayList;
    }

    public List<Connection> getConnectionsArrayList() {
        return connectionsArrayList;
    }

    public void setConnectionsArrayList(List<Connection> connectionsArrayList) {
        this.connectionsArrayList = connectionsArrayList;
    }

    public void addNode() throws IOException {
        nodeArrayList.add(new Node());
        amArrayList.add(new ArrayList<Integer>());
        imArrayList.add(new ArrayList<Integer>());
        for (int i = amArrayList.size()-1; i >= 0; i--){
            if (i == amArrayList.size()-1){
                for (int j = i; j >= 0; j--) {
                    amArrayList.get(i).add(0);
                }
            }
            else {
                amArrayList.get(i).add(0);
            }
        }
    }

    public void addNode(String name, String description){
        nodeArrayList.add(new Node(name,description));
        amArrayList.add(new ArrayList<Integer>());
        imArrayList.add(new ArrayList<Integer>());
        for (int i = amArrayList.size()-1; i >= 0; i--){
            if (i == amArrayList.size()-1){
                for (int j = i; j >= 0; j--) {
                    amArrayList.get(i).add(0);
                }
            }
            else{
                amArrayList.get(i).add(0);
            }
        }
    }

    public void addConnection(Node source, Node receiver, String attitude){
        if (attitude.equals("DS")) {
            connectionsArrayList.add(new Connection(source, receiver, "OS"));
            connectionsArrayList.add(new Connection(receiver, source, "OS"));
            n += 2;
        }
        else {
            connectionsArrayList.add(new Connection(source, receiver, "OS"));
            n++;
        }
    }

    public void printNodeArrayList(){
        for (int i = 0; i < nodeArrayList.size(); i++){
            System.out.print(i + ") " + nodeArrayList.get(i).getName());
            if (i != nodeArrayList.size()-1){
                System.out.print("; ");
            }
        }
    }

    public void buildAM(){
        for (int i = 0; i < connectionsArrayList.size(); i++){
            int r = nodeArrayList.indexOf(connectionsArrayList.get(i).getSource());
            int c = nodeArrayList.indexOf(connectionsArrayList.get(i).getReceiver());
            if (connectionsArrayList.get(i).getAttitude() == "OS"){
                amArrayList.get(r).set(c,1);
            }
            else {
                amArrayList.get(r).set(c,1);
                amArrayList.get(c).set(r,1);
            }
        }
    }

    public void showAM(){
        System.out.println();
        for (int i = 0; i < amArrayList.size(); i++) {
            System.out.println(amArrayList.get(i));
        }
    }

    public void buildIM() {
        for (int i = 0; i < nodeArrayList.size(); i++){
            for (int j = 0; j < n; j++){
                imArrayList.get(i).add(0);
            }
        }
        for (int i = 0; i < connectionsArrayList.size(); i++){
            int s = nodeArrayList.indexOf(connectionsArrayList.get(i).getSource());
            int r = nodeArrayList.indexOf(connectionsArrayList.get(i).getReceiver());
            if (s != r) {
                imArrayList.get(s).set(i, 1);
                imArrayList.get(r).set(i, -1);
            }
        }
    }

    public void showIM(){
        System.out.println();
        for (int i = 0; i < imArrayList.size(); i++) {
            System.out.println(imArrayList.get(i));
        }
    }

    public void info(){
        System.out.println("Nodes: " + nodeArrayList.size() + "   Connections: " + connectionsArrayList.size());
    }
}
