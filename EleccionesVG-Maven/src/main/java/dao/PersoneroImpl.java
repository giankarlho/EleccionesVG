package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import modelo.Personero;

public class PersoneroImpl extends Conexion implements ICRUD<Personero> {

    @Override
    public void registrar(Personero per) throws Exception {
        // dni_per      nom_per     apep_per    apem_per    nac_per     tel_per     asig_mes    mes_per     obs_per     est_per (10)
        // dni          nombre      apaterno    amaterno    nacimiento  telefono    asignacion  mesa        observacion estado       
        String sql = "insert into personero (dni_per,nom_per,apep_per,apem_per,nac_per,tel_per,asig_mes,mes_per,obs_per,est_per) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, per.getDni());
            ps.setString(2, per.getNombre());
            ps.setString(3, per.getApaterno());
            ps.setString(4, per.getAmaterno());
            SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yy");
            ps.setString(5, forma.format(per.getNacimiento()));
            ps.setString(6, per.getTelefono());
            ps.setString(7, per.getAsignacion());
            ps.setString(8, per.getMesa());
            ps.setString(9, per.getObservacion());
            ps.setString(10, per.getEstado());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar PersoneroImpl: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Personero per) throws Exception {
        String sql = "update personero set nom_per=?,apep_per=?, apem_per=?,nac_per=?,tel_per=?,asig_mes=?,mes_per=?,obs_per=?,est_per=? where dni_per=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApaterno());
            ps.setString(3, per.getAmaterno());
            SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yy");
            ps.setString(4, forma.format(per.getNacimiento()));
            ps.setString(5, per.getTelefono());
            ps.setString(6, per.getAsignacion());
            ps.setString(7, per.getMesa());
            ps.setString(8, per.getObservacion());
            ps.setString(9, per.getEstado());
            ps.setString(10, per.getDni());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar PersoneroImpl: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Personero per) throws Exception {
        String sql = "delete from personero where dni_per=?";     // query dml simple, vista, procedures, trigger         
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, per.getDni());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminar PersoneroImpl" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List listarTodos() throws Exception {
        List<Personero> listado = null;
        Personero pers;
        String sql = "select * from personero";
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pers = new Personero();
                pers.setDni(rs.getString("dni_per"));
                pers.setNombre(rs.getString("nom_per"));
                pers.setApaterno(rs.getString("apep_per"));
                pers.setAmaterno(rs.getString("apem_per"));
                pers.setNacimiento(rs.getDate("nac_per"));
                pers.setTelefono(rs.getString("tel_per"));
                pers.setAsignacion(rs.getString("asig_mes"));
                pers.setMesa(rs.getString("mes_per"));
                pers.setObservacion(rs.getString("obs_per"));
                //pers.setEstado(rs.getString("est_per"));
                listado.add(pers);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en listarTodos PersoneroImpl: " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }

    @Override
    public List<Personero> listarTodos(char estado) throws Exception {
        List<Personero> listado = null;
        Personero pers;
        String sql = "select * from personero where est_per=' " + estado + "'";
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pers = new Personero();
                pers.setDni(rs.getString("dni_per"));
                pers.setNombre(rs.getString("nom_per"));
                pers.setApaterno(rs.getString("apep_per"));
                pers.setAmaterno(rs.getString("apem_per"));
                pers.setNacimiento(rs.getDate("nac_per"));
                pers.setTelefono(rs.getString("tel_per"));
                pers.setAsignacion(rs.getString("asig_mes"));
                pers.setMesa(rs.getString("mes_per"));
                pers.setObservacion(rs.getString("obs_per"));
                listado.add(pers);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en listarTodos PersoneroImpl: " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }

    @Override
    public void cambiarEstado(Personero per) throws Exception {
        String sql = "update personero set est_loc=? where dni_per=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, per.getEstado());
            ps.setString(2, per.getDni());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al cambiarEstado PersoneroImpl: " + e.getMessage());
        }
    }

}
