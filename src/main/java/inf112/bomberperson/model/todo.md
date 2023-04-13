
# todo in this branch:

> add new layers for bombs, explosions, and powerups in Tiled, and in Map.java *DONE*
> change draw bomb method to add bombs to object layer (model:119) *DONE*
> change draw explosion method to add explosions to object layer (model:) *DONE*
> Change explosionalgorithm to check for blocked tiles in a different way(model:) *DONE*

> change explosion detection method to remove tilemap object of bomb *DONE*
> change explosion decay method to remove tilemap object of explosion *DONE*
> check collision between player and explosion *DONE*
> ExplosionAlgorithm in model was bad. Rewriting it, and renamed it to explodeBombs. *DONE*


# CURRENT ISSUES

> Make players unable to just paint the map with bomb sprites. *DONE*
> (Made explosion decay time shorter too, it feels much more natural now)
- Make powerups die from getting hit by an explosion *DOING
- Make tileobjects an enum, make an abstract class for them that has default texture and getter setters. *TODO*
- Animate bombs *TODO*

- check collision between player and powerups *TODO
- write javadoc *DOING