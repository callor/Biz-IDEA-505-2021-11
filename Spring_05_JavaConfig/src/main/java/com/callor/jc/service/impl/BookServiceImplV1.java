package com.callor.jc.service.impl;

import com.callor.jc.repository.DDL_Dao;
import com.callor.jc.repository.sql.CreateTableSQL;
import org.springframework.stereotype.Service;

@Service("bookServiceV1")
public class BookServiceImplV1 {

    private final DDL_Dao ddlDao;

    public BookServiceImplV1(DDL_Dao ddlDao) {

        this.ddlDao = ddlDao;
        ddlDao.create_table(CreateTableSQL.create_book_table);

    }
}
