package mx.com.gtsf.arquitecturaibero.controller;


import mx.com.gtsf.arquitecturaibero.model.MateriaModel;
import mx.com.gtsf.arquitecturaibero.model.MateriasModel;
import mx.com.gtsf.arquitecturaibero.service.MateriasService;
import mx.com.gtsf.arquitecturaibero.service.SesionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriasController {

    /**
     * The Constant LOG.
     */
    private static final Log LOG = LogFactory.getLog(AreasController.class);

    @Autowired
    @Qualifier("materiasServiceImpl")
    MateriasService materiasService;

    @Autowired
    @Qualifier("sesionServiceImpl")
    private SesionService sesionService;



    //----------------------------------------------
    //
    //  MATERIAS
    //
    //----------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/{auth}", method = RequestMethod.GET)
    public List<MateriasModel> getAllMaterias(@PathVariable("auth") String token) {
        List<MateriasModel> materiasResult = new ArrayList<MateriasModel>();

        boolean validSession = sesionService.validSession(token);

        if (validSession) {
            materiasResult = materiasService.getAllMaterias();
        } else {
            MateriasModel materia = new MateriasModel();
            materiasResult.add(materia);
        }

        return materiasResult;
    }// getAllMaterias

    @CrossOrigin
    @RequestMapping(value = "/getById/{id}/{auth}", method = RequestMethod.GET)
    public MateriaModel getMateriaById(@PathVariable("id") int id, @PathVariable("auth") String token) {
        MateriaModel materia = new MateriaModel();

        boolean validSession = sesionService.validSession(token);

        if (validSession) {
            materia = materiasService.getMateriaById(id);
        } else {
            materia = new MateriaModel();

        }

        return materia;
    }// getMateriaById

    @CrossOrigin
    @RequestMapping(value = "/getByPlanId/{id}/{auth}", method = RequestMethod.GET)
    public List<MateriaModel> getMateriaByPlanId(@PathVariable("id") int id, @PathVariable("auth") String token) {
        List<MateriaModel> materias;

        boolean validSession = sesionService.validSession(token);

        if (validSession) {
            materias = materiasService.getMateriasByPlanId(id);
        } else {
            materias = new ArrayList<MateriaModel>();

        }

        return materias;
    }// getMateriaByPlanId

    @CrossOrigin
    @RequestMapping(value = "/getBySecuenciaId/{id}/{auth}", method = RequestMethod.GET)
    public List<MateriaModel> getMateriaBySecuenciaId(@PathVariable("id") int id, @PathVariable("auth") String token) {
        List<MateriaModel> materias;

        boolean validSession = sesionService.validSession(token);

        if (validSession) {
            materias = materiasService.getMateriasBySecuenciaId(id);
        } else {
            materias = new ArrayList<MateriaModel>();

        }

        return materias;
    }// getMateriaByPlanId

    // POST Materias -- save or update   new materia
    @CrossOrigin
    @RequestMapping(value = "/{auth}", consumes = "application/json", method = RequestMethod.POST)
    public MateriaModel createMateria(@PathVariable("auth") String token, @RequestBody MateriaModel element) {
        MateriaModel materiaModel = null;

        LOG.info("Actualizando y recibimos: " + element.toString());

        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {
            materiaModel = materiasService.saveMateria(element);
        } else {
            materiaModel = new MateriaModel();

        }

        LOG.info("Actualizamos y recibimos: " + materiaModel.toString());

        return materiaModel;
    } // createMateria

    // DELETE materia
    @CrossOrigin
    @RequestMapping(value = "/deleteMateria/{materiaid}/{auth}", method = RequestMethod.DELETE)
    public void deleteMateria(@PathVariable("materiaid") int materiaid, @PathVariable("auth") String token) {
        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {
            materiasService.removeMateria(materiaid);
        }
    } // deleteMateria
}
