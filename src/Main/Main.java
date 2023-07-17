package Main;

public class Main {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                new Frame().setVisible(true);
            }
        }.start();
    }

}
