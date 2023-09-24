package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.component.MateriasConverter;
import mx.com.gtsf.arquitecturaibero.entity.Materias;
import mx.com.gtsf.arquitecturaibero.entity.MateriasPrerrequisitos;
import mx.com.gtsf.arquitecturaibero.entity.Prerrequisitos;
import mx.com.gtsf.arquitecturaibero.model.MateriaModel;
import mx.com.gtsf.arquitecturaibero.model.MateriasModel;
import mx.com.gtsf.arquitecturaibero.model.PrerrequisitosModel;
import mx.com.gtsf.arquitecturaibero.repository.MateriasJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.MateriasPrerrequisitosService;
import mx.com.gtsf.arquitecturaibero.service.MateriasService;
import mx.com.gtsf.arquitecturaibero.service.PrerrequisitosService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("materiasServiceImpl")
public class MateriasServiceImpl implements MateriasService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(MateriasServiceImpl.class);

    @Autowired
    @Qualifier("materiasJpaRepository")
    MateriasJpaRepository materiasJpaRepository;

    @Autowired
    @Qualifier("materiasConverter")
    MateriasConverter materiasConverter;

    @Autowired
    @Qualifier("materiasPrerrequisitosServiceImpl")
    MateriasPrerrequisitosService materiasPrerrequisitosService;

    @Autowired
    @Qualifier("prerrequisitosServiceImpl")
    PrerrequisitosService prerrequisitosService;

    @Override
    public List<MateriasModel> getAllMaterias() {
        List<MateriasModel> materiasModel = new ArrayList<MateriasModel>();

        List<Materias> materias = materiasJpaRepository.findAllByOrderByMateria();

        for(Materias materia: materias){
            MateriasModel model = materiasConverter.convertMateriasToMateriasModel(materia);

            materiasModel.add(model);
        }
        return materiasModel;
    }

    @Override
    public MateriaModel getMateriaById(long materiaid) {

        Materias materia = materiasJpaRepository.findAllByMateriaid(materiaid);

        MateriaModel model = materiasConverter.convertMateriasToMateriaModel(materia);

        List<PrerrequisitosModel> prerrequisitosAux = model.getPrerrequisitos();

        List<PrerrequisitosModel> prerrequisitos = new ArrayList<PrerrequisitosModel>();

        for(PrerrequisitosModel prerrequisitosModel: prerrequisitosAux){
            Materias materiaAux = this.getMateriaEntityById(prerrequisitosModel.getMateriaid());

            prerrequisitosModel.setMateria(materiaAux.getMateria());
            prerrequisitosModel.setClave(materiaAux.getClave());

            prerrequisitos.add(prerrequisitosModel);

        }

        model.setPrerrequisitos(prerrequisitos);

        //LOG.info("Regresamos: " + model.toString());
        return model;
    }

    @Override
    public Materias getMateriaEntityById(long materiaid) {
        Materias materia = materiasJpaRepository.findAllByMateriaid(materiaid);

        return materia;
    }

    @Override
    public List<MateriaModel> getMateriasByPlanId(long planid) {
        List<Materias> materias = materiasJpaRepository.findAllByPlanes_Planid(planid);

        List<MateriaModel> materiasModel = new ArrayList<MateriaModel>();

        for(Materias materia: materias){
            MateriaModel model = materiasConverter.convertMateriasToMateriaModel(materia);

            List<PrerrequisitosModel> prerrequisitosAux = model.getPrerrequisitos();

            List<PrerrequisitosModel> prerrequisitos = new ArrayList<PrerrequisitosModel>();

            for(PrerrequisitosModel prerrequisitosModel: prerrequisitosAux){
                Materias materiaAux = this.getMateriaEntityById(prerrequisitosModel.getMateriaid());

                prerrequisitosModel.setMateria(materiaAux.getMateria());
                prerrequisitosModel.setClave(materiaAux.getClave());

                prerrequisitos.add(prerrequisitosModel);

            }

            model.setPrerrequisitos(prerrequisitos);

            materiasModel.add(model);
        }
        return materiasModel;
    }

    @Override
    public List<MateriaModel> getMateriasBySecuenciaId(long secuenciaid) {
        List<Materias> materias = materiasJpaRepository.findAllBySecuenciaid(secuenciaid);

        List<MateriaModel> materiasModel = new ArrayList<MateriaModel>();

        for(Materias materia: materias){
            MateriaModel model = materiasConverter.convertMateriasToMateriaModel(materia);


            List<PrerrequisitosModel> prerrequisitosAux = model.getPrerrequisitos();

            List<PrerrequisitosModel> prerrequisitos = new ArrayList<PrerrequisitosModel>();

            for(PrerrequisitosModel prerrequisitosModel: prerrequisitosAux){
                Materias materiaAux = this.getMateriaEntityById(prerrequisitosModel.getMateriaid());

                prerrequisitosModel.setMateria(materiaAux.getMateria());
                prerrequisitosModel.setClave(materiaAux.getClave());

                prerrequisitos.add(prerrequisitosModel);

            }

            model.setPrerrequisitos(prerrequisitos);

            materiasModel.add(model);
        }
        return materiasModel;
    }

    @Transactional
    @Override
    public MateriaModel saveMateria(MateriaModel materiaModel) {

        // Primero guardamos la materia

        //LOG.info("En saveMateria y obtenemos: " + materiaModel.toString());

        Materias materia = materiasConverter.convertMateriaModelToMaterias(materiaModel);
        materia = materiasJpaRepository.save(materia);

        // ----------------------------------------------------------------------------------------
        // Ahora borramos los prerrequisitos para volverlos a agregar
        // ----------------------------------------------------------------------------------------
        // Primero borramos los registros de los prerrequisitos de la materia en cuestión
        List<MateriasPrerrequisitos> materiasPrerrequisitos = materiasPrerrequisitosService.getPrerrequisitosByMateriaid(materiaModel.getMateriaid());
        for(MateriasPrerrequisitos materiaPrerrequisito : materiasPrerrequisitos){
            prerrequisitosService.removePrerrequisito(materiaPrerrequisito.getPrerrequisitos().getPrerrequisitoid());
        }

        // Ahora borramos los registros de materiasprerrequisitos
        materiasPrerrequisitosService.removeMateriasPrerrequisitosByMateriaid(materiaModel.getMateriaid());

        // Ahora obtenemos los prerrequisitos del modelo para volverlos a agregar
        List<PrerrequisitosModel> prerrequisitos = materiaModel.getPrerrequisitos();
        for(PrerrequisitosModel prerrequisitoModel : prerrequisitos){

            Prerrequisitos prerrequisito = prerrequisitosService.addPrerrequisito(prerrequisitoModel);

            MateriasPrerrequisitos materiasPrerrequisitosentity = new MateriasPrerrequisitos();
            materiasPrerrequisitosentity.setMaterias(materia);
            materiasPrerrequisitosentity.setPrerrequisitos(prerrequisito);

            materiasPrerrequisitosentity = materiasPrerrequisitosService.addMateriasPrerrequisitos(materiasPrerrequisitosentity);
        }

        materiaModel = materiasConverter.convertMateriasToMateriaModel(materia);

        List<PrerrequisitosModel> prerrequisitosAux = materiaModel.getPrerrequisitos();

        List<PrerrequisitosModel> prerrequisitosModel = new ArrayList<PrerrequisitosModel>();

        for(PrerrequisitosModel prerrequisitosModelAux: prerrequisitosAux){
            Materias materiaAux = this.getMateriaEntityById(prerrequisitosModelAux.getMateriaid());

            prerrequisitosModelAux.setMateria(materiaAux.getMateria());
            prerrequisitosModelAux.setClave(materiaAux.getClave());

            prerrequisitosModel.add(prerrequisitosModelAux);

        }

        materiaModel.setPrerrequisitos(prerrequisitosModel);

        return materiaModel;
    }

    @Transactional
    @Override
    public int removeMateria(long materiaid) {

        // Primero borramos los registros de los prerrequisitos de la materia en cuestión
        List<MateriasPrerrequisitos> materiasPrerrequisitos = materiasPrerrequisitosService.getPrerrequisitosByMateriaid(materiaid);
        for(MateriasPrerrequisitos materiaPrerrequisito : materiasPrerrequisitos){
            prerrequisitosService.removePrerrequisito(materiaPrerrequisito.getPrerrequisitos().getPrerrequisitoid());
        }

        // Ahora borramos los registros de materiasprerrequisitos
        materiasPrerrequisitosService.removeMateriasPrerrequisitosByMateriaid(materiaid);

        // Ahora borramos la materia
        materiasJpaRepository.deleteById(materiaid);
        return 0;
    }
}
