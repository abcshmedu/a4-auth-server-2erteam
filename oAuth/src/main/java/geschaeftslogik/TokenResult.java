package geschaeftslogik;
import javax.ws.rs.core.Response;

    
    /**
     * enum with status codes.
     * @author Altvatter Robert, Großbeck Thomas
     *
     */
    public enum TokenResult {
        OK(Response.Status.OK.getStatusCode(), "successful"),
        INVALID(Response.Status.BAD_REQUEST.getStatusCode(), "Ungültiges Token"),
        CONFLICT(Response.Status.CONFLICT.getStatusCode(), "Token abgelaufen");
        private String status;
        private int code;
        
        /**
         * Defaultconstructor.
         */
        TokenResult() {
            code = 0;
            status = "";
        }
        
        /**
         * Constructs a MediaServiceResult.
         * @param code of the result
         * @param status of the result
         */
        TokenResult(int code, String status) {
            this.code = code;
            this.status = status;
        }
        
        /**
         * @return code
         */
        public int getCode() {
            return code;
        }
        
        /**
         * @return status
         */
        public String getStatus() {
            return status;
        }
        
        
    };
