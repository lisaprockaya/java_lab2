import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Node {
    private String name;
    private String description;

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Node() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.name = reader.readLine();
        this.description = reader.readLine();
    }

    public Node(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void print(){
        System.out.println(this.name + " " + this.description);
    }
}
