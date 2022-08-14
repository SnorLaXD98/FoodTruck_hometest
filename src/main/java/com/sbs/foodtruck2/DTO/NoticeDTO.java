package com.sbs.foodtruck2.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDTO {

    @JsonIgnore
    private int noticeId;
    private String content;
    private String date;
    private String title;

    public NoticeDTO(){

    }

    public NoticeDTO(int noticeId, String content, String date, String title) {
        this.noticeId = noticeId;
        this.content = content;
        this.date = date;
        this.title = title;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "noticeId=" + noticeId +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
