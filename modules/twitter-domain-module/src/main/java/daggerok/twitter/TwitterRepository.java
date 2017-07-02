package daggerok.twitter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface TwitterRepository extends JpaRepository<Twitter, Long> {

  Optional<Twitter> findFirstById(@Param("id") final Long id);

  Stream<Twitter> findAllByDataContaining(@Param("data") final String data);
}
