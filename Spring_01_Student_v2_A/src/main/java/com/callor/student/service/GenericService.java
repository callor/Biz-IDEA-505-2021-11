package com.callor.student.service;

import java.util.List;

public interface GenericService<M, PK> {

    public List<M> selectAll();
    public M findById(PK pk);

    public void insert(M model);
    public void update(M model);
    public void delete(PK pk);

}
