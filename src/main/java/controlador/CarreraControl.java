/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import servicio.CarreraServiceImpl;
import modelo.Carrera;
import servicio.UniversidadServiceImpl;

/**
 *
 * @author Mauricio Ortiz
 */
public class CarreraControl {

    private CarreraServiceImpl carreraServiceImpl = new CarreraServiceImpl();
    private UniversidadServiceImpl universidadServiceImpl = new UniversidadServiceImpl();

    public String crear(String[] data) {
        var retorno = "No se puede crear Universidad:";

        var nombre = data[0];
        var directorCarrera = data[1];
        var costoCiclo = Double.valueOf(data[2]).doubleValue();;
        var numCiclos = Integer.valueOf(data[3]).intValue();
        var year = Integer.valueOf(data[4]).intValue();
        var mes = Integer.valueOf(data[5]).intValue();
        var dia = Integer.valueOf(data[6]).intValue();
        var universidad = this.universidadServiceImpl.UniversidadCodigo(Integer.valueOf(data[7]));
        var codigo = Integer.valueOf(data[8]).intValue();

        if (costoCiclo < 0) {
            retorno += " El costo del ciclo no es valido ";
        } else {
            if (numCiclos < 2 || numCiclos > 15) {
                retorno += " El numero de ciclos es incorrecto ";
            } else {
                if (year > LocalDate.now().getYear()) {
                    retorno += " El año no es valido ";
                } else {
                    if (mes < 1 || mes > 12) {
                        retorno += " El mes no es valido ";
                    } else {
                        if (dia < 0 || dia > 31) {
                            retorno += " El dia no es valido ";
                        } else {
                            if (universidad == null) {
                                retorno += " Universidad fuera del registro ";
                            } else {
                                var carrera = new Carrera(nombre, directorCarrera, costoCiclo, numCiclos, LocalDate.of(year, mes, dia), universidad, codigo);
                                this.carreraServiceImpl.crear(carrera);
                                retorno = "Creado Satisfactoriamente ";

                            }

                        }

                    }

                }

            }
        }

        return retorno;
    }

    public String modificar(String[] data) {
        var retorno = "No se puede crear Universidad:";

        var nombre = data[0];
        var directorCarrera = data[1];
        var costoCiclo = Double.valueOf(data[2]).doubleValue();;
        var numCiclos = Integer.valueOf(data[3]).intValue();
        var year = Integer.valueOf(data[4]).intValue();
        var mes = Integer.valueOf(data[5]).intValue();
        var dia = Integer.valueOf(data[6]).intValue();
        var universidad = this.universidadServiceImpl.UniversidadCodigo(Integer.valueOf(data[7]));
        var codigo = Integer.valueOf(data[8]).intValue();
        var modificar = Integer.valueOf(data[9]).intValue();

        if (costoCiclo < 0) {
            retorno += " El costo del ciclo no es valido ";
        } else {
            if (numCiclos < 2 || numCiclos > 15) {
                retorno += " El numero de ciclos es incorrecto ";
            } else {
                if (year > LocalDate.now().getYear()) {
                    retorno += " El año no es valido ";
                } else {
                    if (mes < 1 || mes > 12) {
                        retorno += " El mes no es valido ";
                    } else {
                        if (dia < 0 || dia > 31) {
                            retorno += " El dia no es valido ";
                        } else {
                            if (universidad == null) {
                                retorno += " Universidad fuera del registro ";
                            } else {
                                var carrera = new Carrera(nombre, directorCarrera, costoCiclo, numCiclos, LocalDate.of(year, mes, dia), universidad, codigo);
                                this.carreraServiceImpl.modificar(carrera, modificar);
                                retorno = "Modificado Satisfactoriamente ";

                            }

                        }

                    }

                }

            }
        }

        return retorno;

    }

    public void eliminar(String codigos) {
        var codigo = Integer.valueOf(codigos).intValue();
        this.carreraServiceImpl.eliminar(codigo);

    }

    public List<Carrera> listar() {
        return this.carreraServiceImpl.listar();
    }

}
