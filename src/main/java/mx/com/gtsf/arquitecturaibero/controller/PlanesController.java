package mx.com.gtsf.arquitecturaibero.controller;

import mx.com.gtsf.arquitecturaibero.model.PlanModel;
import mx.com.gtsf.arquitecturaibero.model.PlanesModel;
import mx.com.gtsf.arquitecturaibero.service.PlanesService;
import mx.com.gtsf.arquitecturaibero.service.SesionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/planes")
public class PlanesController {

    /**
     * The Constant LOG.
     */
    private static final Log LOG = LogFactory.getLog(PlanesController.class);

    @Autowired
    @Qualifier("planesServiceImpl")
    PlanesService planesService;

    @Autowired
    @Qualifier("sesionServiceImpl")
    private SesionService sesionService;

    //----------------------------------------------
    //
    //  PLANES
    //
    //----------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/{auth}", method = RequestMethod.GET)
    public List<PlanesModel> getAllPlanes(@PathVariable("auth") String token) {
        List<PlanesModel> planesResult = new ArrayList<PlanesModel>();

        boolean validSession = sesionService.validSession(token);

        if (validSession) {
            planesResult = planesService.getAllPlanes();
        } else {
            PlanesModel plan = new PlanesModel();
            planesResult.add(plan);
        }

        return planesResult;
    }// getAllPlanes

    @CrossOrigin
    @RequestMapping(value = "/getById/{id}/{auth}", method = RequestMethod.GET)
    public PlanModel getPlanById(@PathVariable("id") int id, @PathVariable("auth") String token) {
        PlanModel plan = new PlanModel();

        boolean validSession = sesionService.validSession(token);

        if (validSession) {
            plan = planesService.getPlanesById(id);
        } else {
            plan = new PlanModel();

        }

        return plan;
    }// getAllPlanes


    // POST Planes -- save or update   new plan
    @CrossOrigin
    @RequestMapping(value = "/{auth}", consumes = "application/json", method = RequestMethod.POST)
    public PlanModel createPlan(@PathVariable("auth") String token, @RequestBody PlanModel element) {
        PlanModel planModel = null;
        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {
                planModel = planesService.savePlan(element);
        } else {
            planModel = new PlanModel();

        }
        return planModel;
    } // createPlan

    // DELETE plan
    @CrossOrigin
    @RequestMapping(value = "/deletePlan/{planid}/{auth}", method = RequestMethod.DELETE)
    public void deletePlan(@PathVariable("planid") int planid, @PathVariable("auth") String token) {
        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {
            planesService.removePlan(planid);
        }
    } // deletePlan

}
