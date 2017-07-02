package daggerok.twitter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Twitter implements Serializable {

  private static final long serialVersionUID = 1349410454351785631L;

  @Id
  @GeneratedValue(strategy = IDENTITY)
  Long id;

  @Column(nullable = false)
  String data;
}
