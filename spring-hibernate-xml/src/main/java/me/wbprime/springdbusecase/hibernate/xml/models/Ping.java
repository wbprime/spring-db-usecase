package me.wbprime.springdbusecase.mybatis.xml.models;


/**
 * Class: Ping
 * Date: 2016/04/19 10:11
 *
 * @author Elvis Wang [bo.wang35@renren-inc.com]
 */
public class Ping {
    private Integer id;
    private String title;
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
        final StringBuilder sb = new StringBuilder("Ping{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
