package com.watchingy.model;

public class emotionBean {
    private float sadness;
    private float neutral;
    private float disgust;
    private float anger;
    private float surprise;
    private float fear;
    private float happiness;

    public String getEmotion(){
        float i = sadness;
        String result = "伤心";
        if(i < neutral) {
            i = neutral;
            result = "平静";
        }
        if(i < disgust){
            i = disgust;
            result = "迷惑";
        }
        if(i < anger){
            i = anger;
            result = "生气";
        }
        if(i < surprise){
            i = surprise;
            result = "吃惊";
        }
        if(i < fear){
            i = fear;
            result = "恐惧";
        }
        if(i < happiness){
            result = "开心";
        }
        return result;
    }

    public float getSadness() {
        return sadness;
    }

    public void setSadness(float sadness) {
        this.sadness = sadness;
    }

    public float getNeutral() {
        return neutral;
    }

    public void setNeutral(float neutral) {
        this.neutral = neutral;
    }

    public float getDisgust() {
        return disgust;
    }

    public void setDisgust(float disgust) {
        this.disgust = disgust;
    }

    public float getAnger() {
        return anger;
    }

    public void setAnger(float anger) {
        this.anger = anger;
    }

    public float getSurprise() {
        return surprise;
    }

    public void setSurprise(float surprise) {
        this.surprise = surprise;
    }

    public float getFear() {
        return fear;
    }

    public void setFear(float fear) {
        this.fear = fear;
    }

    public float getHappiness() {
        return happiness;
    }

    public void setHappiness(float happiness) {
        this.happiness = happiness;
    }
}
