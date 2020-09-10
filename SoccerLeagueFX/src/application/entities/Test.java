
package application.entities;



public class Test {
   
    public static void main(String args[]){
        
        // Creating Name class objects for players
        Name playerName1 = new Name("Jack", "", "William");
        Name playerName2 = new Name("Dillon", "", "Danis");
        Name playerName3 = new Name("Raul", "", "Smith");
        Name playerName4 = new Name("Ronaldo", "", "Souza");
        Name playerName5 = new Name("Thiago", "", "Ramos");
        Name playerName6 = new Name("Daniel", "", "Alvez");
        
        // Creating Name class objects for managers
        Name managerName1 = new Name("Roberto", "", "Mouro");
        Name managerName2 = new Name("Eto", "", "Smith");
        Name managerName3 = new Name("Cristiano", "", "Ronaldo");

        //Creating Plear Objects
//        Player player1 = new Player(playerName1, "1231", "abc1@gmail.com", 0, false, 0);
//        Player player2 = new Player(playerName2, "1232", "abc2@gmail.com", 0, false, 0);
//        Player player3 = new Player(playerName3, "1233", "abc3@gmail.com", 0, false, 0);
//        Player player4 = new Player(playerName4, "1234", "abc4@gmail.com", 0, false, 0);
//        Player player5 = new Player(playerName5, "1235", "abc5@gmail.com", 0, false, 0);
//        Player player6 = new Player(playerName6, "1236", "abc6@gmail.com", 0, false, 0);
//        
//        // Setting goalsInCurrentYear and defendedGoals if player is Golie
//        player1.setNumberOfGoalsInCurrentYear(10);
//        player2.setNumberOfGoalsInCurrentYear(25);
//        player3.setNumberOfGoalsInCurrentYear(15);
//        player4.setGoalie(true);
//        player4.setDefendedGoals(17);
//        player5.setGoalie(true);
//        player5.setDefendedGoals(20);
//        player6.setNumberOfGoalsInCurrentYear(21);
//       
//        // Creating manager objects
//        Manager manager1 = new Manager(managerName1, "4561", "abc11@gmail.com", "04-08-1997", 0, null);
//        Manager manager2 = new Manager(managerName2, "4562", "abc22@gmail.com", "04-08-1996", 0, null);
//        Manager manager3 = new Manager(managerName3, "4563", "abc33@gmail.com", "04-08-1995", 0, null);
//        
//        // Assigning rating to managers
//        manager1.setStarRating(8);
//        manager2.setStarRating(9);
//        manager3.setStarRating(10);
//
//        //Creating Team objects
//        Team team1 = new Team("Team-A", null, "");
//        Team team2 = new Team("Team-B", null, "");
//        Team team3 = new Team("Team-C", null, "");
//        
//        // Assigning manager to each team
//        team1.setManager(manager1);
//        team2.setManager(manager2);
//        team3.setManager(manager3);
//        
//        // Adding players and Jersey Color to team1
//        team1.addPlayer(player1);
//        team1.addPlayer(player2);
//        team1.setJerseyColor("Black");
//        
//        // Adding players and Jersey Color to team2
//        team2.addPlayer(player3);
//        team2.addPlayer(player4);
//        team2.setJerseyColor("Red");
//        
//        // Adding players and Jersey color to team3
//        team3.addPlayer(player5);
//        team3.addPlayer(player6);
//        team3.setJerseyColor("Yellow");
//        
//        
//        // Assigning team to each manager
//        manager1.setTeamToManage(team1);
//        manager2.setTeamToManage(team2);
//        manager3.setTeamToManage(team3);
//
//        // Creating League object and assigning teams.
//        League league = new League();
//        league.addTeam(team1);
//        league.addTeam(team2);
//        league.addTeam(team3);
//        
//        System.out.println("\n=========================All Teams============================");
//        league.displayAllTeams();
//        
//        System.out.println("\n=========================All Players==========================");
//        league.displayAllPlayers();
//        
//        System.out.println("\n=========================All Managers=========================");
//        league.displayAllManagers();
//        
//        System.out.println("\n=========================Team of a Particlar Manager==========");
////        System.out.println(manager2.getTeamToManage().displayTeam());
//        league.displayTeam(manager2);
//
//        
//        //Removing Team2 From league
//        league.removeTeam(team2);
//        
//        /*************************************************************************************
//         ********************* Output After Performing Remove Operations *********************
//         ************************************************************************************/
//        
//        System.out.println("\n\n\n*************************************************************************************\n" +
//                           "********************* Output After Performing Remove Operations *********************\n" +
//                           "*************************************************************************************\n");
//        
//        System.out.println("\n=========================All Teams============================");
//        league.displayAllTeams();
//        
//        System.out.println("\n=========================All Players==========================");
//        league.displayAllPlayers();
//        
//        System.out.println("\n=========================All Managers=========================");
//        league.displayAllManagers();
//        
//        System.out.println("\n=========================Team of a Particlar Manager==========");
////        System.out.println(manager2.getTeamToManage().displayTeam());
//        league.displayTeam(manager2);
    }
}
