package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Local;

public class LocalImpl extends Conexion implements ICRUD<Local> {

    // codigo       nombre      dir         odpe        ubigeo      estado
    // cod_loc      nom_loc     dir_loc     odpe_loc    cod_ubi     est_loc
    @Override
    public void registrar(Local local) throws Exception {
        String sql = "insert into local (cod_loc,nom_loc,dir_loc,odpe_loc,cod_ubi,est_loc) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, local.getCodigo());
            ps.setString(2, local.getNombre());
            ps.setString(3, local.getDir());
            ps.setInt(4, local.getOdpe());
            ps.setString(5, local.getUbigeo());
            ps.setString(6, local.getEstado());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar LocalImpl: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Local local) throws Exception {
        String sql = "update local set nom_loc=?,dir_loc=?,odpe_loc=?,cod_ubi=?,est_loc=? where cod_loc=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, local.getNombre());
            ps.setString(2, local.getDir());
            ps.setInt(3, local.getOdpe());
            ps.setString(4, local.getUbigeo());
            ps.setString(5, local.getEstado());
            ps.setString(6, local.getCodigo());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar LocalImpl: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Local local) throws Exception {
        String sql = "delete from local where cod_loc=?";     // query dml simple, vista, procedures, trigger         
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, local.getCodigo());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminar LocalImpl" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<Local> listarTodos() throws Exception {
        List<Local> listado = null;
        Local local;
        String sql = "vw_listarLocal"; //cod_loc,nom_loc,odpe_loc,dpto_ubi,prov_ubi,dist_ubi,dir_loc
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                local = new Local();
                local.setCodigo(rs.getString("cod_loc"));
                local.setNombre(rs.getString("nom_loc"));                
                local.setOdpe(rs.getInt("odpe_loc"));
                local.setOdpe(rs.getInt("dpto_ubi"));
                local.setOdpe(rs.getInt("prov_ubi"));
                local.setOdpe(rs.getInt("dist_ubi"));                
                local.setDir(rs.getString("dir_loc"));
                listado.add(local);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en listarTodos LocalImpl: " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }

    @Override
    public List<Local> listarTodos(char estado) throws Exception {
        List<Local> listado = null;
        Local local;
        String sql = "select * from local where est_loc='" + estado + "'";
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                local = new Local();
                local.setCodigo(rs.getString("cod_loc"));
                local.setNombre(rs.getString("nom_loc"));
                local.setDir(rs.getString("dir_loc"));
                local.setOdpe(rs.getInt("odpe_loc"));
                local.setUbigeo(rs.getString("cod_ubi"));                
                listado.add(local);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en listarTodos LocalImpl: " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }

    @Override
    public void cambiarEstado(Local local) throws Exception {
        String sql = "update local set est_loc=? where cod_loc=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, local.getEstado());
            ps.setString(2, local.getCodigo());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al cambiarEstado LocalImpl: " + e.getMessage());
        }
    }

    public Boolean buscarCodigo() throws Exception {
        Boolean estCodigo = false;

        return estCodigo;
    }

}
