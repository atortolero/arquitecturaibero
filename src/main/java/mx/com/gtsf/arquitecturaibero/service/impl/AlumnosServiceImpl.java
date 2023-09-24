package mx.com.gtsf.arquitecturaibero.service.impl;

import mx.com.gtsf.arquitecturaibero.component.AlumnosConverter;
import mx.com.gtsf.arquitecturaibero.entity.*;
import mx.com.gtsf.arquitecturaibero.model.*;
import mx.com.gtsf.arquitecturaibero.repository.AlumnosJpaRepository;
import mx.com.gtsf.arquitecturaibero.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("alumnosServiceImpl")
public class AlumnosServiceImpl implements AlumnosService {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(AreasServiceImpl.class);

    @Autowired
    @Qualifier("alumnosJpaRepository")
    AlumnosJpaRepository alumnosJpaRepository;

    @Autowired
    @Qualifier("semestresServiceImpl")
    SemestresService semestresService;

    @Autowired
    @Qualifier("semestreMateriasServiceImpl")
    SemestreMateriasService semestreMateriasService;

    @Autowired
    @Qualifier("materiasServiceImpl")
    MateriasService materiasService;

    @Autowired
    @Qualifier("opcionesServiceImpl")
    OpcionesService opcionesService;

    @Autowired
    @Qualifier("planesServiceImpl")
    PlanesService planesService;

    @Autowired
    @Qualifier("tipoPeriodoServiceImpl")
    TipoPeriodoService tipoPeriodoService;

    @Autowired
    @Qualifier("secuenciaFormativaServiceImpl")
    SecuenciaFormativaService secuenciaFormativaService;

    @Autowired
    @Qualifier("materiasPrerrequisitosServiceImpl")
    MateriasPrerrequisitosService materiasPrerrequisitosService;

    @Autowired
    @Qualifier("prerrequisitosServiceImpl")
    PrerrequisitosService prerrequisitosService;

    @Autowired
    @Qualifier("usuariosServiceImpl")
    UsuariosService usuariosService;

    @Autowired
    @Qualifier("alumnosCarrerasServiceImpl")
    AlumnosCarrerasService alumnosCarrerasService;

    @Autowired
    @Qualifier("carrerasServiceImpl")
    CarrerasService carrerasService;

    @Autowired
    @Qualifier("alumnosConverter")
    AlumnosConverter alumnosConverter;

