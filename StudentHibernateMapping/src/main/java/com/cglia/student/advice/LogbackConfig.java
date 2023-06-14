package com.cglia.student.advice;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.FileAppender;

@Configuration
public class LogbackConfig {

	public LogbackConfig() {
		configureLogback();
	}

	private void configureLogback() {
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		loggerContext.reset();

		// Set the desired log file path
		String logFilePath = "C:/Users/bhuvan.bhalme/Documents/AOP_logger/application.log";

		// Configure the file appender
		FileAppender fileAppender = new FileAppender();
		fileAppender.setFile(logFilePath);

		// Configure the encoder pattern
		PatternLayoutEncoder encoder = new PatternLayoutEncoder();
		encoder.setPattern("%-5level [%thread] %logger{36} - %msg%n");
		encoder.setContext(loggerContext);
		encoder.start();

		// Attach the encoder to the appender
		fileAppender.setEncoder(encoder);
		fileAppender.setContext(loggerContext);
		fileAppender.start();

		// Get the root logger and add the appender
		ch.qos.logback.classic.Logger rootLogger = loggerContext
				.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
		rootLogger.addAppender(fileAppender);
	}
}
