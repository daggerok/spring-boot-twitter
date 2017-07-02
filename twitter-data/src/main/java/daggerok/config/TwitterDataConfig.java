package daggerok.config;

import daggerok.twitter.Twitter;
import daggerok.twitter.TwitterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableBinding(Sink.class)
@Transactional(readOnly = true)
public class TwitterDataConfig {

  final TwitterRepository twitterRepository;

  @Transactional
  @StreamListener(Sink.INPUT)
  public void onTwitter(final Twitter twitter) {

    log.info("received: {}", twitter);
    val saved = twitterRepository.save(twitter);
    log.info("saved: {}", saved);
  }
}
