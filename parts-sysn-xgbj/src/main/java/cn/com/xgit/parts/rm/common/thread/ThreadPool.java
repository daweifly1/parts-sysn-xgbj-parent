package cn.com.xgit.parts.rm.common.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
public final class ThreadPool {
    private ThreadPool() {
    }

    public static ExecutorService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void exec(Runnable command) {
        getInstance().execute(command);
    }

    public static <T> Future<T> submit(Callable<T> command) {
        return getInstance().submit(command);
    }

    public static void shutdown() {
        getInstance().shutdown();
    }

    public static boolean isTerminated() {
        return getInstance().isTerminated();
    }

    private static class SingletonHolder {
        /**
         * 线程池最少线程数
         */
        private static final int THREAD_POOL_CORE_SIZE = 5;
        /**
         * 最大线程数
         */
        private static final int THREAD_POOL_MAX_SIZE = 20;
        /**
         * 最大线程等待数
         */
        private static final int THREAD_MAX_THREAD_WAIT = 10000;
        /**
         * 最长等待时间
         */
        private static final int THREAD_POOL_WAIT_SECONDS = 5 * 60;

        private static final ExecutorService INSTANCE = new ThreadPoolExecutor(THREAD_POOL_CORE_SIZE, THREAD_POOL_MAX_SIZE, THREAD_POOL_WAIT_SECONDS, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(THREAD_MAX_THREAD_WAIT), new ThreadPoolExecutor.AbortPolicy());
    }
}
