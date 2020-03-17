@Test
public void stressTest() throws InterruptedException {
    final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
    blitzer.blitz(new Runnable() {
        public void run() {
            try {
                queue.put(42);
                queue.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    assertThat(queue.getSize(), is(0));
}