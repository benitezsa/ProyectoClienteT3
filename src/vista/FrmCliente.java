package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entidad.Categoria;
import entidad.Cliente;
import model.CategoriaModel;
import model.ClienteModel;

public class FrmCliente extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtFechaRegistro;
	private JTextField txtEstado;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtDireccion;

	private JComboBox<Categoria> cboCategoria;

	private JTable table;

	private JButton btnRegistrar;
	private JButton btnListar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);

		getContentPane().setBackground(SystemColor.scrollbar);
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Registro de Cliente");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(330, 20, 200, 23);
		getContentPane().add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(40, 70, 100, 23);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(150, 71, 150, 22);
		getContentPane().add(txtNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(40, 110, 100, 23);
		getContentPane().add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setBounds(150, 111, 150, 22);
		getContentPane().add(txtApellido);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDNI.setBounds(40, 150, 100, 23);
		getContentPane().add(lblDNI);

		txtDNI = new JTextField();
		txtDNI.setBounds(150, 151, 150, 22);
		getContentPane().add(txtDNI);

		JLabel lblFechaRegistro = new JLabel("Fecha Registro");
		lblFechaRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaRegistro.setBounds(40, 190, 100, 23);
		getContentPane().add(lblFechaRegistro);

		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setBounds(150, 191, 150, 22);
		getContentPane().add(txtFechaRegistro);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(40, 230, 100, 23);
		getContentPane().add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setBounds(150, 231, 150, 22);
		getContentPane().add(txtEstado);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategoria.setBounds(360, 70, 100, 23);
		getContentPane().add(lblCategoria);

		cboCategoria = new JComboBox<Categoria>();
		cboCategoria.setBounds(470, 71, 180, 22);
		getContentPane().add(cboCategoria);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setBounds(360, 110, 100, 23);
		getContentPane().add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(470, 111, 150, 22);
		getContentPane().add(txtTelefono);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorreo.setBounds(360, 150, 100, 23);
		getContentPane().add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(470, 151, 150, 22);
		getContentPane().add(txtCorreo);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(360, 190, 100, 23);
		getContentPane().add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(470, 191, 150, 22);
		getContentPane().add(txtDireccion);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnRegistrar.setBounds(700, 100, 110, 35);
		btnRegistrar.addActionListener(this);
		getContentPane().add(btnRegistrar);

		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnListar.setBounds(700, 160, 110, 35);
		btnListar.addActionListener(this);
		getContentPane().add(btnListar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 290, 800, 250);
		getContentPane().add(scrollPane);

		table = new JTable();

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Apellido", "DNI", "Fecha Registro",
				"Estado", "Categoria", "Telefono", "Correo", "Direccion"
			}
		));

		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setRowSelectionAllowed(false);
		table.setDefaultEditor(Object.class, null);

		scrollPane.setViewportView(table);

		cargarCategorias();
	}

	private void cargarCategorias() {

		CategoriaModel objCategoriaModel = new CategoriaModel();

		List<Categoria> lista = objCategoriaModel.listaTodos();

		cboCategoria.removeAllItems();

		for (Categoria a : lista) {
			cboCategoria.addItem(a);
		}
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
		if (e.getSource() == btnListar) {
			do_btnListar_actionPerformed(e);
		}
	}
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {

		String nombre = txtNombre.getText().trim();
		String apellido = txtApellido.getText().trim();
		String dni = txtDNI.getText().trim();
		String fechaRegistro = txtFechaRegistro.getText().trim();
		String estadoTexto = txtEstado.getText().trim();
		String telefono = txtTelefono.getText().trim();
		String correo = txtCorreo.getText().trim();
		String direccion = txtDireccion.getText().trim();

		if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()
				|| fechaRegistro.isEmpty() || estadoTexto.isEmpty()
				|| telefono.isEmpty() || correo.isEmpty()
				|| direccion.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Complete todos los campos");
			return;
		}
		if (!dni.matches("\\d{8}")) {
			JOptionPane.showMessageDialog(this, "El DNI debe tener 8 digitos");
			return;
		}
		if (!telefono.matches("\\d{9}")) {
			JOptionPane.showMessageDialog(this, "El telefono debe tener 9 digitos");
			return;
		}
		if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
			JOptionPane.showMessageDialog(this, "Ingrese un correo valido");
			return;
		}
		int estado;
		try {
			estado = Integer.parseInt(estadoTexto);

		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this,
					"El estado debe ser un numero");
			return;
		}

		if (estado != 0 && estado != 1) {
			JOptionPane.showMessageDialog(this,
					"El estado debe ser 1 o 0");
			return;
		}
		Categoria categoria = (Categoria) cboCategoria.getSelectedItem();
		if (categoria == null) {
			JOptionPane.showMessageDialog(this,
					"Seleccione una categoria");
			return;
		}
		int idCategoria = categoria.getIdCategoria();

		Cliente objCliente = new Cliente();

		objCliente.setNombre(nombre);
		objCliente.setApellido(apellido);
		objCliente.setDni(dni);
		objCliente.setFechaRegistro(fechaRegistro);
		objCliente.setEstado(estado);
		objCliente.setIdCategoria(idCategoria);
		objCliente.setTelefono(telefono);
		objCliente.setCorreo(correo);
		objCliente.setDireccion(direccion);

		ClienteModel objClienteModel = new ClienteModel();

		int salida = objClienteModel.insertaCliente(objCliente);

		if (salida > 0) {
			JOptionPane.showMessageDialog(this,
					"Cliente registrado correctamente");
			limpiarCampos();
		} else {
			JOptionPane.showMessageDialog(this,
					"No se pudo registrar el cliente");
		}
	}
	protected void do_btnListar_actionPerformed(ActionEvent e) {

		ClienteModel objClienteModel = new ClienteModel();
		List<Cliente> lista = objClienteModel.listaTodos();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Cliente a : lista) {

			Object[] rowData = {
					a.getIdCliente(),
					a.getNombre(),
					a.getApellido(),
					a.getDni(),
					a.getFechaRegistro(),
					a.getEstado(),
					a.getIdCategoria(),
					a.getTelefono(),
					a.getCorreo(),
					a.getDireccion()
			};
			model.addRow(rowData);
		}
	}
	private void limpiarCampos() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");
		txtFechaRegistro.setText("");
		txtEstado.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		txtDireccion.setText("");
		if (cboCategoria.getItemCount() > 0) {
			cboCategoria.setSelectedIndex(0);
		}
	}
}