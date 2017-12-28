package eu.ludimus.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Component
@ConfigurationProperties("ludimus")
@Getter
@Setter
public class LudimusProperties {
    private Filter filter = new Filter();

    public boolean isPublic(final String path) {
        return getFilter().getAuthorized().stream().filter((authorized) -> {
            System.out.println(authorized.path + " " + path);
            return authorized.path.equals(path);
        }).findAny().isPresent();
    }

    public boolean shouldForward(final String path) {
        return getFilter().getForwards().stream().filter(forward -> forward.path.equals(path)).count() > 0;
    }

    public String getForwardUrl(final String path) {
        final List<Forward> forwards = getFilter().getForwards().stream().filter(forward -> forward.path.equals(path)).collect(Collectors.toList());
        if(forwards.size() > 0) {
            return forwards.get(0).getTo();
        }
        return "/";
    }

    public boolean isStatic(final String path) {
        return getFilter().getStatics().stream().filter(aStatic -> path.toLowerCase().endsWith(aStatic.getExt())).count() > 0;
    }

    @Getter
    @Setter
    @ToString
    public static class Filter {
        private List<Authorized> authorized = new ArrayList<>();
        private List<Forward> forwards = new ArrayList<>();
        private List<Static> statics = new ArrayList<>();
    }

    @Getter
    @Setter
    @ToString
    public static class Authorized {
        private String path;
    }

    @Getter
    @Setter
    @ToString
    public static class Forward {
        private String path;
        private String to;
    }

    @Getter
    @Setter
    @ToString
    public static class Static {
        private String ext;
    }
}
