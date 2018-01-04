package cz.simkovicp.calculator.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.simkovicp.calculator.OperationLog;

@RequestMapping("/api/log")
@RestController
public class LogController {

    @Autowired
    private OperationLog additionLog;

    @RequestMapping(value = "addition", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<String> getAdditionMessages() {
        return additionLog.getMessages();
    }

}
