package daggerok.props;

import daggerok.props.common.Server;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@ConfigurationProperties(prefix = "mq")
public class BrokerProperties implements Serializable {

  private static final long serialVersionUID = 7814185782402980920L;

  String destination;
  Server server;
}
