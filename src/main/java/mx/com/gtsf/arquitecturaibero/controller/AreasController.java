package mx.com.gtsf.arquitecturaibero.controller;


import mx.com.gtsf.arquitecturaibero.entity.Usuarios;
import mx.com.gtsf.arquitecturaibero.model.AreasModel;
import mx.com.gtsf.arquitecturaibero.model.UsuariosModel;
import mx.com.gtsf.arquitecturaibero.service.AreasService;
import mx.com.gtsf.arquitecturaibero.service.SesionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreasController {

    /**
     * The Constant LOG.
     */
    private static final Log LOG = LogFactory.getLog(AreasController.class);

    @Autowired
    @Qualifier("areasServiceImpl")
    AreasService areasService;

    @Autowired
    @Qualifier("sesionServiceImpl")
    private SesionService sesionService;



    //----------------------------------------------
    //
    //  AREAS
    //
    //----------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/{auth}", method = RequestMethod.GET)
    public List<AreasModel> getAllAreas(@PathVariable("auth") String token) {
        List<AreasModel> areasResult = new ArrayList<AreasModel>();

        boolean validSession = sesionService.validSession(token);

        if (validSession) {
            areasResult = areasService.getAllAreas();
        } else {
            AreasModel area = new AreasModel();
            areasResult.add(area);
        }

        return areasResult;
    }// getAllAreas

    // POST Areas -- save or update   new area
    @CrossOrigin
    @RequestMapping(value = "/{auth}", consumes = "application/json", method = RequestMethod.POST)
    public AreasModel createArea(@PathVariable("auth") String token, @RequestBody AreasModel element) {
        AreasModel areaModel = null;
        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {
            areaModel = areasService.addArea(element);
        } else {
            areaModel = new AreasModel();

        }
        return areaModel;
    } // createArea

    // DELETE area
    //@CrossOrigin(origins = "http://localhost:8080")
    @CrossOrigin
    @RequestMapping(value = "/deleteArea/{areaid}/{auth}", method = RequestMethod.DELETE)
    public void deleteArea(@PathVariable("areaid") int areaid, @PathVariable("auth") String token) {
        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {
            areasService.removeArea(areaid);
        }
    } // deleteArea
}
