
package com.br.unifafibe.controleestoque.view;

import com.br.unifafibe.controleestoque.model.Bd;
import com.br.unifafibe.controleestoque.model.Produto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        /*Produto p = new Produto(0, "0", "0", "0", 0);
        System.out.println(p);
        System.exit(0);*/
        Scanner sc = new Scanner(System.in);
        int escol = -1;
        
        System.out.println("----- CONTROLE DE ESTOQUE -----");
        System.out.println("Escolha a opção desejada:");
        while(escol != 0){
            System.out.println("1 - Cadastrar produtos");
            System.out.println("2 - Editar produtos");
            System.out.println("3 - Excluir produtos");
            System.out.println("4 - Busca de produtos");
            System.out.println("5 - Listagem de produtos");
            System.out.println("0 - Sair");
            
            escol = sc.nextInt();
            
            switch(escol){
                case 1:
                    cadastrar(sc);
                    break;
                case 2:
                    editar(sc);
                    break;
                case 3:
                    excluir(sc);
                    break;
                case 4:
                    busca(sc);
                    break;
                case 5:
                    listar();
                    break;
            }
        }
        System.out.println("-----------------");
    }
    
    
    private static void cadastrar(Scanner sc){
            System.out.println("----- CADASTRAR -----");
            System.out.println("Digite o código");
            int cod = sc.nextInt();
            System.out.println("");
            System.out.println("Digite o nome");
            String nome = sc.next();
            System.out.println("");
            System.out.println("Digite o tipo");
            String tipo = sc.next();
            System.out.println("");
            System.out.println("Digite o fornecedor");
            String fornecedor = sc.next();
            System.out.println("");
            System.out.println("Digite a quantidade");
            int quant = sc.nextInt();
            Produto p = new Produto(cod, nome, tipo, fornecedor, quant);
            
            if(Bd.cadastrar(p)){
                System.out.println("Cadastrado com sucesso");
            }
            else{
                System.out.println("Erro ao cadastrar");
            }
            System.out.println("-----------------");
    }
    
    private static void editar(Scanner sc){
        System.out.println("----- EDITAR -----");
        System.out.println("Qual o código do produto que deseja editar?");
        int i = sc.nextInt();
        if(Bd.procurar(i) == true){
            System.out.println("Digite o novo código");
            int cod = sc.nextInt();
            System.out.println("Digite o novo nome");
            String nome = sc.next();
            System.out.println("Digite o novo tipo");
            String tipo = sc.next();
            System.out.println("Digite o novo fornecedor");
            String fornecedor = sc.next();
            System.out.println("Digite a nova quantidade");
            int quant = sc.nextInt();
            Produto p = new Produto(cod, nome, tipo, fornecedor, quant);
            if(Bd.editar(i, p)){
                System.out.println("Produto editado");
            }
            else{
                System.out.println("Erro na edição");
            }
            
        }
        else{
            System.out.println("Produto não achado");
        }
        
        System.out.println("-----------------");
    }
    
    private static void excluir(Scanner sc){
        System.out.println("----- EXCLUIR -----");
        System.out.println("Qual o código do produto que deseja excluir?");
        int cod = sc.nextInt();
        if(Bd.procurar(cod)){
            if(Bd.excluir(cod)){
                System.out.println("Excluido com sucesso");
            }
                       
        }
        else{
            System.out.println("Produto não encontrado");
        }
        
        System.out.println("-----------------");
        
    }
    
    private static void busca(Scanner sc){
        System.out.println("----- BUSCAR -----");
        System.out.println("Qual o código do produto que deseja buscar?");
        int cod = sc.nextInt();
        if(Bd.procurar(cod)){
            Bd.buscar(cod);                
        }
        else{
        System.out.println("Produto não encontrado");
        }
        System.out.println("-----------------");
    }
    
    private static void listar(){
        System.out.println("----- LISTAR -----");
        Produto[] prod = Bd.todosprodutos();
        for(int i=0; i<prod.length; i++){
            if(prod[i].isVisivel()){
                System.out.println(prod[i]);
            }
        }
        System.out.println("-----------------");
    }
}
