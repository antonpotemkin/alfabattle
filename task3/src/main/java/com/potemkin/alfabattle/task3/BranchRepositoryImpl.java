package com.potemkin.alfabattle.task3;

import com.potemkin.alfabattle.task3.exception.BranchException;
import com.potemkin.alfabattle.task3.model.Branch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class BranchRepositoryImpl {
    private final Logger logger = LoggerFactory.getLogger(BranchRepositoryImpl.class);

    private DataSource dataSource;

    public BranchRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Branch getById(int id) throws SQLException {
        logger.info("get id {}", id);
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM branches WHERE id=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        String title = rs.getString("title");
                        double lon = rs.getDouble("lon");
                        double lat = rs.getDouble("lat");
                        String address = rs.getString("address");
                        Branch branch = new Branch(id, title, lon, lat, address);
                        logger.info("found branch {}", branch);
                        return branch;
                    } else {
                        logger.info("not found");
                        throw new BranchException();
                    }
                }
            }
        }
    }

}
