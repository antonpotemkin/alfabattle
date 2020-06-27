package com.potemkin.alfabattle.task3.repository;

import com.potemkin.alfabattle.task3.model.Branch;

import java.sql.SQLException;
import java.util.List;

public interface BranchRepository {
    Branch getById(int id) throws SQLException;
    List<Branch> getAll() throws SQLException;
}
