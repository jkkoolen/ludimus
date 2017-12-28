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

@Entity
@Table(name = "kmr")
@JsonDeserialize(using = KmrDeserializer.class)
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Kmr extends BaseEntity {
    private static final long serialVersionUID = 4757970653858900847L;

    @Column(name = "day")
    private Date day;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "is_business")
    private boolean isBusiness;

    @Column(name = "start_total")
    @Setter
    private Integer startTotal;

    @Column(name = "end_total")
    private Integer endTotal;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @Setter
    private User user;
}
