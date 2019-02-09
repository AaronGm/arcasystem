package interfaces;

import models.Proyecto;

public interface ProyectoDAO extends DAO<Integer, Proyecto> {
    int[] analisisSemanas(int semanas, String periodo);
}
