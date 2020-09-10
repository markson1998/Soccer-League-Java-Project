package application.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table( name = "tbl_players")
public class Player implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int player_id;
    
    private String firstName;
    private String middleName;
    private String lastName;
    private String phone; 
    private String email;
    
    @Column(name = "goals_in_year")
    private int numberOfGoalsInCurrentYear;
    
    @Column(name = "goalie")
    private boolean goalie;
    
    @Column(name = "defended_goals")
    private int defendedGoals;

    public Player() {
        
    }

    public Player(int player_id, String firstName, String middleName, String lastName, String phone, String email, int numberOfGoalsInCurrentYear, boolean goalie, int defendedGoals) {
        this.player_id = player_id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.numberOfGoalsInCurrentYear = numberOfGoalsInCurrentYear;
        this.goalie = goalie;
        this.defendedGoals = defendedGoals;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
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
    
    public int getNumberOfGoalsInCurrentYear() {
        return numberOfGoalsInCurrentYear;
    }

    public void setNumberOfGoalsInCurrentYear(int numberOfGoalsInCurrentYear) {
        this.numberOfGoalsInCurrentYear = numberOfGoalsInCurrentYear;
    }

    public boolean isGoalie() {
        return goalie;
    }

    public void setGoalie(boolean goalie) {
        this.goalie = goalie;
    }
    
    public void setDefendedGoals(int defendedGoals){
        if(goalie){
            this.defendedGoals = defendedGoals;
        }
        else{
            System.out.println("Player is not Golie...");
        }
    }
    
    public int getDefendedGoals(){
        return defendedGoals;
    }
    
    public String getName(){
        return firstName + " " + middleName + " " + lastName;
    }

    @Override
    public String toString() {
        if(goalie){
            return "Player{" + "name=" + getName() + "\tphone=" + phone + "\temail=" + email + "\tGoalie=" + goalie + "\tDefended_Goals=" + defendedGoals + '}';
        }
        else{
            return "Player{" + "name=" + getName() + "\tphone=" + phone + "\temail=" + email + "\tnumberOfGoalsInCurrentYear=" + numberOfGoalsInCurrentYear + "\tgoalie=" + goalie + '}';
        }
    }
}