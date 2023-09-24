package mx.com.gtsf.arquitecturaibero.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.com.gtsf.arquitecturaibero.component.CurrentDateGenerator;
import mx.com.gtsf.arquitecturaibero.component.PasswordEncrypt;
import mx.com.gtsf.arquitecturaibero.component.UsuariosConverter;
import mx.com.gtsf.arquitecturaibero.entity.*;
import mx.com.gtsf.arquitecturaibero.model.*;
import mx.com.gtsf.arquitecturaibero.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    /**
     * The Constant LOG.
     */
    private static final Log LOG = LogFactory.getLog(UsuariosController.class);

    /**
     * The service
     **/
    @Autowired
    @Qualifier("usuariosServiceImpl")
    private UsuariosService usuariosService;

    @Autowired
    @Qualifier("sesionServiceImpl")
    private SesionService sesionService;

    @Autowired
    @Qualifier("alumnosServiceImpl")
    AlumnosService alumnosService;

    @Autowired
    @Qualifier("usuariosConverter")
    private UsuariosConverter usuariosConverter;

    @Autowired
    @Qualifier("passwordEncrypt")
    PasswordEncrypt passwordEncrypt;

    @Autowired
    @Qualifier("currentDateGenerator")
    CurrentDateGenerator currentDateGenerator;

    @Autowired
    @Qualifier("semestresServiceImpl")
    SemestresService semestresService;

    @Autowired
    @Qualifier("alumnosCarrerasServiceImpl")
    AlumnosCarrerasService alumnosCarrerasService;

    @Autowired
    @Qualifier("carrerasServiceImpl")
    CarrerasService carrerasService;

    //----------------------------------------------
    //
    //  LOGIN PROCESS
    //
    //----------------------------------------------

    @CrossOrigin   //loginAlumnos
    @RequestMapping(value = "/logIN/", method = RequestMethod.POST)
    public String logIN(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        String alumnosLoginModel;

        LOG.info("En autenticación CCA...");

        String uri = "https://apps.alumnos.uia/api/auth/index.php?usuario="+username+"&password="+pwd;

        RestTemplate restTemplate = new RestTemplate();
        alumnosLoginModel = restTemplate.getForObject(uri, String.class);

        ////alumnosLoginModel = "{\"estatus\":-2,\"mensaje\":\"LLAMADA INVALIDA\",\"datos\":\"\"}";
        ////alumnosLoginModel = "{\"estatus\":1,\"mensaje\":\"ACCESO VALIDO\",\"datos\":{\"nombre\":\"RANGEL PANTOJA, EVELYN VIRIDIANA\",\"carrera\":\"ARQUITECTURA\"}}";

        LOG.info("Regresamos: " + alumnosLoginModel);

        return alumnosLoginModel;
    }// login

    @CrossOrigin
    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public UsuariosModel login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        Usuarios usuario;
        UsuariosModel usrModel;

        usuario = usuariosService.getUserByEmail(username);

        if (usuario != null) {

            //LOG.info("Usuario es diferente de NULL:");

            long tipoUsuario = usuario.getTipoUsuario().getTipoid();

            String password = usuario.getPassword();

            String passEncrypt = passwordEncrypt.getMD5(pwd);

            //LOG.info("Password Encriptado: \"" + passEncrypt + "\"");

            if (password.equals(passEncrypt)) {

                //LOG.info("El password está bien");

                TokenModel tokenModel = getJWTToken(username);

                usrModel = usuariosConverter.convertUsuariosToUsuariosModel(usuario);

                usrModel.setToken(tokenModel.getToken());
                usrModel.setExpiresin(tokenModel.getExpiresin());

                if(tipoUsuario == 2){
                    //LOG.info("Es alumno");
                    Alumnos alumno = alumnosService.getAlumnoById(usuario.getAlumnoid());
                    Semestres semestre = null;
                    AlumnosCarreras alumnosCarreras = null;
                    Carreras carrera = null;
                    if(alumno != null) {
                        semestre = semestresService.findLastSemestreByAlumnoid(alumno.getAlumnoid());
                        alumnosCarreras = alumnosCarrerasService.getCarrerasByAlumnoid(alumno.getAlumnoid());
                    }
//                    else{
//                        LOG.info("alumno es null");
//                    }

                    if(alumnosCarreras != null) {
                        carrera = carrerasService.getCarreraByid(alumnosCarreras.getCarreras().getCarreraid());
                    }
//                    else{
//                        LOG.info("alumnosCarreras es null");
//                    }

                    try {
                        usrModel.setCarrera(carrera.getCarrera());
                    }catch(Exception e){
                        usrModel.setCarrera("");
                        //LOG.info("No se puede encontrar la carrera");
                    }

                    try {
                        usrModel.setNumCuenta(alumno.getNumCuenta());
                    }catch(Exception e){
                        usrModel.setNumCuenta("");
                        //LOG.info("No hay número de cuenta");
                    }

                    try {
                        usrModel.setPeriodoInicioid(alumno.getTipoPeriodo().getTipoperiodoid());
                    }catch(Exception e){
                        usrModel.setPeriodoInicioid(100);
                        //LOG.info("no se puede poner el periodoinicioid");
                    }

                    try {
                        usrModel.setAnioInicio(alumno.getAnioInicio());
                    }catch(Exception e){
                        usrModel.setAnioInicio(0);
                        //LOG.info("no se puede poner el anioinicio");
                    }

                    try {
                        usrModel.setSemestre("" + semestre.getSemestre() + "");
                    }catch(Exception e){
                        usrModel.setSemestre("");
                        //LOG.info("no se puede poner el semestre");
                    }

                    try {
                        usrModel.setPlanid(alumno.getPlanes().getPlanid());
                    }catch(Exception e){
                        usrModel.setPlanid(100);
                        //LOG.info("no se puede poner el planid");
                    }
                }

                // Creamos la sesión
                Sesion element = new Sesion();

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                String strDate = dateFormat.format(date); //2016/11/16 12:08:43

                element.setToken(tokenModel.getToken().substring(7)); // Se guarda el token a partir del séptimo caracter, quitándose el "Bearer "
                element.setUsuario(usuario);
                element.setFechainicio(strDate);

                try {
                    // Revisando si el usuario tiene sesiones activas
                    List<Sesion> sesionesUsuario = sesionService.getSessionByUserId(usuario.getUsuarioid());

                    if(sesionesUsuario.size() > 0) {
                        // Borramos sesiones previas del usuario...
                        sesionService.removeSessionByUserId(usuario.getUsuarioid());
                    }
                }catch(Exception e){
                    // No hay sesiones activas del usuario
                }

                sesionService.addSession(element);
            } else {
                // La contrasena está mal
                UsuariosModel model = new UsuariosModel();
                model.setError(1); // Password incorrecto
                return model;
            }
        } else {
            // El usuario no existe
            UsuariosModel model = new UsuariosModel();
            model.setError(2);
            return model;
        }

        return usrModel;
    }// login

    @CrossOrigin
    @RequestMapping(value = "/getToken", method = RequestMethod.POST)
    public String getToken(@RequestParam("cuenta") String cuenta) {

        //LOG.info("En getToken con: " + cuenta);

        String token = "";
        String username = "general@arqibero.edu";

        TokenModel tokenModel = getJWTToken(cuenta);

        Usuarios usuario = null; //usuariosService.getUserByEmail(username);

        Sesion element = new Sesion();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String strDate = dateFormat.format(date); //2016/11/16 12:08:43

        element.setToken(tokenModel.getToken().substring(7)); // Se guarda el token a partir del séptimo caracter, quitándose el "Bearer "
        element.setUsuario(usuario);
        element.setFechainicio(strDate);

        sesionService.addSession(element);

        token = element.getToken();

        //LOG.info("Regresamos: " + token);

        return token;
    }// getAllUsers

    private TokenModel getJWTToken(String username) {
        TokenModel tokenModel = new TokenModel();
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("gtsfJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 6000000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        tokenModel.token = "Bearer " + token;
        tokenModel.expiresin = 7200;

        return tokenModel;
    }// TokenModel

    //----------------------------------------------
    //
    //  USUARIOS
    //
    //----------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/{auth}", method = RequestMethod.GET)
    public List<UsuariosModel> getAllUsers(@PathVariable("auth") String token) {
        List<UsuariosModel> userResult = new ArrayList<UsuariosModel>();

        boolean validSession = sesionService.validSession(token);

        if (validSession) {
            userResult = usuariosService.listAllUsersByType(1); // tipoid = 4 son los usuarios que contestan encuestas
        } else {
            UsuariosModel user = new UsuariosModel();
            userResult.add(user);
        }

        return userResult;
    }// getAllUsers

    // GET User -- Get user by id
    @CrossOrigin
    @RequestMapping(value = "/getById/{id}/{auth}", method = RequestMethod.GET)
    public UsuariosModel getUserById(@PathVariable("id") int id, @PathVariable("auth") String token) {
        UsuariosModel usrModel = null;
        Usuarios usuario = null;

        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {
            usuario = usuariosService.getUserById(id);

            if (usuario != null) {
                usrModel = usuariosConverter.convertUsuariosToUsuariosModel(usuario);
            } else {
                usrModel = new UsuariosModel();
            }
        } else {
            usrModel = new UsuariosModel();
            usrModel.setError(1); // Error 1 es sesión no válida
        }
        return usrModel;
    } // getUserById

    // GET User -- Get user by email
    //@CrossOrigin(origins = "http://localhost:8080")
    @CrossOrigin
    @RequestMapping(value = "/getByEmail/{email}/{auth}", method = RequestMethod.GET)
    public UsuariosModel getUserByEmail(@PathVariable("email") String email, @PathVariable("auth") String token) {
        Usuarios usuario = null;
        UsuariosModel usrModel = null;

        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {
            usuario = usuariosService.getUserByEmail(email);

            if (usuario != null) {
                usrModel = usuariosConverter.convertUsuariosToUsuariosModel(usuario);

            } else {
                usrModel = new UsuariosModel();
                usrModel.setError(2); // El usuario no existe
                return usrModel;

            }
        } else {
            usrModel = new UsuariosModel();
            usrModel.setError(1); // Error 1 es sesión no válida

        }
        return usrModel;
    } // getUserByEmail

    // PUT User - MODIFICAR DATOS GENERALES DEL USUARIO
    //@CrossOrigin(origins = "http://localhost:8080")
    @CrossOrigin
    @RequestMapping(value = "/{id}/{auth}", method = RequestMethod.POST)
    public UsuariosModel modifyUserById(@PathVariable("id") int id, @PathVariable("auth") String token, @RequestBody UsuariosModel userModel) {
        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {

            // Obtenemos el password del usuario almacenado
            Usuarios savedUser = usuariosService.getUserByEmail(userModel.getEmail());
            if(savedUser != null) {
                userModel.setPassword(savedUser.getPassword());

                UsuariosModel model = usuariosService.updateUsuario(userModel);

                return model;
            }
            else{
                return null;
            }
        }
        return null;
    } // modifyUserById

    // PUT User - MODIFICAR PASSWORD DEL USUARIO
    //@CrossOrigin(origins = "http://localhost:8080")
    @CrossOrigin
    @RequestMapping(value = "/updateUserPassword/{id}/{auth}", method = RequestMethod.POST)
    public UsuariosModel modifyUserPassword(@PathVariable("id") int id, @PathVariable("auth") String token, @RequestBody UserPasswordModel userPassModel) {
        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {
            // Obtenemos la información del usuario almacenado
            Usuarios savedUser = usuariosService.getUserById(id);

            String passEncrypt = passwordEncrypt.getMD5(userPassModel.getPassword());

            savedUser.setPassword(passEncrypt);
            UsuariosModel usrModel = usuariosConverter.convertUsuariosToUsuariosModel(savedUser);

            usrModel = usuariosService.updateUsuario(usrModel);

            return usrModel;
        }
        return null;
    } // modifyUserPassword

    // POST User -- save new user
    //@CrossOrigin(origins = "http://localhost:8080")
    @CrossOrigin
    @RequestMapping(value = "/{auth}", consumes = "application/json", method = RequestMethod.POST)
    public UsuariosModel createUser(@PathVariable("auth") String token, @RequestBody UsuariosModel element) {
        UsuariosModel usrModel = null;
        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {

            // Validamos que el usuario no exista ya en la base de datos
            Usuarios savedUser = usuariosService.getUserByEmail(element.getEmail());
            if(savedUser != null){
                return null;
            }
            else {
                String passEncrypt = passwordEncrypt.getMD5(element.getPassword());
                element.setPassword(passEncrypt);
                usrModel = usuariosService.addUsuarios(element);
            }
        } else {
            usrModel = new UsuariosModel();
            usrModel.setError(1); // Error 1 es sesión no válida
        }
        return usrModel;
    } // createUser

    // DELETE user
    //@CrossOrigin(origins = "http://localhost:8080")
    @CrossOrigin
    @RequestMapping(value = "/deleteUser/{usuarioid}/{auth}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("usuarioid") int usuarioid, @PathVariable("auth") String token) {
        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {
            usuariosService.removeUsuario(usuarioid);
        }
    } // deleteUser


    // GET Fecha - getFecha
    @CrossOrigin
    @RequestMapping(value = "/getDate/{auth}", method = RequestMethod.GET)
    public FechaModel getDate(@PathVariable("auth") String token) {
        FechaModel fecha = new FechaModel();

        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {

            fecha.setDate(currentDateGenerator.generateCurrentDateWithoutTime());
        }

        return fecha;
    } // getDate


    // PUT User - OBTIENE LA INFORMACIÓN DEL ALUMNO
    @CrossOrigin
    @RequestMapping(value = "/getStudentInfo/{auth}", method = RequestMethod.POST)
    public AlumnosModel getStudentInfo(@PathVariable("auth") String token, @RequestBody AlumnosModel alumnosModel) {
        boolean validSession = sesionService.validSession(token);

        //LOG.info("En getStudentInfo con token: " + token);
        //LOG.info("Recibimos: " + alumnosModel.toString());

        if (validSession == true) {

            //LOG.info("En getStudentInfo con: " + alumnosModel.toString() + " es lo que recibimos");

            alumnosModel = alumnosService.getStudentInfo(alumnosModel);

            return alumnosModel;
        }
        else {
            //LOG.info("En el else y regresamos null");
            return null;
        }
    } // getStudentInfo

    // PUT User - ACTUALIZA LOS SEMESTRES DEL ALUMNO
    @CrossOrigin
    @RequestMapping(value = "/updateSemester/{auth}", method = RequestMethod.POST)
    public AlumnosModel updateSemester(@PathVariable("auth") String token, @RequestBody AlumnosModel alumnosModel) {
        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {

            //LOG.info("En updateSemestre con: " + alumnosModel.toString());

            alumnosModel = alumnosService.updateSemestre(alumnosModel);

            //LOG.info("Regresamos: " + alumnosModel.toString());

            return alumnosModel;
        }
        return new AlumnosModel();
    } // getStudentInfo

    // PUT User - ACTUALIZA EL PRIMER SEMESTRE DEL ALUMNO
    @CrossOrigin
    @RequestMapping(value = "/updateFirstSemester/{auth}", method = RequestMethod.POST)
    public AlumnosSemestresModel updateFirstSemester(@PathVariable("auth") String token, @RequestBody AlumnosSemestresModel alumnosModel) {
        boolean validSession = sesionService.validSession(token);

        if (validSession == true) {

            //LOG.info("En updateFirstSemester con: " + alumnosModel.toString() + " es lo que recibimos");

            alumnosModel = alumnosService.updateFirstSemester(alumnosModel);

            return alumnosModel;
        }
        return new AlumnosSemestresModel();
    } // getStudentInfo

}// UsuariosController
