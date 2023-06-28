public class Main {
    public static void main(String[] args) {

        Worker.OnTaskDoneListener listener = System.out::println;
        Worker.OnTaskErrorListener errorCallback = System.out::println;

        Worker worker = new Worker(listener, errorCallback);
        worker.start();
    }
}