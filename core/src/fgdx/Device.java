package fgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class Device {
	public SpriteBatch batch;
	public Stage stage;
	public Screen currentScreen;
	public InputCorrector input;
	
	public Device(){
		batch = new SpriteBatch();
		stage = new Stage(new StretchViewport(960, 540));
		resetCam();
		input = new InputCorrector(stage);
	}
	
	public void setScreen(Screen s){
		resetCam();
		if(currentScreen!=null){
			currentScreen.dispose();
		}
		currentScreen = s;
	}
	
	public Vector2 getScreenDim(){
		return new Vector2(stage.getViewport().getWorldWidth(), stage.getViewport().getWorldHeight());
	}
	
	public void resetCam(){
		stage.getCamera().position.x=0;
		stage.getCamera().position.y=0;
		stage.getCamera().update();
	}
	
	public void render(){
		if(currentScreen!=null){
			currentScreen.render();
		}
	}
	
	public void startDraw(){
		batch.setProjectionMatrix(stage.getCamera().combined);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
	}
	
	public void draw(Drawable d){
		d.draw(batch);
	}
	
	public void endDraw(){
		batch.end();
	}
}
