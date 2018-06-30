package dao;

import java.util.List;

import entidad.EmpleadoBean;

public interface EmpleadoDAO {

	public abstract List<EmpleadoBean> consultaEmpleadoPorCargo(String filtro) throws Exception;
	public abstract List<EmpleadoBean> listaEmpleado();
	public abstract int eliminaEmpleado(int idEmpleado) throws Exception;
	public abstract int insertaEmpleado(EmpleadoBean obj) throws Exception;
	public abstract int actualizaEmpleado(EmpleadoBean obj) throws Exception;	
}
