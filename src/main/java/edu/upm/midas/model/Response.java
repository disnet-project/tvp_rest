package edu.upm.midas.model;
import edu.upm.midas.constants.Constants;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by gerardo on 26/09/2017.
 *
 * @author Gerardo Lagunes G. ${EMAIL}
 * @version ${<VERSION>}
 * @project tvp_rest
 * @className Response
 * @see
 */
public class Response {

    private String token;
    private boolean authorization;
    private String message;
    List<MatchNLP> validatedConcepts;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAuthorization() {
        return authorization;
    }

    public void setAuthorization(boolean authorization) {
        this.authorization = authorization;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MatchNLP> getValidatedConcepts() {
        return validatedConcepts;
    }

    public void setValidatedConcepts(List<MatchNLP> validatedConcepts) {
        this.validatedConcepts = validatedConcepts;
    }
}
