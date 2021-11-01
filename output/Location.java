package com.example.shesh.Models;

@Entity
@Table(name = "Location")
public Location {

        @SerializedName("Id")
    @Column(name = "Id")
    private Long _id;
        @SerializedName("ParentName")
    @Column(name = "ParentName")
    private Long _parentName;
        @SerializedName("Name")
    @Column(name = "Name")
    private String _name;
        @SerializedName("OcationType")
    @Column(name = "OcationType")
    private LocationType _ocationType;
        @SerializedName("Latitude")
    @Column(name = "Latitude")
    private Long _latitude;
        @SerializedName("Longitude")
    @Column(name = "Longitude")
    private Long _longitude;
        @SerializedName("Code")
    @Column(name = "Code")
    private Integer _code;
        @SerializedName("PhoneCode")
    @Column(name = "PhoneCode")
    private Integer _phoneCode;
    
        public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        public Long getParentName() {
        return this.parentName;
    }

    public void setParentName(Long parentName) {
        this.parentName = parentName;
    }
        public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
        public LocationType getOcationType() {
        return this.ocationType;
    }

    public void setOcationType(LocationType ocationType) {
        this.ocationType = ocationType;
    }
        public Long getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }
        public Long getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }
        public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
        public Integer getPhoneCode() {
        return this.phoneCode;
    }

    public void setPhoneCode(Integer phoneCode) {
        this.phoneCode = phoneCode;
    }
    }