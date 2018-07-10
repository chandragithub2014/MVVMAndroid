package com.andr.mvvm.RetofitMVVM.Repository;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ResultModel
{
    @SerializedName("id")
    private int id;
    @SerializedName("body")
    private String body;
    @SerializedName("title")
    private String title;
    @SerializedName("userId")
    private String userId;

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getBody ()
    {
        return body;
    }

    public void setBody (String body)
    {
        this.body = body;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", body = "+body+", title = "+title+", userId = "+userId+"]";
    }
}

/*
@Entity(tableName = "post_info")
 public class ResultModel implements Parcelable{
        @NonNull
        @ColumnInfo(name = "userId")
        @SerializedName("userId")
        @Expose
        private Integer userId;

        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        @SerializedName("id")
        @Expose
        private Integer id;

        @NonNull
        @ColumnInfo(name = "title")
        @SerializedName("title")
        @Expose
        private String title;

        @NonNull
        @ColumnInfo(name = "body")
        @SerializedName("body")
        @Expose
        private String body;

        public final Creator<ResultModel> CREATOR = new Creator<ResultModel>() {

            @SuppressWarnings({
                    "unchecked"
            })
            public ResultModel createFromParcel(Parcel in) {
                ResultModel instance = new ResultModel();

                instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));

                instance.title = ((String) in.readValue((String.class.getClassLoader())));

                instance.body = ((String) in.readValue((String.class.getClassLoader())));

                return instance;
            }

            public ResultModel[] newArray(int size) {
                return (new ResultModel[size]);
            }

        };



        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }



        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }



        public void writeToParcel(Parcel dest, int flags) {

            dest.writeValue(id);

            dest.writeValue(title);

            dest.writeValue(body);

        }

        public int describeContents() {
            return 0;
        }
    }

*/
