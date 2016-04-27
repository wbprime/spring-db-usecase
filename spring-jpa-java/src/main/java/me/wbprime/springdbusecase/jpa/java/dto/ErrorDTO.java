package me.wbprime.springdbusecase.jpa.java.dto;


/**
 * Class: ErrorDTO
 * Date: 2016/04/19 11:23
 *
 * @author Elvis Wang [bo.wang35@renren-inc.com]
 */
public class ErrorDTO {
    private String error;

    public final String getError() {
        return error;
    }

    public final void setError(final String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorDTO{");
        sb.append("error='").append(error).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
