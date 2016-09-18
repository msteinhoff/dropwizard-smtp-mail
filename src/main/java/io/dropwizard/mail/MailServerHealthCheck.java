package io.dropwizard.mail;

import org.simplejavamail.mailer.Mailer;

import com.codahale.metrics.health.HealthCheck;

public final class MailServerHealthCheck extends HealthCheck {
    private final Mailer mailer;

    public MailServerHealthCheck(final Mailer mailer) {
        this.mailer = mailer;
    }

    @Override
    protected Result check() throws Exception {
        // TODO check if mailer is always connected or only connects on demand
        if (mailer.getSession().getTransport().isConnected()) {
            return Result.healthy();
        } else {
            return Result.unhealthy("mailer is not connected");
        }
    }
}
