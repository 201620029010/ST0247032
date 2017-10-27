/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;


/**
 * Clase Pareja que almacena la longitud y latitud del nodo
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Posicion
{
    public float posX;
    public float posY;
    public Posicion(float y,float x) {posX = x;  posY = y;}

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }
}

