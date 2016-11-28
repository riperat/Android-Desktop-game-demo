package com.peter.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.peter.game.GameTest;


public class MenuState extends State {
    private Texture background;
    private Texture playButton;
    private Texture exitButton;
    private boolean isClicked;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        this.background = new Texture("backgroundMenu2d.jpg");
        this.playButton = new Texture("selectedPlayButton.png");
        this.exitButton = new Texture("exitButton.png");
        this.isClicked = false;
    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN) || Gdx.input.isKeyJustPressed(Input.Keys.UP)) {

            if (!isClicked) {
                this.exitButton = new Texture("selectedExitButton.png");
                this.playButton = new Texture("playButton.png");
                this.isClicked = true;

            } else {
                this.playButton = new Texture("selectedPlayButton.png");
                this.exitButton = new Texture("exitButton.png");
                this.isClicked = false;
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && this.isClicked) {
            Gdx.app.exit();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && !this.isClicked) {
            gsm.set(new PlayState(gsm));
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
        sb.draw(this.playButton, (GameTest.WIGHT / 2) - (playButton.getWidth() / 2) + 20
                , (GameTest.HEIGHT / 2) - (playButton.getHeight() / 2) + 50);
        sb.draw(this.exitButton, (GameTest.WIGHT / 2) - (playButton.getWidth() / 2) + 20
                , (GameTest.HEIGHT / 2) - (playButton.getHeight() / 2) - 100);
        sb.end();
    }

    @Override
    public void dispose() {
        this.background.dispose();
        this.playButton.dispose();
        this.exitButton.dispose();
    }

}
