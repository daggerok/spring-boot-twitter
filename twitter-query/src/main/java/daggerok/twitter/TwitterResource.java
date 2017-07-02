package daggerok.twitter;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TwitterResource {

  final TwitterRepository twitterRepository;

  @GetMapping("/")
  public List<Twitter> get() {
    return twitterRepository.findAll();
  }
}
