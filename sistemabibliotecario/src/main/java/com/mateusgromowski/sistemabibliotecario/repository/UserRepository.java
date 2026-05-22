package com.mateusgromowski.sistemabibliotecario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mateusgromowski.sistemabibliotecario.conn.ConnectionFactory;
import com.mateusgromowski.sistemabibliotecario.model.User;

public class UserRepository {
    private ConnectionFactory connectionFactory;

    public UserRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO user_table (name, email) VALUES (?, ?)";
        try (Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Usuário não pôde ser adicionado. " + e.getMessage());
        }
    }

    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM user_table WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = User.builder().id(rs.getInt("id")).name(rs.getString("name")).email(rs.getString("email"))
                        .build();
                return user;
            }
            return null;
        } catch (SQLException e) {
            throw new SQLException("Usuário inacessível. " + e.getMessage());
        }
    }

    public void updateUser(User user, int id) throws SQLException {
        String sql = "UPDATE user_table SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Impossível atualizar usuário. " + e.getMessage());
        }
    }

    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM user_table WHERE id = ?";

        try (Connection conn = connectionFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Impossível deletar usuário. " + e.getMessage());
        }

    }

}
