package eu.ludimus.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import eu.ludimus.model.deserializer.KmrDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@JsonDeserialize(using = KmrDeserializer.class)
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Kmr extends BaseEntity {
    private static final long serialVersionUID = 4757970653858900847L;

    private Date day;

    private String origin;

    private String destination;

    private boolean isBusiness;

    @Setter
    private Integer startTotal;

    private Integer endTotal;

    @Setter
    private User user;
}
