package me.wbprime.springdbusecase.mybatis.java.controllers;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import me.wbprime.springdbusecase.mybatis.java.dto.ErrorDTO;
import me.wbprime.springdbusecase.mybatis.java.dto.PingDTO;
import me.wbprime.springdbusecase.mybatis.java.exceptions.PingNotFoundException;
import me.wbprime.springdbusecase.mybatis.java.services.PingServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * Class: PingController
 * Date: 2016/04/18 21:29
 *
 * @author Elvis Wang [mail@wbprime.me]
 */
@RestController
public class PingController {
    @Resource(name = "pingService")
    private PingServiceI pingService;

    @RequestMapping(value = "ping", method = RequestMethod.POST)
    public PingDTO add(@Valid @RequestBody final PingDTO dto) {
        final PingDTO result = pingService.insert(dto);
        return result;
    }

    @RequestMapping(value = "ping", method = RequestMethod.GET)
    public List<PingDTO> list() {
        return pingService.findAll();
    }

    @RequestMapping(value = "ping/{id}", method = RequestMethod.GET)
    public PingDTO get(@PathVariable("id") final int id) throws PingNotFoundException {
        final PingDTO result = pingService.findOne(id);
        return result;
    }

    @RequestMapping(value = "ping/{id}", method = RequestMethod.PUT)
    public PingDTO update(
        @PathVariable("id") final int id,
        @Valid @RequestBody final PingDTO dto
    ) throws PingNotFoundException {
        final PingDTO result = pingService.updateOne(id, dto);
        return result;
    }

    @RequestMapping(value = "ping/{id}", method = RequestMethod.DELETE)
    public PingDTO delete(@PathVariable("id") final int id) throws PingNotFoundException {
        final PingDTO result = pingService.deleteOne(id);
        return result;
    }

    @ExceptionHandler(PingNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public List<ErrorDTO> handlePingNotFoundException(final PingNotFoundException e) {
        final ErrorDTO dto = new ErrorDTO();
        dto.setError(e.getMessage());

        return ImmutableList.of(
            dto
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ErrorDTO> handleBindException(final MethodArgumentNotValidException e) {
        final BindingResult bindingResult = e.getBindingResult();
        final List<ErrorDTO> result =
            Lists.newArrayListWithExpectedSize(bindingResult.getErrorCount());
        for (FieldError error : bindingResult.getFieldErrors()) {
            final ErrorDTO dto = new ErrorDTO();
            dto.setError(error.getField() + ": " + error.getDefaultMessage());
            result.add(dto);
        }

        return result;
    }
}
