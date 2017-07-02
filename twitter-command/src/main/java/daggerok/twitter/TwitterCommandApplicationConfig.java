package daggerok.twitter;

import lombok.val;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import static java.lang.Integer.MAX_VALUE;

@EnableAsync
@Configuration
@EnableBinding(Source.class)
@ComponentScan(basePackageClasses = {
    TwitterCommand.class,
    TwitterResource.class,
})
public class TwitterCommandApplicationConfig {

  @Bean
  public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
    val executor = new ThreadPoolTaskExecutor();
    executor.setThreadNamePrefix(TwitterCommand.class.getSimpleName());
    executor.setCorePoolSize(MAX_VALUE);
    executor.initialize();
    return executor;
  }
}
