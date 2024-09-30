/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nodo_arbol;

/**
 *
 * @author admin
 */
import java.util.Scanner;

// Clase Nodo
class Nodo {
    int valor;
    Nodo izquierdo; 
    Nodo derecho;

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = null;
        derecho = null;
    }
}

// Clase ArbolBinario
class ArbolBinario {
    private Nodo raiz;
    private Scanner scanner;

    // Constructor
    public ArbolBinario() {
        raiz = null;
        scanner = new Scanner(System.in);
    }

    // Agregar nodo por teclado
    public void agregar() {
        System.out.print("Ingrese valor: ");
        int valor = scanner.nextInt();
        Nodo nuevoNodo = new Nodo(valor);
        if (raiz == null) {
            raiz = nuevoNodo;
        } else {
            agregarNodo(raiz, nuevoNodo);
        }
    }

    // Agregar nodo recursivo
    private void agregarNodo(Nodo actual, Nodo nuevoNodo) {
        if (nuevoNodo.valor < actual.valor) {
            if (actual.izquierdo == null) {
                actual.izquierdo = nuevoNodo;
            } else {
                agregarNodo(actual.izquierdo, nuevoNodo);
            }
        } else {
            if (actual.derecho == null) {
                actual.derecho = nuevoNodo;
            } else {
                agregarNodo(actual.derecho, nuevoNodo);
            }
        }
    }

    // Recorrer árbol en orden (inorder)
    public void recorrerEnOrden() {
        recorrerEnOrden(raiz);
    }

    // Recorrer árbol en orden (inorder) recursivo
    private void recorrerEnOrden(Nodo actual) {
        if (actual != null) {
            recorrerEnOrden(actual.izquierdo);
            System.out.print(actual.valor + " ");
            recorrerEnOrden(actual.derecho);
        }
    }

    // Buscar elemento
    public void buscar() {
        System.out.print("Ingrese valor a buscar: ");
        int valor = scanner.nextInt();
        boolean encontrado = buscarNodo(raiz, valor);
        System.out.println(encontrado ? "Encontrado" : "No encontrado");
    }

    // Buscar nodo recursivo
    private boolean buscarNodo(Nodo actual, int valor) {
        if (actual == null) {
            return false;
        }
        if (valor == actual.valor) {
            return true;
        }
        if (valor < actual.valor) {
            return buscarNodo(actual.izquierdo, valor);
        } else {
            return buscarNodo(actual.derecho, valor);
        }
    }

    // Menú principal
    public void menu() {
        int opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar nodo");
            System.out.println("2. Recorrer arbol");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Salir");
            System.out.print("Ingresar una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregar();
                    break;
                case 2:
                    recorrerEnOrden();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    System.out.println("Finalizado");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 4);
    }
}

// Clase Principal
public class Nodo_Arbol {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.menu();
    }
}
