package edu.upm.midas.model;
import edu.upm.midas.constants.Constants;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by gerardo on 26/09/2017.
 *
 * @author Gerardo Lagunes G. ${EMAIL}
 * @version ${<VERSION>}
 * @project tvp_rest
 * @className Request
 * @see
 */
public class Request {

    @Valid
    @NotNull(message = Constants.ERR_NO_PARAMETER)
    @NotEmpty(message = Constants.ERR_EMPTY_PARAMETER)
    private String token;
    @Valid
    @NotNull(message = Constants.ERR_NO_PARAMETER)
    @NotEmpty(message = Constants.ERR_EMPTY_PARAMETER)
    private List<Concept> concepts;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Concept> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }
}
