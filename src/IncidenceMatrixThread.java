public class IncidenceMatrixThread extends Thread{
    App app;

    public IncidenceMatrixThread(App app){
        this.app = app;
    }

    @Override
    public void run(){
        app.build_and_show_incidence_matrix();
    }
}
