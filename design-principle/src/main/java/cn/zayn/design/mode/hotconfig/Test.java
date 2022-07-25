package cn.zayn.design.mode.hotconfig;

public class Test {
    public static void main(String[] args) {
        /**
         * 我们设计了两个功能非常单一的接口：Updater 和 Viewer。ScheduledUpdater 只依赖 Updater 这个跟热更新相关的接口，
         * 不需要被强迫去依赖不需要的 Viewer 接口，
         * 满足接口隔离原则。同理，SimpleHttpServer 只依赖跟查看信息相关的 Viewer 接口，不依赖不需要的 Updater 接口，也满足接口隔离原则
         */
        ConfigSource configSource = new ConfigSource();
        RedisConfig redisConfig = new RedisConfig(configSource);
        KafkaConfig kafkaConfig = new KafkaConfig(configSource);
        ScheduleUpdate redisUpdate = new ScheduleUpdate(redisConfig, 1, 1000);
        redisUpdate.run();
        ScheduleUpdate kafkaUpdate = new ScheduleUpdate(kafkaConfig, 1, 1000);
        kafkaUpdate.run();
        SimpleHttpServer simpleHttpServer = new SimpleHttpServer("xxx", 8080);
        simpleHttpServer.addViewers("/config", kafkaConfig);
        simpleHttpServer.addViewers("/config", redisConfig);

        /**
         * Updater、Viewer 职责更加单一，单一就意味了通用、复用性好。比如，我们现在又有一个新的需求，
         * 开发一个 Metrics 性能统计模块，并且希望将 Metrics 也通过 SimpleHttpServer
         * 显示在网页上，以方便查看。这个时候，尽管 Metrics 跟 RedisConfig
         * 等没有任何关系，但我们仍然可以让 Metrics 类实现非常通用的 Viewer 接口，复用 SimpleHttpServer 的代码实现
         */
        simpleHttpServer.addViewers("/metric", new ApiMetrics());
        simpleHttpServer.addViewers("/metric", new BizMetric());

    }
}
