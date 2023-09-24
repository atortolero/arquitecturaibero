package mx.com.gtsf.arquitecturaibero.component;

import mx.com.gtsf.arquitecturaibero.entity.Planes;
import mx.com.gtsf.arquitecturaibero.entity.SecuenciaFormativa;
import mx.com.gtsf.arquitecturaibero.model.PlanModel;
import mx.com.gtsf.arquitecturaibero.model.PlanesModel;
import mx.com.gtsf.arquitecturaibero.model.SecuenciasFormativasModel;
import mx.com.gtsf.arquitecturaibero.service.SecuenciaFormativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("planesConverter")
public class PlanesConverter {

    @Autowired
    @Qualifier("secuenciaFormativaServiceImpl")
    SecuenciaFormativaService secuenciaFormativaService;

    @Autowired
    @Qualifier("secuenciasFormativasConverter")
    SecuenciasFormativasConverter secuenciasFormativasConverter;

    public PlanesModel convertPlanesToPlanesModel(Planes plan){
        PlanesModel model = new PlanesModel();

        model.setPlanid(plan.getPlanid());
        model.setPlan(plan.getNombre());
        model.setAnioInicio(plan.getAnioInicio());
        model.setPeriodoInicioid(plan.getPeriodoInicioid());

        return model;
    }

    public PlanModel convertPlanesToPlanModel(Planes plan){
        PlanModel model = new PlanModel();

        model.setPlanid(plan.getPlanid());
        model.setNombrePlan(plan.getNombre());
        model.setAnioInicio(plan.getAnioInicio());
        model.setPeriodoInicioid(plan.getPeriodoInicioid());
        model.setNumOptativas(plan.getNumeroOptativas());
        model.setCreditos(plan.getCreditos());
        model.setCreditosObligatorias(plan.getCreditosObligatorias());
        model.setCreditosOptativas(plan.getCreditosOptativas());
        model.setPdf(plan.getPdf());

        List<SecuenciasFormativasModel> listSecuenciasFormativasModel = new ArrayList<SecuenciasFormativasModel>();

        List<SecuenciaFormativa> secuenciasFormativas = secuenciaFormativaService.getSecuenciasbyPlanid(plan.getPlanid());
        if(secuenciasFormativas != null){
            for(SecuenciaFormativa secuenciaFormativa: secuenciasFormativas){
                SecuenciasFormativasModel modelSecuenciasFormativas = secuenciasFormativasConverter.convertSecuenciasFormativasToSecuenciasFormativasModel(secuenciaFormativa);

                listSecuenciasFormativasModel.add(modelSecuenciasFormativas);
            }
        }
        else{
            SecuenciasFormativasModel modelSecuenciasFormativas = new SecuenciasFormativasModel();
            listSecuenciasFormativasModel.add(modelSecuenciasFormativas);
        }

        model.setSecuenciasFormativas(listSecuenciasFormativasModel);

        return model;
    }

    public Planes convertPlanesModelToPlanes(PlanModel model){
        Planes plan = new Planes();

        if(model.getPlanid() > 0){
            plan.setPlanid(model.getPlanid());
        }

        plan.setNombre(model.getNombrePlan());
        plan.setAnioInicio(model.getAnioInicio());
        plan.setPeriodoInicioid(model.getPeriodoInicioid());
        plan.setNumeroOptativas(model.getNumOptativas());
        plan.setCreditos(model.getCreditos());
        plan.setCreditosObligatorias(model.getCreditosObligatorias());
        plan.setCreditosOptativas(model.getCreditosOptativas());

        return plan;
    }
}
