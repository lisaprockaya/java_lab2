import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Connection {
    private Node source;
    private Node receiver;
    private String attitude;

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getReceiver() {
        return receiver;
    }

    public void setReceiver(Node receiver) {
        this.receiver = receiver;
    }

    public String getAttitude() {
        return attitude;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    public Connection(Node source, Node receiver, String attitude){
        this.source = source;
        this.receiver = receiver;
        //OS = One-sided
        //DS = Double-sided
        if (attitude == "DS") {
            this.attitude = "DS";
        }
        else {
            this.attitude = "OS";
        }
    }

    public String toString(){
        return (this.source.getName() + " " + this.receiver.getName()) + " " + this.getAttitude();
    }

    public void print(){
        System.out.println(this.source.getName() + " " + this.receiver.getName() + " " + this.attitude);
    }
}
