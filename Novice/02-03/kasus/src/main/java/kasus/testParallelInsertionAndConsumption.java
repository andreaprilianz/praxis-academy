@Test
public void testParallelInsertionAndConsumption() throws InterruptedException, ExecutionException {
    final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
    ExecutorService threadPool = Executors.newFixedThreadPool(NUM_THREADS);
    final CountDownLatch latch = new CountDownLatch(NUM_THREADS);
    List<Future<Integer>> futuresPut = new ArrayList<Future<Integer>>();
    for (int i = 0; i < 3; i++) {
        Future<Integer> submit = threadPool.submit(new Callable<Integer>() {
            public Integer call() {
                int sum = 0;
                for (int i = 0; i < 1000; i++) {
                    int nextInt = ThreadLocalRandom.current().nextInt(100);
                    queue.put(nextInt);
                    sum += nextInt;
                }
                latch.countDown();
                return sum;
            }
        });
        futuresPut.add(submit);
    }
    List<Future<Integer>> futuresGet = new ArrayList<Future<Integer>>();
    for (int i = 0; i < 3; i++) {
        Future<Integer> submit = threadPool.submit(new Callable<Integer>() {
            public Integer call() {
                int count = 0;
                try {
                    for (int i = 0; i < 1000; i++) {
                        Integer got = queue.get();
                        count += got;
                    }
                } catch (InterruptedException e) {
 
                }
                latch.countDown();
                return count;
            }
        });
        futuresGet.add(submit);
    }
    latch.await();
    int sumPut = 0;
    for (Future<Integer> future : futuresPut) {
        sumPut += future.get();
    }
    int sumGet = 0;
    for (Future<Integer> future : futuresGet) {
        sumGet += future.get();
    }
    assertThat(sumPut, is(sumGet));
}