package modele;

import javax.swing.JOptionPane;

public class Operation {

    public static Matrice C;
// Addition 
    public static Matrice addition(Matrice A, Matrice B) {

        C = new Matrice(B.getligne(), B.getcolonne());

        Integer S = 0;

        if ((A.getligne() == B.getligne())
                && (A.getcolonne() == B.getcolonne())) {
            for (int i = 0; i < A.getligne(); i++) {
                for (int j = 0; j < A.getcolonne(); j++) {
                    S = A.getValeur(i, j) + B.getValeur(i, j);
                    C.setValeur(i, j, S);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "L'addition est impossible pour ces deux matrices qui ne sont pas de mêmes tailles ", "ERREUR", JOptionPane.WARNING_MESSAGE);
        }
        return C;
    }

// Multiplication
// c(i,j)=som(k=1:n) a(i,k)*b(k,j).
    public static Matrice multiplication(Matrice A, Matrice B)
    {Matrice C= new Matrice(A.getligne(), B.getcolonne());
        Integer S = 0;

        
        if (A.getcolonne() == B.getligne()) {
            for (int i = 0; i < A.getligne(); i++) {
                for (int j = 0; j < B.getcolonne(); j++) {

                    for (int k = 0; k < B.getligne(); k++) {
                        S += A.getValeur(i, k) * B.getValeur(k, j);
                        C.setValeur(i, j, S);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Le produit des deux matrices est impossible : leurs dimensions sont incompatibles pour le produit", "ERREUR", JOptionPane.WARNING_MESSAGE);
        }
        return C;
    }
// deretminant
    public static float determinant(Matrice A) {
      // deter variable qui contient resultat 
         float deter = 1;
        if(A.getligne()==A.getcolonne()){
          
        float[][] A1 = new float[A.getligne()][A.getcolonne()] ;
        
 
       

        for (int i = 0; i < A.getligne(); i++) {
            for (int j = 0; j < A.getcolonne(); j++) {
                A1[i][j] = A.getValeur(i, j);
            }
        }

        for (int k = 0; k < (A.getligne() - 1); k++) {
            for (int i = (k + 1); i < A.getligne(); i++) {
                for (int j = (k + 1); j < A.getligne(); j++) {
                    A1[i][j] -= A1[i][k] * A1[k][j] / A1[k][k];
                }
            }
        }
        for (int i = 0; i < A.getligne(); i++) {
            deter *= A1[i][i];
        }
       

        }
        else{
         JOptionPane.showMessageDialog(null, " Matrice non carée, le déterminant n'est pas définit", "ERREUR", JOptionPane.WARNING_MESSAGE);
        }
      return deter;
    }
//Important : les operation en String pour qui'il donne une zonne vide dans le resultat finale si on rencontrer un exeprtion 
    public static String inverse(Matrice A) {
        // A est une matrice carre [ligne=colonne]
         String CAD = "";
        if(determinant( A)!=0 && (A.getligne()==A.getcolonne())){
        Integer L = A.getligne();
        float A1[][] = new float[L][L];
        float B[][] = new float[L][L];
        float C[][] = new float[L][L];


        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                A1[i][j] = A.getValeur(i, j);
                C[i][j] = 0;
                if (i == j) {
                    B[i][j] = 1;
                } else {
                    B[i][j] = 0;
                }
            }
        }
        for (int k = 0; k < (L - 1); k++) {
            for (int i = (k + 1); i < L; i++) {
                for (int s = 0; s < L; s++) {
                    B[i][s] -= A1[i][k] * B[k][s] / A1[k][k];
                }
                for (int j = (k + 1); j < L; j++) {
                    A1[i][j] -= A1[i][k] * A1[k][j] / A1[k][k];
                }
            }
        }

        for (int s = 0; s < L; s++) {
            C[L - 1][s] = B[L - 1][s] / A1[L - 1][L - 1];
            for (int i = (L - 2); i >= 0; i--) {
                C[i][s] = B[i][s] / A1[i][i];
                for (int k = (L - 1); k > i; k--) {
                    C[i][s] -= A1[i][k] * C[k][s] / A1[i][i];
                }
            }
        }
       
        for (int i = 0; i <= (L - 1); i++) {
            for (int j = 0; j <= (L - 1); j++) {

                CAD = CAD + C[i][j] + "\t";
            }
            CAD = CAD + "\n";

        }
        }
        else{
          JOptionPane.showMessageDialog(null, " La matrice n'est pas inversible", "ERREUR", JOptionPane.WARNING_MESSAGE);
            }
        return CAD;
    }
 //transposer
    public static String transposer(Matrice A) {
       // TL: transposer ligne
        //TC:transpose colonne
        int TL, TC;
        String CAD = "";

        TL = A.getligne();
        TC = A.getcolonne();

        for (int j = 0; j <= TC - 1; j++) {
            for (int i = 0; i <= TL - 1; i++) {

                CAD = CAD + A.getValeur(i, j) + "\t";
            }
            CAD = CAD + "\n";

        }
        return CAD;
    }
    //Trace
    public static float trace(Matrice A) {
        float t = 0;
        if(A.getcolonne()==A.getligne()){
        for (int i = 0; i < A.getligne(); i++) {
            t += A.getValeur(i, i);
        }}
        else{
        
         JOptionPane.showMessageDialog(null, "La matrice n'est pas carrée, la trace n'est pas définie ", "ERREUR", JOptionPane.WARNING_MESSAGE);
            }
        return t;
    }
    //triangle superieur
    public static String trianguleSuperieur(Matrice A) {
        int l, c;
        String CAD = "";

        l = A.getligne();
        c = A.getcolonne();

        if (l == c) {
            for (int i = 0; i <= l - 1; i++) {
                for (int j = 0; j <= c - 1; j++) {
                    if (i <= j) {
                        CAD = CAD + A.getValeur(i, j) + "\t";
                    } else {
                        CAD = CAD + 0 + "\t";
                    }
                }
                CAD = CAD + "\n";
            }

        } else {
            JOptionPane.showMessageDialog(null, " Matrice non carée ", "ERREUR", JOptionPane.WARNING_MESSAGE);

        }
        return CAD;

    }
    //triangle inferieur 
    public static String trianguleInferieur(Matrice A) {
        int l, c;
        String CAD = "";

        l = A.getligne();
        c = A.getcolonne();
        if (l == c) {
            for (int i = 0; i <= l - 1; i++) {
                for (int j = 0; j <= c - 1; j++) {
                    if (i >= j) {
                        CAD = CAD + A.getValeur(i, j) + "\t";
                    } else {
                        CAD = CAD + 0 + "\t";
                    }
                }
                CAD = CAD + "\n";
            }

        } else {
            JOptionPane.showMessageDialog(null, " Matrice non carée", "ERREUR", JOptionPane.WARNING_MESSAGE);
        }
        return CAD;
}
//Diagonale
    public static String diagonale(Matrice A) {
        int l, c, num;
        String CAD = "";
        l = A.getligne();
        c = A.getcolonne();
        if (l == c) {
            for (int i = 0; i <= l - 1; i++) {
                for (int j = 0; j <= c - 1; j++) {
                    if (i == j) {
                        CAD = CAD + A.getValeur(i, j) + "\t";
                    } else {
                        CAD = CAD + 0 + "\t";
                    }
                }
                CAD = CAD + "\n";
            }

        } else {
            JOptionPane.showMessageDialog(null, " Matrice non carée", "ERREUR", JOptionPane.WARNING_MESSAGE);
        }
        return CAD;
    }

 
}
