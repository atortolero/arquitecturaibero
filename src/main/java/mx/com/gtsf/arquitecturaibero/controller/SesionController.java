package mx.com.gtsf.arquitecturaibero.controller;

import mx.com.gtsf.arquitecturaibero.model.UsuariosModel;
import mx.com.gtsf.arquitecturaibero.service.SesionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sesion")
public class SesionController {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(SesionController.class);

    @Autowired
    @Qualifier("sesionServiceImpl")
    private SesionService sesionService;

    // DELETE session
    @CrossOrigin
    @RequestMapping(value = "/deleteSession/{auth}", method = RequestMethod.DELETE)
    public UsuariosModel deleteSession(@PathVariable("auth") String token) {

        //LOG.info("EN deleteSession con token: \"" + token  + "\"");

        UsuariosModel usrModel = new UsuariosModel();

        try {
            sesionService.removeSession(token);
        }catch(Exception e){
            LOG.info("Borrando una session con excepcion: " + e.toString());
        }

        return usrModel;

    }
}

