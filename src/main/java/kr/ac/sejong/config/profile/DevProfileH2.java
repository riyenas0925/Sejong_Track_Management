package kr.ac.sejong.config.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile(value = "develop-h2")
@PropertySource({"classpath:develop/application-h2.properties"})
public class DevProfileH2 {
}
