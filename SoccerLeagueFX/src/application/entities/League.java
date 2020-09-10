
package application.entities;

import java.util.ArrayList;
import java.util.List;


public class League {
    private List<Team> mTeam = new ArrayList<>();
    
    public void addTeam(Team team) {
        mTeam.add(team);
    }

    public void removeTeam(Team team) {
        mTeam.remove(team);
    }
    
    public int getSize(){
       return mTeam.size();
    }
    
    public boolean isJersyColorUnique(){
        for(int i=0;i<getSize();i++){
            for(int j=i+1; j<getSize(); j++){
                if(mTeam.get(i).getJerseyColor().equalsIgnoreCase(mTeam.get(j).jerseyColor)){
                    break;
                }
            }
        }
        return false;
    }
    
    public void displayTeam(Manager manager){
        boolean isFound = false;
        for(int i=0;i<getSize();i++){
            if(mTeam.get(i).getManager().equals(manager)){
                System.out.println(mTeam.get(i).displayTeam());
                isFound = true;
            }
        }
        if(!isFound){
            System.out.println("No Team Found for Manager: " + manager.getName());
        }
    }
    
    public void displayAllTeams(){
        for(int i=0;i<getSize();i++){
            System.out.println(mTeam.get(i).displayTeam());
        }
    }
    
    public void displayAllPlayers(){
        for(int i=0;i<getSize();i++){
            System.out.println(mTeam.get(i).displayPlayer());
        }
    }
    
    public void displayAllManagers(){
        for(int i=0;i<getSize();i++){
            System.out.println(mTeam.get(i).displayManager());
        }
    }
}