    @Override
    public AlumnosModel getStudentInfo(AlumnosModel alumnosModel) {

        LOG.info("En getStudentInfo!!!!!");
        Alumnos alumno = alumnosJpaRepository.getAlumnosByNumCuenta(alumnosModel.getNumCuenta());

        // Si no existe, lo guardamos
        if(alumno == null){
            LOG.info("El alumno no existe y lo guardamos!!!");
            alumno = alumnosConverter.convertAlumnosModelToAlumnos(alumnosModel);
            alumno = this.saveAlumno(alumno);

            AlumnosCarreras alumnosCarreras = new AlumnosCarreras();

            Carreras carrera = carrerasService.getCarreraByName(alumnosModel.getCarrera());

            alumnosCarreras.setAlumnos(alumno);
            alumnosCarreras.setCarreras(carrera);

            alumnosCarreras = alumnosCarrerasService.saveAlumnosCarreras(alumnosCarreras);
        }

        List<AlumnosSemestresModel> semestresModel = new ArrayList<AlumnosSemestresModel>();

        alumnosModel = alumnosConverter.convertAlumnosToAlumnosModel(alumno);

        // Obtenemos los semestres del alumno
        LOG.info("Alumnoid en getStudentInfo: " + alumno.getAlumnoid());
        List<Semestres> semestres = semestresService.getSemestreByAlumnoid(alumno.getAlumnoid());

        // Recorrermos los semestres y para cada semestre, llenamos su información y obtenemos sus materias
        for(Semestres semestre : semestres){

            AlumnosSemestresModel semestreModel = new AlumnosSemestresModel();

            semestreModel.setAnioPeriodo(semestre.getAnioPeriodo());
            semestreModel.setFin(semestre.getFin());
            semestreModel.setPeriodo(semestre.getPeriodo());
            semestreModel.setSemestreid(semestre.getSemestreid());
            semestreModel.setSemestre(semestre.getSemestre());
            semestreModel.setStatus(semestre.getStatus());
            semestreModel.setTipoPeriodoID(semestre.getTipoPeriodo().getTipoperiodoid());

            List<AlumnosMateriasModel> materias = new ArrayList<AlumnosMateriasModel>();

            // Obtenemos las materias del semestre
            List<SemestreMaterias> semestreMaterias = semestreMateriasService.getSemestreMateriasBySemestreid(semestre.getSemestreid());

            // Recorremos las materias para obtener su información
            for(SemestreMaterias semestreMateria : semestreMaterias){

                AlumnosMateriasModel materia = new AlumnosMateriasModel();

                Materias materiaEntity = materiasService.getMateriaEntityById(semestreMateria.getMaterias().getMateriaid());

                materia.setAreaid(materiaEntity.getAreas().getAreaid());
                materia.setArea(materiaEntity.getAreas().getArea());
                materia.setMateriaid(materiaEntity.getMateriaid());
                materia.setMateria(materiaEntity.getMateria());
                materia.setClave(materiaEntity.getClave());
                materia.setColor(materiaEntity.getAreas().getColor());
                materia.setCreditos(materiaEntity.getCreditos());
                materia.setDescripcion(materiaEntity.getDescripcion());
                materia.setHoras(materiaEntity.getHoras());
                materia.setObligatoria(materiaEntity.isObligatoria());
                materia.setOpcionid(materiaEntity.getOpcionid());

                if(materiaEntity.getOpcionid() != 0){
                    Opciones opcion = opcionesService.getOpcionById(materiaEntity.getOpcionid());
                    materia.setOpcion(opcion.getOpcion());
                }
                else{
                    materia.setOpcion("");
                }

                materia.setSigla(materiaEntity.getSigla());
                materia.setSecuenciaFormativaid(materiaEntity.getSecuenciaid());

                if(materiaEntity.getSecuenciaid() != 0){
                    SecuenciaFormativa secuenciaFormativa = secuenciaFormativaService.getSecuenciaById(materiaEntity.getSecuenciaid());
                    materia.setSecuenciaFormativa(secuenciaFormativa.getSecuencia());
                }
                else{
                    materia.setSecuenciaFormativa("");
                }

                materia.setSemestreIdeal(materiaEntity.getSemestreIdeal());
                materia.setSiglas(materiaEntity.getSigla());
                materia.setStatus(semestreMateria.getStatus());

                List<AlumnosPrerrequisitosModel>  prerrequisitos = new ArrayList<AlumnosPrerrequisitosModel>();

                // Ahora obtenemos los prerrequisitos de la materia para agregarlos al arreglo del modelo del alumno
                List<MateriasPrerrequisitos> materiasPrerrequisitos = materiasPrerrequisitosService.getPrerrequisitosByMateriaid(materiaEntity.getMateriaid());

                for(MateriasPrerrequisitos materiaPrerrequisito : materiasPrerrequisitos){

                    AlumnosPrerrequisitosModel prerrequisito = new AlumnosPrerrequisitosModel();

                    Prerrequisitos prerrequisitosEntity = prerrequisitosService.getPrerrequisitoById(materiaPrerrequisito.getPrerrequisitos().getPrerrequisitoid());
                    Materias materiaEntityPrerrequisito = materiasService.getMateriaEntityById(prerrequisitosEntity.getMateriaid());

                    prerrequisito.setMateriaid(materiaEntityPrerrequisito.getMateriaid());
                    prerrequisito.setMateria(materiaEntityPrerrequisito.getMateria());
                    prerrequisito.setClave(materiaEntityPrerrequisito.getClave());

                    MateriaPrerrequisitoQuery materiaPrerrequisitoQuery = semestreMateriasService.getMateriaPrerrequisito(alumno.getAlumnoid(), materiaEntityPrerrequisito.getMateriaid());
                    if(materiaPrerrequisitoQuery != null) {
                        prerrequisito.setPeriodo(materiaPrerrequisitoQuery.getPeriodo());
                        prerrequisito.setStatus(materiaPrerrequisitoQuery.getStatus());
                    }
                    else{
                        prerrequisito.setPeriodo("");
                        prerrequisito.setStatus(0);
                    }

                    prerrequisitos.add(prerrequisito);
                }// for de prerrequisitos

                materia.setPrerrequisitos(prerrequisitos);

                materias.add(materia);
            }// for de materias

            semestreModel.setMaterias(materias);
            semestresModel.add(semestreModel);
        }// for

        alumnosModel.setSemestres(semestresModel);

        LOG.info("Saliendo de getStudentInfo con: " + alumnosModel.toString());

        return alumnosModel;
    }

