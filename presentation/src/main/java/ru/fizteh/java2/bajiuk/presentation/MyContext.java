package ru.fizteh.java2.bajiuk.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.InputStream;
import java.io.PrintStream;

@Configuration
@EnableAutoConfiguration
@ComponentScan("ru.fizteh.java2.bajiuk")
@PropertySource("classpath:shell.properties")
public class MyContext {
    @Bean
    public InputStream getStdIn() {
        return System.in;
    }

    @Bean
    public PrintStream getStdOut() {
        return System.out;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyContext.class);
    }
}
