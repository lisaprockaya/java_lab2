import java.io.IOException;

public class AdjacencyMatrixThread extends Thread{
    App app;

    public AdjacencyMatrixThread(App app){
        this.app = app;
    }

    @Override
    public void run(){
            app.build_and_show_adjacency_matrix();
    }
}

