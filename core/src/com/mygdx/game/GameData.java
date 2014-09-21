package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class GameData {
	static Preferences state = Gdx.app.getPreferences("game");
	static String EXP_KEY = "exp";
	static String LEVEL_KEY = "level";
	private static int exp;
	private static int level;
	public static int getLevel(){
		return level;
	}
	
	public static int getExp(){
		return exp;
	}
	
	public static int getExpGoal(){
		int level = getLevel();
		return (level*2000);
	}
	
	public static float getExpPercent(){
		return ((float)getExp()/(float)getExpGoal());
	}
	public static void addExp(int amt){
		int expGoal = getExpGoal();
		exp+=amt;
		
		if(exp > expGoal){
			exp = exp%expGoal;
			level++;
		}
		
	}
	
	public static void init(){
		level = state.getInteger(LEVEL_KEY, 1);
		exp = state.getInteger(EXP_KEY, 0);
	}
	
	public static void save(){
		state.putInteger(EXP_KEY, getExp());
		state.putInteger(LEVEL_KEY, getLevel());
		state.flush();
	}
	
}
