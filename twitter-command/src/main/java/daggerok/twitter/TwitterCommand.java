package daggerok.twitter;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@EnableBinding(Source.class)
@Transactional(readOnly = true)
public class TwitterCommand {

  final Source source;

  @Async
  @Transactional
  public void save(@NonNull final Twitter twitter) {

    source.output()
          .send(MessageBuilder.withPayload(twitter)
                              .build());
  }
}
