
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gargui3
 */
public class CrearTablero {
    
    private Integer[][] tablero;
    private Integer fili[]={0,1,1,1,0,-1,-1,-1};
    private Integer colu[]={1,1,0,-1,-1,-1,0,1};
    private int cont=0;
    private Integer f;
    private Integer c;
    private ArrayList<Integer> bX = new ArrayList<Integer>();
    private ArrayList<Integer> bY = new ArrayList<Integer>();
    private Integer Score=0;

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer Score) {
        this.Score = Score;
    }
    
    
    
    public void comprobarRepetidos(Integer fil, Integer col){
        for (int i = 0; i < bX.size(); i++) {
            if(bX.get(i)==f && bY.get(i)==c){
                f = (int)(Math.random()*(fil-1) + 1);
                c = (int)(Math.random()*(col-1) + 1);
                comprobarRepetidos(fil,col);
            }
        }
    }
    
    public CrearTablero(Integer fil, Integer col, Integer b){
        
        tablero = new Integer[fil+2][col+2];   
        
        for (int i = 1; i <= fil; i++) {
            for (int j = 1; j <= col; j++) {
                tablero[i][j]=0;
            }
        }
        
        bordeMatriz(fil,col);
        
        for (int i = 0; i < b; i++) {
            f = (int)(Math.random()*(fil-1) + 1);
            c = (int)(Math.random()*(col-1) + 1);
            
            if(bX.size()>0){
                comprobarRepetidos(fil,col);
            }
            
            bX.add(f);
            bY.add(c);

            tablero[f][c]=-1;
            for (int j = 0; j < 8; j++) {
                if(tablero[f+fili[j]][c+colu[j]]>=0){
                    tablero[f+fili[j]][c+colu[j]]+=1;
                }
            }
        }
        
    }
    public void bordeMatriz(Integer fil, Integer col){
        for(int i=0;i<=fil;i++){
            tablero[i][0]=-2;
            tablero[i][col+1]=-2;
        }
        for(int j=0;j<=col;j++){
            tablero[0][j]=-2;
            tablero[fil+1][j]=-2;
        }
    }
    
    public Integer valor(Integer i, Integer j){
        
        return tablero[i][j];
        
    }
    
    public Boolean comprobar(Integer i, Integer j){
        
        Boolean des=false;
        if(tablero[i][j]==-1){
            des=true;
        }
        return des;
    }
    
    public Boolean isCero(Integer i, Integer j){
        
        Boolean des=false;
        if(tablero[i][j]==0){
            des=true;
        }
        return des;
        
    }
    
    public Integer mas(){
        return cont++;
    }
    
    public Integer menos(){
        return cont--;
    }
    
    public void valorT(Integer i, Integer j, Integer valorT){
        
        tablero[i][j]=valorT;
        
    }
    
}
