package org.example.BuenSabor_V4.DAO;

import org.example.BuenSabor_V4.Entities.Sucursal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAO {
    public Sucursal getById(Connection conex, Long id) throws SQLException {
        String sqlSelect = "SELECT * FROM sucursal WHERE id = ?";
        try (PreparedStatement psSelect = conex.prepareStatement(sqlSelect)) {
            psSelect.setLong(1, id);
            try (ResultSet rs = psSelect.executeQuery()) {
                if (rs.next()) {
                    return Sucursal.builder()
                            .id(rs.getLong("id"))
                            .nombre(rs.getString("nombre"))
                            .horarioApertura(rs.getTime("horario_apertura").toLocalTime())
                            .horarioCierre(rs.getTime("horario_cierre").toLocalTime())
                            .build();
                }
            }
        }
        return null;
    }

    public List<Sucursal> getAll(Connection conex) throws SQLException {
        String sqlSelectAll = "SELECT * FROM empresa";
        List<Sucursal> listaSucursal = new ArrayList<>();

        try (PreparedStatement psSelectAll = conex.prepareStatement(sqlSelectAll);
             ResultSet rs = psSelectAll.executeQuery()) {

            while (rs.next()) {
                Sucursal sucursal = Sucursal.builder()
                        .id(rs.getLong("id"))
                        .nombre(rs.getString("nombre"))
                        .horarioApertura(rs.getTime("horario_apertura").toLocalTime())
                        .horarioCierre(rs.getTime("horario_cierre").toLocalTime())
                        .build();
                listaSucursal.add(sucursal);
            }
        }

        return listaSucursal;
    }

    public void save(Connection conex, Sucursal sucursal) throws SQLException {
        String sqlInsert = "INSERT INTO sucursal (nombre, horario_apertura, horario_cierre) VALUES (?, ?, ?)";

        try (PreparedStatement psInsert = conex.prepareStatement(sqlInsert)) {
            psInsert.setString(1, sucursal.getNombre());
            psInsert.setTime(2, Time.valueOf(sucursal.getHorarioApertura()));
            psInsert.setTime(3, Time.valueOf(sucursal.getHorarioCierre()));
            int filasInsertadas = psInsert.executeUpdate();
            System.out.println("🔵 Filas insertadas: " + filasInsertadas);
        }
    }

    public void update(Connection conex, Sucursal sucursal) throws SQLException {
        String sqlUpdate = "UPDATE sucursal SET nombre = ?, horario_apertura = ?, horario_cierre = ? WHERE id = ?";

        try (PreparedStatement psUpdate = conex.prepareStatement(sqlUpdate)) {
            psUpdate.setString(1, sucursal.getNombre());
            psUpdate.setTime(2, Time.valueOf(sucursal.getHorarioApertura()));
            psUpdate.setTime(3, Time.valueOf(sucursal.getHorarioCierre()));
            psUpdate.setLong(4, sucursal.getId());
            int filasActualizadas = psUpdate.executeUpdate();
            System.out.println("🟡 Filas actualizadas: " + filasActualizadas);
        }
    }

    public void delete(Connection conex, Long id) throws SQLException {
        String sqlDelete = "DELETE FROM sucursal WHERE id = ?";

        try (PreparedStatement psDelete = conex.prepareStatement(sqlDelete)) {
            psDelete.setLong(1, id);
            int filasEliminadas = psDelete.executeUpdate();
            System.out.println("🔴 Filas eliminadas: " + filasEliminadas);
        }
    }
}