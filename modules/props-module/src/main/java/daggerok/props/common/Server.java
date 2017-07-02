package daggerok.props.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Server implements Serializable {

  private static final long serialVersionUID = -7151585064476879633L;

  String type;
  String host;
  Integer port;
  String user;
  String pass;
}
