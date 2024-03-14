package br.edu.ifmt.springbootcleanarch.domain.ports;

public interface LogPort {
    void trace(String msg);
    void debug(String msg);
    void info(String msg);
    void warn(String msg);
    void error(String msg);
}
