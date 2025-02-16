/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vezzolaluca.whisperinggods.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;
import vezzolaluca.whisperinggods.controller.AssetLoader;

/**
 *
 * @author lucav
 */
public class EntityList {
    private ArrayList<Entity> list;
            
    public EntityList(){
        list = new ArrayList();
        
        //SPAWNERS
        //pumpkin bush
        Sprite pumpkinBushSprite = new Sprite(AssetLoader.manager.get(AssetLoader.PUMPKIN_BUSH, Texture.class));
        float pupmkinBushRatio = pumpkinBushSprite.getHeight()/pumpkinBushSprite.getWidth();
        float pumpkinBushWidth = 10;
        pumpkinBushSprite.setSize(pumpkinBushWidth, pumpkinBushWidth*pupmkinBushRatio);
        SpawnerEntity pumpkinBushSpawner = new SpawnerEntity(pumpkinBushSprite, 100, "pumpkin bush");
        list.add(pumpkinBushSpawner);
    }
    
    public ArrayList<Entity> getAllEntities(){
        return list;
    }
    
    public ArrayList<Entity> getEntitiesByName(String name){
        ArrayList<Entity> resultList = new ArrayList<>();
        
        for(Entity entity : list){
            if(entity.getName().equalsIgnoreCase(name)){
                resultList.add(entity);
            }
        }
        
        return resultList;
    }
    
    public ArrayList getEntitiesByCategory(String category){
        ArrayList<Entity> resultList = new ArrayList<>();
        
        for(Entity entity : list){
            if(entity.getCategory().equalsIgnoreCase(category)){
                resultList.add(entity);
            }
        }
        
        return resultList;
    }
    
    public void doEntitiesActions(){
        ArrayList<SpawnerEntity> spawners = this.getEntitiesByCategory("spawner");
        for(SpawnerEntity sE : spawners){
            sE.decreaseRemainingSpawningTime();
            if(sE.canSpawnResource()){
                list.add(sE.spawnResource());
            }
        }
        
        for(Entity e: list){
            //DEBUGGING
            String debuggingOutputter = "";
            debuggingOutputter += e.toString() + " | REMAINING SPAWNING TIME: ";
            if(e.getClass() == SpawnerEntity.class){
                SpawnerEntity temp = (SpawnerEntity) e;
                debuggingOutputter += temp.getRemainingST();
            }
            System.out.println(debuggingOutputter);
        }
    }
    
    public void addToWorld(World world){
        for(Entity e: list){
            if(e.getClass() == PhisicalEntity.class){
                PhisicalEntity temp = (PhisicalEntity) e;
                temp.addToWorld(world);
                //temp.setAsDynamic();
            }
        }
    }
}
