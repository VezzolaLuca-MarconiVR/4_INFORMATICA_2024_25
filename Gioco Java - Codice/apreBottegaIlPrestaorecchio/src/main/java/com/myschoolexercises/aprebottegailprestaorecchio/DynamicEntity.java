package com.myschoolexercises.aprebottegailprestaorecchio;


/**
 *
 * @author lucav
 */

//A child class of Entity that can move or be moved.
abstract class DynamicEntity extends Entity {
    public void move(double posX, double posY){
        this.setPosX(posX);
        this.setPosY(posY);
    }
}
