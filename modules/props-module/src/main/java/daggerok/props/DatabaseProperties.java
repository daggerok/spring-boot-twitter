package daggerok.props;

import daggerok.props.common.Server;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@ConfigurationProperties(prefix = "db")
public class DatabaseProperties implements Serializable {

  private static final long serialVersionUID = -323895804947475572L;

  String name;
  Server server;
}
