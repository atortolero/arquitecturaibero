package mx.com.gtsf.arquitecturaibero.component;

import mx.com.gtsf.arquitecturaibero.entity.*;
import mx.com.gtsf.arquitecturaibero.model.MateriaModel;
import mx.com.gtsf.arquitecturaibero.model.MateriasModel;
import mx.com.gtsf.arquitecturaibero.model.PlanModel;
import mx.com.gtsf.arquitecturaibero.model.PrerrequisitosModel;
import mx.com.gtsf.arquitecturaibero.service.*;
import mx.com.gtsf.arquitecturaibero.service.impl.AreasServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("materiasConverter")
public class MateriasConverter {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(MateriasConverter.class);

    @Autowired
    @Qualifier("materiasPrerrequisitosServiceImpl")
    MateriasPrerrequisitosService materiasPrerrequisitosService;

    @Autowired
    @Qualifier("prerrequisitosServiceImpl")
    PrerrequisitosService prerrequisitosService;

    @Autowired
    @Qualifier("areasServiceImpl")
    AreasService areasService;

    @Autowired
    @Qualifier("secuenciaFormativaServiceImpl")
    SecuenciaFormativaService secuenciaFormativaService;

    @Autowired
    @Qualifier("planesServiceImpl")
    PlanesService planesService;

    @Autowired
    @Qualifier("opcionesServiceImpl")
    OpcionesService opcionesService;


    public MateriasModel convertMateriasToMateriasModel(Materias materia){
        MateriasModel model = new MateriasModel();

        model.setMateriaid(materia.getMateriaid());
        model.setMateria(materia.getMateria());
        model.setClave(materia.getClave());
        model.setSigla(materia.getSigla());

        return model;
    }

    public MateriaModel convertMateriasToMateriaModel(Materias materia){
        MateriaModel materiaModel = new MateriaModel();

        List<PrerrequisitosModel> prerrequisitos = new ArrayList<PrerrequisitosModel>();

        materiaModel.setMateriaid(materia.getMateriaid());
        materiaModel.setMateria(materia.getMateria());
        materiaModel.setClave(materia.getClave());
        materiaModel.setSigla(materia.getSigla());
        materiaModel.setCreditos(materia.getCreditos());
        materiaModel.setHoras(materia.getHoras());
        materiaModel.setSemestreIdeal(materia.getSemestreIdeal());
        materiaModel.setObligatoria(materia.isObligatoria());
        materiaModel.setAreaid(materia.getAreas().getAreaid());
        materiaModel.setArea(materia.getAreas().getArea());
        materiaModel.setSecuenciaFormativaid(materia.getSecuenciaid());
        materiaModel.setOpcionid(materia.getOpcionid());
        materiaModel.setDescripcion(materia.getDescripcion());
        materiaModel.setPlanid(materia.getPlanes().getPlanid());
        materiaModel.setVerano(materia.isVerano());

        try {
            SecuenciaFormativa secuenciaFormativa = secuenciaFormativaService.getSecuenciaById(materia.getSecuenciaid());
            materiaModel.setSecuenciaFormativa(secuenciaFormativa.getSecuencia());
        }catch(Exception e){
            materiaModel.setSecuenciaFormativa("");
        }

        try {
            Opciones opcion = opcionesService.getOpcionById(materia.getOpcionid());
            materiaModel.setOpcion(opcion.getOpcion());
        }catch(Exception e){
            materiaModel.setOpcion("");
        }

        List<MateriasPrerrequisitos> materiasPrerrequisito = materiasPrerrequisitosService.getPrerrequisitosByMateriaid(materia.getMateriaid());
        if(materiasPrerrequisito != null){
            for(MateriasPrerrequisitos materiaPrerrequisito: materiasPrerrequisito){

                Prerrequisitos prerrequisito = prerrequisitosService.getPrerrequisitoById(materiaPrerrequisito.getPrerrequisitos().getPrerrequisitoid());

                PrerrequisitosModel model = new PrerrequisitosModel();

                if(prerrequisito != null) {
                    model.setMateriaid(prerrequisito.getMateriaid());
                }

                prerrequisitos.add(model);
            }
        }

        materiaModel.setPrerrequisitos(prerrequisitos);
        return materiaModel;
    }

    public Materias convertMateriaModelToMaterias(MateriaModel model){
        Materias materia = new Materias();

        if(model.getMateriaid() > 0){
            materia.setMateriaid(model.getMateriaid());
        }

        //LOG.info("En convert y recivimos: " + model.toString());

        materia.setMateria(model.getMateria());
        materia.setClave(model.getClave());
        materia.setSigla(model.getSigla());
        materia.setCreditos(model.getCreditos());
        materia.setHoras(model.getHoras());
        materia.setSemestreIdeal(model.getSemestreIdeal());
        materia.setObligatoria(model.isObligatoria());
        materia.setDescripcion(model.getDescripcion());
        materia.setSecuenciaid(model.getSecuenciaFormativaid());
        materia.setOpcionid(model.getOpcionid());
        materia.setVerano(model.isVerano());

        Areas area = areasService.getAreaById(model.getAreaid());
        materia.setAreas(area);

        Planes plan = planesService.getPlanesEntityById(model.getPlanid());
        materia.setPlanes(plan);

        //LOG.info("Antes de salir y obligatoria: " + materia.isObligatoria());

        return materia;
    }
}
