package eu.ludimus.properties;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ToString
@Component
@ConfigurationProperties("ludimus")
@Data
@Slf4j
public class LudimusProperties {
    private String dataDir;

}
