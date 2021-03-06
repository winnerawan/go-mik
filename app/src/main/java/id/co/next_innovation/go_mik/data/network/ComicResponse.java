package id.co.next_innovation.go_mik.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.co.next_innovation.go_mik.data.db.entity.Comic;

public class ComicResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private DataComic data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataComic getData() {
        return data;
    }

    public void setData(DataComic data) {
        this.data = data;
    }

    public class DataComic {
        @SerializedName("comics")
        @Expose
        private List<Comic> comics = null;
        @SerializedName("paginator")
        @Expose
        private Paginator paginator;

        public List<Comic> getComics() {
            return comics;
        }

        public void setComics(List<Comic> comics) {
            this.comics = comics;
        }

        public Paginator getPaginator() {
            return paginator;
        }

        public void setPaginator(Paginator paginator) {
            this.paginator = paginator;
        }
    }
}
