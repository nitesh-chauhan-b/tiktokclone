package com.managmnet.tiktok;

public class Model {
    String videoUri,name;
    int profile;

    public Model(String videoUri, String name, int profile) {
        this.videoUri = videoUri;
        this.name = name;
        this.profile = profile;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }
}
