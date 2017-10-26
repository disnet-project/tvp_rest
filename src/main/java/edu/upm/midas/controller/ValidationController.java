package edu.upm.midas.controller;
import edu.upm.midas.authorization.token.service.TokenAuthorization;
import edu.upm.midas.model.MatchNLP;
import edu.upm.midas.model.Request;
import edu.upm.midas.model.Response;
import edu.upm.midas.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by gerardo on 05/07/2017.
 *
 * @author Gerardo Lagunes G. ${EMAIL}
 * @version ${<VERSION>}
 * @project validation_medical_term
 * @className ValidationController
 * @see
 */
@RestController
@RequestMapping("${my.service.rest.request.mapping.general.url}")
public class ValidationController {

    @Autowired
    private ValidationService validationService;
    @Autowired
    private TokenAuthorization tokenAuthorization;

    @RequestMapping(path = { "${my.service.rest.request.mapping.validate.path}" }, //Term Validation Procedure
            method = RequestMethod.POST)
    public Response validate(@RequestBody @Valid Request request, HttpServletRequest httpRequest, Device device) throws Exception {
        Response response = tokenAuthorization.validateService(request.getToken(), httpRequest.getServletPath(), httpRequest.getServletPath(), device);
        if (response.isAuthorization()) {
            List<MatchNLP> conceptsValidated = validationService.doValidation(request.getConcepts());
            response.setValidatedConcepts(conceptsValidated);
        }

        return response;
    }

}
