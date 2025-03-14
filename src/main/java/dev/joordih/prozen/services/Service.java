package dev.joordih.prozen.services;

public interface Service {
  void register();

  default void unregister() {
  }
}
