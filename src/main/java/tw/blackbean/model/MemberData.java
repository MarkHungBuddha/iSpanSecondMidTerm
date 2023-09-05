package tw.blackbean.model;

import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
public class MemberData {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "memberid", nullable = false)
    private int memberid;
    @Basic
    @Column(name = "username", nullable = true, length = 50)
    private String username;
    @Basic
    @Column(name = "gender", nullable = true, length = 10)
    private String gender;
    @Basic
    @Column(name = "birthdate", nullable = true)
    private String birthdate;
    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    private String phone;
    @Basic
    @Column(name = "email", nullable = true, length = 100)
    private String email;
    @Basic
    @Column(name = "passwd", nullable = true, length = 50)
    private String passwd;
    @Basic
    @Column(name = "membercreationdate", nullable = true)
    private String membercreationdate;
    @Basic
    @Column(name = "country", nullable = true, length = 50)
    private String country;
    @Basic
    @Column(name = "city", nullable = true, length = 50)
    private String city;


    @Basic
    @Column(name = "region", nullable = true, length = 50)
    private String region;
    @Basic
    @Column(name = "street", nullable = true, length = 100)
    private String street;
    @Basic
    @Column(name = "postalcode", nullable = true, length = 20)
    private String postalcode;

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getMembercreationdate() {
        return membercreationdate;
    }

    public void setMembercreationdate(String membercreationdate) {
        this.membercreationdate = membercreationdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", MemberData.class.getSimpleName() + "[", "]")
                .add("memberid=" + memberid)
                .add("username='" + username + "'")
                .add("gender='" + gender + "'")
                .add("birthdate=" + birthdate)
                .add("phone='" + phone + "'")
                .add("email='" + email + "'")
                .add("passwd='" + passwd + "'")
                .add("membercreationdate=" + membercreationdate)
                .add("country='" + country + "'")
                .add("city='" + city + "'")
                .add("region='" + region + "'")
                .add("street='" + street + "'")
                .add("postalcode='" + postalcode + "'")
                .toString();
    }
}
