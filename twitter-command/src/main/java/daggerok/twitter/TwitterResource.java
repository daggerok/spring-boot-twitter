package daggerok.twitter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TwitterResource {

  final TwitterCommand command;

  @Async
  @PostMapping("/")
  @ResponseStatus(ACCEPTED)
  public void post(@RequestBody final Twitter twitter) {

    log.info("saving {}", twitter);
    command.save(twitter);
  }
}
