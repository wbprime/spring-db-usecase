package me.wbprime.springdbusecase.hibernate.xml.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class: PingDTO
 * Date: 2016/04/19 10:13
 *
 * @author Elvis Wang [bo.wang35@renren-inc.com]
 */
public class PingDTO {
    private Integer id;

    @Size(max = 128)
    @NotNull
    private String title;

    @Size(max = 256)
    @NotNull
    private String description;

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PingDTO{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
