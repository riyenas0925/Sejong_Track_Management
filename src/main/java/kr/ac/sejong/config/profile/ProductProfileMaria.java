package kr.ac.sejong.config.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile(value = "product-maria")
@PropertySource({"classpath:production/application-maria.properties"})
public class ProductProfileMaria {
}
