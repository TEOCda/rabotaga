public class Main {
    public static void main(String[] args) {

        Worker.OnTaskDoneListener listener = System.out::println;
        Worker.OnTaskErrorListener errorCallback = System.out::println;

        Worker worker = new Worker(listener, errorCallback);
        worker.start();
    }

    public static class Worker {
        private OnTaskDoneListener callback;
        private OnTaskErrorListener errorCallback;

        public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
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
}