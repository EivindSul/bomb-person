package inf112.bomberperson.model;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Collision {
    Player player;
    String blockedKey = "blocked";

    public Collision(Player player){
        this.player =player;
    }
    public boolean isCellBlocked(float x, float y, TiledMapTileLayer layer){
        try {

            TiledMapTileLayer.Cell cell = layer.getCell((int) (x / layer.getTileWidth()), (int) (y / layer.getTileHeight()));
            System.out.println(cell.getTile().getId());
            return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey(blockedKey);
        }
        catch (Exception e){
            return false;

        }

    }
    public boolean collidesRight(TiledMapTileLayer layer){
        boolean collides = false;
        for(float step = 0; step < player.getHeight() ; step += layer.getTileHeight()/2){
            try {
                collides = isCellBlocked(player.getX() + player.getWidth(), player.getY() + step, layer);
                if (collides){
                    break;
                }
            }
            catch (Exception e){
                continue;
            }
        }

        return collides;
    }
    public boolean collidesLeft(TiledMapTileLayer layer){
        boolean collides = false;
        for(float step = 0; step < player.getHeight() ; step += layer.getTileHeight()/2){
            try {
                collides = isCellBlocked(player.getX() , player.getY() + step, layer);
                if (collides){
                    break;
                }
            }catch (Exception e){
                continue;
            }
        }

        return collides;
    }

    public boolean collidesTop(TiledMapTileLayer layer){
        boolean collides = false;
        for(float step = 0; step < player.getWidth() ; step += layer.getTileWidth()/2){
            try {
                collides = isCellBlocked(player.getX() + step, player.getY() + player.getHeight(), layer);
                if (collides){
                    break;
                }
            }
            catch (Exception e){
                continue;
            }
        }

        return collides;
    }
    public boolean collidesBottom(TiledMapTileLayer layer){
        boolean collides = false;

        for(float step = 0; step < player.getWidth(); step += layer.getTileWidth()/2){
            try {
                collides = isCellBlocked(player.getX() + step, player.getY(), layer);
                if (collides){
                    break;
                }
            } catch (Exception e){
                continue;
            }
        }

        return collides;
    }


}
