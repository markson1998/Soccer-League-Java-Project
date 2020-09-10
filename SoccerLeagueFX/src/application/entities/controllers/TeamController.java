package application.entities.controllers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import application.entities.Team;
import java.util.List;
import javax.persistence.TypedQuery;

public class TeamController {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public TeamController(){
        emf = Persistence.createEntityManagerFactory("SoccerLeagueFXPU");
        em = emf.createEntityManager();
    }
    
    public List<Team> getTeamData(){
        TypedQuery<Team> qry = em.createQuery("select s from Team s", Team.class);
        return qry.getResultList();
    }
    
    public boolean insertTeamData(Team team){
        try{
            em.getTransaction().begin();
            em.persist(team);
            System.out.println(team.toString());
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
        
    }
    
    public boolean updateTeamData(Team team, int team_id){
        try{
            em.getTransaction().begin();
              em.find(Team.class, team_id);
            em.merge(team);
            System.out.println(team.toString());
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
        
    }
    
    public boolean removeTeamData(int team_id){
        try{
            em.getTransaction().begin();
            Team t = em.find(Team.class, team_id);
            em.remove(t);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
