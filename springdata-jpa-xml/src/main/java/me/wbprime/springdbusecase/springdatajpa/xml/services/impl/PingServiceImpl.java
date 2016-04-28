package me.wbprime.springdbusecase.springdatajpa.xml.services.impl;


import com.google.common.base.Function;
import com.google.common.collect.Lists;
import me.wbprime.springdbusecase.springdatajpa.xml.dao.PingDAO;
import me.wbprime.springdbusecase.springdatajpa.xml.dto.PingDTO;
import me.wbprime.springdbusecase.springdatajpa.xml.exceptions.PingNotFoundException;
import me.wbprime.springdbusecase.springdatajpa.xml.models.Ping;
import me.wbprime.springdbusecase.springdatajpa.xml.services.PingServiceI;

import java.util.Collections;
import java.util.List;

/**
 * Class: PingServiceImpl
 * Date: 2016/04/18 22:09
 *
 * @author Elvis Wang [mail@wbprime.me]
 */
public class PingServiceImpl implements PingServiceI {
    private PingDAO pingDao;

    public final PingDAO getPingDao() {
        return pingDao;
    }

    public final void setPingDao(final PingDAO pingDao) {
        this.pingDao = pingDao;
    }

    @Override
    public PingDTO insert(final PingDTO dto) {
        final Ping ping = createPingFromDTO(dto);

        pingDao.save(ping);

        return createDTOFromPing(ping);
    }

    @Override
    public List<PingDTO> findAll() {
        final List<Ping> list = pingDao.findAll();

        if (null != list) {
            return Lists.transform(
                list,
                new Function<Ping, PingDTO>() {
                    @Override
                    public PingDTO apply(final Ping input) {
                        return createDTOFromPing(input);
                    }
                }
            );
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public PingDTO findOne(final int id) throws PingNotFoundException {
        final Ping ping = findPingById(id);

        return createDTOFromPing(ping);
    }

    @Override
    public PingDTO updateOne(
        final int id, final PingDTO dto
    ) throws PingNotFoundException {
        final Ping ping = findPingById(id);

        ping.setTitle(dto.getTitle());
        ping.setDescription(dto.getDescription());
        pingDao.save(ping);

        return createDTOFromPing(ping);
    }

    @Override
    public PingDTO deleteOne(final int id) throws PingNotFoundException {
        final Ping ping = findPingById(id);

        pingDao.delete(ping);

        return createDTOFromPing(ping);
    }

    private Ping findPingById(final int id) throws PingNotFoundException {
        final Ping ping = pingDao.findOne(id);

        if (null == ping)
            throw new PingNotFoundException("Ping not found for id:  " + id);
        return ping;
    }

    private PingDTO createDTOFromPing(final Ping ping) {
        final PingDTO dto = new PingDTO();
        dto.setId(ping.getId());
        dto.setTitle(ping.getTitle());
        dto.setDescription(ping.getDescription());

        return dto;
    }

    private Ping createPingFromDTO(final PingDTO dto) {
        final Ping ping = new Ping();
        ping.setTitle(dto.getTitle());
        ping.setDescription(dto.getDescription());

        return ping;
    }
}
