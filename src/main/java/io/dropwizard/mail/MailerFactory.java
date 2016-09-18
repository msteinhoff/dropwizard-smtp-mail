package io.dropwizard.mail;

import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.config.ServerConfig;
import org.simplejavamail.mailer.config.TransportStrategy;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.net.HostAndPort;

import javax.validation.constraints.NotNull;

import io.dropwizard.setup.Environment;

public class MailerFactory {
    @NotNull
    protected HostAndPort server;

    protected String username;

    protected String password;

    @NotNull
    protected TransportStrategy transport;

    public MailerFactory() {
        this.server = HostAndPort.fromParts("localhost", 25);
        this.username = null;
        this.password = null;
        this.transport = TransportStrategy.SMTP_PLAIN;
    }

    @JsonProperty("server")
    public final HostAndPort getServer() {
        return server;
    }

    @JsonProperty("server")
    public final void setServer(final HostAndPort server) {
        this.server = server;
    }

    @JsonProperty("username")
    public final String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public final void setUsername(final String username) {
        this.username = username;
    }

    @JsonProperty("password")
    public final String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public final void setPassword(final String password) {
        this.password = password;
    }

    @JsonProperty("transport")
    public final TransportStrategy getTransport() {
        return transport;
    }

    @JsonProperty("transport")
    public final void setTransport(final TransportStrategy transport) {
        this.transport = transport;
    }

    public final Mailer build(final Environment environment, final String name) {
        final Mailer mailer;
        mailer = new Mailer(new ServerConfig(server.getHostText(), server.getPort(), username, password), transport);
        // TODO figure out how to collect email metrics
        environment.healthChecks().register(name, new SocketHealthCheck(server));
        return mailer;
    }
}
