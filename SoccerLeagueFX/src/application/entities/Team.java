package application.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "tbl_teams")
public class Team implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int team_id;
    
    @OneToOne
    Manager manager;
    
    @ElementCollection
    @Column(name = "players")
    private List<Player> mPlayers = new ArrayList<>();
    
    @Column(name = "jersey_color")
    String jerseyColor;
    
    @Column(name = "team_name")
    String teamName;

    public Team() {
    }

    public Team(int team_id, Manager manager, String jerseyColor, String teamName) {
        this.team_id = team_id;
        this.manager = manager;
        this.jerseyColor = jerseyColor;
        this.teamName = teamName;
        this.mPlayers = new ArrayList<>();
    }
    
    public void addPlayer(Player player) {
        mPlayers.add(player);
    }

    public void removePlayer(Player player) {
        mPlayers.remove(player);
    }
    
    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }
    
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
    
    public String getTeamName(){
        return teamName;
    }
    
    public void setManager(Manager manager){
        this.manager = manager;
    }
    
    public void removeManager(){
        this.manager = null;
    }
    
    public Manager getManager(){
        return manager;
    }

    public void setJerseyColor(String jerseyColor) {
        this.jerseyColor = jerseyColor;
    }
    
    public String getJerseyColor() {
        return jerseyColor;
    }

    public List<Player> getAllPlayers(){
        return mPlayers;
    }
    
    public String displayTeam(){
       return "Team{" + "Team Name=" + teamName + "\t\tTeam Manager=" + manager.getName() + "\t\tJersey Color=" + jerseyColor + "}";
    }
    
    public String displayPlayer(){
        return mPlayers.toString();
    }
    
    public String displayManager(){
        return manager.toString();
    }
}