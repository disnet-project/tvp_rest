package edu.upm.midas.authorization.client;

import edu.upm.midas.authorization.client.configuration.FeignAuthConfiguration;
import edu.upm.midas.authorization.client.fallback.AuthClientFallback;
import edu.upm.midas.authorization.model.ValidationResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gerardo on 17/08/2017.
 *
 * @author Gerardo Lagunes G. ${EMAIL}
 * @version ${<VERSION>}
 * @project eidw
 * @className CustomizeTvpClient
 * @see
 */
@FeignClient(name = "${my.service.authorization.name}",
        url = "${my.service.authorization.url}",
        fallback = AuthClientFallback.class,
        configuration = FeignAuthConfiguration.class)
public interface CustomizeAuthClient {

    @RequestMapping(value = "${my.service.authorization.path}", method = RequestMethod.POST)
    public ValidationResponse validationServiceByToken(@RequestBody String tokenService);

}
