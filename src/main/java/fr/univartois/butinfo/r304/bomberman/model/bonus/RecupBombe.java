package fr.univartois.butinfo.r304.bomberman.model.bonus;

import fr.univartois.butinfo.r304.bomberman.model.BombermanGame;
import fr.univartois.butinfo.r304.bomberman.model.IMovable;
import fr.univartois.butinfo.r304.bomberman.model.bombs.Bombe;
import fr.univartois.butinfo.r304.bomberman.model.map.Wall;
import fr.univartois.butinfo.r304.bomberman.model.map.wallState.IWallState;
import fr.univartois.butinfo.r304.bomberman.model.movables.AbstractMovable;
import fr.univartois.butinfo.r304.bomberman.model.movables.player.Joueur;
import fr.univartois.butinfo.r304.bomberman.view.Sprite;
import fr.univartois.butinfo.r304.bomberman.view.SpriteStore;

public class RecupBombe extends AbstractMovable implements IWallState {

    private Bombe bombe;
    private SpriteStore spriteStore = SpriteStore.getInstance();


    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    public RecupBombe(BombermanGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        bombe = new Bombe(game, xPosition, yPosition, spriteStore.getSprite("bomb"), 4000);
    }

    @Override
    public void collidedWith(IMovable other) {
        if (other instanceof Joueur joueur) {
            joueur.addBomb(bombe);
            game.removeMovable(this);
        }
    }

    @Override
    public void explode() {
        //
    }

    @Override
    public void hitEnemy() {
        //
    }

    @Override
    public void degrade(Wall wall) {
        // Ne fais rien après la dégradation
    }
}
