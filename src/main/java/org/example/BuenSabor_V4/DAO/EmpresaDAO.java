package org.example.BuenSabor_V4.DAO;

import org.example.BuenSabor_V4.Entities.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {

    public Empresa getById(Connection conex, Long id) throws SQLException {
        String sqlSelect = "SELECT * FROM empresa WHERE id = ?";
        try (PreparedStatement psSelect = conex.prepareStatement(sqlSelect)) {
            psSelect.setLong(1, id);
            try (ResultSet rs = psSelect.executeQuery()) {
                if (rs.next()) {
                    return Empresa.builder()
                            .id(rs.getLong("id"))
                            .nombre(rs.getString("nombre"))
                            .razonSocial(rs.getString("razon_social"))
                            .cuil(rs.getInt("cuil"))
                            .build();
                }
            }
        }
        return null;
    }

    public List<Empresa> getAll(Connection conex) throws SQLException {
        String sqlSelectAll = "SELECT * FROM empresa";
        List<Empresa> listaEmpresas = new ArrayList<>();

        try (PreparedStatement psSelectAll = conex.prepareStatement(sqlSelectAll);
             ResultSet rs = psSelectAll.executeQuery()) {

            while (rs.next()) {
                Empresa empresa = Empresa.builder()
                        .id(rs.getLong("id"))
                        .nombre(rs.getString("nombre"))
                        .razonSocial(rs.getString("razon_social"))
                        .cuil(rs.getInt("cuil"))
                        .build();
                listaEmpresas.add(empresa);
            }
        }

        return listaEmpresas;
    }

    public void save(Connection conex, Empresa empresa) throws SQLException {
        String sqlInsert = "INSERT INTO empresa (nombre, razon_social, cuil) VALUES (?, ?, ?)";

        try (PreparedStatement psInsert = conex.prepareStatement(sqlInsert)) {
            psInsert.setString(1, empresa.getNombre());
            psInsert.setString(2, empresa.getRazonSocial());
            psInsert.setInt(3, empresa.getCuil());
            int filasInsertadas = psInsert.executeUpdate();
            System.out.println("🔵 Filas insertadas: " + filasInsertadas);
        }
    }

    public void update(Connection conex, Empresa empresa) throws SQLException {
        String sqlUpdate = "UPDATE empresa SET nombre = ?, razon_social = ?, cuil = ? WHERE id = ?";

        try (PreparedStatement psUpdate = conex.prepareStatement(sqlUpdate)) {
            psUpdate.setString(1, empresa.getNombre());
            psUpdate.setString(2, empresa.getRazonSocial());
            psUpdate.setInt(3, empresa.getCuil());
            psUpdate.setLong(4, empresa.getId());
            int filasActualizadas = psUpdate.executeUpdate();
            System.out.println("🟡 Filas actualizadas: " + filasActualizadas);
        }
    }

    public void delete(Connection conex, Long id) throws SQLException {
        String sqlDelete = "DELETE FROM empresa WHERE id = ?";

        try (PreparedStatement psDelete = conex.prepareStatement(sqlDelete)) {
            psDelete.setLong(1, id);
            int filasEliminadas = psDelete.executeUpdate();
            System.out.println("🔴 Filas eliminadas: " + filasEliminadas);
        }
    }
}