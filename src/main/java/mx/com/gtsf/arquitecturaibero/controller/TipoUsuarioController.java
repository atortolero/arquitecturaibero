package mx.com.gtsf.arquitecturaibero.controller;

import mx.com.gtsf.arquitecturaibero.model.TipoUsuarioModel;
import mx.com.gtsf.arquitecturaibero.service.SesionService;
import mx.com.gtsf.arquitecturaibero.service.TipoUsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tiposUsuario")
public class TipoUsuarioController {

    /**
     * The Constant LOG.
     */
    private static final Log LOG = LogFactory.getLog(TipoUsuarioController.class);

    /**
     * The service
     **/
    @Autowired
    @Qualifier("tipoUsuarioServiceImpl")
    private TipoUsuarioService tipoUsuarioService;

    @Autowired
    @Qualifier("sesionServiceImpl")
    private SesionService sesionService;


    // GET tiposUsuario -- Get all tiposUsuario
    @CrossOrigin
    @RequestMapping(value = "/getTiposUsuario/{auth}", method = RequestMethod.GET)
    public List<TipoUsuarioModel> getAllTiposUsuario(@PathVariable("auth") String token) {
        List<TipoUsuarioModel> tipoUsuarioResult = new ArrayList<TipoUsuarioModel>();

        //LOG.info("En getTiposUsuario con token: \"" + token + "\"");

        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {

            //LOG.info("Sesión válida!");

            tipoUsuarioResult = tipoUsuarioService.getTiposAdministradores();

            //LOG.info("Obtuvimos: \"" + tipoUsuarioResult.toString() + "\"");

        } else {
            //LOG.info("Sesión no válida");

            TipoUsuarioModel tipoUsuario = new TipoUsuarioModel();
            tipoUsuarioResult.add(tipoUsuario);
        }

        return tipoUsuarioResult;
    }
}

