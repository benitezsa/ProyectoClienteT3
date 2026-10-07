package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Categoria;
import util.MySqlDBConexion;

public class CategoriaModel {

	public List<Categoria> listaTodos() {

		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			// 1-Crear conexion
			conn = MySqlDBConexion.getConexion();

			// 2-Crear sentencia SQL
			String sql = "SELECT * FROM categoria";
			pstm = conn.prepareStatement(sql);
			System.out.println("SQL: " + pstm.toString());

			// 3-Ejecutar sentencia SQL
			rs = pstm.executeQuery();

			// 4-Recorrer resultados
			while (rs.next()) {

				Categoria a = new Categoria();
				a.setIdCategoria(rs.getInt("idCategoria"));
				a.setNombre(rs.getString("nombre"));
				lista.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
}