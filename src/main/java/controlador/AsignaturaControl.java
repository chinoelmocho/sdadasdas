/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.util.List;
import modelo.Asignatura;
import modelo.Carrera;

import servicio.AsignaturaServiceImpl;
import servicio.CarreraServiceImpl;

/**
 *
 * @author David
 */
public class AsignaturaControl {

    private AsignaturaServiceImpl asignaturaServiceImpl = new AsignaturaServiceImpl();
    private CarreraServiceImpl carreraServiceImpl = new CarreraServiceImpl();

    public AsignaturaControl() {
        this.asignaturaServiceImpl = new AsignaturaServiceImpl();
    }

    public String crear(String[] data) {
       
            var retorno = "No se puede crear la Asignatura:";
            var nombre = data[0];
            var docente = data[1];
            var numHoras = Integer.valueOf(data[2]).intValue();
            var horasSemanales = Integer.valueOf(data[3]).intValue();
            var costoHoras = Double.valueOf(data[4]).doubleValue();
            var cuposDisponibles = Integer.valueOf(data[5]).intValue();
            var carrera = this.carreraServiceImpl.CarreraCodigo(Integer.valueOf(data[6]));
            var modalidad = data[7];
            var codigo = Integer.valueOf(data[8]).intValue();
           
        
            if (numHoras < 0) {
                retorno += " El numero de Horas no son validos ";
            } else {
                if (horasSemanales <= 0 || horasSemanales > 24) {
                    retorno += " El numero de horas semanales es incorrecto ";
                } else {
                    if (costoHoras < 0) {
                        retorno += " El costo por horas no es valido";
                    } else {
                        if (cuposDisponibles < 0) {
                            retorno += " Los cupos disponibles no validos ";
                        } else {
                            if (carrera == null) {
                                retorno += " Universidad fuera del registro ";
                            } else {
                                var asignatura = new Asignatura(nombre, docente, numHoras, horasSemanales, costoHoras, cuposDisponibles, carrera, modalidad, codigo);
                                this.asignaturaServiceImpl.crear(asignatura);
                                retorno = "Creado Satisfactoriamente ";

                            }

                        }

                    }

                }

            }

            return retorno;
    
        
  }

    public String modificar(String[] data) {

        var retorno = "No se puede crear la Asignatura:";
        var nombre = data[0];
        var docente = data[1];
        var numHoras = Integer.valueOf(data[2]).intValue();
        var horasSemanales = Integer.valueOf(data[3]).intValue();
        var costoHoras = Double.valueOf(data[4]).doubleValue();
        var cuposDisponibles = Integer.valueOf(data[5]).intValue();
        var carrera = this.carreraServiceImpl.CarreraCodigo(Integer.valueOf(data[6]));
        var modalidad = data[7];
        var codigo = Integer.valueOf(data[8]).intValue();
        var modificar = Integer.valueOf(data[9]).intValue();

        if (numHoras < 0) {
            retorno += " El numero de Horas no son validos ";
        } else {
            if (horasSemanales <= 0 || horasSemanales > 24) {
                retorno += " El numero de horas semanales es incorrecto ";
            } else {
                if (costoHoras < 0) {
                    retorno += " El costo por horas no es valido";
                } else {
                    if (cuposDisponibles < 0) {
                        retorno += " Los cupos disponibles no validos ";
                    } else {
                        if (carrera == null) {
                            retorno += " Universidad fuera del registro ";
                        } else {
                            var asignatura = new Asignatura(nombre, docente, numHoras, horasSemanales, costoHoras, cuposDisponibles, carrera, modalidad, codigo);
                            this.asignaturaServiceImpl.modificar(asignatura, modificar);
                            retorno = "Modificado Satisfactoriamente ";

                        }

                    }

                }

            }

        }

        return retorno;

    }

    public void eliminar(String codigos) {
        var codigo = Integer.valueOf(codigos).intValue();
        this.asignaturaServiceImpl.eliminar(codigo);

    }

    public List<Asignatura> listar() {
        return this.asignaturaServiceImpl.listar();

    }
}
