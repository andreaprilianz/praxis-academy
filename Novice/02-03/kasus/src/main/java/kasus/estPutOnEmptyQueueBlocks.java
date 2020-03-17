package kasus;

@Test
public void testPutOnEmptyQueueBlocks() throws InterruptedException {
    final SimpleBlockingQueue queue = new SimpleBlockingQueue();
    BlockingThread blockingThread = new BlockingThread(queue);
    blockingThread.start();
    Thread.sleep(5000);
    assertThat(blockingThread.isReachedAfterGet(), is(false));
    assertThat(blockingThread.isWasInterrupted(), is(false));
    assertThat(blockingThread.isThrowableThrown(), is(false));
    queue.put(new Object());
    Thread.sleep(1000);
    assertThat(blockingThread.isReachedAfterGet(), is(true));
    assertThat(blockingThread.isWasInterrupted(), is(false));
    assertThat(blockingThread.isThrowableThrown(), is(false));
    blockingThread.join();
}