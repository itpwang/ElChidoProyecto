package mainMod;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;


public class GameState implements Serializable {

    private Boolean savedDebug;
    private Point[] savedListOfEnemyLoc;
    private Point[] savedListOfItemLoc;
    private Boolean savedIsInvincible;
    private Integer savedInvCounter;
    private Integer savedPlayerAmmo;
    private Boolean savedRadar;
    private Enemy[] savedEnemies;
    private ArrayList<Item> savedItems;
    private Player savedPlayer;
    private Grid savedBoard;

    // ORDER :
//                gameObjects.add(player);
//                gameObjects.add(board);
//                gameObjects.add(enemies);
//                gameObjects.add(listOfEnemyLoc);
//                gameObjects.add(listOfItemLoc);
//                gameObjects.add(isInvincible);
//                gameObjects.add(invCounter);
//                gameObjects.add(playerAmmo);
//                gameObjects.add(radar);
//                gameObjects.add(debug);

    public GameState(ArrayList gameObjects) {
        savedPlayer = (Player) gameObjects.get(0);
        savedBoard = (Grid) gameObjects.get(1);
        savedEnemies = (Enemy[]) gameObjects.get(2);
        savedItems = (ArrayList<Item>) gameObjects.get(3);
        savedIsInvincible = (Boolean) gameObjects.get(4);
        savedInvCounter = (Integer) gameObjects.get(5);
        savedPlayerAmmo = (Integer) gameObjects.get(6);
        savedRadar = (Boolean) gameObjects.get(7);
        savedDebug = (Boolean) gameObjects.get(8);


    }




    public Player getSavedPlayer() {
        return savedPlayer;
    }
//    public Point[] getSavedListOfEnemyLoc() {
//        return savedListOfEnemyLoc;
//    }
//
//    public Point[] getSavedListOfItemLoc() {
//        return savedListOfItemLoc;
//    }

    public Boolean getSavedDebug() {
        return savedDebug;
    }
    public Boolean getSavedIsInvincible() {
        return savedIsInvincible;
    }

    public Integer getSavedInvCounter() {
        return savedInvCounter;
    }

    public Integer getSavedPlayerAmmo() {
        return savedPlayerAmmo;
    }

    public Boolean getSavedRadar() {
        return savedRadar;
    }

    public Enemy[] getSavedEnemies() {
        return savedEnemies;
    }

    public Grid getSavedBoard() {
        return savedBoard;
    }
    public ArrayList<Item> getSavedItems() { return savedItems;}

}


