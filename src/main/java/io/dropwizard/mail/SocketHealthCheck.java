package io.dropwizard.mail;

import static com.google.common.base.Preconditions.checkNotNull;

import java.net.Socket;

import com.codahale.metrics.health.HealthCheck;
import com.google.common.net.HostAndPort;

public class SocketHealthCheck extends HealthCheck {
    private final HostAndPort server;

    public SocketHealthCheck(final HostAndPort server) {
        this.server = checkNotNull(server, "server is null");
    }

    @Override
    protected Result check() throws Exception {
        try (final Socket socket = new Socket(server.getHostText(), server.getPort())) {
            return Result.healthy();
        } catch (Exception e) {
            return Result.unhealthy("Could not connect to %s", server);
        }
    }
}
