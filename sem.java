public class Main {
    static int[] counts = new int[4];
    static int total = 0;
    static class mysemaphore {
        private int tokens;
        public mysemaphore(int tokens) {
            this.tokens = tokens;
        }
        public synchronized void taketoken() {
            while (tokens == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            tokens--;
        }
        public synchronized void backtokens() {
            tokens++;
            notifyAll();
        }
    }
static class teacher {
        int id;
        teacher(int id) {
            this.id = id;
        }
        public void houses() {
            int start = (id - 1) * 20 + 1;
            int end = id * 20;
            for (int i = start; i <= end; i++) {
                int category;
                if (i % 4 == 0) {
                    category = 0;
                } else if (i % 4 == 1) {
                    category = 1;
                } else if (i % 4 == 2) {
                    category = 2;
                } else {
                    category = 3;
                }
                counts[category]++;
                total++;
            }
        }
    }
public static void main(String[] args) {
    teacher t1 = new teacher(1);
    teacher t2 = new teacher(2);
    teacher t3 = new teacher(3);

    t1.houses();
    t2.houses();
    t3.houses();

    System.out.println("Falcons: " + counts[0]);
    System.out.println("Eagles: " + counts[1]);
    System.out.println("Lions: " + counts[2]);
    System.out.println("Tigers: " + counts[3]);
    System.out.println("Total: " + total);
}
}