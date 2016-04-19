package me.wbprime.springdbusecase.mybatis.java.services.impl;


import com.google.common.base.Function;
import com.google.common.collect.Lists;
import me.wbprime.springdbusecase.mybatis.java.dao.PingDAO;
import me.wbprime.springdbusecase.mybatis.java.dto.PingDTO;
import me.wbprime.springdbusecase.mybatis.java.exceptions.PingNotFoundException;
import me.wbprime.springdbusecase.mybatis.java.models.Ping;
import me.wbprime.springdbusecase.mybatis.java.services.PingServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Class: PingServiceImpl
 * Date: 2016/04/18 22:09
 *
 * @author Elvis Wang [mail@wbprime.me]
 */
@Service("pingService")
public class PingServiceImpl implements PingServiceI {
    @Resource(type = PingDAO.class)
    private PingDAO pingDao;

    @Override
    public PingDTO insert(final PingDTO dto) {
        final Ping ping = createPingFromDTO(dto);

        pingDao.insert(ping);

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
        pingDao.updateOne(ping);

        return createDTOFromPing(ping);
    }

    @Override
    public PingDTO deleteOne(final int id) throws PingNotFoundException {
        final Ping ping = findPingById(id);

        pingDao.deleteOne(id);

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
