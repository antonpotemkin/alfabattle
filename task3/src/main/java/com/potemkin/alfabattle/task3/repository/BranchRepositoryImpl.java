package com.potemkin.alfabattle.task3.repository;

import com.potemkin.alfabattle.task3.exception.BranchException;
import com.potemkin.alfabattle.task3.model.Branch;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class BranchRepositoryImpl implements BranchRepository {

    private DataSource dataSource;

    public BranchRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Branch getById(int id) throws SQLException {
        log.info("get id {}", id);
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM branches WHERE id=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Branch branch = generateBranch(rs, id);
                        log.info("found branch {}", branch);
                        return branch;
                    } else {
                        log.info("not found");
                        throw new BranchException();
                    }
                }
            }
        }
    }

    @Override
    public List<Branch> getAll() throws SQLException {
        log.info("get all");
        List<Branch> branches = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM branches ORDER BY id";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Branch branch = generateBranch(rs, rs.getInt("id"));
                        log.info("found branch {}", branch);
                        branches.add(branch);
                    }
                }
            }
        }
        return branches;
    }

    private Branch generateBranch(ResultSet rs, int id) throws SQLException {
        String title = rs.getString("title");
        double lon = rs.getDouble("lon");
        double lat = rs.getDouble("lat");
        String address = rs.getString("address");
        Branch branch = new Branch(id, title, lon, lat, address);
        return branch;
    }
}
