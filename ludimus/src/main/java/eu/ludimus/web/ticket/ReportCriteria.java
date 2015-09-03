package eu.ludimus.web.ticket;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ReportCriteria {
    public static enum Type {
        TAX_EXPORT,
        PDF_EXPORT,
        OVERVIEW;
        public String getName() {
            return this.name();
        }
    }
    private Type type;
    @NotNull
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date fromDate;
    @NotNull
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date toDate;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
