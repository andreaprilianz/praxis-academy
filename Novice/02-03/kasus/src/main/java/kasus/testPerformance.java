@Test
public void testPerformance() throws InterruptedException {
    for (int numThreads = 1; numThreads < THREADS_MAX; numThreads++) {
        long startMillis = System.currentTimeMillis();
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
        ExecutorService threadPool = Executors.newFixedThreadPool(numThreads);
        for (int i = 0; i < numThreads; i++) {
            threadPool.submit(new Runnable() {
                public void run() {
                    for (long i = 0; i < ITERATIONS; i++) {
                        int nextInt = ThreadLocalRandom.current().nextInt(100);
                        try {
                            queue.put(nextInt);
                            nextInt = queue.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(5, TimeUnit.MINUTES);
        long totalMillis = System.currentTimeMillis() - startMillis;
        double throughput = (double)(numThreads * ITERATIONS * 2) / (double) totalMillis;
        System.out.println(String.format("%s with %d threads: %dms (throughput: %.1f ops/s)", LinkedBlockingQueue.class.getSimpleName(), numThreads, totalMillis, throughput));
    }
}