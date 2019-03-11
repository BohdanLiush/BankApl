package apk.win.first.bankapl;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Organization implements Serializable, Parcelable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("oldId")
    @Expose
    private Integer oldId;

    @SerializedName("orgType")
    @Expose
    private Integer orgType;

    @SerializedName("branch")
    @Expose
    private Boolean branch;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("regionId")
    @Expose
    private String regionId;
    @SerializedName("cityId")
    @Expose
    private String cityId;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("currencies")
    @Expose
    private Currencies currencies;

    protected Organization(Parcel in) {
        id = in.readString();
        if (in.readByte() == 0) {
            oldId = null;
        } else {
            oldId = in.readInt();
        }
        if (in.readByte() == 0) {
            orgType = null;
        } else {
            orgType = in.readInt();
        }
        byte tmpBranch = in.readByte();
        branch = tmpBranch == 0 ? null : tmpBranch == 1;
        title = in.readString();
        regionId = in.readString();
        cityId = in.readString();
        phone = in.readString();
        address = in.readString();
        link = in.readString();
    }

    public static final Creator<Organization> CREATOR = new Creator<Organization>() {
        @Override
        public Organization createFromParcel(Parcel in) {
            return new Organization(in);
        }

        @Override
        public Organization[] newArray(int size) {
            return new Organization[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOldId() {
        return oldId;
    }

    public void setOldId(Integer oldId) {
        this.oldId = oldId;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public Boolean getBranch() {
        return branch;
    }

    public void setBranch(Boolean branch) {
        this.branch = branch;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currencies currencies) {
        this.currencies = currencies;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
    }
}