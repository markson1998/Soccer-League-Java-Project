package application.entities.controllers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import application.entities.Player;
import java.util.List;
import javax.persistence.TypedQuery;

public class PlayerController {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public PlayerController(){
        emf = Persistence.createEntityManagerFactory("SoccerLeagueFXPU");
        em = emf.createEntityManager();
    }
    
    public List<Player> getPlayerData(){
        TypedQuery<Player> qry = em.createQuery("select s from Player s", Player.class);
        return qry.getResultList();
    }
    
    public boolean insertPlayerData(Player player){
        try{
            em.getTransaction().begin();
            em.persist(player);
            System.out.println(player.toString());
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
        
    }
    
    public boolean updatePlayerData(Player player, int player_id){
        try{
            em.getTransaction().begin();
            em.find(Player.class, player_id);
            em.merge(player);
            System.out.println(player.toString());
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
        
    }
    
    public boolean removePlayerData(int player_id){
        try{
            em.getTransaction().begin();
            Player p = em.find(Player.class, player_id);
            em.remove(p);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
