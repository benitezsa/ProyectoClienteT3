package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Cliente;
import util.MySqlDBConexion;

public class ClienteModel {

	public int insertaCliente(Cliente obj) {

		int salida = -1;

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			// 1-Crear conexion
			conn = MySqlDBConexion.getConexion();

			// 2-Crear sentencia SQL
			String sql = "INSERT INTO cliente "
					+ "(nombre, dni, fechaRegistro, estado, idCategoria, apellido, telefono, correo, direccion) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getDni());
			pstm.setString(3, obj.getFechaRegistro());
			pstm.setInt(4, obj.getEstado());
			pstm.setInt(5, obj.getIdCategoria());
			pstm.setString(6, obj.getApellido());
			pstm.setString(7, obj.getTelefono());
			pstm.setString(8, obj.getCorreo());
			pstm.setString(9, obj.getDireccion());

			System.out.println("SQL: " + pstm.toString());

			// 3-Ejecutar sentencia SQL
			salida = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstm != null)
					pstm.close();

				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return salida;
	}

	public List<Cliente> listaTodos() {

		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			// 1-Crear conexion
			conn = MySqlDBConexion.getConexion();

			// 2-Crear sentencia SQL
			String sql = "SELECT * FROM cliente";

			pstm = conn.prepareStatement(sql);

			System.out.println("SQL: " + pstm.toString());

			// 3-Ejecutar sentencia SQL
			rs = pstm.executeQuery();

			// 4-Recorrer resultados
			while (rs.next()) {

				Cliente a = new Cliente();

				a.setIdCliente(rs.getInt("idCliente"));
				a.setNombre(rs.getString("nombre"));
				a.setDni(rs.getString("dni"));
				a.setFechaRegistro(rs.getString("fechaRegistro"));
				a.setEstado(rs.getInt("estado"));
				a.setIdCategoria(rs.getInt("idCategoria"));
				a.setApellido(rs.getString("apellido"));
				a.setTelefono(rs.getString("telefono"));
				a.setCorreo(rs.getString("correo"));
				a.setDireccion(rs.getString("direccion"));

				lista.add(a);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (rs != null)
					rs.close();

				if (pstm != null)
					pstm.close();

				if (conn != null)
					conn.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

        return lista;
    }

    public int actualizaCliente(Cliente obj) {

        int salida = -1;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {

            conn = MySqlDBConexion.getConexion();

            String sql = "UPDATE cliente SET nombre=?, dni=?, fechaRegistro=?, "
                    + "estado=?, idCategoria=?, apellido=?, telefono=?, "
                    + "correo=?, direccion=? WHERE idCliente=?";

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, obj.getNombre());
            pstm.setString(2, obj.getDni());
            pstm.setString(3, obj.getFechaRegistro());
            pstm.setInt(4, obj.getEstado());
            pstm.setInt(5, obj.getIdCategoria());
            pstm.setString(6, obj.getApellido());
            pstm.setString(7, obj.getTelefono());
            pstm.setString(8, obj.getCorreo());
            pstm.setString(9, obj.getDireccion());
            pstm.setInt(10, obj.getIdCliente());

            salida = pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            try {

                if (pstm != null)
                    pstm.close();

                if (conn != null)
                    conn.close();

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return salida;
    }

    public int eliminaCliente(int idCliente) {

        int salida = -1;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {

            conn = MySqlDBConexion.getConexion();

            String sql = "DELETE FROM cliente WHERE idCliente=?";

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idCliente);

            salida = pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            try {

                if (pstm != null)
                    pstm.close();

                if (conn != null)
                    conn.close();

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return salida;
    }
}