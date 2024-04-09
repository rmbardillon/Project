package com.library.management.system;

public class Member {
    private String id;
    private String name;
    private String email;
    private String membershipStatus;

    public Member() {
    }

    public Member(String id, String name, String email, String membershipStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.membershipStatus = membershipStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

}
