package com.zjt.main.Repository;


import com.zjt.main.entity.Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface EntityRepository extends Repository<Entity, Long> {

    List<Entity> findAllByName(String name);


}
