package src.utilities;
import java.lang.Math.*;

/**
 * Classe pour calculer les vecteurs
 */
public class UtilVector {
	/**
	 * Additionne v1 et v2
	 * @param v1 Vecteur 1
	 * @param v2 Vecteur 2
	 * @return vecteur
	 */
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
	
	/**
	 * Soustraction de v1 et v2
	 * @param v1 vecteur 1
	 * @param v2 vecteur 2
	 * @return vecteur (double [])
	 */
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
	
	/**
	 * Produit scalaire de v1 avec scal
	 * @param v1 vecteur 1
	 * @param scal produit scalaire
	 * @return vecteur (double [])
	 */
	protected static double[] scalMultVec(double[] v1, double scal) {
		double[] result = new double[v1.length];
		for (int i=0; i<v1.length; i++) {
			result[i] = v1[i]*scal;
		}
		return result;
	}
	
	/**
	 * Moyenne des vecteurs v1, v2 et v3
	 * @param v1 vecteur 1
	 * @param v2 vecteur 2
	 * @param v3 vecteur 3
	 * @return result
	 */
	protected static double [] meanVec(double[] v1, double[] v2, double[] v3) {
		if( (!sameLength(v1, v2)) || (!sameLength(v1,v3)) ) {
			return null;
		}
		double[] result = new double[v1.length];
		double currentMean = 0;
		for (int i=0; i<v1.length; i++) {
			currentMean = (v1[i]+v2[i]+v3[i])/3;
			result[i] = currentMean;
		}

		return result;
	}
	
	/**
	 * Norme du vecteur v1
	 * @param v1 vecteur 1
	 * @return norme
	 */
	protected static double normVec(double[] v1) {
		double result = 0;
		double inter = 0;
		for (int i=0; i<v1.length; i++) {
			inter = v1[i]*v1[i];
		}
		result = Math.sqrt(inter);
		return result;
	}	
	
	/**
	 * Distance euclidienne entre v1 et v2
	 * @param v1 vecteur 1
	 * @param v2 vecteur 2
	 * @return distance (double)
	 */
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
	
	/**
	 * Similarité cosinus entre v1 et v2
	 * @param v1 vecteur 1
	 * @param v2 vecteur 2
	 * @return result
	 */
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
		result = inter1 / (Math.sqrt(inter3) * Math.sqrt(inter2));
		return result;
	}

	/**
	 * Regarde si la longueur de V1 != longueur de V2
	 * @param v1 vecteur 1
	 * @param v2 vecteur 2
	 * @return boolean
	 */
	protected static boolean sameLength(double [] v1, double[] v2) {
		if(v1.length != v2.length) {
			System.out.println("Erreur, tailles incompatibles");
			return false;
		}
		return true;
	}
}