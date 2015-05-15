package modele;

public class Matrice {

   //tableau pour stockee les valeur
    private Integer M[][];
    private Integer L;
    private Integer C;

    
    public Matrice() { 
        //pour intialiser les valeurs 
        M = new Integer[3][3];
         this.setligne(3);
        this.setcolonne(3);
   
    }

    public Matrice(Integer L, Integer C) {
        M = new Integer[L][C];
        this.setligne(L);
        this.setcolonne(C);
    }
	
    public Integer[][] getM() {
        return M;
    }

    //setter
    public void setM(Integer[][] M) {
        this.M = M;
    }
//changer la valeur 
    public void setValeur(Integer L, Integer C, Integer x) {
        M[L][C] = x;
    }
//avoir la valeur  d un element su matrice 
    public Integer getValeur(Integer L, Integer C) {
        return M[L][C];
    }

    public Integer getcolonne() {
        return C;
    }

    public void setcolonne(Integer C) {
        this.C = C;
    }

    public Integer getligne() {
        return L;
    }

    public void setligne(Integer L) {
        this.L = L;
    }
    public static void main(String args[]){
    
    
    Matrice m=new Matrice();
    System.out.println(m.getligne());
       System.out.println(m.getcolonne());
    
    }
    
}