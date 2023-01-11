/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import java.util.List;
import modelo.Carrera;
import modelo.Universidad;

/**
 *
 * @author Mauricio Ortiz
 */
public class CarreraServiceImpl implements CarreraService {

    public static List<Carrera> carreraList = new ArrayList<>();

    public CarreraServiceImpl() {

    }

    @Override
    public void crear(Carrera carrera) {
        this.carreraList.add(carrera);
    }

    @Override
    public List<Carrera> listar() {
        return this.carreraList;
    }

    public Carrera CarreraCodigo(int codigo) {
        Carrera retorno = null;
        for (var carrera : this.carreraList) {
            if (codigo == carrera.getCodigo()) {
                retorno = carrera;
                break;

            }
        }
        return retorno;
    }

    @Override
    public void modificar(Carrera carrera, int codigo) {
        var indice = -1;
        for (var universidades : this.carreraList) {
            indice++;
            if (codigo == universidades.getCodigo()) {
                this.carreraList.set(indice, carrera);

            }

        }
    }

    @Override
    public void eliminar(int codigo) {
        var indice = -1;
        for (var carreras : this.carreraList) {
            indice++;
            if (codigo == carreras.getCodigo()) {
                this.carreraList.remove(indice);

            }

        }

    }

}
