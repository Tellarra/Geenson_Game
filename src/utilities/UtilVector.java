package src.utilities;
import java.lang.Math.*;

protected static class UtilVector {
	// Méthodes
	
	//Renvoit le vecteur résultant de l'addition de v1 et v2
	protected static double[] addVec(double[] v1, double[] v2) {
		if(!sameLength(v1, v2)) {
			return null;
		}
		double[] result = new double[v1.length];
		for (int i=0; i<v1.length; i++) {
			result[i] = v1[i]+v2[i];
		}
		return result;
	}
	
	//Renvoit le vecteur résultant de la soustraction de v1 et v2
	protected static double[] subVec(double[] v1, double[] v2) {
		if(!sameLength(v1, v2)) {
			return null;
		}
		double[] result = new double[v1.length];
		for (int i=0; i<v1.length; i++) {
			result[i] = v1[i]-v2[i];
		}
		return result;
	}
	
	//Renvoit le vecteur résultant du produit scalaire de v1 avec scal
	protected static double[] scalMultVec(double[] v1, double scal) {
		double[] result = new double[v1.length];
		for (int i=0; i<v1.length; i++) {
			result[i] = v1[i]*scal;
		}
		return result;
	}
	
	//Renvoit la moyenne du vecteur v1
	protected static double meanVec(double[] v1) {
		double result = 0;
		double sum = 0;
		for (int i=0; i<v1.length; i++) {
			sum = sum + v1[i];
		}
		result = sum / v1.length;
		return result;
	}
	
	//Renvoit la norme du vecteur v1
	protected static double normVec(double[] v1) {
		double result = 0;
		double inter = 0;
		for (int i=0; i<v1.length; i++) {
			inter = v1[i]*v1[i];
		}
		result = Math.sqrt(inter);
		return result;
	}	
	
	//Renvoit la distance euclidienne entre v1 et v2
	protected static double distVec(double[] v1, double[] v2) {
		if(!sameLength(v1, v2)) {
			return 0;
		}
		double sum = 0;
		for (int i=0; i<v1.length; i++) {
			sum = sum + (v1[i] - v2[i])*(v1[i] - v2[i]);
		}
		double result = Math.sqrt(sum);
		return result;
	}
	
	//renvoit la similarité cosinus entre v1 et v2
	protected static double cosVec(double[] v1, double[] v2) {
		if(!sameLength(v1, v2)) {
			return 0;
		}
		double result = 0;
		double inter1 = 0;
		double inter2 = 0;
		double inter3 = 0;
		for (int i=0; i<v1.length; i++) {
			inter1 = inter1 + v1[i]*v2[i];
			inter2 = inter2 + v1[i]*v1[i];
			inter3 = inter3 + v2[i]*v2[i];
		}
		result = inter1 / (Math.sqrt(inter1) * Math.sqrt(inter2));
		
		return result;
	}

	//Si la longueur de V1 != longueur de V2
	protected static boolean sameLength(double [] v1, double[] v2) {
		if(v1.length != v2.length) {
			System.out.println("Erreur, tailles incompatibles");
			return false;
		}
		return true;
	}
}