    @Override
    public AlumnosModel updateSemestre(AlumnosModel alumnosModel) {

        Alumnos alumno = alumnosJpaRepository.getAlumnosByNumCuenta(alumnosModel.getNumCuenta());

        LOG.info("El alumno es: " + alumno.getAlumnoid());

        // Borramos los semestres del alumno para volverlos a actualizar con la información que nos llega el front
        // esto es porque en el front se hacen los cambios en tiempo real y el back los registra hasta que le llega
        // el request
        semestresService.removeSemestreByAlumnoid(alumno.getAlumnoid());

        // Ahora obtenemos el arreglo que recibimos y guardamos los semestres para actualizar el historial del alumno
        List<AlumnosSemestresModel> semestres = alumnosModel.getSemestres();

        // Recorremos los semestres del alumno que nos llegan actualizados desde el front
        for(AlumnosSemestresModel semestre : semestres){
            Semestres semestreEntity = new Semestres();

            semestreEntity.setAnioPeriodo(semestre.getAnioPeriodo());
            semestreEntity.setFin(semestre.getFin());
            semestreEntity.setPeriodo(semestre.getPeriodo());
            semestreEntity.setSemestre(semestre.getSemestre());
            semestreEntity.setStatus(semestre.getStatus());
            semestreEntity.setAlumnos(alumno);

            TipoPeriodo tipoPeriodo = tipoPeriodoService.getTipoPeriodoById(semestre.getTipoPeriodoID());
            semestreEntity.setTipoPeriodo(tipoPeriodo);

            // Guardamos cada uno de los semestres que nos llegan del front
            semestreEntity = semestresService.saveSemestre(semestreEntity);

            // Obtenemos las materias que llevó en cada semestre
            List<AlumnosMateriasModel> materias = semestre.getMaterias();

            // Recorremos la materias de cada semestre para volverlas a guardar en el back
            for(AlumnosMateriasModel materia : materias){

                SemestreMaterias semestreMaterias = new SemestreMaterias();

                Materias materiaEntity = materiasService.getMateriaEntityById(materia.getMateriaid());

                semestreMaterias.setMaterias(materiaEntity);
                semestreMaterias.setSemestres(semestreEntity);
                semestreMaterias.setStatus(materia.getStatus());

                // Guardamos cada una de las materias de cada semestre
                semestreMateriasService.saveSemestreMaterias(semestreMaterias);

                // Obtenemos los prerrequisitos de cada materia
                List<AlumnosPrerrequisitosModel> prerrequisitos = materia.getPrerrequisitos();

                // Recorremos los prerrequisitos para obtener su status
                for(AlumnosPrerrequisitosModel prerrequisito : prerrequisitos){

                    try{
                        int statusPrerrequisito = semestreMateriasService.getStatusPrerrequisito(alumno.getAlumnoid(), prerrequisito.getMateriaid());
                        prerrequisito.setStatus(statusPrerrequisito);
                    }catch (Exception e){
                        LOG.info("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
                        LOG.info("En el catch!!!!!!");
                        LOG.info("Con: alumnoid: " + alumno.getAlumnoid() + " y materiaid: " + prerrequisito.getMateriaid() + " y semestreid: " + semestreEntity.getSemestreid());
                        LOG.info(" " + e.toString());
                        prerrequisito.setStatus(0);
                        LOG.info("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
                    }
                }

            }
        }

        return alumnosModel;
    }

    @Override
    public AlumnosSemestresModel updateFirstSemester(AlumnosSemestresModel alumnosModel) {

        LOG.info("Usuarioid: " + alumnosModel.getUserID());
        LOG.info("Recibimos: " + alumnosModel.toString());
        Alumnos alumno = null;

        try {
            // Si no existe el usuario quiere decir que lo que nos llegó fue un alumno válido de la autenticación de CCA
            Usuarios usuario = usuariosService.getUserById(alumnosModel.getUserID());
            alumno = alumnosJpaRepository.getAlumnosByAlumnoid(usuario.getAlumnoid());
        }catch(Exception e){
            alumno = alumnosJpaRepository.getAlumnosByNumCuenta("" + alumnosModel.getUserID());
        }

        // Actualizamos el plan del alumno
        Planes plan = planesService.getPlanesEntityById(alumnosModel.getPlanID());
        alumno.setPlanes(plan);
        alumno.setAnioInicio(alumnosModel.getAnioPeriodo());

        // Actualizamos el periodo de inicio del alumno
        TipoPeriodo periodo = tipoPeriodoService.getTipoPeriodoById(alumnosModel.getTipoPeriodoID());
        alumno.setTipoPeriodo(periodo);

        alumno = this.saveAlumno(alumno);

        try{
            LOG.info("El alumno es: " + alumno.getAlumnoid() + " y nombre: " + alumno.getNombre() + " nocuenta: " + alumno.getNumCuenta());
        }catch(Exception e){
            LOG.info("El alumno es null");
        }

        // Borramos los semestres del alumno
        LOG.info("Borrando semestres");
        semestresService.removeSemestreByAlumnoid(alumno.getAlumnoid());
        LOG.info("Semestres borrados");


        Semestres semestreEntity = new Semestres();

        semestreEntity.setAnioPeriodo(alumnosModel.getAnioPeriodo());
        semestreEntity.setFin(alumnosModel.getFin());
        semestreEntity.setPeriodo(alumnosModel.getPeriodo());
        semestreEntity.setSemestre(alumnosModel.getSemestre());
        semestreEntity.setStatus(alumnosModel.getStatus());
        semestreEntity.setAlumnos(alumno);

        TipoPeriodo tipoPeriodo = tipoPeriodoService.getTipoPeriodoById(alumnosModel.getTipoPeriodoID());
        semestreEntity.setTipoPeriodo(tipoPeriodo);

        LOG.info("Guardando semestre con: " + alumno.getAlumnoid());
        semestreEntity = semestresService.saveSemestre(semestreEntity);
        LOG.info("Semestre guardado");

        alumnosModel.setSemestreid(semestreEntity.getSemestreid());


        return alumnosModel;
    }

    @Override
    public Alumnos getAlumnoById(long alumnoid) {
        Alumnos alumno = alumnosJpaRepository.getAlumnosByAlumnoid(alumnoid);
        return alumno;
    }

    @Override
    public Alumnos saveAlumno(Alumnos alumno) {
        alumno = alumnosJpaRepository.save(alumno);
        return alumno;
    }
}
