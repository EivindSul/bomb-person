package inf112.bomberperson.model.tiles;

import com.badlogic.gdx.math.Vector2;

import inf112.bomberperson.model.map.Map;

public abstract class TileObject {

    private Vector2 position;
    private int textureID;

    public TileObject(Vector2 position){
        this.position = position;
        this.textureID = 545;

    }

    public float getX(){
        return this.position.x;
    }

    public float getY(){
        return this.position.y;
    }

    public void setX(float x){
        this.position.x = x;
    }

    public void setY(float y){
        this.position.y = y;
    }

    public Vector2 getPosition(){
        return this.position;
    }

    public int getCol(){
        return Math.round(position.x / Map.TILE_SIZE);
    }
    public int getRow(){
        return Math.round(position.y / Map.TILE_SIZE);
    }

    public int getTexture(){
        return this.textureID;
    }

    public void setTexture(int texture){
        this.textureID = texture;
    }

}
