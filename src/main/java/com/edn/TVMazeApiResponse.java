package com.edn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TVMazeApiResponse {

    @SerializedName("score")
    @Expose
    private Double score;

    @SerializedName("show")
    @Expose
    private Show show;

    @Getter
    @Setter
    public static class Show {

        @SerializedName("id")
        @Expose
        private Integer id;

        @SerializedName("url")
        @Expose
        private String url;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("type")
        @Expose
        private String type;

        @SerializedName("language")
        @Expose
        private String language;

        @SerializedName("genres")
        @Expose
        private List<String> genres = null;

        @SerializedName("status")
        @Expose
        private String status;

        @SerializedName("runtime")
        @Expose
        private Integer runtime;

        @SerializedName("premiered")
        @Expose
        private String premiered;

        @SerializedName("officialSite")
        @Expose
        private Object officialSite;

        @SerializedName("schedule")
        @Expose
        private Schedule schedule;
        @SerializedName("rating")
        @Expose
        private Rating rating;

        @SerializedName("weight")
        @Expose
        private Integer weight;

        @SerializedName("network")
        @Expose
        private Network network;

        @SerializedName("webChannel")
        @Expose
        private Object webChannel;

        @SerializedName("externals")
        @Expose
        private Externals externals;

        @SerializedName("image")
        @Expose
        private Image image;

        @SerializedName("summary")
        @Expose
        private String summary;

        @SerializedName("updated")
        @Expose
        private Integer updated;

        @SerializedName("_links")
        @Expose
        private Links links;
    }

    @Getter
    @Setter
    public static class Country {

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("code")
        @Expose

        private String code;
        @SerializedName("timezone")
        @Expose
        private String timezone;
    }

    @Getter
    @Setter
    public static class Externals {

        @SerializedName("tvrage")
        @Expose
        private Integer tvrage;

        @SerializedName("thetvdb")
        @Expose
        private Integer thetvdb;

        @SerializedName("imdb")
        @Expose
        private String imdb;
    }

    @Getter
    @Setter
    public static class Image {

        @SerializedName("medium")
        @Expose
        private String medium;

        @SerializedName("original")
        @Expose
        private String original;
    }

    @Getter
    @Setter
    public static class Links {

        @SerializedName("self")
        @Expose
        private Self self;

        @SerializedName("previousepisode")
        @Expose
        private Previousepisode previousepisode;

        @SerializedName("nextepisode")
        @Expose
        private Nextepisode nextepisode;
    }

    @Getter
    @Setter
    public static class Network {

        @SerializedName("id")
        @Expose
        private Integer id;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("country")
        @Expose
        private Country country;
    }

    @Getter
    @Setter
    public static class Nextepisode {

        @SerializedName("href")
        @Expose
        private String href;
    }

    @Getter
    @Setter
    public static class Previousepisode {

        @SerializedName("href")
        @Expose
        private String href;
    }

    @Getter
    @Setter
    public static class Rating {

        @SerializedName("average")
        @Expose
        private Double average;
    }

    @Getter
    @Setter
    public static class Schedule {

        @SerializedName("time")
        @Expose
        private String time;

        @SerializedName("days")
        @Expose
        private List<String> days = null;
    }

    @Getter
    @Setter
    public static class Self {

        @SerializedName("href")
        @Expose
        private String href;
    }
}