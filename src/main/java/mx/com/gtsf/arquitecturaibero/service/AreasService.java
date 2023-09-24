package mx.com.gtsf.arquitecturaibero.service;

import mx.com.gtsf.arquitecturaibero.entity.Areas;
import mx.com.gtsf.arquitecturaibero.model.AreasModel;

import java.util.List;

public interface AreasService {

    public abstract List<AreasModel> getAllAreas();

    public abstract AreasModel addArea(AreasModel model);
    public abstract int removeArea(long areaid);

    public abstract Areas getAreaById(long areaid);
}
