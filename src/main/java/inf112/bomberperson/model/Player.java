package inf112.bomberperson.model;


import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private Vector2 position;

    public Player(TiledMapTileLayer groundLayer) {
        setPosition(getRandomGrassTile(groundLayer));
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public boolean collideWithTile(Map.TileType tileType) {
        int tileX = (int) (position.x / Map.TILE_SIZE);
        int tileY = (int) (position.y / Map.TILE_SIZE);

        switch (tileType) {
            case GRASS:
                return false;
            case BRICK:
                if (Map.explodableWallLayer.getCell(tileX, tileY) != null) {
                    Map.explodableWallLayer.setCell(tileX, tileY, new TiledMapTileLayer.Cell());
                    return true;
                }
                return false;
            case WALL:
                if (Map.wallLayer.getCell(tileX, tileY) != null) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    private Vector2 getRandomGrassTile(TiledMapTileLayer groundLayer) {
        while (true) {
            int x = Map.random.nextInt(Map.MAP_WIDTH);
            int y = Map.random.nextInt(Map.MAP_HEIGHT);
            if (groundLayer.getCell(x, y).getTile().getId() == Map.GRASS_TILE_ID) {
                return new Vector2(x * Map.TILE_SIZE, y * Map.TILE_SIZE);
            }
        }
    }

    public void update(float deltaTime, Map map) {
        // Move the player according to its velocity
        position.add(velocity.cpy().scl(deltaTime));

        // Check for collisions with walls and bricks
        if (map.isCellBlocked(position.x, position.y)) {
            // Undo the move
            position.sub(velocity.cpy().scl(deltaTime));
            // Stop the player from moving in the blocked direction
            velocity.set(0, 0);
        }
    }
}
