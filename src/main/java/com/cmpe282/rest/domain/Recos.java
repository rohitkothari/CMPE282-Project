package com.cmpe282.rest.domain;

public class Recos {
	private int countyFIPS;
	private float ageUnder19;
	private float age1964;
	private float age6584;
	private float ageOver85;
	
	private float white;
	private float black;
	private float hispanic;
	private float other;
	
	private int noHSDiploma;
	private int unemployed;
	
	private float noExercise;
	private float fruits;
	private float smoker;
	 
	private int uninsured;

	public int getCountyFIPS() {
		return countyFIPS;
	}

	public void setCountyFIPS(int countyFIPS) {
		this.countyFIPS = countyFIPS;
	}

	public float getAgeUnder19() {
		return ageUnder19;
	}

	public void setAgeUnder19(float ageUnder19) {
		this.ageUnder19 = ageUnder19;
	}

	public float getAge1964() {
		return age1964;
	}

	public void setAge1964(float age1964) {
		this.age1964 = age1964;
	}

	public float getAge6584() {
		return age6584;
	}

	public void setAge6584(float age6584) {
		this.age6584 = age6584;
	}

	public float getAgeOver85() {
		return ageOver85;
	}

	public void setAgeOver85(float ageOver85) {
		this.ageOver85 = ageOver85;
	}

	public float getWhite() {
		return white;
	}

	public void setWhite(float white) {
		this.white = white;
	}

	public float getBlack() {
		return black;
	}

	public void setBlack(float black) {
		this.black = black;
	}

	public float getHispanic() {
		return hispanic;
	}

	public void setHispanic(float hispanic) {
		this.hispanic = hispanic;
	}

	public float getOther() {
		return other;
	}

	public void setOther(float other) {
		this.other = other;
	}

	public int getNoHSDiploma() {
		return noHSDiploma;
	}

	public void setNoHSDiploma(int noHSDiploma) {
		this.noHSDiploma = noHSDiploma;
	}

	public int getUnemployed() {
		return unemployed;
	}

	public void setUnemployed(int unemployed) {
		this.unemployed = unemployed;
	}

	public float getNoExercise() {
		return noExercise;
	}

	public void setNoExercise(float noExercise) {
		this.noExercise = noExercise;
	}

	public float getFruits() {
		return fruits;
	}

	public void setFruits(float fruits) {
		this.fruits = fruits;
	}

	public float getSmoker() {
		return smoker;
	}

	public void setSmoker(float smoker) {
		this.smoker = smoker;
	}

	public int getUninsured() {
		return uninsured;
	}

	public void setUninsured(int uninsured) {
		this.uninsured = uninsured;
	}
}
