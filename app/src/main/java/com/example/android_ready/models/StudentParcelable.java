package com.example.android_ready.models;

import android.os.Parcel;
import android.os.Parcelable;

public class StudentParcelable implements Parcelable {

    String name, dob;

    public StudentParcelable(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    protected StudentParcelable(Parcel in) {
        this.name = in.readString();
        this.dob = in.readString();
    }

    public static final Creator<StudentParcelable> CREATOR = new Creator<StudentParcelable>() {
        @Override
        public StudentParcelable createFromParcel(Parcel in) {
            return new StudentParcelable(in);
        }

        @Override
        public StudentParcelable[] newArray(int size) {
            return new StudentParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(dob);
    }
}
