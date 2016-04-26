package me.wbprime.springdbusecase.hibernate.xml.services;


import me.wbprime.springdbusecase.hibernate.xml.dto.PingDTO;
import me.wbprime.springdbusecase.hibernate.xml.exceptions.PingNotFoundException;

import java.util.List;

/**
 * Interface: PingServiceI
 * Date: 2016/04/18 22:08
 *
 * @author Elvis Wang [mail@wbprime.me]
 */
public interface PingServiceI {
    PingDTO insert(PingDTO dto);

    List<PingDTO> findAll();

    PingDTO findOne(int id) throws PingNotFoundException;

    PingDTO updateOne(int id, PingDTO dto) throws PingNotFoundException;

    PingDTO deleteOne(int id) throws PingNotFoundException;
}
