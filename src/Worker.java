public class Worker {
    private Worker.OnTaskDoneListener callback;
    private Worker.OnTaskErrorListener errorCallback;

    public Worker(Worker.OnTaskDoneListener callback, Worker.OnTaskErrorListener errorCallback) {
        this.callback = callback;

        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i != 33) {
                callback.onDone("Task " + i + " is done");
            } else {
                errorCallback.onError("Task " + i + " is not done");
            }
        }
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
}