package edu.upm.midas.constants;

/**
 * Created by gerardo on 27/3/17.
 * @project ExtractionInformationWikipedia
 * @version ${<VERSION>}
 * @author Gerardo Lagunes G.
 * @className Constants
 * @see
 */
public class Constants {

    public static final String HTTP_HEADER = "https://";
    public static final String VERSION_PROJECT = "1.0";

    /** Validaciones */
    public static final String SEMANTIC_TYPES[] = { "sosy", "diap", "dsyn", "fndg", "lbpr", "lbtr" };

    public final static float SIMILARITY_MIN_VALUE = (float) 0.85;

    public final static String VALIDATION_FILE = "/findings/allFindings.fd";

    public final static String ERR_NO_PARAMETER = "No parameter was sent";
    public final static String ERR_EMPTY_PARAMETER = "Empty parameter";

    public static final String EXTRACTION_HISTORY_FOLDER = "tmp/tvp/";

    public static final String TVP_RETRIEVAL_HISTORY_FOLDER = "tmp/tvp/";
    public static final String TVP_RETRIEVAL_FILE_NAME = "_tvp_validation";
    public static final String DOT_JSON = ".json";

    /**
     * Linea del piso
     */
    public static final String UNDER_SCORE = "_";

}
