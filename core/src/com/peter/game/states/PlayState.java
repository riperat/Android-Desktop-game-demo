package com.peter.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;

/**
 * Created by Pepi on 11/26/2016.
 */

public class PlayState extends State {
    private Texture hero;
    private Texture background;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        this.background = new Texture("backgroundMenu2d.jpg");
        this.hero = new Texture("guyWithGun.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            gsm.set(new MenuState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        this.handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(this.background, 0, 0);
        sb.draw(this.hero, 20, 40);
        sb.end();
    }

    @Override
    public void dispose() {
        this.hero.dispose();
        this.background.dispose();
    }
}
