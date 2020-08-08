
package com.br.unifafibe.controleestoque.model;
import java.util.Scanner;

public class Bd {
    private static final Produto[] prod = new Produto[100];
    private static int pos = 0;
    
    public static boolean cadastrar(Produto p){
        if (pos == prod.length-1){
            return false;
        }
        
        prod[pos] = p;
        prod[pos].setVisivel(true);
        pos++;
        
        return true;
    }
    
    public static Produto[] todosprodutos(){
        Produto[] produto = new Produto[pos];
        for(int i = 0; i < prod.length; i++){
            if(Bd.prod[i] == null) break;
            produto[i] = Bd.prod[i];
        }
        return produto;
    }
    
    public static Produto[] listar(){
        Produto[] produto = new Produto[pos];
        for (int i = 0; i < prod.length; i++){
            if(Bd.prod[i].isVisivel()){
                produto[i] = Bd.prod[i];
            }            
        }
        return produto;
    }
    
    public static boolean excluir(int cod){        
            for (int i = 0; i < prod.length; i++){
                if (prod[i].getCod() == cod){
                    Bd.prod[i].setVisivel(false);
                    return true;
                }             
            }
            return false;              
        
    }
    
    public static boolean procurar(int posi){
        for (int i = 0; i < prod.length; i++){
            if (prod[i].getCod() == posi && prod[i].isVisivel() == true){
                return true;
            }             
        }
        return false;
    }
    
    public static boolean buscar(int cod){
        
        
        
            for (int i = 0; i < prod.length; i++){
                if(Bd.prod[i].getCod() == cod && Bd.prod[i].isVisivel()){                    
                    System.out.println(prod[i]);
                    return true;
                }
            }
        return false;        
    }
    
    public static boolean editar(int cod, Produto p){
        for (int i = 0; i < prod.length; i++){
            if (prod[i].getCod() == cod){
                prod[i] = p;
                prod[i].setVisivel(true);
                return true;
            }
            
        }       
        
        return false;
        
        }
        
    
}
