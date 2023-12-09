package main.GUIs;

// Libreria que creé que tiene varias funciones útiles para trabajar con las posiciones y tamaños variables de ventana

import java.awt.*;

public class UtilsFrame {
    public static void posicionPorcentual(Container frame, double posX, double posY) {
        Container parent = frame.getParent();
        frame.setLocation((int) (parent.getWidth() * posX), (int) (parent.getHeight() * posY));
    }
    public static void posicionPorcentual(Container frame, Container parent, double posX, double posY) {
        frame.setLocation((int) (parent.getWidth() * posX), (int) (parent.getHeight() * posY));
    }
    public static void tamanoPorcentual(Container frame, double sizeX, double sizeY) {
        Container parent = frame.getParent();
        frame.setSize((int) (parent.getWidth() * sizeX), (int) (parent.getHeight() * sizeY));
    }
    public static void tamanoPorcentual(Container frame, Container parent, double sizeX, double sizeY) {
        frame.setSize((int) (parent.getWidth() * sizeX), (int) (parent.getHeight() * sizeY));
    }

    public static void boundsPorcentual(Container frame, double posX, double posY, double sizeX, double sizeY) {
        UtilsFrame.tamanoPorcentual(frame, sizeX, sizeY);
        UtilsFrame.posicionPorcentual(frame, posX, posY);
    }

    public static void boundsPorcentual(Container frame, Container parent, double posX, double posY, double sizeX, double sizeY) {
        UtilsFrame.tamanoPorcentual(frame, parent, sizeX, sizeY);
        UtilsFrame.posicionPorcentual(frame, parent, posX, posY);
    }

    public static void moverConCentroAnchorPoint(Container frame, double anchorPointX, double anchorPointY, int posX, int posY) {
        frame.setLocation((int)(posX - anchorPointX*frame.getWidth()), (int)(posY - anchorPointY*frame.getHeight()));
    }

    public static void moverConCentro(Container frame, int posX, int posY) {
        moverConCentroAnchorPoint(frame, 0.5, 0.5, posX, posY);
    }

    public static void moverConCentroPorcentualAnchorPoint(Container frame, double anchorPointX, double anchorPointY, double posX, double posY) {
        frame.setLocation((int)(frame.getParent().getWidth()*posX - anchorPointX*frame.getWidth()), (int)(frame.getParent().getHeight()*posY - anchorPointY*frame.getHeight()));
    }

    public static void moverConCentroPorcentual(Container frame, double posX, double posY) {
        moverConCentroPorcentualAnchorPoint(frame, 0.5, 0.5, posX, posY);
    }


}
