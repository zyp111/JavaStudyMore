package thread;

    public class Test {
        public static void main(String[] args) {
            Thread t = new Thread() {
              public void run() {
                  for(int i = 0; i < 50000; i++)
                  pong();
              }
            };
            t.start();
//            t.run();
            for(int i = 0; i < 50000;i++) {
                System.out.println("ping");
            }
        }
        static void pong() {
            System.out.println("pong");
        }
    }
