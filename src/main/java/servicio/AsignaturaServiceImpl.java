/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import java.util.List;
import modelo.Asignatura;

/**
 *
 * @author David
 */
public class AsignaturaServiceImpl implements AsignaturaService {

    public List<Asignatura> asiganturaList;

    public AsignaturaServiceImpl() {
        this.asiganturaList = new ArrayList<>();
    }

    @Override
    public void crear(Asignatura asignatura) {
        this.asiganturaList.add(asignatura);
    }

    @Override
    public List<Asignatura> listar() {
        return this.asiganturaList;
    }

    @Override
    public void modificar(Asignatura asignatura, int codigo) {
        var indice = -1;
        for (var asignaturas : this.asiganturaList) {
            indice++;
            if (codigo == asignaturas.getCodigo()) {
                this.asiganturaList.set(indice, asignatura);

            }

        }
    }

    @Override
    public void eliminar(int codigo) {
        var indice = -1;
        for (var asignatura : this.asiganturaList) {
            indice++;
            if (codigo == asignatura.getCodigo()) {
                this.asiganturaList.remove(indice);

            }

        }
    }

}
