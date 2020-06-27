package com.potemkin.alfabattle.task3;

import com.potemkin.alfabattle.task3.model.Branch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class BranchController {
    private final Logger logger = LoggerFactory.getLogger(BranchRepositoryImpl.class);

    @Autowired
    private BranchRepositoryImpl repository;

    @GetMapping("/branches/{id}")
    public Branch getById(@PathVariable int id) throws SQLException {
        logger.info("getById {}", id);
        return repository.getById(id);
    }
}
