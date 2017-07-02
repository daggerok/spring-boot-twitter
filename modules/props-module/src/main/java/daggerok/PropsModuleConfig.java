package daggerok;

import daggerok.props.BrokerProperties;
import daggerok.props.DatabaseProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class PropsModuleConfig {

  final BrokerProperties mq;
  final DatabaseProperties db;

  public static void main(String[] args) {
    // stub
  }

  @Bean
  public CommandLineRunner init() {
    return args -> {
      log.info("mq: {}", mq);
      log.info("db: {}", db);
    };
  }
}
