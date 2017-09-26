package edu.upm.midas.service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.upm.midas.model.Concept;
import edu.upm.midas.model.Response;
import edu.upm.midas.token.component.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gerardo on 26/09/2017.
 *
 * @author Gerardo Lagunes G. ${EMAIL}
 * @version ${<VERSION>}
 * @project tvp_rest
 * @className TokenAuthorization
 * @see
 */
@Service
public class TokenAuthorization {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    public Response validateService(String userToken, List<Concept> conceptList, String path, Device device){
        Response response = new Response();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String token = jwtTokenUtil.generateToken( userToken, gson.toJson(conceptList), path, device );

        return response;

    }


}
