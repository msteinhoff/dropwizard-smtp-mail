# Dropwizard SMTP mailer

[![Build Status](https://travis-ci.org/msteinhoff/dropwizard-smtp-mail.svg?branch=master)](https://travis-ci.org/msteinhoff/dropwizard-smtp-mail)
[![Coverage Status](https://img.shields.io/coveralls/msteinhoff/dropwizard-smtp-mail.svg)](https://coveralls.io/r/msteinhoff/dropwizard-smtp-mail)
[![Maven Central](https://img.shields.io/maven-central/v/io.dropwizard.modules/dropwizard-smtp-mail.svg)](http://mvnrepository.com/artifact/io.dropwizard.modules/dropwizard-smtp-mail)

A set of classes to send [SMTP mails] [1] in a [Dropwizard] [2] application.

The package provides [lifecycle-management] [3] and configuration factory
classes with the most common options for simple-java-mail Mailer classes.

[1]: http://www.simplejavamail.org/
[2]: http://dropwizard.io/1.0.0/docs
[3]: http://dropwizard.io/1.0.0/docs/manual/core.html#managed-objects

# Usage

To embed a mailer, add a `MailerFactory` to your [Configuration](http://dropwizard.io/1.0.0/docs/manual/core.html#configuration)
class. This enables configuration of the smtp mail server, credentials and TLS
settings.

Use the `MailerFactory` class to create a `Mailer` via `build()`.  A health
check is registered that checks if the host and port is reachable. The mailer is
automatically closed when dropwizard shuts down.

# Configuration

The following configuration settings are supported by `MailerFactory`:

* `server`: smtp server host and port, defaults to `localhost:25`
* `username`: user name to login, empty by default
* `password`: user name to login, empty by default
* `transport`: `SMTP_PLAIN` (default) or `SMTP_TLS`

# Maven Artifacts

This project is not yet available on Maven Central. You have to clone it and
install it in your local maven repository. To add it to your project simply add
the following dependencies to your `pom.xml`:

    <dependency>
      <groupId>io.dropwizard.modules</groupId>
      <artifactId>dropwizard-smtp-mail</artifactId>
      <version>1.0.0-1-SNAPSHOT</version>
    </dependency>


# Support

Please file bug reports and feature requests in [GitHub issues](https://github.com/msteinhoff/dropwizard-smtp-mail/issues).


# License

Copyright (c) 2016 Mario Steinhoff

This library is licensed under the Apache License, Version 2.0.

See http://www.apache.org/licenses/LICENSE-2.0.html or the LICENSE file in this repository for the full license text.
