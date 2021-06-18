package com.yfz.mvp;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginInfo implements Parcelable {

    private String userid;
    private String name;
    private String role;

    public LoginInfo(){

    }

    protected LoginInfo(Parcel in) {
        userid = in.readString();
        name = in.readString();
        role = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userid);
        parcel.writeString(name);
        parcel.writeString(role);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LoginInfo> CREATOR = new Creator<LoginInfo>() {
        @Override
        public LoginInfo createFromParcel(Parcel in) {
            return new LoginInfo(in);
        }

        @Override
        public LoginInfo[] newArray(int size) {
            return new LoginInfo[size];
        }
    };

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}