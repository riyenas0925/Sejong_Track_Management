package kr.ac.sejong.config;

import kr.ac.sejong.config.profile.DevProfileH2;
import kr.ac.sejong.config.profile.DevProfileMySQL;
import kr.ac.sejong.config.profile.ProductProfileMaria;
import org.springframework.context.annotation.Import;

@Import({DevProfileMySQL.class, DevProfileH2.class, ProductProfileMaria.class})
public class ProfileConfig {
}
