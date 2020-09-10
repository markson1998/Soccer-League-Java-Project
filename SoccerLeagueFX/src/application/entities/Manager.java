package application.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "tbl_managers")
public class Manager implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int manager_id;
    
    private String firstName;
    private String middleName;
    private String lastName;
    private String phone; 
    private String email;
    private String dob;
    private int starRating;
    
    @OneToOne
    private Team teamToManage;

    public Manager() {
    }

    public Manager(int manager_id, String firstName, String middleName, String lastName, String phone, String email, String dob, int starRating, Team teamToManage) {
        this.manager_id = manager_id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.starRating = starRating;
        this.teamToManage = teamToManage;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public Team getTeamToManage() {
        return teamToManage;
    }

    public void setTeamToManage(Team teamToManage) {
        this.teamToManage = teamToManage;
    }
    
    public String getName(){
        return firstName + " " + middleName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Manager{" + "name="+ getName() + "\t\tphone=" + phone + "\t\temail=" + email+ "\t\tdob=" + dob + "\t\tstarRating=" + starRating +'}';
    }
}
