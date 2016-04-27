package me.wbprime.springdbusecase.jpa.xml.models;


import java.util.Date;

/**
 * Class: Ping
 * Date: 2016/04/19 10:11
 *
 * @author Elvis Wang [bo.wang35@renren-inc.com]
 */
public class Ping {
    private Integer id;
    private String  title;
    private String  description;
    private Date    createTime;

    public Ping() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ping{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}
