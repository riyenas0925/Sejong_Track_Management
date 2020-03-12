package kr.ac.sejong.config.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile(value = "develop-mysql")
@PropertySource({"classpath:develop/application-mysql.properties"})
public class DevProfileMySQL {
}
