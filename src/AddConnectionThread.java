import java.io.IOException;

public class AddConnectionThread extends Thread{
    App app;

    public AddConnectionThread(App app){
        this.app = app;
    }

    @Override
    public void run(){
        try {
            app.add_connection();
        }
        catch (IOException e){}
    }
}
