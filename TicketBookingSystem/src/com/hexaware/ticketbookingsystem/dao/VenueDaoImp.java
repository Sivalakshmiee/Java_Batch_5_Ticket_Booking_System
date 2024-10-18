package com.hexaware.ticketbookingsystem.dao;

import com.hexaware.ticketbookingsystem.entity.Venue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VenueDaoImp implements IVenueDao {
    private final Connection conn;

    public VenueDaoImp() {
        conn = DBUtil.getDBConnection(); 
    }

    // Fetch venue details by name
    public Venue getVenueByName(String venueName) {
        String query = "SELECT * FROM venu WHERE venue_name = ?";
        Venue venue = null;

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, venueName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    venue = new Venue(
                            rs.getString("venue_name"),
                            rs.getString("address")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching venue by name: " + e.getMessage());
        }
        return venue;
    }

    // Other DAO methods can be implemented here...
}
