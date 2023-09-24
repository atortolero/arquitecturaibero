package mx.com.gtsf.arquitecturaibero.component;

import mx.com.gtsf.arquitecturaibero.entity.*;
import mx.com.gtsf.arquitecturaibero.model.AlumnosModel;
import mx.com.gtsf.arquitecturaibero.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("alumnosConverter")
public class AlumnosConverter {

    @Autowired
    @Qualifier("planesServiceImpl")
    PlanesService planesService;

    @Autowired
    @Qualifier("tipoPeriodoServiceImpl")
    TipoPeriodoService tipoPeriodoService;

    @Autowired
    @Qualifier("semestresServiceImpl")
    SemestresService semestresService;

    @Autowired
    @Qualifier("alumnosCarrerasServiceImpl")
    AlumnosCarrerasService alumnosCarrerasService;

    @Autowired
    @Qualifier("carrerasServiceImpl")
    CarrerasService carrerasService;

    public Alumnos convertAlumnosModelToAlumnos(AlumnosModel model){

        Alumnos alumno = new Alumnos();

        alumno.setNombre(model.getNombre());
        alumno.setApPaterno("");
        alumno.setApMaterno("");
        alumno.setNumCuenta(model.getNumCuenta());
        alumno.setAnioInicio(model.getAnioInicio());

        Planes plan = planesService.getPlanesEntityById(model.getPlanid());
        alumno.setPlanes(plan);

        TipoPeriodo tipoPeriodo = tipoPeriodoService.getTipoPeriodoById(model.getPeriodoInicioID());
        alumno.setTipoPeriodo(tipoPeriodo);

        return alumno;
    }

    public AlumnosModel convertAlumnosToAlumnosModel(Alumnos alumno){
        AlumnosModel model = new AlumnosModel();

        model.setNombre(alumno.getNombre());
        model.setApPaterno(alumno.getApPaterno());
        model.setApMaterno(alumno.getApMaterno());
        model.setTipoid(2); // tipoid = 2 es para alumnos

        AlumnosCarreras alumnosCarreras = alumnosCarrerasService.getCarrerasByAlumnoid(alumno.getAlumnoid());
        Carreras carrera = carrerasService.getCarreraByid(alumnosCarreras.getCarreras().getCarreraid());
        model.setCarrera(carrera.getCarrera());

        model.setNumCuenta(alumno.getNumCuenta());
        model.setPeriodoInicioID(alumno.getTipoPeriodo().getTipoperiodoid());
        model.setAnioInicio(alumno.getAnioInicio());
        model.setPlanid(alumno.getPlanes().getPlanid());

        // Obtenemos el semestre actual del alumno
//        try {
//            Semestres semestreActual = semestresService.findLastSemestreByAlumnoid(alumno.getAlumnoid());
//            model.setSemestre(semestreActual.getSemestre());
//        }catch(Exception e){
//            model.setSemestre("1");
//        }

        return model;
    }
}
