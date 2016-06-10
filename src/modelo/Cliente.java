package modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByCliCedula", query = "SELECT c FROM Cliente c WHERE c.cliCedula = :cliCedula"),
    @NamedQuery(name = "Cliente.findByCliNombre", query = "SELECT c FROM Cliente c WHERE c.cliNombre = :cliNombre"),
    @NamedQuery(name = "Cliente.findByCliRazonSocial", query = "SELECT c FROM Cliente c WHERE c.cliRazonSocial = :cliRazonSocial"),
    @NamedQuery(name = "Cliente.findByCliDireccion", query = "SELECT c FROM Cliente c WHERE c.cliDireccion = :cliDireccion"),
    @NamedQuery(name = "Cliente.findByCliTelefono", query = "SELECT c FROM Cliente c WHERE c.cliTelefono = :cliTelefono"),
    @NamedQuery(name = "Cliente.findByCliMovil", query = "SELECT c FROM Cliente c WHERE c.cliMovil = :cliMovil"),
    @NamedQuery(name = "Cliente.findByCliCorreo", query = "SELECT c FROM Cliente c WHERE c.cliCorreo = :cliCorreo")})
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int idCliente;

	@Column(name="cli_cedula")
	private String cliCedula;

	@Column(name="cli_correo")
	private String cliCorreo;

	@Column(name="cli_direccion")
	private String cliDireccion;

	@Column(name="cli_movil")
	private String cliMovil;

	@Column(name="cli_nombre")
	private String cliNombre;

	@Column(name="cli_razon_social")
	private String cliRazonSocial;

	@Column(name="cli_telefono")
	private String cliTelefono;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="cliente")
	private List<Factura> facturas;

	public Cliente() {
	}
	
	

	public Cliente(String cliCedula, String cliCorreo, String cliDireccion,
			String cliMovil, String cliNombre, String cliRazonSocial,
			String cliTelefono) {
		super();
		this.cliCedula = cliCedula;
		this.cliCorreo = cliCorreo;
		this.cliDireccion = cliDireccion;
		this.cliMovil = cliMovil;
		this.cliNombre = cliNombre;
		this.cliRazonSocial = cliRazonSocial;
		this.cliTelefono = cliTelefono;
		this.facturas = facturas;
	}



	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCliCedula() {
		return this.cliCedula;
	}

	public void setCliCedula(String cliCedula) {
		this.cliCedula = cliCedula;
	}

	public String getCliCorreo() {
		return this.cliCorreo;
	}

	public void setCliCorreo(String cliCorreo) {
		this.cliCorreo = cliCorreo;
	}

	public String getCliDireccion() {
		return this.cliDireccion;
	}

	public void setCliDireccion(String cliDireccion) {
		this.cliDireccion = cliDireccion;
	}

	public String getCliMovil() {
		return this.cliMovil;
	}

	public void setCliMovil(String cliMovil) {
		this.cliMovil = cliMovil;
	}

	public String getCliNombre() {
		return this.cliNombre;
	}

	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
	}

	public String getCliRazonSocial() {
		return this.cliRazonSocial;
	}

	public void setCliRazonSocial(String cliRazonSocial) {
		this.cliRazonSocial = cliRazonSocial;
	}

	public String getCliTelefono() {
		return this.cliTelefono;
	}

	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	

}