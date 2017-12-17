import java.io.IOException;

public class AddNodeThread extends Thread {
    App app;

    public AddNodeThread(App app){
        this.app = app;
    }

    @Override
    public void run(){
        try {
            app.add_node();
        }
        catch (IOException e){}
    }
}
