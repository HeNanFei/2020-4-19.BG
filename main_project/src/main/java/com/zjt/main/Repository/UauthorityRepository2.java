package com.zjt.main.Repository;

import com.zjt.main.entity.Uauthority2;
import org.springframework.data.repository.Repository;

import java.util.List;
@org.springframework.stereotype.Repository
public interface UauthorityRepository2 extends Repository<Uauthority2, Long> {

    List<Uauthority2> findAllByUid(Integer uid);

    Uauthority2 findByUsername(String username);

}
