package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.component.OpcionesConverter;
import mx.com.gtsf.arquitecturaibero.component.PlanesConverter;
import mx.com.gtsf.arquitecturaibero.component.SecuenciasFormativasConverter;
import mx.com.gtsf.arquitecturaibero.entity.Opciones;
import mx.com.gtsf.arquitecturaibero.entity.Planes;
import mx.com.gtsf.arquitecturaibero.entity.SecuenciaFormativa;
import mx.com.gtsf.arquitecturaibero.model.OpcionesModel;
import mx.com.gtsf.arquitecturaibero.model.PlanModel;
import mx.com.gtsf.arquitecturaibero.model.PlanesModel;
import mx.com.gtsf.arquitecturaibero.model.SecuenciasFormativasModel;
import mx.com.gtsf.arquitecturaibero.repository.PlanesJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.OpcionesService;
import mx.com.gtsf.arquitecturaibero.service.PlanesService;
import mx.com.gtsf.arquitecturaibero.service.SecuenciaFormativaService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("planesServiceImpl")
public class PlanesServiceImpl implements PlanesService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(PlanesServiceImpl.class);

    @Autowired
    @Qualifier("planesJpaRepository")
    PlanesJpaRepository planesJpaRepository;

    @Autowired
    @Qualifier("planesConverter")
    PlanesConverter planesConverter;

    @Autowired
    @Qualifier("secuenciasFormativasConverter")
    SecuenciasFormativasConverter secuenciasFormativasConverter;

    @Autowired
    @Qualifier("secuenciaFormativaServiceImpl")
    SecuenciaFormativaService secuenciaFormativaService;

    @Autowired
    @Qualifier("opcionesConverter")
    OpcionesConverter opcionesConverter;

    @Autowired
    @Qualifier("opcionesServiceImpl")
    OpcionesService opcionesService;


    @Override
    public List<PlanesModel> getAllPlanes() {
        List<PlanesModel> planesModel = new ArrayList<PlanesModel>();

        List<Planes> planes = planesJpaRepository.findAllByPlanidIsNotOrderByNombre(100); // 100 es un plan indefinido

        for(Planes plan: planes){
            PlanesModel model = planesConverter.convertPlanesToPlanesModel(plan);

            planesModel.add(model);
        }
        return planesModel;
    }

    @Override
    public PlanModel getPlanesById(long planid) {

        Planes plan = planesJpaRepository.findByPlanid(planid);

        PlanModel planModel = planesConverter.convertPlanesToPlanModel(plan);
        return planModel;
    }

    @Override
    public Planes getPlanesEntityById(long planid) {
        Planes plan = planesJpaRepository.findByPlanid(planid);

        return plan;
    }

    @Transactional
    @Override
    public PlanModel savePlan(PlanModel model) {

        LOG.info("En savePlan y recibimos: " +model.toString());

        // Primero guardamos el plan
        Planes plan = planesConverter.convertPlanesModelToPlanes(model);
        plan = planesJpaRepository.save(plan);

        // Obtenemos las secuencias formativas que actualmente tiene el plan para ver si cambiaron o no
        List<SecuenciaFormativa> secuenciasFormativasActuales = secuenciaFormativaService.getSecuenciasbyPlanid(model.getPlanid());

        // Obtenemos las secuencias formativas del plan que se está modificando
        List<SecuenciasFormativasModel> secuenciasFormativas = model.getSecuenciasFormativas();

        // Primero recorremos las secuencias formativas actuales para ver si hay alguna que ya se haya eliminado con la actualización del plan
        // Si ya no está, la borramos
        int siEstaLaSecuencia = 0;
        for(SecuenciaFormativa secuencia : secuenciasFormativasActuales){
            siEstaLaSecuencia = 0;
            for(SecuenciasFormativasModel secuenciasFormativasModel : secuenciasFormativas){
                if(secuencia.getSecuenciaid() == secuenciasFormativasModel.getSecuenciaid()){
                    siEstaLaSecuencia = 1;
                    break;
                }
            }
            // Si no está la secuencia en el plan que llegó modificado
            // la borramos
            if(siEstaLaSecuencia == 0){
                secuenciaFormativaService.removeSecuenciaFormativa(secuencia.getSecuenciaid());
            }
        }

        // Ahora guardamos las secuencias formativas y las opciones del plan que se está modificando
        for(SecuenciasFormativasModel secuenciasFormativasModel : secuenciasFormativas){
            SecuenciaFormativa secuenciaFormativa = secuenciasFormativasConverter.convertSecuenciasFormativasModelToSecuenciasFormativas(secuenciasFormativasModel);

            secuenciaFormativa.setPlanes(plan);
            try {
                secuenciaFormativa = secuenciaFormativaService.saveSecuenciaFormativa(secuenciaFormativa);
            }catch(Exception e){
                LOG.info("Error al guardar la secuencia formativa al actualizar el plan");
            }

            // Obtenemos las opciones de cada una de las secuencias formativas
            List<OpcionesModel> opciones = secuenciasFormativasModel.getOpciones();
            for(OpcionesModel opcionModel: opciones){

                Opciones opcion = opcionesConverter.convertOpcionesModelToOpciones(opcionModel);

                opcion.setSecuenciaFormativa(secuenciaFormativa);

                try {
                    opcion = opcionesService.saveOpcion(opcion);
                }catch(Exception e){
                    LOG.info("Error al guardar la opción de la secuencia formativa al actualizar el plan");
                }
            }// for de opciones
        }// for de secuencias formativas

        model = planesConverter.convertPlanesToPlanModel(plan);

        return model;
    }

    @Transactional
    @Override
    public int removePlan(long planid) {

        planesJpaRepository.deleteById(planid);
        return 0;
    }
}
